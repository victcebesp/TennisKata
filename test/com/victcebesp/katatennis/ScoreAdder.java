package com.victcebesp.katatennis;

class ScoreAdder {

    private final int pointsToAdd;

    ScoreAdder(int pointsToAdd) {
        this.pointsToAdd = pointsToAdd;
    }

    public void pointsToAdd(Score score) {
        for (int i = 0; i < pointsToAdd; i++) {
            score.addPoint();
        }
    }

}
