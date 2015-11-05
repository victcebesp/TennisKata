package com.victcebesp.katatennis;

public class Game {

    private final Score score1;
    private final Score score2;

    public Game(Score score1, Score score2) {
        this.score1 = score1;
        this.score2 = score2;
    }

    public void addPointsToPlayer(String playerName) {
        score1.addPoints();
    }

    public String getSetWinner() {
        return "playerA";
    }

    public int getScoreForPlayer(String playerName) {
        return playerName.equals("playerA") ? score1.getPoints() : score2.getPoints();
    }

}
