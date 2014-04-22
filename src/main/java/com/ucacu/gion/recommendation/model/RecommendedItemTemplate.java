package com.ucacu.gion.recommendation.model;

public abstract class RecommendedItemTemplate {
    protected Object key;
    protected double recommendation;

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getKey() {
        return this.key;
    }

    public void setRecommenedation(double recommendation) {
        this.recommendation = recommendation;
    }

    public double getRecommenedation() {
        return this.recommendation;
    }
}
