package com.victcebesp.katatennis;

enum States{DEUCE, SIMILAR, SetPointWonWithoutAdvantage, DIFFERENT}

public class Game {

    private final Player playerA;
    private final Player playerB;

    public Game(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }

    private States state() {
        if(playerA.getPoints() == playerB.getPoints() && playerA.getPoints() == 40) return States.DEUCE;
        if(playerA.getPoints() == playerB.getPoints()) return States.SIMILAR;
        return States.DIFFERENT;
    }

    public boolean updateGame(Player player) {
        if (player.getAdvantages() == 1) {
            player.addSetPoint();
            restartPointsAndAdvantages();
            return true;
        }
        if (state().equals(States.DEUCE)){
            player.addAdvantage();
            return true;
        }
        return false;
    }

    private void restartPointsAndAdvantages() {
        playerA.restartPoints();
        playerA.restartAdvantages();
        playerB.restartPoints();
        playerB.restartAdvantages();
    }
}
