package com.ucacu.gion.recommendation.data;

import java.util.List;

public class DefaultCritic extends CriticTemplate implements Critic {
    DefaultCritic(Object key, List<Score> scores) {
        this.key = key;
        this.scores = scores;
    }
}
