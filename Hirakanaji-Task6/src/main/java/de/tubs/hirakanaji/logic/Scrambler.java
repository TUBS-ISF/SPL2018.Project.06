package de.tubs.hirakanaji.logic;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static de.tubs.hirakanaji.core.HiraganaDataSet.*;
import static de.tubs.hirakanaji.core.HiraganaDataSet.hiraganaYouonDakuten;
import static de.tubs.hirakanaji.core.KatakanaDataSet.*;
import static de.tubs.hirakanaji.core.KatakanaDataSet.katakanaYouonDakuten;
import static de.tubs.hirakanaji.core.RomajiDataSet.*;
import static de.tubs.hirakanaji.core.RomajiDataSet.romajiYouonDakuten;

public class Scrambler {

    private static int lineCount = 20; // Amount of generated lines

    public static void startScrambler() {
        String[][] dataSet;

        System.out.println("Choose amount of lines to print.");
        String input = getUserInput();
        if (input.matches("[\\d]*")) {
           lineCount = Integer.parseInt(input);
        }

        System.out.println("Choose syllabary: Hiragana | Katakana | Romaji");
        input = getUserInput();

        switch (input) {
            case "Hiragana":
                // Hiragana
                dataSet = getDataSet(hiraganaChars, hiraganaGojuuon, hiraganaGojuuonDakuten, hiraganaYouon, hiraganaYouonDakuten);
                printSyllables(dataSet);
                break;
            case "Katakana":
                // Katakana
                dataSet = getDataSet(katakanaChars, katakanaGojuuon, katakanaGojuuonDakuten, katakanaYouon, katakanaYouonDakuten);
                printSyllables(dataSet);
                break;
            default:
                // Romaji
                dataSet = getDataSet(romajiChars, romajiGojuuon, romajiGojuuonDakuten, romajiYouon, romajiYouonDakuten);
                printSyllables(dataSet);
                break;
        }
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

    private static void printSyllables(String[][] dataSet) {
        int minSyllableCount = 2;   // Min. number of syllables per line (e.g. "ba ka")
        int maxSyllableCount = 5;   // Max. number of syllables per line (e.g. "ha hi fu he ho")

        int syllable;               // Variable syllable of dataSet

        ThreadLocalRandom random = ThreadLocalRandom.current();

        for (int i = 0; i < lineCount; i++) {
            StringBuilder line = new StringBuilder(maxSyllableCount);
            for (int j = 0; j < random.nextInt(minSyllableCount, maxSyllableCount + 1); j++) {
                line.append(dataSet[syllable = random.nextInt(0, dataSet.length)]
                        [random.nextInt(0, dataSet[syllable].length)]);
            }
            System.out.println(line.toString());
        }
    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
