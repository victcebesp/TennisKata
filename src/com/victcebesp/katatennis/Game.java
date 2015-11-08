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
        checkToAddAvantageTo(playerName);
        checkToAddMatchPointToPlayer(playerName);
        if (playerName.equals("playerA")) score1.addPoints();
        else score2.addPoints();
    }



    public String getSetWinner() {
        if (score1.getAdvantage() - 2 == score2.getAdvantage() || score1.getPoints() == score2.getPoints() + 30) return "playerA";
        if (score2.getAdvantage() - 2 == score1.getAdvantage() || score2.getPoints() == score1.getPoints() + 30) return "playerB";
        return null;
    }

    public int getScoreFromPlayer(String playerName) {
        return playerName.equals("playerA") ? score1.getPoints() : score2.getPoints();
    }

    public States state() {
        if(score1.getPoints() != score2.getPoints()) return States.DIFFERENT;
        return score1.getPoints() == 40 ? States.DEUCE : States.SIMILAR;
    }

    private void checkToAddAvantageTo(String playerName) {
        if (state() == States.DEUCE && playerName.equals("playerA")) score1.addAdvantage();
        if (state() == States.DEUCE && playerName.equals("playerB")) score2.addAdvantage();
    }
    private void checkToAddMatchPointToPlayer(String playerName) {
        if (playerName.equals("playerA") && score1.getPoints() == 40 && score2.getPoints() < 40)
            score1.addMatchPoints();
            score1.setPoints(0);
            score2.setPoints(0);
        if (playerName.equals("playerB") && score2.getPoints() == 40 && score1.getPoints() < 40)
            score2.addMatchPoints();
            score1.setPoints(0);
            score2.setPoints(0);
    }
}
