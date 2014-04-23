package com.ucacu.gion.recommendation;

import java.util.ArrayList;
import java.util.List;

import com.ucacu.gion.recommendation.model.ItemList;
import com.ucacu.gion.recommendation.model.Item;

public abstract class Recommender<T extends Item> {
    public abstract double getSimilarity(ItemList critic1, ItemList critic2);

    public List<T> getSimilarities(List<ItemList> critics, ItemList target, Class<T> clazz) throws InstantiationException,
            IllegalAccessException {

        List<T> items = new ArrayList<T>();
        for (ItemList c : critics) {
            if (!target.getKey().equals(c.getKey())) {
                T item = clazz.newInstance();
                item.setKey(c.getKey());
                item.setValue(this.getSimilarity(c, target));
                items.add(item);
            }
        }

        return items;
    }

    /*
    public List<T> getRecommendations(List<Critic> critics, Critic target, Class<T> clazz) throws InstantiationException,
            IllegalAccessException {
        List<Double> totals = new ArrayList<Double>();
        List<Double> sumSimilarities = new ArrayList<Double>();

        for (Critic c : critics) {
            if (!c.getKey().equals(target.getKey())) {
                double simirality = getSimilarity(c, target);
                if (simirality != 0)
                    continue;

                for (Item score : c.getItems()) {
                    for (Item scoreTarget : target.getItems()) {}
                }
            }
        }

    }
    */

    public void sortByItemValue(List<T> items)
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
