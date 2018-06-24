package de.tubs.hirakanaji.core.datasets.hiragana;

import de.tubs.hirakanaji.core.DataSet;

/**
 * @author lisa-rosenberg
 * @since 13.05.2018
 */
public class YouonDakuten implements DataSet {

    private static final String[][] hiraganaYouonDakuten = new String[][] {
            // a       u      e      o
            {"ぎゃ", "ぎゅ",        "ぎょ"}, // g
            {"じゃ", "じゅ", "じぇ", "じょ"}, // j
            {"ぢゃ", "ぢゅ", "ぢぇ", "ぢょ"}, // j
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
        return hiraganaYouonDakuten;
    }

    @Override
    public String[][] getRomajiSet() {
        return romajiYouonDakuten;
    }
}
