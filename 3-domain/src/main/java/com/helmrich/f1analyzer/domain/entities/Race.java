package com.helmrich.f1analyzer.domain.entities;

public class Race {
    private String raceName;
    private String date;
    private String time;

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Ausgewähltes Rennen: " + getRaceName() + ", gefahren am: " + getDate() + ", zur Uhrzeit: " + getTime();
    }
}
