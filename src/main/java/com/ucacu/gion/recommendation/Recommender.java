package com.ucacu.gion.recommendation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.ucacu.gion.recommendation.model.Item;
import com.ucacu.gion.recommendation.model.ItemList;
import com.ucacu.gion.recommendation.util.ItemListUtil;

public abstract class Recommender {
    public abstract double getSimilarity(ItemList critic1, ItemList critic2);

    public <T extends Item> List<T> getSimilarities(List<ItemList> itemLists, ItemList targetList, Class<T> clazz) throws InstantiationException,
            IllegalAccessException {

        List<T> items = new ArrayList<T>();
        for (ItemList itemList : itemLists) {
            if (!targetList.getKey().equals(itemList.getKey())) {
                T item = clazz.newInstance();
                item.setKey(itemList.getKey());
                item.setValue(this.getSimilarity(itemList, targetList));
                items.add(item);
            }
        }

        return items;
    }

    public <T extends Item> List<T> getRecommendations(List<ItemList> itemLists, ItemList targetList, Class<T> clazz) throws InstantiationException,
            IllegalAccessException {
        Map<Object, Double> totals = new HashMap<Object, Double>();
        Map<Object, Double> sumSimilarities = new HashMap<Object, Double>();

        for (ItemList itemList : itemLists) {
            if (!itemList.getKey().equals(targetList.getKey())) {
                double simirality = getSimilarity(itemList, targetList);
                if (simirality <= 0.0d)
                    continue;

                for (Item item : itemList.getItems()) {
                    Item node = ItemListUtil.getNodeByKey(targetList, item.getKey());
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

        sortByItemValue(recommendations);
        return recommendations;
    }

    public <T extends Item> void sortByItemValue(List<T> items)
    {
        boolean flag = true;
        T tmp;
        while (flag) {
            flag = false;
            for (int i = 0; i < items.size() - 1; i++) {
                if (items.get(i).getValue() < items.get(i + 1).getValue()) {
                    tmp = items.get(i);
                    items.set(i, items.get(i + 1));
                    items.set(i + 1, tmp);
                    flag = true;
                }
            }
        }
    }
}
