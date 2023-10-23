package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtil {

    public static Properties perfectScoreFile = new Properties();
    public static Properties cupFile = new Properties();

    public static void loadFile(Properties properties, final String filePath)
    {
        try {
            properties.load(new FileInputStream(filePath));
        } catch (IOException e) {
            System.err.println("File not found"+ properties+ filePath);

        }
    }
}
