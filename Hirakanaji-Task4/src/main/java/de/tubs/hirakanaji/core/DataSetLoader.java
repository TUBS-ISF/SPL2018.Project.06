package de.tubs.hirakanaji.core;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;

public class DataSetLoader {

    private DataSetLoader() {}
    
    private static Map<String, DataSet> dataSets;

    public static void loadDataSets() {
        final Map<String, DataSet> loadedDataSets = new HashMap<>();

        File loc = new File("Hirakanaji-Task4" + File.separatorChar + "plugins");
        System.out.println(loc.exists());

        File[] flist = loc.listFiles(file -> file.getPath().toLowerCase().contains("-dataset-"));
        URL[] urls = new URL[Objects.requireNonNull(flist).length];
        for (int i = 0; i < flist.length; i++) {
            try {
                urls[i] = flist[i].toURI().toURL();
            } catch (MalformedURLException e) {
                System.out.println("fehler");
            }
        }
        URLClassLoader ucl = new URLClassLoader(urls);


        final ServiceLoader<DataSet> serviceLoader = ServiceLoader.load(DataSet.class, ucl);

        for (DataSet dataSet : serviceLoader) {
            String dataSetName = dataSet.getClass().getName();
            loadedDataSets.put(dataSetName, dataSet);
            System.out.println("Loaded dataset: " + dataSetName);
        }

        dataSets = loadedDataSets;
    }

    public static List<DataSet> getAvailableDataSets() {
        return new ArrayList<>(dataSets.values());
    }
    
}
