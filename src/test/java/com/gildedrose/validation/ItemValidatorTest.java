package com.gildedrose.validation;

import com.gildedrose.Item;
import com.gildedrose.ItemType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemValidatorTest {

    private ItemValidator itemValidator;

    @BeforeEach
    void setup () {
        itemValidator = new ItemValidator ();
    }

    private static Stream<Arguments> sellInValidationItems () {
        return Stream.of (
                Arguments.of (new Item (ItemType.AGED_BRIE.getItemName (), 5, 10), 4)
        );
    }

    private static Stream<Arguments> getItemsForIncrementQuality () {
        return Stream.of (
                Arguments.of (new Item (ItemType.AGED_BRIE.getItemName (), 5, 10), 2, 12),
                Arguments.of (new Item (ItemType.AGED_BRIE.getItemName (), 5, 50), 2, 50)
        );
    }

    private static Stream<Arguments> getItemsToCheckExpiration () {
        return Stream.of (
                Arguments.of (new Item (ItemType.AGED_BRIE.getItemName (), 0, 10), false),
                Arguments.of (new Item (ItemType.AGED_BRIE.getItemName (), -1, 50), true)
        );
    }

    @ParameterizedTest(name = "Verify SellIn days for items - {index}")
    @MethodSource("sellInValidationItems")
    @DisplayName("SellIn value decrease by 1 for all items")
    void updateSellInDays (Item input, int expectedSellIn) {

        itemValidator.updateSellInDays (input);

        assertEquals (expectedSellIn, input.sellIn);
    }

    @ParameterizedTest(name = "Increment item quality - {index} ")
    @MethodSource("getItemsForIncrementQuality")
    @DisplayName("Increment item quality")
    void incrementQualityForItems (Item input, int amount, int expectedQuality) {

        itemValidator.incrementQuality (input, amount);

        assertEquals (expectedQuality, input.quality);
    }

    @ParameterizedTest(name = "Verify item is expired - {index}")
    @MethodSource("getItemsToCheckExpiration")
    @DisplayName("Validate Item Expiration")
    void verifyItemExpiration (Item input, boolean expectedValue) {

        boolean result = itemValidator.isExpired (input);

        assertEquals (expectedValue, result);
    }

    private static Stream<Arguments> getItemsForDecrementQuality () {
        return Stream.of (
                Arguments.of (new Item ("Elixir of the Mongoose", 5, 10), 2, 8),
                Arguments.of (new Item ("Elixir of the Mongoose", 5, 2), 2, 0),
                Arguments.of (new Item ("Elixir of the Mongoose", 5, 0), 2, 0)
        );
    }

    @ParameterizedTest(name = "Decrement item quality - {index} ")
    @MethodSource("getItemsForDecrementQuality")
    @DisplayName("Decrement item quality")
    void decrementQualityForItems (Item input, int amount, int expectedQuality) {

        itemValidator.decrementQuality (input, amount);

        assertEquals (expectedQuality, input.quality);
    }

    private static Stream<Arguments> getItemsToSetQualityForMinimum () {
        return Stream.of (
                Arguments.of (new Item (ItemType.BACK_STAGE_PASSES.getItemName (), 5, 10), 0),
                Arguments.of (new Item (ItemType.BACK_STAGE_PASSES.getItemName (), 0, 2), 0)
        );
    }

    @ParameterizedTest(name = "Set quality to minimum - {index} ")
    @MethodSource("getItemsToSetQualityForMinimum")
    @DisplayName("Set the quality to minimum for the items")
    void setQualityToMinForItems (Item input, int expectedQuality) {

        itemValidator.setQualityToMinimum (input);

        assertEquals (expectedQuality, input.quality);
    }
}
