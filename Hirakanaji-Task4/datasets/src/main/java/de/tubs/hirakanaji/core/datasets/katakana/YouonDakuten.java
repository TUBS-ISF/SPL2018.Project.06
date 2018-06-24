package de.tubs.hirakanaji.core.datasets.katakana;

import de.tubs.hirakanaji.core.DataSet;

import javax.xml.crypto.Data;

/**
 * @author lisa-rosenberg
 * @since 27.05.2018
 */
public class YouonDakuten implements DataSet {

    private static final String[][] katakanaYouonDakuten = new String[][] {
            // a       u      e      o
            {"ぎゃ", "ぎゅ",        "ぎょ"}, // g
            {"じゃ", "じゅ", "じェ", "じょ"}, // j
            {"ちゃ", "ちゅ", "ちェ", "ちょ"}, // j
            {"びゃ", "びゅ",        "びょ"}, // b
            {"ぴゃ", "ぴゅ",        "ぴょ"}, // p
    };

    private static final String[][] romajiYouonDakuten = new String[][] {
            {"gya", "gyu",        "gyo"},
            {"ja",  "ju",  "je",  "jo" },
            {"ja",  "ju",  "je",  "jo" },
            {"bya", "byu",        "byo"},
            {"pya", "pyu",        "pyo"},
    };

    @Override
    public String[][] getSyllabarySet() {
        return katakanaYouonDakuten;
    }

    @Override
    public String[][] getRomajiSet() {
        return romajiYouonDakuten;
    }
}
