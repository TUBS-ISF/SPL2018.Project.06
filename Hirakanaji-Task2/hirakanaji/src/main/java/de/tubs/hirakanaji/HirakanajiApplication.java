package de.tubs.hirakanaji;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static de.tubs.hirakanaji.core.HiraganaDataSet.*;
import static de.tubs.hirakanaji.core.HiraganaDataSet.hiraganaData;

/**
 * @author lisa-rosenberg
 * @since 13.05.2018
 */
public class HirakanajiApplication {

    public static void main(String[] args) {

        String[][] dataSet = Stream.of(characters, hiraganaData, hiraganaExtraData)
                .flatMap(Stream::of).toArray(String[][]::new);

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
