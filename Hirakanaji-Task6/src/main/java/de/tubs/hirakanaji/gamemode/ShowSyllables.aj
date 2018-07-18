package de.tubs.hirakanaji.gamemode;

import java.util.Scanner;
import java.util.stream.Stream;

import static de.tubs.hirakanaji.syllabary.HiraganaDataSet.*;
import static de.tubs.hirakanaji.syllabary.KatakanaDataSet.*;
import static de.tubs.hirakanaji.syllabary.RomajiDataSet.*;

public aspect ShowSyllables {

    declare precedence: HirakanajiApplication, ShowSyllables;

    after(): execution(void HirakanajiApplication.main()) {
        startShowSyllables();
    }

    private ShowSyllables() {

    }

    public static void startShowSyllables() {
        String[][] dataSet;

        System.out.println("Choose syllabary: Hiragana | Katakana | Romaji");
        String input = getUserInput();

        if ("Hiragana".equals(input)) {
            /* Hiragana */
            dataSet = getDataSet(hiraganaChars, hiraganaGojuuon, hiraganaGojuuonDakuten, hiraganaYouon, hiraganaYouonDakuten);
            printSyllables(dataSet);
        } else if ("Katakana".equals(input)) {
            /* Katakana */
            dataSet = getDataSet(katakanaChars, katakanaGojuuon, katakanaGojuuonDakuten, katakanaYouon, katakanaYouonDakuten);
            printSyllables(dataSet);
        } else {
            /* Romaji */
            dataSet = getDataSet(romajiChars, romajiGojuuon, romajiGojuuonDakuten, romajiYouon, romajiYouonDakuten);
            printSyllables(dataSet);
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
            if (s.equals("Gojuuon")) {
                dataSet = Stream.of(dataSet, gojuuon)
                        .flatMap(Stream::of).toArray(String[][]::new);
            } else if (s.equals("Gojuuon with Dakuten")) {
                dataSet = Stream.of(dataSet, gojuuonDakuten)
                        .flatMap(Stream::of).toArray(String[][]::new);
            }  else if (s.equals("Youon")) {
                dataSet = Stream.of(dataSet, youon)
                        .flatMap(Stream::of).toArray(String[][]::new);
            }  else if (s.equals("Youon with Dakuten")) {
                dataSet = Stream.of(dataSet, youonDakuten)
                        .flatMap(Stream::of).toArray(String[][]::new);
            }
        }

        return dataSet;
    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static void printSyllables(String[][] dataSet) {
        for (int row = 0; row < dataSet.length; row++) {
            for (int col = 0; col < dataSet[row].length; col++) {
                System.out.print(dataSet[row][col]);
            }
            System.out.println();
        }
    }
}
