package com.ucacu.gion.recommendation.model;

public class DefaultScore extends ScoreTemplate implements Score {
    public DefaultScore(Object key, Double score) {
        this.key = key;
        this.score = score;
    }
}
