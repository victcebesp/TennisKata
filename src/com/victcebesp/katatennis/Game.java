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
        if(bothPlayersHasFortyAsScore()) return States.DEUCE;
        if(bothPlayersHasTheSameScore()) return States.SIMILAR;
        return States.DIFFERENT;
    }

    private boolean bothPlayersHasTheSameScore() {
        return playerA.getPoints() == playerB.getPoints();
    }

    private boolean bothPlayersHasFortyAsScore() {
        return bothPlayersHasTheSameScore() && playerA.getPoints() == 40;
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
