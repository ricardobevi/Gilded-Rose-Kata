package com.gildedrose;

public class StaticItem extends AbstractItem implements IItem {

    StaticItem(String name, int sellIn, int quality){
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void updateQuality() {
        // Nothing to do here...
    }



}
