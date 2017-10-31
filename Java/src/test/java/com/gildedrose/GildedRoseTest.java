package com.gildedrose;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    private Item[] items;

    private GildedRose gildedRose;

    @Before
    public void setup() {
        this.items = new Item[] {
                new Item("Sword of Burning Fire", 10, 26),
                new Item("Aged Brie", 10, 0),
                new Item("Vest of Hermes", 5, 7),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 24),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80)
        };

        this.gildedRose = new GildedRose( this.items );
    }

    @After
    public void destroy() {
        this.items = null;
        this.gildedRose = null;
    }

    private void updateQualityTimes(int times) {
        IntStream.range(0, times).forEach( x -> this.gildedRose.updateQuality() );
    }

    @Test
    public void updateQualityForOneDay() throws Exception {
        // WHEN
        updateQualityTimes(1);

        // THEN
        assertEquals(
            "Sword of Burning Fire, 9, 25\n" +
            "Aged Brie, 9, 1\n" +
            "Vest of Hermes, 4, 6\n" +
            "Backstage passes to a TAFKAL80ETC concert, 9, 26\n" +
            "Sulfuras, Hand of Ragnaros, 0, 80\n" +
            "Sulfuras, Hand of Ragnaros, -1, 80\n",
            this.gildedRose.toString()
        );
    }

    @Test
    public void updateQualityUntilItemsExpire() throws Exception {
        // WHEN
        updateQualityTimes(11);

        // THEN
        assertEquals(
                "Sword of Burning Fire, -1, 14\n" +
                "Aged Brie, -1, 12\n" +
                "Vest of Hermes, -6, 0\n" +
                "Backstage passes to a TAFKAL80ETC concert, -1, 0\n" +
                "Sulfuras, Hand of Ragnaros, 0, 80\n" +
                "Sulfuras, Hand of Ragnaros, -1, 80\n",
                this.gildedRose.toString()
        );
    }

}
