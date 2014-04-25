package com.ucacu.gion.recommendation;

import com.ucacu.gion.recommendation.model.Item;
import com.ucacu.gion.recommendation.model.Items;

public class DistanceBasedRecommender extends Recommender {
    @Override
    public double getSimilarity(Items critic1, Items critic2) {
        double sumSquares = 0.0d;
        for (Item item1 : critic1.getItems()) {
            for (Item item2 : critic2.getItems()) {
                if (item1.getKey().equals(item2.getKey())) {
                    sumSquares += Math.pow(item1.getValue() - item2.getValue(), 2);
                    break;
                }
            }
        }
        return 1.0d / (1.0d + Math.sqrt(sumSquares));
    }
}
