package util;

import java.io.*;
import java.util.Properties;

public class FileUtil {

    public static Properties perfectScoreFile = new Properties();
    public static Properties cupFile = new Properties();
    public static File saveFile;

    public static void loadFile(Properties properties, final String filePath)
    {
        try {
            properties.load(new FileInputStream(filePath));
        } catch (IOException e) {
            System.err.println("File not found"+ properties+ filePath);

        }
    }

    public static void createSaveFile()
    {
        saveFile = new File("./src/main/resources/SaveFile/saveScoresFile");
    }

    public static StringBuilder readSaveFile(File saveFile)
    {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(saveFile));
            String line;
            while((line = bufferedReader.readLine()) != null)
            {
                stringBuilder.append(line).append("\n");
            }
            bufferedReader.close();
        } catch (IOException e) {

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
        }
    }

    public static void storePerfectFile()
    {
        try {
            perfectScoreFile.store(new FileWriter(PathUtil.PERFECT_SCORE_FILE), "");
        } catch (IOException e) {
        }
    }

    public static void storeCupFile()
    {
        try {
            cupFile.store(new FileWriter(PathUtil.CUP_FILE), "");
        } catch (IOException e) {
        }
    }
}
