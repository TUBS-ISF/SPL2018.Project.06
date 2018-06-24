package de.tubs.hirakanaji.dataset.datasets.hiragana;

import de.tubs.hirakanaji.dataset.DataSet;

/**
 * @author lisa-rosenberg
 * @since 13.05.2018
 */
public class GojuuonDakuten implements DataSet {

    private static final String[][] hiraganaGojuuonDakuten = new String[][] {
            // a    i     u     e    o
            {"が", "ぎ", "ぐ", "げ", "ご"}, // g
            {"ざ", "じ", "ず", "ぜ", "ぞ"}, // z
            {"だ", "ぢ", "づ", "で", "ど"}, // d
            {"ば", "び", "ぶ", "べ", "ぼ"}, // b
            {"ぱ", "ぴ", "ぷ", "ぺ", "ぽ"}, // p
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
        return hiraganaGojuuonDakuten;
    }

    @Override
    public String[][] getRomajiSet() {
        return romajiGojuuonDakuten;
    }
}
