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

        Question question16 = new Question(UtilStringStorage.QUESTION_16,UtilStringStorage.ANSWER_A16,
                UtilStringStorage.ANSWER_B16, UtilStringStorage.ANSWER_C16, UtilStringStorage.ANSWER_D16, UtilStringStorage.GOOD_ANSWER_16,
                UtilStringStorage.EXPLANATION_16);
        questionList.add(question16);

        Question question17 = new Question(UtilStringStorage.QUESTION_17,UtilStringStorage.ANSWER_A17,
                UtilStringStorage.ANSWER_B17, UtilStringStorage.ANSWER_C17, UtilStringStorage.ANSWER_D17, UtilStringStorage.GOOD_ANSWER_17,
                UtilStringStorage.EXPLANATION_17);
        questionList.add(question17);

        Question question18 = new Question(UtilStringStorage.QUESTION_18,UtilStringStorage.ANSWER_A18,
                UtilStringStorage.ANSWER_B18, UtilStringStorage.ANSWER_C18, UtilStringStorage.ANSWER_D18, UtilStringStorage.GOOD_ANSWER_18,
                UtilStringStorage.EXPLANATION_18);
        questionList.add(question18);

        Question question19 = new Question(UtilStringStorage.QUESTION_19,UtilStringStorage.ANSWER_A19,
                UtilStringStorage.ANSWER_B19, UtilStringStorage.ANSWER_C19, UtilStringStorage.ANSWER_D19, UtilStringStorage.GOOD_ANSWER_19,
                UtilStringStorage.EXPLANATION_19);
        questionList.add(question19);

        Question question20 = new Question(UtilStringStorage.QUESTION_20,UtilStringStorage.ANSWER_A20,
                UtilStringStorage.ANSWER_B20, UtilStringStorage.ANSWER_C20, UtilStringStorage.ANSWER_D20, UtilStringStorage.GOOD_ANSWER_20,
                UtilStringStorage.EXPLANATION_20);
        questionList.add(question20);

        Question question21 = new Question("Qui a écrit l'Odyssée ?", "Platon", "Péricles",
                "Hérodote", "Homère", "Homère", "L'Odyssée est la deuxième oeuvre de littérature d'Homère après l'Iliade");
        questionList.add(question21);

        Question question22 = new Question("Quelle est la deuxième langue la plus parlée en Inde ?", "Le Bengali",
                "Le Tamoul", "Le Pendjabi", "Le Népalais", "Le Bengali",
                "Le Bengali est la 2ème langue la plus parlée en Inde, avec 268 millions de locuteurs");
        questionList.add(question22);

        Question question23 = new Question("Qu'est ce que la carotide ?", "Un organe", "Une artère",
                "Une maladie", "Un os", "Une artère", "La carotide est une artère composée de deux parties, interne et externe");
        questionList.add(question23);

        Question question24 = new Question("Quelle est la vitesse maximale atteinte par une voiture à roues ?", "560,87 km/h", "447,32 km/h",
                "633,79 km/h", "398,17 km/h", "633,79 km/h", "Le record de vitesse maximale atteinte par un véhicule a roue est de 633,79km/h"+"\n"+"et à été réalisé en 1947");
        questionList.add(question24);

        Question question25 = new Question("Quel est le musée d'art le plus visité au monde ?", "Le Musée du Louvre",
                "Le Musée national de Chine", "Le British Museum", "Le Musée du Vatican", "Le Musée du Louvre",
                "Le Musée du Louvre est le musée d'art le plus visité au monde"+"\n"+"avec plus de 10 millions de visiteurs par an");
        questionList.add(question25);

        Question question26 = new Question("De quand date la plus vieille université du monde ?", "968 après J.C", "132 avant J.C",
                "425 après J.C", "681 après J.C", "425 après J.C", "La plus vieille université du monde est l'université de Constantinople"+"\n"+"sa fondation remonte à 425 après J.C");
        questionList.add(question26);

        Question question27 = new Question("De quel pays Mogadiscio est la capital ?", "Le Kenya", "L'Ethiopie",
                "Le Niger", "La Somalie", "La Somalie", "Mogadiscio est la capitale de la Somalie et compte plus de 2 millions d'habitants");
        questionList.add(question27);

        Question question28 = new Question("En quelle année les femmes obtiennent le droit de vote en France ?", "1913", "1927", "1938", "1944",
                "1944", "En france les femmes obtiennent le droit de vote en 1944, mais il faudra attendre 1945"+"\n"+"pour qu'elles puissent participer à leurs premier vote (OMG c'est beaucoup trop tard)");
        questionList.add(question28);

        Question question29 = new Question("Que veux dire 'lantiponner' ?", "Faire cuire lentement",
                "Plier un métal", "Parler inutilement", "Être à l'opposé", "Parler inutilement", "lantiponner veux dire parler inutilement, de manière frivole ou importun");
        questionList.add(question29);

        Question question30 = new Question("Quand se sont éteints les dinosaures ?", "Il y a 46 millions d'années", "Il y a 66 millions d'années",
                "Il y a 86 millions d'années", "Il y a 106 millions d'années", "Il y a 66 millions d'années", "Les dinosaures ont disparu il y a environ 66 millions d'années");
        questionList.add(question30);

        Question question31 = new Question("Quelle est la taille de l'humain le plus grand de l'histoire ?", "2,32 mètres",
                "2,72 mètres", "2,51 mètres", "2,97 mètres", "2,72 mètres", "Robert Wadlow est l'homme le plus grand de l'histoire et mesurait 2,72 mètres au moment de sa mort en 1940");
        questionList.add(question31);

        Question question32 = new Question("Athéna était la déesse de la sagesse, des artisans et des artistes, mais aussi de", "La stratégie militaire", "L'olivier",
                "L'enfance", "La ruse", "La stratégie militaire", "Dans la mythologie grecque Athéna était la déesse de la sagesse, des artisans et des artistes,"+"\n"+"mais aussi de la stratégie militaire et des maitres d'écoles");
        questionList.add(question32);

        Question question33 = new Question("Quel est le fruit le plus consommé en France ?", "La banane", "La poire", "L'orange", "La pomme",
                "La pomme", "La pomme est le fruit le plus consommé en france, juste devant la banane et l'orange");
        questionList.add(question33);

        Question question34 = new Question("Quelle est la vitesse maximale de l'air expiré par un éternuement ?", "17km/h", "35km/h",
                "55km/h", "45km/h", "55km/h", "L'air expiré par un éternuement peux atteindre 55km/h");
        questionList.add(question34);

        Question question35 = new Question("Quelle est la ville avec la plus grande densité de population du monde ?", "Manille", "Dacca",
                "Le Caire", "Hong Kong", "Manille", "Manille est la ville avec la plus grande densité du monde avec plus de 40 000 habitants/km²");
        questionList.add(question35);
    }

    public List<Question> getQuestionList() {
        return questionList;
    }
}
