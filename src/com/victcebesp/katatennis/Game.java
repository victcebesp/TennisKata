package com.victcebesp.katatennis;

enum States{DEUCE, SIMILAR, SetPointWonWithoutAdvantage, DIFFERENT}

public class Game {

    private final Player playerA;
    private final Player playerB;

    public Game(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }

    public String returnStatus(){

        if (aPlayerWonASetPointWithoutAdvantages()) return playerWithHigherScore().getPlayerName() + " scored a setPoint";
        if (playerAHasASetPoint()) {
            return playerA.getPlayerName() + " scored a setPoint";
        }
        if (aPlayerHasAnAdvantage()) return playerWithHigherScore().getPlayerName() + " has an advantage";
        if (state().equals(States.DEUCE)) return "Deuce";
        if (state().equals(States.SIMILAR)) return playerA.getPoints() + " All";
        return "Player A score: " + playerA.getPoints() + ", Player B score: " + playerB.getPoints();
    }

    private boolean aPlayerHasAnAdvantage() {
        if (playerA.getPoints() > 40 && playerB.getPoints() == 40 ){
            playerWithHigherScore().addAdvantage();
            return true;
        }
        if (playerB.getPoints() > 40 && playerA.getPoints() == 40 ){
            playerWithHigherScore().addAdvantage();
            return true;
        }
        else return false;
    }

    private Player playerWithHigherScore() {
        return playerA.getPoints() > playerB.getPoints() ? playerA : playerB;
    }

    private boolean playerAHasASetPoint() {
        return playerA.getSetPoints() == 1;
    }

    private boolean aPlayerWonASetPointWithoutAdvantages(){
        if(state() == States.SetPointWonWithoutAdvantage){
            playerWithHigherScore().addSetPoint();
            return true;
        }
        return false;
    }

    private States state() {
        if(playerA.getPoints() == playerB.getPoints() && playerA.getPoints() == 40) return States.DEUCE;
        if(playerA.getPoints() == playerB.getPoints()) return States.SIMILAR;
        if (playerA.getPoints() > 40 && playerB.getPoints() < 40) return States.SetPointWonWithoutAdvantage;
        if (playerB.getPoints() > 40 && playerA.getPoints() < 40) return States.SetPointWonWithoutAdvantage;
        return States.DIFFERENT;
    }

    public boolean updateGame(Player player) {
        if (player.getAdvantages() == 1) player.addSetPoint();
        else if (state().equals(States.DEUCE)){
            player.addAdvantage();
            return true;
        }
        return false;
    }
}
