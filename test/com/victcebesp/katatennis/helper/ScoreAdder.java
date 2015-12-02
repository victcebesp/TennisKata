package com.victcebesp.katatennis.helper;

import com.victcebesp.katatennis.Player;

public class ScoreAdder {
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
