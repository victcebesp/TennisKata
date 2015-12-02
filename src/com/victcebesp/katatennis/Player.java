package com.victcebesp.katatennis;

public class Player {

    private String playerName;
    protected Score score;

    public Player(String playerName) {
        this.playerName = playerName;
        this.score = new Score();
    }

    public String getPlayerName() {
        return playerName;
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
}
