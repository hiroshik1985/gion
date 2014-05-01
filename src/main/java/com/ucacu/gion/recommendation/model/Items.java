package com.ucacu.gion.recommendation.model;

import java.util.List;

public interface Items<T extends Item> {
    public Object getKey();

    public void setKey(Object Key);

    public List<T> getItems();

    public void setItems(List<T> items);
}
