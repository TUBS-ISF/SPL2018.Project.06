package de.tubs.hirakanaji.gamemode;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static de.tubs.hirakanaji.syllabary.HiraganaDataSet.*;
import static de.tubs.hirakanaji.syllabary.HiraganaDataSet.hiraganaYouonDakuten;
import static de.tubs.hirakanaji.syllabary.KatakanaDataSet.*;
import static de.tubs.hirakanaji.syllabary.KatakanaDataSet.katakanaYouonDakuten;
import static de.tubs.hirakanaji.syllabary.RomajiDataSet.*;

public class SyllableTrainer {

//    declare precedence: HirakanajiApplication, SyllableTrainer;
//
//    after(): execution(void HirakanajiApplication.main()) {
//        startSyllableTrainer();
//    }

    private SyllableTrainer() {

    }

    public static String startSyllableTrainer() {
        String[][] dataSet;

        System.out.println("Choose syllabary: Hiragana | Katakana");
        String input = getUserInput();

        if ("Hiragana".equalsIgnoreCase(input)) {
            /* Hiragana */
            dataSet = getDataSet(hiraganaChars, hiraganaGojuuon, hiraganaGojuuonDakuten, hiraganaYouon, hiraganaYouonDakuten);
            return askQuestions(dataSet);

        } else {
            /* Katakana */
            dataSet = getDataSet(katakanaChars, katakanaGojuuon, katakanaGojuuonDakuten, katakanaYouon, katakanaYouonDakuten);
            return askQuestions(dataSet);
        }

    }

    private static String[][] getDataSet(String[][] chars, String[][] gojuuon, String[][] gojuuonDakuten,
                                         String[][] youon, String[][] youonDakuten) {
        System.out.println("Choose one or more sets (separator = ','): Gojuuon | Gojuuon with Dakuten | Youon | Youon with Dakuten");
        String inputSet = getUserInput();
        String[] inputSets = inputSet.split(",");

        String[][] dataSet;
        dataSet = Stream.of(chars)
                .flatMap(Stream::of).toArray(String[][]::new);

        for (String s : inputSets) {
            if (s.equalsIgnoreCase("Gojuuon")) {
                dataSet = Stream.of(dataSet, gojuuon)
                        .flatMap(Stream::of).toArray(String[][]::new);
            } else if (s.equalsIgnoreCase("Gojuuon with Dakuten")) {
                dataSet = Stream.of(dataSet, gojuuonDakuten)
                        .flatMap(Stream::of).toArray(String[][]::new);
            }  else if (s.equalsIgnoreCase("Youon")) {
                dataSet = Stream.of(dataSet, youon)
                        .flatMap(Stream::of).toArray(String[][]::new);
            }  else if (s.equalsIgnoreCase("Youon with Dakuten")) {
                dataSet = Stream.of(dataSet, youonDakuten)
                        .flatMap(Stream::of).toArray(String[][]::new);
            }
        }

        return dataSet;
    }

    private static String askQuestions(String[][] dataSet) {
        StringBuilder results = new StringBuilder();

        int rounds = 10;
        String[][] romajiDataSet = getDataSet(romajiChars, romajiGojuuon, romajiGojuuonDakuten, romajiYouon, romajiYouonDakuten);

        for (int round = 0; round <= rounds; round++) {
            int row = ThreadLocalRandom.current().nextInt(0, dataSet.length);
            int col = ThreadLocalRandom.current().nextInt(0, dataSet[row].length);

            System.out.println("Which romaji syllable is this one?");
            results.append("Which romaji syllable is this one? \\n");
            System.out.println(dataSet[row][col]);
            results.append(dataSet[row][col] + "\\n");
            String input = getUserInput();

            int[] romajiIndex = searchForSyllable(input);
            if (romajiIndex[0] == row && romajiIndex[1] == col) {
                System.out.println("Correct!");
                results.append("Correct! \\n");
            }  else {
                System.out.println("Wrong! It's " + romajiDataSet[row][col]);
                results.append("Wrong! It's " + romajiDataSet[row][col] + "\\n");
            }
        }

        return results.toString();
    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static int[] searchForSyllable(String input) {
        String[][] romajiDataSet = getDataSet(romajiChars, romajiGojuuon, romajiGojuuonDakuten, romajiYouon, romajiYouonDakuten);

        for (int row = 0; row < romajiDataSet.length; row++) {
            for (int col = 0; col < romajiDataSet[row].length; col++) {
                if (romajiDataSet[row][col].equalsIgnoreCase(input)) {
                    return new int[]{row, col};
                }
            }
        }

        return new int[]{};
    }

}
