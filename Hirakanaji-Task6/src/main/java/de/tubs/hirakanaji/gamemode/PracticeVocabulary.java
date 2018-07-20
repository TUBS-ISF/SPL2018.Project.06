package de.tubs.hirakanaji.gamemode;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static de.tubs.hirakanaji.vocabulary.Unit1.unit1Vocabulary;
import static de.tubs.hirakanaji.vocabulary.Unit2.unit2Vocabulary;

public class PracticeVocabulary {

    private static int rounds;

//    declare precedence: HirakanajiApplication, PracticeVocabulary;
//
//    after(): execution(void HirakanajiApplication.main()) {
//        startPracticeVocabulary();
//    }

    private PracticeVocabulary() {

    }

    public static void startPracticeVocabulary() {
        String[][] dataSet;

        System.out.println("How many rounds?");
        rounds = Integer.parseInt(getUserInput());

        System.out.println("Choose unit: Unit 1 | Unit 2");
        String input = getUserInput();

        if ("Unit 1".equalsIgnoreCase(input)) {
            /* Unit 1 */
            dataSet = getDataSet(unit1Vocabulary);
            startGame(dataSet);

        } else {
            /* Unit 2 */
            dataSet = getDataSet(unit2Vocabulary);
            startGame(dataSet);
        }
    }

    private static String[][] getDataSet(String[][] unitVocabulary) {
        return Stream.of(new String[0][0], unitVocabulary).flatMap(Stream::of).toArray(String[][]::new);
    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static void startGame(String[][] dataSet) {
        for (int round = 0; round <= rounds; round++) {
            int row = ThreadLocalRandom.current().nextInt(0, dataSet.length);
            int col = ThreadLocalRandom.current().nextInt(0, dataSet[row].length);
            int solutionCol;

            if (col == 1) {
                System.out.println("Translate the following word into Rōmaji");
                solutionCol = 0;

            } else {
                System.out.println("Translate the following word into English");
                solutionCol = 1;

            }

            System.out.println(dataSet[row][col]);
            String input = getUserInput();

            if (dataSet[row][solutionCol].equalsIgnoreCase(input)) {
                System.out.println("Correct!");
            }  else {
                System.out.println("Wrong! It's " + dataSet[row][solutionCol]);
            }
        }
    }
}