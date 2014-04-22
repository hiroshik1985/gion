package com.ucacu.gion.recommendation.model;

public abstract class ItemTemplate {
    protected Object key;
    protected double value;

    public Object getKey() {
        return this.key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
