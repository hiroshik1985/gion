package com.ucacu.gion.recommendation;

import java.util.List;

import org.junit.Test;

import com.ucacu.gion.recommendation.model.DefaultItem;
import com.ucacu.gion.recommendation.model.DefaultItems;
import com.ucacu.gion.recommendation.model.Item;
import com.ucacu.gion.recommendation.test.TestHelper;
import com.ucacu.gion.recommendation.util.ItemUtil;

public class PearsonBasedRecommenderTest {

    @Test
    public void testGetItems() throws InstantiationException, IllegalAccessException {
        List<DefaultItems> critics = TestHelper.getTestCritics();
        PearsonBasedRecommender recommender = new PearsonBasedRecommender();

        List<DefaultItem> items = recommender.getSimilarities(critics, critics.get(6), DefaultItem.class);
        ItemUtil.sortByItemValue(items);
        for (Item si : items) {
            System.out.println(si.getKey() + " : " + si.getValue());
        }

    }

    @Test
    public void testGetRecommendtions() throws InstantiationException, IllegalAccessException {
        List<DefaultItems> critics = TestHelper.getTestCritics();
        PearsonBasedRecommender recommender = new PearsonBasedRecommender();

        List<DefaultItem> items = recommender.getRecommendations(critics, critics.get(6), DefaultItem.class);
        ItemUtil.sortByItemValue(items);
        for (Item si : items) {
            System.out.println(si.getKey() + " : " + si.getValue());
        }
    }

    @Test
    public void testGetSimilaritesList() throws InstantiationException, IllegalAccessException {
        List<DefaultItems> critics = TestHelper.getTestCritics();
        PearsonBasedRecommender recommender = new PearsonBasedRecommender();

        critics = ItemUtil.transfrom(critics, DefaultItems.class, DefaultItem.class);
        critics = recommender.getRecommendations(critics, critics.get(6), DefaultItem.class);
        TestHelper.printTestData(critics);
    }
}
