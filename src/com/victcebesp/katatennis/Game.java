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
        if (stateIsSetPointWonWithoutAdvantage()) return States.SetPointWonWithoutAdvantage;
        if(playerA.getPoints() == playerB.getPoints() && playerA.getPoints() == 40) return States.DEUCE;
        if(playerA.getPoints() == playerB.getPoints()) return States.SIMILAR;
        return States.DIFFERENT;
    }

    private boolean stateIsSetPointWonWithoutAdvantage() {
        if (playerB.getPoints() == 40 && playerA.getPoints() < 40) return true;
        if (playerA.getPoints() == 40 && playerB.getPoints() < 40) return true;
        return false;
    }

    public boolean updateGame(Player player) {
        if(state().equals(States.SetPointWonWithoutAdvantage)) {
            player.addSetPoint();
            restartPointsAndAdvantages();
            return true;
        }
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
