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
    public abstract <T extends Items<U>, U extends Item> double getSimilarity(T imtes1, T imtes2);

    public <T extends Items<U>, U extends Item> List<U> getSimilarities(final List<T> itemsList, final T targetItems, final Class<U> clazz)
            throws InstantiationException,
            IllegalAccessException {

        List<U> items = new ArrayList<U>();
        for (T itemList : itemsList) {
            if (!targetItems.getKey().equals(itemList.getKey())) {

                U item = ItemUtil.createItemInstance(clazz, itemList.getKey(), this.getSimilarity(itemList, targetItems));
                items.add(item);
            }
        }
        return items;
    }

    public <T extends Items<U>, U extends Item> List<T> getSimilaritesList(final List<T> itemsList, Class<T> clazzItmes, Class<U> clazzItem)
            throws InstantiationException, IllegalAccessException {
        List<T> similaritesList = new ArrayList<T>();
        for (T items : itemsList) {
            T similarities = ItemUtil.createItemsInstance(clazzItmes, items.getKey(), this.getSimilarities(itemsList, items, clazzItem));
            similaritesList.add(similarities);
        }

        return similaritesList;
    }

    public <T extends Item, U extends Items<T>> List<T> getRecommendations(final List<U> itemsList, final U targetItems, final Class<T> clazz)
            throws InstantiationException,
            IllegalAccessException {
        Map<Object, Double> scores = new HashMap<Object, Double>();
        Map<Object, Double> sumSimilarities = new HashMap<Object, Double>();

        for (U itemList : itemsList) {
            if (!itemList.getKey().equals(targetItems.getKey())) {
                double similarity = getSimilarity(itemList, targetItems);
                if (similarity <= 0.0d)
                    continue;

                for (Item item : itemList.getItems()) {
                    Item itemTarget = ItemUtil.getItemByKey(targetItems, item.getKey());
                    if (itemTarget == null || itemTarget.getValue() == 0.0d) {
                        scores.put(item.getKey(),
                                scores.containsKey(item.getKey()) ? scores.get(item.getKey()) + item.getValue() * similarity : item.getValue()
                                        * similarity);
                        sumSimilarities.put(item.getKey(),
                                sumSimilarities.containsKey(item.getKey()) ? sumSimilarities.get(item.getKey()) + similarity : similarity);
                    }
                }
            }
        }
        List<T> recommendations = new ArrayList<T>();

        for (Iterator<Entry<Object, Double>> it = scores.entrySet().iterator(); it.hasNext();) {
            Map.Entry<Object, Double> entry = (Map.Entry<Object, Double>) it.next();
            T item = ItemUtil.createItemInstance(clazz, entry.getKey(), entry.getValue() / sumSimilarities.get(entry.getKey()));
            recommendations.add(item);
        }

        ItemUtil.sortByItemValue(recommendations);
        return recommendations;
    }

    public <T extends Item, U extends Items<T>> List<T> getRecomendedItems(final List<U> similaryItemsList, final U target, final Class<T> clazz)
            throws InstantiationException,
            IllegalAccessException {
        Map<Object, Double> scores = new HashMap<Object, Double>();
        Map<Object, Double> sumSimilarities = new HashMap<Object, Double>();

        for (Item item : target.getItems()) {
            U similarItems = ItemUtil.getItemsByKey(similaryItemsList, target.getKey());
            for (Item similarItem : similarItems.getItems()) {
                if (similarItem.getKey().equals(item.getKey()))
                    continue;

                scores.put(item.getKey(),
                        scores.containsKey(item.getKey()) ? scores.get(item.getKey()) + item.getValue() * similarItem.getValue() : item.getValue()
                                * similarItem.getValue());
                sumSimilarities.put(item.getKey(),
                        sumSimilarities.containsKey(item.getKey()) ? sumSimilarities.get(item.getKey()) + similarItem.getValue() : similarItem.getValue());

            }
        }

        List<T> recommendations = new ArrayList<T>();

        for (Iterator<Entry<Object, Double>> it = scores.entrySet().iterator(); it.hasNext();) {
            Map.Entry<Object, Double> entry = (Map.Entry<Object, Double>) it.next();
            T item = ItemUtil.createItemInstance(clazz, entry.getKey(), entry.getValue() / sumSimilarities.get(entry.getKey()));
            recommendations.add(item);
        }

        ItemUtil.sortByItemValue(recommendations);
        return recommendations;
    }

}
