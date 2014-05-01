package com.ucacu.gion.recommendation.util;

import java.util.ArrayList;
import java.util.List;

import com.ucacu.gion.recommendation.model.Item;
import com.ucacu.gion.recommendation.model.Items;

public class ItemUtil {
    public static <T extends Items<U>, U extends Item> Boolean containsItem(Items<U> items, Item target) {
        for (Item item : items.getItems()) {
            if (item.getKey().equals(target.getKey()))
                return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public static <T extends Items<U>, U extends Item> U getItemByKey(T items, Object key) {
        for (Item item : items.getItems()) {
            if (item.getKey().equals(key))
                return (U) item;
        }
        return null;
    }

    public static <T extends Items<U>, U extends Item> T getItemsByKey(List<T> itemsDstList, Object key) {
        for (T items : itemsDstList) {
            if (items.getKey().equals(key))
                return items;
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

    @SuppressWarnings("unchecked")
    public static <T extends Items<U>, U extends Item> List<T> transfrom(List<T> src, Class<T> clazzItems, Class<U> clazzItem) throws InstantiationException,
            IllegalAccessException {
        List<T> itemsDstList = new ArrayList<T>();
        for (T items : src) {
            for (Item item : items.getItems()) {

                T itemsDst = ItemUtil.getItemsByKey(itemsDstList, item.getKey());

                if (itemsDst == null) {
                    List<U> itemDst = new ArrayList<U>();
                    itemDst.add(ItemUtil.createItemInstance(clazzItem, items.getKey(), item.getValue()));
                    itemsDst = ItemUtil.createItemsInstance(clazzItems, item.getKey(), itemDst);
                    itemsDstList.add(itemsDst);
                }
                else {
                    U itemDst = ItemUtil.createItemInstance(clazzItem, items.getKey(), item.getValue());
                    itemsDst.getItems().add(itemDst);
                }
            }
        }

        return itemsDstList;
    }

    public static <T extends Item> T createItemInstance(Class<T> clazz, Object key, double value) throws InstantiationException, IllegalAccessException {
        T t = clazz.newInstance();
        t.setKey(key);
        t.setValue(value);

        return t;
    }

    public static <T extends Items<U>, U extends Item> T createItemsInstance(Class<T> clazzItmes, Object key, List<U> list) throws InstantiationException,
            IllegalAccessException {
        T t = clazzItmes.newInstance();
        t.setKey(key);
        t.setItems(list);

        return t;
    }
}
