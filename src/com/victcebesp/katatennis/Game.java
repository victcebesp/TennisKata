package com.victcebesp.katatennis;

enum States{DEUCE, SIMILAR, DIFFERENT}

public class Game {

    private final Player playerA;
    private final Player playerB;

    public Game(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }

    public String printGameStatus(){
        if (playerAHasASetPoint()) return playerA.getPlayerName() + " has a setPoint";
        if (playerBHasAnAdvantage()) return playerB.getPlayerName() + " has an advantage";
        if (playerAHasAnAdvantage()) return playerA.getPlayerName() + " has an advantage";
        if (state().equals(States.DEUCE)) return "Deuce";
        if (state().equals(States.SIMILAR)) return playerA.getPoints() + " All";
        return "Player A score: " + playerA.getPoints() + ", Player B score: " + playerB.getPoints();
    }

    private boolean playerAHasASetPoint() {
        return playerA.getSetPoints() == 1;
    }

    private boolean playerBHasAnAdvantage() {
        return playerB.getAdvantage() == 1;
    }

    private boolean playerAHasAnAdvantage() {
        return playerA.getAdvantage() == 1;
    }

    private States state() {
        if(playerA.getPoints() == playerB.getPoints() && playerA.getPoints() == 40) return States.DEUCE;
        if(playerA.getPoints() == playerB.getPoints()) return States.SIMILAR;
        return States.DIFFERENT;
    }

}
