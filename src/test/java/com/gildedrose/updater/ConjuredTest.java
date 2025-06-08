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
}
