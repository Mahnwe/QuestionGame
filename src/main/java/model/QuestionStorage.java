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
        Question question1 = new Question("Quelle est la superficie du Brésil ?","8 547 404km²",
                "3 682 607km²", "5 360 419km²", "10 853 730km²", "8 547 404km²",
                "Le Brésil fait 8 547 404km² ce qui en fait le 5ème plus grand pays du monde en superficie"+"\n"+"et le 1er en Amérique du sud");
        questionList.add(question1);

        Question question2 = new Question("Quelle est la date de la bataille d'Alésia ?", "253 ap JC",
                "186 av JC", "67 ap JC", "52 av JC", "52 av JC",
                "La bataille d'Alésia se déroule en 52 av JC et des peuples habitant la 'Gaule'"+"\n"+"(appelés ainsi par Jule César) et les armées romaines menées par ce dernier");
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

        Question question10 = new Question("A quelle température est le point chaud crée par la pince de la crevette pistolet ?",
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
                "L'arbre le plus vieux du monde est un Pin Bristlecone"+"\n"+"nommé Mathusalem et âgé de 4855ans");
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
                "plier un métal", "Parler inutilement", "Être à l'opposé", "Parler inutilement", "lantiponner veux dire parler inutilement, de manière frivole ou importun");
        questionList.add(question29);

        Question question30 = new Question("Quand se sont éteints les dinosaures ?", "Il y a 46 millions d'années", "Il y a 66 millions d'années",
                "Il y a 86 millions d'années", "Il y a 106 millions d'années", "Il y a 66 millions d'années", "Les dinosaures ont disparu il y a environ 66 millions d'années");
        questionList.add(question30);

        Question question31 = new Question("Quelle est la taille de l'humain le plus grand de l'histoire ?", "2,32 mètres",
                "2,72 mètres", "2,51 mètres", "2,97 mètres", "2,72 mètres", "Robert Wadlow est l'homme le plus grand de l'histoire et mesurait 2,72 mètres au moment de sa mort en 1940");
        questionList.add(question31);

        Question question32 = new Question("Athéna était la déesse de la sagesse, des artisans et des artistes, mais aussi de", "La statégie militaire", "L'olivier",
                "L'enfance", "La ruse", "La stratégie militaire", "Dans la mythologie grecque Athéna était la déesse de la sagesse, des artisans et des artistes,"+"\n"+"mais aussi de la stratégie militaire et des maitres d'écoles");
        questionList.add(question32);

        Question question33 = new Question("Quel est le fruit le plus consommé en France ?", "La banane", "La poire", "L'orange", "La pomme",
                "La pomme", "La pomme est le fruit le plus consommé en france, juste devant la banane et l'orange");
        questionList.add(question33);
    }

    public List<Question> getQuestionList() {
        return questionList;
    }
}
