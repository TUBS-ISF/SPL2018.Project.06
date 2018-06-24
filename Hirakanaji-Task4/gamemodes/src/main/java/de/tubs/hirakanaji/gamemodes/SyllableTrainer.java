package de.tubs.hirakanaji.gamemodes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class SyllableTrainer implements GameMode {

    private SyllableTrainer() {}

    private static Logger logger = LoggerFactory.getLogger(SyllableTrainer.class.getName());

    public static void startSyllableTrainer(String[][] syllabaryDataSet, String[][] romajiDataSet) {
        askQuestions(syllabaryDataSet, romajiDataSet);
    }

    private static void askQuestions(String[][] syllabaryDataSet, String[][] romajiDataSet) {
        int rounds = 10;

        for (int round = 0; round <= rounds; round++) {
            int row = ThreadLocalRandom.current().nextInt(0, syllabaryDataSet.length);
            int col = ThreadLocalRandom.current().nextInt(0, syllabaryDataSet[row].length);

            logger.info("Which romaji syllable is this one?");
            logger.info(syllabaryDataSet[row][col]);
            String input = getUserInput();

            if (input.equals(romajiDataSet[row][col])) {
                logger.info("Correct!");
            } else {
                logger.info("Wrong! It's {}.", romajiDataSet[row][col]);
            }
        }
    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void start(String[][] syllabaryDataSet, String[][] romajiDataSet) {

    }

    @Override
    public String getName() {
        return null;
    }
}
