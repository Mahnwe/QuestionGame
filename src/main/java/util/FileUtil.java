package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Properties;


public class FileUtil {

    private static final Logger logger = LogManager.getLogger(FileUtil.class);
    public static Properties generalSavesFile = new Properties();
    public static Properties personalizeQuestionsFile = new Properties();
    public static File saveFile;

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

    public static void createSaveFile()
    {
        saveFile = new File("./src/main/resources/SaveFile/saveScoresFile");
    }

    public static StringBuilder readSaveFile(File saveFile)
    {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(saveFile))){
            String line;
            while((line = bufferedReader.readLine()) != null)
            {
                stringBuilder.append(line).append("\n").append("\n");
            }
        } catch (IOException e) {
                logger.error("Save file can't be read");
        }
        return stringBuilder;
    }

    public static void writeInSaveFile(File saveFile, String lineToWrite)
    {
        try {
            boolean append = true;
            FileWriter fw = new FileWriter(saveFile.getAbsoluteFile(), append);
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write(lineToWrite);
            }
        }catch (IOException e) {
            e.printStackTrace();
            logger.error("Can't write in save file");
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

    public static void resetSaveFile()
    {
        try {
            FileWriter fw = new FileWriter(saveFile.getAbsoluteFile());
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write("");
            }
        }catch (IOException e) {
            e.printStackTrace();
            logger.error("Save file can't be reset");
        }
    }

    public static void resetGeneralSavesFile()
    {
        generalSavesFile.setProperty("goldCup", "0");
        generalSavesFile.setProperty("silverCup", "0");
        generalSavesFile.setProperty("bronzeCup", "0");

        generalSavesFile.setProperty("perfectScore10", "0");
        generalSavesFile.setProperty("perfectScore15", "0");
        generalSavesFile.setProperty("perfectScore20", "0");

        generalSavesFile.setProperty("survivalScore20", "0");
        generalSavesFile.setProperty("survivalScore30", "0");
        generalSavesFile.setProperty("survivalScore50", "0");
        FileUtil.storeGeneralSavesFile();
    }

}
