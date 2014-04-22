package com.ucacu.gion.recommendation;

import com.ucacu.gion.recommendation.model.Critic;
import com.ucacu.gion.recommendation.model.Score;
import com.ucacu.gion.recommendation.model.SimilarItem;

public class PearsonBasedRecommender<T extends SimilarItem> extends Recommender<T> {
    @Override
    public double getSimilarity(Critic critic1, Critic critic2) {
        int n = 0;
        double sum1 = 0.0d;
        double sum2 = 0.0d;
        double sumSquares1 = 0.0d;
        double sumSquares2 = 0.0d;
        double sumProduct = 0.0d;

        for (Score s1 : critic1.getScores()) {
            for (Score s2 : critic2.getScores()) {
                if (s1.getKey().equals(s2.getKey())) {
                    n++;
                    sum1 += s1.getScore();
                    sum2 += s2.getScore();
                    sumSquares1 += Math.pow(s1.getScore(), 2);
                    sumSquares2 += Math.pow(s2.getScore(), 2);
                    sumProduct += s1.getScore() * s2.getScore();
                }
            }
        }

        if (n == 0)
            return 0.0d;

        double denom = Math.sqrt((sumSquares1 - Math.pow(sum1, 2) / n) * (sumSquares2 - Math.pow(sum2, 2) / n));
        double numer = sumProduct - (sum1 * sum2 / n);

        return denom == 0 ? 0.0d : numer / denom;
    }
}
