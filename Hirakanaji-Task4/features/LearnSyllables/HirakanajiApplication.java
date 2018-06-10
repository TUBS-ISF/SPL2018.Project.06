/**
 * @author lisa-rosenberg
 * @since 13.05.2018
 */
public class HirakanajiApplication {

    private static void startSyllableTrainer() {
        String[][] dataSet;

        // Hiragana
        dataSet = getDataSet(hiraganaChars, hiraganaGojuuon, hiraganaGojuuonDakuten, hiraganaYouon, hiraganaYouonDakuten);

        askQuestions(dataSet);

        // Katakana
        dataSet = getDataSet(katakanaChars, katakanaGojuuon, katakanaGojuuonDakuten, katakanaYouon, katakanaYouonDakuten);

        askQuestions(dataSet);
    }

    private static void askQuestions(String[][] dataSet) {
        int rounds = 10;
        String[][] romajiDataSet = getDataSet(romajiChars, romajiGojuuon, romajiGojuuonDakuten, romajiYouon, romajiYouonDakuten);

        for (int round = 0; round <= rounds; round++) {
            int row = ThreadLocalRandom.current().nextInt(0, dataSet.length);
            int col = ThreadLocalRandom.current().nextInt(0, dataSet[row].length);

            logger.info("Which romaji syllable is this one?");
            logger.info(dataSet[row][col]);
            String input = getUserInput();
            int[] romajiIndex = searchForSyllable(input);
            if (romajiIndex.length == 0) {
                logger.info("Romaji syllable not found. Correct answer was {}.", romajiDataSet[row][col]);
            }  else if (romajiIndex[0] == row && romajiIndex[1] == col) {
                logger.info("Correct!");
            } else {
                logger.info("Wrong! It's {}.", romajiDataSet[row][col]);
            }
        }
    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static int[] searchForSyllable(String input) {
        String[][] romajiDataSet = getDataSet(romajiChars, romajiGojuuon, romajiGojuuonDakuten, romajiYouon, romajiYouonDakuten);

        for (int row = 0; row < romajiDataSet.length; row++) {
            for (int col = 0; col < romajiDataSet[row].length; col++) {
                if (romajiDataSet[row][col].equals(input)) {
                    return new int[]{row, col};
                }
            }
        }
        return new int[]{};
    }
}
