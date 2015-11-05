package com.victcebesp.katatennis;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameShould {

    public final String PLAYER_A = "playerA";
    public final String PLAYER_B = "playerB";
    private Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game(new Score(), new Score());
    }

    @Test public void
    return_player_one_as_the_winner_when_its_score_is_greater_than_forty_and_score_of_player_two_is_zero() {
        addPointsTo(PLAYER_A);

        assertThat(game.getScoreForPlayer(PLAYER_A), is(55));
        assertThat(game.getScoreForPlayer(PLAYER_B), is(0));
        assertThat(game.getSetWinner(), is(PLAYER_A));
    }

    private void addPointsTo(String player) {
        for (int i = 0; i < 4; i++) {
            game.addPointsToPlayer(player);
        }
    }

}
