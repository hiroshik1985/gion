package com.ucacu.gion.recommendation;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ucacu.gion.recommendation.model.Critic;
import com.ucacu.gion.recommendation.model.DefaultCritic;
import com.ucacu.gion.recommendation.model.DefaultScore;
import com.ucacu.gion.recommendation.model.DefaultSimilarItem;
import com.ucacu.gion.recommendation.model.Score;
import com.ucacu.gion.recommendation.model.SimilarItem;

public class DistanceBasedRecommenderTest {
    List<Critic> critics;

    @Before
    public void testSetup() {
        critics = new ArrayList<Critic>();
        List<Score> scores = new ArrayList<Score>();
        scores.add(new DefaultScore("Lady in the Water", 2.5d));
        scores.add(new DefaultScore("Snakes on a Plane", 3.5d));
        scores.add(new DefaultScore("Just My Luck", 3.0d));
        scores.add(new DefaultScore("Superman Returns", 3.5d));
        scores.add(new DefaultScore("You, Me and Dupree", 2.5d));
        scores.add(new DefaultScore("The Night Listener", 3.0d));
        critics.add(new DefaultCritic("Lisa Rose", scores));

        scores = new ArrayList<Score>();
        scores.add(new DefaultScore("Lady in the Water", 3.0d));
        scores.add(new DefaultScore("Snakes on a Plane", 3.5d));
        scores.add(new DefaultScore("Just My Luck", 1.5d));
        scores.add(new DefaultScore("Superman Returns", 5.0d));
        scores.add(new DefaultScore("You, Me and Dupree", 3.5d));
        scores.add(new DefaultScore("The Night Listener", 3.0d));
        critics.add(new DefaultCritic("Gene Seymour", scores));

        scores = new ArrayList<Score>();
        scores.add(new DefaultScore("Lady in the Water", 2.5d));
        scores.add(new DefaultScore("Snakes on a Plane", 3.0d));
        scores.add(new DefaultScore("Superman Returns", 3.5d));
        scores.add(new DefaultScore("The Night Listener", 4.0d));
        critics.add(new DefaultCritic("Michael Phillips", scores));

        scores = new ArrayList<Score>();
        scores.add(new DefaultScore("Snakes on a Plane", 3.5d));
        scores.add(new DefaultScore("Just My Luck", 3.0d));
        scores.add(new DefaultScore("Superman Returns", 4.0d));
        scores.add(new DefaultScore("You, Me and Dupree", 2.5d));
        scores.add(new DefaultScore("The Night Listener", 4.5d));
        critics.add(new DefaultCritic("Claudia Puig", scores));

        scores = new ArrayList<Score>();
        scores.add(new DefaultScore("Lady in the Water", 3.0d));
        scores.add(new DefaultScore("Snakes on a Plane", 4.0d));
        scores.add(new DefaultScore("Just My Luck", 2.0d));
        scores.add(new DefaultScore("Superman Returns", 3.0d));
        scores.add(new DefaultScore("You, Me and Dupree", 2.0d));
        scores.add(new DefaultScore("The Night Listener", 3.0d));
        critics.add(new DefaultCritic("Mick LaSalle", scores));

        scores = new ArrayList<Score>();
        scores.add(new DefaultScore("Lady in the Water", 3.0d));
        scores.add(new DefaultScore("Snakes on a Plane", 4.0d));
        scores.add(new DefaultScore("Superman Returns", 5.0d));
        scores.add(new DefaultScore("You, Me and Dupree", 3.5d));
        scores.add(new DefaultScore("The Night Listener", 3.0d));
        critics.add(new DefaultCritic("Jack Matthews", scores));

        scores = new ArrayList<Score>();
        scores.add(new DefaultScore("Snakes on a Plane", 4.5d));
        scores.add(new DefaultScore("Superman Returns", 4.0d));
        scores.add(new DefaultScore("You, Me and Dupree", 1.0d));
        critics.add(new DefaultCritic("Toby", scores));
    }

    @Test
    public void testGetSimilarItems() throws InstantiationException, IllegalAccessException {
        DistanceBasedRecommender<DefaultSimilarItem> recommender = new DistanceBasedRecommender<DefaultSimilarItem>();

        List<DefaultSimilarItem> items = recommender.getSimilarItems(critics, critics.get(6), DefaultSimilarItem.class);
        recommender.sortBySimilarity(items);
        for (SimilarItem si : items) {
            System.out.println(si.getKey() + " : " + si.getSimilarity());
        }

    }

    private void printTestData() {
        for (Critic c : critics) {
            System.out.println(c.getKey() + " :");
            for (Score s : c.getScores()) {
                System.out.println(" " + s.getKey() + " : " + s.getScore());
            }
        }
    }
}
