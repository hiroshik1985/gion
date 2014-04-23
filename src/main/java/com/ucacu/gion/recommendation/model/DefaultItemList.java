package com.ucacu.gion.recommendation.model;

import java.util.List;

public class DefaultItemList extends ItemListTemplate implements ItemList {
    public DefaultItemList(Object key, List<Item> items) {
        this.key = key;
        this.items = items;
    }
}
