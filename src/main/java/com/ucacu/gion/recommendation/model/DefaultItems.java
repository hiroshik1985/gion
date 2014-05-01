package com.ucacu.gion.recommendation.model;

import java.util.List;

public class DefaultItems extends ItemsTemplate<DefaultItem> implements Items<DefaultItem> {
    public DefaultItems() {}

    public DefaultItems(Object key, List<DefaultItem> items) {
        this.key = key;
        this.items = items;
    }
}
