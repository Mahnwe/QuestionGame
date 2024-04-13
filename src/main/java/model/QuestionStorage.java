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
        Question question1 = new Question(UtilStringStorage.geography, QuestionStringStorage.question1,QuestionStringStorage.answerA1,
                QuestionStringStorage.answerB1, QuestionStringStorage.answerC1, QuestionStringStorage.answerD1, QuestionStringStorage.goodAnswer1,
                QuestionStringStorage.explanation1);
        questionList.add(question1);

        Question question2 = new Question(UtilStringStorage.historia, QuestionStringStorage.question2,QuestionStringStorage.answerA2,
                QuestionStringStorage.answerB2, QuestionStringStorage.answerC2, QuestionStringStorage.answerD2, QuestionStringStorage.goodAnswer2,
                QuestionStringStorage.explanation2);
        questionList.add(question2);

        Question question3 = new Question(UtilStringStorage.linguistic, QuestionStringStorage.question3,QuestionStringStorage.answerA3,
                QuestionStringStorage.answerB3, QuestionStringStorage.answerC3, QuestionStringStorage.answerD3, QuestionStringStorage.goodAnswer3,
                QuestionStringStorage.explanation3);
        questionList.add(question3);

        Question question4 = new Question(UtilStringStorage.geography, QuestionStringStorage.question4,QuestionStringStorage.answerA4,
                QuestionStringStorage.answerB4, QuestionStringStorage.answerC4, QuestionStringStorage.answerD4, QuestionStringStorage.goodAnswer4,
                QuestionStringStorage.explanation4);
        questionList.add(question4);

        Question question5 = new Question(UtilStringStorage.animals, QuestionStringStorage.question5,QuestionStringStorage.answerA5,
                QuestionStringStorage.answerB5, QuestionStringStorage.answerC5, QuestionStringStorage.answerD5, QuestionStringStorage.goodAnswer5,
                QuestionStringStorage.explanation5);
        questionList.add(question5);

        Question question6 = new Question(UtilStringStorage.invention, QuestionStringStorage.question6,QuestionStringStorage.answerA6,
                QuestionStringStorage.answerB6, QuestionStringStorage.answerC6, QuestionStringStorage.answerD6, QuestionStringStorage.goodAnswer6,
                QuestionStringStorage.explanation6);
        questionList.add(question6);

        Question question7 = new Question(UtilStringStorage.linguistic, QuestionStringStorage.question7,QuestionStringStorage.answerA7,
                QuestionStringStorage.answerB7, QuestionStringStorage.answerC7, QuestionStringStorage.answerD7, QuestionStringStorage.goodAnswer7,
                QuestionStringStorage.explanation7);
        questionList.add(question7);

        Question question8 = new Question(UtilStringStorage.insolite, QuestionStringStorage.question8,QuestionStringStorage.answerA8,
                QuestionStringStorage.answerB8, QuestionStringStorage.answerC8, QuestionStringStorage.answerD8, QuestionStringStorage.goodAnswer8,
                QuestionStringStorage.explanation8);
        questionList.add(question8);

        Question question9 = new Question(UtilStringStorage.paleontology, QuestionStringStorage.question9,QuestionStringStorage.answerA9,
                QuestionStringStorage.answerB9, QuestionStringStorage.answerC9, QuestionStringStorage.answerD9, QuestionStringStorage.goodAnswer9,
                QuestionStringStorage.explanation9);
        questionList.add(question9);

        Question question10 = new Question(UtilStringStorage.insolite, QuestionStringStorage.question10,QuestionStringStorage.answerA10,
                QuestionStringStorage.answerB10, QuestionStringStorage.answerC10, QuestionStringStorage.answerD10, QuestionStringStorage.goodAnswer10,
                QuestionStringStorage.explanation10);
        questionList.add(question10);

        Question question11 = new Question(UtilStringStorage.animals, QuestionStringStorage.question11,QuestionStringStorage.answerA11,
                QuestionStringStorage.answerB11, QuestionStringStorage.answerC11, QuestionStringStorage.answerD11, QuestionStringStorage.goodAnswer11,
                QuestionStringStorage.explanation11);
        questionList.add(question11);

        Question question12 = new Question(UtilStringStorage.videoGames, QuestionStringStorage.question12,QuestionStringStorage.answerA12,
                QuestionStringStorage.answerB12, QuestionStringStorage.answerC12, QuestionStringStorage.answerD12, QuestionStringStorage.goodAnswer12,
                QuestionStringStorage.explanation12);
        questionList.add(question12);

        Question question13 = new Question(UtilStringStorage.cinema, QuestionStringStorage.question13,QuestionStringStorage.answerA13,
                QuestionStringStorage.answerB13, QuestionStringStorage.answerC13, QuestionStringStorage.answerD13, QuestionStringStorage.goodAnswer13,
                QuestionStringStorage.explanation13);
        questionList.add(question13);

        Question question14 = new Question(UtilStringStorage.space, QuestionStringStorage.question14,QuestionStringStorage.answerA14,
                QuestionStringStorage.answerB14, QuestionStringStorage.answerC14, QuestionStringStorage.answerD14, QuestionStringStorage.goodAnswer14,
                QuestionStringStorage.explanation14);
        questionList.add(question14);

        Question question15 = new Question(UtilStringStorage.plants, QuestionStringStorage.question15,QuestionStringStorage.answerA15,
                QuestionStringStorage.answerB15, QuestionStringStorage.answerC15, QuestionStringStorage.answerD15, QuestionStringStorage.goodAnswer15,
                QuestionStringStorage.explanation15);
        questionList.add(question15);

        Question question16 = new Question(UtilStringStorage.geography, QuestionStringStorage.question16,QuestionStringStorage.answerA16,
                QuestionStringStorage.answerB16, QuestionStringStorage.answerC16, QuestionStringStorage.answerD16, QuestionStringStorage.goodAnswer16,
                QuestionStringStorage.explanation16);
        questionList.add(question16);

        Question question17 = new Question(UtilStringStorage.historia, QuestionStringStorage.question17,QuestionStringStorage.answerA17,
                QuestionStringStorage.answerB17, QuestionStringStorage.answerC17, QuestionStringStorage.answerD17, QuestionStringStorage.goodAnswer17,
                QuestionStringStorage.explanation17);
        questionList.add(question17);

        Question question18 = new Question(UtilStringStorage.geography, QuestionStringStorage.question18,QuestionStringStorage.answerA18,
                QuestionStringStorage.answerB18, QuestionStringStorage.answerC18, QuestionStringStorage.answerD18, QuestionStringStorage.goodAnswer18,
                QuestionStringStorage.explanation18);
        questionList.add(question18);

        Question question19 = new Question(UtilStringStorage.animals, QuestionStringStorage.question19,QuestionStringStorage.answerA19,
                QuestionStringStorage.answerB19, QuestionStringStorage.answerC19, QuestionStringStorage.answerD19, QuestionStringStorage.goodAnswer19,
                QuestionStringStorage.explanation19);
        questionList.add(question19);

        Question question20 = new Question(UtilStringStorage.music, QuestionStringStorage.question20,QuestionStringStorage.answerA20,
                QuestionStringStorage.answerB20, QuestionStringStorage.answerC20, QuestionStringStorage.answerD20, QuestionStringStorage.goodAnswer20,
                QuestionStringStorage.explanation20);
        questionList.add(question20);

        Question question21 = new Question(UtilStringStorage.literature, QuestionStringStorage.question21,QuestionStringStorage.answerA21,
                QuestionStringStorage.answerB21, QuestionStringStorage.answerC21, QuestionStringStorage.answerD21, QuestionStringStorage.goodAnswer21,
                QuestionStringStorage.explanation21);
        questionList.add(question21);

        Question question22 = new Question(UtilStringStorage.linguistic, QuestionStringStorage.question22,QuestionStringStorage.answerA22,
                QuestionStringStorage.answerB22, QuestionStringStorage.answerC22, QuestionStringStorage.answerD22, QuestionStringStorage.goodAnswer22,
                QuestionStringStorage.explanation22);
        questionList.add(question22);

        Question question23 = new Question(UtilStringStorage.humanBody, QuestionStringStorage.question23,QuestionStringStorage.answerA23,
                QuestionStringStorage.answerB23, QuestionStringStorage.answerC23, QuestionStringStorage.answerD23, QuestionStringStorage.goodAnswer23,
                QuestionStringStorage.explanation23);
        questionList.add(question23);

        Question question24 = new Question(UtilStringStorage.records, QuestionStringStorage.question24,QuestionStringStorage.answerA24,
                QuestionStringStorage.answerB24, QuestionStringStorage.answerC24, QuestionStringStorage.answerD24, QuestionStringStorage.goodAnswer24,
                QuestionStringStorage.explanation24);
        questionList.add(question24);

        Question question25 = new Question(UtilStringStorage.culture, QuestionStringStorage.question25,QuestionStringStorage.answerA25,
                QuestionStringStorage.answerB25, QuestionStringStorage.answerC25, QuestionStringStorage.answerD25, QuestionStringStorage.goodAnswer25,
                QuestionStringStorage.explanation25);
        questionList.add(question25);

        Question question26 = new Question(UtilStringStorage.historia, QuestionStringStorage.question26,QuestionStringStorage.answerA26,
                QuestionStringStorage.answerB26, QuestionStringStorage.answerC26, QuestionStringStorage.answerD26, QuestionStringStorage.goodAnswer26,
                QuestionStringStorage.explanation26);
        questionList.add(question26);

        Question question27 = new Question(UtilStringStorage.geography, QuestionStringStorage.question27,QuestionStringStorage.answerA27,
                QuestionStringStorage.answerB27, QuestionStringStorage.answerC27, QuestionStringStorage.answerD27, QuestionStringStorage.goodAnswer27,
                QuestionStringStorage.explanation27);
        questionList.add(question27);

        Question question28 = new Question(UtilStringStorage.law, QuestionStringStorage.question28,QuestionStringStorage.answerA28,
                QuestionStringStorage.answerB28, QuestionStringStorage.answerC28, QuestionStringStorage.answerD28, QuestionStringStorage.goodAnswer28,
                QuestionStringStorage.explanation28);
        questionList.add(question28);

        Question question29 = new Question(UtilStringStorage.linguistic, QuestionStringStorage.question29,QuestionStringStorage.answerA29,
                QuestionStringStorage.answerB29, QuestionStringStorage.answerC29, QuestionStringStorage.answerD29, QuestionStringStorage.goodAnswer29,
                QuestionStringStorage.explanation29);
        questionList.add(question29);

        Question question30 = new Question(UtilStringStorage.paleontology, QuestionStringStorage.question30,QuestionStringStorage.answerA30,
                QuestionStringStorage.answerB30, QuestionStringStorage.answerC30, QuestionStringStorage.answerD30, QuestionStringStorage.goodAnswer30,
                QuestionStringStorage.explanation30);
        questionList.add(question30);

        Question question31 = new Question(UtilStringStorage.records, QuestionStringStorage.question31,QuestionStringStorage.answerA31,
                QuestionStringStorage.answerB31, QuestionStringStorage.answerC31, QuestionStringStorage.answerD31, QuestionStringStorage.goodAnswer31,
                QuestionStringStorage.explanation31);
        questionList.add(question31);

        Question question32 = new Question(UtilStringStorage.mythology, QuestionStringStorage.question32,QuestionStringStorage.answerA32,
                QuestionStringStorage.answerB32, QuestionStringStorage.answerC32, QuestionStringStorage.answerD32, QuestionStringStorage.goodAnswer32,
                QuestionStringStorage.explanation32);
        questionList.add(question32);

        Question question33 = new Question(UtilStringStorage.food, QuestionStringStorage.question33,QuestionStringStorage.answerA33,
                QuestionStringStorage.answerB33, QuestionStringStorage.answerC33, QuestionStringStorage.answerD33, QuestionStringStorage.goodAnswer33,
                QuestionStringStorage.explanation33);
        questionList.add(question33);

        Question question34 = new Question(UtilStringStorage.humanBody, QuestionStringStorage.question34,QuestionStringStorage.answerA34,
                QuestionStringStorage.answerB34, QuestionStringStorage.answerC34, QuestionStringStorage.answerD34, QuestionStringStorage.goodAnswer34,
                QuestionStringStorage.explanation34);
        questionList.add(question34);

        Question question35 = new Question(UtilStringStorage.society, QuestionStringStorage.question35,QuestionStringStorage.answerA35,
                QuestionStringStorage.answerB35, QuestionStringStorage.answerC35, QuestionStringStorage.answerD35, QuestionStringStorage.goodAnswer35,
                QuestionStringStorage.explanation35);
        questionList.add(question35);

        Question question36 = new Question(UtilStringStorage.animals, QuestionStringStorage.question36,QuestionStringStorage.answerA36,
                QuestionStringStorage.answerB36, QuestionStringStorage.answerC36, QuestionStringStorage.answerD36, QuestionStringStorage.goodAnswer36,
                QuestionStringStorage.explanation36);
        questionList.add(question36);

        Question question37 = new Question(UtilStringStorage.literature, QuestionStringStorage.question37,QuestionStringStorage.answerA37,
                QuestionStringStorage.answerB37, QuestionStringStorage.answerC37, QuestionStringStorage.answerD37, QuestionStringStorage.goodAnswer37,
                QuestionStringStorage.explanation37);
        questionList.add(question37);

        Question question38 = new Question(UtilStringStorage.historia, QuestionStringStorage.question38,QuestionStringStorage.answerA38,
                QuestionStringStorage.answerB38, QuestionStringStorage.answerC38, QuestionStringStorage.answerD38, QuestionStringStorage.goodAnswer38,
                QuestionStringStorage.explanation38);
        questionList.add(question38);

        Question question39 = new Question(UtilStringStorage.plants, QuestionStringStorage.question39,QuestionStringStorage.answerA39,
                QuestionStringStorage.answerB39, QuestionStringStorage.answerC39, QuestionStringStorage.answerD39, QuestionStringStorage.goodAnswer39,
                QuestionStringStorage.explanation39);
        questionList.add(question39);

        Question question40 = new Question(UtilStringStorage.historia, QuestionStringStorage.question40,QuestionStringStorage.answerA40,
                QuestionStringStorage.answerB40, QuestionStringStorage.answerC40, QuestionStringStorage.answerD40, QuestionStringStorage.goodAnswer40,
                QuestionStringStorage.explanation40);
        questionList.add(question40);

        Question question41 = new Question(UtilStringStorage.internet, QuestionStringStorage.question41,QuestionStringStorage.answerA41,
                QuestionStringStorage.answerB41, QuestionStringStorage.answerC41, QuestionStringStorage.answerD41, QuestionStringStorage.goodAnswer41,
                QuestionStringStorage.explanation41);
        questionList.add(question41);

        Question question42 = new Question(UtilStringStorage.animals, QuestionStringStorage.question42,QuestionStringStorage.answerA42,
                QuestionStringStorage.answerB42, QuestionStringStorage.answerC42, QuestionStringStorage.answerD42, QuestionStringStorage.goodAnswer42,
                QuestionStringStorage.explanation42);
        questionList.add(question42);

        Question question43 = new Question(UtilStringStorage.videoGames, QuestionStringStorage.question43,QuestionStringStorage.answerA43,
                QuestionStringStorage.answerB43, QuestionStringStorage.answerC43, QuestionStringStorage.answerD43, QuestionStringStorage.goodAnswer43,
                QuestionStringStorage.explanation43);
        questionList.add(question43);

        Question question44 = new Question(UtilStringStorage.society, QuestionStringStorage.question44,QuestionStringStorage.answerA44,
                QuestionStringStorage.answerB44, QuestionStringStorage.answerC44, QuestionStringStorage.answerD44, QuestionStringStorage.goodAnswer44,
                QuestionStringStorage.explanation44);
        questionList.add(question44);

        Question question45 = new Question(UtilStringStorage.space, QuestionStringStorage.question45,QuestionStringStorage.answerA45,
                QuestionStringStorage.answerB45, QuestionStringStorage.answerC45, QuestionStringStorage.answerD45, QuestionStringStorage.goodAnswer45,
                QuestionStringStorage.explanation45);
        questionList.add(question45);

        Question question46 = new Question(UtilStringStorage.music, QuestionStringStorage.question46,QuestionStringStorage.answerA46,
                QuestionStringStorage.answerB46, QuestionStringStorage.answerC46, QuestionStringStorage.answerD46, QuestionStringStorage.goodAnswer46,
                QuestionStringStorage.explanation46);
        questionList.add(question46);

        Question question47 = new Question(UtilStringStorage.flags, QuestionStringStorage.question47,QuestionStringStorage.answerA47,
                QuestionStringStorage.answerB47, QuestionStringStorage.answerC47, QuestionStringStorage.answerD47, QuestionStringStorage.goodAnswer47,
                QuestionStringStorage.explanation47);
        questionList.add(question47);

        Question question48 = new Question(UtilStringStorage.humanBody, QuestionStringStorage.question48,QuestionStringStorage.answerA48,
                QuestionStringStorage.answerB48, QuestionStringStorage.answerC48, QuestionStringStorage.answerD48, QuestionStringStorage.goodAnswer48,
                QuestionStringStorage.explanation48);
        questionList.add(question48);

        Question question49 = new Question(UtilStringStorage.music, QuestionStringStorage.question49,QuestionStringStorage.answerA49,
                QuestionStringStorage.answerB49, QuestionStringStorage.answerC49, QuestionStringStorage.answerD49, QuestionStringStorage.goodAnswer49,
                QuestionStringStorage.explanation49);
        questionList.add(question49);

        Question question50 = new Question(UtilStringStorage.geography, QuestionStringStorage.question50,QuestionStringStorage.answerA50,
                QuestionStringStorage.answerB50, QuestionStringStorage.answerC50, QuestionStringStorage.answerD50, QuestionStringStorage.goodAnswer50,
                QuestionStringStorage.explanation50);
        questionList.add(question50);

        Question question51 = new Question(UtilStringStorage.cinema, QuestionStringStorage.question51,QuestionStringStorage.answerA51,
                QuestionStringStorage.answerB51, QuestionStringStorage.answerC51, QuestionStringStorage.answerD51, QuestionStringStorage.goodAnswer51,
                QuestionStringStorage.explanation51);
        questionList.add(question51);

        Question question52 = new Question(UtilStringStorage.invention, QuestionStringStorage.question52,QuestionStringStorage.answerA52,
                QuestionStringStorage.answerB52, QuestionStringStorage.answerC52, QuestionStringStorage.answerD52, QuestionStringStorage.goodAnswer52,
                QuestionStringStorage.explanation52);
        questionList.add(question52);

        Question question53 = new Question(UtilStringStorage.sports, QuestionStringStorage.question53,QuestionStringStorage.answerA53,
                QuestionStringStorage.answerB53, QuestionStringStorage.answerC53, QuestionStringStorage.answerD53, QuestionStringStorage.goodAnswer53,
                QuestionStringStorage.explanation53);
        questionList.add(question53);

        Question question54 = new Question(UtilStringStorage.animals, QuestionStringStorage.question54,QuestionStringStorage.answerA54,
                QuestionStringStorage.answerB54, QuestionStringStorage.answerC54, QuestionStringStorage.answerD54, QuestionStringStorage.goodAnswer54,
                QuestionStringStorage.explanation54);
        questionList.add(question54);

        Question question55 = new Question(UtilStringStorage.historia, QuestionStringStorage.question55,QuestionStringStorage.answerA55,
                QuestionStringStorage.answerB55, QuestionStringStorage.answerC55, QuestionStringStorage.answerD55, QuestionStringStorage.goodAnswer55,
                QuestionStringStorage.explanation55);
        questionList.add(question55);

        Question question56 = new Question(UtilStringStorage.society, QuestionStringStorage.question56,QuestionStringStorage.answerA56,
                QuestionStringStorage.answerB56, QuestionStringStorage.answerC56, QuestionStringStorage.answerD56, QuestionStringStorage.goodAnswer56,
                QuestionStringStorage.explanation56);
        questionList.add(question56);

        Question question57 = new Question(UtilStringStorage.records, QuestionStringStorage.question57,QuestionStringStorage.answerA57,
                QuestionStringStorage.answerB57, QuestionStringStorage.answerC57, QuestionStringStorage.answerD57, QuestionStringStorage.goodAnswer57,
                QuestionStringStorage.explanation57);
        questionList.add(question57);

        Question question58 = new Question(UtilStringStorage.society, QuestionStringStorage.question58,QuestionStringStorage.answerA58,
                QuestionStringStorage.answerB58, QuestionStringStorage.answerC58, QuestionStringStorage.answerD58, QuestionStringStorage.goodAnswer58,
                QuestionStringStorage.explanation58);
        questionList.add(question58);

        Question question59 = new Question(UtilStringStorage.literature, QuestionStringStorage.question59,QuestionStringStorage.answerA59,
                QuestionStringStorage.answerB59, QuestionStringStorage.answerC59, QuestionStringStorage.answerD59, QuestionStringStorage.goodAnswer59,
                QuestionStringStorage.explanation59);
        questionList.add(question59);

        Question question60 = new Question(UtilStringStorage.food, QuestionStringStorage.question60,QuestionStringStorage.answerA60,
                QuestionStringStorage.answerB60, QuestionStringStorage.answerC60, QuestionStringStorage.answerD60, QuestionStringStorage.goodAnswer60,
                QuestionStringStorage.explanation60);
        questionList.add(question60);

        Question question61 = new Question(UtilStringStorage.painting, QuestionStringStorage.question61,QuestionStringStorage.answerA61,
                QuestionStringStorage.answerB61, QuestionStringStorage.answerC61, QuestionStringStorage.answerD61, QuestionStringStorage.goodAnswer61,
                QuestionStringStorage.explanation61);
        questionList.add(question61);

        Question question62 = new Question(UtilStringStorage.minerals, QuestionStringStorage.question62,QuestionStringStorage.answerA62,
                QuestionStringStorage.answerB62, QuestionStringStorage.answerC62, QuestionStringStorage.answerD62, QuestionStringStorage.goodAnswer62,
                QuestionStringStorage.explanation62);
        questionList.add(question62);

        Question question63 = new Question(UtilStringStorage.nature, QuestionStringStorage.question63,QuestionStringStorage.answerA63,
                QuestionStringStorage.answerB63, QuestionStringStorage.answerC63, QuestionStringStorage.answerD63, QuestionStringStorage.goodAnswer63,
                QuestionStringStorage.explanation63);
        questionList.add(question63);

        Question question64 = new Question(UtilStringStorage.painting, QuestionStringStorage.question64,QuestionStringStorage.answerA64,
                QuestionStringStorage.answerB64, QuestionStringStorage.answerC64, QuestionStringStorage.answerD64, QuestionStringStorage.goodAnswer64,
                QuestionStringStorage.explanation64);
        questionList.add(question64);

        Question question65 = new Question(UtilStringStorage.space, QuestionStringStorage.question65,QuestionStringStorage.answerA65,
                QuestionStringStorage.answerB65, QuestionStringStorage.answerC65, QuestionStringStorage.answerD65, QuestionStringStorage.goodAnswer65,
                QuestionStringStorage.explanation65);
        questionList.add(question65);

        Question question66 = new Question(UtilStringStorage.linguistic, QuestionStringStorage.question66,QuestionStringStorage.answerA66,
                QuestionStringStorage.answerB66, QuestionStringStorage.answerC66, QuestionStringStorage.answerD66, QuestionStringStorage.goodAnswer66,
                QuestionStringStorage.explanation66);
        questionList.add(question66);

        Question question67 = new Question(UtilStringStorage.nature, QuestionStringStorage.question67,QuestionStringStorage.answerA67,
                QuestionStringStorage.answerB67, QuestionStringStorage.answerC67, QuestionStringStorage.answerD67, QuestionStringStorage.goodAnswer67,
                QuestionStringStorage.explanation67);
        questionList.add(question67);

        Question question68 = new Question(UtilStringStorage.law, QuestionStringStorage.question68,QuestionStringStorage.answerA68,
                QuestionStringStorage.answerB68, QuestionStringStorage.answerC68, QuestionStringStorage.answerD68, QuestionStringStorage.goodAnswer68,
                QuestionStringStorage.explanation68);
        questionList.add(question68);

        Question question69 = new Question(UtilStringStorage.internet, QuestionStringStorage.question69,QuestionStringStorage.answerA69,
                QuestionStringStorage.answerB69, QuestionStringStorage.answerC69, QuestionStringStorage.answerD69, QuestionStringStorage.goodAnswer69,
                QuestionStringStorage.explanation69);
        questionList.add(question69);

        Question question70 = new Question(UtilStringStorage.animals, QuestionStringStorage.question70,QuestionStringStorage.answerA70,
                QuestionStringStorage.answerB70, QuestionStringStorage.answerC70, QuestionStringStorage.answerD70, QuestionStringStorage.goodAnswer70,
                QuestionStringStorage.explanation70);
        questionList.add(question70);

        Question question71 = new Question(UtilStringStorage.sports, QuestionStringStorage.question71,QuestionStringStorage.answerA71,
                QuestionStringStorage.answerB71, QuestionStringStorage.answerC71, QuestionStringStorage.answerD71, QuestionStringStorage.goodAnswer71,
                QuestionStringStorage.explanation71);
        questionList.add(question71);

        Question question72 = new Question(UtilStringStorage.literature, QuestionStringStorage.question72,QuestionStringStorage.answerA72,
                QuestionStringStorage.answerB72, QuestionStringStorage.answerC72, QuestionStringStorage.answerD72, QuestionStringStorage.goodAnswer72,
                QuestionStringStorage.explanation72);
        questionList.add(question72);

        Question question73 = new Question(UtilStringStorage.nature, QuestionStringStorage.question73,QuestionStringStorage.answerA73,
                QuestionStringStorage.answerB73, QuestionStringStorage.answerC73, QuestionStringStorage.answerD73, QuestionStringStorage.goodAnswer73,
                QuestionStringStorage.explanation73);
        questionList.add(question73);

        Question question74 = new Question(UtilStringStorage.animals, QuestionStringStorage.question74,QuestionStringStorage.answerA74,
                QuestionStringStorage.answerB74, QuestionStringStorage.answerC74, QuestionStringStorage.answerD74, QuestionStringStorage.goodAnswer74,
                QuestionStringStorage.explanation74);
        questionList.add(question74);

        Question question75 = new Question(UtilStringStorage.society, QuestionStringStorage.question75,QuestionStringStorage.answerA75,
                QuestionStringStorage.answerB75, QuestionStringStorage.answerC75, QuestionStringStorage.answerD75, QuestionStringStorage.goodAnswer75,
                QuestionStringStorage.explanation75);
        questionList.add(question75);

        Question question76 = new Question(UtilStringStorage.invention, QuestionStringStorage.question76,QuestionStringStorage.answerA76,
                QuestionStringStorage.answerB76, QuestionStringStorage.answerC76, QuestionStringStorage.answerD76, QuestionStringStorage.goodAnswer76,
                QuestionStringStorage.explanation76);
        questionList.add(question76);

        Question question77 = new Question(UtilStringStorage.geography, QuestionStringStorage.question77,QuestionStringStorage.answerA77,
                QuestionStringStorage.answerB77, QuestionStringStorage.answerC77, QuestionStringStorage.answerD77, QuestionStringStorage.goodAnswer77,
                QuestionStringStorage.explanation77);
        questionList.add(question77);

        Question question78 = new Question(UtilStringStorage.geography, QuestionStringStorage.question78,QuestionStringStorage.answerA78,
                QuestionStringStorage.answerB78, QuestionStringStorage.answerC78, QuestionStringStorage.answerD78, QuestionStringStorage.goodAnswer78,
                QuestionStringStorage.explanation78);
        questionList.add(question78);

        Question question79 = new Question(UtilStringStorage.historia, QuestionStringStorage.question79,QuestionStringStorage.answerA79,
                QuestionStringStorage.answerB79, QuestionStringStorage.answerC79, QuestionStringStorage.answerD79, QuestionStringStorage.goodAnswer79,
                QuestionStringStorage.explanation79);
        questionList.add(question79);

        Question question80 = new Question(UtilStringStorage.sports, QuestionStringStorage.question80,QuestionStringStorage.answerA80,
                QuestionStringStorage.answerB80, QuestionStringStorage.answerC80, QuestionStringStorage.answerD80, QuestionStringStorage.goodAnswer80,
                QuestionStringStorage.explanation80);
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
