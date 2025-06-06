package com.gildedrose;

import com.gildedrose.factory.ItemUpdaterFactory;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose (Item[] items) {
        this.items = items;
    }

    public void updateQuality () {
        Arrays.stream (items).forEach (item -> {
            ItemUpdaterFactory.getItems (item.name).update (item);
        });
    }
}
