package com.ucacu.gion.recommendation.model;

import java.util.List;

public abstract class ItemsTemplate<T extends Item> {
    protected Object key;
    protected List<T> items;

    public Object getKey() {
        return this.key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public List<T> getItems() {
        return this.items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
