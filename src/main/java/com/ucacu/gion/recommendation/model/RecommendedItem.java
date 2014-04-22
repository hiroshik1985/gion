package com.ucacu.gion.recommendation.model;

public interface RecommendedItem {

    public void setKey(Object key);

    public Object getKey();

    public void setRecommendation(double recommendation);

    public double getRecommendation();
}
