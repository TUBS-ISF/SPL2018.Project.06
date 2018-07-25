package de.tubs.hirakanaji.syllabary;

import de.tubs.hirakanaji.gamemode.Scrambler;
import de.tubs.hirakanaji.gamemode.ShowSyllables;
import de.tubs.hirakanaji.gamemode.SyllableTrainer;

import java.util.stream.Stream;

import static de.tubs.hirakanaji.gamemode.Scrambler.*;

/**
 * @author lisa-rosenberg
 * @since 13.05.2018
 */
public aspect Hiragana {

    public static final String[][] hiraganaChars = new String[0][0];

    before(): execution(String de.tubs.hirakanaji.gamemode.Scrambler.startScrambler()) {
        syllabaries += " " + getClass().getName();
    }

    after(): call(String de.tubs.hirakanaji.gamemode.LearnVocabulary.getUserInput()) {
        if (getClass().getName().equalsIgnoreCase(Scrambler.inputSyllabary)) {
            Scrambler.dataSet = Scrambler.getDataSet(hiraganaChars, hiraganaGojuuon, hiraganaGojuuonDakuten,
                    hiraganaYouon, hiraganaYouonDakuten);
        }
    }

    after(): call(String de.tubs.hirakanaji.gamemode.ShowSyllables.getUserInput()) {
        if (getClass().getName().equalsIgnoreCase(ShowSyllables.inputSyllabary)) {
            ShowSyllables.dataSet = ShowSyllables.getDataSet(hiraganaChars, hiraganaGojuuon, hiraganaGojuuonDakuten,
                    hiraganaYouon, hiraganaYouonDakuten);
        }
    }

    after(): call(String de.tubs.hirakanaji.gamemode.SyllableTrainer.getUserInput()) {
        if (getClass().getName().equalsIgnoreCase(SyllableTrainer.inputSyllabary)) {
            SyllableTrainer.dataSet = SyllableTrainer.getDataSet(hiraganaChars, hiraganaGojuuon, hiraganaGojuuonDakuten,
                    hiraganaYouon, hiraganaYouonDakuten);
        }
    }

    public static final String[][] hiraganaGojuuon = new String[][] {
            // a    i     u     e    o
            {"あ", "い", "う", "え", "お"}, // None

            {"か", "き", "く", "け", "こ"}, // k
            {"さ", "し", "す", "せ", "そ"}, // s
            {"た", "ち", "つ", "て", "と"}, // t
            {"な", "に", "ぬ", "ね", "の"}, // n
            {"は", "ひ", "ふ", "へ", "ほ"}, // h
            {"ま", "み", "む", "め", "も"}, // m
            {"や",       "ゆ",       "よ"}, // y
            {"ら", "り", "る", "れ", "ろ"}, // r
            {"わ",                   "を"}, // w

            {"ん"}, // Special
    };

    public static final String[][] hiraganaGojuuonDakuten = new String[][] {
            // a    i     u     e    o
            {"が", "ぎ", "ぐ", "げ", "ご"}, // g
            {"ざ", "じ", "ず", "ぜ", "ぞ"}, // z
            {"だ", "ぢ", "づ", "で", "ど"}, // d
            {"ば", "び", "ぶ", "べ", "ぼ"}, // b
            {"ぱ", "ぴ", "ぷ", "ぺ", "ぽ"}, // p
    };

    public static final String[][] hiraganaYouon = new String[][] {
            // a       u      e      o
            {"きゃ", "きゅ",        "きょ"}, // k
            {"しゃ", "しゅ", "しぇ", "しょ"}, // s
            {"ちゃ", "ちゅ", "ちぇ", "ちょ"}, // c
            {"にゃ", "にゅ",        "にょ"}, // n
            {"ひゃ", "ひゅ",        "ひょ"}, // h
            {"みゃ", "みゅ",        "みょ"}, // m
            {"りゃ", "りゅ",        "りょ"}, // r
    };

    public static final String[][] hiraganaYouonDakuten = new String[][] {
            // a       u      e      o
            {"ぎゃ", "ぎゅ",        "ぎょ"}, // g
            {"じゃ", "じゅ", "じぇ", "じょ"}, // j
            {"ぢゃ", "ぢゅ", "ぢぇ", "ぢょ"}, // j
            {"びゃ", "びゅ",        "びょ"}, // b
            {"ぴゃ", "ぴゅ",        "ぴょ"}, // p
    };

}
