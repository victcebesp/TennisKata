package com.victcebesp.katatennis;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameShould {

    Player playerA;
    Player playerB;
    private Game game;

    @Before
    public void setUp() {
        playerA = new Player("playerA");
        playerB = new Player("playerB");
        game = new Game(playerA, playerB);
    }

    @Test public void
    add_an_advantage_when_both_players_have_40_as_score_and_one_scores() {
        add(3).pointsTo(playerA);
        add(3).pointsTo(playerB);
        add(1).pointsTo(playerA);

        assertThat(playerA.getAdvantages(), is(1));
    }

    @Test public void
    add_a_setpoint_when_a_player_has_an_advantage_and_scores() {
        add(3).pointsTo(playerA);
        add(3).pointsTo(playerB);
        add(2).pointsTo(playerA);

        assertThat(playerA.getSetPoints(), is(1));
    }

    @Test public void
    restart_both_scores_and_advantages_when_a_setpoint_is_scored() {
        add(3).pointsTo(playerA);
        add(3).pointsTo(playerB);
        add(2).pointsTo(playerA);

        assertThat(playerA.getPoints(), is(0));
        assertThat(playerA.getAdvantages(), is(0));
        assertThat(playerB.getPoints(), is(0));
        assertThat(playerB.getAdvantages(), is(0));
    }

    private ScoreAdder add(int points) {
        return new ScoreAdder(points);
    }

    class ScoreAdder {

        private final int pointsToAdd;

        ScoreAdder(int pointsToAdd) {
            this.pointsToAdd = pointsToAdd;
        }

        public void pointsTo(Player player) {
            for (int i = 0; i < pointsToAdd; i++) {
                if(!game.updateGame(player)) player.addPoint();
            }
        }

    }


}

