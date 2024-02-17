package util;

import model.handlers.PersonalizeQuestionsHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class FileUtil {

    private static final Logger logger = LogManager.getLogger(FileUtil.class);
    protected static Properties generalSavesFile = new Properties();
    protected static Properties personalizeQuestionsFile = new Properties();

    public static void loadFile(Properties properties, final String filePath)
    {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            logger.error("Stream can't be create");
        }
        try {
            properties.load(fileInputStream);
        } catch (IOException e) {
            logger.error("File not found");
            logger.error(filePath);
        }
        finally {
            if(fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    logger.error("Stream can't be close");
                }
            }
        }
    }

    public static void writeNormalModInJsonFile(String gameMod, String playerName, int playerScore, String scoreOn, int questionCount, long elapsedMinute, String gameMinute, long elapsedSecond, String gameSecond)
    {
        List<JSONObject> jsonObjectList = readJsonFile();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("gameMod", gameMod);
        jsonObject.put("playerName", playerName);
        jsonObject.put("playerScore", playerScore + " " + scoreOn + " " + questionCount);
        jsonObject.put("playerTimer", elapsedMinute + " " + gameMinute + " " + elapsedSecond + " " + gameSecond);
        jsonObjectList.add(jsonObject);
        FileWriter file = null;
        try {
            file = new FileWriter("./src/main/resources/SaveFile/GamesSaveFile.json");
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("File can't be found");
        }
        try {
            assert file != null;
            file.append(jsonObjectList.toString());
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Can't write in save file");
        }
        try {
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("File can't be closed");
        }
    }
    public static void writeSurvivalModeInJsonFile(String gameMod, String playerName, int questionCount, String questions, long elapsedMinute, String gameMinute, long elapsedSecond, String gameSecond)
    {
        List<JSONObject> jsonObjectList = readJsonFile();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("gameMod", gameMod);
        jsonObject.put("playerName", playerName);
        jsonObject.put("playerScore", questionCount + questions);
        jsonObject.put("playerTimer", elapsedMinute + " " + gameMinute + " " + elapsedSecond + " " + gameSecond);
        jsonObjectList.add(jsonObject);
        FileWriter file = null;
        try {
            file = new FileWriter("./src/main/resources/SaveFile/GamesSaveFile.json");
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("File can't be found");
        }
        try {
            assert file != null;
            file.write(jsonObjectList.toString());
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Can't write in save file");
        }
        try {
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("File can't be closed");
        }
    }

    public static void storeGeneralSavesFile()
    {
        try (FileWriter fileWriter = new FileWriter(PathUtil.GENERAL_SAVES_FILE)){
            generalSavesFile.store(fileWriter, "");
        } catch (IOException e) {
            logger.error("General file can't be store");
        }
    }

    public static void storePersonalizeQuestionsFile()
    {
        try (FileWriter fileWriter = new FileWriter(PathUtil.PERSONALIZE_QUESTIONS_FILE)){
            personalizeQuestionsFile.store(fileWriter, "");
        } catch (IOException e) {
            logger.error("Personalize questions file can't be store");
        }
    }

    public static void resetPersonalizeQuestionFile()
    {
        personalizeQuestionsFile.clear();
        personalizeQuestionsFile.setProperty(PersonalizeQuestionsHandler.QUESTION_NUMBER_KEY_PROPERTIES, "0");
        storePersonalizeQuestionsFile();
    }

    public static List<JSONObject> readJsonFile()
    {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = null;
        try {
                reader = new FileReader("./src/main/resources/SaveFile/GamesSaveFile.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            logger.error("File can't be found");
        }
        List<JSONObject> jsonArrayList = new ArrayList<>();
            try {
                jsonArrayList = (List<JSONObject>) jsonParser.parse(reader);
            } catch (ParseException | IOException e) {
                e.printStackTrace();
                logger.error("object can't be parsed");
            }
            return jsonArrayList;
    }

    public static void resetJsonFile()
    {
        List<JSONObject> jsonObjectList = readJsonFile();
        jsonObjectList.clear();
        FileWriter file = null;
        try {
            file = new FileWriter("./src/main/resources/SaveFile/GamesSaveFile.json");
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("File can't be found");
        }
        try {
            assert file != null;
            file.write(jsonObjectList.toString());
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Can't write in save file");
        }
        try {
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("File can't be closed");
        }
    }

    public static void actualizeJsonFile(List<JSONObject> jsonObjectList)
    {
        FileWriter file = null;
        try {
            file = new FileWriter("./src/main/resources/SaveFile/GamesSaveFile.json");
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("File can't be found");
        }
        try {
            assert file != null;
            file.write(jsonObjectList.toString());
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Can't write in save file");
        }
        try {
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("File can't be closed");
        }
    }

    public static void resetGeneralSavesFile()
    {
        generalSavesFile.setProperty("goldCup", "0");
        generalSavesFile.setProperty("silverCup", "0");
        generalSavesFile.setProperty("bronzeCup", "0");
        generalSavesFile.setProperty("secretCup", "0");

        generalSavesFile.setProperty("perfectScore10", "0");
        generalSavesFile.setProperty("perfectScore15", "0");
        generalSavesFile.setProperty("perfectScore20", "0");

        generalSavesFile.setProperty("survivalScore20", "0");
        generalSavesFile.setProperty("survivalScore30", "0");
        generalSavesFile.setProperty("survivalScore50", "0");

        generalSavesFile.setProperty("numberOfGames", "0");
        generalSavesFile.setProperty("questionAnswered", "0");
        generalSavesFile.setProperty("goodAnswerNumber", "0");
        generalSavesFile.setProperty("badAnswerNumber", "0");
        generalSavesFile.setProperty("timePlayed", "0");
        generalSavesFile.setProperty("numberOfNormalGames", "0");
        generalSavesFile.setProperty("numberOfSurvivalGames", "0");

        FileUtil.storeGeneralSavesFile();
    }

    public static void incrementGeneralStat(String propertyKey)
    {
        int checkForStat = Integer.parseInt(generalSavesFile.getProperty(propertyKey));
        checkForStat++;
        generalSavesFile.setProperty(propertyKey, String.valueOf(checkForStat));
        storeGeneralSavesFile();
    }

    public static void createAndLoadFiles()
    {
        FileUtil.loadFile(generalSavesFile, PathUtil.GENERAL_SAVES_FILE);
        FileUtil.loadFile(personalizeQuestionsFile, PathUtil.PERSONALIZE_QUESTIONS_FILE);
    }

    public static Properties getGeneralSavesFile() {
        return generalSavesFile;
    }

    public static Properties getPersonalizeQuestionsFile() {
        return personalizeQuestionsFile;
    }
}
