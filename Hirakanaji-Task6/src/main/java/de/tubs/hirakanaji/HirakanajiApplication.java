package de.tubs.hirakanaji;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static de.tubs.hirakanaji.gamemode.Scrambler.startScrambler;
import static de.tubs.hirakanaji.gamemode.ShowSyllables.startShowSyllables;
import static de.tubs.hirakanaji.gamemode.SyllableTrainer.startSyllableTrainer;

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

        System.out.println("Choose game mode: SyllableTrainer | Scrambler | ShowSyllables");
        String input = getUserInput();

        if ("SyllableTrainer".equals(input)) {
            /* Learn Syllables */
            startSyllableTrainer();
        } else if ("Scrambler".equals(input)) {
            /* Scrambler */
            startScrambler();
        } else {
            /* ShowSyllables */
            startShowSyllables();
        }
    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
