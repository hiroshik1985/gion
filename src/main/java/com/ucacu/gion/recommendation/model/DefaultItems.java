package com.ucacu.gion.recommendation.model;

import java.util.List;

public class DefaultItems extends ItemsTemplate implements Items {
    public DefaultItems(Object key, List<Item> items) {
        this.key = key;
        this.items = items;
    }
}
