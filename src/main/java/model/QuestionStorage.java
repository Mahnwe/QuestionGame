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

        Question question81 = new Question(UtilStringStorage.economy, QuestionStringStorage.question81,QuestionStringStorage.answerA81,
                QuestionStringStorage.answerB81, QuestionStringStorage.answerC81, QuestionStringStorage.answerD81, QuestionStringStorage.goodAnswer81,
                QuestionStringStorage.explanation81);
        questionList.add(question81);

        Question question82 = new Question(UtilStringStorage.minerals, QuestionStringStorage.question82,QuestionStringStorage.answerA82,
                QuestionStringStorage.answerB82, QuestionStringStorage.answerC82, QuestionStringStorage.answerD82, QuestionStringStorage.goodAnswer82,
                QuestionStringStorage.explanation82);
        questionList.add(question82);

        Question question83 = new Question(UtilStringStorage.space, QuestionStringStorage.question83,QuestionStringStorage.answerA83,
                QuestionStringStorage.answerB83, QuestionStringStorage.answerC83, QuestionStringStorage.answerD83, QuestionStringStorage.goodAnswer83,
                QuestionStringStorage.explanation83);
        questionList.add(question83);

        Question question84 = new Question(UtilStringStorage.animals, QuestionStringStorage.question84,QuestionStringStorage.answerA84,
                QuestionStringStorage.answerB84, QuestionStringStorage.answerC84, QuestionStringStorage.answerD84, QuestionStringStorage.goodAnswer84,
                QuestionStringStorage.explanation84);
        questionList.add(question84);

        Question question85 = new Question(UtilStringStorage.humanBody, QuestionStringStorage.question85,QuestionStringStorage.answerA85,
                QuestionStringStorage.answerB85, QuestionStringStorage.answerC85, QuestionStringStorage.answerD85, QuestionStringStorage.goodAnswer85,
                QuestionStringStorage.explanation85);
        questionList.add(question85);

        Question question86 = new Question(UtilStringStorage.flags, QuestionStringStorage.question86,QuestionStringStorage.answerA86,
                QuestionStringStorage.answerB86, QuestionStringStorage.answerC86, QuestionStringStorage.answerD86, QuestionStringStorage.goodAnswer86,
                QuestionStringStorage.explanation86);
        questionList.add(question86);

        Question question87 = new Question(UtilStringStorage.insolite, QuestionStringStorage.question87,QuestionStringStorage.answerA87,
                QuestionStringStorage.answerB87, QuestionStringStorage.answerC87, QuestionStringStorage.answerD87, QuestionStringStorage.goodAnswer87,
                QuestionStringStorage.explanation87);
        questionList.add(question87);

        Question question88 = new Question(UtilStringStorage.invention, QuestionStringStorage.question88,QuestionStringStorage.answerA88,
                QuestionStringStorage.answerB88, QuestionStringStorage.answerC88, QuestionStringStorage.answerD88, QuestionStringStorage.goodAnswer88,
                QuestionStringStorage.explanation88);
        questionList.add(question88);

        Question question89 = new Question(UtilStringStorage.linguistic, QuestionStringStorage.question89,QuestionStringStorage.answerA89,
                QuestionStringStorage.answerB89, QuestionStringStorage.answerC89, QuestionStringStorage.answerD89, QuestionStringStorage.goodAnswer89,
                QuestionStringStorage.explanation89);
        questionList.add(question89);

        Question question90 = new Question(UtilStringStorage.animals, QuestionStringStorage.question90,QuestionStringStorage.answerA90,
                QuestionStringStorage.answerB90, QuestionStringStorage.answerC90, QuestionStringStorage.answerD90, QuestionStringStorage.goodAnswer90,
                QuestionStringStorage.explanation90);
        questionList.add(question90);

        Question question91 = new Question(UtilStringStorage.videoGames, QuestionStringStorage.question91,QuestionStringStorage.answerA91,
                QuestionStringStorage.answerB91, QuestionStringStorage.answerC91, QuestionStringStorage.answerD91, QuestionStringStorage.goodAnswer91,
                QuestionStringStorage.explanation91);
        questionList.add(question91);

        Question question92 = new Question(UtilStringStorage.cinema, QuestionStringStorage.question92,QuestionStringStorage.answerA92,
                QuestionStringStorage.answerB92, QuestionStringStorage.answerC92, QuestionStringStorage.answerD92, QuestionStringStorage.goodAnswer92,
                QuestionStringStorage.explanation92);
        questionList.add(question92);

        Question question93 = new Question(UtilStringStorage.historia, QuestionStringStorage.question93,QuestionStringStorage.answerA93,
                QuestionStringStorage.answerB93, QuestionStringStorage.answerC93, QuestionStringStorage.answerD93, QuestionStringStorage.goodAnswer93,
                QuestionStringStorage.explanation93);
        questionList.add(question93);

        Question question94 = new Question(UtilStringStorage.mathematics, QuestionStringStorage.question94,QuestionStringStorage.answerA94,
                QuestionStringStorage.answerB94, QuestionStringStorage.answerC94, QuestionStringStorage.answerD94, QuestionStringStorage.goodAnswer94,
                QuestionStringStorage.explanation94);
        questionList.add(question94);

        Question question95 = new Question(UtilStringStorage.science, QuestionStringStorage.question95,QuestionStringStorage.answerA95,
                QuestionStringStorage.answerB95, QuestionStringStorage.answerC95, QuestionStringStorage.answerD95, QuestionStringStorage.goodAnswer95,
                QuestionStringStorage.explanation95);
        questionList.add(question95);

        Question question96 = new Question(UtilStringStorage.geography, QuestionStringStorage.question96,QuestionStringStorage.answerA96,
                QuestionStringStorage.answerB96, QuestionStringStorage.answerC96, QuestionStringStorage.answerD96, QuestionStringStorage.goodAnswer96,
                QuestionStringStorage.explanation96);
        questionList.add(question96);

        Question question97 = new Question(UtilStringStorage.internet, QuestionStringStorage.question97,QuestionStringStorage.answerA97,
                QuestionStringStorage.answerB97, QuestionStringStorage.answerC97, QuestionStringStorage.answerD97, QuestionStringStorage.goodAnswer97,
                QuestionStringStorage.explanation97);
        questionList.add(question97);

        Question question98 = new Question(UtilStringStorage.linguistic, QuestionStringStorage.question98,QuestionStringStorage.answerA98,
                QuestionStringStorage.answerB98, QuestionStringStorage.answerC98, QuestionStringStorage.answerD98, QuestionStringStorage.goodAnswer98,
                QuestionStringStorage.explanation98);
        questionList.add(question98);

        Question question99 = new Question(UtilStringStorage.geography, QuestionStringStorage.question99,QuestionStringStorage.answerA99,
                QuestionStringStorage.answerB99, QuestionStringStorage.answerC99, QuestionStringStorage.answerD99, QuestionStringStorage.goodAnswer99,
                QuestionStringStorage.explanation99);
        questionList.add(question99);

        Question question100 = new Question(UtilStringStorage.economy, QuestionStringStorage.question100,QuestionStringStorage.answerA100,
                QuestionStringStorage.answerB100, QuestionStringStorage.answerC100, QuestionStringStorage.answerD100, QuestionStringStorage.goodAnswer100,
                QuestionStringStorage.explanation100);
        questionList.add(question100);

        Question question101 = new Question(UtilStringStorage.science, QuestionStringStorage.question101,QuestionStringStorage.answerA101,
                QuestionStringStorage.answerB101, QuestionStringStorage.answerC101, QuestionStringStorage.answerD101, QuestionStringStorage.goodAnswer101,
                QuestionStringStorage.explanation101);
        questionList.add(question101);

        Question question102 = new Question(UtilStringStorage.literature, QuestionStringStorage.question102,QuestionStringStorage.answerA102,
                QuestionStringStorage.answerB102, QuestionStringStorage.answerC102, QuestionStringStorage.answerD102, QuestionStringStorage.goodAnswer102,
                QuestionStringStorage.explanation102);
        questionList.add(question102);

        Question question103 = new Question(UtilStringStorage.humanBody, QuestionStringStorage.question103,QuestionStringStorage.answerA103,
                QuestionStringStorage.answerB103, QuestionStringStorage.answerC103, QuestionStringStorage.answerD103, QuestionStringStorage.goodAnswer103,
                QuestionStringStorage.explanation103);
        questionList.add(question103);

        Question question104 = new Question(UtilStringStorage.geography, QuestionStringStorage.question104,QuestionStringStorage.answerA104,
                QuestionStringStorage.answerB104, QuestionStringStorage.answerC104, QuestionStringStorage.answerD104, QuestionStringStorage.goodAnswer104,
                QuestionStringStorage.explanation104);
        questionList.add(question104);

        Question question105 = new Question(UtilStringStorage.videoGames, QuestionStringStorage.question105,QuestionStringStorage.answerA105,
                QuestionStringStorage.answerB105, QuestionStringStorage.answerC105, QuestionStringStorage.answerD105, QuestionStringStorage.goodAnswer105,
                QuestionStringStorage.explanation105);
        questionList.add(question105);

        Question question106 = new Question(UtilStringStorage.internet, QuestionStringStorage.question106,QuestionStringStorage.answerA106,
                QuestionStringStorage.answerB106, QuestionStringStorage.answerC106, QuestionStringStorage.answerD106, QuestionStringStorage.goodAnswer106,
                QuestionStringStorage.explanation106);
        questionList.add(question106);

        Question question107 = new Question(UtilStringStorage.flags, QuestionStringStorage.question107,QuestionStringStorage.answerA107,
                QuestionStringStorage.answerB107, QuestionStringStorage.answerC107, QuestionStringStorage.answerD107, QuestionStringStorage.goodAnswer107,
                QuestionStringStorage.explanation107);
        questionList.add(question107);

        Question question108 = new Question(UtilStringStorage.paleontology, QuestionStringStorage.question108,QuestionStringStorage.answerA108,
                QuestionStringStorage.answerB108, QuestionStringStorage.answerC108, QuestionStringStorage.answerD108, QuestionStringStorage.goodAnswer108,
                QuestionStringStorage.explanation108);
        questionList.add(question108);

        Question question109 = new Question(UtilStringStorage.monument, QuestionStringStorage.question109,QuestionStringStorage.answerA109,
                QuestionStringStorage.answerB109, QuestionStringStorage.answerC109, QuestionStringStorage.answerD109, QuestionStringStorage.goodAnswer109,
                QuestionStringStorage.explanation109);
        questionList.add(question109);

        Question question110 = new Question(UtilStringStorage.geography, QuestionStringStorage.question110,QuestionStringStorage.answerA110,
                QuestionStringStorage.answerB110, QuestionStringStorage.answerC110, QuestionStringStorage.answerD110, QuestionStringStorage.goodAnswer110,
                QuestionStringStorage.explanation110);
        questionList.add(question110);

        Question question111 = new Question(UtilStringStorage.plants, QuestionStringStorage.question111,QuestionStringStorage.answerA111,
                QuestionStringStorage.answerB111, QuestionStringStorage.answerC111, QuestionStringStorage.answerD111, QuestionStringStorage.goodAnswer111,
                QuestionStringStorage.explanation111);
        questionList.add(question111);

        Question question112 = new Question(UtilStringStorage.culture, QuestionStringStorage.question112,QuestionStringStorage.answerA112,
                QuestionStringStorage.answerB112, QuestionStringStorage.answerC112, QuestionStringStorage.answerD112, QuestionStringStorage.goodAnswer112,
                QuestionStringStorage.explanation112);
        questionList.add(question112);

        Question question113 = new Question(UtilStringStorage.mythology, QuestionStringStorage.question113,QuestionStringStorage.answerA113,
                QuestionStringStorage.answerB113, QuestionStringStorage.answerC113, QuestionStringStorage.answerD113, QuestionStringStorage.goodAnswer113,
                QuestionStringStorage.explanation113);
        questionList.add(question113);

        Question question114 = new Question(UtilStringStorage.mythology, QuestionStringStorage.question114,QuestionStringStorage.answerA114,
                QuestionStringStorage.answerB114, QuestionStringStorage.answerC114, QuestionStringStorage.answerD114, QuestionStringStorage.goodAnswer114,
                QuestionStringStorage.explanation114);
        questionList.add(question114);

        Question question115 = new Question(UtilStringStorage.monument, QuestionStringStorage.question115,QuestionStringStorage.answerA115,
                QuestionStringStorage.answerB115, QuestionStringStorage.answerC115, QuestionStringStorage.answerD115, QuestionStringStorage.goodAnswer115,
                QuestionStringStorage.explanation115);
        questionList.add(question115);

        Question question116 = new Question(UtilStringStorage.invention, QuestionStringStorage.question116,QuestionStringStorage.answerA116,
                QuestionStringStorage.answerB116, QuestionStringStorage.answerC116, QuestionStringStorage.answerD116, QuestionStringStorage.goodAnswer116,
                QuestionStringStorage.explanation116);
        questionList.add(question116);

        Question question117 = new Question(UtilStringStorage.monument, QuestionStringStorage.question117,QuestionStringStorage.answerA117,
                QuestionStringStorage.answerB117, QuestionStringStorage.answerC117, QuestionStringStorage.answerD117, QuestionStringStorage.goodAnswer117,
                QuestionStringStorage.explanation117);
        questionList.add(question117);

        Question question118 = new Question(UtilStringStorage.animals, QuestionStringStorage.question118,QuestionStringStorage.answerA118,
                QuestionStringStorage.answerB118, QuestionStringStorage.answerC118, QuestionStringStorage.answerD118, QuestionStringStorage.goodAnswer118,
                QuestionStringStorage.explanation118);
        questionList.add(question118);

        Question question119 = new Question(UtilStringStorage.geography, QuestionStringStorage.question119,QuestionStringStorage.answerA119,
                QuestionStringStorage.answerB119, QuestionStringStorage.answerC119, QuestionStringStorage.answerD119, QuestionStringStorage.goodAnswer119,
                QuestionStringStorage.explanation119);
        questionList.add(question119);

        Question question120 = new Question(UtilStringStorage.space, QuestionStringStorage.question120,QuestionStringStorage.answerA120,
                QuestionStringStorage.answerB120, QuestionStringStorage.answerC120, QuestionStringStorage.answerD120, QuestionStringStorage.goodAnswer120,
                QuestionStringStorage.explanation120);
        questionList.add(question120);

        Question question121 = new Question(UtilStringStorage.records, QuestionStringStorage.question121,QuestionStringStorage.answerA121,
                QuestionStringStorage.answerB121, QuestionStringStorage.answerC121, QuestionStringStorage.answerD121, QuestionStringStorage.goodAnswer121,
                QuestionStringStorage.explanation121);
        questionList.add(question121);

        Question question122 = new Question(UtilStringStorage.society, QuestionStringStorage.question122,QuestionStringStorage.answerA122,
                QuestionStringStorage.answerB122, QuestionStringStorage.answerC122, QuestionStringStorage.answerD122, QuestionStringStorage.goodAnswer122,
                QuestionStringStorage.explanation122);
        questionList.add(question122);

        Question question123 = new Question(UtilStringStorage.economy, QuestionStringStorage.question123,QuestionStringStorage.answerA123,
                QuestionStringStorage.answerB123, QuestionStringStorage.answerC123, QuestionStringStorage.answerD123, QuestionStringStorage.goodAnswer123,
                QuestionStringStorage.explanation123);
        questionList.add(question123);

        Question question124 = new Question(UtilStringStorage.food, QuestionStringStorage.question124,QuestionStringStorage.answerA124,
                QuestionStringStorage.answerB124, QuestionStringStorage.answerC124, QuestionStringStorage.answerD124, QuestionStringStorage.goodAnswer124,
                QuestionStringStorage.explanation124);
        questionList.add(question124);

        Question question125 = new Question(UtilStringStorage.food, QuestionStringStorage.question125,QuestionStringStorage.answerA125,
                QuestionStringStorage.answerB125, QuestionStringStorage.answerC125, QuestionStringStorage.answerD125, QuestionStringStorage.goodAnswer125,
                QuestionStringStorage.explanation125);
        questionList.add(question125);

        Question question126 = new Question(UtilStringStorage.plants, QuestionStringStorage.question126,QuestionStringStorage.answerA126,
                QuestionStringStorage.answerB126, QuestionStringStorage.answerC126, QuestionStringStorage.answerD126, QuestionStringStorage.goodAnswer126,
                QuestionStringStorage.explanation126);
        questionList.add(question126);

        Question question127 = new Question(UtilStringStorage.nature, QuestionStringStorage.question127,QuestionStringStorage.answerA127,
                QuestionStringStorage.answerB127, QuestionStringStorage.answerC127, QuestionStringStorage.answerD127, QuestionStringStorage.goodAnswer127,
                QuestionStringStorage.explanation127);
        questionList.add(question127);

        Question question128 = new Question(UtilStringStorage.linguistic, QuestionStringStorage.question128,QuestionStringStorage.answerA128,
                QuestionStringStorage.answerB128, QuestionStringStorage.answerC128, QuestionStringStorage.answerD128, QuestionStringStorage.goodAnswer128,
                QuestionStringStorage.explanation128);
        questionList.add(question128);

        Question question129 = new Question(UtilStringStorage.music, QuestionStringStorage.question129,QuestionStringStorage.answerA129,
                QuestionStringStorage.answerB129, QuestionStringStorage.answerC129, QuestionStringStorage.answerD129, QuestionStringStorage.goodAnswer129,
                QuestionStringStorage.explanation129);
        questionList.add(question129);

        Question question130 = new Question(UtilStringStorage.food, QuestionStringStorage.question130,QuestionStringStorage.answerA130,
                QuestionStringStorage.answerB130, QuestionStringStorage.answerC130, QuestionStringStorage.answerD130, QuestionStringStorage.goodAnswer130,
                QuestionStringStorage.explanation130);
        questionList.add(question130);

        Question question131 = new Question(UtilStringStorage.food, QuestionStringStorage.question131,QuestionStringStorage.answerA131,
                QuestionStringStorage.answerB131, QuestionStringStorage.answerC131, QuestionStringStorage.answerD131, QuestionStringStorage.goodAnswer131,
                QuestionStringStorage.explanation131);
        questionList.add(question131);

        Question question132 = new Question(UtilStringStorage.historia, QuestionStringStorage.question132,QuestionStringStorage.answerA132,
                QuestionStringStorage.answerB132, QuestionStringStorage.answerC132, QuestionStringStorage.answerD132, QuestionStringStorage.goodAnswer132,
                QuestionStringStorage.explanation132);
        questionList.add(question132);

        Question question133 = new Question(UtilStringStorage.linguistic, QuestionStringStorage.question133,QuestionStringStorage.answerA133,
                QuestionStringStorage.answerB133, QuestionStringStorage.answerC133, QuestionStringStorage.answerD133, QuestionStringStorage.goodAnswer133,
                QuestionStringStorage.explanation133);
        questionList.add(question133);

        Question question134 = new Question(UtilStringStorage.cinema, QuestionStringStorage.question134,QuestionStringStorage.answerA134,
                QuestionStringStorage.answerB134, QuestionStringStorage.answerC134, QuestionStringStorage.answerD134, QuestionStringStorage.goodAnswer134,
                QuestionStringStorage.explanation134);
        questionList.add(question134);

        Question question135 = new Question(UtilStringStorage.science, QuestionStringStorage.question135,QuestionStringStorage.answerA135,
                QuestionStringStorage.answerB135, QuestionStringStorage.answerC135, QuestionStringStorage.answerD135, QuestionStringStorage.goodAnswer135,
                QuestionStringStorage.explanation135);
        questionList.add(question135);

        Question question136 = new Question(UtilStringStorage.mathematics, QuestionStringStorage.question136,QuestionStringStorage.answerA136,
                QuestionStringStorage.answerB136, QuestionStringStorage.answerC136, QuestionStringStorage.answerD136, QuestionStringStorage.goodAnswer136,
                QuestionStringStorage.explanation136);
        questionList.add(question136);

        Question question137 = new Question(UtilStringStorage.linguistic, QuestionStringStorage.question137,QuestionStringStorage.answerA137,
                QuestionStringStorage.answerB137, QuestionStringStorage.answerC137, QuestionStringStorage.answerD137, QuestionStringStorage.goodAnswer137,
                QuestionStringStorage.explanation137);
        questionList.add(question137);

        Question question138 = new Question(UtilStringStorage.flags, QuestionStringStorage.question138,QuestionStringStorage.answerA138,
                QuestionStringStorage.answerB138, QuestionStringStorage.answerC138, QuestionStringStorage.answerD138, QuestionStringStorage.goodAnswer138,
                QuestionStringStorage.explanation138);
        questionList.add(question138);

        Question question139 = new Question(UtilStringStorage.videoGames, QuestionStringStorage.question139,QuestionStringStorage.answerA139,
                QuestionStringStorage.answerB139, QuestionStringStorage.answerC139, QuestionStringStorage.answerD139, QuestionStringStorage.goodAnswer139,
                QuestionStringStorage.explanation139);
        questionList.add(question139);

        Question question140 = new Question(UtilStringStorage.society, QuestionStringStorage.question140,QuestionStringStorage.answerA140,
                QuestionStringStorage.answerB140, QuestionStringStorage.answerC140, QuestionStringStorage.answerD140, QuestionStringStorage.goodAnswer140,
                QuestionStringStorage.explanation140);
        questionList.add(question140);

        Question question141 = new Question(UtilStringStorage.monument, QuestionStringStorage.question141,QuestionStringStorage.answerA141,
                QuestionStringStorage.answerB141, QuestionStringStorage.answerC141, QuestionStringStorage.answerD141, QuestionStringStorage.goodAnswer141,
                QuestionStringStorage.explanation141);
        questionList.add(question141);

        Question question142 = new Question(UtilStringStorage.science, QuestionStringStorage.question142,QuestionStringStorage.answerA142,
                QuestionStringStorage.answerB142, QuestionStringStorage.answerC142, QuestionStringStorage.answerD142, QuestionStringStorage.goodAnswer142,
                QuestionStringStorage.explanation142);
        questionList.add(question142);

        Question question143 = new Question(UtilStringStorage.economy, QuestionStringStorage.question143,QuestionStringStorage.answerA143,
                QuestionStringStorage.answerB143, QuestionStringStorage.answerC143, QuestionStringStorage.answerD143, QuestionStringStorage.goodAnswer143,
                QuestionStringStorage.explanation143);
        questionList.add(question143);

        Question question144 = new Question(UtilStringStorage.music, QuestionStringStorage.question144,QuestionStringStorage.answerA144,
                QuestionStringStorage.answerB144, QuestionStringStorage.answerC144, QuestionStringStorage.answerD144, QuestionStringStorage.goodAnswer144,
                QuestionStringStorage.explanation144);
        questionList.add(question144);

        Question question145 = new Question(UtilStringStorage.mathematics, QuestionStringStorage.question145,QuestionStringStorage.answerA145,
                QuestionStringStorage.answerB145, QuestionStringStorage.answerC145, QuestionStringStorage.answerD145, QuestionStringStorage.goodAnswer145,
                QuestionStringStorage.explanation145);
        questionList.add(question145);

        Question question146 = new Question(UtilStringStorage.records, QuestionStringStorage.question146,QuestionStringStorage.answerA146,
                QuestionStringStorage.answerB146, QuestionStringStorage.answerC146, QuestionStringStorage.answerD146, QuestionStringStorage.goodAnswer146,
                QuestionStringStorage.explanation146);
        questionList.add(question146);

        Question question147 = new Question(UtilStringStorage.nature, QuestionStringStorage.question147,QuestionStringStorage.answerA147,
                QuestionStringStorage.answerB147, QuestionStringStorage.answerC147, QuestionStringStorage.answerD147, QuestionStringStorage.goodAnswer147,
                QuestionStringStorage.explanation147);
        questionList.add(question147);

        Question question148 = new Question(UtilStringStorage.invention, QuestionStringStorage.question148,QuestionStringStorage.answerA148,
                QuestionStringStorage.answerB148, QuestionStringStorage.answerC148, QuestionStringStorage.answerD148, QuestionStringStorage.goodAnswer148,
                QuestionStringStorage.explanation148);
        questionList.add(question148);

        Question question149 = new Question(UtilStringStorage.law, QuestionStringStorage.question149,QuestionStringStorage.answerA149,
                QuestionStringStorage.answerB149, QuestionStringStorage.answerC149, QuestionStringStorage.answerD149, QuestionStringStorage.goodAnswer149,
                QuestionStringStorage.explanation149);
        questionList.add(question149);

        Question question150 = new Question(UtilStringStorage.plants, QuestionStringStorage.question150,QuestionStringStorage.answerA150,
                QuestionStringStorage.answerB150, QuestionStringStorage.answerC150, QuestionStringStorage.answerD150, QuestionStringStorage.goodAnswer150,
                QuestionStringStorage.explanation150);
        questionList.add(question150);

        Question question151 = new Question(UtilStringStorage.geography, QuestionStringStorage.question151,QuestionStringStorage.answerA151,
                QuestionStringStorage.answerB151, QuestionStringStorage.answerC151, QuestionStringStorage.answerD151, QuestionStringStorage.goodAnswer151,
                QuestionStringStorage.explanation151);
        questionList.add(question151);

        Question question152 = new Question(UtilStringStorage.historia, QuestionStringStorage.question152,QuestionStringStorage.answerA152,
                QuestionStringStorage.answerB152, QuestionStringStorage.answerC152, QuestionStringStorage.answerD152, QuestionStringStorage.goodAnswer152,
                QuestionStringStorage.explanation152);
        questionList.add(question152);

        Question question153 = new Question(UtilStringStorage.linguistic, QuestionStringStorage.question153,QuestionStringStorage.answerA153,
                QuestionStringStorage.answerB153, QuestionStringStorage.answerC153, QuestionStringStorage.answerD153, QuestionStringStorage.goodAnswer153,
                QuestionStringStorage.explanation153);
        questionList.add(question153);

        Question question154 = new Question(UtilStringStorage.animals, QuestionStringStorage.question154,QuestionStringStorage.answerA154,
                QuestionStringStorage.answerB154, QuestionStringStorage.answerC154, QuestionStringStorage.answerD154, QuestionStringStorage.goodAnswer154,
                QuestionStringStorage.explanation154);
        questionList.add(question154);

        Question question155 = new Question(UtilStringStorage.insolite, QuestionStringStorage.question155,QuestionStringStorage.answerA155,
                QuestionStringStorage.answerB155, QuestionStringStorage.answerC155, QuestionStringStorage.answerD155, QuestionStringStorage.goodAnswer155,
                QuestionStringStorage.explanation155);
        questionList.add(question155);

        Question question156 = new Question(UtilStringStorage.paleontology, QuestionStringStorage.question156,QuestionStringStorage.answerA156,
                QuestionStringStorage.answerB156, QuestionStringStorage.answerC156, QuestionStringStorage.answerD156, QuestionStringStorage.goodAnswer156,
                QuestionStringStorage.explanation156);
        questionList.add(question156);

        Question question157 = new Question(UtilStringStorage.videoGames, QuestionStringStorage.question157,QuestionStringStorage.answerA157,
                QuestionStringStorage.answerB157, QuestionStringStorage.answerC157, QuestionStringStorage.answerD157, QuestionStringStorage.goodAnswer157,
                QuestionStringStorage.explanation157);
        questionList.add(question157);

        Question question158 = new Question(UtilStringStorage.cinema, QuestionStringStorage.question158,QuestionStringStorage.answerA158,
                QuestionStringStorage.answerB158, QuestionStringStorage.answerC158, QuestionStringStorage.answerD158, QuestionStringStorage.goodAnswer158,
                QuestionStringStorage.explanation158);
        questionList.add(question158);

        Question question159 = new Question(UtilStringStorage.space, QuestionStringStorage.question159,QuestionStringStorage.answerA159,
                QuestionStringStorage.answerB159, QuestionStringStorage.answerC159, QuestionStringStorage.answerD159, QuestionStringStorage.goodAnswer159,
                QuestionStringStorage.explanation159);
        questionList.add(question159);

        Question question160 = new Question(UtilStringStorage.plants, QuestionStringStorage.question160,QuestionStringStorage.answerA160,
                QuestionStringStorage.answerB160, QuestionStringStorage.answerC160, QuestionStringStorage.answerD160, QuestionStringStorage.goodAnswer160,
                QuestionStringStorage.explanation160);
        questionList.add(question160);

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
