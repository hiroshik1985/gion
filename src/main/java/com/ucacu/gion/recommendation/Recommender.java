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
    public abstract <ITEMS extends Items<ITEM>, ITEM extends Item> double getSimilarity(ITEMS imtes1, ITEMS imtes2);

    public <ITEMS extends Items<ITEM>, ITEM extends Item> List<ITEM> getSimilarities(final List<ITEMS> itemsList, final ITEMS targetItems,
            final Class<ITEM> clazz)
            throws InstantiationException,
            IllegalAccessException {

        List<ITEM> items = new ArrayList<ITEM>();
        for (ITEMS itemList : itemsList) {
            if (!targetItems.getKey().equals(itemList.getKey())) {

                ITEM item = ItemUtil.createItemInstance(clazz, itemList.getKey(), this.getSimilarity(itemList, targetItems));
                items.add(item);
            }
        }
        return items;
    }

    public <ITEMS extends Items<ITEM>, ITEM extends Item> List<ITEMS> getSimilaritesList(final List<ITEMS> itemsList, Class<ITEMS> clazzItmes,
            Class<ITEM> clazzItem)
            throws InstantiationException, IllegalAccessException {
        List<ITEMS> similaritesList = new ArrayList<ITEMS>();
        for (ITEMS items : itemsList) {
            ITEMS similarities = ItemUtil.createItemsInstance(clazzItmes, items.getKey(), this.getSimilarities(itemsList, items, clazzItem));
            similaritesList.add(similarities);
        }

        return similaritesList;
    }

    public <ITEMS extends Items<ITEM>, ITEM extends Item> List<ITEM> getRecommendations(final List<ITEMS> itemsList, final ITEMS targetItems,
            final Class<ITEM> clazz)
            throws InstantiationException,
            IllegalAccessException {
        Map<Object, Double> scores = new HashMap<Object, Double>();
        Map<Object, Double> sumSimilarities = new HashMap<Object, Double>();

        for (ITEMS itemList : itemsList) {
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
        List<ITEM> recommendations = new ArrayList<ITEM>();

        for (Iterator<Entry<Object, Double>> it = scores.entrySet().iterator(); it.hasNext();) {
            Map.Entry<Object, Double> entry = (Map.Entry<Object, Double>) it.next();
            ITEM item = ItemUtil.createItemInstance(clazz, entry.getKey(), entry.getValue() / sumSimilarities.get(entry.getKey()));
            recommendations.add(item);
        }

        ItemUtil.sortByItemValue(recommendations);
        return recommendations;
    }

    public <ITEMS extends Items<ITEM>, ITEM extends Item> List<ITEM> getRecomendedItems(final List<ITEMS> similaryItemsList, final ITEMS target,
            final Class<ITEM> clazz)
            throws InstantiationException,
            IllegalAccessException {
        Map<Object, Double> scores = new HashMap<Object, Double>();
        Map<Object, Double> sumSimilarities = new HashMap<Object, Double>();

        for (Item item : target.getItems()) {
            ITEMS similarItems = ItemUtil.getItemsByKey(similaryItemsList, item.getKey());
            if (similarItems != null) {
                for (Item similarItem : similarItems.getItems()) {
                    if (ItemUtil.getItemByKey(target, similarItem.getKey()) != null)
                        continue;

                    scores.put(
                            similarItem.getKey(),
                            scores.containsKey(similarItem.getKey()) ? scores.get(similarItem.getKey()) + item.getValue() * similarItem.getValue() : item
                                    .getValue()
                                    * similarItem.getValue());
                    sumSimilarities.put(similarItem.getKey(),
                            sumSimilarities.containsKey(similarItem.getKey()) ? sumSimilarities.get(similarItem.getKey()) + similarItem.getValue()
                                    : similarItem.getValue());

                }
            }
        }

        List<ITEM> recommendations = new ArrayList<ITEM>();

        for (Iterator<Entry<Object, Double>> it = scores.entrySet().iterator(); it.hasNext();) {
            Map.Entry<Object, Double> entry = (Map.Entry<Object, Double>) it.next();
            ITEM item = ItemUtil.createItemInstance(clazz, entry.getKey(), entry.getValue() / sumSimilarities.get(entry.getKey()));
            recommendations.add(item);
        }

        ItemUtil.sortByItemValue(recommendations);
        return recommendations;
    }
}
