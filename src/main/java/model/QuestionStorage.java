package model;

import java.util.ArrayList;

public class QuestionStorage
{
    private final ArrayList<Question> questionList = new ArrayList<>();

    public QuestionStorage()
    {
        createQuestions();
    }

    public void createQuestions()
    {
        Question question1 = new Question("Quelle est la superficie du Brésil ?","8 547 404km²",
                "3 682 607km²", "5 360 419km²", "10 853 730km²", "8 547 404km²",
                "Le Brésil fait 8 547 404km² ce qui en fait le 5ème plus grand pays du monde en superficie"+"\n"+"et le 1er en Amérique du sud");
        questionList.add(question1);

        Question question2 = new Question("Quelle est la date de la bataille d'Alésia ?", "253 ap JC",
                "186 av JC", "67 ap JC", "52 av JC", "52 av JC",
                "La bataille d'Alésia se déroule en 52 av JC et oppose une coalition de peuples habitant la 'Gaule'"+"\n"+"(appelés ainsi par Jule César) et les armées romaines menées par ce dernier");
        questionList.add(question2);

        Question question3 = new Question("Qu'est ce que le 'chibouque' ?", "Une espèce rare de bouc",
                "L'ancêtre des narguilés", "Une insulte du patois auvergnat", "Ce mot n'existe pas", "L'ancêtre des narguilés",
                "'Chibouque' est l'ancien nom donné au narguilés ou chicha actuels");
        questionList.add(question3);

        Question question4 = new Question("Ou se trouve l'archipel des 'Comores' ?", "A l'Ouest de l'Argentine",
                "A l'Est de l'Australie", "Au Sud des Caraibes", "Au Nord de Madagascar", "Au Nord de Madagascar",
                "L'archipel des Comores est situé au Nord de Madagascar et est composé de 4 îles");
        questionList.add(question4);

        Question question5 = new Question("De quel pays les wéta géants sont ils endémiques ?", "Du Perou",
                "De Nouvelle Zélande", "D'Afrique du Sud", "De Norvège", "De Nouvelle Zélande",
                "Les wétas géants sont endémiques de Nouvelle-Zélande et font partie"+"\n"+"des plus grands et des plus lourds insectes du monde");
        questionList.add(question5);

        Question question6 = new Question("De quel siècle date l'invention des lunettes ?", "Du 11e siecle",
                "Du 15e siecle", "Du 13e siecle", "Du 9e siecle", "Du 13e siecle",
                "Les premières lunettes composée de 2 branches et deux verres"+"\n"+"sont inventées au 13ème siècle mais sont très différentes de celle de nos jours");
        questionList.add(question6);

        Question question7 = new Question("Qu'est ce que le 'Sepak Takraw' ?", "Un sport insolite",
                "Un plat très épicé", "Un animal en voie de disparition", "Une cérémonie religieuse", "Un sport insolite",
                "Le Sepak Takraw est un sport proche du volley-ball et est très populaire en Asie du sud-est");
        questionList.add(question7);

        Question question8 = new Question("A quelle profondeur se trouve le point le plus profond des océans ?", "8 848 metres",
                "21 325 metres", "10 994 metres", "16 687 metres", "10 994 metres",
                "Le point le plus profond des océans s'appelle le Challenger Deep et a été mesuré à 10 994 metres");
        questionList.add(question8);

        Question question9 = new Question("Quand sont apparues les premières tortues ?", "Il y a 67 millions d'années",
                "Il y a 330 millions d'années", "Il y a 130 millions d'années", "Il y a 210 millions d'années", "Il y a 210 millions d'années",
                "Les premières tortues sont apparus il y a environ 210 millions d'années"+"\n"+"pendant la période du Trias et étaient semi-aquatique");
        questionList.add(question9);

        Question question10 = new Question("A combien de degrés s'élève le point chaud crée par la pince de la crevette pistolet ?",
                "4700 degres Celsius", "1225 degres Celsius", "6430 degres Celsius", "2500 degres Celsius", "4700 degres Celsius",
                "La crevette pistolet peux créer un point chaud de 4700 degrés Celsius"+"\n"+" se rapprochant de la température à la surface du Soleil (5900 degrès)");
        questionList.add(question10);

        Question question11 = new Question("Quel est le plus grand mammifère marin connu ?",
                "L'orque", "La baleine grise", "La baleine bleue", "Le cachalot",
                "La baleine bleue", "Le plus grand mammifère marin connu est la baleine bleue avec en moyenne"+"\n"+"25 mètres de long pour 130 tonnes");
        questionList.add(question11);

        Question question12 = new Question("Quel est le jeu vidéo le plus vendu de l'histoire ?", "Tetris", "Minecraft",
                "Wii Sports", "Grand Theft Auto V", "Minecraft", "Minecraft est le jeu vidéo le plus vendu de l'histoire avec 238 millions d'unités vendus");
        questionList.add(question12);

        Question question13 = new Question("En quelle année est sorti le film 'Le voyage dans la Lune' de Georges Méliès ?", "1898",
                "1921", "1937", "1902", "1902", "Le voyage dans la Lune est sorti en 1902 et est la première oeuvre de Science-fiction au cinéma");
        questionList.add(question13);

        Question question14 = new Question("Quelle est la distance Terre-Lune au point le plus proche ?", "245 320km",
                "356 700km", "406 300km", "556 820km", "356 700km",
                "Lorsque la Lune est à son périgée la distance Terre-Lune est de 356 700km");
        questionList.add(question14);

        Question question15 = new Question("Quel est l'âge de l'arbre le plus vieux du monde ?", "4855ans",
                "3650ans", "2305ans", "3122ans", "4855ans",
                "L'arbre le plus vieux du monde est un Pin Bristlecone nommé Mathusalem et âgé de 4855ans");
        questionList.add(question15);

        Question question16 = new Question("Quel est le plus grand océan du monde en superficie ?", "Océan Indien",
                "Océan Antarctique", "Océan Pacifique", "Océan Atlantique", "Océan Pacifique",
                "L'Océan Pacifique est le plus grand océan du monde avec environ 166 millions de km²");
        questionList.add(question16);

        Question question17 = new Question("De quand date la construction de la pyramide de Khéops", "Vers 2560 av J.C",
                "Vers 1560 av J.C", "Vers 3800 av J.C", "Vers 720 av J.C", "Vers 2560 av J.C",
                "La pyramide de Khéops fut édifiée vers 2560 av J.C, il y a plus de 4500ans" +"\n"+"et est la plus grande pyramide de Gizeh");
        questionList.add(question17);

        Question question18 = new Question("De combien d'états sont composés les Etats-Unis ?", "37", "63",
                "43", "50", "50", "Les Etats-Unis sont composés de 50 états");
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

        Question question22 = new Question("Quelle est la deuxième langue la plus parlée en Inde ?", "Le Tamoul",
                "Le Bengali", "Le Pendjabi", "Le Népalais", "Le Bengali",
                "Le Bengali est la 2ème langue la plus parlée en Inde, avec 268 millions de locuteurs");
        questionList.add(question22);
    }

    public ArrayList<Question> getQuestionList() {
        return questionList;
    }
}
