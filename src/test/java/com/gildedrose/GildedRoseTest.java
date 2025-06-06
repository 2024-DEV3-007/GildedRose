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
}
