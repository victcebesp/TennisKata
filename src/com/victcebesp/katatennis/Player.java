package com.victcebesp.katatennis;

public class Player {

    protected Score score;

    public Player() {
        this.score = new Score();
    }

    public int getPoints() {
        return score.getPoints();
    }

    public void addPoint() {
        score.addPoint();
    }

    public int getSetPoints() {
        return score.getSetPoints();
    }

    public void addSetPoint() {
        score.addSetPoint();
    }

    public void addAdvantage() {
        score.addAdvantage();
    }

    public int getAdvantages() {
        return score.getAdvantage();
    }

    public void restartPoints() {
        score.setPoints(0);
    }

    public void restartAdvantages() {
        score.setAdvantages(0);
    }
}
