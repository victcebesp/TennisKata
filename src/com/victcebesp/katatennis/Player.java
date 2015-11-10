package com.victcebesp.katatennis;

public class Player {
    private String playerName;
    private Score score;

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

    public void addAdvantage() {
        score.addAdvantage();
    }

    public int getAdvantage() {
        return score.getAdvantage();
    }
}
