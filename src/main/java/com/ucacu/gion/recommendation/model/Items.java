package com.ucacu.gion.recommendation.model;

import java.util.List;

public interface Items {
    public Object getKey();

    public void setKey(Object Key);

    public <T extends Item> List<T> getItems();

    public <T extends Item> void setItems(List<T> items);
}
