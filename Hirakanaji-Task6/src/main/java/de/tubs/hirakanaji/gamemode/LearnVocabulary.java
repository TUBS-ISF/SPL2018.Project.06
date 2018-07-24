package de.tubs.hirakanaji.gamemode;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static de.tubs.hirakanaji.vocabulary.Unit1.unit1Vocabulary;
import static de.tubs.hirakanaji.vocabulary.Unit2.unit2Vocabulary;

public class LearnVocabulary {

    private static int rounds;

    private LearnVocabulary() {

    }

    public static String startLearnVocabulary() {
        String[][] dataSet;

        System.out.println("How many rounds?");
        rounds = Integer.parseInt(getUserInput());

        System.out.println("Choose unit: Unit 1 | Unit 2");
        String input = getUserInput();

        if ("Unit 1".equalsIgnoreCase(input)) {
            /* Unit 1 */
            dataSet = getDataSet(unit1Vocabulary);
            return startGame(dataSet);

        } else {
            /* Unit 2 */
            dataSet = getDataSet(unit2Vocabulary);
            return startGame(dataSet);
        }
    }

    private static String[][] getDataSet(String[][] unitVocabulary) {
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
