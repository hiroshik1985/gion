package com.ucacu.gion.recommendation.data;

import java.util.List;

public interface Critic {
    public Object getKey();

    public List<Score> getScores();
}
