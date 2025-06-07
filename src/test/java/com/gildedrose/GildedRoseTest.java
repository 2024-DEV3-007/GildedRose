package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {

    private static Stream<Arguments> sellInValidationItems () {
        return Stream.of (
                Arguments.of (new Item[]{new Item (ItemType.AGED_BRIE.getItemName (), 1, 1)}, 0),
                Arguments.of(new Item[] { new Item("Elixir of the Mongoose", 2, 1) }, 1)
        );
    }

    @ParameterizedTest(name = "Verify SellIn days for items - {index}")
    @MethodSource("sellInValidationItems")
    @DisplayName("SellIn value decrease by 1 for all items")
    void updateSellInDaysForItems (Item[] items, int expectedSellInDays) {

        GildedRose app = new GildedRose (items);

        app.updateQuality ();

        assertEquals (expectedSellInDays, items[0].sellIn);
    }

    private static Stream<Arguments> qualityValidationItems () {
        return Stream.of (
                Arguments.of (new Item[]{new Item (ItemType.AGED_BRIE.getItemName (), 1, 1)}, 2),
                Arguments.of (new Item[]{new Item (ItemType.AGED_BRIE.getItemName (), 0, 10)}, 12),
                Arguments.of (new Item[]{new Item (ItemType.AGED_BRIE.getItemName (), 2, 50)}, 50),

                Arguments.of(new Item[] { new Item("Elixir of the Mongoose", 2, 1) }, 0),
                Arguments.of(new Item[] { new Item("Elixir of the Mongoose", 0, 6) },4),
                Arguments.of(new Item[] { new Item("Elixir of the Mongoose", 5, 0) },0)
        );
    }

    @ParameterizedTest(name = "Verify Quality  for items - {index}")
    @MethodSource("qualityValidationItems")
    @DisplayName("Validate quality value for all items")
    void updateQualityForItems (Item[] items, int expectedQuality) {

        GildedRose app = new GildedRose (items);

        app.updateQuality ();

        assertEquals (expectedQuality, items[0].quality);
    }
}
