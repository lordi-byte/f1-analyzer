package com.helmrich.f1analyzer.domain.entities;

import java.util.ArrayList;
import java.util.List;

public class RaceResult {
    private Race race;
    private ArrayList<Result> resultList;

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public List<Result> getResultList() {
        return resultList;
    }

    public void setResultList(ArrayList<Result> resultList) {
        this.resultList = resultList;
    }

    public void addResultToList(Result result) {
        this.resultList.add(result);
    }

    @Override
    public String toString() {
        return race.toString() + "\n" + resultList.toString();
    }
}
