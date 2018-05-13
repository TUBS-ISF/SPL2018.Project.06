package de.tubs.hirakanaji;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static de.tubs.hirakanaji.core.HiraganaDataSet.*;
import static de.tubs.hirakanaji.core.RomajiDataSet.*;

/**
 * @author lisa-rosenberg
 * @since 13.05.2018
 */
public class HirakanajiApplication {

    public static void main(String[] args) {
        List<String> list = Arrays.asList(args);

        // Scrambler (CLI)
        if (list.contains("Scrambler")) {
            String[][] dataSet;

            if (list.contains("Romaji")) {
                dataSet = Stream.of(romajiChars, romajiData, romajiExtraData)
                        .flatMap(Stream::of).toArray(String[][]::new);
                printSyllables(dataSet);
            }

            if (list.contains("Hiragana")) {
                dataSet = Stream.of(hiraganaChars, hiraganaData, hiraganaExtraData)
                        .flatMap(Stream::of).toArray(String[][]::new);
                printSyllables(dataSet);
            }
        }
    }

    private static void printSyllables(String[][] dataSet) {
        int minSyllableCount = 2;   // Min. number of syllables per line (e.g. "ba ka")
        int maxSyllableCount = 5;   // Max. number of syllables per line (e.g. "ha hi fu he ho")
        int wordCount = 20;         // Amount of generated lines
        int syllable;               // Variable syllable of dataSet

        ThreadLocalRandom random = ThreadLocalRandom.current();

        for (int i = 0; i < wordCount; i++) {
            for (int j = 0; j < random.nextInt(minSyllableCount, maxSyllableCount + 1); j++) {
                System.out.print(dataSet[syllable = random.nextInt(0, dataSet.length)]
                                              [random.nextInt(0, dataSet[syllable].length)]);
            }
            System.out.println(/*"\n"*/);
        }
    }

}
