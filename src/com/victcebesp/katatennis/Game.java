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
        if (state().equals(States.DEUCE)) return "Deuce";
        if (state().equals(States.SIMILAR)) return playerA.getPoints() + " All";
        return "Player A score: " + playerA.getPoints() + ", Player B score: " + playerB.getPoints();
    }

    public void addPointsToPlayer(Player playerName) {
        checkToAddAdvantageTo(playerName.getPlayerName());
        if (playerName.getPlayerName().equals("playerA")) playerA.addPoint();
        else playerB.addPoint();
    }

    private States state() {
        if(playerA.getPoints() == playerB.getPoints() && playerA.getPoints() == 40) return States.DEUCE;
        if(playerA.getPoints() == playerB.getPoints()) return States.SIMILAR;
        return States.DIFFERENT;
    }

    private void checkToAddAdvantageTo(String playerName) {
        if (state() == States.DEUCE) addAdvantageTo(playerName);
    }

    private void addAdvantageTo(String playerName) {
        if (playerName.equalsIgnoreCase("playerA")) playerA.addAdvantage();
        else playerB.addAdvantage();
    }
}
