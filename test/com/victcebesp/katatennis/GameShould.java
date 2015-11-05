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
        addXPointsTo(PLAYER_A, 4);

        assertThat(game.getScoreFromPlayer(PLAYER_A), is(55));
        assertThat(game.getScoreFromPlayer(PLAYER_B), is(0));
        assertThat(game.getSetWinner(), is(PLAYER_A));
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
    return_1_advantage_when_deuce_happend_and_a_player_scores() {
        addXPointsTo(PLAYER_A, 3);
        addXPointsTo(PLAYER_B, 4);

        assertThat(game.getAdvantageFromPlayer(PLAYER_B), is(1));
    }

    @Test public void
    return_player_two_as_the_winner_when_it_has_two_advantages() {
        assertThat(game.getSetWinner(), is(PLAYER_B));
    }

    private void addXPointsTo(String player, int times) {
        for (int i = 0; i < times; i++) {
            game.addPointsToPlayer(player);
        }
    }

}
