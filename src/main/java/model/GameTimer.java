package model;

public class GameTimer
{
    public static long startTime;
    public static long elapsedTime;
    public static long secondsDisplay;
    public static long elapsedMinutes;
    public static long elapsedSeconds;
    public static void startTimer()
    {
        startTime = System.currentTimeMillis();
    }

    public static void stopTimer()
    {
        elapsedTime = System.currentTimeMillis() - startTime;
    }

    public static void setTimerDisplay()
    {
        elapsedSeconds = elapsedTime / 1000;
        secondsDisplay = elapsedSeconds % 60;
        elapsedMinutes = elapsedSeconds / 60;
    }
}
