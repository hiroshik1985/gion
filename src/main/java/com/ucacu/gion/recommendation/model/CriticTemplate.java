package com.ucacu.gion.recommendation.model;

import java.util.List;

public abstract class CriticTemplate {
    protected Object key;
    protected List<Score> scores;

    public Object getKey() {
        return this.key;
    }

    public List<Score> getScores() {
        return this.scores;
    }
}
