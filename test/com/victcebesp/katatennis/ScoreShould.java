package com.victcebesp.katatennis;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScoreShould {

    /**
     * TODO: Rules
     * Points => 0, 15, 30, 40  ==  "love", "fifteen", "thirty", "forty"
     * if he scores a point and the other player has less than 40 on the score, he wins the point
     * If 40 && 40 => "deuce"
     * When a deuce happens, a player who scores a point has the "advantage"
     * If he scores two times at a row, he wins the point
     * else if he loses the second ball he loses his advantage and it's back to deuce
     */

    /**
     * TODO: Possible tests
     * 40 scores point & the other has less than 40 => wins point
     * 40 & 40 => deuce
     * deuce & scores point => advantage
     * advantage & scores point => wins point
     * advantage & loses point => back to deuce
     */

    @Test
    public void return_0_when_its_started() {
        assertEquals(0, new Score().getPoints());
    }

    @Test
    public void return_15_after_adding_a_point() {
        Score score = new Score();

        score.addPoints();

        assertEquals(15, score.getPoints());
    }

    @Test
    public void return_30_after_adding_a_point_to_a_15_score() {
        Score score = new Score();

        score.addPoints();
        score.addPoints();

        assertEquals(30, score.getPoints());
    }

    @Test
    public void return_40_after_adding_a_point_to_a_30_score() {
        Score score = new Score();

        score.addPoints();
        score.addPoints();
        score.addPoints();

        assertEquals(40, score.getPoints());
    }

}
