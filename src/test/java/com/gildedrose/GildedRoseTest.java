package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {

    @Test
    @DisplayName ("Aged Brie : SellIn value reduces by one for each day")
    void updateSellInDaysForAgedBrie () {

        Item[] items = new Item[]{new Item ("Aged Brie", 1, 1)};
        GildedRose app = new GildedRose (items);
        app.updateQuality ();
        assertEquals (0, items[0].sellIn);
    }

    @Test
    @DisplayName("Aged Brie: Increases quality by 1 when sellIn is greater than 0")
    void updateQualityBeforeSellInDayForAgedBrie () {

        Item[] items = new Item[]{new Item ("Aged Brie", 5, 10)};
        GildedRose app = new GildedRose (items);
        app.updateQuality ();
        assertEquals (11, items[0].quality);
    }
}
