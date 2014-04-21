package com.ucacu.gion.recommendation;

import java.util.ArrayList;
import java.util.List;

import com.ucacu.gion.recommendation.data.Critic;
import com.ucacu.gion.recommendation.data.SimilarItem;

public abstract class Recommender {
	public abstract double getSimilarity(Critic critic1, Critic critic2);
	public List<SimilarItem> getSimilarItem(List<Critic> critics, Critic target){
		List<SimilarItem> items = new ArrayList<SimilarItem>();
		
		for(Critic c : critics){
			if(!target.getKey().equals(c.getKey())){
				items.add(new SimilarItem(c.getKey(),this.getSimilarity(c, target)));
			}
		}
		
		return items;
	}
}
