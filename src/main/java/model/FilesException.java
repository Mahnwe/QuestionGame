package model;

public class FilesException extends Exception {

    public FilesException()
    {

    }
    public FilesException(String exceptionName, String message)
    {
        System.out.println(exceptionName);
        System.out.println(message);
    }
}
