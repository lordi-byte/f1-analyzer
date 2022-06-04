package com.helmrich.f1analyzer.domain.entities;

public class Result {
    private String position;
    private int fastestLapPosition;
    private String fastestLapTime;
    private double fastestLapAvgSpeed;
    private int raceTimeInMilli;
    private double points;
    private Driver driver;
    private int grid;
    private int laps;
    private String status;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getFastestLapPosition() {
        return fastestLapPosition;
    }

    public void setFastestLapPosition(int fastestLapPosition) {
        this.fastestLapPosition = fastestLapPosition;
    }


    public String getFastestLapTime() {
        return fastestLapTime;
    }

    public void setFastestLapTime(String fastestLapTime) {
        this.fastestLapTime = fastestLapTime;
    }


    public double getFastestLapAvgSpeed() {
        return fastestLapAvgSpeed;
    }

    public void setFastestLapAvgSpeed(double fastestLapAvgSpeed) {
        this.fastestLapAvgSpeed = fastestLapAvgSpeed;
    }

    public int getRaceTimeInMilli() {
        return raceTimeInMilli;
    }

    public void setRaceTimeInMilli(int raceTimeInMilli) {
        this.raceTimeInMilli = raceTimeInMilli;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public int getGrid() {
        return grid;
    }

    public void setGrid(int grid) {
        this.grid = grid;
    }

    public int getLaps() {
        return laps;
    }

    public void setLaps(int laps) {
        this.laps = laps;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Platz: " + getPosition() + ", Punkte: " + getPoints() + ", Name: " + driver.getGivenName() + " " + driver.getFamilyName() + "\n";
    }
}
