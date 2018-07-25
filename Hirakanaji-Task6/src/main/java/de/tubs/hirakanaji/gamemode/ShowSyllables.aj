package de.tubs.hirakanaji.gamemode;

import java.util.Scanner;
import java.util.stream.Stream;

import static de.tubs.hirakanaji.HirakanajiApplication.exportText;
import static de.tubs.hirakanaji.HirakanajiApplication.gameModes;
import static de.tubs.hirakanaji.HirakanajiApplication.userInput;

public aspect ShowSyllables {

    public static String[][] dataSet;
    public static String syllabaries;
    public static String inputSyllabary;

    before(): execution(void HirakanajiApplication.main()) {
        gameModes += " " + getClass().getName();
    }

    after(): call(String de.tubs.hirakanaji.HirakanajiApplication.getUserInput()) {
        if (getClass().getName().equalsIgnoreCase(userInput)) {
            exportText = startShowSyllables();
        }
    }

    private ShowSyllables() {

    }

    public static String startShowSyllables() {
        System.out.println("Choose syllabary:" + syllabaries);
        inputSyllabary = getUserInput();

        return printSyllables(dataSet);
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
}
