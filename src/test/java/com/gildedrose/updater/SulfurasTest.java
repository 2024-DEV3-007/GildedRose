package com.gildedrose.updater;

import com.gildedrose.Item;
import com.gildedrose.ItemType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SulfurasTest {

    private Sulfuras sulfuras;

    @BeforeEach
    void setUp () {
        sulfuras = new Sulfuras ();
    }

    @Test
    @DisplayName ("Sulfuras sellIn value does not change")
    void sellInDaysDoesNotChangeForASulfuras () {

        Item item = new Item (ItemType.SULFURAS.getItemName (), 5, 80);

        sulfuras.update (item);

        assertEquals (5, item.sellIn);
    }

    @Test
    @DisplayName("Sulfuras quality will not change")
    void qualityDoesNotChangeForASulfuras () {

        Item item = new Item (ItemType.SULFURAS.getItemName (), 5, 80);

        sulfuras.update (item);

        assertEquals (80, item.quality);
    }
}
