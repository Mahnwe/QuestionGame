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
        Question question1 = new Question(1,"Quelle est la superficie du Brésil ?","8 547 404km²",
                "3 682 607km²", "5 360 419km²", "10 853 730km²", "8 547 404km²",
                "Le Brésil fait 8 547 404km² ce qui en fait le 5ème plus grand pays du monde en superficie"+"\n"+"et le 1er en Amérique du sud");
        questionList.add(question1);

        Question question2 = new Question(2,"Quelle est la date de la bataille d'Alésia ?", "253 ap JC",
                "186 av JC", "67 ap JC", "52 av JC", "52 av JC",
                "La bataille d'Alésia se déroule en 52 av JC et oppose une coalition de peuples habitant la 'Gaule'"+"\n"+"(appeler ainsi par Jule César) et les armées romaines menées par ce dernier");
        questionList.add(question2);

        Question question3 = new Question(3,"Qu'est ce que le 'chibouque' ?", "Une espèce rare de bouc",
                "L'ancêtre des narguilés", "Une insulte du patois auvergnat", "Ce mot n'existe pas", "L'ancêtre des narguilés",
                "'Chibouque' est l'ancien nom donné au narguilés ou chicha actuels");
        questionList.add(question3);

        Question question4 = new Question(4,"Ou se trouve l'archipel des 'Comores' ?", "A l'Ouest de l'Argentine",
                "A l'Est de l'Australie", "Au Sud des Caraibes", "Au Nord de Madagascar", "Au Nord de Madagascar",
                "L'archipel des Comores est situé au Nord de Madagascar et est composé de 4 îles");
        questionList.add(question4);

        Question question5 = new Question(5,"De quel pays les weta géants sont ils endémiques ?", "Du Perou",
                "De Nouvelle Zélande", "D'Afrique du Sud", "De Norvège", "De Nouvelle Zélande",
                "Les wétas géants sont endémiques de Nouvelle-Zélande et font partie"+"\n"+"des plus grands et des plus lourds insectes du monde");
        questionList.add(question5);

        Question question6 = new Question(6,"De quel siècle date l'invention des lunettes ?", "Du 11e siecle",
                "Du 15e siecle", "Du 13e siecle", "Du 9e siecle", "Du 13e siecle",
                "Les premières lunettes composée de 2 branches et deux verres"+"\n"+"sont inventées au 13ème siècle mais sont très différentes de celle de nos jours");
        questionList.add(question6);

        Question question7 = new Question(7,"Qu'est ce que le 'Sepak Takraw' ?", "Un sport insolite",
                "Un plat très epice", "Un animal en voie de disparition", "Une cérémonie religieuse", "Un sport insolite",
                "Le Sepak Takraw est un sport proche du volley-ball et est très populaire en Asie du sud-est");
        questionList.add(question7);

        Question question8 = new Question(8,"A quelle profondeur se trouve le point le plus profond des oceans ?", "8 848 metres",
                "21 325 metres", "10 994 metres", "16 687 metres", "10 994 metres",
                "Le point le plus profond des océans s'appelle le Challenger Deep et a été mesuré à 10 994 metres");
        questionList.add(question8);

        Question question9 = new Question(9,"Quand sont apparues les premieres tortues ?", "Il y a 67 millions d'annees",
                "Il y a 330 millions d'annees", "Il y a 130 millions d'années", "Il y a 210 millions d'annees", "Il y a 210 millions d'annees",
                "Les premières tortues sont apparus il y a environ 210 millions d'années"+"\n"+"pendant la période du Trias et étaient semi-aquatique");
        questionList.add(question9);

        Question question10 = new Question(10,"A combien de degres s'eleve le point chaud creer par les pinces de la crevette pistolet ?",
                "4700 degres Celsius", "1225 degres Celsius", "6430 degres Celsius", "2500 degres Celsius", "4700 degres Celsius",
                "La crevette pistolet peux créer un point chaud de 4700 degrés Celsius"+"\n"+" se rapprochant de la température à la surface du Soleil (5900 degrès)");
        questionList.add(question10);
    }

    public ArrayList<Question> getQuestionList() {
        return questionList;
    }
}
