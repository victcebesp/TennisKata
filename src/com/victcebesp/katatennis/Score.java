package com.victcebesp.katatennis;


public class Score {

    private int score;
    private int matchPoints;
    private int advantage;

    public Score() {
        this.score = 0;
        this.matchPoints = 0;
    }

    public void addPoints() {
        score += score == 30 ? 10 : 15;
    }

    public int getPoints() {
        return score;
    }

}
