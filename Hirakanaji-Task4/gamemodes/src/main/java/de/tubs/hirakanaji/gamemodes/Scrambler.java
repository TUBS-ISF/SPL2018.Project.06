package de.tubs.hirakanaji.gamemodes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Scrambler implements GameMode{

    private Scrambler() {}

    private static Logger logger = LoggerFactory.getLogger(Scrambler.class.getName());

    private static void printSyllables(String[][] dataSet, String[][] romajiDataSet) {
        logger.info("syllabary | romaji");
        String[][] chosenDataSet;

        Scanner scanner = new Scanner(System.in);
        chosenDataSet = scanner.nextLine().equals("romaji") ? romajiDataSet : dataSet;

        int minSyllableCount = 2;   // Min. number of syllables per line (e.g. "ba ka")
        int maxSyllableCount = 5;   // Max. number of syllables per line (e.g. "ha hi fu he ho")
        int wordCount = 20;         // Amount of generated lines
        int syllable;               // Variable syllable of dataSet

        ThreadLocalRandom random = ThreadLocalRandom.current();

        for (int i = 0; i < wordCount; i++) {
            StringBuilder line = new StringBuilder(maxSyllableCount);

            for (int j = 0; j < random.nextInt(minSyllableCount, maxSyllableCount + 1); j++) {
                line.append(chosenDataSet[syllable = random.nextInt(0, chosenDataSet.length)]
                        [random.nextInt(0, chosenDataSet[syllable].length)]);
            }

            logger.info(line.toString());
        }
    }

    @Override
    public void start(String[][] syllabaryDataSet, String[][] romajiDataSet) {
        printSyllables(syllabaryDataSet, romajiDataSet);
    }

    @Override
    public String getName() {
        return null;
    }
}
