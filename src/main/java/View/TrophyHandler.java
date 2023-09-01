package View;

import java.io.*;

public class TrophyHandler
{
    private final File goldCupFile;
    private final File silverCupFile;
    private final File bronzeCupFile;

    public TrophyHandler()
    {
        goldCupFile = new File("./src/main/resources/SaveFile/GoldCupFile");
        silverCupFile = new File("./src/main/resources/SaveFile/SilverCupFile");
        bronzeCupFile = new File("./src/main/resources/SaveFile/BronzeCupFile");
    }

    public void WriteInGoldCupFile(String stringToUse, String lineToReplace)
    {
        try {
            FileWriter fw = new FileWriter(goldCupFile.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            String lineReplacement = lineToReplace.replace(lineToReplace, stringToUse);
            bw.write(lineReplacement);
            bw.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public StringBuilder ReadInGoldCupFile()
    {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(goldCupFile));
            String line;
            while((line = bufferedReader.readLine()) != null)
            {
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder;
    }

    public void WriteInSilverCupFile(String stringToUse, String lineToReplace)
    {
        try {
            FileWriter fw = new FileWriter(silverCupFile.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            String lineReplacement = lineToReplace.replace(lineToReplace, stringToUse);
            bw.write(lineReplacement);
            bw.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public StringBuilder ReadInSilverCupFile()
    {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(silverCupFile));
            String line;
            while((line = bufferedReader.readLine()) != null)
            {
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder;
    }

    public void WriteInBronzeCupFile(String stringToUse, String lineToReplace)
    {
        try {
            FileWriter fw = new FileWriter(bronzeCupFile.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            String lineReplacement = lineToReplace.replace(lineToReplace, stringToUse);
            bw.write(lineReplacement);
            bw.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public StringBuilder ReadInBronzeCupFile()
    {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(bronzeCupFile));
            String line;
            while((line = bufferedReader.readLine()) != null)
            {
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder;
    }
}
