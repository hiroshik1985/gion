package com.ucacu.gion.recommendation;

import java.util.List;

import org.junit.Test;

import com.ucacu.gion.recommendation.model.Critic;
import com.ucacu.gion.recommendation.model.DefaultItem;
import com.ucacu.gion.recommendation.model.Item;
import com.ucacu.gion.recommendation.test.TestHelper;

public class PearsonBasedRecommenderTest {

    @Test
    public void testGetItems() throws InstantiationException, IllegalAccessException {
        List<Critic> critics = TestHelper.getTestCritics();
        PearsonBasedRecommender<DefaultItem> recommender = new PearsonBasedRecommender<DefaultItem>();

        List<DefaultItem> items = recommender.getSimilarities(critics, critics.get(6), DefaultItem.class);
        recommender.sortByItemValue(items);
        for (Item si : items) {
            System.out.println(si.getKey() + " : " + si.getValue());
        }

    }
}
