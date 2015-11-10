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
    public void setUp() throws Exception {
        game = new Game(playerA, playerB);
    }

    @Test public void
    return_each_player_score() {
        addXPointsTo(playerA, 2);
        addXPointsTo(playerB, 1);

        assertThat(game.printGameStatus(), is("Player A score: 30, Player B score: 15"));
    }

    @Test public void
    return_that_both_players_have_the_same_score() {
        addXPointsTo(playerA, 2);
        addXPointsTo(playerB, 2);

        assertThat(game.printGameStatus(), is("30 All"));
    }

    @Test public void
    return_deuce_when_both_players_have_as_score_40() {
        addXPointsTo(playerA, 3);
        addXPointsTo(playerB, 3);

        assertThat(game.printGameStatus(), is("Deuce"));
    }

    @Test public void
    return_playerA_has_an_advantage_when_deuce_happen_and_playerA_scores() {
        addXPointsTo(playerA, 4);
        addXPointsTo(playerB, 3);

        assertThat(game.printGameStatus(), is("playerA has an advantage"));
    }

    private void addXPointsTo(Player player, int times) {
        for (int i = 0; i < times; i++) {
            game.addPointsToPlayer(player);
        }
    }

}

