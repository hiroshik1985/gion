package com.ucacu.gion.recommendation.data;

public abstract class ScoreTemplate{
	protected Object key;
	protected Double score;
	
    public Object getKey(){
    	return this.key;
    }

    public Double getScore(){
    	return this.score;
    }
}
