package de.tubs.hirakanaji;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static de.tubs.hirakanaji.core.RomajiDataSet.*;
import static de.tubs.hirakanaji.core.HiraganaDataSet.*;
import static de.tubs.hirakanaji.core.KatakanaDataSet.*;

/**
 * @author lisa-rosenberg
 * @since 13.05.2018
 */
public class HirakanajiApplication {

    private static Logger logger = LoggerFactory.getLogger("Hirakanaji");

    private static List<String> properties;

    public static void main(String[] args) {
        properties = Arrays.asList(args);

        /* Learn Syllables */
        startSyllableTrainer();

        /* Scrambler */
        startScrambler();
    }

    private static void startScrambler() {
        String[][] dataSet;
        // Romaji
        dataSet = getDataSet(romajiChars, romajiGojuuon, romajiGojuuonDakuten, romajiYouon, romajiYouonDakuten);
        printSyllables(dataSet);

        // Hiragana
        dataSet = getDataSet(hiraganaChars, hiraganaGojuuon, hiraganaGojuuonDakuten, hiraganaYouon, hiraganaYouonDakuten);
        printSyllables(dataSet);

        // Katakana
        dataSet = getDataSet(katakanaChars, katakanaGojuuon, katakanaGojuuonDakuten, katakanaYouon, katakanaYouonDakuten);
        printSyllables(dataSet);
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

    public static List<String> getProperties() {
        return properties;
    }

    private static void printSyllables(String[][] dataSet) {
        int minSyllableCount = 2;   // Min. number of syllables per line (e.g. "ba ka")
        int maxSyllableCount = 5;   // Max. number of syllables per line (e.g. "ha hi fu he ho")
        int wordCount = 20;         // Amount of generated lines
        int syllable;               // Variable syllable of dataSet

        ThreadLocalRandom random = ThreadLocalRandom.current();

        for (int i = 0; i < wordCount; i++) {
            StringBuilder line = new StringBuilder(maxSyllableCount);
            for (int j = 0; j < random.nextInt(minSyllableCount, maxSyllableCount + 1); j++) {
                line.append(dataSet[syllable = random.nextInt(0, dataSet.length)]
                        [random.nextInt(0, dataSet[syllable].length)]);
            }
            logger.info(line.toString());
        }
    }

    private static void startSyllableTrainer() {
        String[][] dataSet;

        // Hiragana
        dataSet = getDataSet(hiraganaChars, hiraganaGojuuon, hiraganaGojuuonDakuten, hiraganaYouon, hiraganaYouonDakuten);
        askQuestions(dataSet);

        // Katakana
        dataSet = getDataSet(katakanaChars, katakanaGojuuon, katakanaGojuuonDakuten, katakanaYouon, katakanaYouonDakuten);
        askQuestions(dataSet);
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
