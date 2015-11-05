package com.victcebesp.katatennis;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScoreCalculatorShould {

    @Test
    public void add_1_matchPoint_after_adding_a_point_to_40_and_the_other_player_has_less_than_40_points() {
        Score score1 = new Score();
        Score score2 = new Score();

        pointAdder(score1, 4);
        pointAdder(score2, 2);

        assertEquals(1, new ScoreCalculator().matchPointCalculator(score1, score2));
    }

    @Test
    public void return_true_if_both_scores_are_40() {
        Score score1 = new Score();
        Score score2 = new Score();

        pointAdder(score1, 3);
        pointAdder(score2, 3);

        assertEquals(true, new ScoreCalculator().checkIfHaveTheSamePointsAndItIs40(score1, score2));
    }

    private int pointAdder(Score score, int numberOfTimes){
        for (int i = 0; i < numberOfTimes; i++) {
            score.addPoint();
        }
        return score.getPoints();
    }
}
