package com.gildedrose;

import org.junit.Before;
import org.junit.Test;

public class GildedRoseSpec {

    GildedRose gildedRose;

    @Before
    public void setup(){
    }

    @Test
    public void should_degrade_quality_and_sellin_as_time_passes(){
        Item[] items = { new Item("lala", 10, 10) };

        gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assert items[0].quality == 9;
        assert items[0].sellIn == 9;
    }

    @Test
    public void should_degrade_quality_twice_as_fast_after_sell_in_date(){
        Item[] items = { new Item("lala", 0, 10) };

        gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assert items[0].quality == 8;
        assert items[0].sellIn == -1;
    }

    @Test
    public void should_not_have_negtive_quality(){
        Item[] items = { new Item("lala", 0, 0) };

        gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assert items[0].quality == 0;
        assert items[0].sellIn == -1;
    }

    @Test
    public void should_increase_quality_of_Aged_Brie(){
        Item[] items = { new Item("Aged Brie", 10, 10) };

        gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assert items[0].quality == 11;
        assert items[0].sellIn == 9;
    }

    @Test
    public void should_increase_quality_of_Aged_Brie_up_to_50(){
        Item[] items = { new Item("Aged Brie", 10, 50) };

        gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assert items[0].quality == 50;
        assert items[0].sellIn == 9;
    }

    @Test
    public void should_not_modify_Sulfuras_item(){
        Item[] items = { new Item("Sulfuras, Hand of Ragnaros", 10, 80) };

        gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assert items[0].quality == 80;
        assert items[0].sellIn == 10;
    }

    @Test
    public void should_decrease_quality_by_2_when_less_than_10_days_for_concert(){
        Item[] items = { new Item("Backstage passes to a TAFKAL80ETC concert", 9, 20) };

        gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assert items[0].quality == 22;
        assert items[0].sellIn == 8;
    }

    @Test
    public void should_decrease_quality_by_3_when_less_than_5_days_for_concert(){
        Item[] items = { new Item("Backstage passes to a TAFKAL80ETC concert", 4, 20) };

        gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assert items[0].quality == 23;
        assert items[0].sellIn == 3;
    }

    @Test
    public void should_decrease_quality_to_0_when_concert_has_passed(){
        Item[] items = { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) };

        gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assert items[0].quality == 0;
        assert items[0].sellIn == -1;
    }

    @Test
    public void should_decrease_quality_twice_as_fast_for_conjured_items(){
        Item[] items = { new Item("Conjured", 10, 20) };

        gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assert items[0].quality == 18;
        assert items[0].sellIn == 9;
    }

    @Test
    public void should_decrease_quality_up_to_zero_for_conjured_items(){
        Item[] items = { new Item("Conjured", 10, 1) };

        gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assert items[0].quality == 0;
        assert items[0].sellIn == 9;
    }


}
