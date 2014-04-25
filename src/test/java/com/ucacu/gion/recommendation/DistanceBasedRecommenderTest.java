package com.ucacu.gion.recommendation;

import java.util.List;

import org.junit.Test;

import com.ucacu.gion.recommendation.model.DefaultItem;
import com.ucacu.gion.recommendation.model.Item;
import com.ucacu.gion.recommendation.model.Items;
import com.ucacu.gion.recommendation.test.TestHelper;
import com.ucacu.gion.recommendation.util.ItemUtil;

public class DistanceBasedRecommenderTest {
    @Test
    public void testGetSimilarities() throws InstantiationException, IllegalAccessException {
        List<Items> critics = TestHelper.getTestCritics();
        DistanceBasedRecommender recommender = new DistanceBasedRecommender();

        List<DefaultItem> items = recommender.getSimilarities(critics, critics.get(6), DefaultItem.class);
        ItemUtil.sortByItemValue(items);
        for (Item si : items) {
            System.out.println(si.getKey() + " : " + si.getValue());
        }

    }

    @Test
    public void testGetRecommendtionss() throws InstantiationException, IllegalAccessException {
        List<Items> critics = TestHelper.getTestCritics();
        DistanceBasedRecommender recommender = new DistanceBasedRecommender();

        List<DefaultItem> items = recommender.getRecommendations(critics, critics.get(6), DefaultItem.class);
        ItemUtil.sortByItemValue(items);
        for (Item si : items) {
            System.out.println(si.getKey() + " : " + si.getValue());
        }

    }
}
