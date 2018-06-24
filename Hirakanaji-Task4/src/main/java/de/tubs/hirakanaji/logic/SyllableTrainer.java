package de.tubs.hirakanaji.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static de.tubs.hirakanaji.core.HiraganaDataSet.*;
import static de.tubs.hirakanaji.core.HiraganaDataSet.hiraganaYouonDakuten;
import static de.tubs.hirakanaji.core.KatakanaDataSet.*;
import static de.tubs.hirakanaji.core.KatakanaDataSet.katakanaYouonDakuten;
import static de.tubs.hirakanaji.core.RomajiDataSet.*;

public class SyllableTrainer {

    private static Logger logger = LoggerFactory.getLogger("Hirakanaji-SyllableTrainer");

    public static void startSyllableTrainer() {
        String[][] dataSet;

        // Hiragana
        dataSet = getDataSet(hiraganaChars, hiraganaGojuuon, hiraganaGojuuonDakuten, hiraganaYouon, hiraganaYouonDakuten);
        askQuestions(dataSet);

        // Katakana
        dataSet = getDataSet(katakanaChars, katakanaGojuuon, katakanaGojuuonDakuten, katakanaYouon, katakanaYouonDakuten);
        askQuestions(dataSet);
    }

    private static String[][] getDataSet(String[][] chars, String[][] gojuuon, String[][] gojuuonDakuten,
                                         String[][] youon, String[][] youonDakuten) {
        String[][] dataSet;
        dataSet = Stream.of(chars)
                .flatMap(Stream::of).toArray(String[][]::new);

        dataSet = Stream.of(dataSet, gojuuon)
                .flatMap(Stream::of).toArray(String[][]::new);

        dataSet = Stream.of(dataSet, gojuuonDakuten)
                .flatMap(Stream::of).toArray(String[][]::new);

        dataSet = Stream.of(dataSet, youon)
                .flatMap(Stream::of).toArray(String[][]::new);

        dataSet = Stream.of(dataSet, youonDakuten)
                .flatMap(Stream::of).toArray(String[][]::new);
        return dataSet;
    }

    private static void askQuestions(String[][] dataSet) {
        int rounds = 10;
        String[][] romajiDataSet = getDataSet(romajiChars, romajiGojuuon, romajiGojuuonDakuten, romajiYouon, romajiYouonDakuten);

        for (int round = 0; round <= rounds; round++) {
            int row = ThreadLocalRandom.current().nextInt(0, dataSet.length);
            int col = ThreadLocalRandom.current().nextInt(0, dataSet[row].length);

            logger.info("Which romaji syllable is this one?");
            logger.info(dataSet[row][col]);
            String input = getUserInput();
            int[] romajiIndex = searchForSyllable(input);
            if (romajiIndex.length == 0) {
                logger.info("Romaji syllable not found. Correct answer was {}.", romajiDataSet[row][col]);
            }  else if (romajiIndex[0] == row && romajiIndex[1] == col) {
                logger.info("Correct!");
            } else {
                logger.info("Wrong! It's {}.", romajiDataSet[row][col]);
            }
        }
    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static int[] searchForSyllable(String input) {
        String[][] romajiDataSet = getDataSet(romajiChars, romajiGojuuon, romajiGojuuonDakuten, romajiYouon, romajiYouonDakuten);

        for (int row = 0; row < romajiDataSet.length; row++) {
            for (int col = 0; col < romajiDataSet[row].length; col++) {
                if (romajiDataSet[row][col].equals(input)) {
                    return new int[]{row, col};
                }
            }
        }
        return new int[]{};
    }

}
