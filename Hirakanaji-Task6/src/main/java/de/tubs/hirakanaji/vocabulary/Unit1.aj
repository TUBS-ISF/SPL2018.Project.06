package de.tubs.hirakanaji.vocabulary;

import de.tubs.hirakanaji.gamemode.LearnVocabulary;
import de.tubs.hirakanaji.gamemode.PracticeVocabulary;

import static de.tubs.hirakanaji.gamemode.LearnVocabulary.inputUnit;

public aspect Unit1 {

    before(): execution(String de.tubs.hirakanaji.gamemode.LearnVocabulary.startLearnVocabulary()) {
        LearnVocabulary.units += " " + getClass().getName();
    }

    before(): execution(String de.tubs.hirakanaji.gamemode.PracticeVocabulary.startPracticeVocabulary()) {
        PracticeVocabulary.units += " " + getClass().getName();
    }

    after(): call(String de.tubs.hirakanaji.gamemode.LearnVocabulary.getUserInput()) {
        if (getClass().getName().equalsIgnoreCase(inputUnit)) {
            LearnVocabulary.dataSet = LearnVocabulary.getDataSet(unit1Vocabulary);
        }
    }

    after(): call(String de.tubs.hirakanaji.gamemode.PracticeVocabulary.getUserInput()) {
        if (getClass().getName().equalsIgnoreCase(inputUnit)) {
            PracticeVocabulary.dataSet = PracticeVocabulary.getDataSet(unit1Vocabulary);
        }
    }

    public static final String[][] unit1Vocabulary = new String[][] {
            {"Hajimemashite!",      "Nice to meet you!",    "はじめまして!"},
            {"desu",                "to be",                "です"},
            {"hai",                 "yes",                  "はい"},
            {"sō desu",             "that's right",         "そう です"},
            {"Konnichi wa!",        "Hello!",               "こんにち わ"},
            {"kore",                "this",                 "これ"},
            {"nimotsu",             "luggage",              "にもつ"},
            {"iie",                 "no",                   "いいえ"},
            {"watashi",             "I",                    "わたし"},
            {"dewa arimasen",       "not",                  "でわ ありません"},
            {"sore",                "it",                   "それ"},
            {"kaban",               "bag",                  "かばん"},
            {"are",                 "that",                 "あれ"},
            {"gakkō",               "school",               "がっこう"},
            {"sakura",              "cherry tree",          "さくら"},
            {"hana",                "flower",               "はな"},
            {"momo",                "peach tree",           "もも"},
            {"nan",                 "what",                 "なん"},
            {"depāto",              "shopping center",      "でぱあと"},
            {"eki",                 "railway station",      "えき"},
            {"Arigatō!",            "Thank you!",           "ありがとう!"},
            {"Dō itashimashite!",   "You're welcome!",      "どう いたしまして!"},
            {"Jā",                  "Well then",            "じゃあ"},
            {"Jā mata!",            "See you!",             "じゃあ また"},
            {"Sayōnara!",           "Goodbye!",             "さようなら!"}
    };

}
