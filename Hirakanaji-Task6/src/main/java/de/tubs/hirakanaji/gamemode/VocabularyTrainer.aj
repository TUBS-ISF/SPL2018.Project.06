package de.tubs.hirakanaji.gamemode;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static de.tubs.hirakanaji.vocabulary.Unit1.unit1Vocabulary;
import static de.tubs.hirakanaji.vocabulary.Unit2.unit2Vocabulary;

public aspect VocabularyTrainer {

    static int rounds;

    declare precedence: HirakanajiApplication, VocabularyTrainer;

    after(): execution(void HirakanajiApplication.main()) {
        startVocabularyTrainer();
    }

    private VocabularyTrainer() {

    }

    public static void startVocabularyTrainer() {
        String[][] dataSet;

        System.out.println("How many rounds?");
        rounds = Integer.parseInt(getUserInput());

        System.out.println("Choose unit: Unit 1 | Unit 2");
        String input = getUserInput();

        if ("Unit 1".equals(input)) {
            /* Unit 1 */
            dataSet = getDataSet(unit1Vocabulary);
            askQuestions(dataSet);

        } else {
            /* Unit 2 */
            dataSet = getDataSet(unit2Vocabulary);
            askQuestions(dataSet);
        }
    }

    private static String[][] getDataSet(String[][] unitVocabulary) {
        return Stream.of(new String[0][0], unitVocabulary).flatMap(Stream::of).toArray(String[][]::new);
    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static void askQuestions(String[][] dataSet) {

        for (int round = 0; round <= rounds; round++) {
            int row = ThreadLocalRandom.current().nextInt(0, dataSet.length);
            int col = ThreadLocalRandom.current().nextInt(0, dataSet[row].length);
            int solutionCol;

            switch (col) {
                case 1:
                    System.out.println("Translate the following word into Rōmaji");
                    solutionCol = 0;
                    break;
                default:
                    System.out.println("Translate the following word into English");
                    solutionCol = 1;
                    break;
            }

            System.out.println(dataSet[row][col]);
            String input = getUserInput();

            if (dataSet[row][solutionCol].equals(input)) {
                System.out.println("Correct!");
            }  else {
                System.out.println("Wrong! It's " + dataSet[row][solutionCol]);
            }
        }
    }
}
