package com.victcebesp.katatennis;


public class Score {

    private int score;
    private int matchPoints;
    private int advantage;

    public Score() {
        this.score = 0;
        this.matchPoints = 0;
    }


    public void addPoint() {
        score += score == 30 ? 10 : 15;
    }

    public void addMatchPoint() {
        matchPoints += 1;
    }
    public void addAdvantage() {
        advantage += 1;
    }

    public int getPoints() {
        return score;
    }

    public int getMatchPoints() {
        return matchPoints;
    }

    public int getAdvantage() {
        return advantage;
    }
}
