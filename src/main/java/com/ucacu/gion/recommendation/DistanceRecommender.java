package com.ucacu.gion.recommendation;

import com.ucacu.gion.recommendation.data.Critic;
import com.ucacu.gion.recommendation.data.Score;

public class DistanceRecommender extends Recommender {
	@Override
	public double getSimilarity(Critic critic1, Critic critic2){
		double sumSquares = 0.0d;
		for(Score s1 : critic1.getScores()){
			for(Score s2 : critic2.getScores()){
				if(s1.getKey().equals(s2.getKey())){
					sumSquares += Math.pow(s1.getScore() - s2.getScore(), 2);
				}
			}
		}
		return sumSquares;
	}
}
