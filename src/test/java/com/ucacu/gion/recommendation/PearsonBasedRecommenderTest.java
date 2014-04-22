package com.ucacu.gion.recommendation;

import java.util.List;

import org.junit.Test;

import com.ucacu.gion.recommendation.model.Critic;
import com.ucacu.gion.recommendation.model.DefaultSimilarItem;
import com.ucacu.gion.recommendation.model.SimilarItem;
import com.ucacu.gion.recommendation.test.TestHelper;

public class PearsonBasedRecommenderTest {

    @Test
    public void testGetSimilarItems() throws InstantiationException, IllegalAccessException {
        List<Critic> critics = TestHelper.getTestCritics();
        PearsonBasedRecommender<DefaultSimilarItem> recommender = new PearsonBasedRecommender<DefaultSimilarItem>();

        List<DefaultSimilarItem> items = recommender.getSimilarItems(critics, critics.get(6), DefaultSimilarItem.class);
        recommender.sortBySimilarity(items);
        for (SimilarItem si : items) {
            System.out.println(si.getKey() + " : " + si.getSimilarity());
        }

    }
}
