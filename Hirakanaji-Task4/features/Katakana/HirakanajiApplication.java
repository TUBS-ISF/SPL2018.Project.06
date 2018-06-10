/**
 * @author lisa-rosenberg
 * @since 13.05.2018
 */
public class HirakanajiApplication {

    private static void startScrambler() {
        String[][] dataSet;

        // Katakana
        dataSet = getDataSet(katakanaChars, katakanaGojuuon, katakanaGojuuonDakuten, katakanaYouon, katakanaYouonDakuten);
        printSyllables(dataSet);
    }

    private static void startSyllableTrainer() {
        String[][] dataSet;

        // Katakana
        dataSet = getDataSet(katakanaChars, katakanaGojuuon, katakanaGojuuonDakuten, katakanaYouon, katakanaYouonDakuten);

        askQuestions(dataSet);
    }
}
