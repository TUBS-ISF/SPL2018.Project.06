package de.tubs.hirakanaji;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import static de.tubs.hirakanaji.logic.Scrambler.startScrambler;
import static de.tubs.hirakanaji.logic.SyllableTrainer.startSyllableTrainer;

/**
 * @author lisa-rosenberg
 * @since 13.05.2018
 */
public class HirakanajiApplication {

    private static Logger logger = LoggerFactory.getLogger("Hirakanaji");

    private static List<String> properties;

    public static void main(String[] args) {
        properties = Arrays.asList(args);

        /* Learn Syllables */
        startSyllableTrainer();

        /* Scrambler */
        startScrambler();
    }

    public static List<String> getProperties() {
        return properties;
    }
}
