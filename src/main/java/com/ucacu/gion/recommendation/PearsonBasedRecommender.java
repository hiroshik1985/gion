package com.ucacu.gion.recommendation;

import com.ucacu.gion.recommendation.model.Item;
import com.ucacu.gion.recommendation.model.ItemList;

public class PearsonBasedRecommender extends Recommender {
    @Override
    public double getSimilarity(ItemList critic1, ItemList critic2) {
        int n = 0;
        double sum1 = 0.0d;
        double sum2 = 0.0d;
        double sumSquares1 = 0.0d;
        double sumSquares2 = 0.0d;
        double sumProduct = 0.0d;

        for (Item item1 : critic1.getItems()) {
            for (Item item2 : critic2.getItems()) {
                if (item1.getKey().equals(item2.getKey())) {
                    n++;
                    sum1 += item1.getValue();
                    sum2 += item2.getValue();
                    sumSquares1 += Math.pow(item1.getValue(), 2);
                    sumSquares2 += Math.pow(item2.getValue(), 2);
                    sumProduct += item1.getValue() * item2.getValue();
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
