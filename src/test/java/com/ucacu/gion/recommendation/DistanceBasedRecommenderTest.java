package com.ucacu.gion.recommendation;

import java.util.List;

import org.junit.Test;

import com.ucacu.gion.recommendation.model.DefaultItem;
import com.ucacu.gion.recommendation.model.DefaultItems;
import com.ucacu.gion.recommendation.test.TestHelper;
import com.ucacu.gion.recommendation.util.ItemUtil;

public class DistanceBasedRecommenderTest {
    @Test
    public void testGetSimilarities() throws InstantiationException, IllegalAccessException {
        List<DefaultItems> critics = TestHelper.getTestCritics();
        DistanceBasedRecommender recommender = new DistanceBasedRecommender();

        List<DefaultItem> items = recommender.getSimilarities(critics, critics.get(6), DefaultItem.class);
        ItemUtil.sortByItemValue(items);
    }

    @Test
    public void testGetRecommendtionss() throws InstantiationException, IllegalAccessException {
        List<DefaultItems> critics = TestHelper.getTestCritics();
        DistanceBasedRecommender recommender = new DistanceBasedRecommender();

        List<DefaultItem> items = recommender.getRecommendations(critics, critics.get(6), DefaultItem.class);
        ItemUtil.sortByItemValue(items);
    }

    @Test
    public void testGetSimilarItems() throws InstantiationException, IllegalAccessException {
        List<DefaultItems> critics = TestHelper.getTestCritics();
        DistanceBasedRecommender recommender = new DistanceBasedRecommender();

        List<DefaultItem> items = recommender.getRecommendations(critics, critics.get(6), DefaultItem.class);
        ItemUtil.sortByItemValue(items);
    }

    @Test
    public void testGetSimilaritesList() throws InstantiationException, IllegalAccessException {
        List<DefaultItems> critics = TestHelper.getTestCritics();
        DistanceBasedRecommender recommender = new DistanceBasedRecommender();
        List<DefaultItems> items = ItemUtil.transfrom(critics, DefaultItems.class, DefaultItem.class);
        items = recommender.getSimilaritesList(items, DefaultItems.class, DefaultItem.class);
    }

    @Test
    public void testGetRecomendedItems() throws InstantiationException, IllegalAccessException {
        List<DefaultItems> critics = TestHelper.getTestCritics();
        DistanceBasedRecommender recommender = new DistanceBasedRecommender();
        List<DefaultItems> items = ItemUtil.transfrom(critics, DefaultItems.class, DefaultItem.class);
        items = recommender.getSimilaritesList(items, DefaultItems.class, DefaultItem.class);
        List<DefaultItem> recommendedItems = recommender.getRecomendedItems(items, critics.get(6), DefaultItem.class);
        ItemUtil.sortByItemValue(recommendedItems);
    }

}
