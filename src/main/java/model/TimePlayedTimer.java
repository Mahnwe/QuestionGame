package model;

public class TimePlayedTimer {
    private static long startTime;
    private static long elapsedTime;
    private static long secondsDisplay;
    private static long elapsedHours;
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

    public static void setTimerDisplay(long timePlayedInFile)
    {
        setElapsedSeconds(timePlayedInFile / 1000);
        setSecondsDisplay(getElapsedSeconds() % 60);
        setElapsedMinutes(getElapsedSeconds() / 60);
        setElapsedHours(getElapsedMinutes() / 60);
    }

    private static long getStartTime() {
        return startTime;
    }

    private static void setStartTime(long startTime) {
        TimePlayedTimer.startTime = startTime;
    }

    public static long getElapsedTime() {
        return elapsedTime;
    }

    private static void setElapsedTime(long elapsedTime) {
        TimePlayedTimer.elapsedTime = elapsedTime;
    }

    public static long getSecondsDisplay() {
        return secondsDisplay;
    }

    private static void setSecondsDisplay(long secondsDisplay) {
        TimePlayedTimer.secondsDisplay = secondsDisplay;
    }

    public static long getElapsedHours() { return elapsedHours; }

    public static void setElapsedHours(long elapsedHours) {
        TimePlayedTimer.elapsedHours = elapsedHours;
    }

    public static long getElapsedMinutes() {
        return elapsedMinutes;
    }

    private static void setElapsedMinutes(long elapsedMinutes) {
        TimePlayedTimer.elapsedMinutes = elapsedMinutes;
    }

    public static long getElapsedSeconds() {
        return elapsedSeconds;
    }

    private static void setElapsedSeconds(long elapsedSeconds) {
        TimePlayedTimer.elapsedSeconds = elapsedSeconds;
    }

}
