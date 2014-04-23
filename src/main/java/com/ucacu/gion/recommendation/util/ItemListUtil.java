package com.ucacu.gion.recommendation.util;

import com.ucacu.gion.recommendation.model.Item;
import com.ucacu.gion.recommendation.model.ItemList;

public class ItemListUtil {
    public static Boolean containsItem(ItemList items, Item target) {
        for (Item item : items.getItems()) {
            if (item.getKey().equals(target.getKey()))
                return true;
        }
        return false;
    }
}
