package de.tubs.hirakanaji.dataset.datasets.hiragana;

import de.tubs.hirakanaji.dataset.DataSet;

/**
 * @author lisa-rosenberg
 * @since 13.05.2018
 */
public class Gojuuon implements DataSet {

    private static final String[][] hiraganaGojuuon = new String[][] {
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
        return hiraganaGojuuon;
    }

    @Override
    public String[][] getRomajiSet() {
        return romajiGojuuon;
    }
}
