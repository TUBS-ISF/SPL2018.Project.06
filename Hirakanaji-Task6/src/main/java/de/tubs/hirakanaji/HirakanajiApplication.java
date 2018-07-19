package de.tubs.hirakanaji;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static de.tubs.hirakanaji.gamemode.Scrambler.startScrambler;
import static de.tubs.hirakanaji.gamemode.ShowSyllables.startShowSyllables;
import static de.tubs.hirakanaji.gamemode.SyllableTrainer.startSyllableTrainer;
import static de.tubs.hirakanaji.gamemode.VocabularyTrainer.startVocabularyTrainer;

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

        System.out.println("Choose game mode: SyllableTrainer | Scrambler | ShowSyllables | VocabularyTrainer");
        String input = getUserInput();

        if ("SyllableTrainer".equalsIgnoreCase(input)) {
            /* Learn Syllables */
            startSyllableTrainer();
        } else if ("Scrambler".equalsIgnoreCase(input)) {
            /* Scrambler */
            startScrambler();
        } else if ("ShowSyllables".equalsIgnoreCase(input)){
            /* Show Syllables */
            startShowSyllables();
        } else {
            /* Vocabulary Trainer */
            startVocabularyTrainer();
        }
    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
