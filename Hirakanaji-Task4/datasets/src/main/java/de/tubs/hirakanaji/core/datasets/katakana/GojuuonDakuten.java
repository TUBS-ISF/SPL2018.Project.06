package de.tubs.hirakanaji.core.datasets.katakana;

import de.tubs.hirakanaji.core.DataSet;

/**
 * @author lisa-rosenberg
 * @since 27.05.2018
 */
public class GojuuonDakuten implements DataSet {

    private static final String[][] katakanaGojuuonDakuten = new String[][] {
            // a    i     u     e    o
            {"ガ", "ギ", "グ", "ゲ", "ゴ"}, // g
            {"ザ", "ジ", "ズ", "ゼ", "ゾ"}, // z
            {"ダ", "ヂ", "ヅ", "デ", "ド"}, // d
            {"バ", "ビ", "ブ", "ベ", "ボ"}, // b
            {"パ", "ピ", "プ", "ペ", "ポ"}, // p
    };

    private static final String[][] romajiGojuuonDakuten = new String[][] {
            {"ga", "gi", "gu", "ge", "go"},
            {"za", "ji", "zu", "ze", "zo"},
            {"da", "ji", "zu", "de", "do"},
            {"ba", "bi", "bu", "be", "bo"},
            {"pa", "pi", "pu", "pe", "po"},
    };

    @Override
    public String[][] getSyllabarySet() {
        return katakanaGojuuonDakuten;
    }

    @Override
    public String[][] getRomajiSet() {
        return romajiGojuuonDakuten;
    }
}
