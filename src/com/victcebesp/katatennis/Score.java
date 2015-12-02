package com.victcebesp.katatennis;

public class Score {

    private int score;
    private int advantage;
    private int setPoint;

    public Score() {
        this.score = 0;
    }


    public void addPoint() {
        score += score == 30 ? 10 : 15;
    }

    public int getPoints() {
        return score;
    }

    public void addAdvantage() {
        advantage++;
    }

    public int getAdvantage() {
        return advantage;
    }


    public void addSetPoint() {
        setPoint++;
    }

    public int getSetPoints() {
        return setPoint;
    }

}