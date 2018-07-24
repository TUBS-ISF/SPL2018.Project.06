package de.tubs.hirakanaji;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static de.tubs.hirakanaji.export.TxtExport.printOutput;
import static de.tubs.hirakanaji.gamemode.LearnVocabulary.startLearnVocabulary;
import static de.tubs.hirakanaji.gamemode.Scrambler.startScrambler;
import static de.tubs.hirakanaji.gamemode.ShowSyllables.startShowSyllables;
import static de.tubs.hirakanaji.gamemode.SyllableTrainer.startSyllableTrainer;
import static de.tubs.hirakanaji.gamemode.PracticeVocabulary.startPracticeVocabulary;

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
        String result;

        properties = Arrays.asList(args);

        System.out.println("Choose game category: Syllables | Vocabulary");
        String input = getUserInput();

        if ("Syllables".equalsIgnoreCase(input)) {
            /* Category Syllables */
            System.out.println("Choose game mode: SyllableTrainer | Scrambler | ShowSyllables");
            input = getUserInput();
        } else {
            /* Category Vocabulary */
            System.out.println("Choose game mode: PracticeVocabulary | LearnVocabulary");
            input = getUserInput();
        }

        if ("SyllableTrainer".equalsIgnoreCase(input)) {
            /* Learn Syllables */
            result = startSyllableTrainer();
        } else if ("Scrambler".equalsIgnoreCase(input)) {
            /* Scrambler */
            result = startScrambler();
        } else if ("ShowSyllables".equalsIgnoreCase(input)){
            /* Show Syllables */
            result = startShowSyllables();
        } else if ("PraticeVocabulary".equalsIgnoreCase(input)){
            /* Practice Vocabulary */
            result = startPracticeVocabulary();
        } else {
            /* Learn Vocabulary */
            result = startLearnVocabulary();
        }

        System.out.println("Do you want to save your results? Yes | No");
        input = getUserInput();

        if ("Yes".equalsIgnoreCase(input)) {
            /* Yes - Export as TXT */
            System.out.println("Enter file name");
            input = getUserInput();

            printOutput(input, result);
        }
    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
