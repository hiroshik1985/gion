package com.ucacu.gion.recommendation.model;

import java.util.List;

public class DefaultCritic extends CriticTemplate implements Critic {
    public DefaultCritic(Object key, List<Item> items) {
        this.key = key;
        this.items = items;
    }
}
