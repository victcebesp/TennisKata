package com.victcebesp.katatennis;

enum States{DEUCE, SIMILAR, DIFFERENT}

public class Game {

    private final Score score1;
    private final Score score2;

    public Game(Score score1, Score score2) {
        this.score1 = score1;
        this.score2 = score2;
    }

    public void addPointsToPlayer(String playerName) {
        CheckToAddAvantageTo(playerName);
        CheckToAddMatchPointToPlayerA(playerName);
        CheckToAddMatchPointToPlayerB(playerName);
        if (playerName.equals("playerA")) score1.addPoints();
        else score2.addPoints();
    }



    public String getSetWinner() {
        if (score1.getAdvantage() == 2 || score1.getPoints() == score2.getPoints() + 30) return "playerA";
        if (score2.getAdvantage() == 2 || score2.getPoints() == score1.getPoints() + 30) return "playerB";
        return "playerA";
    }

    public int getScoreFromPlayer(String playerName) {
        return playerName.equals("playerA") ? score1.getPoints() : score2.getPoints();
    }

    public States state() {
        if(score1.getPoints() != score2.getPoints()) return States.DIFFERENT;
        return score1.getPoints() == 40 ? States.DEUCE : States.SIMILAR;
    }

    public int getAdvantageFromPlayer(String player) {
        return 1;
    }
    private void CheckToAddAvantageTo(String playerName) {
        if (state() == States.DEUCE && playerName.equals("playerA")) score1.addAdvantage();
        else score2.addAdvantage();
    }
    private void CheckToAddMatchPointToPlayerA(String playerName) {
        if (score1.getPoints() == 40 && score2.getPoints() < 40 && playerName.equals("playerA")) score1.addMatchPoints();
    }
    private void CheckToAddMatchPointToPlayerB(String playerName) {
        if (score2.getPoints() == 40 && score1.getPoints() < 40 && playerName.equals("playerB")) score2.addMatchPoints();
    }
}
