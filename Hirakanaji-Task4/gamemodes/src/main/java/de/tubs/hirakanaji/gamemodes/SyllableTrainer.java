package de.tubs.hirakanaji.gamemodes;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class SyllableTrainer implements GameMode {

    private void askQuestions(String[][] syllabaryDataSet, String[][] romajiDataSet) {
        int rounds = 10;

        for (int round = 0; round <= rounds; round++) {
            int row = ThreadLocalRandom.current().nextInt(0, syllabaryDataSet.length);
            int col = ThreadLocalRandom.current().nextInt(0, syllabaryDataSet[row].length);

            System.out.println("Which romaji syllable is this one?");

            System.out.println(syllabaryDataSet[row][col]);
            String input = getUserInput();

            if (input.equals(romajiDataSet[row][col])) {
                System.out.println("Correct!");
            } else {
                System.out.println("Wrong! It's " + romajiDataSet[row][col]);
            }
        }
    }

    private String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void start(String[][] syllabaryDataSet, String[][] romajiDataSet) {
        askQuestions(syllabaryDataSet, romajiDataSet);
    }

    @Override
    public String getName() {
        return "Syllable-Trainer";
    }
}
