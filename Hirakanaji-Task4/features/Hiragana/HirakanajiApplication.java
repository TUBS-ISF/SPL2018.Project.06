package de.tubs.hirakanaji;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static de.tubs.hirakanaji.core.RomajiDataSet.*;
import static de.tubs.hirakanaji.core.HiraganaDataSet.*;
import static de.tubs.hirakanaji.core.KatakanaDataSet.*;

/**
 * @author lisa-rosenberg
 * @since 13.05.2018
 */
public class HirakanajiApplication {

    private static void startScrambler() {
        String[][] dataSet;

        // Hiragana
        dataSet = getDataSet(hiraganaChars, hiraganaGojuuon, hiraganaGojuuonDakuten, hiraganaYouon, hiraganaYouonDakuten);
    }

    private static void startSyllableTrainer() {
        String[][] dataSet;

        // Hiragana
        dataSet = getDataSet(hiraganaChars, hiraganaGojuuon, hiraganaGojuuonDakuten, hiraganaYouon, hiraganaYouonDakuten);

        askQuestions(dataSet);
    }
}
