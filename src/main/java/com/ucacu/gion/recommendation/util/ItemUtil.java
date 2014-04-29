package com.ucacu.gion.recommendation.util;

import java.util.ArrayList;
import java.util.List;

import com.ucacu.gion.recommendation.model.Item;
import com.ucacu.gion.recommendation.model.Items;

public class ItemUtil {
    public static Boolean containsItem(Items items, Item target) {
        for (Item item : items.getItems()) {
            if (item.getKey().equals(target.getKey()))
                return true;
        }
        return false;
    }

    public static Item getItemByKey(Items items, Object key) {
        for (Item item : items.getItems()) {
            if (item.getKey().equals(key))
                return item;
        }
        return null;
    }

    public static <T extends Item> void sortByItemValue(List<T> items)
    {
        boolean flag = true;
        T tmp;
        while (flag) {
            flag = false;
            for (int i = 0; i < items.size() - 1; i++) {
                if (items.get(i).getValue() < items.get(i + 1).getValue()) {
                    tmp = items.get(i);
                    items.set(i, items.get(i + 1));
                    items.set(i + 1, tmp);
                    flag = true;
                }
            }
        }
    }

    public static Items getItemListByKey(List<Items> itemsList, Object key) {
        for (Items items : itemsList) {
            if (items.getKey().equals(key))
                return items;
        }
        return null;
    }

    public static <T extends Items, U extends Item> transfrom(List<T> src, Class<T> clazzItems, Class<U> clazzItem) {
        List<T> dst = new ArrayList<T>();
        for (T items : src) {
            for(Item item : items.getItems()){
                for(T itemDst)
            }
        }
    }

    public static <T extends Item> T createItemInstance(Class<T> clazz, Object key, double value) throws InstantiationException, IllegalAccessException {
        T t = clazz.newInstance();
        t.setKey(key);
        t.setValue(value);

        return t;
    }

    @SuppressWarnings("unchecked")
    public static <T extends Items, U extends Item> T createItemsInstance(Class<T> clazzItmes, Object key, List<U> list) throws InstantiationException,
            IllegalAccessException {
        T t = clazzItmes.newInstance();
        t.setKey(key);
        t.setItems((List<Item>) list);

        return t;
    }
}
