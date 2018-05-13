package de.tubs.hirakanaji.core;

/**
 * @author lisa-rosenberg
 * @since 13.05.2018
 */
public class RomajiDataSet {

    public static final String[][] romajiChars = new String[0][0];

    public static final String[][] romajiData = new String[][] {
            {"a", "i", "u", "e", "o"},

            {"ka", "ki", "ku", "ke", "ko"},
            {"ga", "gi", "gu", "ge", "go"},

            {"sa", "shi", "su", "se", "so"},
            {"za", "ji", "zu", "ze", "zo"},

            {"ta", "chi", "tsu", "te", "to"},
            {"da", "ji", "zu", "de", "do"},

            {"na", "ni", "nu", "ne", "no"},

            {"ha", "hi", "fu", "he", "ho"},
            {"ba", "bi", "bu", "be", "bo"},
            {"pa", "pi", "pu", "pe", "po"},

            {"ma", "mi", "mu", "me", "mo"},

            {"ya",       "yu",       "yo"},

            {"ra", "ri", "ru", "re", "ro"},

            {"wa",                   "wo"},

            {"n"},
    };

    public static final String[][] romajiExtraData = new String[][] {
            {"kya", "kyu",        "kyo"},
            {"gya", "gyu",        "gyo"},

            {"nya", "nyu",        "nyo"},

            {"hya", "hyu",        "hyo"},

            {"bya", "byu",        "byo"},
            {"pya", "pyu",        "pyo"},

            {"mya", "myu",        "myo"},

            {"rya", "ryu",        "ryo"},

            {"ja",  "ju",  "je",  "jo" },

            {"cha", "chu", "che", "cho"},

            {"sha", "shu", "she", "sho"},
    };

}
