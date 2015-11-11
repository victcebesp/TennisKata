package com.victcebesp.katatennis;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameShould {

    PlayerSpy playerA = new PlayerSpy("playerA");
    PlayerSpy playerB = new PlayerSpy("playerB");
    private Game game;

    @Before
    public void setUp() {
        game = new Game(playerA, playerB);
    }

    @Test public void
    return_each_player_score() {
        add(2).pointsToAdd(playerA.getScore());
        add(1).pointsToAdd(playerB.getScore());

        assertThat(game.printGameStatus(), is("Player A score: 30, Player B score: 15"));
    }

    @Test public void
    return_that_both_players_have_the_same_score() {
        add(2).pointsToAdd(playerA.getScore());
        add(2).pointsToAdd(playerB.getScore());

        assertThat(game.printGameStatus(), is("30 All"));
    }

    @Test public void
    return_deuce_when_both_players_have_as_score_40() {
        add(3).pointsToAdd(playerA.getScore());
        add(3).pointsToAdd(playerB.getScore());

        assertThat(game.printGameStatus(), is("Deuce"));
    }

    @Test public void
    return_playerA_has_an_advantage_when_deuce_happen_and_playerA_scores() {
        add(4).pointsToAdd(playerA.getScore());
        add(3).pointsToAdd(playerB.getScore());

        assertThat(game.printGameStatus(), is("playerA has an advantage"));
    }

    @Test public void
    return_playerB_has_an_advantage_when_deuce_happen_and_playerB_scores() {
        add(3).pointsToAdd(playerA.getScore());
        add(4).pointsToAdd(playerB.getScore());

        assertThat(game.printGameStatus(), is("playerB has an advantage"));
    }

    public ScoreAdder add(int points) {
        return new ScoreAdder(points);
    }

    public class PlayerSpy extends Player {

        public PlayerSpy(String playerName) {
            super(playerName);
        }

        public Score getScore() {
            return score;
        }
    }

}

