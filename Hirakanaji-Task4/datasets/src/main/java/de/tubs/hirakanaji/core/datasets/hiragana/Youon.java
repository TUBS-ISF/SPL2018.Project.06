package de.tubs.hirakanaji.core.datasets.hiragana;

import de.tubs.hirakanaji.core.DataSet;

/**
 * @author lisa-rosenberg
 * @since 13.05.2018
 */
public class Youon implements DataSet {

    private static final String[][] hiraganaYouon = new String[][] {
            // a       u      e      o
            {"きゃ", "きゅ",        "きょ"}, // k
            {"しゃ", "しゅ", "しぇ", "しょ"}, // s
            {"ちゃ", "ちゅ", "ちぇ", "ちょ"}, // c
            {"にゃ", "にゅ",        "にょ"}, // n
            {"ひゃ", "ひゅ",        "ひょ"}, // h
            {"みゃ", "みゅ",        "みょ"}, // m
            {"りゃ", "りゅ",        "りょ"}, // r
    };

    private static final String[][] romajiYouon = new String[][] {
            {"kya", "kyu",        "kyo"},
            {"sha", "shu", "she", "sho"},
            {"cha", "chu", "che", "cho"},
            {"nya", "nyu",        "nyo"},
            {"hya", "hyu",        "hyo"},
            {"mya", "myu",        "myo"},
            {"rya", "ryu",        "ryo"},
    };

    @Override
    public String[][] getSyllabarySet() {
        return hiraganaYouon;
    }

    @Override
    public String[][] getRomajiSet() {
        return romajiYouon;
    }
}
