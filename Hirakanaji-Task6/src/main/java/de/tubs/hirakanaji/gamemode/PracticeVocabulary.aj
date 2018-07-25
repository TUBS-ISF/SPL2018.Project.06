package de.tubs.hirakanaji.gamemode;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static de.tubs.hirakanaji.HirakanajiApplication.exportText;
import static de.tubs.hirakanaji.HirakanajiApplication.gameModes;
import static de.tubs.hirakanaji.HirakanajiApplication.userInput;
import static de.tubs.hirakanaji.vocabulary.Unit1.unit1Vocabulary;
import static de.tubs.hirakanaji.vocabulary.Unit2.unit2Vocabulary;

public aspect PracticeVocabulary {

    private static int rounds;
    public static String units;
    public static String inputUnit;
    public static String[][] dataSet;

    before(): execution(void HirakanajiApplication.main()) {
        gameModes += " " + getClass().getName();
    }

    after(): call(String de.tubs.hirakanaji.HirakanajiApplication.getUserInput()) {
        if (getClass().getName().equalsIgnoreCase(userInput)) {
            exportText = startPracticeVocabulary();
        }
    }

    private PracticeVocabulary() {

    }

    public static String startPracticeVocabulary() {
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
