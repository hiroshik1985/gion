package com.ucacu.gion.recommendation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.ucacu.gion.recommendation.model.Item;
import com.ucacu.gion.recommendation.model.Items;
import com.ucacu.gion.recommendation.util.ItemUtil;

public abstract class Recommender {
    public abstract double getSimilarity(Items critic1, Items critic2);

    public <T extends Item> List<T> getSimilarities(List<Items> itemsList, Items targetItems, Class<T> clazz) throws InstantiationException,
            IllegalAccessException {

        List<T> items = new ArrayList<T>();
        for (Items itemList : itemsList) {
            if (!targetItems.getKey().equals(itemList.getKey())) {
                T item = clazz.newInstance();
                item.setKey(itemList.getKey());
                item.setValue(this.getSimilarity(itemList, targetItems));
                items.add(item);
            }
        }

        return items;
    }

    public <T extends Item> List<T> getRecommendations(List<Items> itemsList, Items targetItems, Class<T> clazz) throws InstantiationException,
            IllegalAccessException {
        Map<Object, Double> totals = new HashMap<Object, Double>();
        Map<Object, Double> sumSimilarities = new HashMap<Object, Double>();

        for (Items itemList : itemsList) {
            if (!itemList.getKey().equals(targetItems.getKey())) {
                double simirality = getSimilarity(itemList, targetItems);
                if (simirality <= 0.0d)
                    continue;

                for (Item item : itemList.getItems()) {
                    Item node = ItemUtil.getItemByKey(targetItems, item.getKey());
                    if (node == null || node.getValue() == 0.0d) {
                        totals.put(item.getKey(),
                                totals.containsKey(item.getKey()) ? totals.get(item.getKey()) + item.getValue() * simirality : item.getValue()
                                        * simirality);
                        sumSimilarities.put(item.getKey(),
                                sumSimilarities.containsKey(item.getKey()) ? sumSimilarities.get(item.getKey()) + simirality : simirality);
                    }
                }
            }
        }
        List<T> recommendations = new ArrayList<T>();

        for (Iterator<Entry<Object, Double>> it = totals.entrySet().iterator(); it.hasNext();) {
            Map.Entry<Object, Double> entry = (Map.Entry<Object, Double>) it.next();
            T item = clazz.newInstance();
            item.setKey(entry.getKey());
            item.setValue(entry.getValue() / sumSimilarities.get(entry.getKey()));
            recommendations.add(item);
        }

        ItemUtil.sortByItemValue(recommendations);
        return recommendations;
    }

}
