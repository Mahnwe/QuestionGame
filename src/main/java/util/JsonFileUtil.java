package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonFileUtil
{
    private static final Logger logger = LogManager.getLogger(JsonFileUtil.class);

    public static void writeNormalModInJsonFile(String gameMod, String playerName, int playerScore, String scoreOn, int questionCount, long elapsedMinute, String gameMinute, long elapsedSecond, String gameSecond)
    {
        List<JSONObject> jsonObjectList = readJsonFile();

        Map<String,String> jsonMap = new HashMap<>();
        jsonMap.put("gameMod", gameMod);
        jsonMap.put("playerName", playerName);
        jsonMap.put("playerScore", playerScore + " " + scoreOn + " " + questionCount);
        jsonMap.put("playerTimer", elapsedMinute + " " + gameMinute + " " + elapsedSecond + " " + gameSecond);

        JSONObject jsonObject = new JSONObject(jsonMap);
        jsonObjectList.add(jsonObject);
        FileWriter file = null;
        try
        {
            file = new FileWriter("./src/main/resources/SaveFile/GamesSaveFile.json");
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("File can't be found");
        }
        try
        {
            assert file != null;
            file.append(jsonObjectList.toString());
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Can't write in save file");
        }
        try
        {
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("File can't be closed");
        }
    }
    public static void writeSurvivalModeInJsonFile(String gameMod, String playerName, int questionCount, String questions, long elapsedMinute, String gameMinute, long elapsedSecond, String gameSecond)
    {
        List<JSONObject> jsonObjectList = readJsonFile();

        Map<String,String> jsonMap = new HashMap<>();
        jsonMap.put("gameMod", gameMod);
        jsonMap.put("playerName", playerName);
        jsonMap.put("playerScore", questionCount + questions);
        jsonMap.put("playerTimer", elapsedMinute + " " + gameMinute + " " + elapsedSecond + " " + gameSecond);

        JSONObject jsonObject = new JSONObject(jsonMap);
        jsonObjectList.add(jsonObject);
        FileWriter file = null;
        try
        {
            file = new FileWriter("./src/main/resources/SaveFile/GamesSaveFile.json");
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("File can't be found");
        }
        try
        {
            assert file != null;
            file.write(jsonObjectList.toString());
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Can't write in save file");
        }
        try
        {
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("File can't be closed");
        }
    }

    public static List<JSONObject> readJsonFile()
    {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = null;
        try
        {
            reader = new FileReader("./src/main/resources/SaveFile/GamesSaveFile.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            logger.error("File can't be found");
        }
        List<JSONObject> jsonArrayList = new ArrayList<>();
        try
        {
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
        try
        {
            file = new FileWriter("./src/main/resources/SaveFile/GamesSaveFile.json");
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("File can't be found");
        }
        try
        {
            assert file != null;
            file.write(jsonObjectList.toString());
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Can't write in save file");
        }
        try
        {
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("File can't be closed");
        }
    }

    public static void actualizeJsonFile(List<JSONObject> jsonObjectList)
    {
        FileWriter file = null;
        try
        {
            file = new FileWriter("./src/main/resources/SaveFile/GamesSaveFile.json");
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("File can't be found");
        }
        try
        {
            assert file != null;
            file.write(jsonObjectList.toString());
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Can't write in save file");
        }
        try
        {
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("File can't be closed");
        }
    }
}
