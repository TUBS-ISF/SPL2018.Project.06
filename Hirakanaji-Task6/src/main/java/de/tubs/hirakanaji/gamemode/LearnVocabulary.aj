package de.tubs.hirakanaji.gamemode;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static de.tubs.hirakanaji.HirakanajiApplication.exportText;
import static de.tubs.hirakanaji.HirakanajiApplication.gameModes;
import static de.tubs.hirakanaji.HirakanajiApplication.userInput;
import static de.tubs.hirakanaji.vocabulary.Unit1.unit1Vocabulary;
import static de.tubs.hirakanaji.vocabulary.Unit2.unit2Vocabulary;

public aspect LearnVocabulary {

    private static int rounds;
    public static String units;
    public static String inputUnit;
    public static String[][] dataSet;

    before(): call(void de.tubs.hirakanaji.HirakanajiApplication.main()) {
        gameModes += " " + getClass().getName();
    }

    after(): call(String de.tubs.hirakanaji.HirakanajiApplication.getUserInput()) {
        if (getClass().getName().equalsIgnoreCase(userInput)) {
            exportText = startLearnVocabulary();
        }
    }

    private LearnVocabulary() {

    }

    public static String startLearnVocabulary() {
        System.out.println("How many rounds?");
        rounds = Integer.parseInt(getUserInput());

        System.out.println("Choose unit:" + units);
        inputUnit = getUserInput();

        return startGame(dataSet);
    }

    public static String[][] getDataSet(String[][] unitVocabulary) {
        return Stream.of(new String[0][0], unitVocabulary).flatMap(Stream::of).toArray(String[][]::new);
    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static String startGame(String[][] dataSet) {
        StringBuilder results = new StringBuilder();

        for (int round = 0; round <= rounds; round++) {
            Scanner input = new Scanner(System.in);

            int row = ThreadLocalRandom.current().nextInt(0, dataSet.length);
            System.out.println(dataSet[row][0] + " | " + dataSet[row][1] +  " | " + dataSet[row][2]);
            results.append(dataSet[row][0] + " | " + dataSet[row][1] +  " | " + dataSet[row][2] + "\\n");

            System.out.println("Press Enter to continue.");
            input.nextLine();
        }

        return results.toString();
    }

}
