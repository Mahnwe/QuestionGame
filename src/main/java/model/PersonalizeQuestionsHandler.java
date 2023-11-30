package model;

import util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class PersonalizeQuestionsHandler
{
    public static List<Question> personalizeQuestionList = new ArrayList<>();
    private static final String QUESTION_NUMBER_KEY_PROPERTIES = "personalizeQuestionsNumber";
    private static int propertyKeyQuestionNumber = Integer.parseInt(FileUtil.personalizeQuestionsFile.getProperty(QUESTION_NUMBER_KEY_PROPERTIES));
    private static final ArrayList<String> listeStringQuestion = new ArrayList<>();
    private static final String PROPERTY_KEY_START = "personalizeQuestion";
    private static final String PROPERTY_KEY_CATEGORY = "Category";
    private static final String PROPERTY_KEY_QUESTION = "Question";
    private static final String PROPERTY_KEY_ANSWER_A = "AnswerA";
    private static final String PROPERTY_KEY_ANSWER_B = "AnswerB";
    private static final String PROPERTY_KEY_ANSWER_C = "AnswerC";
    private static final String PROPERTY_KEY_ANSWER_D = "AnswerD";
    private static final String PROPERTY_KEY_GOOD_ANSWER = "GoodAnswer";
    private static final String PROPERTY_KEY_EXPLANATION = "Explanation";

    public static void addNewQuestionToPropertiesFile(String category, String questionToAsk, String answerA, String answerB, String answerC, String answerD, String goodAnswer, String explanation)
    {
        String propertyQuestionKey = PROPERTY_KEY_START +propertyKeyQuestionNumber;

        FileUtil.personalizeQuestionsFile.setProperty(propertyQuestionKey+ PROPERTY_KEY_CATEGORY, category);
        FileUtil.personalizeQuestionsFile.setProperty(propertyQuestionKey+ PROPERTY_KEY_QUESTION, questionToAsk);
        FileUtil.personalizeQuestionsFile.setProperty(propertyQuestionKey+ PROPERTY_KEY_ANSWER_A, answerA);
        FileUtil.personalizeQuestionsFile.setProperty(propertyQuestionKey+ PROPERTY_KEY_ANSWER_B, answerB);
        FileUtil.personalizeQuestionsFile.setProperty(propertyQuestionKey+ PROPERTY_KEY_ANSWER_C, answerC);
        FileUtil.personalizeQuestionsFile.setProperty(propertyQuestionKey+ PROPERTY_KEY_ANSWER_D, answerD);
        FileUtil.personalizeQuestionsFile.setProperty(propertyQuestionKey+ PROPERTY_KEY_GOOD_ANSWER, goodAnswer);
        FileUtil.personalizeQuestionsFile.setProperty(propertyQuestionKey+ PROPERTY_KEY_EXPLANATION, explanation);

        propertyKeyQuestionNumber++;
        FileUtil.personalizeQuestionsFile.setProperty(QUESTION_NUMBER_KEY_PROPERTIES, String.valueOf(propertyKeyQuestionNumber));
        FileUtil.storePersonalizeQuestionsFile();
    }

    public static void addPersonalizeQuestionsToStringList()
    {
        propertyKeyQuestionNumber = Integer.parseInt(FileUtil.personalizeQuestionsFile.getProperty(QUESTION_NUMBER_KEY_PROPERTIES));
        String propertyReadQuestionKey;
        for(int i = 0; i < propertyKeyQuestionNumber; i++)
        {
            propertyReadQuestionKey = PROPERTY_KEY_START+i;
            listeStringQuestion.add(FileUtil.personalizeQuestionsFile.getProperty(propertyReadQuestionKey+PROPERTY_KEY_CATEGORY));
            listeStringQuestion.add(FileUtil.personalizeQuestionsFile.getProperty(propertyReadQuestionKey+PROPERTY_KEY_QUESTION));
            listeStringQuestion.add(FileUtil.personalizeQuestionsFile.getProperty(propertyReadQuestionKey+PROPERTY_KEY_ANSWER_A));
            listeStringQuestion.add(FileUtil.personalizeQuestionsFile.getProperty(propertyReadQuestionKey+PROPERTY_KEY_ANSWER_B));
            listeStringQuestion.add(FileUtil.personalizeQuestionsFile.getProperty(propertyReadQuestionKey+PROPERTY_KEY_ANSWER_C));
            listeStringQuestion.add(FileUtil.personalizeQuestionsFile.getProperty(propertyReadQuestionKey+PROPERTY_KEY_ANSWER_D));
            listeStringQuestion.add(FileUtil.personalizeQuestionsFile.getProperty(propertyReadQuestionKey+PROPERTY_KEY_GOOD_ANSWER));
            listeStringQuestion.add(FileUtil.personalizeQuestionsFile.getProperty(propertyReadQuestionKey+PROPERTY_KEY_EXPLANATION));

            Question personalizeQuestion = new Question(listeStringQuestion.get(0), listeStringQuestion.get(1), listeStringQuestion.get(2), listeStringQuestion.get(3), listeStringQuestion.get(4), listeStringQuestion.get(5), listeStringQuestion.get(6), listeStringQuestion.get(7));
            personalizeQuestionList.add(personalizeQuestion);
            listeStringQuestion.clear();
        }
    }
}
