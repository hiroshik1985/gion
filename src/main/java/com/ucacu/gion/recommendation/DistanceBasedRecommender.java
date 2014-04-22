package com.ucacu.gion.recommendation;

import com.ucacu.gion.recommendation.model.Critic;
import com.ucacu.gion.recommendation.model.Score;
import com.ucacu.gion.recommendation.model.SimilarItem;

public class DistanceBasedRecommender<T extends SimilarItem> extends Recommender<T> {
    @Override
    public double getSimilarity(Critic critic1, Critic critic2) {
        double sumSquares = 0.0d;
        for (Score s1 : critic1.getScores()) {
            for (Score s2 : critic2.getScores()) {
                if (s1.getKey().equals(s2.getKey())) {
                    sumSquares += Math.pow(s1.getScore() - s2.getScore(), 2);
                }
            }
        }
        return 1.0d / (1.0d + Math.sqrt(sumSquares));
    }
}
