package model;

import javafx.scene.control.Button;
import javafx.scene.input.Clipboard;
import javafx.scene.input.DataFormat;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.FileUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ImportFileHandler {

    private static final Logger logger = LogManager.getLogger(ImportFileHandler.class);
    public static String ressourcesString = "./src/main/resources/PersonalizeQuestions/";
    public static String fileImportName = "ImportPersonalizeQuestion"+FileUtil.generalSavesFile.getProperty("numberOfImportFile")+".properties";
    private static final String FULL_PATH_FILE = ressourcesString+fileImportName;
    public static List<Question> importPersonalizeQuestionList = new ArrayList<>();
    private static final ArrayList<String> listeStringQuestion = new ArrayList<>();
    public static final ArrayList<Properties> propertiesList = new ArrayList<>();

    public static void setUpCopyButton(Button button)
    {
        button.setOnAction(event -> {
            Stage fileChooserStage = new Stage();
            fileChooserStage.initModality(Modality.APPLICATION_MODAL);
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new File("C:\\Users\\mat-d\\IdeaProjects\\QuestionGame\\src\\main\\resources\\PersonalizeQuestions"));
            fileChooser.setTitle("Open Resource File");
            fileChooser.showOpenDialog(fileChooserStage);
        });
    }

    public static void addImportPersonalizeQuestionsToStringList()
    {
        int numberOfImportFiles = Integer.parseInt(FileUtil.generalSavesFile.getProperty("numberOfImportFile"));
        for(int i = 0; i < numberOfImportFiles; i++) {
            int propertyKeyQuestionNumber = Integer.parseInt(propertiesList.get(i).getProperty(PersonalizeQuestionsHandler.QUESTION_NUMBER_KEY_PROPERTIES));
            String propertyReadQuestionKey;
            for (int x = 0; x < propertyKeyQuestionNumber; x++) {
                propertyReadQuestionKey = PersonalizeQuestionsHandler.getPropertyKeyStart() + x;
                listeStringQuestion.add(propertiesList.get(i).getProperty(propertyReadQuestionKey + PersonalizeQuestionsHandler.PROPERTY_KEY_CATEGORY));
                listeStringQuestion.add(propertiesList.get(i).getProperty(propertyReadQuestionKey + PersonalizeQuestionsHandler.PROPERTY_KEY_QUESTION));
                listeStringQuestion.add(propertiesList.get(i).getProperty(propertyReadQuestionKey + PersonalizeQuestionsHandler.PROPERTY_KEY_ANSWER_A));
                listeStringQuestion.add(propertiesList.get(i).getProperty(propertyReadQuestionKey + PersonalizeQuestionsHandler.PROPERTY_KEY_ANSWER_B));
                listeStringQuestion.add(propertiesList.get(i).getProperty(propertyReadQuestionKey + PersonalizeQuestionsHandler.PROPERTY_KEY_ANSWER_C));
                listeStringQuestion.add(propertiesList.get(i).getProperty(propertyReadQuestionKey + PersonalizeQuestionsHandler.PROPERTY_KEY_ANSWER_D));
                listeStringQuestion.add(propertiesList.get(i).getProperty(propertyReadQuestionKey + PersonalizeQuestionsHandler.PROPERTY_KEY_GOOD_ANSWER));
                listeStringQuestion.add(propertiesList.get(i).getProperty(propertyReadQuestionKey + PersonalizeQuestionsHandler.PROPERTY_KEY_EXPLANATION));

                Question personalizeQuestion = new Question(listeStringQuestion.get(0), listeStringQuestion.get(1), listeStringQuestion.get(2), listeStringQuestion.get(3), listeStringQuestion.get(4), listeStringQuestion.get(5), listeStringQuestion.get(6), listeStringQuestion.get(7));
                importPersonalizeQuestionList.add(personalizeQuestion);
                listeStringQuestion.clear();
            }
        }
    }

    public static void setUpButtonFileFromImport(Button button)
    {
        button.setOnAction(event -> {
            if(Clipboard.getSystemClipboard().hasFiles()) {
                Properties propertiesImportFile = new Properties();
                Clipboard clipboardImportFile = Clipboard.getSystemClipboard();
                List listOfFiles;
                listOfFiles = (List) clipboardImportFile.getContent(DataFormat.FILES);
                File file = (File) listOfFiles.get(0);
                readSaveFile(propertiesImportFile, file);
                int numberOfImportFile = Integer.parseInt(FileUtil.generalSavesFile.getProperty("numberOfImportFile"));
                numberOfImportFile++;
                FileUtil.generalSavesFile.setProperty("numberOfImportFile", String.valueOf(numberOfImportFile));
                FileUtil.storeGeneralSavesFile();
                storePersonalizeQuestionsFile(propertiesImportFile);
                propertiesList.add(propertiesImportFile);
            }
        });
    }

    public static void readSaveFile(Properties properties, File file)
    {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String line;
            int lineNumber = 0;
            while((line = bufferedReader.readLine()) != null)
            {
                if(lineNumber >= 2) {
                    String[] splitString = line.split("=");
                    properties.setProperty(splitString[0], splitString[1]);
                }
                lineNumber++;
            }
        } catch (IOException e) {
            logger.error("Save file can't be read");
        }
    }

    public static void storePersonalizeQuestionsFile(Properties properties)
    {
        try (FileWriter fileWriter = new FileWriter(FULL_PATH_FILE)){
            properties.store(fileWriter, "");
        } catch (IOException e) {
            logger.error("Personalize questions file can't be store");
        }
    }

    public static String getFullPathFile() {
        return FULL_PATH_FILE;
    }
}
