package view;

import java.io.*;

public class TrophyHandler
{
    private final File goldCupFile;
    private final File silverCupFile;
    private final File bronzeCupFile;

    public TrophyHandler(File goldCupFile, File silverCupFile, File bronzeCupFile)
    {
        this.goldCupFile = goldCupFile;
        this.silverCupFile = silverCupFile;
        this.bronzeCupFile = bronzeCupFile;
    }

    public void writeInGoldCupFile(String stringToUse, String lineToReplace)
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
    public StringBuilder readInGoldCupFile()
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

    public void writeInSilverCupFile(String stringToUse, String lineToReplace)
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
    public StringBuilder readInSilverCupFile()
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

    public void writeInBronzeCupFile(String stringToUse, String lineToReplace)
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
    public StringBuilder readInBronzeCupFile()
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
