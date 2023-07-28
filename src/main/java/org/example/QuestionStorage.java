package org.example;

import java.util.ArrayList;

public class QuestionStorage
{
    private ArrayList<Question> questionList = new ArrayList<>();

    public QuestionStorage()
    {
        createQuestions();
    }

    public void createQuestions()
    {
        Question question1 = new Question(1,"Quelle est la superficie du Bresil ?","8 547 404km²",
                "3 682 607km²", "5 360 419km²", "10 853 730km²", "8 547 404km²");
        questionList.add(question1);

        Question question2 = new Question(2,"Quelle est la date de la bataille d'Alésia ?", "253 ap JC",
                "186 av JC", "67 ap JC", "52 av JC", "52 av JC");
        questionList.add(question2);

        Question question3 = new Question(3,"Qu'est ce que le 'chibouque' ?", "Une espece rare de bouc",
                "L'ancetre des narguiles", "Une insulte du patois auvergnat", "Ce mot n'existe pas", "L'ancetre des narguiles");
        questionList.add(question3);

        Question question4 = new Question(4,"Ou se trouve l'archipel des 'Comores' ?", "A l'Ouest de l'Argentine",
                "A l'Est de l'Australie", "Au Sud des Caraibes", "Au Nord de Madagascar", "Au Nord de Madagascar");
        questionList.add(question4);

        Question question5 = new Question(5,"De quel pays les weta geants sont ils endemiques ?", "Du Perou",
                "De Nouvelle Zelande", "D'Afrique du Sud", "De Norvège", "De Nouvelle Zelande");
        questionList.add(question5);

        Question question6 = new Question(6,"De quel siecle date l'invention des lunettes ?", "Du 11e siecle",
                "Du 15e siecle", "Du 13e siecle", "Du 9e siecle", "Du 13e siecle");
        questionList.add(question6);

        Question question7 = new Question(7,"Qu'est ce que le 'Sepak Takraw' ?", "Un sport insolite",
                "Un plat très epice", "Un animal en voie de disparition", "Une cérémonie religieuse", "Un sport insolite");
        questionList.add(question7);

        Question question8 = new Question(8,"A quelle profondeur se trouve le point le plus profond des oceans ?", "8 848 metres",
                "21 325 metres", "10 994 metres", "16 687 metres", "10 994 metres");
        questionList.add(question8);

        Question question9 = new Question(9,"Quand sont apparues les premieres tortues ?", "Il y a 67 millions d'annees",
                "Il y a 330 millions d'annees", "Il y a 130 millions d'années", "Il y a 210 millions d'annees", "Il y a 210 millions d'annees");
        questionList.add(question9);

        Question question10 = new Question(10,"A combien de degres s'eleve le point chaud creer par les pinces de la crevette pistolet ?",
                "4700 degres Celsius", "1225 degres Celsius", "6430 degres Celsius", "2500 degres Celsius", "4700 degres Celsius");
        questionList.add(question10);
    }

    public ArrayList<Question> getQuestionList() {
        return questionList;
    }
}
