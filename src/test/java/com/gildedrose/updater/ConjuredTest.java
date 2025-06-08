package com.gildedrose.updater;

import com.gildedrose.Item;
import com.gildedrose.ItemType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConjuredTest {

    private Conjured conjured;

    @BeforeEach
    void setUp () {
        conjured = new Conjured ();
    }

    @Test
    @DisplayName ("Conjured : SellIn value reduces by one")
    void updateSellInDaysForConjured () {

        Item item = new Item (ItemType.CONJURED.getItemName (), 1, 1);

        conjured.update (item);

        assertEquals (0, item.sellIn);
    }

    @Test
    @DisplayName("Conjured : Quality decreases by 2 before sellIn date")
    void qualityDecreasesByTwoBeforeSellIn() {

        Item item = new Item(ItemType.CONJURED.getItemName (), 5, 10);

        conjured.update (item);

        assertEquals(8, item.quality);
    }

    @Test
    @DisplayName("Conjured : Quality decreases by 4 when expires")
    void qualityDecreasesByFourWhenExpires() {

        Item item = new Item(ItemType.CONJURED.getItemName (), 0, 10);

        conjured.update (item);

        assertEquals(6, item.quality);
    }

    @Test
    @DisplayName("Conjured : Quality never goes below 0")
    void qualityNeverGoesBelowZero() {

        Item item = new Item(ItemType.CONJURED.getItemName (), 0, 0);

        conjured.update (item);

        assertEquals(0, item.quality);
    }
}
