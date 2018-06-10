/**
 * @author lisa-rosenberg
 * @since 13.05.2018
 */
public class HirakanajiApplication {

    private static Logger logger = LoggerFactory.getLogger("Hirakanaji");

    private static List<String> properties;

    private static String[][] getDataSet(String[][] chars, String[][] gojuuon, String[][] gojuuonDakuten,
                                         String[][] youon, String[][] youonDakuten) {
        String[][] dataSet;
        dataSet = Stream.of(chars)
                .flatMap(Stream::of).toArray(String[][]::new);

        dataSet = Stream.of(dataSet, gojuuon)
                .flatMap(Stream::of).toArray(String[][]::new);

        dataSet = Stream.of(dataSet, gojuuonDakuten)
                .flatMap(Stream::of).toArray(String[][]::new);

        dataSet = Stream.of(dataSet, youon)
                .flatMap(Stream::of).toArray(String[][]::new);

        dataSet = Stream.of(dataSet, youonDakuten)
                .flatMap(Stream::of).toArray(String[][]::new);
        return dataSet;
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
            StringBuilder line = new StringBuilder(maxSyllableCount);
            for (int j = 0; j < random.nextInt(minSyllableCount, maxSyllableCount + 1); j++) {
                line.append(dataSet[syllable = random.nextInt(0, dataSet.length)]
                        [random.nextInt(0, dataSet[syllable].length)]);
            }
            logger.info(line.toString());
        }
    }
}
