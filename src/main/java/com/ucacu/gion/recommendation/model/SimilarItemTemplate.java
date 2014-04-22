package com.ucacu.gion.recommendation.model;

public abstract class SimilarItemTemplate {
    protected Object key;
    protected double similarity;

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getKey() {
        return this.key;
    }

    public void setSimilarity(double similarity) {
        this.similarity = similarity;
    }

    public double getSimilarity() {
        return this.similarity;
    }
}
