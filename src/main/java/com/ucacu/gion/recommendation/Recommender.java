package com.ucacu.gion.recommendation;

import java.util.ArrayList;
import java.util.List;

import com.ucacu.gion.recommendation.model.Critic;
import com.ucacu.gion.recommendation.model.SimilarItem;

public abstract class Recommender<T extends SimilarItem> {
    public abstract double getSimilarity(Critic critic1, Critic critic2);

    public List<T> getSimilarItems(List<Critic> critics, Critic target, Class<T> clazz) throws InstantiationException,
            IllegalAccessException {

        List<T> items = new ArrayList<T>();
        for (Critic c : critics) {
            if (!target.getKey().equals(c.getKey())) {
                T item = clazz.newInstance();
                item.setKey(c.getKey());
                item.setSimilarity(this.getSimilarity(c, target));
                items.add(item);
            }
        }

        return items;
    }

    public void sortBySimilarity(List<T> list)
    {
        boolean flag = true;
        T tmp;
        while (flag) {
            flag = false;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).getSimilarity() < list.get(i + 1).getSimilarity()) {
                    tmp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, tmp);
                    flag = true;
                }
            }
        }
    }
}
