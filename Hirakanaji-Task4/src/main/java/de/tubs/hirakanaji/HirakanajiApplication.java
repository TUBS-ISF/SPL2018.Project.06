package de.tubs.hirakanaji;

import java.util.Arrays;
import java.util.List;

import static de.tubs.hirakanaji.logic.Scrambler.startScrambler;
import static de.tubs.hirakanaji.logic.SyllableTrainer.startSyllableTrainer;

/**
 * @author lisa-rosenberg
 * @since 13.05.2018
 */
public class HirakanajiApplication {

    private static List<String> properties;

    public static List<String> getProperties() {
        return properties;
    }

    public static void main(String[] args) {
        properties = Arrays.asList(args);

        /* Learn Syllables */
        startSyllableTrainer();

        /* Scrambler */
        startScrambler();
    }
}
