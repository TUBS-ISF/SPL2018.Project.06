package de.tubs.hirakanaji;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static de.tubs.hirakanaji.core.RomajiDataSet.*;

/**
 * @author lisa-rosenberg
 * @since 13.05.2018
 */
@SuppressWarnings("Duplicates")
public class HirakanajiApplication {

    private static List<String> properties;

    public static void main(String[] args) {
        properties = Arrays.asList(args);

        /* Scrambler (CLI) */
        
        // #if CLI
	    String[][] dataSet;
	        
	    // #if Romaji
	    dataSet = Stream.of(romajiChars, romajiGojuuon, romajiGojuuonDakuten, romajiYouon, romajiYouonDakuten)
	            .flatMap(Stream::of).toArray(String[][]::new);
	    printSyllables(dataSet);
	    // #endif
	        
	    // #if Hiragana
//@	    dataSet = Stream.of(hiraganaChars, hiraganaGojuuon, hiraganaGojuuonDakuten, hiraganaYouon, hiraganaYouonDakuten)
//@	            .flatMap(Stream::of).toArray(String[][]::new);
//@	    printSyllables(dataSet);
	    // #endif

        // #if Katakana
//@	    dataSet = Stream.of(katakanaChars, katakanaGojuuon, katakanaGojuuonDakuten, katakanaYouon, katakanaYouonDakuten)
//@	            .flatMap(Stream::of).toArray(String[][]::new);
//@	    printSyllables(dataSet);
        // #endif
	    // #endif

    }

    public static List<String> getProperties() {
        return properties;
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
