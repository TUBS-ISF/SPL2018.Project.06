package de.tubs.hirakanaji.export;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static de.tubs.hirakanaji.HirakanajiApplication.exportText;

public aspect Txt {

    after(): execution(void de.tubs.hirakanaji.HirakanajiApplication.main()) {
        System.out.println("Your results will be exported into a text file. Enter file name.");
        String userInput = getUserInput();

        printOutput(userInput, exportText);
    }

    public static void printOutput(String fileName, String exportText) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(exportText);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
