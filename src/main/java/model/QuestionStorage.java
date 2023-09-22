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
        Question question1 = new Question(UtilStringStorage.QUESTION_1,UtilStringStorage.ANSWER_A1,
                UtilStringStorage.ANSWER_B1, UtilStringStorage.ANSWER_C1, UtilStringStorage.ANSWER_D1, UtilStringStorage.GOOD_ANSWER_1,
                UtilStringStorage.EXPLANATION_1);
        questionList.add(question1);

        Question question2 = new Question(UtilStringStorage.QUESTION_2,UtilStringStorage.ANSWER_A2,
                UtilStringStorage.ANSWER_B2, UtilStringStorage.ANSWER_C2, UtilStringStorage.ANSWER_D2, UtilStringStorage.GOOD_ANSWER_2,
                UtilStringStorage.EXPLANATION_2);
        questionList.add(question2);

        Question question3 = new Question(UtilStringStorage.QUESTION_3,UtilStringStorage.ANSWER_A3,
                UtilStringStorage.ANSWER_B3, UtilStringStorage.ANSWER_C3, UtilStringStorage.ANSWER_D3, UtilStringStorage.GOOD_ANSWER_3,
                UtilStringStorage.EXPLANATION_3);
        questionList.add(question3);

        Question question4 = new Question(UtilStringStorage.QUESTION_4,UtilStringStorage.ANSWER_A4,
                UtilStringStorage.ANSWER_B4, UtilStringStorage.ANSWER_C4, UtilStringStorage.ANSWER_D4, UtilStringStorage.GOOD_ANSWER_4,
                UtilStringStorage.EXPLANATION_4);
        questionList.add(question4);

        Question question5 = new Question(UtilStringStorage.QUESTION_5,UtilStringStorage.ANSWER_A5,
                UtilStringStorage.ANSWER_B5, UtilStringStorage.ANSWER_C5, UtilStringStorage.ANSWER_D5, UtilStringStorage.GOOD_ANSWER_5,
                UtilStringStorage.EXPLANATION_5);
        questionList.add(question5);

        Question question6 = new Question(UtilStringStorage.QUESTION_6,UtilStringStorage.ANSWER_A6,
                UtilStringStorage.ANSWER_B6, UtilStringStorage.ANSWER_C6, UtilStringStorage.ANSWER_D6, UtilStringStorage.GOOD_ANSWER_6,
                UtilStringStorage.EXPLANATION_6);
        questionList.add(question6);

        Question question7 = new Question(UtilStringStorage.QUESTION_7,UtilStringStorage.ANSWER_A7,
                UtilStringStorage.ANSWER_B7, UtilStringStorage.ANSWER_C7, UtilStringStorage.ANSWER_D7, UtilStringStorage.GOOD_ANSWER_7,
                UtilStringStorage.EXPLANATION_7);
        questionList.add(question7);

        Question question8 = new Question(UtilStringStorage.QUESTION_8,UtilStringStorage.ANSWER_A8,
                UtilStringStorage.ANSWER_B8, UtilStringStorage.ANSWER_C8, UtilStringStorage.ANSWER_D8, UtilStringStorage.GOOD_ANSWER_8,
                UtilStringStorage.EXPLANATION_8);
        questionList.add(question8);

        Question question9 = new Question(UtilStringStorage.QUESTION_9,UtilStringStorage.ANSWER_A9,
                UtilStringStorage.ANSWER_B9, UtilStringStorage.ANSWER_C9, UtilStringStorage.ANSWER_D9, UtilStringStorage.GOOD_ANSWER_9,
                UtilStringStorage.EXPLANATION_9);
        questionList.add(question9);

        Question question10 = new Question(UtilStringStorage.QUESTION_10,UtilStringStorage.ANSWER_A10,
                UtilStringStorage.ANSWER_B10, UtilStringStorage.ANSWER_C10, UtilStringStorage.ANSWER_D10, UtilStringStorage.GOOD_ANSWER_10,
                UtilStringStorage.EXPLANATION_10);
        questionList.add(question10);

        Question question11 = new Question(UtilStringStorage.QUESTION_11,UtilStringStorage.ANSWER_A11,
                UtilStringStorage.ANSWER_B11, UtilStringStorage.ANSWER_C11, UtilStringStorage.ANSWER_D11, UtilStringStorage.GOOD_ANSWER_11,
                UtilStringStorage.EXPLANATION_11);
        questionList.add(question11);

        Question question12 = new Question(UtilStringStorage.QUESTION_12,UtilStringStorage.ANSWER_A12,
                UtilStringStorage.ANSWER_B12, UtilStringStorage.ANSWER_C12, UtilStringStorage.ANSWER_D12, UtilStringStorage.GOOD_ANSWER_12,
                UtilStringStorage.EXPLANATION_12);
        questionList.add(question12);

        Question question13 = new Question(UtilStringStorage.QUESTION_13,UtilStringStorage.ANSWER_A13,
                UtilStringStorage.ANSWER_B13, UtilStringStorage.ANSWER_C13, UtilStringStorage.ANSWER_D13, UtilStringStorage.GOOD_ANSWER_13,
                UtilStringStorage.EXPLANATION_13);
        questionList.add(question13);

        Question question14 = new Question(UtilStringStorage.QUESTION_14,UtilStringStorage.ANSWER_A14,
                UtilStringStorage.ANSWER_B14, UtilStringStorage.ANSWER_C14, UtilStringStorage.ANSWER_D14, UtilStringStorage.GOOD_ANSWER_14,
                UtilStringStorage.EXPLANATION_14);
        questionList.add(question14);

        Question question15 = new Question(UtilStringStorage.QUESTION_15,UtilStringStorage.ANSWER_A15,
                UtilStringStorage.ANSWER_B15, UtilStringStorage.ANSWER_C15, UtilStringStorage.ANSWER_D15, UtilStringStorage.GOOD_ANSWER_15,
                UtilStringStorage.EXPLANATION_15);
        questionList.add(question15);

        Question question16 = new Question("Quel est le plus grand océan du monde en superficie ?", "Océan Indien",
                "Océan Antarctique", "Océan Pacifique", "Océan Atlantique", "Océan Pacifique",
                "L'Océan Pacifique est le plus grand océan du monde avec environ 166 millions de km²");
        questionList.add(question16);

        Question question17 = new Question("De quand date la construction de la pyramide de Khéops ?", "Vers 2560 av J.C",
                "Vers 1560 av J.C", "Vers 3800 av J.C", "Vers 720 av J.C", "Vers 2560 av J.C",
                "La pyramide de Khéops fut édifiée vers 2560 av J.C, il y a plus de 4500ans" +"\n"+"et est la plus grande pyramide de Gizeh");
        questionList.add(question17);

        Question question18 = new Question("De combien d'états sont composés les Etats-Unis ?", "37 états", "63 états",
                "43 états", "50 états", "50 états", "Les Etats-Unis sont composés de 50 états");
        questionList.add(question18);

        Question question19 = new Question("Quel animal est un roitelet ?", "Un renard", "Un cheval",
                "Un oiseau", "Un poisson", "Un oiseau", "Le roitelet est une espèce d'oiseau de l'ordre des passereaux");
        questionList.add(question19);

        Question question20 = new Question("Ou est né Mozart ?", "A Venise", "A Salzbourg",
                "A Vienne", "A Turin", "A Salzbourg", "Wolfgang Amadeus Mozart est né à Salzbourg en 1756");
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
