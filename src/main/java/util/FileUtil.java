package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Properties;


public class FileUtil {

    private static final Logger logger = LogManager.getLogger(FileUtil.class);
    public static Properties perfectScoreFile = new Properties();
    public static Properties cupFile = new Properties();
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

    public static void storePerfectFile()
    {
        try (FileWriter fileWriter = new FileWriter(PathUtil.PERFECT_SCORE_FILE)) {
            perfectScoreFile.store(fileWriter, "");
        } catch (IOException e) {
            logger.error("Perfect score file can't be store");
        }
    }

    public static void storeCupFile()
    {
        try (FileWriter fileWriter = new FileWriter(PathUtil.CUP_FILE)){
            cupFile.store(fileWriter, "");
        } catch (IOException e) {
            logger.error("Cup file can't be store");
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

    public static void resetCupFile()
    {
        cupFile.setProperty("goldCup", "0");
        cupFile.setProperty("silverCup", "0");
        cupFile.setProperty("bronzeCup", "0");
        FileUtil.storeCupFile();
    }

    public static void resetPerfectFile()
    {
        perfectScoreFile.setProperty("perfectScore10", "0");
        perfectScoreFile.setProperty("perfectScore15", "0");
        perfectScoreFile.setProperty("perfectScore20", "0");
        FileUtil.storePerfectFile();
    }

}
