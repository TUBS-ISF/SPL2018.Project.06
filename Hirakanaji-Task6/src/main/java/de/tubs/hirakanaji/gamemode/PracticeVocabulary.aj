package de.tubs.hirakanaji.gamemode;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static de.tubs.hirakanaji.vocabulary.Unit1.unit1Vocabulary;
import static de.tubs.hirakanaji.vocabulary.Unit2.unit2Vocabulary;

public aspect PracticeVocabulary {

    declare precedence: HirakanajiApplication, PracticeVocabulary;

    after(): execution(void HirakanajiApplication.main()) {
        startPracticeVocabulary();
    }

    private static int rounds;

    private PracticeVocabulary() {

    }

    public static String startPracticeVocabulary() {
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
            int row = ThreadLocalRandom.current().nextInt(0, dataSet.length);
            int col = ThreadLocalRandom.current().nextInt(0, dataSet[row].length);
            int solutionCol;


            if (col == 1) {
                System.out.println("Translate the following word into Rōmaji");
                results.append("Translate the following word into Rōmaji \\n");
                solutionCol = 0;

            } else {
                System.out.println("Translate the following word into English");
                results.append("Translate the following word into English \\n");
                solutionCol = 1;
            }

            System.out.println(dataSet[row][col]);
            results.append(dataSet[row][col] + "\\n");
            String input = getUserInput();

            if (dataSet[row][solutionCol].equalsIgnoreCase(input)) {
                System.out.println("Correct!");
                results.append("Correct! \\n");
            }  else {
                System.out.println("Wrong! It's " + dataSet[row][solutionCol]);
                results.append("Wrong! It's " + dataSet[row][solutionCol] + "\\n");
            }
        }

        return results.toString();
    }
}
