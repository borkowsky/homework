package by.it_academy.homework.practice6;

public class TimeConverter {
    private int seconds = 0;
    private int minutes = 0;
    private int hours = 0;

    public TimeConverter(int hours, int minutes, int seconds) {
        this.seconds = seconds;
        this.minutes = minutes;
        this.hours = hours;
    }

    public TimeConverter(int seconds) {
        this.seconds = seconds % 60;
        this.minutes = (seconds / 60) % 60;
        this.hours = (seconds / 3600) % 24;
    }

    public String toString() {
        return "Hours: " + hours + ", minutes: " + minutes + ", seconds: " + seconds;
    }

    public boolean isEqual(TimeConverter timeConverter) {
        return (timeConverter.hours == this.hours) && (timeConverter.minutes == this.minutes) && (timeConverter.seconds == this.seconds);
    }

    public int getSeconds() {
        return (hours * 3600) + (minutes * 60) + seconds;
    }
}
