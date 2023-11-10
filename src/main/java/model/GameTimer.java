package model;

public class GameTimer
{
    private static long startTime;
    private static long elapsedTime;
    private static long secondsDisplay;
    private static long elapsedMinutes;
    private static long elapsedSeconds;
    public static void startTimer()
    {
        setStartTime(System.currentTimeMillis());
    }

    public static void stopTimer()
    {
        setElapsedTime(System.currentTimeMillis() - getStartTime());
    }

    public static void setTimerDisplay()
    {
        setElapsedSeconds(getElapsedTime() / 1000);
        setSecondsDisplay(getElapsedSeconds() % 60);
        setElapsedMinutes(getElapsedSeconds() / 60);
    }

    private static long getStartTime() {
        return startTime;
    }

    private static void setStartTime(long startTime) {
        GameTimer.startTime = startTime;
    }

    private static long getElapsedTime() {
        return elapsedTime;
    }

    private static void setElapsedTime(long elapsedTime) {
        GameTimer.elapsedTime = elapsedTime;
    }

    public static long getSecondsDisplay() {
        return secondsDisplay;
    }

    private static void setSecondsDisplay(long secondsDisplay) {
        GameTimer.secondsDisplay = secondsDisplay;
    }

    public static long getElapsedMinutes() {
        return elapsedMinutes;
    }

    private static void setElapsedMinutes(long elapsedMinutes) {
        GameTimer.elapsedMinutes = elapsedMinutes;
    }

    public static long getElapsedSeconds() {
        return elapsedSeconds;
    }

    private static void setElapsedSeconds(long elapsedSeconds) {
        GameTimer.elapsedSeconds = elapsedSeconds;
    }
}
