package de.tubs.hirakanaji;

import de.tubs.hirakanaji.core.DataSet;
import de.tubs.hirakanaji.core.DataSetLoader;
import de.tubs.hirakanaji.gamemodes.GameMode;
import de.tubs.hirakanaji.gamemodes.GameModeLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author lisa-rosenberg
 * @since 13.05.2018
 */
public class HirakanajiApplication {

    private static List<String> properties;
    private static Logger logger = LoggerFactory.getLogger(HirakanajiApplication.class.getName());

    public static List<String> getProperties() {
        return properties;
    }

    public static void main(String[] args) {
        properties = Arrays.asList(args);

        // Load DataSets
        DataSetLoader.loadDataSets();
        List<DataSet> availableDataSets = DataSetLoader.getAvailableDataSets();

        String[][] allSyllabaryDataSets = availableDataSets.stream()
                .map(DataSet::getSyllabarySet)
                .flatMap(Stream::of).toArray(String[][]::new);

        String[][] allRomajiDataSets = availableDataSets.stream()
                .map(DataSet::getRomajiSet)
                .flatMap(Stream::of).toArray(String[][]::new);

        // Load GameModes
        GameModeLoader.loadGameModes();
        List<GameMode> availableGameModes = GameModeLoader.getAvailableGameModes();

        // Let User Choose GameMode
        String gameModeNames = availableGameModes.stream().map(GameMode::getName).reduce((s, s2) -> s + " | " + s2).orElse(null);
        Map<String, GameMode> gameModesMap = availableGameModes.stream().collect(Collectors.toMap(GameMode::getName, gm -> gm));

        logger.info("Choose game mode: {}", gameModeNames);

        Scanner scanner = new Scanner(System.in);
        String gamemode = scanner.nextLine();

        // Start Chosen GameMode
        GameMode gameMode = gameModesMap.get(gamemode);
        gameMode.start(allSyllabaryDataSets, allRomajiDataSets);
    }
}
