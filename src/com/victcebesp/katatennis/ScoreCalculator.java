package com.victcebesp.katatennis;

public class ScoreCalculator {

    public int matchPointCalculator(Score score1, Score score2) {
        if (compareScores(score1, score2)) return score1.getMatchPoints();
        if (compareScores(score2, score1)) return score2.getMatchPoints();
        return 0;
    }

    private boolean checkIfHaveTheSamePointsAndItIs40(Score score1, Score score2) {
        if (score1.getPoints() == score2.getPoints() && score1.getPoints() == 40) {
            return true;
        }
        return false;
    }

    private boolean compareScores(Score score1, Score score2) {
        if (score1.getPoints() > score2.getPoints() && score1.getPoints() > 40 && score2.getPoints() < 40) {
            score1.addMatchPoint();
            return true;
        }
        return false;
    }
}
