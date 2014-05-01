package com.ucacu.gion.recommendation;

import com.ucacu.gion.recommendation.model.Item;
import com.ucacu.gion.recommendation.model.Items;

public class DistanceBasedRecommender extends Recommender {
    @Override
    public <T extends Items<U>, U extends Item> double getSimilarity(T items1, T items2) {
        double sumSquares = 0.0d;
        for (Item item1 : items1.getItems()) {
            for (Item item2 : items2.getItems()) {
                if (item1.getKey().equals(item2.getKey())) {
                    sumSquares += Math.pow(item1.getValue() - item2.getValue(), 2);
                    break;
                }
            }
        }
        return 1.0d / (1.0d + Math.sqrt(sumSquares));
    }
}
