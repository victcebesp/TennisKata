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
        if (this.getPoints() == 40) addAdvantage();
        else score += score == 30 ? 10 : 15;
    }

    public void setPoints(int points) {
        this.score = points;
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

    public void addMatchPoints() {
        matchPoints = matchPoints + 1;
    }

    public int getMatchPoint() {
        return matchPoints;
    }
}
