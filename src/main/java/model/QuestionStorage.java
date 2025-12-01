package model;

import model.handlers.ImportFileHandler;
import model.handlers.PersonalizeQuestionsHandler;
import util.stringutiltranslate.QuestionStringStorage;
import util.stringutiltranslate.UtilStringStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuestionStorage
{
    private final ArrayList<Question> questionList = new ArrayList<>();
    private Random randomIndex;

    public QuestionStorage()
    {
        createQuestions();
        checkExternalSourcesOfQuestions();
    }

    public void createQuestions()
    {
        Question question1 = new Question(UtilStringStorage.geography, QuestionStringStorage.questionObject1.getQuestion(),QuestionStringStorage.questionObject1.getAnswerA(),
                QuestionStringStorage.questionObject1.getAnswerB(), QuestionStringStorage.questionObject1.getAnswerC(), QuestionStringStorage.questionObject1.getAnswerD(),
                QuestionStringStorage.questionObject1.getGoodAnswer(), QuestionStringStorage.questionObject1.getExplanation());
        questionList.add(question1);

        Question question2 = new Question(UtilStringStorage.historia, QuestionStringStorage.questionObject2.getQuestion(),QuestionStringStorage.questionObject2.getAnswerA(),
                QuestionStringStorage.questionObject2.getAnswerB(), QuestionStringStorage.questionObject2.getAnswerC(), QuestionStringStorage.questionObject2.getAnswerD(),
                QuestionStringStorage.questionObject2.getGoodAnswer(), QuestionStringStorage.questionObject2.getExplanation());
        questionList.add(question2);

        Question question3 = new Question(UtilStringStorage.linguistic, QuestionStringStorage.questionObject3.getQuestion(),QuestionStringStorage.questionObject3.getAnswerA(),
                QuestionStringStorage.questionObject3.getAnswerB(), QuestionStringStorage.questionObject3.getAnswerC(), QuestionStringStorage.questionObject3.getAnswerD(),
                QuestionStringStorage.questionObject3.getGoodAnswer(), QuestionStringStorage.questionObject3.getExplanation());
        questionList.add(question3);

        Question question4 = new Question(UtilStringStorage.geography, QuestionStringStorage.questionObject4.getQuestion(),QuestionStringStorage.questionObject4.getAnswerA(),
                QuestionStringStorage.questionObject4.getAnswerB(), QuestionStringStorage.questionObject4.getAnswerC(), QuestionStringStorage.questionObject4.getAnswerD(),
                QuestionStringStorage.questionObject4.getGoodAnswer(), QuestionStringStorage.questionObject4.getExplanation());
        questionList.add(question4);

        Question question5 = new Question(UtilStringStorage.animals, QuestionStringStorage.questionObject5.getQuestion(),QuestionStringStorage.questionObject5.getAnswerA(),
                QuestionStringStorage.questionObject5.getAnswerB(), QuestionStringStorage.questionObject5.getAnswerC(), QuestionStringStorage.questionObject5.getAnswerD(),
                QuestionStringStorage.questionObject5.getGoodAnswer(), QuestionStringStorage.questionObject5.getExplanation());
        questionList.add(question5);

        Question question6 = new Question(UtilStringStorage.invention, QuestionStringStorage.questionObject6.getQuestion(),QuestionStringStorage.questionObject6.getAnswerA(),
                QuestionStringStorage.questionObject6.getAnswerB(), QuestionStringStorage.questionObject6.getAnswerC(), QuestionStringStorage.questionObject6.getAnswerD(),
                QuestionStringStorage.questionObject6.getGoodAnswer(), QuestionStringStorage.questionObject6.getExplanation());
        questionList.add(question6);

        Question question7 = new Question(UtilStringStorage.linguistic, QuestionStringStorage.questionObject7.getQuestion(),QuestionStringStorage.questionObject7.getAnswerA(),
                QuestionStringStorage.questionObject7.getAnswerB(), QuestionStringStorage.questionObject7.getAnswerC(), QuestionStringStorage.questionObject7.getAnswerD(),
                QuestionStringStorage.questionObject7.getGoodAnswer(), QuestionStringStorage.questionObject7.getExplanation());
        questionList.add(question7);

        Question question8 = new Question(UtilStringStorage.insolite, QuestionStringStorage.questionObject8.getQuestion(),QuestionStringStorage.questionObject8.getAnswerA(),
                QuestionStringStorage.questionObject8.getAnswerB(), QuestionStringStorage.questionObject8.getAnswerC(), QuestionStringStorage.questionObject8.getAnswerD(),
                QuestionStringStorage.questionObject8.getGoodAnswer(), QuestionStringStorage.questionObject8.getExplanation());
        questionList.add(question8);

        Question question9 = new Question(UtilStringStorage.paleontology, QuestionStringStorage.questionObject9.getQuestion(),QuestionStringStorage.questionObject9.getAnswerA(),
                QuestionStringStorage.questionObject9.getAnswerB(), QuestionStringStorage.questionObject9.getAnswerC(), QuestionStringStorage.questionObject9.getAnswerD(),
                QuestionStringStorage.questionObject9.getGoodAnswer(), QuestionStringStorage.questionObject9.getExplanation());
        questionList.add(question9);

        Question question10 = new Question(UtilStringStorage.insolite, QuestionStringStorage.questionObject10.getQuestion(),QuestionStringStorage.questionObject10.getAnswerA(),
                QuestionStringStorage.questionObject10.getAnswerB(), QuestionStringStorage.questionObject10.getAnswerC(), QuestionStringStorage.questionObject10.getAnswerD(),
                QuestionStringStorage.questionObject10.getGoodAnswer(), QuestionStringStorage.questionObject10.getExplanation());
        questionList.add(question10);

        Question question11 = new Question(UtilStringStorage.animals, QuestionStringStorage.questionObject11.getQuestion(),QuestionStringStorage.questionObject11.getAnswerA(),
                QuestionStringStorage.questionObject11.getAnswerB(), QuestionStringStorage.questionObject11.getAnswerC(), QuestionStringStorage.questionObject11.getAnswerD(),
                QuestionStringStorage.questionObject11.getGoodAnswer(), QuestionStringStorage.questionObject11.getExplanation());
        questionList.add(question11);

        Question question12 = new Question(UtilStringStorage.videoGames, QuestionStringStorage.questionObject12.getQuestion(),QuestionStringStorage.questionObject12.getAnswerA(),
                QuestionStringStorage.questionObject12.getAnswerB(), QuestionStringStorage.questionObject12.getAnswerC(), QuestionStringStorage.questionObject12.getAnswerD(),
                QuestionStringStorage.questionObject12.getGoodAnswer(), QuestionStringStorage.questionObject12.getExplanation());
        questionList.add(question12);

        Question question13 = new Question(UtilStringStorage.cinema, QuestionStringStorage.questionObject13.getQuestion(),QuestionStringStorage.questionObject13.getAnswerA(),
                QuestionStringStorage.questionObject13.getAnswerB(), QuestionStringStorage.questionObject13.getAnswerC(), QuestionStringStorage.questionObject13.getAnswerD(),
                QuestionStringStorage.questionObject13.getGoodAnswer(), QuestionStringStorage.questionObject13.getExplanation());
        questionList.add(question13);

        Question question14 = new Question(UtilStringStorage.space, QuestionStringStorage.questionObject14.getQuestion(),QuestionStringStorage.questionObject14.getAnswerA(),
                QuestionStringStorage.questionObject14.getAnswerB(), QuestionStringStorage.questionObject14.getAnswerC(), QuestionStringStorage.questionObject14.getAnswerD(),
                QuestionStringStorage.questionObject14.getGoodAnswer(), QuestionStringStorage.questionObject14.getExplanation());
        questionList.add(question14);

        Question question15 = new Question(UtilStringStorage.plants, QuestionStringStorage.questionObject15.getQuestion(),QuestionStringStorage.questionObject15.getAnswerA(),
                QuestionStringStorage.questionObject15.getAnswerB(), QuestionStringStorage.questionObject15.getAnswerC(), QuestionStringStorage.questionObject15.getAnswerD(),
                QuestionStringStorage.questionObject15.getGoodAnswer(), QuestionStringStorage.questionObject15.getExplanation());
        questionList.add(question15);

        Question question16 = new Question(UtilStringStorage.geography, QuestionStringStorage.questionObject16.getQuestion(),QuestionStringStorage.questionObject16.getAnswerA(),
                QuestionStringStorage.questionObject16.getAnswerB(), QuestionStringStorage.questionObject16.getAnswerC(), QuestionStringStorage.questionObject16.getAnswerD(),
                QuestionStringStorage.questionObject16.getGoodAnswer(), QuestionStringStorage.questionObject16.getExplanation());
        questionList.add(question16);

        Question question17 = new Question(UtilStringStorage.historia, QuestionStringStorage.questionObject17.getQuestion(),QuestionStringStorage.questionObject17.getAnswerA(),
                QuestionStringStorage.questionObject17.getAnswerB(), QuestionStringStorage.questionObject17.getAnswerC(), QuestionStringStorage.questionObject17.getAnswerD(),
                QuestionStringStorage.questionObject17.getGoodAnswer(), QuestionStringStorage.questionObject17.getExplanation());
        questionList.add(question17);

        Question question18 = new Question(UtilStringStorage.geography, QuestionStringStorage.questionObject18.getQuestion(),QuestionStringStorage.questionObject18.getAnswerA(),
                QuestionStringStorage.questionObject18.getAnswerB(), QuestionStringStorage.questionObject18.getAnswerC(), QuestionStringStorage.questionObject18.getAnswerD(),
                QuestionStringStorage.questionObject18.getGoodAnswer(), QuestionStringStorage.questionObject18.getExplanation());
        questionList.add(question18);

        Question question19 = new Question(UtilStringStorage.animals, QuestionStringStorage.questionObject19.getQuestion(),QuestionStringStorage.questionObject19.getAnswerA(),
                QuestionStringStorage.questionObject19.getAnswerB(), QuestionStringStorage.questionObject19.getAnswerC(), QuestionStringStorage.questionObject19.getAnswerD(),
                QuestionStringStorage.questionObject19.getGoodAnswer(), QuestionStringStorage.questionObject19.getExplanation());
        questionList.add(question19);

        Question question20 = new Question(UtilStringStorage.music, QuestionStringStorage.questionObject20.getQuestion(),QuestionStringStorage.questionObject20.getAnswerA(),
                QuestionStringStorage.questionObject20.getAnswerB(), QuestionStringStorage.questionObject20.getAnswerC(), QuestionStringStorage.questionObject20.getAnswerD(),
                QuestionStringStorage.questionObject20.getGoodAnswer(), QuestionStringStorage.questionObject20.getExplanation());
        questionList.add(question20);

        Question question21 = new Question(UtilStringStorage.literature, QuestionStringStorage.questionObject21.getQuestion(),QuestionStringStorage.questionObject21.getAnswerA(),
                QuestionStringStorage.questionObject21.getAnswerB(), QuestionStringStorage.questionObject21.getAnswerC(), QuestionStringStorage.questionObject21.getAnswerD(),
                QuestionStringStorage.questionObject21.getGoodAnswer(), QuestionStringStorage.questionObject21.getExplanation());
        questionList.add(question21);

        Question question22 = new Question(UtilStringStorage.linguistic, QuestionStringStorage.questionObject22.getQuestion(),QuestionStringStorage.questionObject22.getAnswerA(),
                QuestionStringStorage.questionObject22.getAnswerB(), QuestionStringStorage.questionObject22.getAnswerC(), QuestionStringStorage.questionObject22.getAnswerD(),
                QuestionStringStorage.questionObject22.getGoodAnswer(), QuestionStringStorage.questionObject22.getExplanation());
        questionList.add(question22);

        Question question23 = new Question(UtilStringStorage.humanBody, QuestionStringStorage.questionObject23.getQuestion(),QuestionStringStorage.questionObject23.getAnswerA(),
                QuestionStringStorage.questionObject23.getAnswerB(), QuestionStringStorage.questionObject23.getAnswerC(), QuestionStringStorage.questionObject23.getAnswerD(),
                QuestionStringStorage.questionObject23.getGoodAnswer(), QuestionStringStorage.questionObject23.getExplanation());
        questionList.add(question23);

        Question question24 = new Question(UtilStringStorage.records, QuestionStringStorage.questionObject24.getQuestion(),QuestionStringStorage.questionObject24.getAnswerA(),
                QuestionStringStorage.questionObject24.getAnswerB(), QuestionStringStorage.questionObject24.getAnswerC(), QuestionStringStorage.questionObject24.getAnswerD(),
                QuestionStringStorage.questionObject24.getGoodAnswer(), QuestionStringStorage.questionObject24.getExplanation());
        questionList.add(question24);

        Question question25 = new Question(UtilStringStorage.culture, QuestionStringStorage.questionObject25.getQuestion(),QuestionStringStorage.questionObject25.getAnswerA(),
                QuestionStringStorage.questionObject25.getAnswerB(), QuestionStringStorage.questionObject25.getAnswerC(), QuestionStringStorage.questionObject25.getAnswerD(),
                QuestionStringStorage.questionObject25.getGoodAnswer(), QuestionStringStorage.questionObject25.getExplanation());
        questionList.add(question25);

        Question question26 = new Question(UtilStringStorage.historia, QuestionStringStorage.questionObject26.getQuestion(),QuestionStringStorage.questionObject26.getAnswerA(),
                QuestionStringStorage.questionObject26.getAnswerB(), QuestionStringStorage.questionObject26.getAnswerC(), QuestionStringStorage.questionObject26.getAnswerD(),
                QuestionStringStorage.questionObject26.getGoodAnswer(), QuestionStringStorage.questionObject26.getExplanation());
        questionList.add(question26);

        Question question27 = new Question(UtilStringStorage.geography, QuestionStringStorage.questionObject27.getQuestion(),QuestionStringStorage.questionObject27.getAnswerA(),
                QuestionStringStorage.questionObject27.getAnswerB(), QuestionStringStorage.questionObject27.getAnswerC(), QuestionStringStorage.questionObject27.getAnswerD(),
                QuestionStringStorage.questionObject27.getGoodAnswer(), QuestionStringStorage.questionObject27.getExplanation());
        questionList.add(question27);

        Question question28 = new Question(UtilStringStorage.law, QuestionStringStorage.questionObject28.getQuestion(),QuestionStringStorage.questionObject28.getAnswerA(),
                QuestionStringStorage.questionObject28.getAnswerB(), QuestionStringStorage.questionObject28.getAnswerC(), QuestionStringStorage.questionObject28.getAnswerD(),
                QuestionStringStorage.questionObject28.getGoodAnswer(), QuestionStringStorage.questionObject28.getExplanation());
        questionList.add(question28);

        Question question29 = new Question(UtilStringStorage.linguistic, QuestionStringStorage.questionObject29.getQuestion(),QuestionStringStorage.questionObject29.getAnswerA(),
                QuestionStringStorage.questionObject29.getAnswerB(), QuestionStringStorage.questionObject29.getAnswerC(), QuestionStringStorage.questionObject29.getAnswerD(),
                QuestionStringStorage.questionObject29.getGoodAnswer(), QuestionStringStorage.questionObject29.getExplanation());
        questionList.add(question29);

        Question question30 = new Question(UtilStringStorage.paleontology, QuestionStringStorage.questionObject30.getQuestion(),QuestionStringStorage.questionObject30.getAnswerA(),
                QuestionStringStorage.questionObject30.getAnswerB(), QuestionStringStorage.questionObject30.getAnswerC(), QuestionStringStorage.questionObject30.getAnswerD(),
                QuestionStringStorage.questionObject30.getGoodAnswer(), QuestionStringStorage.questionObject30.getExplanation());
        questionList.add(question30);

        Question question31 = new Question(UtilStringStorage.records, QuestionStringStorage.questionObject31.getQuestion(),QuestionStringStorage.questionObject31.getAnswerA(),
                QuestionStringStorage.questionObject31.getAnswerB(), QuestionStringStorage.questionObject31.getAnswerC(), QuestionStringStorage.questionObject31.getAnswerD(),
                QuestionStringStorage.questionObject31.getGoodAnswer(), QuestionStringStorage.questionObject31.getExplanation());
        questionList.add(question31);

        Question question32 = new Question(UtilStringStorage.mythology, QuestionStringStorage.questionObject32.getQuestion(),QuestionStringStorage.questionObject32.getAnswerA(),
                QuestionStringStorage.questionObject32.getAnswerB(), QuestionStringStorage.questionObject32.getAnswerC(), QuestionStringStorage.questionObject32.getAnswerD(),
                QuestionStringStorage.questionObject32.getGoodAnswer(), QuestionStringStorage.questionObject32.getExplanation());
        questionList.add(question32);

        Question question33 = new Question(UtilStringStorage.food, QuestionStringStorage.questionObject33.getQuestion(),QuestionStringStorage.questionObject33.getAnswerA(),
                QuestionStringStorage.questionObject33.getAnswerB(), QuestionStringStorage.questionObject33.getAnswerC(), QuestionStringStorage.questionObject33.getAnswerD(),
                QuestionStringStorage.questionObject33.getGoodAnswer(), QuestionStringStorage.questionObject33.getExplanation());
        questionList.add(question33);

        Question question34 = new Question(UtilStringStorage.humanBody, QuestionStringStorage.questionObject34.getQuestion(),QuestionStringStorage.questionObject34.getAnswerA(),
                QuestionStringStorage.questionObject34.getAnswerB(), QuestionStringStorage.questionObject34.getAnswerC(), QuestionStringStorage.questionObject34.getAnswerD(),
                QuestionStringStorage.questionObject34.getGoodAnswer(), QuestionStringStorage.questionObject34.getExplanation());
        questionList.add(question34);

        Question question35 = new Question(UtilStringStorage.society, QuestionStringStorage.questionObject35.getQuestion(),QuestionStringStorage.questionObject35.getAnswerA(),
                QuestionStringStorage.questionObject35.getAnswerB(), QuestionStringStorage.questionObject35.getAnswerC(), QuestionStringStorage.questionObject35.getAnswerD(),
                QuestionStringStorage.questionObject35.getGoodAnswer(), QuestionStringStorage.questionObject35.getExplanation());
        questionList.add(question35);

        Question question36 = new Question(UtilStringStorage.animals, QuestionStringStorage.questionObject36.getQuestion(),QuestionStringStorage.questionObject36.getAnswerA(),
                QuestionStringStorage.questionObject36.getAnswerB(), QuestionStringStorage.questionObject36.getAnswerC(), QuestionStringStorage.questionObject36.getAnswerD(),
                QuestionStringStorage.questionObject36.getGoodAnswer(), QuestionStringStorage.questionObject36.getExplanation());
        questionList.add(question36);

        Question question37 = new Question(UtilStringStorage.literature, QuestionStringStorage.questionObject37.getQuestion(),QuestionStringStorage.questionObject37.getAnswerA(),
                QuestionStringStorage.questionObject37.getAnswerB(), QuestionStringStorage.questionObject37.getAnswerC(), QuestionStringStorage.questionObject37.getAnswerD(),
                QuestionStringStorage.questionObject37.getGoodAnswer(), QuestionStringStorage.questionObject37.getExplanation());
        questionList.add(question37);

        Question question38 = new Question(UtilStringStorage.historia, QuestionStringStorage.questionObject38.getQuestion(),QuestionStringStorage.questionObject38.getAnswerA(),
                QuestionStringStorage.questionObject38.getAnswerB(), QuestionStringStorage.questionObject38.getAnswerC(), QuestionStringStorage.questionObject38.getAnswerD(),
                QuestionStringStorage.questionObject38.getGoodAnswer(), QuestionStringStorage.questionObject38.getExplanation());
        questionList.add(question38);

        Question question39 = new Question(UtilStringStorage.plants, QuestionStringStorage.questionObject39.getQuestion(),QuestionStringStorage.questionObject39.getAnswerA(),
                QuestionStringStorage.questionObject39.getAnswerB(), QuestionStringStorage.questionObject39.getAnswerC(), QuestionStringStorage.questionObject39.getAnswerD(),
                QuestionStringStorage.questionObject39.getGoodAnswer(), QuestionStringStorage.questionObject39.getExplanation());
        questionList.add(question39);

        Question question40 = new Question(UtilStringStorage.historia, QuestionStringStorage.questionObject40.getQuestion(),QuestionStringStorage.questionObject40.getAnswerA(),
                QuestionStringStorage.questionObject40.getAnswerB(), QuestionStringStorage.questionObject40.getAnswerC(), QuestionStringStorage.questionObject40.getAnswerD(),
                QuestionStringStorage.questionObject40.getGoodAnswer(), QuestionStringStorage.questionObject40.getExplanation());
        questionList.add(question40);

        Question question41 = new Question(UtilStringStorage.internet, QuestionStringStorage.questionObject41.getQuestion(),QuestionStringStorage.questionObject41.getAnswerA(),
                QuestionStringStorage.questionObject41.getAnswerB(), QuestionStringStorage.questionObject41.getAnswerC(), QuestionStringStorage.questionObject41.getAnswerD(),
                QuestionStringStorage.questionObject41.getGoodAnswer(), QuestionStringStorage.questionObject41.getExplanation());
        questionList.add(question41);

        Question question42 = new Question(UtilStringStorage.animals, QuestionStringStorage.questionObject42.getQuestion(),QuestionStringStorage.questionObject42.getAnswerA(),
                QuestionStringStorage.questionObject42.getAnswerB(), QuestionStringStorage.questionObject42.getAnswerC(), QuestionStringStorage.questionObject42.getAnswerD(),
                QuestionStringStorage.questionObject42.getGoodAnswer(), QuestionStringStorage.questionObject42.getExplanation());
        questionList.add(question42);

        Question question43 = new Question(UtilStringStorage.videoGames, QuestionStringStorage.questionObject43.getQuestion(),QuestionStringStorage.questionObject43.getAnswerA(),
                QuestionStringStorage.questionObject43.getAnswerB(), QuestionStringStorage.questionObject43.getAnswerC(), QuestionStringStorage.questionObject43.getAnswerD(),
                QuestionStringStorage.questionObject43.getGoodAnswer(), QuestionStringStorage.questionObject43.getExplanation());
        questionList.add(question43);

        Question question44 = new Question(UtilStringStorage.society, QuestionStringStorage.questionObject44.getQuestion(),QuestionStringStorage.questionObject44.getAnswerA(),
                QuestionStringStorage.questionObject44.getAnswerB(), QuestionStringStorage.questionObject44.getAnswerC(), QuestionStringStorage.questionObject44.getAnswerD(),
                QuestionStringStorage.questionObject44.getGoodAnswer(), QuestionStringStorage.questionObject44.getExplanation());
        questionList.add(question44);

        Question question45 = new Question(UtilStringStorage.space, QuestionStringStorage.questionObject45.getQuestion(),QuestionStringStorage.questionObject45.getAnswerA(),
                QuestionStringStorage.questionObject45.getAnswerB(), QuestionStringStorage.questionObject45.getAnswerC(), QuestionStringStorage.questionObject45.getAnswerD(),
                QuestionStringStorage.questionObject45.getGoodAnswer(), QuestionStringStorage.questionObject45.getExplanation());
        questionList.add(question45);

        Question question46 = new Question(UtilStringStorage.music, QuestionStringStorage.questionObject46.getQuestion(),QuestionStringStorage.questionObject46.getAnswerA(),
                QuestionStringStorage.questionObject46.getAnswerB(), QuestionStringStorage.questionObject46.getAnswerC(), QuestionStringStorage.questionObject46.getAnswerD(),
                QuestionStringStorage.questionObject46.getGoodAnswer(), QuestionStringStorage.questionObject46.getExplanation());
        questionList.add(question46);

        Question question47 = new Question(UtilStringStorage.flags, QuestionStringStorage.questionObject47.getQuestion(),QuestionStringStorage.questionObject47.getAnswerA(),
                QuestionStringStorage.questionObject47.getAnswerB(), QuestionStringStorage.questionObject47.getAnswerC(), QuestionStringStorage.questionObject47.getAnswerD(),
                QuestionStringStorage.questionObject47.getGoodAnswer(), QuestionStringStorage.questionObject47.getExplanation());
        questionList.add(question47);

        Question question48 = new Question(UtilStringStorage.humanBody, QuestionStringStorage.questionObject48.getQuestion(),QuestionStringStorage.questionObject48.getAnswerA(),
                QuestionStringStorage.questionObject48.getAnswerB(), QuestionStringStorage.questionObject48.getAnswerC(), QuestionStringStorage.questionObject48.getAnswerD(),
                QuestionStringStorage.questionObject48.getGoodAnswer(), QuestionStringStorage.questionObject48.getExplanation());
        questionList.add(question48);

        Question question49 = new Question(UtilStringStorage.music, QuestionStringStorage.questionObject49.getQuestion(),QuestionStringStorage.questionObject49.getAnswerA(),
                QuestionStringStorage.questionObject49.getAnswerB(), QuestionStringStorage.questionObject49.getAnswerC(), QuestionStringStorage.questionObject49.getAnswerD(),
                QuestionStringStorage.questionObject49.getGoodAnswer(), QuestionStringStorage.questionObject49.getExplanation());
        questionList.add(question49);

        Question question50 = new Question(UtilStringStorage.geography, QuestionStringStorage.questionObject50.getQuestion(),QuestionStringStorage.questionObject50.getAnswerA(),
                QuestionStringStorage.questionObject50.getAnswerB(), QuestionStringStorage.questionObject50.getAnswerC(), QuestionStringStorage.questionObject50.getAnswerD(),
                QuestionStringStorage.questionObject50.getGoodAnswer(), QuestionStringStorage.questionObject50.getExplanation());
        questionList.add(question50);

        Question question51 = new Question(UtilStringStorage.cinema, QuestionStringStorage.questionObject51.getQuestion(),QuestionStringStorage.questionObject51.getAnswerA(),
                QuestionStringStorage.questionObject51.getAnswerB(), QuestionStringStorage.questionObject51.getAnswerC(), QuestionStringStorage.questionObject51.getAnswerD(),
                QuestionStringStorage.questionObject51.getGoodAnswer(), QuestionStringStorage.questionObject51.getExplanation());
        questionList.add(question51);

        Question question52 = new Question(UtilStringStorage.invention, QuestionStringStorage.questionObject52.getQuestion(),QuestionStringStorage.questionObject52.getAnswerA(),
                QuestionStringStorage.questionObject52.getAnswerB(), QuestionStringStorage.questionObject52.getAnswerC(), QuestionStringStorage.questionObject52.getAnswerD(),
                QuestionStringStorage.questionObject52.getGoodAnswer(), QuestionStringStorage.questionObject52.getExplanation());
        questionList.add(question52);

        Question question53 = new Question(UtilStringStorage.sports, QuestionStringStorage.questionObject53.getQuestion(),QuestionStringStorage.questionObject53.getAnswerA(),
                QuestionStringStorage.questionObject53.getAnswerB(), QuestionStringStorage.questionObject53.getAnswerC(), QuestionStringStorage.questionObject53.getAnswerD(),
                QuestionStringStorage.questionObject53.getGoodAnswer(), QuestionStringStorage.questionObject53.getExplanation());
        questionList.add(question53);

        Question question54 = new Question(UtilStringStorage.animals, QuestionStringStorage.questionObject54.getQuestion(),QuestionStringStorage.questionObject54.getAnswerA(),
                QuestionStringStorage.questionObject54.getAnswerB(), QuestionStringStorage.questionObject54.getAnswerC(), QuestionStringStorage.questionObject54.getAnswerD(),
                QuestionStringStorage.questionObject54.getGoodAnswer(), QuestionStringStorage.questionObject54.getExplanation());
        questionList.add(question54);

        Question question55 = new Question(UtilStringStorage.historia, QuestionStringStorage.questionObject55.getQuestion(),QuestionStringStorage.questionObject55.getAnswerA(),
                QuestionStringStorage.questionObject55.getAnswerB(), QuestionStringStorage.questionObject55.getAnswerC(), QuestionStringStorage.questionObject55.getAnswerD(),
                QuestionStringStorage.questionObject55.getGoodAnswer(), QuestionStringStorage.questionObject55.getExplanation());
        questionList.add(question55);

        Question question56 = new Question(UtilStringStorage.society, QuestionStringStorage.questionObject56.getQuestion(),QuestionStringStorage.questionObject56.getAnswerA(),
                QuestionStringStorage.questionObject56.getAnswerB(), QuestionStringStorage.questionObject56.getAnswerC(), QuestionStringStorage.questionObject56.getAnswerD(),
                QuestionStringStorage.questionObject56.getGoodAnswer(), QuestionStringStorage.questionObject56.getExplanation());
        questionList.add(question56);

        Question question57 = new Question(UtilStringStorage.records, QuestionStringStorage.questionObject57.getQuestion(),QuestionStringStorage.questionObject57.getAnswerA(),
                QuestionStringStorage.questionObject57.getAnswerB(), QuestionStringStorage.questionObject57.getAnswerC(), QuestionStringStorage.questionObject57.getAnswerD(),
                QuestionStringStorage.questionObject57.getGoodAnswer(), QuestionStringStorage.questionObject57.getExplanation());
        questionList.add(question57);

        Question question58 = new Question(UtilStringStorage.society, QuestionStringStorage.questionObject58.getQuestion(),QuestionStringStorage.questionObject58.getAnswerA(),
                QuestionStringStorage.questionObject58.getAnswerB(), QuestionStringStorage.questionObject58.getAnswerC(), QuestionStringStorage.questionObject58.getAnswerD(),
                QuestionStringStorage.questionObject58.getGoodAnswer(), QuestionStringStorage.questionObject58.getExplanation());
        questionList.add(question58);

        Question question59 = new Question(UtilStringStorage.literature, QuestionStringStorage.questionObject59.getQuestion(),QuestionStringStorage.questionObject59.getAnswerA(),
                QuestionStringStorage.questionObject59.getAnswerB(), QuestionStringStorage.questionObject59.getAnswerC(), QuestionStringStorage.questionObject59.getAnswerD(),
                QuestionStringStorage.questionObject59.getGoodAnswer(), QuestionStringStorage.questionObject59.getExplanation());
        questionList.add(question59);

        Question question60 = new Question(UtilStringStorage.food, QuestionStringStorage.questionObject60.getQuestion(),QuestionStringStorage.questionObject60.getAnswerA(),
                QuestionStringStorage.questionObject60.getAnswerB(), QuestionStringStorage.questionObject60.getAnswerC(), QuestionStringStorage.questionObject60.getAnswerD(),
                QuestionStringStorage.questionObject60.getGoodAnswer(), QuestionStringStorage.questionObject60.getExplanation());
        questionList.add(question60);

        Question question61 = new Question(UtilStringStorage.painting, QuestionStringStorage.questionObject61.getQuestion(),QuestionStringStorage.questionObject61.getAnswerA(),
                QuestionStringStorage.questionObject61.getAnswerB(), QuestionStringStorage.questionObject61.getAnswerC(), QuestionStringStorage.questionObject61.getAnswerD(),
                QuestionStringStorage.questionObject61.getGoodAnswer(), QuestionStringStorage.questionObject61.getExplanation());
        questionList.add(question61);

        Question question62 = new Question(UtilStringStorage.minerals, QuestionStringStorage.questionObject62.getQuestion(),QuestionStringStorage.questionObject62.getAnswerA(),
                QuestionStringStorage.questionObject62.getAnswerB(), QuestionStringStorage.questionObject62.getAnswerC(), QuestionStringStorage.questionObject62.getAnswerD(),
                QuestionStringStorage.questionObject62.getGoodAnswer(), QuestionStringStorage.questionObject62.getExplanation());
        questionList.add(question62);

        Question question63 = new Question(UtilStringStorage.nature, QuestionStringStorage.questionObject63.getQuestion(),QuestionStringStorage.questionObject63.getAnswerA(),
                QuestionStringStorage.questionObject63.getAnswerB(), QuestionStringStorage.questionObject63.getAnswerC(), QuestionStringStorage.questionObject63.getAnswerD(),
                QuestionStringStorage.questionObject63.getGoodAnswer(), QuestionStringStorage.questionObject63.getExplanation());
        questionList.add(question63);

        Question question64 = new Question(UtilStringStorage.painting, QuestionStringStorage.questionObject64.getQuestion(),QuestionStringStorage.questionObject64.getAnswerA(),
                QuestionStringStorage.questionObject64.getAnswerB(), QuestionStringStorage.questionObject64.getAnswerC(), QuestionStringStorage.questionObject64.getAnswerD(),
                QuestionStringStorage.questionObject64.getGoodAnswer(), QuestionStringStorage.questionObject64.getExplanation());
        questionList.add(question64);

        Question question65 = new Question(UtilStringStorage.space, QuestionStringStorage.questionObject65.getQuestion(),QuestionStringStorage.questionObject65.getAnswerA(),
                QuestionStringStorage.questionObject65.getAnswerB(), QuestionStringStorage.questionObject65.getAnswerC(), QuestionStringStorage.questionObject65.getAnswerD(),
                QuestionStringStorage.questionObject65.getGoodAnswer(), QuestionStringStorage.questionObject65.getExplanation());
        questionList.add(question65);

        Question question66 = new Question(UtilStringStorage.linguistic, QuestionStringStorage.questionObject66.getQuestion(),QuestionStringStorage.questionObject66.getAnswerA(),
                QuestionStringStorage.questionObject66.getAnswerB(), QuestionStringStorage.questionObject66.getAnswerC(), QuestionStringStorage.questionObject66.getAnswerD(),
                QuestionStringStorage.questionObject66.getGoodAnswer(), QuestionStringStorage.questionObject66.getExplanation());
        questionList.add(question66);

        Question question67 = new Question(UtilStringStorage.nature, QuestionStringStorage.questionObject67.getQuestion(),QuestionStringStorage.questionObject67.getAnswerA(),
                QuestionStringStorage.questionObject67.getAnswerB(), QuestionStringStorage.questionObject67.getAnswerC(), QuestionStringStorage.questionObject67.getAnswerD(),
                QuestionStringStorage.questionObject67.getGoodAnswer(), QuestionStringStorage.questionObject67.getExplanation());
        questionList.add(question67);

        Question question68 = new Question(UtilStringStorage.law, QuestionStringStorage.questionObject68.getQuestion(),QuestionStringStorage.questionObject68.getAnswerA(),
                QuestionStringStorage.questionObject68.getAnswerB(), QuestionStringStorage.questionObject68.getAnswerC(), QuestionStringStorage.questionObject68.getAnswerD(),
                QuestionStringStorage.questionObject68.getGoodAnswer(), QuestionStringStorage.questionObject68.getExplanation());
        questionList.add(question68);

        Question question69 = new Question(UtilStringStorage.internet, QuestionStringStorage.questionObject69.getQuestion(),QuestionStringStorage.questionObject69.getAnswerA(),
                QuestionStringStorage.questionObject69.getAnswerB(), QuestionStringStorage.questionObject69.getAnswerC(), QuestionStringStorage.questionObject69.getAnswerD(),
                QuestionStringStorage.questionObject69.getGoodAnswer(), QuestionStringStorage.questionObject69.getExplanation());
        questionList.add(question69);

        Question question70 = new Question(UtilStringStorage.animals, QuestionStringStorage.questionObject70.getQuestion(),QuestionStringStorage.questionObject70.getAnswerA(),
                QuestionStringStorage.questionObject70.getAnswerB(), QuestionStringStorage.questionObject70.getAnswerC(), QuestionStringStorage.questionObject70.getAnswerD(),
                QuestionStringStorage.questionObject70.getGoodAnswer(), QuestionStringStorage.questionObject70.getExplanation());
        questionList.add(question70);

        Question question71 = new Question(UtilStringStorage.sports, QuestionStringStorage.questionObject71.getQuestion(),QuestionStringStorage.questionObject71.getAnswerA(),
                QuestionStringStorage.questionObject71.getAnswerB(), QuestionStringStorage.questionObject71.getAnswerC(), QuestionStringStorage.questionObject71.getAnswerD(),
                QuestionStringStorage.questionObject71.getGoodAnswer(), QuestionStringStorage.questionObject71.getExplanation());
        questionList.add(question71);

        Question question72 = new Question(UtilStringStorage.literature, QuestionStringStorage.questionObject72.getQuestion(),QuestionStringStorage.questionObject72.getAnswerA(),
                QuestionStringStorage.questionObject72.getAnswerB(), QuestionStringStorage.questionObject72.getAnswerC(), QuestionStringStorage.questionObject72.getAnswerD(),
                QuestionStringStorage.questionObject72.getGoodAnswer(), QuestionStringStorage.questionObject72.getExplanation());
        questionList.add(question72);

        Question question73 = new Question(UtilStringStorage.nature, QuestionStringStorage.questionObject73.getQuestion(),QuestionStringStorage.questionObject73.getAnswerA(),
                QuestionStringStorage.questionObject73.getAnswerB(), QuestionStringStorage.questionObject73.getAnswerC(), QuestionStringStorage.questionObject73.getAnswerD(),
                QuestionStringStorage.questionObject73.getGoodAnswer(), QuestionStringStorage.questionObject73.getExplanation());
        questionList.add(question73);

        Question question74 = new Question(UtilStringStorage.animals, QuestionStringStorage.questionObject74.getQuestion(),QuestionStringStorage.questionObject74.getAnswerA(),
                QuestionStringStorage.questionObject74.getAnswerB(), QuestionStringStorage.questionObject74.getAnswerC(), QuestionStringStorage.questionObject74.getAnswerD(),
                QuestionStringStorage.questionObject74.getGoodAnswer(), QuestionStringStorage.questionObject74.getExplanation());
        questionList.add(question74);

        Question question75 = new Question(UtilStringStorage.society, QuestionStringStorage.questionObject75.getQuestion(),QuestionStringStorage.questionObject75.getAnswerA(),
                QuestionStringStorage.questionObject75.getAnswerB(), QuestionStringStorage.questionObject75.getAnswerC(), QuestionStringStorage.questionObject75.getAnswerD(),
                QuestionStringStorage.questionObject75.getGoodAnswer(), QuestionStringStorage.questionObject75.getExplanation());
        questionList.add(question75);

        Question question76 = new Question(UtilStringStorage.invention, QuestionStringStorage.questionObject76.getQuestion(),QuestionStringStorage.questionObject76.getAnswerA(),
                QuestionStringStorage.questionObject76.getAnswerB(), QuestionStringStorage.questionObject76.getAnswerC(), QuestionStringStorage.questionObject76.getAnswerD(),
                QuestionStringStorage.questionObject76.getGoodAnswer(), QuestionStringStorage.questionObject76.getExplanation());
        questionList.add(question76);

        Question question77 = new Question(UtilStringStorage.geography, QuestionStringStorage.questionObject77.getQuestion(),QuestionStringStorage.questionObject77.getAnswerA(),
                QuestionStringStorage.questionObject77.getAnswerB(), QuestionStringStorage.questionObject77.getAnswerC(), QuestionStringStorage.questionObject77.getAnswerD(),
                QuestionStringStorage.questionObject77.getGoodAnswer(), QuestionStringStorage.questionObject77.getExplanation());
        questionList.add(question77);

        Question question78 = new Question(UtilStringStorage.geography, QuestionStringStorage.questionObject78.getQuestion(),QuestionStringStorage.questionObject78.getAnswerA(),
                QuestionStringStorage.questionObject78.getAnswerB(), QuestionStringStorage.questionObject78.getAnswerC(), QuestionStringStorage.questionObject78.getAnswerD(),
                QuestionStringStorage.questionObject78.getGoodAnswer(), QuestionStringStorage.questionObject78.getExplanation());
        questionList.add(question78);

        Question question79 = new Question(UtilStringStorage.historia, QuestionStringStorage.questionObject79.getQuestion(),QuestionStringStorage.questionObject79.getAnswerA(),
                QuestionStringStorage.questionObject79.getAnswerB(), QuestionStringStorage.questionObject79.getAnswerC(), QuestionStringStorage.questionObject79.getAnswerD(),
                QuestionStringStorage.questionObject79.getGoodAnswer(), QuestionStringStorage.questionObject79.getExplanation());
        questionList.add(question79);

        Question question80 = new Question(UtilStringStorage.sports, QuestionStringStorage.questionObject80.getQuestion(),QuestionStringStorage.questionObject80.getAnswerA(),
                QuestionStringStorage.questionObject80.getAnswerB(), QuestionStringStorage.questionObject80.getAnswerC(), QuestionStringStorage.questionObject80.getAnswerD(),
                QuestionStringStorage.questionObject80.getGoodAnswer(), QuestionStringStorage.questionObject80.getExplanation());
        questionList.add(question80);

        Question question81 = new Question(UtilStringStorage.economy, QuestionStringStorage.questionObject81.getQuestion(),QuestionStringStorage.questionObject81.getAnswerA(),
                QuestionStringStorage.questionObject81.getAnswerB(), QuestionStringStorage.questionObject81.getAnswerC(), QuestionStringStorage.questionObject81.getAnswerD(),
                QuestionStringStorage.questionObject81.getGoodAnswer(), QuestionStringStorage.questionObject81.getExplanation());
        questionList.add(question81);

        Question question82 = new Question(UtilStringStorage.minerals, QuestionStringStorage.questionObject82.getQuestion(),QuestionStringStorage.questionObject82.getAnswerA(),
                QuestionStringStorage.questionObject82.getAnswerB(), QuestionStringStorage.questionObject82.getAnswerC(), QuestionStringStorage.questionObject82.getAnswerD(),
                QuestionStringStorage.questionObject82.getGoodAnswer(), QuestionStringStorage.questionObject82.getExplanation());
        questionList.add(question82);

        Question question83 = new Question(UtilStringStorage.space, QuestionStringStorage.questionObject83.getQuestion(),QuestionStringStorage.questionObject83.getAnswerA(),
                QuestionStringStorage.questionObject83.getAnswerB(), QuestionStringStorage.questionObject83.getAnswerC(), QuestionStringStorage.questionObject83.getAnswerD(),
                QuestionStringStorage.questionObject83.getGoodAnswer(), QuestionStringStorage.questionObject83.getExplanation());
        questionList.add(question83);

        Question question84 = new Question(UtilStringStorage.animals, QuestionStringStorage.questionObject84.getQuestion(),QuestionStringStorage.questionObject84.getAnswerA(),
                QuestionStringStorage.questionObject84.getAnswerB(), QuestionStringStorage.questionObject84.getAnswerC(), QuestionStringStorage.questionObject84.getAnswerD(),
                QuestionStringStorage.questionObject84.getGoodAnswer(), QuestionStringStorage.questionObject84.getExplanation());
        questionList.add(question84);

        Question question85 = new Question(UtilStringStorage.humanBody, QuestionStringStorage.questionObject85.getQuestion(),QuestionStringStorage.questionObject85.getAnswerA(),
                QuestionStringStorage.questionObject85.getAnswerB(), QuestionStringStorage.questionObject85.getAnswerC(), QuestionStringStorage.questionObject85.getAnswerD(),
                QuestionStringStorage.questionObject85.getGoodAnswer(), QuestionStringStorage.questionObject85.getExplanation());
        questionList.add(question85);

        Question question86 = new Question(UtilStringStorage.flags, QuestionStringStorage.questionObject86.getQuestion(),QuestionStringStorage.questionObject86.getAnswerA(),
                QuestionStringStorage.questionObject86.getAnswerB(), QuestionStringStorage.questionObject86.getAnswerC(), QuestionStringStorage.questionObject86.getAnswerD(),
                QuestionStringStorage.questionObject86.getGoodAnswer(), QuestionStringStorage.questionObject86.getExplanation());
        questionList.add(question86);

        Question question87 = new Question(UtilStringStorage.insolite, QuestionStringStorage.questionObject87.getQuestion(),QuestionStringStorage.questionObject87.getAnswerA(),
                QuestionStringStorage.questionObject87.getAnswerB(), QuestionStringStorage.questionObject87.getAnswerC(), QuestionStringStorage.questionObject87.getAnswerD(),
                QuestionStringStorage.questionObject87.getGoodAnswer(), QuestionStringStorage.questionObject87.getExplanation());
        questionList.add(question87);

        Question question88 = new Question(UtilStringStorage.invention, QuestionStringStorage.questionObject88.getQuestion(),QuestionStringStorage.questionObject88.getAnswerA(),
                QuestionStringStorage.questionObject88.getAnswerB(), QuestionStringStorage.questionObject88.getAnswerC(), QuestionStringStorage.questionObject88.getAnswerD(),
                QuestionStringStorage.questionObject88.getGoodAnswer(), QuestionStringStorage.questionObject88.getExplanation());
        questionList.add(question88);

        Question question89 = new Question(UtilStringStorage.linguistic, QuestionStringStorage.questionObject89.getQuestion(),QuestionStringStorage.questionObject89.getAnswerA(),
                QuestionStringStorage.questionObject89.getAnswerB(), QuestionStringStorage.questionObject89.getAnswerC(), QuestionStringStorage.questionObject89.getAnswerD(),
                QuestionStringStorage.questionObject89.getGoodAnswer(), QuestionStringStorage.questionObject89.getExplanation());
        questionList.add(question89);

        Question question90 = new Question(UtilStringStorage.animals, QuestionStringStorage.questionObject90.getQuestion(),QuestionStringStorage.questionObject90.getAnswerA(),
                QuestionStringStorage.questionObject90.getAnswerB(), QuestionStringStorage.questionObject90.getAnswerC(), QuestionStringStorage.questionObject90.getAnswerD(),
                QuestionStringStorage.questionObject90.getGoodAnswer(), QuestionStringStorage.questionObject90.getExplanation());
        questionList.add(question90);

        Question question91 = new Question(UtilStringStorage.videoGames, QuestionStringStorage.questionObject91.getQuestion(),QuestionStringStorage.questionObject91.getAnswerA(),
                QuestionStringStorage.questionObject91.getAnswerB(), QuestionStringStorage.questionObject91.getAnswerC(), QuestionStringStorage.questionObject91.getAnswerD(),
                QuestionStringStorage.questionObject91.getGoodAnswer(), QuestionStringStorage.questionObject91.getExplanation());
        questionList.add(question91);

        Question question92 = new Question(UtilStringStorage.cinema, QuestionStringStorage.questionObject92.getQuestion(),QuestionStringStorage.questionObject92.getAnswerA(),
                QuestionStringStorage.questionObject92.getAnswerB(), QuestionStringStorage.questionObject92.getAnswerC(), QuestionStringStorage.questionObject92.getAnswerD(),
                QuestionStringStorage.questionObject92.getGoodAnswer(), QuestionStringStorage.questionObject92.getExplanation());
        questionList.add(question92);

        Question question93 = new Question(UtilStringStorage.historia, QuestionStringStorage.questionObject93.getQuestion(),QuestionStringStorage.questionObject93.getAnswerA(),
                QuestionStringStorage.questionObject93.getAnswerB(), QuestionStringStorage.questionObject93.getAnswerC(), QuestionStringStorage.questionObject93.getAnswerD(),
                QuestionStringStorage.questionObject93.getGoodAnswer(), QuestionStringStorage.questionObject93.getExplanation());
        questionList.add(question93);

        Question question94 = new Question(UtilStringStorage.mathematics, QuestionStringStorage.questionObject94.getQuestion(),QuestionStringStorage.questionObject94.getAnswerA(),
                QuestionStringStorage.questionObject94.getAnswerB(), QuestionStringStorage.questionObject94.getAnswerC(), QuestionStringStorage.questionObject94.getAnswerD(),
                QuestionStringStorage.questionObject94.getGoodAnswer(), QuestionStringStorage.questionObject94.getExplanation());
        questionList.add(question94);

        Question question95 = new Question(UtilStringStorage.science, QuestionStringStorage.questionObject95.getQuestion(),QuestionStringStorage.questionObject95.getAnswerA(),
                QuestionStringStorage.questionObject95.getAnswerB(), QuestionStringStorage.questionObject95.getAnswerC(), QuestionStringStorage.questionObject95.getAnswerD(),
                QuestionStringStorage.questionObject95.getGoodAnswer(), QuestionStringStorage.questionObject95.getExplanation());
        questionList.add(question95);

        Question question96 = new Question(UtilStringStorage.geography, QuestionStringStorage.questionObject96.getQuestion(),QuestionStringStorage.questionObject96.getAnswerA(),
                QuestionStringStorage.questionObject96.getAnswerB(), QuestionStringStorage.questionObject96.getAnswerC(), QuestionStringStorage.questionObject96.getAnswerD(),
                QuestionStringStorage.questionObject96.getGoodAnswer(), QuestionStringStorage.questionObject96.getExplanation());
        questionList.add(question96);

        Question question97 = new Question(UtilStringStorage.internet, QuestionStringStorage.questionObject97.getQuestion(),QuestionStringStorage.questionObject97.getAnswerA(),
                QuestionStringStorage.questionObject97.getAnswerB(), QuestionStringStorage.questionObject97.getAnswerC(), QuestionStringStorage.questionObject97.getAnswerD(),
                QuestionStringStorage.questionObject97.getGoodAnswer(), QuestionStringStorage.questionObject97.getExplanation());
        questionList.add(question97);

        Question question98 = new Question(UtilStringStorage.linguistic, QuestionStringStorage.questionObject98.getQuestion(),QuestionStringStorage.questionObject98.getAnswerA(),
                QuestionStringStorage.questionObject98.getAnswerB(), QuestionStringStorage.questionObject98.getAnswerC(), QuestionStringStorage.questionObject98.getAnswerD(),
                QuestionStringStorage.questionObject98.getGoodAnswer(), QuestionStringStorage.questionObject98.getExplanation());
        questionList.add(question98);

        Question question99 = new Question(UtilStringStorage.geography, QuestionStringStorage.questionObject99.getQuestion(),QuestionStringStorage.questionObject99.getAnswerA(),
                QuestionStringStorage.questionObject99.getAnswerB(), QuestionStringStorage.questionObject99.getAnswerC(), QuestionStringStorage.questionObject99.getAnswerD(),
                QuestionStringStorage.questionObject99.getGoodAnswer(), QuestionStringStorage.questionObject99.getExplanation());
        questionList.add(question99);

        Question question100 = new Question(UtilStringStorage.economy, QuestionStringStorage.questionObject100.getQuestion(),QuestionStringStorage.questionObject100.getAnswerA(),
                QuestionStringStorage.questionObject100.getAnswerB(), QuestionStringStorage.questionObject100.getAnswerC(), QuestionStringStorage.questionObject100.getAnswerD(),
                QuestionStringStorage.questionObject100.getGoodAnswer(), QuestionStringStorage.questionObject100.getExplanation());
        questionList.add(question100);

        Question question101 = new Question(UtilStringStorage.science, QuestionStringStorage.questionObject101.getQuestion(),QuestionStringStorage.questionObject101.getAnswerA(),
                QuestionStringStorage.questionObject101.getAnswerB(), QuestionStringStorage.questionObject101.getAnswerC(), QuestionStringStorage.questionObject101.getAnswerD(),
                QuestionStringStorage.questionObject101.getGoodAnswer(), QuestionStringStorage.questionObject101.getExplanation());
        questionList.add(question101);

        Question question102 = new Question(UtilStringStorage.literature, QuestionStringStorage.questionObject102.getQuestion(),QuestionStringStorage.questionObject102.getAnswerA(),
                QuestionStringStorage.questionObject102.getAnswerB(), QuestionStringStorage.questionObject102.getAnswerC(), QuestionStringStorage.questionObject102.getAnswerD(),
                QuestionStringStorage.questionObject102.getGoodAnswer(), QuestionStringStorage.questionObject102.getExplanation());
        questionList.add(question102);

        Question question103 = new Question(UtilStringStorage.humanBody, QuestionStringStorage.questionObject103.getQuestion(),QuestionStringStorage.questionObject103.getAnswerA(),
                QuestionStringStorage.questionObject103.getAnswerB(), QuestionStringStorage.questionObject103.getAnswerC(), QuestionStringStorage.questionObject103.getAnswerD(),
                QuestionStringStorage.questionObject103.getGoodAnswer(), QuestionStringStorage.questionObject103.getExplanation());
        questionList.add(question103);

        Question question104 = new Question(UtilStringStorage.geography, QuestionStringStorage.questionObject104.getQuestion(),QuestionStringStorage.questionObject104.getAnswerA(),
                QuestionStringStorage.questionObject104.getAnswerB(), QuestionStringStorage.questionObject104.getAnswerC(), QuestionStringStorage.questionObject104.getAnswerD(),
                QuestionStringStorage.questionObject104.getGoodAnswer(), QuestionStringStorage.questionObject104.getExplanation());
        questionList.add(question104);

        Question question105 = new Question(UtilStringStorage.videoGames, QuestionStringStorage.questionObject105.getQuestion(),QuestionStringStorage.questionObject105.getAnswerA(),
                QuestionStringStorage.questionObject105.getAnswerB(), QuestionStringStorage.questionObject105.getAnswerC(), QuestionStringStorage.questionObject105.getAnswerD(),
                QuestionStringStorage.questionObject105.getGoodAnswer(), QuestionStringStorage.questionObject105.getExplanation());
        questionList.add(question105);

        Question question106 = new Question(UtilStringStorage.internet, QuestionStringStorage.questionObject106.getQuestion(),QuestionStringStorage.questionObject106.getAnswerA(),
                QuestionStringStorage.questionObject106.getAnswerB(), QuestionStringStorage.questionObject106.getAnswerC(), QuestionStringStorage.questionObject106.getAnswerD(),
                QuestionStringStorage.questionObject106.getGoodAnswer(), QuestionStringStorage.questionObject106.getExplanation());
        questionList.add(question106);

        Question question107 = new Question(UtilStringStorage.flags, QuestionStringStorage.questionObject107.getQuestion(),QuestionStringStorage.questionObject107.getAnswerA(),
                QuestionStringStorage.questionObject107.getAnswerB(), QuestionStringStorage.questionObject107.getAnswerC(), QuestionStringStorage.questionObject107.getAnswerD(),
                QuestionStringStorage.questionObject107.getGoodAnswer(), QuestionStringStorage.questionObject107.getExplanation());
        questionList.add(question107);

        Question question108 = new Question(UtilStringStorage.paleontology, QuestionStringStorage.questionObject108.getQuestion(),QuestionStringStorage.questionObject108.getAnswerA(),
                QuestionStringStorage.questionObject108.getAnswerB(), QuestionStringStorage.questionObject108.getAnswerC(), QuestionStringStorage.questionObject108.getAnswerD(),
                QuestionStringStorage.questionObject108.getGoodAnswer(), QuestionStringStorage.questionObject108.getExplanation());
        questionList.add(question108);

        Question question109 = new Question(UtilStringStorage.monument, QuestionStringStorage.questionObject109.getQuestion(),QuestionStringStorage.questionObject109.getAnswerA(),
                QuestionStringStorage.questionObject109.getAnswerB(), QuestionStringStorage.questionObject109.getAnswerC(), QuestionStringStorage.questionObject109.getAnswerD(),
                QuestionStringStorage.questionObject109.getGoodAnswer(), QuestionStringStorage.questionObject109.getExplanation());
        questionList.add(question109);

        Question question110 = new Question(UtilStringStorage.geography, QuestionStringStorage.questionObject110.getQuestion(),QuestionStringStorage.questionObject110.getAnswerA(),
                QuestionStringStorage.questionObject110.getAnswerB(), QuestionStringStorage.questionObject110.getAnswerC(), QuestionStringStorage.questionObject110.getAnswerD(),
                QuestionStringStorage.questionObject110.getGoodAnswer(), QuestionStringStorage.questionObject110.getExplanation());
        questionList.add(question110);

        Question question111 = new Question(UtilStringStorage.plants, QuestionStringStorage.questionObject111.getQuestion(),QuestionStringStorage.questionObject111.getAnswerA(),
                QuestionStringStorage.questionObject111.getAnswerB(), QuestionStringStorage.questionObject111.getAnswerC(), QuestionStringStorage.questionObject111.getAnswerD(),
                QuestionStringStorage.questionObject111.getGoodAnswer(), QuestionStringStorage.questionObject111.getExplanation());
        questionList.add(question111);

        Question question112 = new Question(UtilStringStorage.culture, QuestionStringStorage.questionObject112.getQuestion(),QuestionStringStorage.questionObject112.getAnswerA(),
                QuestionStringStorage.questionObject112.getAnswerB(), QuestionStringStorage.questionObject112.getAnswerC(), QuestionStringStorage.questionObject112.getAnswerD(),
                QuestionStringStorage.questionObject112.getGoodAnswer(), QuestionStringStorage.questionObject112.getExplanation());
        questionList.add(question112);

        Question question113 = new Question(UtilStringStorage.mythology, QuestionStringStorage.questionObject113.getQuestion(),QuestionStringStorage.questionObject113.getAnswerA(),
                QuestionStringStorage.questionObject113.getAnswerB(), QuestionStringStorage.questionObject113.getAnswerC(), QuestionStringStorage.questionObject113.getAnswerD(),
                QuestionStringStorage.questionObject113.getGoodAnswer(), QuestionStringStorage.questionObject113.getExplanation());
        questionList.add(question113);

        Question question114 = new Question(UtilStringStorage.mythology, QuestionStringStorage.questionObject114.getQuestion(),QuestionStringStorage.questionObject114.getAnswerA(),
                QuestionStringStorage.questionObject114.getAnswerB(), QuestionStringStorage.questionObject114.getAnswerC(), QuestionStringStorage.questionObject114.getAnswerD(),
                QuestionStringStorage.questionObject114.getGoodAnswer(), QuestionStringStorage.questionObject114.getExplanation());
        questionList.add(question114);

        Question question115 = new Question(UtilStringStorage.monument, QuestionStringStorage.questionObject115.getQuestion(),QuestionStringStorage.questionObject115.getAnswerA(),
                QuestionStringStorage.questionObject115.getAnswerB(), QuestionStringStorage.questionObject115.getAnswerC(), QuestionStringStorage.questionObject115.getAnswerD(),
                QuestionStringStorage.questionObject115.getGoodAnswer(), QuestionStringStorage.questionObject115.getExplanation());
        questionList.add(question115);

        Question question116 = new Question(UtilStringStorage.invention, QuestionStringStorage.questionObject116.getQuestion(),QuestionStringStorage.questionObject116.getAnswerA(),
                QuestionStringStorage.questionObject116.getAnswerB(), QuestionStringStorage.questionObject116.getAnswerC(), QuestionStringStorage.questionObject116.getAnswerD(),
                QuestionStringStorage.questionObject116.getGoodAnswer(), QuestionStringStorage.questionObject116.getExplanation());
        questionList.add(question116);

        Question question117 = new Question(UtilStringStorage.monument, QuestionStringStorage.questionObject117.getQuestion(),QuestionStringStorage.questionObject117.getAnswerA(),
                QuestionStringStorage.questionObject117.getAnswerB(), QuestionStringStorage.questionObject117.getAnswerC(), QuestionStringStorage.questionObject117.getAnswerD(),
                QuestionStringStorage.questionObject117.getGoodAnswer(), QuestionStringStorage.questionObject117.getExplanation());
        questionList.add(question117);

        Question question118 = new Question(UtilStringStorage.animals, QuestionStringStorage.questionObject118.getQuestion(),QuestionStringStorage.questionObject118.getAnswerA(),
                QuestionStringStorage.questionObject118.getAnswerB(), QuestionStringStorage.questionObject118.getAnswerC(), QuestionStringStorage.questionObject118.getAnswerD(),
                QuestionStringStorage.questionObject118.getGoodAnswer(), QuestionStringStorage.questionObject118.getExplanation());
        questionList.add(question118);

        Question question119 = new Question(UtilStringStorage.geography, QuestionStringStorage.questionObject119.getQuestion(),QuestionStringStorage.questionObject119.getAnswerA(),
                QuestionStringStorage.questionObject119.getAnswerB(), QuestionStringStorage.questionObject119.getAnswerC(), QuestionStringStorage.questionObject119.getAnswerD(),
                QuestionStringStorage.questionObject119.getGoodAnswer(), QuestionStringStorage.questionObject119.getExplanation());
        questionList.add(question119);

        Question question120 = new Question(UtilStringStorage.space, QuestionStringStorage.questionObject120.getQuestion(),QuestionStringStorage.questionObject120.getAnswerA(),
                QuestionStringStorage.questionObject120.getAnswerB(), QuestionStringStorage.questionObject120.getAnswerC(), QuestionStringStorage.questionObject120.getAnswerD(),
                QuestionStringStorage.questionObject120.getGoodAnswer(), QuestionStringStorage.questionObject120.getExplanation());
        questionList.add(question120);

        Question question121 = new Question(UtilStringStorage.records, QuestionStringStorage.questionObject121.getQuestion(),QuestionStringStorage.questionObject121.getAnswerA(),
                QuestionStringStorage.questionObject121.getAnswerB(), QuestionStringStorage.questionObject121.getAnswerC(), QuestionStringStorage.questionObject121.getAnswerD(),
                QuestionStringStorage.questionObject121.getGoodAnswer(), QuestionStringStorage.questionObject121.getExplanation());
        questionList.add(question121);

        Question question122 = new Question(UtilStringStorage.society, QuestionStringStorage.questionObject122.getQuestion(),QuestionStringStorage.questionObject122.getAnswerA(),
                QuestionStringStorage.questionObject122.getAnswerB(), QuestionStringStorage.questionObject122.getAnswerC(), QuestionStringStorage.questionObject122.getAnswerD(),
                QuestionStringStorage.questionObject122.getGoodAnswer(), QuestionStringStorage.questionObject122.getExplanation());
        questionList.add(question122);

        Question question123 = new Question(UtilStringStorage.economy, QuestionStringStorage.questionObject123.getQuestion(),QuestionStringStorage.questionObject123.getAnswerA(),
                QuestionStringStorage.questionObject123.getAnswerB(), QuestionStringStorage.questionObject123.getAnswerC(), QuestionStringStorage.questionObject123.getAnswerD(),
                QuestionStringStorage.questionObject123.getGoodAnswer(), QuestionStringStorage.questionObject123.getExplanation());
        questionList.add(question123);

        Question question124 = new Question(UtilStringStorage.food, QuestionStringStorage.questionObject124.getQuestion(),QuestionStringStorage.questionObject124.getAnswerA(),
                QuestionStringStorage.questionObject124.getAnswerB(), QuestionStringStorage.questionObject124.getAnswerC(), QuestionStringStorage.questionObject124.getAnswerD(),
                QuestionStringStorage.questionObject124.getGoodAnswer(), QuestionStringStorage.questionObject124.getExplanation());
        questionList.add(question124);

        Question question125 = new Question(UtilStringStorage.food, QuestionStringStorage.questionObject125.getQuestion(),QuestionStringStorage.questionObject125.getAnswerA(),
                QuestionStringStorage.questionObject125.getAnswerB(), QuestionStringStorage.questionObject125.getAnswerC(), QuestionStringStorage.questionObject125.getAnswerD(),
                QuestionStringStorage.questionObject125.getGoodAnswer(), QuestionStringStorage.questionObject125.getExplanation());
        questionList.add(question125);

        Question question126 = new Question(UtilStringStorage.plants, QuestionStringStorage.questionObject126.getQuestion(),QuestionStringStorage.questionObject126.getAnswerA(),
                QuestionStringStorage.questionObject126.getAnswerB(), QuestionStringStorage.questionObject126.getAnswerC(), QuestionStringStorage.questionObject126.getAnswerD(),
                QuestionStringStorage.questionObject126.getGoodAnswer(), QuestionStringStorage.questionObject126.getExplanation());
        questionList.add(question126);

        Question question127 = new Question(UtilStringStorage.nature, QuestionStringStorage.questionObject127.getQuestion(),QuestionStringStorage.questionObject127.getAnswerA(),
                QuestionStringStorage.questionObject127.getAnswerB(), QuestionStringStorage.questionObject127.getAnswerC(), QuestionStringStorage.questionObject127.getAnswerD(),
                QuestionStringStorage.questionObject127.getGoodAnswer(), QuestionStringStorage.questionObject127.getExplanation());
        questionList.add(question127);

        Question question128 = new Question(UtilStringStorage.linguistic, QuestionStringStorage.questionObject128.getQuestion(),QuestionStringStorage.questionObject128.getAnswerA(),
                QuestionStringStorage.questionObject128.getAnswerB(), QuestionStringStorage.questionObject128.getAnswerC(), QuestionStringStorage.questionObject128.getAnswerD(),
                QuestionStringStorage.questionObject128.getGoodAnswer(), QuestionStringStorage.questionObject128.getExplanation());
        questionList.add(question128);

        Question question129 = new Question(UtilStringStorage.music, QuestionStringStorage.questionObject129.getQuestion(),QuestionStringStorage.questionObject129.getAnswerA(),
                QuestionStringStorage.questionObject129.getAnswerB(), QuestionStringStorage.questionObject129.getAnswerC(), QuestionStringStorage.questionObject129.getAnswerD(),
                QuestionStringStorage.questionObject129.getGoodAnswer(), QuestionStringStorage.questionObject129.getExplanation());
        questionList.add(question129);

        Question question130 = new Question(UtilStringStorage.food, QuestionStringStorage.questionObject130.getQuestion(),QuestionStringStorage.questionObject130.getAnswerA(),
                QuestionStringStorage.questionObject130.getAnswerB(), QuestionStringStorage.questionObject130.getAnswerC(), QuestionStringStorage.questionObject130.getAnswerD(),
                QuestionStringStorage.questionObject130.getGoodAnswer(), QuestionStringStorage.questionObject130.getExplanation());
        questionList.add(question130);

        Question question131 = new Question(UtilStringStorage.food, QuestionStringStorage.questionObject131.getQuestion(),QuestionStringStorage.questionObject131.getAnswerA(),
                QuestionStringStorage.questionObject131.getAnswerB(), QuestionStringStorage.questionObject131.getAnswerC(), QuestionStringStorage.questionObject131.getAnswerD(),
                QuestionStringStorage.questionObject131.getGoodAnswer(), QuestionStringStorage.questionObject131.getExplanation());
        questionList.add(question131);

        Question question132 = new Question(UtilStringStorage.historia, QuestionStringStorage.questionObject132.getQuestion(),QuestionStringStorage.questionObject132.getAnswerA(),
                QuestionStringStorage.questionObject132.getAnswerB(), QuestionStringStorage.questionObject132.getAnswerC(), QuestionStringStorage.questionObject132.getAnswerD(),
                QuestionStringStorage.questionObject132.getGoodAnswer(), QuestionStringStorage.questionObject132.getExplanation());
        questionList.add(question132);

        Question question133 = new Question(UtilStringStorage.linguistic, QuestionStringStorage.questionObject133.getQuestion(),QuestionStringStorage.questionObject133.getAnswerA(),
                QuestionStringStorage.questionObject133.getAnswerB(), QuestionStringStorage.questionObject133.getAnswerC(), QuestionStringStorage.questionObject133.getAnswerD(),
                QuestionStringStorage.questionObject133.getGoodAnswer(), QuestionStringStorage.questionObject133.getExplanation());
        questionList.add(question133);

        Question question134 = new Question(UtilStringStorage.cinema, QuestionStringStorage.questionObject134.getQuestion(),QuestionStringStorage.questionObject134.getAnswerA(),
                QuestionStringStorage.questionObject134.getAnswerB(), QuestionStringStorage.questionObject134.getAnswerC(), QuestionStringStorage.questionObject134.getAnswerD(),
                QuestionStringStorage.questionObject134.getGoodAnswer(), QuestionStringStorage.questionObject134.getExplanation());
        questionList.add(question134);

        Question question135 = new Question(UtilStringStorage.science, QuestionStringStorage.questionObject135.getQuestion(),QuestionStringStorage.questionObject135.getAnswerA(),
                QuestionStringStorage.questionObject135.getAnswerB(), QuestionStringStorage.questionObject135.getAnswerC(), QuestionStringStorage.questionObject135.getAnswerD(),
                QuestionStringStorage.questionObject135.getGoodAnswer(), QuestionStringStorage.questionObject135.getExplanation());
        questionList.add(question135);

        Question question136 = new Question(UtilStringStorage.mathematics, QuestionStringStorage.questionObject136.getQuestion(),QuestionStringStorage.questionObject136.getAnswerA(),
                QuestionStringStorage.questionObject136.getAnswerB(), QuestionStringStorage.questionObject136.getAnswerC(), QuestionStringStorage.questionObject136.getAnswerD(),
                QuestionStringStorage.questionObject136.getGoodAnswer(), QuestionStringStorage.questionObject136.getExplanation());
        questionList.add(question136);

        Question question137 = new Question(UtilStringStorage.linguistic, QuestionStringStorage.questionObject137.getQuestion(),QuestionStringStorage.questionObject137.getAnswerA(),
                QuestionStringStorage.questionObject137.getAnswerB(), QuestionStringStorage.questionObject137.getAnswerC(), QuestionStringStorage.questionObject137.getAnswerD(),
                QuestionStringStorage.questionObject137.getGoodAnswer(), QuestionStringStorage.questionObject137.getExplanation());
        questionList.add(question137);

        Question question138 = new Question(UtilStringStorage.flags, QuestionStringStorage.questionObject138.getQuestion(),QuestionStringStorage.questionObject138.getAnswerA(),
                QuestionStringStorage.questionObject138.getAnswerB(), QuestionStringStorage.questionObject138.getAnswerC(), QuestionStringStorage.questionObject138.getAnswerD(),
                QuestionStringStorage.questionObject138.getGoodAnswer(), QuestionStringStorage.questionObject138.getExplanation());
        questionList.add(question138);

        Question question139 = new Question(UtilStringStorage.videoGames, QuestionStringStorage.questionObject139.getQuestion(),QuestionStringStorage.questionObject139.getAnswerA(),
                QuestionStringStorage.questionObject139.getAnswerB(), QuestionStringStorage.questionObject139.getAnswerC(), QuestionStringStorage.questionObject139.getAnswerD(),
                QuestionStringStorage.questionObject139.getGoodAnswer(), QuestionStringStorage.questionObject139.getExplanation());
        questionList.add(question139);

        Question question140 = new Question(UtilStringStorage.society, QuestionStringStorage.questionObject140.getQuestion(),QuestionStringStorage.questionObject140.getAnswerA(),
                QuestionStringStorage.questionObject140.getAnswerB(), QuestionStringStorage.questionObject140.getAnswerC(), QuestionStringStorage.questionObject140.getAnswerD(),
                QuestionStringStorage.questionObject140.getGoodAnswer(), QuestionStringStorage.questionObject140.getExplanation());
        questionList.add(question140);

        Question question141 = new Question(UtilStringStorage.monument, QuestionStringStorage.questionObject141.getQuestion(),QuestionStringStorage.questionObject141.getAnswerA(),
                QuestionStringStorage.questionObject141.getAnswerB(), QuestionStringStorage.questionObject141.getAnswerC(), QuestionStringStorage.questionObject141.getAnswerD(),
                QuestionStringStorage.questionObject141.getGoodAnswer(), QuestionStringStorage.questionObject141.getExplanation());
        questionList.add(question141);

        Question question142 = new Question(UtilStringStorage.science, QuestionStringStorage.questionObject142.getQuestion(),QuestionStringStorage.questionObject142.getAnswerA(),
                QuestionStringStorage.questionObject142.getAnswerB(), QuestionStringStorage.questionObject142.getAnswerC(), QuestionStringStorage.questionObject142.getAnswerD(),
                QuestionStringStorage.questionObject142.getGoodAnswer(), QuestionStringStorage.questionObject142.getExplanation());
        questionList.add(question142);

        Question question143 = new Question(UtilStringStorage.economy, QuestionStringStorage.questionObject143.getQuestion(),QuestionStringStorage.questionObject143.getAnswerA(),
                QuestionStringStorage.questionObject143.getAnswerB(), QuestionStringStorage.questionObject143.getAnswerC(), QuestionStringStorage.questionObject143.getAnswerD(),
                QuestionStringStorage.questionObject143.getGoodAnswer(), QuestionStringStorage.questionObject143.getExplanation());
        questionList.add(question143);

        Question question144 = new Question(UtilStringStorage.music, QuestionStringStorage.questionObject144.getQuestion(),QuestionStringStorage.questionObject144.getAnswerA(),
                QuestionStringStorage.questionObject144.getAnswerB(), QuestionStringStorage.questionObject144.getAnswerC(), QuestionStringStorage.questionObject144.getAnswerD(),
                QuestionStringStorage.questionObject144.getGoodAnswer(), QuestionStringStorage.questionObject144.getExplanation());
        questionList.add(question144);

        Question question145 = new Question(UtilStringStorage.mathematics, QuestionStringStorage.questionObject145.getQuestion(),QuestionStringStorage.questionObject145.getAnswerA(),
                QuestionStringStorage.questionObject145.getAnswerB(), QuestionStringStorage.questionObject145.getAnswerC(), QuestionStringStorage.questionObject145.getAnswerD(),
                QuestionStringStorage.questionObject145.getGoodAnswer(), QuestionStringStorage.questionObject145.getExplanation());
        questionList.add(question145);

        Question question146 = new Question(UtilStringStorage.records, QuestionStringStorage.questionObject146.getQuestion(),QuestionStringStorage.questionObject146.getAnswerA(),
                QuestionStringStorage.questionObject146.getAnswerB(), QuestionStringStorage.questionObject146.getAnswerC(), QuestionStringStorage.questionObject146.getAnswerD(),
                QuestionStringStorage.questionObject146.getGoodAnswer(), QuestionStringStorage.questionObject146.getExplanation());
        questionList.add(question146);

        Question question147 = new Question(UtilStringStorage.nature, QuestionStringStorage.questionObject147.getQuestion(),QuestionStringStorage.questionObject147.getAnswerA(),
                QuestionStringStorage.questionObject147.getAnswerB(), QuestionStringStorage.questionObject147.getAnswerC(), QuestionStringStorage.questionObject147.getAnswerD(),
                QuestionStringStorage.questionObject147.getGoodAnswer(), QuestionStringStorage.questionObject147.getExplanation());
        questionList.add(question147);

        Question question148 = new Question(UtilStringStorage.invention, QuestionStringStorage.questionObject148.getQuestion(),QuestionStringStorage.questionObject148.getAnswerA(),
                QuestionStringStorage.questionObject148.getAnswerB(), QuestionStringStorage.questionObject148.getAnswerC(), QuestionStringStorage.questionObject148.getAnswerD(),
                QuestionStringStorage.questionObject148.getGoodAnswer(), QuestionStringStorage.questionObject148.getExplanation());
        questionList.add(question148);

        Question question149 = new Question(UtilStringStorage.law, QuestionStringStorage.questionObject149.getQuestion(),QuestionStringStorage.questionObject149.getAnswerA(),
                QuestionStringStorage.questionObject149.getAnswerB(), QuestionStringStorage.questionObject149.getAnswerC(), QuestionStringStorage.questionObject149.getAnswerD(),
                QuestionStringStorage.questionObject149.getGoodAnswer(), QuestionStringStorage.questionObject149.getExplanation());
        questionList.add(question149);

        Question question150 = new Question(UtilStringStorage.plants, QuestionStringStorage.questionObject150.getQuestion(),QuestionStringStorage.questionObject150.getAnswerA(),
                QuestionStringStorage.questionObject150.getAnswerB(), QuestionStringStorage.questionObject150.getAnswerC(), QuestionStringStorage.questionObject150.getAnswerD(),
                QuestionStringStorage.questionObject150.getGoodAnswer(), QuestionStringStorage.questionObject150.getExplanation());
        questionList.add(question150);

        Question question151 = new Question(UtilStringStorage.geography, QuestionStringStorage.questionObject151.getQuestion(),QuestionStringStorage.questionObject151.getAnswerA(),
                QuestionStringStorage.questionObject151.getAnswerB(), QuestionStringStorage.questionObject151.getAnswerC(), QuestionStringStorage.questionObject151.getAnswerD(),
                QuestionStringStorage.questionObject151.getGoodAnswer(), QuestionStringStorage.questionObject151.getExplanation());
        questionList.add(question151);

        Question question152 = new Question(UtilStringStorage.historia, QuestionStringStorage.questionObject152.getQuestion(),QuestionStringStorage.questionObject152.getAnswerA(),
                QuestionStringStorage.questionObject152.getAnswerB(), QuestionStringStorage.questionObject152.getAnswerC(), QuestionStringStorage.questionObject152.getAnswerD(),
                QuestionStringStorage.questionObject152.getGoodAnswer(), QuestionStringStorage.questionObject152.getExplanation());
        questionList.add(question152);

        Question question153 = new Question(UtilStringStorage.linguistic, QuestionStringStorage.questionObject153.getQuestion(),QuestionStringStorage.questionObject153.getAnswerA(),
                QuestionStringStorage.questionObject153.getAnswerB(), QuestionStringStorage.questionObject153.getAnswerC(), QuestionStringStorage.questionObject153.getAnswerD(),
                QuestionStringStorage.questionObject153.getGoodAnswer(), QuestionStringStorage.questionObject153.getExplanation());
        questionList.add(question153);

        Question question154 = new Question(UtilStringStorage.animals, QuestionStringStorage.questionObject154.getQuestion(),QuestionStringStorage.questionObject154.getAnswerA(),
                QuestionStringStorage.questionObject154.getAnswerB(), QuestionStringStorage.questionObject154.getAnswerC(), QuestionStringStorage.questionObject154.getAnswerD(),
                QuestionStringStorage.questionObject154.getGoodAnswer(), QuestionStringStorage.questionObject154.getExplanation());
        questionList.add(question154);

        Question question155 = new Question(UtilStringStorage.insolite, QuestionStringStorage.questionObject155.getQuestion(),QuestionStringStorage.questionObject155.getAnswerA(),
                QuestionStringStorage.questionObject155.getAnswerB(), QuestionStringStorage.questionObject155.getAnswerC(), QuestionStringStorage.questionObject155.getAnswerD(),
                QuestionStringStorage.questionObject155.getGoodAnswer(), QuestionStringStorage.questionObject155.getExplanation());
        questionList.add(question155);

        Question question156 = new Question(UtilStringStorage.paleontology, QuestionStringStorage.questionObject156.getQuestion(),QuestionStringStorage.questionObject156.getAnswerA(),
                QuestionStringStorage.questionObject156.getAnswerB(), QuestionStringStorage.questionObject156.getAnswerC(), QuestionStringStorage.questionObject156.getAnswerD(),
                QuestionStringStorage.questionObject156.getGoodAnswer(), QuestionStringStorage.questionObject156.getExplanation());
        questionList.add(question156);

        Question question157 = new Question(UtilStringStorage.videoGames, QuestionStringStorage.questionObject157.getQuestion(),QuestionStringStorage.questionObject157.getAnswerA(),
                QuestionStringStorage.questionObject157.getAnswerB(), QuestionStringStorage.questionObject157.getAnswerC(), QuestionStringStorage.questionObject157.getAnswerD(),
                QuestionStringStorage.questionObject157.getGoodAnswer(), QuestionStringStorage.questionObject157.getExplanation());
        questionList.add(question157);

        Question question158 = new Question(UtilStringStorage.cinema, QuestionStringStorage.questionObject158.getQuestion(),QuestionStringStorage.questionObject158.getAnswerA(),
                QuestionStringStorage.questionObject158.getAnswerB(), QuestionStringStorage.questionObject158.getAnswerC(), QuestionStringStorage.questionObject158.getAnswerD(),
                QuestionStringStorage.questionObject158.getGoodAnswer(), QuestionStringStorage.questionObject158.getExplanation());
        questionList.add(question158);

        Question question159 = new Question(UtilStringStorage.space, QuestionStringStorage.questionObject159.getQuestion(),QuestionStringStorage.questionObject159.getAnswerA(),
                QuestionStringStorage.questionObject159.getAnswerB(), QuestionStringStorage.questionObject159.getAnswerC(), QuestionStringStorage.questionObject159.getAnswerD(),
                QuestionStringStorage.questionObject159.getGoodAnswer(), QuestionStringStorage.questionObject159.getExplanation());
        questionList.add(question159);

        Question question160 = new Question(UtilStringStorage.plants, QuestionStringStorage.questionObject160.getQuestion(),QuestionStringStorage.questionObject160.getAnswerA(),
                QuestionStringStorage.questionObject160.getAnswerB(), QuestionStringStorage.questionObject160.getAnswerC(), QuestionStringStorage.questionObject160.getAnswerD(),
                QuestionStringStorage.questionObject160.getGoodAnswer(), QuestionStringStorage.questionObject160.getExplanation());
        questionList.add(question160);

        Question question161 = new Question(UtilStringStorage.music, QuestionStringStorage.questionObject161.getQuestion(),QuestionStringStorage.questionObject161.getAnswerA(),
                QuestionStringStorage.questionObject161.getAnswerB(), QuestionStringStorage.questionObject161.getAnswerC(), QuestionStringStorage.questionObject161.getAnswerD(),
                QuestionStringStorage.questionObject161.getGoodAnswer(), QuestionStringStorage.questionObject161.getExplanation());
        questionList.add(question161);

        Question question162 = new Question(UtilStringStorage.literature, QuestionStringStorage.questionObject162.getQuestion(),QuestionStringStorage.questionObject162.getAnswerA(),
                QuestionStringStorage.questionObject162.getAnswerB(), QuestionStringStorage.questionObject162.getAnswerC(), QuestionStringStorage.questionObject162.getAnswerD(),
                QuestionStringStorage.questionObject162.getGoodAnswer(), QuestionStringStorage.questionObject162.getExplanation());
        questionList.add(question162);

        Question question163 = new Question(UtilStringStorage.humanBody, QuestionStringStorage.questionObject163.getQuestion(),QuestionStringStorage.questionObject163.getAnswerA(),
                QuestionStringStorage.questionObject163.getAnswerB(), QuestionStringStorage.questionObject163.getAnswerC(), QuestionStringStorage.questionObject163.getAnswerD(),
                QuestionStringStorage.questionObject163.getGoodAnswer(), QuestionStringStorage.questionObject163.getExplanation());
        questionList.add(question163);

        Question question164 = new Question(UtilStringStorage.records, QuestionStringStorage.questionObject164.getQuestion(),QuestionStringStorage.questionObject164.getAnswerA(),
                QuestionStringStorage.questionObject164.getAnswerB(), QuestionStringStorage.questionObject164.getAnswerC(), QuestionStringStorage.questionObject164.getAnswerD(),
                QuestionStringStorage.questionObject164.getGoodAnswer(), QuestionStringStorage.questionObject164.getExplanation());
        questionList.add(question164);

        Question question165 = new Question(UtilStringStorage.culture, QuestionStringStorage.questionObject165.getQuestion(),QuestionStringStorage.questionObject165.getAnswerA(),
                QuestionStringStorage.questionObject165.getAnswerB(), QuestionStringStorage.questionObject165.getAnswerC(), QuestionStringStorage.questionObject165.getAnswerD(),
                QuestionStringStorage.questionObject165.getGoodAnswer(), QuestionStringStorage.questionObject165.getExplanation());
        questionList.add(question165);

        Question question166 = new Question(UtilStringStorage.law, QuestionStringStorage.questionObject166.getQuestion(),QuestionStringStorage.questionObject166.getAnswerA(),
                QuestionStringStorage.questionObject166.getAnswerB(), QuestionStringStorage.questionObject166.getAnswerC(), QuestionStringStorage.questionObject166.getAnswerD(),
                QuestionStringStorage.questionObject166.getGoodAnswer(), QuestionStringStorage.questionObject166.getExplanation());
        questionList.add(question166);

        Question question167 = new Question(UtilStringStorage.mythology, QuestionStringStorage.questionObject167.getQuestion(),QuestionStringStorage.questionObject167.getAnswerA(),
                QuestionStringStorage.questionObject167.getAnswerB(), QuestionStringStorage.questionObject167.getAnswerC(), QuestionStringStorage.questionObject167.getAnswerD(),
                QuestionStringStorage.questionObject167.getGoodAnswer(), QuestionStringStorage.questionObject167.getExplanation());
        questionList.add(question167);

        Question question168 = new Question(UtilStringStorage.society, QuestionStringStorage.questionObject168.getQuestion(),QuestionStringStorage.questionObject168.getAnswerA(),
                QuestionStringStorage.questionObject168.getAnswerB(), QuestionStringStorage.questionObject168.getAnswerC(), QuestionStringStorage.questionObject168.getAnswerD(),
                QuestionStringStorage.questionObject168.getGoodAnswer(), QuestionStringStorage.questionObject168.getExplanation());
        questionList.add(question168);

        Question question169 = new Question(UtilStringStorage.internet, QuestionStringStorage.questionObject169.getQuestion(),QuestionStringStorage.questionObject169.getAnswerA(),
                QuestionStringStorage.questionObject169.getAnswerB(), QuestionStringStorage.questionObject169.getAnswerC(), QuestionStringStorage.questionObject169.getAnswerD(),
                QuestionStringStorage.questionObject169.getGoodAnswer(), QuestionStringStorage.questionObject169.getExplanation());
        questionList.add(question169);

        Question question170 = new Question(UtilStringStorage.flags, QuestionStringStorage.questionObject170.getQuestion(),QuestionStringStorage.questionObject170.getAnswerA(),
                QuestionStringStorage.questionObject170.getAnswerB(), QuestionStringStorage.questionObject170.getAnswerC(), QuestionStringStorage.questionObject170.getAnswerD(),
                QuestionStringStorage.questionObject170.getGoodAnswer(), QuestionStringStorage.questionObject170.getExplanation());
        questionList.add(question170);

        Question question171 = new Question(UtilStringStorage.sports, QuestionStringStorage.questionObject171.getQuestion(),QuestionStringStorage.questionObject171.getAnswerA(),
                QuestionStringStorage.questionObject171.getAnswerB(), QuestionStringStorage.questionObject171.getAnswerC(), QuestionStringStorage.questionObject171.getAnswerD(),
                QuestionStringStorage.questionObject171.getGoodAnswer(), QuestionStringStorage.questionObject171.getExplanation());
        questionList.add(question171);

        Question question172 = new Question(UtilStringStorage.painting, QuestionStringStorage.questionObject172.getQuestion(),QuestionStringStorage.questionObject172.getAnswerA(),
                QuestionStringStorage.questionObject172.getAnswerB(), QuestionStringStorage.questionObject172.getAnswerC(), QuestionStringStorage.questionObject172.getAnswerD(),
                QuestionStringStorage.questionObject172.getGoodAnswer(), QuestionStringStorage.questionObject172.getExplanation());
        questionList.add(question172);

        Question question173 = new Question(UtilStringStorage.minerals, QuestionStringStorage.questionObject173.getQuestion(),QuestionStringStorage.questionObject173.getAnswerA(),
                QuestionStringStorage.questionObject173.getAnswerB(), QuestionStringStorage.questionObject173.getAnswerC(), QuestionStringStorage.questionObject173.getAnswerD(),
                QuestionStringStorage.questionObject173.getGoodAnswer(), QuestionStringStorage.questionObject173.getExplanation());
        questionList.add(question173);

        Question question174 = new Question(UtilStringStorage.nature, QuestionStringStorage.questionObject174.getQuestion(),QuestionStringStorage.questionObject174.getAnswerA(),
                QuestionStringStorage.questionObject174.getAnswerB(), QuestionStringStorage.questionObject174.getAnswerC(), QuestionStringStorage.questionObject174.getAnswerD(),
                QuestionStringStorage.questionObject174.getGoodAnswer(), QuestionStringStorage.questionObject174.getExplanation());
        questionList.add(question174);

        Question question175 = new Question(UtilStringStorage.invention, QuestionStringStorage.questionObject175.getQuestion(),QuestionStringStorage.questionObject175.getAnswerA(),
                QuestionStringStorage.questionObject175.getAnswerB(), QuestionStringStorage.questionObject175.getAnswerC(), QuestionStringStorage.questionObject175.getAnswerD(),
                QuestionStringStorage.questionObject175.getGoodAnswer(), QuestionStringStorage.questionObject175.getExplanation());
        questionList.add(question175);

        Question question176 = new Question(UtilStringStorage.science, QuestionStringStorage.questionObject176.getQuestion(),QuestionStringStorage.questionObject176.getAnswerA(),
                QuestionStringStorage.questionObject176.getAnswerB(), QuestionStringStorage.questionObject176.getAnswerC(), QuestionStringStorage.questionObject176.getAnswerD(),
                QuestionStringStorage.questionObject176.getGoodAnswer(), QuestionStringStorage.questionObject176.getExplanation());
        questionList.add(question176);

        Question question177 = new Question(UtilStringStorage.monument, QuestionStringStorage.questionObject177.getQuestion(),QuestionStringStorage.questionObject177.getAnswerA(),
                QuestionStringStorage.questionObject177.getAnswerB(), QuestionStringStorage.questionObject177.getAnswerC(), QuestionStringStorage.questionObject177.getAnswerD(),
                QuestionStringStorage.questionObject177.getGoodAnswer(), QuestionStringStorage.questionObject177.getExplanation());
        questionList.add(question177);

        Question question178 = new Question(UtilStringStorage.economy, QuestionStringStorage.questionObject178.getQuestion(),QuestionStringStorage.questionObject178.getAnswerA(),
                QuestionStringStorage.questionObject178.getAnswerB(), QuestionStringStorage.questionObject178.getAnswerC(), QuestionStringStorage.questionObject178.getAnswerD(),
                QuestionStringStorage.questionObject178.getGoodAnswer(), QuestionStringStorage.questionObject178.getExplanation());
        questionList.add(question178);

        Question question179 = new Question(UtilStringStorage.food, QuestionStringStorage.questionObject179.getQuestion(),QuestionStringStorage.questionObject179.getAnswerA(),
                QuestionStringStorage.questionObject179.getAnswerB(), QuestionStringStorage.questionObject179.getAnswerC(), QuestionStringStorage.questionObject179.getAnswerD(),
                QuestionStringStorage.questionObject179.getGoodAnswer(), QuestionStringStorage.questionObject179.getExplanation());
        questionList.add(question179);

        Question question180 = new Question(UtilStringStorage.mathematics, QuestionStringStorage.questionObject180.getQuestion(),QuestionStringStorage.questionObject180.getAnswerA(),
                QuestionStringStorage.questionObject180.getAnswerB(), QuestionStringStorage.questionObject180.getAnswerC(), QuestionStringStorage.questionObject180.getAnswerD(),
                QuestionStringStorage.questionObject180.getGoodAnswer(), QuestionStringStorage.questionObject180.getExplanation());
        questionList.add(question180);

        Question question181 = new Question(UtilStringStorage.insolite, QuestionStringStorage.questionObject181.getQuestion(),QuestionStringStorage.questionObject181.getAnswerA(),
                QuestionStringStorage.questionObject181.getAnswerB(), QuestionStringStorage.questionObject181.getAnswerC(), QuestionStringStorage.questionObject181.getAnswerD(),
                QuestionStringStorage.questionObject181.getGoodAnswer(), QuestionStringStorage.questionObject181.getExplanation());
        questionList.add(question181);

        Question question182 = new Question(UtilStringStorage.paleontology, QuestionStringStorage.questionObject182.getQuestion(),QuestionStringStorage.questionObject182.getAnswerA(),
                QuestionStringStorage.questionObject182.getAnswerB(), QuestionStringStorage.questionObject182.getAnswerC(), QuestionStringStorage.questionObject182.getAnswerD(),
                QuestionStringStorage.questionObject182.getGoodAnswer(), QuestionStringStorage.questionObject182.getExplanation());
        questionList.add(question182);

        Question question183 = new Question(UtilStringStorage.videoGames, QuestionStringStorage.questionObject183.getQuestion(),QuestionStringStorage.questionObject183.getAnswerA(),
                QuestionStringStorage.questionObject183.getAnswerB(), QuestionStringStorage.questionObject183.getAnswerC(), QuestionStringStorage.questionObject183.getAnswerD(),
                QuestionStringStorage.questionObject183.getGoodAnswer(), QuestionStringStorage.questionObject183.getExplanation());
        questionList.add(question183);

        Question question184 = new Question(UtilStringStorage.cinema, QuestionStringStorage.questionObject184.getQuestion(),QuestionStringStorage.questionObject184.getAnswerA(),
                QuestionStringStorage.questionObject184.getAnswerB(), QuestionStringStorage.questionObject184.getAnswerC(), QuestionStringStorage.questionObject184.getAnswerD(),
                QuestionStringStorage.questionObject184.getGoodAnswer(), QuestionStringStorage.questionObject184.getExplanation());
        questionList.add(question184);

        Question question185 = new Question(UtilStringStorage.space, QuestionStringStorage.questionObject185.getQuestion(),QuestionStringStorage.questionObject185.getAnswerA(),
                QuestionStringStorage.questionObject185.getAnswerB(), QuestionStringStorage.questionObject185.getAnswerC(), QuestionStringStorage.questionObject185.getAnswerD(),
                QuestionStringStorage.questionObject185.getGoodAnswer(), QuestionStringStorage.questionObject185.getExplanation());
        questionList.add(question185);

        Question question186 = new Question(UtilStringStorage.culture, QuestionStringStorage.questionObject186.getQuestion(),QuestionStringStorage.questionObject186.getAnswerA(),
                QuestionStringStorage.questionObject186.getAnswerB(), QuestionStringStorage.questionObject186.getAnswerC(), QuestionStringStorage.questionObject186.getAnswerD(),
                QuestionStringStorage.questionObject186.getGoodAnswer(), QuestionStringStorage.questionObject186.getExplanation());
        questionList.add(question186);

        Question question187 = new Question(UtilStringStorage.law, QuestionStringStorage.questionObject187.getQuestion(),QuestionStringStorage.questionObject187.getAnswerA(),
                QuestionStringStorage.questionObject187.getAnswerB(), QuestionStringStorage.questionObject187.getAnswerC(), QuestionStringStorage.questionObject187.getAnswerD(),
                QuestionStringStorage.questionObject187.getGoodAnswer(), QuestionStringStorage.questionObject187.getExplanation());
        questionList.add(question187);

        Question question188 = new Question(UtilStringStorage.mythology, QuestionStringStorage.questionObject188.getQuestion(),QuestionStringStorage.questionObject188.getAnswerA(),
                QuestionStringStorage.questionObject188.getAnswerB(), QuestionStringStorage.questionObject188.getAnswerC(), QuestionStringStorage.questionObject188.getAnswerD(),
                QuestionStringStorage.questionObject188.getGoodAnswer(), QuestionStringStorage.questionObject188.getExplanation());
        questionList.add(question188);

        Question question189 = new Question(UtilStringStorage.internet, QuestionStringStorage.questionObject189.getQuestion(),QuestionStringStorage.questionObject189.getAnswerA(),
                QuestionStringStorage.questionObject189.getAnswerB(), QuestionStringStorage.questionObject189.getAnswerC(), QuestionStringStorage.questionObject189.getAnswerD(),
                QuestionStringStorage.questionObject189.getGoodAnswer(), QuestionStringStorage.questionObject189.getExplanation());
        questionList.add(question189);

        Question question190 = new Question(UtilStringStorage.flags, QuestionStringStorage.questionObject190.getQuestion(),QuestionStringStorage.questionObject190.getAnswerA(),
                QuestionStringStorage.questionObject190.getAnswerB(), QuestionStringStorage.questionObject190.getAnswerC(), QuestionStringStorage.questionObject190.getAnswerD(),
                QuestionStringStorage.questionObject190.getGoodAnswer(), QuestionStringStorage.questionObject190.getExplanation());
        questionList.add(question190);

        Question question191 = new Question(UtilStringStorage.sports, QuestionStringStorage.questionObject191.getQuestion(),QuestionStringStorage.questionObject191.getAnswerA(),
                QuestionStringStorage.questionObject191.getAnswerB(), QuestionStringStorage.questionObject191.getAnswerC(), QuestionStringStorage.questionObject191.getAnswerD(),
                QuestionStringStorage.questionObject191.getGoodAnswer(), QuestionStringStorage.questionObject191.getExplanation());
        questionList.add(question191);

        Question question192 = new Question(UtilStringStorage.painting, QuestionStringStorage.questionObject192.getQuestion(),QuestionStringStorage.questionObject192.getAnswerA(),
                QuestionStringStorage.questionObject192.getAnswerB(), QuestionStringStorage.questionObject192.getAnswerC(), QuestionStringStorage.questionObject192.getAnswerD(),
                QuestionStringStorage.questionObject192.getGoodAnswer(), QuestionStringStorage.questionObject192.getExplanation());
        questionList.add(question192);

        Question question193 = new Question(UtilStringStorage.minerals, QuestionStringStorage.questionObject193.getQuestion(),QuestionStringStorage.questionObject193.getAnswerA(),
                QuestionStringStorage.questionObject193.getAnswerB(), QuestionStringStorage.questionObject193.getAnswerC(), QuestionStringStorage.questionObject193.getAnswerD(),
                QuestionStringStorage.questionObject193.getGoodAnswer(), QuestionStringStorage.questionObject193.getExplanation());
        questionList.add(question193);

        Question question194 = new Question(UtilStringStorage.science, QuestionStringStorage.questionObject194.getQuestion(),QuestionStringStorage.questionObject194.getAnswerA(),
                QuestionStringStorage.questionObject194.getAnswerB(), QuestionStringStorage.questionObject194.getAnswerC(), QuestionStringStorage.questionObject194.getAnswerD(),
                QuestionStringStorage.questionObject194.getGoodAnswer(), QuestionStringStorage.questionObject194.getExplanation());
        questionList.add(question194);

        Question question195 = new Question(UtilStringStorage.monument, QuestionStringStorage.questionObject195.getQuestion(),QuestionStringStorage.questionObject195.getAnswerA(),
                QuestionStringStorage.questionObject195.getAnswerB(), QuestionStringStorage.questionObject195.getAnswerC(), QuestionStringStorage.questionObject195.getAnswerD(),
                QuestionStringStorage.questionObject195.getGoodAnswer(), QuestionStringStorage.questionObject195.getExplanation());
        questionList.add(question195);

        Question question196 = new Question(UtilStringStorage.mathematics, QuestionStringStorage.questionObject196.getQuestion(),QuestionStringStorage.questionObject196.getAnswerA(),
                QuestionStringStorage.questionObject196.getAnswerB(), QuestionStringStorage.questionObject196.getAnswerC(), QuestionStringStorage.questionObject196.getAnswerD(),
                QuestionStringStorage.questionObject196.getGoodAnswer(), QuestionStringStorage.questionObject196.getExplanation());
        questionList.add(question196);

        Question question197 = new Question(UtilStringStorage.painting, QuestionStringStorage.questionObject197.getQuestion(),QuestionStringStorage.questionObject197.getAnswerA(),
                QuestionStringStorage.questionObject197.getAnswerB(), QuestionStringStorage.questionObject197.getAnswerC(), QuestionStringStorage.questionObject197.getAnswerD(),
                QuestionStringStorage.questionObject197.getGoodAnswer(), QuestionStringStorage.questionObject197.getExplanation());
        questionList.add(question197);

        Question question198 = new Question(UtilStringStorage.minerals, QuestionStringStorage.questionObject198.getQuestion(),QuestionStringStorage.questionObject198.getAnswerA(),
                QuestionStringStorage.questionObject198.getAnswerB(), QuestionStringStorage.questionObject198.getAnswerC(), QuestionStringStorage.questionObject198.getAnswerD(),
                QuestionStringStorage.questionObject198.getGoodAnswer(), QuestionStringStorage.questionObject198.getExplanation());
        questionList.add(question198);

        Question question199 = new Question(UtilStringStorage.culture, QuestionStringStorage.questionObject199.getQuestion(),QuestionStringStorage.questionObject199.getAnswerA(),
                QuestionStringStorage.questionObject199.getAnswerB(), QuestionStringStorage.questionObject199.getAnswerC(), QuestionStringStorage.questionObject199.getAnswerD(),
                QuestionStringStorage.questionObject199.getGoodAnswer(), QuestionStringStorage.questionObject199.getExplanation());
        questionList.add(question199);

        Question question200 = new Question(UtilStringStorage.science, QuestionStringStorage.questionObject200.getQuestion(),QuestionStringStorage.questionObject200.getAnswerA(),
                QuestionStringStorage.questionObject200.getAnswerB(), QuestionStringStorage.questionObject200.getAnswerC(), QuestionStringStorage.questionObject200.getAnswerD(),
                QuestionStringStorage.questionObject200.getGoodAnswer(), QuestionStringStorage.questionObject200.getExplanation());
        questionList.add(question200);

    }

    public void checkExternalSourcesOfQuestions()
    {
        checkPersonalizeQuestions();
        checkImportQuestions();
    }

    public void checkPersonalizeQuestions()
    {
        PersonalizeQuestionsHandler.addPersonalizeQuestionsToStringList();
        if(!PersonalizeQuestionsHandler.getPersonalizeQuestionList().isEmpty())
        {
            randomIndex = new Random();
            for (int i = PersonalizeQuestionsHandler.getPersonalizeQuestionList().size(); i > 0; i--)
            {
                int randomQuestionIndex = generateRandomIndex();
                Question question = PersonalizeQuestionsHandler.getPersonalizeQuestionList().remove(randomQuestionIndex);
                questionList.add(question);
            }
        }
    }

    public void checkImportQuestions()
    {
        ImportFileHandler.addImportPersonalizeQuestionsToStringList();
        if(!ImportFileHandler.getImportPersonalizeQuestionList().isEmpty())
        {
            randomIndex = new Random();
            for(int i = ImportFileHandler.getImportPersonalizeQuestionList().size(); i > 0; i--)
            {
                int randomImportQuestionIndex = generateRandomIndexImport();
                Question importQuestion = ImportFileHandler.getImportPersonalizeQuestionList().remove(randomImportQuestionIndex);
                questionList.add(importQuestion);
            }
        }
    }

    public int generateRandomIndex()
    {
        int maxRandom = PersonalizeQuestionsHandler.getPersonalizeQuestionList().size();
        int minRandom = 0;
        return randomIndex.nextInt((maxRandom - 1 - minRandom) + 1) + minRandom;
    }
    public int generateRandomIndexImport()
    {
        int maxRandom = ImportFileHandler.getImportPersonalizeQuestionList().size();
        int minRandom = 0;
        return randomIndex.nextInt((maxRandom - 1 - minRandom) + 1) + minRandom;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

}
