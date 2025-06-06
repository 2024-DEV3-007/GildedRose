package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose (Item[] items) {
        this.items = items;
    }

    public void updateQuality () {
        for (Item item : items) {
            if (item.name.equals ("Aged Brie")) {
                int increment = (item.sellIn > 0) ? 1 : 2;
                item.quality += increment;
                item.sellIn--;
            }
        }
    }
}
