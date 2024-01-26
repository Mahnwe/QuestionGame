package model;

import javafx.animation.PauseTransition;
import javafx.scene.control.Label;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.FileUtil;

import java.io.*;
import java.util.*;

public class ImportFileHandler {

    private static final Logger logger = LogManager.getLogger(ImportFileHandler.class);
    private static final List<Question> importPersonalizeQuestionList = new ArrayList<>();
    private static final ArrayList<String> listeStringQuestion = new ArrayList<>();
    private static final List<Properties> propertiesList = new ArrayList<>();
    private static final String PERSONALIZE_QUESTION_PATH = "./src/main/resources/PersonalizeQuestions/PersonalizeQuestions.properties";
    private static final String IMPORT_PATH = "./src/main/resources/ImportFile";
    private static final String PREFIX_CHECK_FILE_PATH = "./src/main/resources/ImportFile/ImportPersonalizeQuestion";
    private static final String SUFFIX_CHECK_FILE_PATH = ".properties";

    public static void setUpOpenDirectoryButton(String directoryPath)
    {
            Stage fileChooserStage = new Stage();
            fileChooserStage.initModality(Modality.APPLICATION_MODAL);
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new File(directoryPath));
            fileChooser.setTitle("Open Resource File");
            fileChooser.showOpenDialog(fileChooserStage);
    }

    public static void setUpCopyFileButton()
    {
            List<File> fileList = new ArrayList<>();
            File file = new File(PERSONALIZE_QUESTION_PATH);
            fileList.add(file);
            Clipboard clipboard = Clipboard.getSystemClipboard();
            ClipboardContent clipboardContent = new ClipboardContent();
            clipboardContent.putFiles(fileList);
            clipboard.setContent(clipboardContent);
    }

    public static void addFileToList()
    {
        FileChooser fileChooserGetNumber = new FileChooser();
        fileChooserGetNumber.setInitialDirectory(new File(IMPORT_PATH));
        int numberOfFileInDirectory = Objects.requireNonNull(fileChooserGetNumber.getInitialDirectory().listFiles()).length;
        FileUtil.getGeneralSavesFile().setProperty("numberOfImportFile", String.valueOf(numberOfFileInDirectory));
        FileUtil.storeGeneralSavesFile();
        int numberOfImportFile = Integer.parseInt(FileUtil.getGeneralSavesFile().getProperty("numberOfImportFile"));
        if(numberOfImportFile >= 1) {
            for (int i = 0; i < Objects.requireNonNull(fileChooserGetNumber.getInitialDirectory().listFiles()).length; i++)
            {
                    Properties propertiesFile;
                    String getPath = Arrays.stream(Objects.requireNonNull(fileChooserGetNumber.getInitialDirectory().listFiles())).toList().get(i).getAbsolutePath();
                    propertiesFile = loadFile(getPath);
                    propertiesList.add(propertiesFile);
            }
        }
    }

    public static void addImportPersonalizeQuestionsToStringList()
    {
        addFileToList();
        int numberOfImportFiles = Integer.parseInt(FileUtil.getGeneralSavesFile().getProperty("numberOfImportFile"));
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

    public static void setUpButtonFileFromImport(Label label)
    {
            if(Clipboard.getSystemClipboard().hasFiles()) {
                Properties propertiesImportFile = new Properties();
                File file = getClipboardFile();
                if (file.getName().equals("PersonalizeQuestions.properties")) {
                    readSaveFile(propertiesImportFile, file);

                    int numberOfImportFile = Integer.parseInt(FileUtil.getGeneralSavesFile().getProperty("numberOfImportFile"));
                    numberOfImportFile++;
                    boolean isFull = true;
                    FileChooser fileCheckForImportPlace = new FileChooser();
                    fileCheckForImportPlace.setInitialDirectory(new File(IMPORT_PATH));

                    checkFileSlotInDirectory(fileCheckForImportPlace, numberOfImportFile, isFull, propertiesImportFile, label);
                }
            }
            Clipboard clipboardImportFile = Clipboard.getSystemClipboard();
            clipboardImportFile.clear();
    }

    public static File getClipboardFile()
    {
        Clipboard clipboardImportFile = Clipboard.getSystemClipboard();
        List<File> listOfFiles;
        listOfFiles = (List<File>) clipboardImportFile.getContent(DataFormat.FILES);
        return listOfFiles.get(0);
    }

    public static void checkFileSlotInDirectory(FileChooser fileCheckForImportPlace, int numberOfImportFile, boolean isFull, Properties propertiesImportFile, Label label)
    {
        for (int i = 0; i < Objects.requireNonNull(fileCheckForImportPlace.getInitialDirectory().listFiles()).length; i++) {
            String checkAllPath = PREFIX_CHECK_FILE_PATH + i + SUFFIX_CHECK_FILE_PATH;
            if (!checkAllPath.equals(Arrays.stream(Objects.requireNonNull(fileCheckForImportPlace.getInitialDirectory().listFiles())).toList().get(i).getAbsolutePath())) {
                FileUtil.getGeneralSavesFile().setProperty("numberOfImportFile", String.valueOf(numberOfImportFile));
                FileUtil.storeGeneralSavesFile();
                String getI = String.valueOf(i);
                storeImportPersonalizeQuestionsFile(propertiesImportFile, PREFIX_CHECK_FILE_PATH + getI + SUFFIX_CHECK_FILE_PATH);
                isFull = false;
                displayLabelAfterImport(label);
            }
        }
        if (isFull) {
            FileUtil.getGeneralSavesFile().setProperty("numberOfImportFile", String.valueOf(numberOfImportFile));
            FileUtil.storeGeneralSavesFile();
            int calculateNumber = (numberOfImportFile - 1);
            storeImportPersonalizeQuestionsFile(propertiesImportFile, PREFIX_CHECK_FILE_PATH + calculateNumber + SUFFIX_CHECK_FILE_PATH);
            displayLabelAfterImport(label);
        }
    }
    public static void displayLabelAfterImport(Label label)
    {
        label.setVisible(true);
        PauseTransition visiblePause = new PauseTransition(Duration.seconds(5));
        visiblePause.setOnFinished(event -> label.setVisible(false));
        visiblePause.play();
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
            logger.error("Save file can't be read"+e.getMessage());
        }
    }

    public static void storeImportPersonalizeQuestionsFile(Properties properties, String fullPathFile)
    {
        try (FileWriter fileWriter = new FileWriter(fullPathFile)){
            properties.store(fileWriter, "");
        } catch (IOException e) {
            logger.error("Personalize questions file can't be store"+e.getMessage());
        }
    }
    public static Properties loadFile(final String filePath)
    {
        FileInputStream fileInputStream = null;
        Properties properties = new Properties();
        try {
            fileInputStream = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            logger.error("Stream can't be create"+e.getMessage());
        }
        try {
            properties.load(fileInputStream);
        } catch (IOException e) {
            logger.error("File not found"+e.getMessage());
            logger.error(filePath);
        }
        finally {
            if(fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    logger.error("Stream can't be close"+e.getMessage());
                }
            }
        }
        return properties;
    }

    public static List<Question> getImportPersonalizeQuestionList() {
        return importPersonalizeQuestionList;
    }
    public static String getImportPath() {
        return IMPORT_PATH;
    }
}
