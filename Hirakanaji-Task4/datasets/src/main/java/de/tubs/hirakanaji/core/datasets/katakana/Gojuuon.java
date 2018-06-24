package de.tubs.hirakanaji.core.datasets.katakana;

import de.tubs.hirakanaji.core.DataSet;

/**
 * @author lisa-rosenberg
 * @since 27.05.2018
 */
public class Gojuuon implements DataSet {

    private static final String[][] katakanaGojuuon = new String[][] {
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

    private static final String[][] romajiGojuuon = new String[][] {
            {"a", "i", "u", "e", "o"},

            {"ka", "ki", "ku", "ke", "ko"},
            {"sa", "shi", "su", "se", "so"},
            {"ta", "chi", "tsu", "te", "to"},
            {"na", "ni", "nu", "ne", "no"},
            {"ha", "hi", "fu", "he", "ho"},
            {"ma", "mi", "mu", "me", "mo"},
            {"ya",       "yu",       "yo"},
            {"ra", "ri", "ru", "re", "ro"},
            {"wa",                   "wo"},

            {"n"},
    };

    @Override
    public String[][] getSyllabarySet() {
        return katakanaGojuuon;
    }

    @Override
    public String[][] getRomajiSet() {
        return romajiGojuuon;
    }
}
