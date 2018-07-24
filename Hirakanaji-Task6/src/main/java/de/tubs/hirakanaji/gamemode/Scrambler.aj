package de.tubs.hirakanaji.gamemode;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static de.tubs.hirakanaji.syllabary.HiraganaDataSet.*;
import static de.tubs.hirakanaji.syllabary.HiraganaDataSet.hiraganaYouonDakuten;
import static de.tubs.hirakanaji.syllabary.KatakanaDataSet.*;
import static de.tubs.hirakanaji.syllabary.KatakanaDataSet.katakanaYouonDakuten;
import static de.tubs.hirakanaji.syllabary.RomajiDataSet.*;
import static de.tubs.hirakanaji.syllabary.RomajiDataSet.romajiYouonDakuten;

public aspect Scrambler {

    declare precedence: HirakanajiApplication, Scrambler;

    after(): execution(void HirakanajiApplication.main()) {
        startScrambler();
    }

    private Scrambler() {

    }

    private static int lineCount = 20; // Amount of generated lines

    public static String startScrambler() {
        String[][] dataSet;

        System.out.println("Choose amount of lines to print.");
        String inputLines = getUserInput();
        if (inputLines.matches("[\\d]*")) {
           lineCount = Integer.parseInt(inputLines);
        }

        System.out.println("Choose syllabary: Hiragana | Katakana | Romaji");
        String inputSyllabary = getUserInput();

        switch (inputSyllabary) {
            case "Hiragana":
                // Hiragana
                dataSet = getDataSet(hiraganaChars, hiraganaGojuuon, hiraganaGojuuonDakuten, hiraganaYouon, hiraganaYouonDakuten);
                return printSyllables(dataSet);
            case "Katakana":
                // Katakana
                dataSet = getDataSet(katakanaChars, katakanaGojuuon, katakanaGojuuonDakuten, katakanaYouon, katakanaYouonDakuten);
                return printSyllables(dataSet);
            default:
                // Romaji
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

    private static String printSyllables(String[][] dataSet) {
        int minSyllableCount = 2;   // Min. number of syllables per line (e.g. "ba ka")
        int maxSyllableCount = 5;   // Max. number of syllables per line (e.g. "ha hi fu he ho")

        int syllable;               // Variable syllable of dataSet

        StringBuilder results = new StringBuilder();

        ThreadLocalRandom random = ThreadLocalRandom.current();

        for (int i = 0; i < lineCount; i++) {
            StringBuilder line = new StringBuilder(maxSyllableCount);
            for (int j = 0; j < random.nextInt(minSyllableCount, maxSyllableCount + 1); j++) {
                line.append(dataSet[syllable = random.nextInt(0, dataSet.length)]
                        [random.nextInt(0, dataSet[syllable].length)]);
            }
            System.out.println(line.toString());
            results.append(line.toString() + "\\n");
        }

        return results.toString();
    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
