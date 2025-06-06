package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose (Item[] items) {
        this.items = items;
    }

    public void updateQuality () {
        for (Item item : items) {
            if (item.name.equals ("Aged Brie"))
                item.sellIn--;
        }
    }
}
