package com.ucacu.gion.recommendation.model;

import java.util.List;

public interface Items<ITEM extends Item> {
    public Object getKey();

    public void setKey(Object Key);

    public List<ITEM> getItems();

    public void setItems(List<ITEM> items);
}
