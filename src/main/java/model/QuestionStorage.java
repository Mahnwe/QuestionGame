package model;

import java.util.ArrayList;
import java.util.List;

public class QuestionStorage
{
    private final ArrayList<Question> questionList = new ArrayList<>();

    public QuestionStorage()
    {
        createQuestions();
    }

    public void createQuestions()
    {
        Question question1 = new Question(UtilStringStorage.question1,UtilStringStorage.answerA1,
                UtilStringStorage.answerB1, UtilStringStorage.answerC1, UtilStringStorage.answerD1, UtilStringStorage.goodAnswer1,
                UtilStringStorage.explanation1);
        questionList.add(question1);

        Question question2 = new Question(UtilStringStorage.question2,UtilStringStorage.answerA2,
                UtilStringStorage.answerB2, UtilStringStorage.answerC2, UtilStringStorage.answerD2, UtilStringStorage.goodAnswer2,
                UtilStringStorage.explanation2);
        questionList.add(question2);

        Question question3 = new Question(UtilStringStorage.question3,UtilStringStorage.answerA3,
                UtilStringStorage.answerB3, UtilStringStorage.answerC3, UtilStringStorage.answerD3, UtilStringStorage.goodAnswer3,
                UtilStringStorage.explanation3);
        questionList.add(question3);

        Question question4 = new Question(UtilStringStorage.question4,UtilStringStorage.answerA4,
                UtilStringStorage.answerB4, UtilStringStorage.answerC4, UtilStringStorage.answerD4, UtilStringStorage.goodAnswer4,
                UtilStringStorage.explanation4);
        questionList.add(question4);

        Question question5 = new Question(UtilStringStorage.question5,UtilStringStorage.answerA5,
                UtilStringStorage.answerB5, UtilStringStorage.answerC5, UtilStringStorage.answerD5, UtilStringStorage.goodAnswer5,
                UtilStringStorage.explanation5);
        questionList.add(question5);

        Question question6 = new Question(UtilStringStorage.question6,UtilStringStorage.answerA6,
                UtilStringStorage.answerB6, UtilStringStorage.answerC6, UtilStringStorage.answerD6, UtilStringStorage.goodAnswer6,
                UtilStringStorage.explanation6);
        questionList.add(question6);

        Question question7 = new Question(UtilStringStorage.question7,UtilStringStorage.answerA7,
                UtilStringStorage.answerB7, UtilStringStorage.answerC7, UtilStringStorage.answerD7, UtilStringStorage.goodAnswer7,
                UtilStringStorage.explanation7);
        questionList.add(question7);

        Question question8 = new Question(UtilStringStorage.question8,UtilStringStorage.answerA8,
                UtilStringStorage.answerB8, UtilStringStorage.answerC8, UtilStringStorage.answerD8, UtilStringStorage.goodAnswer8,
                UtilStringStorage.explanation8);
        questionList.add(question8);

        Question question9 = new Question(UtilStringStorage.question9,UtilStringStorage.answerA9,
                UtilStringStorage.answerB9, UtilStringStorage.answerC9, UtilStringStorage.answerD9, UtilStringStorage.goodAnswer9,
                UtilStringStorage.explanation9);
        questionList.add(question9);

        Question question10 = new Question(UtilStringStorage.question10,UtilStringStorage.answerA10,
                UtilStringStorage.answerB10, UtilStringStorage.answerC10, UtilStringStorage.answerD10, UtilStringStorage.goodAnswer10,
                UtilStringStorage.explanation10);
        questionList.add(question10);

        Question question11 = new Question(UtilStringStorage.question11,UtilStringStorage.answerA11,
                UtilStringStorage.answerB11, UtilStringStorage.answerC11, UtilStringStorage.answerD11, UtilStringStorage.goodAnswer11,
                UtilStringStorage.explanation11);
        questionList.add(question11);

        Question question12 = new Question(UtilStringStorage.question12,UtilStringStorage.answerA12,
                UtilStringStorage.answerB12, UtilStringStorage.answerC12, UtilStringStorage.answerD12, UtilStringStorage.goodAnswer12,
                UtilStringStorage.explanation12);
        questionList.add(question12);

        Question question13 = new Question(UtilStringStorage.question13,UtilStringStorage.answerA13,
                UtilStringStorage.answerB13, UtilStringStorage.answerC13, UtilStringStorage.answerD13, UtilStringStorage.goodAnswer13,
                UtilStringStorage.explanation13);
        questionList.add(question13);

        Question question14 = new Question(UtilStringStorage.question14,UtilStringStorage.answerA14,
                UtilStringStorage.answerB14, UtilStringStorage.answerC14, UtilStringStorage.answerD14, UtilStringStorage.goodAnswer14,
                UtilStringStorage.explanation14);
        questionList.add(question14);

        Question question15 = new Question(UtilStringStorage.question15,UtilStringStorage.answerA15,
                UtilStringStorage.answerB15, UtilStringStorage.answerC15, UtilStringStorage.answerD15, UtilStringStorage.goodAnswer15,
                UtilStringStorage.explanation15);
        questionList.add(question15);

        Question question16 = new Question(UtilStringStorage.question16,UtilStringStorage.answerA16,
                UtilStringStorage.answerB16, UtilStringStorage.answerC16, UtilStringStorage.answerD16, UtilStringStorage.goodAnswer16,
                UtilStringStorage.explanation16);
        questionList.add(question16);

        Question question17 = new Question(UtilStringStorage.question17,UtilStringStorage.answerA17,
                UtilStringStorage.answerB17, UtilStringStorage.answerC17, UtilStringStorage.answerD17, UtilStringStorage.goodAnswer17,
                UtilStringStorage.explanation17);
        questionList.add(question17);

        Question question18 = new Question(UtilStringStorage.question18,UtilStringStorage.answerA18,
                UtilStringStorage.answerB18, UtilStringStorage.answerC18, UtilStringStorage.answerD18, UtilStringStorage.goodAnswer18,
                UtilStringStorage.explanation18);
        questionList.add(question18);

        Question question19 = new Question(UtilStringStorage.question19,UtilStringStorage.answerA19,
                UtilStringStorage.answerB19, UtilStringStorage.answerC19, UtilStringStorage.answerD19, UtilStringStorage.goodAnswer19,
                UtilStringStorage.explanation19);
        questionList.add(question19);

        Question question20 = new Question(UtilStringStorage.question20,UtilStringStorage.answerA20,
                UtilStringStorage.answerB20, UtilStringStorage.answerC20, UtilStringStorage.answerD20, UtilStringStorage.goodAnswer20,
                UtilStringStorage.explanation20);
        questionList.add(question20);

        Question question21 = new Question(UtilStringStorage.QUESTION_21,UtilStringStorage.ANSWER_A21,
                UtilStringStorage.ANSWER_B21, UtilStringStorage.ANSWER_C21, UtilStringStorage.ANSWER_D21, UtilStringStorage.GOOD_ANSWER_21,
                UtilStringStorage.EXPLANATION_21);
        questionList.add(question21);

        Question question22 = new Question(UtilStringStorage.QUESTION_22,UtilStringStorage.ANSWER_A22,
                UtilStringStorage.ANSWER_B22, UtilStringStorage.ANSWER_C22, UtilStringStorage.ANSWER_D22, UtilStringStorage.GOOD_ANSWER_22,
                UtilStringStorage.EXPLANATION_22);
        questionList.add(question22);

        Question question23 = new Question(UtilStringStorage.QUESTION_23,UtilStringStorage.ANSWER_A23,
                UtilStringStorage.ANSWER_B23, UtilStringStorage.ANSWER_C23, UtilStringStorage.ANSWER_D23, UtilStringStorage.GOOD_ANSWER_23,
                UtilStringStorage.EXPLANATION_23);
        questionList.add(question23);

        Question question24 = new Question(UtilStringStorage.QUESTION_24,UtilStringStorage.ANSWER_A24,
                UtilStringStorage.ANSWER_B24, UtilStringStorage.ANSWER_C24, UtilStringStorage.ANSWER_D24, UtilStringStorage.GOOD_ANSWER_24,
                UtilStringStorage.EXPLANATION_24);
        questionList.add(question24);

        Question question25 = new Question(UtilStringStorage.QUESTION_25,UtilStringStorage.ANSWER_A25,
                UtilStringStorage.ANSWER_B25, UtilStringStorage.ANSWER_C25, UtilStringStorage.ANSWER_D25, UtilStringStorage.GOOD_ANSWER_25,
                UtilStringStorage.EXPLANATION_25);
        questionList.add(question25);

        Question question26 = new Question(UtilStringStorage.QUESTION_26,UtilStringStorage.ANSWER_A26,
                UtilStringStorage.ANSWER_B26, UtilStringStorage.ANSWER_C26, UtilStringStorage.ANSWER_D26, UtilStringStorage.GOOD_ANSWER_26,
                UtilStringStorage.EXPLANATION_26);
        questionList.add(question26);

        Question question27 = new Question(UtilStringStorage.QUESTION_27,UtilStringStorage.ANSWER_A27,
                UtilStringStorage.ANSWER_B27, UtilStringStorage.ANSWER_C27, UtilStringStorage.ANSWER_D27, UtilStringStorage.GOOD_ANSWER_27,
                UtilStringStorage.EXPLANATION_27);
        questionList.add(question27);

        Question question28 = new Question(UtilStringStorage.QUESTION_28,UtilStringStorage.ANSWER_A28,
                UtilStringStorage.ANSWER_B28, UtilStringStorage.ANSWER_C28, UtilStringStorage.ANSWER_D28, UtilStringStorage.GOOD_ANSWER_28,
                UtilStringStorage.EXPLANATION_28);
        questionList.add(question28);

        Question question29 = new Question(UtilStringStorage.QUESTION_29,UtilStringStorage.ANSWER_A29,
                UtilStringStorage.ANSWER_B29, UtilStringStorage.ANSWER_C29, UtilStringStorage.ANSWER_D29, UtilStringStorage.GOOD_ANSWER_29,
                UtilStringStorage.EXPLANATION_29);
        questionList.add(question29);

        Question question30 = new Question(UtilStringStorage.QUESTION_30,UtilStringStorage.ANSWER_A30,
                UtilStringStorage.ANSWER_B30, UtilStringStorage.ANSWER_C30, UtilStringStorage.ANSWER_D30, UtilStringStorage.GOOD_ANSWER_30,
                UtilStringStorage.EXPLANATION_30);
        questionList.add(question30);

        Question question31 = new Question(UtilStringStorage.QUESTION_31,UtilStringStorage.ANSWER_A31,
                UtilStringStorage.ANSWER_B31, UtilStringStorage.ANSWER_C31, UtilStringStorage.ANSWER_D31, UtilStringStorage.GOOD_ANSWER_31,
                UtilStringStorage.EXPLANATION_31);
        questionList.add(question31);

        Question question32 = new Question(UtilStringStorage.QUESTION_32,UtilStringStorage.ANSWER_A32,
                UtilStringStorage.ANSWER_B32, UtilStringStorage.ANSWER_C32, UtilStringStorage.ANSWER_D32, UtilStringStorage.GOOD_ANSWER_32,
                UtilStringStorage.EXPLANATION_32);
        questionList.add(question32);

        Question question33 = new Question(UtilStringStorage.QUESTION_33,UtilStringStorage.ANSWER_A33,
                UtilStringStorage.ANSWER_B33, UtilStringStorage.ANSWER_C33, UtilStringStorage.ANSWER_D33, UtilStringStorage.GOOD_ANSWER_33,
                UtilStringStorage.EXPLANATION_33);
        questionList.add(question33);

        Question question34 = new Question(UtilStringStorage.QUESTION_34,UtilStringStorage.ANSWER_A34,
                UtilStringStorage.ANSWER_B34, UtilStringStorage.ANSWER_C34, UtilStringStorage.ANSWER_D34, UtilStringStorage.GOOD_ANSWER_34,
                UtilStringStorage.EXPLANATION_34);
        questionList.add(question34);

        Question question35 = new Question(UtilStringStorage.QUESTION_35,UtilStringStorage.ANSWER_A35,
                UtilStringStorage.ANSWER_B35, UtilStringStorage.ANSWER_C35, UtilStringStorage.ANSWER_D35, UtilStringStorage.GOOD_ANSWER_35,
                UtilStringStorage.EXPLANATION_35);
        questionList.add(question35);
    }

    public List<Question> getQuestionList() {
        return questionList;
    }
}
