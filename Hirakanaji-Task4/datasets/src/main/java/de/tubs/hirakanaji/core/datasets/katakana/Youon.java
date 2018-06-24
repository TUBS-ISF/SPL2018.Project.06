package de.tubs.hirakanaji.core.datasets.katakana;

import de.tubs.hirakanaji.core.DataSet;

/**
 * @author lisa-rosenberg
 * @since 27.05.2018
 */
public class Youon implements DataSet {

    private static final String[][] katakanaYouon = new String[][] {
            // a       u      e      o
            {"キャ", "キュ",        "キョ"}, // k
            {"シャ", "シュ", "シェ", "ショ"}, // s
            {"チャ", "チュ", "チェ", "チョ"}, // c
            {"ニャ", "ニュ",        "ニョ"}, // n
            {"ヒャ", "ヒュ",        "ヒョ"}, // h
            {"ミャ", "ミュ",        "ミョ"}, // m
            {"リャ", "リュ",        "リョ"}, // r
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
        return katakanaYouon;
    }

    @Override
    public String[][] getRomajiSet() {
        return romajiYouon;
    }
}
