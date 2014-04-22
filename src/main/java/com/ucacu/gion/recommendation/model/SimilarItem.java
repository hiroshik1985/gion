package com.ucacu.gion.recommendation.model;

public interface SimilarItem {

    public void setKey(Object key);

    public Object getKey();

    public void setSimilarity(double similarity);

    public double getSimilarity();
}
