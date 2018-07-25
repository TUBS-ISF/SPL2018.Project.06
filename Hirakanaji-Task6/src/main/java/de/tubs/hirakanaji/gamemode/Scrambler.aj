package de.tubs.hirakanaji.gamemode;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static de.tubs.hirakanaji.HirakanajiApplication.exportText;
import static de.tubs.hirakanaji.HirakanajiApplication.gameModes;
import static de.tubs.hirakanaji.HirakanajiApplication.userInput;
import static de.tubs.hirakanaji.syllabary.Hiragana.hiraganaYouonDakuten;
import static de.tubs.hirakanaji.syllabary.Katakana.katakanaYouonDakuten;
import static de.tubs.hirakanaji.syllabary.Romaji.romajiYouonDakuten;

public aspect Scrambler {

    public static String[][] dataSet;
    private static int lineCount = 20;
    public static String syllabaries;
    public static String inputSyllabary;

    before(): call(void de.tubs.hirakanaji.HirakanajiApplication.main()) {
        gameModes += " " + getClass().getName();
    }

    after(): call(String de.tubs.hirakanaji.HirakanajiApplication.getUserInput()) {
        if (getClass().getName().equalsIgnoreCase(userInput)) {
            exportText = startScrambler();
        }
    }

    private Scrambler() {

    }

    public static String startScrambler() {

        System.out.println("Choose amount of lines to print.");
        String inputLines = getUserInput();
        if (inputLines.matches("[\\d]*")) {
           lineCount = Integer.parseInt(inputLines);
        }

        System.out.println("Choose syllabary:" + syllabaries);
        inputSyllabary = getUserInput();

        return printSyllables(dataSet);
    }

    private static String printSyllables(String[][] dataSet) {
        int minSyllableCount = 2;
        int maxSyllableCount = 5;

        int syllable;

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

    public static String[][] getDataSet(String[][] chars, String[][] gojuuon, String[][] gojuuonDakuten,
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

}
