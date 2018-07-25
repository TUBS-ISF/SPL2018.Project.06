package de.tubs.hirakanaji.syllabary;

import de.tubs.hirakanaji.gamemode.Scrambler;
import de.tubs.hirakanaji.gamemode.ShowSyllables;
import de.tubs.hirakanaji.gamemode.SyllableTrainer;

import static de.tubs.hirakanaji.gamemode.Scrambler.*;
import static de.tubs.hirakanaji.syllabary.Hiragana.*;

/**
 * @author lisa-rosenberg
 * @since 27.05.2018
 */
public aspect Katakana {

    public static final String[][] katakanaChars = new String[0][0];

    before(): execution(String de.tubs.hirakanaji.gamemode.Scrambler.startScrambler()) {
        syllabaries += " " + getClass().getName();
    }

    after(): call(String de.tubs.hirakanaji.gamemode.LearnVocabulary.getUserInput()) {
        if (getClass().getName().equalsIgnoreCase(Scrambler.inputSyllabary)) {
            Scrambler.dataSet = Scrambler.getDataSet(katakanaChars, katakanaGojuuon, katakanaGojuuonDakuten,
                    katakanaYouon, katakanaYouonDakuten);
        }
    }

    after(): call(String de.tubs.hirakanaji.gamemode.ShowSyllables.getUserInput()) {
        if (getClass().getName().equalsIgnoreCase(ShowSyllables.inputSyllabary)) {
            ShowSyllables.dataSet = ShowSyllables.getDataSet(katakanaChars, katakanaGojuuon, katakanaGojuuonDakuten,
                    katakanaYouon, katakanaYouonDakuten);
        }
    }

    after(): call(String de.tubs.hirakanaji.gamemode.SyllableTrainer.getUserInput()) {
        if (getClass().getName().equalsIgnoreCase(SyllableTrainer.inputSyllabary)) {
            SyllableTrainer.dataSet = SyllableTrainer.getDataSet(katakanaChars, katakanaGojuuon, katakanaGojuuonDakuten,
                    katakanaYouon, katakanaYouonDakuten);
        }
    }

    public static final String[][] katakanaGojuuon = new String[][] {
            // a    i     u     e    o
            {"ア", "イ", "ウ", "エ", "オ"}, // None

            {"カ", "キ", "ク", "ケ", "コ"}, // k
            {"サ", "シ", "ス", "セ", "ソ"}, // s
            {"タ", "チ", "ツ", "テ", "ト"}, // t
            {"ナ", "ニ", "ヌ", "ネ", "ノ"}, // n
            {"ハ", "ヒ", "フ", "ヘ", "ホ"}, // h
            {"マ", "ミ", "ム", "メ", "モ"}, // m
            {"ヤ",       "ユ",       "ヨ"}, // y
            {"ラ", "リ", "ル", "レ", "ロ"}, // r
            {"ワ",                   "ヲ"}, // w

            {"ン"}, // Special
    };

    public static final String[][] katakanaGojuuonDakuten = new String[][] {
            // a    i     u     e    o
            {"ガ", "ギ", "グ", "ゲ", "ゴ"}, // g
            {"ザ", "ジ", "ズ", "ゼ", "ゾ"}, // z
            {"ダ", "ヂ", "ヅ", "デ", "ド"}, // d
            {"バ", "ビ", "ブ", "ベ", "ボ"}, // b
            {"パ", "ピ", "プ", "ペ", "ポ"}, // p
    };

    public static final String[][] katakanaYouon = new String[][] {
            // a       u      e      o
            {"キャ", "キュ",        "キョ"}, // k
            {"シャ", "シュ", "シェ", "ショ"}, // s
            {"チャ", "チュ", "チェ", "チョ"}, // c
            {"ニャ", "ニュ",        "ニョ"}, // n
            {"ヒャ", "ヒュ",        "ヒョ"}, // h
            {"ミャ", "ミュ",        "ミョ"}, // m
            {"リャ", "リュ",        "リョ"}, // r
    };

    public static final String[][] katakanaYouonDakuten = new String[][] {
            // a       u      e      o
            {"ぎゃ", "ぎゅ",        "ぎょ"}, // g
            {"じゃ", "じゅ", "じェ", "じょ"}, // j
            {"ちゃ", "ちゅ", "ちェ", "ちょ"}, // j
            {"びゃ", "びゅ",        "びょ"}, // b
            {"ぴゃ", "ぴゅ",        "ぴょ"}, // p
    };

}
