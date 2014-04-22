package com.ucacu.gion.recommendation.model;

public class DefaultItem extends ItemTemplate implements Item {
    public DefaultItem() {}

    public DefaultItem(Object key, double value) {
        this.key = key;
        this.value = value;
    }
}
