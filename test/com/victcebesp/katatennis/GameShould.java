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
    return_true_when_there_is_a_set_winner() {
        addXPointsTo(PLAYER_A, 3);

        assertThat(game.checkIfThereIsASetWinner(), is(true));
    }

    @Test public void
    return_deuce_when_both_scores_are_forty() {
        addXPointsTo(PLAYER_A, 3);
        addXPointsTo(PLAYER_B, 3);

        assertThat(game.getScoreFromPlayer(PLAYER_A), is(40));
        assertThat(game.getScoreFromPlayer(PLAYER_B), is(40));
        assertThat(game.state(), is(States.DEUCE));
    }

    @Test public void
    return_player_two_as_the_winner_when_it_has_two_advantages_more_than_playerA() {
        addXPointsTo(PLAYER_A, 3);
        addXPointsTo(PLAYER_B, 5);

        assertThat(game.decideWichPlayerWinTheSet(), is("playerB"));
    }

    private void addXPointsTo(String player, int times) {
        for (int i = 0; i < times; i++) {
            game.addPointsToPlayer(player);
        }
    }

}
