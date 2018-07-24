package de.tubs.hirakanaji.export;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TxtExport {

    public static void printOutput(String fileName, String exportText) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(exportText);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
