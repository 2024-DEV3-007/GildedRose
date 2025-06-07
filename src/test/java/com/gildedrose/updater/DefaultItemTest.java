package com.gildedrose.updater;

import com.gildedrose.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefaultItemTest {

    private DefaultItem defaultItem;

    @BeforeEach
    void setUp () {
        defaultItem = new DefaultItem ();
    }

    @Test
    @DisplayName("Default item : SellIn decreases by 1 each day")
    void updateSellInDaysForDefaultItem () {

        Item item = new Item ("Elixir of the Mongoose", 10, 20);

        defaultItem.update (item);

        assertEquals (9, item.sellIn);
    }

    @Test
    @DisplayName("Default item : Quality decreases by 1 before sellIn date")
    void qualityDecreasesByOneBeforeSellIn() {

        Item item = new Item("Elixir of the Mongoose", 5, 10);

        defaultItem.update(item);

        assertEquals(9, item.quality);
    }
}
