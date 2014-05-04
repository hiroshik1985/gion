package com.ucacu.gion.recommendation.test;

import java.util.ArrayList;
import java.util.List;

import com.ucacu.gion.recommendation.model.DefaultItem;
import com.ucacu.gion.recommendation.model.DefaultItems;
import com.ucacu.gion.recommendation.model.Item;
import com.ucacu.gion.recommendation.model.Items;

public class TestHelper {
    public static List<DefaultItems> getTestCritics() {
        List<DefaultItems> imtesList = new ArrayList<DefaultItems>();
        List<DefaultItem> itemList = new ArrayList<DefaultItem>();
        itemList.add(new DefaultItem("Lady in the Water", 2.5d));
        itemList.add(new DefaultItem("Snakes on a Plane", 3.5d));
        itemList.add(new DefaultItem("Just My Luck", 3.0d));
        itemList.add(new DefaultItem("Superman Returns", 3.5d));
        itemList.add(new DefaultItem("You, Me and Dupree", 2.5d));
        itemList.add(new DefaultItem("The Night Listener", 3.0d));
        imtesList.add(new DefaultItems("Lisa Rose", itemList));

        itemList = new ArrayList<DefaultItem>();
        itemList.add(new DefaultItem("Lady in the Water", 3.0d));
        itemList.add(new DefaultItem("Snakes on a Plane", 3.5d));
        itemList.add(new DefaultItem("Just My Luck", 1.5d));
        itemList.add(new DefaultItem("Superman Returns", 5.0d));
        itemList.add(new DefaultItem("You, Me and Dupree", 3.5d));
        itemList.add(new DefaultItem("The Night Listener", 3.0d));
        imtesList.add(new DefaultItems("Gene Seymour", itemList));

        itemList = new ArrayList<DefaultItem>();
        itemList.add(new DefaultItem("Lady in the Water", 2.5d));
        itemList.add(new DefaultItem("Snakes on a Plane", 3.0d));
        itemList.add(new DefaultItem("Superman Returns", 3.5d));
        itemList.add(new DefaultItem("The Night Listener", 4.0d));
        imtesList.add(new DefaultItems("Michael Phillips", itemList));

        itemList = new ArrayList<DefaultItem>();
        itemList.add(new DefaultItem("Snakes on a Plane", 3.5d));
        itemList.add(new DefaultItem("Just My Luck", 3.0d));
        itemList.add(new DefaultItem("Superman Returns", 4.0d));
        itemList.add(new DefaultItem("You, Me and Dupree", 2.5d));
        itemList.add(new DefaultItem("The Night Listener", 4.5d));
        imtesList.add(new DefaultItems("Claudia Puig", itemList));

        itemList = new ArrayList<DefaultItem>();
        itemList.add(new DefaultItem("Lady in the Water", 3.0d));
        itemList.add(new DefaultItem("Snakes on a Plane", 4.0d));
        itemList.add(new DefaultItem("Just My Luck", 2.0d));
        itemList.add(new DefaultItem("Superman Returns", 3.0d));
        itemList.add(new DefaultItem("You, Me and Dupree", 2.0d));
        itemList.add(new DefaultItem("The Night Listener", 3.0d));
        imtesList.add(new DefaultItems("Mick LaSalle", itemList));

        itemList = new ArrayList<DefaultItem>();
        itemList.add(new DefaultItem("Lady in the Water", 3.0d));
        itemList.add(new DefaultItem("Snakes on a Plane", 4.0d));
        itemList.add(new DefaultItem("Superman Returns", 5.0d));
        itemList.add(new DefaultItem("You, Me and Dupree", 3.5d));
        itemList.add(new DefaultItem("The Night Listener", 3.0d));
        imtesList.add(new DefaultItems("Jack Matthews", itemList));

        itemList = new ArrayList<DefaultItem>();
        itemList.add(new DefaultItem("Snakes on a Plane", 4.5d));
        itemList.add(new DefaultItem("Superman Returns", 4.0d));
        itemList.add(new DefaultItem("You, Me and Dupree", 1.0d));
        imtesList.add(new DefaultItems("Toby", itemList));

        return imtesList;
    }

    public static <ITEMS extends Items<ITEM>, ITEM extends Item> void printItemsList(List<ITEMS> itemsList) {
        for (ITEMS items : itemsList) {
            System.out.println(items.getKey() + " :");
            for (Item item : items.getItems()) {
                System.out.println(" " + item.getKey() + " : " + item.getValue());
            }
        }
    }

    public static <ITEM extends Item> void printItemList(List<ITEM> itemList) {
        for (Item item : itemList) {
            System.out.println(item.getKey() + " : " + item.getValue());
        }
    }
}
