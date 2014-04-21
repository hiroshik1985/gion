package com.ucacu.gion.recommendation.data;

public class DefaultScore extends ScoreTemplate implements Score {
	DefaultScore(Object key, Double score){
		this.key = key;
		this.score = score;
	}
}
