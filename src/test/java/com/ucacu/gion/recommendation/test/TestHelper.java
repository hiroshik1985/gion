package com.ucacu.gion.recommendation.test;

import java.util.ArrayList;
import java.util.List;

import com.ucacu.gion.recommendation.model.DefaultItem;
import com.ucacu.gion.recommendation.model.DefaultItems;
import com.ucacu.gion.recommendation.model.Item;
import com.ucacu.gion.recommendation.model.Items;

public class TestHelper {
    public static List<DefaultItems> getTestCritics() {
        List<DefaultItems> critics = new ArrayList<DefaultItems>();
        List<DefaultItem> scores = new ArrayList<DefaultItem>();
        scores.add(new DefaultItem("Lady in the Water", 2.5d));
        scores.add(new DefaultItem("Snakes on a Plane", 3.5d));
        scores.add(new DefaultItem("Just My Luck", 3.0d));
        scores.add(new DefaultItem("Superman Returns", 3.5d));
        scores.add(new DefaultItem("You, Me and Dupree", 2.5d));
        scores.add(new DefaultItem("The Night Listener", 3.0d));
        critics.add(new DefaultItems("Lisa Rose", scores));

        scores = new ArrayList<DefaultItem>();
        scores.add(new DefaultItem("Lady in the Water", 3.0d));
        scores.add(new DefaultItem("Snakes on a Plane", 3.5d));
        scores.add(new DefaultItem("Just My Luck", 1.5d));
        scores.add(new DefaultItem("Superman Returns", 5.0d));
        scores.add(new DefaultItem("You, Me and Dupree", 3.5d));
        scores.add(new DefaultItem("The Night Listener", 3.0d));
        critics.add(new DefaultItems("Gene Seymour", scores));

        scores = new ArrayList<DefaultItem>();
        scores.add(new DefaultItem("Lady in the Water", 2.5d));
        scores.add(new DefaultItem("Snakes on a Plane", 3.0d));
        scores.add(new DefaultItem("Superman Returns", 3.5d));
        scores.add(new DefaultItem("The Night Listener", 4.0d));
        critics.add(new DefaultItems("Michael Phillips", scores));

        scores = new ArrayList<DefaultItem>();
        scores.add(new DefaultItem("Snakes on a Plane", 3.5d));
        scores.add(new DefaultItem("Just My Luck", 3.0d));
        scores.add(new DefaultItem("Superman Returns", 4.0d));
        scores.add(new DefaultItem("You, Me and Dupree", 2.5d));
        scores.add(new DefaultItem("The Night Listener", 4.5d));
        critics.add(new DefaultItems("Claudia Puig", scores));

        scores = new ArrayList<DefaultItem>();
        scores.add(new DefaultItem("Lady in the Water", 3.0d));
        scores.add(new DefaultItem("Snakes on a Plane", 4.0d));
        scores.add(new DefaultItem("Just My Luck", 2.0d));
        scores.add(new DefaultItem("Superman Returns", 3.0d));
        scores.add(new DefaultItem("You, Me and Dupree", 2.0d));
        scores.add(new DefaultItem("The Night Listener", 3.0d));
        critics.add(new DefaultItems("Mick LaSalle", scores));

        scores = new ArrayList<DefaultItem>();
        scores.add(new DefaultItem("Lady in the Water", 3.0d));
        scores.add(new DefaultItem("Snakes on a Plane", 4.0d));
        scores.add(new DefaultItem("Superman Returns", 5.0d));
        scores.add(new DefaultItem("You, Me and Dupree", 3.5d));
        scores.add(new DefaultItem("The Night Listener", 3.0d));
        critics.add(new DefaultItems("Jack Matthews", scores));

        scores = new ArrayList<DefaultItem>();
        scores.add(new DefaultItem("Snakes on a Plane", 4.5d));
        scores.add(new DefaultItem("Superman Returns", 4.0d));
        scores.add(new DefaultItem("You, Me and Dupree", 1.0d));
        critics.add(new DefaultItems("Toby", scores));

        return critics;
    }

    public static <T extends Items<U>, U extends Item> void printTestData(List<T> critics) {
        for (T c : critics) {
            System.out.println(c.getKey() + " :");
            for (Item item : c.getItems()) {
                System.out.println(" " + item.getKey() + " : " + item.getValue());
            }
        }
    }
}
