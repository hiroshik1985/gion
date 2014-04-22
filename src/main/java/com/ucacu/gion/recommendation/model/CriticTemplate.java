package com.ucacu.gion.recommendation.model;

import java.util.List;

public abstract class CriticTemplate {
    protected Object key;
    protected List<Item> items;

    public Object getKey() {
        return this.key;
    }

    public List<Item> getItems() {
        return this.items;
    }
}
