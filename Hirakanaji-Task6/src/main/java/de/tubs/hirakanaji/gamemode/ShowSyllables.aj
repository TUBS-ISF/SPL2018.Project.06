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

    public static String startShowSyllables() {
        String[][] dataSet;

        System.out.println("Choose syllabary: Hiragana | Katakana | Romaji");
        String input = getUserInput();

        if ("Hiragana".equalsIgnoreCase(input)) {
            /* Hiragana */
            dataSet = getDataSet(hiraganaChars, hiraganaGojuuon, hiraganaGojuuonDakuten, hiraganaYouon, hiraganaYouonDakuten);
            return printSyllables(dataSet);
        } else if ("Katakana".equalsIgnoreCase(input)) {
            /* Katakana */
            dataSet = getDataSet(katakanaChars, katakanaGojuuon, katakanaGojuuonDakuten, katakanaYouon, katakanaYouonDakuten);
            return printSyllables(dataSet);
        } else {
            /* Romaji */
            dataSet = getDataSet(romajiChars, romajiGojuuon, romajiGojuuonDakuten, romajiYouon, romajiYouonDakuten);
            return printSyllables(dataSet);
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

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static String printSyllables(String[][] dataSet) {
        StringBuilder results = new StringBuilder();

        for (String[] aDataSet : dataSet) {
            for (String anADataSet : aDataSet) {
                System.out.print(anADataSet);
                results.append(anADataSet + "\\n");
            }
            System.out.println();
        }

        return results.toString();
    }
}
