package de.tubs.hirakanaji.gamemodes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;

public class GameModeLoader {

    private GameModeLoader() {}

    private static Logger logger = LoggerFactory.getLogger(GameModeLoader.class.getName());
    private static Map<String, GameMode> gameModes;

    public static void loadGameModes() {
        final Map<String, GameMode> loadedGameModes = new HashMap<>();

        File loc = new File("Hirakanaji-Task4" + File.separatorChar + "plugins");

        File[] flist = loc.listFiles(file -> file.getPath().toLowerCase().contains("-gamemode-"));
        URL[] urls = new URL[Objects.requireNonNull(flist).length];
        for (int i = 0; i < flist.length; i++) {
            try {
                urls[i] = flist[i].toURI().toURL();
            } catch (MalformedURLException e) {
                logger.info("Fehler");
            }
        }

        URLClassLoader ucl = new URLClassLoader(urls);

        final ServiceLoader<GameMode> serviceLoader = ServiceLoader.load(GameMode.class, ucl);

        for (GameMode gameMode : serviceLoader) {
            String gameModeName = gameMode.getClass().getName();
            loadedGameModes.put(gameModeName, gameMode);
            logger.info("Loaded gamemode: {}", gameModeName);
        }

        gameModes = loadedGameModes;
    }

    public static List<GameMode> getAvailableGameModes() {
        return new ArrayList<>(gameModes.values());
    }
    
}
