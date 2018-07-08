package de.tubs.hirakanaji.core;

/**
 * @author lisa-rosenberg
 * @since 13.05.2018
 */
public class RomajiDataSet {

    public static final String[][] romajiChars = new String[0][0];

    public static final String[][] romajiGojuuon = new String[][] {
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

    public static final String[][] romajiGojuuonDakuten = new String[][] {
            {"ga", "gi", "gu", "ge", "go"},
            {"za", "ji", "zu", "ze", "zo"},
            {"da", "ji", "zu", "de", "do"},
            {"ba", "bi", "bu", "be", "bo"},
            {"pa", "pi", "pu", "pe", "po"},
    };

    public static final String[][] romajiYouon = new String[][] {
            {"kya", "kyu",        "kyo"},
            {"sha", "shu", "she", "sho"},
            {"cha", "chu", "che", "cho"},
            {"nya", "nyu",        "nyo"},
            {"hya", "hyu",        "hyo"},
            {"mya", "myu",        "myo"},
            {"rya", "ryu",        "ryo"},
    };

    public static final String[][] romajiYouonDakuten = new String[][] {
            {"gya", "gyu",        "gyo"},
            {"ja",  "ju",  "je",  "jo" },
            {"ja",  "ju",  "je",  "jo" },
            {"bya", "byu",        "byo"},
            {"pya", "pyu",        "pyo"},
    };

}
