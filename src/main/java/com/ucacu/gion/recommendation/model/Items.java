package com.ucacu.gion.recommendation.model;

import java.util.List;

public interface Items {
    public Object getKey();

    public void setKey(Object Key);

    public List<Item> getItems();

    public void setItems(List<Item> items);
}
