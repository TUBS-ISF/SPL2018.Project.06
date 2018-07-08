package de.tubs.hirakanaji;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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

        System.out.println("Choose game mode: SyllableTrainer | Scrambler");
        String input = getUserInput();

        if ("SyllableTrainer".equals(input)) {
            /* Learn Syllables */
            startSyllableTrainer();

        } else {/* Scrambler */
            startScrambler();
        }
    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
