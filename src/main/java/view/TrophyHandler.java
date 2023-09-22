package view;

import java.io.*;

public class TrophyHandler
{

    public TrophyHandler()
    {
        // No need to instantiate something, this class handle writing and reading in files
    }

    public void writeInCupFile(File file, String stringToUse, String lineToReplace)
    {
        try {
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                String lineReplacement = lineToReplace.replace(lineToReplace, stringToUse);
                bw.write(lineReplacement);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public StringBuilder readInCupFile(File file)
    {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while((line = bufferedReader.readLine()) != null)
            {
                stringBuilder.append(line).append("\n");
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder;
    }
}
