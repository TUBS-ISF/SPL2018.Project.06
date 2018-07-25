package de.tubs.hirakanaji;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author lisa-rosenberg
 * @since 13.05.2018
 */
public class HirakanajiApplication {

    private static List<String> properties;

    public static String gameModes;
    public static String exportText;
    public static String userInput;

    public static List<String> getProperties() {
        return properties;
    }

    public static void main(String[] args) {
        properties = Arrays.asList(args);

        System.out.println("Choose game mode:" + gameModes);
        userInput = getUserInput();
    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
