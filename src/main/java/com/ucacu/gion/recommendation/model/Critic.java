package com.ucacu.gion.recommendation.model;

import java.util.List;

public interface Critic {
    public Object getKey();

    public List<Score> getScores();
}
