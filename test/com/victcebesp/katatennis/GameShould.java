package com.victcebesp.katatennis;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameShould {

    Player playerA = new Player("playerA");
    Player playerB = new Player("playerB");
    private Game game;

    @Before
    public void setUp() {
        game = new Game(playerA, playerB);
    }

    @Test public void
    return_each_player_score() {
        add(2).pointsToAdd(playerA);
        add(1).pointsToAdd(playerB);

        assertThat(game.printGameStatus(), is("Player A score: 30, Player B score: 15"));
    }

    @Test public void
    return_that_both_players_have_the_same_score() {
        add(2).pointsToAdd(playerA);
        add(2).pointsToAdd(playerB);

        assertThat(game.printGameStatus(), is("30 All"));
    }

    @Test public void
    return_deuce_when_both_players_have_as_score_40() {
        add(3).pointsToAdd(playerA);
        add(3).pointsToAdd(playerB);

        assertThat(game.printGameStatus(), is("Deuce"));
    }

    @Test public void
    return_playerA_has_an_advantage_when_deuce_happen_and_playerA_scores() {
        add(4).pointsToAdd(playerA);
        add(3).pointsToAdd(playerB);

        assertThat(game.printGameStatus(), is("playerA has an advantage"));
    }

    @Test public void
    return_playerB_has_an_advantage_when_deuce_happen_and_playerB_scores() {
        add(3).pointsToAdd(playerA);
        add(4).pointsToAdd(playerB);

        assertThat(game.printGameStatus(), is("playerB has an advantage"));
    }

    @Test public void
    add_a_setpoint_when_a_player_has_two_advantages() {
        add(5).pointsToAdd(playerA);
        add(3).pointsToAdd(playerB);

        assertThat(game.printGameStatus(), is("playerA scored a setPoint"));
        assertThat(playerA.getPoints(), is(0));
        assertThat(playerB.getPoints(), is(0));
    }

    @Test public void
    add_a_setpoint_when_a_player_has_40_and_scores_and_the_other_player_has_less_than_40_points(){
        add(1).pointsToAdd(playerB);
        add(4).pointsToAdd(playerB);
        assertThat(game.printGameStatus(), is("playerA scored a setPoint"));

    }

    public ScoreAdder add(int points) {
        return new ScoreAdder(points);
    }

    class ScoreAdder {
        final private int pointsToAdd;

        public ScoreAdder(int points) {
            this.pointsToAdd = points;
        }

        public void pointsToAdd(Player player) {
            for (int i = 0; i < pointsToAdd; i++) {
                player.addPoint();
            }
        }
    }
}

