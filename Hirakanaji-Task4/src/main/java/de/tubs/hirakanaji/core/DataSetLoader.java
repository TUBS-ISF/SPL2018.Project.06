package de.tubs.hirakanaji.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;

public class DataSetLoader {

    private DataSetLoader() {}
    
    private static Map<String, DataSet> dataSets;
    private static Logger logger = LoggerFactory.getLogger(DataSetLoader.class.getName());

    public static void loadDataSets() {
        final Map<String, DataSet> loadedDataSets = new HashMap<>();

        File loc = new File("Hirakanaji-Task4" + File.separatorChar + "plugins");

        File[] flist = loc.listFiles(file -> file.getPath().toLowerCase().contains("-dataset-"));
        URL[] urls = new URL[Objects.requireNonNull(flist).length];
        for (int i = 0; i < flist.length; i++) {
            try {
                urls[i] = flist[i].toURI().toURL();
            } catch (MalformedURLException e) {
                logger.info("Fehler");
            }
        }
        URLClassLoader ucl = new URLClassLoader(urls);


        final ServiceLoader<DataSet> serviceLoader = ServiceLoader.load(DataSet.class, ucl);

        for (DataSet dataSet : serviceLoader) {
            String dataSetName = dataSet.getClass().getName();
            loadedDataSets.put(dataSetName, dataSet);
            logger.info("Loaded dataset: {}", dataSetName);
        }

        dataSets = loadedDataSets;
    }

    public static List<DataSet> getAvailableDataSets() {
        return new ArrayList<>(dataSets.values());
    }
    
}
