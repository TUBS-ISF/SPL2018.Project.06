package de.tubs.hirakanaji.syllabary;

import de.tubs.hirakanaji.gamemode.Scrambler;
import de.tubs.hirakanaji.gamemode.ShowSyllables;
import de.tubs.hirakanaji.gamemode.SyllableTrainer;

import static de.tubs.hirakanaji.gamemode.Scrambler.*;
import static de.tubs.hirakanaji.syllabary.Katakana.katakanaYouonDakuten;

/**
 * @author lisa-rosenberg
 * @since 13.05.2018
 */
public aspect Romaji {

    public static final String[][] romajiChars = new String[0][0];

    before(): execution(void de.tubs.hirakanaji.gamemode.Scrambler.startScrambler()) {
        syllabaries += " " + getClass().getName();
    }

    after(): call(String de.tubs.hirakanaji.gamemode.LearnVocabulary.getUserInput()) {
        if (getClass().getName().equalsIgnoreCase(Scrambler.inputSyllabary)) {
            Scrambler.dataSet = Scrambler.getDataSet(romajiChars, romajiGojuuon, romajiGojuuonDakuten,
                    romajiYouon, romajiYouonDakuten);
        }
    }

    after(): call(String de.tubs.hirakanaji.gamemode.ShowSyllables.getUserInput()) {
        if (getClass().getName().equalsIgnoreCase(ShowSyllables.inputSyllabary)) {
            ShowSyllables.dataSet = ShowSyllables.getDataSet(romajiChars, romajiGojuuon, romajiGojuuonDakuten,
                    romajiYouon, romajiYouonDakuten);
        }
    }

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
