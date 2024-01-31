package model;

import util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class PersonalizeQuestionsHandler
{
    private static final List<Question> personalizeQuestionList = new ArrayList<>();
    public static final String QUESTION_NUMBER_KEY_PROPERTIES = "personalizeQuestionsNumber";
    private static int propertyKeyQuestionNumber = Integer.parseInt(FileUtil.getPersonalizeQuestionsFile().getProperty(QUESTION_NUMBER_KEY_PROPERTIES));
    private static final ArrayList<String> listeStringQuestion = new ArrayList<>();
    private static final String PROPERTY_KEY_START = "personalizeQuestion";
    public static final String PROPERTY_KEY_CATEGORY = "Category";
    public static final String PROPERTY_KEY_QUESTION = "Question";
    public static final String PROPERTY_KEY_ANSWER_A = "AnswerA";
    public static final String PROPERTY_KEY_ANSWER_B = "AnswerB";
    public static final String PROPERTY_KEY_ANSWER_C = "AnswerC";
    public static final String PROPERTY_KEY_ANSWER_D = "AnswerD";
    public static final String PROPERTY_KEY_GOOD_ANSWER = "GoodAnswer";
    public static final String PROPERTY_KEY_EXPLANATION = "Explanation";

    public static void addNewQuestionToPropertiesFile(String category, String questionToAsk, String answerA, String answerB, String answerC, String answerD, String goodAnswer, String explanation)
    {
        propertyKeyQuestionNumber = Integer.parseInt(FileUtil.getPersonalizeQuestionsFile().getProperty(QUESTION_NUMBER_KEY_PROPERTIES));
        propertyKeyQuestionNumber++;

        for(int i = 0; i < propertyKeyQuestionNumber; i++) {
            String propertyQuestionKey = PROPERTY_KEY_START + i;
            String checkIfPropertyExist = FileUtil.getPersonalizeQuestionsFile().getProperty(propertyQuestionKey +PROPERTY_KEY_QUESTION);
            if (checkIfPropertyExist == null) {
                FileUtil.getPersonalizeQuestionsFile().setProperty(propertyQuestionKey + PROPERTY_KEY_CATEGORY, category);
                FileUtil.getPersonalizeQuestionsFile().setProperty(propertyQuestionKey + PROPERTY_KEY_QUESTION, questionToAsk);
                FileUtil.getPersonalizeQuestionsFile().setProperty(propertyQuestionKey + PROPERTY_KEY_ANSWER_A, answerA);
                FileUtil.getPersonalizeQuestionsFile().setProperty(propertyQuestionKey + PROPERTY_KEY_ANSWER_B, answerB);
                FileUtil.getPersonalizeQuestionsFile().setProperty(propertyQuestionKey + PROPERTY_KEY_ANSWER_C, answerC);
                FileUtil.getPersonalizeQuestionsFile().setProperty(propertyQuestionKey + PROPERTY_KEY_ANSWER_D, answerD);
                FileUtil.getPersonalizeQuestionsFile().setProperty(propertyQuestionKey + PROPERTY_KEY_GOOD_ANSWER, goodAnswer);
                FileUtil.getPersonalizeQuestionsFile().setProperty(propertyQuestionKey + PROPERTY_KEY_EXPLANATION, explanation);
                break;
            }
        }
        FileUtil.getPersonalizeQuestionsFile().setProperty(QUESTION_NUMBER_KEY_PROPERTIES, String.valueOf(propertyKeyQuestionNumber));
        FileUtil.storePersonalizeQuestionsFile();
    }

    public static void addPersonalizeQuestionsToStringList()
    {
        propertyKeyQuestionNumber = Integer.parseInt(FileUtil.getPersonalizeQuestionsFile().getProperty(QUESTION_NUMBER_KEY_PROPERTIES));
        String propertyReadQuestionKey;
        for(int i = 0; i < propertyKeyQuestionNumber; i++)
        {
            propertyReadQuestionKey = PROPERTY_KEY_START+i;
            listeStringQuestion.add(FileUtil.getPersonalizeQuestionsFile().getProperty(propertyReadQuestionKey+PROPERTY_KEY_CATEGORY));
            listeStringQuestion.add(FileUtil.getPersonalizeQuestionsFile().getProperty(propertyReadQuestionKey+PROPERTY_KEY_QUESTION));
            listeStringQuestion.add(FileUtil.getPersonalizeQuestionsFile().getProperty(propertyReadQuestionKey+PROPERTY_KEY_ANSWER_A));
            listeStringQuestion.add(FileUtil.getPersonalizeQuestionsFile().getProperty(propertyReadQuestionKey+PROPERTY_KEY_ANSWER_B));
            listeStringQuestion.add(FileUtil.getPersonalizeQuestionsFile().getProperty(propertyReadQuestionKey+PROPERTY_KEY_ANSWER_C));
            listeStringQuestion.add(FileUtil.getPersonalizeQuestionsFile().getProperty(propertyReadQuestionKey+PROPERTY_KEY_ANSWER_D));
            listeStringQuestion.add(FileUtil.getPersonalizeQuestionsFile().getProperty(propertyReadQuestionKey+PROPERTY_KEY_GOOD_ANSWER));
            listeStringQuestion.add(FileUtil.getPersonalizeQuestionsFile().getProperty(propertyReadQuestionKey+PROPERTY_KEY_EXPLANATION));

            Question personalizeQuestion = new Question(listeStringQuestion.get(0), listeStringQuestion.get(1), listeStringQuestion.get(2), listeStringQuestion.get(3), listeStringQuestion.get(4), listeStringQuestion.get(5), listeStringQuestion.get(6), listeStringQuestion.get(7));
            personalizeQuestionList.add(personalizeQuestion);
            listeStringQuestion.clear();
        }
    }

    public static void deleteIndividualQuestion(String deleteIndex)
    {
        propertyKeyQuestionNumber = Integer.parseInt(FileUtil.getPersonalizeQuestionsFile().getProperty(QUESTION_NUMBER_KEY_PROPERTIES));
        propertyKeyQuestionNumber--;

        FileUtil.getPersonalizeQuestionsFile().remove(deleteIndex+PROPERTY_KEY_CATEGORY);
        FileUtil.getPersonalizeQuestionsFile().remove(deleteIndex+PROPERTY_KEY_QUESTION);
        FileUtil.getPersonalizeQuestionsFile().remove(deleteIndex+PROPERTY_KEY_ANSWER_A);
        FileUtil.getPersonalizeQuestionsFile().remove(deleteIndex+PROPERTY_KEY_ANSWER_B);
        FileUtil.getPersonalizeQuestionsFile().remove(deleteIndex+PROPERTY_KEY_ANSWER_C);
        FileUtil.getPersonalizeQuestionsFile().remove(deleteIndex+PROPERTY_KEY_ANSWER_D);
        FileUtil.getPersonalizeQuestionsFile().remove(deleteIndex+PROPERTY_KEY_GOOD_ANSWER);
        FileUtil.getPersonalizeQuestionsFile().remove(deleteIndex+PROPERTY_KEY_EXPLANATION);

        FileUtil.getPersonalizeQuestionsFile().setProperty(QUESTION_NUMBER_KEY_PROPERTIES, String.valueOf(propertyKeyQuestionNumber));
        FileUtil.storePersonalizeQuestionsFile();
        if(propertyKeyQuestionNumber == 0)
        {
            FileUtil.resetPersonalizeQuestionFile();
        }
    }

    public static int getPropertyKeyQuestionNumber() {
        return propertyKeyQuestionNumber;
    }

    public static String getPropertyKeyStart() {
        return PROPERTY_KEY_START;
    }
    public static String getPropertyKeyQuestion() {
        return PROPERTY_KEY_QUESTION;
    }

    public static List<Question> getPersonalizeQuestionList() {
        return personalizeQuestionList;
    }
}
