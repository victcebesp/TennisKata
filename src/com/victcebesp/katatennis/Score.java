package com.victcebesp.katatennis;

public class Score {

    private int score;
    private int advantage;

    public Score() {
        this.score = 0;
    }

    public void addPoint() {
        if (this.getPoints() == 40) addAdvantage();
        else score += score == 30 ? 10 : 15;
    }

    public int getPoints() {
        return score;
    }

    public int getAdvantage() {
        return advantage;
    }

    public void addAdvantage() {
        advantage++;
    }
}