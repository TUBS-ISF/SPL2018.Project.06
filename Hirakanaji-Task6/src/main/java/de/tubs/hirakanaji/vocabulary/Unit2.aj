package de.tubs.hirakanaji.vocabulary;

import de.tubs.hirakanaji.gamemode.LearnVocabulary;
import de.tubs.hirakanaji.gamemode.PracticeVocabulary;

import static de.tubs.hirakanaji.gamemode.LearnVocabulary.getDataSet;
import static de.tubs.hirakanaji.gamemode.LearnVocabulary.inputUnit;

public aspect Unit2 {

    before(): execution(String de.tubs.hirakanaji.gamemode.LearnVocabulary.startLearnVocabulary()) {
        LearnVocabulary.units += " " + getClass().getName();
    }

    before(): execution(String de.tubs.hirakanaji.gamemode.PracticeVocabulary.startPracticeVocabulary()) {
        PracticeVocabulary.units += " " + getClass().getName();
    }

    after(): call(String de.tubs.hirakanaji.gamemode.LearnVocabulary.getUserInput()) {
        if (getClass().getName().equalsIgnoreCase(inputUnit)) {
            LearnVocabulary.dataSet = getDataSet(unit2Vocabulary);
        }
    }

    after(): call(String de.tubs.hirakanaji.gamemode.PracticeVocabulary.getUserInput()) {
        if (getClass().getName().equalsIgnoreCase(inputUnit)) {
            PracticeVocabulary.dataSet = getDataSet(unit2Vocabulary);
        }
    }

    public static final String[][] unit2Vocabulary = new String[][] {
            {"Nihon",           "Japan",                "にほん"},
            {"nihongo",         "Japanese",             "にほんご"},
            {"doitsugo",        "German",               "どいつご"},
            {"sensei",          "teacher",              "せんせい"},
            {"anata",           "you",                  "あなた"},
            {"minna",           "everyone",             "みんな"},
            {"hiragana",        "Hiragana",             "ひらがな"},
            {"katakana",        "Katakana",             "かたかな"},
            {"kanji",           "Kanji",                "かんじ"},
            {"rōmaji",          "Romaji",               "ろうまじ"},
            {"mono",            "thing",                "もの"},
            {"kyōshitsu",       "classroom",            "きょうしつ"},
            {"mado",            "window",               "まど"},
            {"tsukue",          "desk",                 "つくえ"},
            {"isu",             "chair",                "いす"},
            {"hon",             "book",                 "ほん"},
            {"kyōkasho",        "textbook",             "きょうかしょ"},
            {"enpitsu",         "pencil",               "えんぴつ"},
            {"kokuban",         "blackboard",           "こくばん"},
            {"e",               "picture",              "え"},
            {"shukudai",        "homework",             "しゅくだい"},
            {"shitsumon",       "question",             "しつもん"},
            {"tsugi",           "next one",             "つぎ"},
            {"motto",           "more",                 "もっと"},
            {"hakkiri",         "clear",                "はっきり"},
            {"yukkuri",         "slow",                 "ゆっくり"},
            {"ōkii koe de",     "in a loud voice",      "おおきい こえ で"},
            {"Mō ichido!",      "One more time!",       "もう いちど!"},
            {"Itte kudasai!",   "Speak up, please!",    "いって ください!"}
    };
}
