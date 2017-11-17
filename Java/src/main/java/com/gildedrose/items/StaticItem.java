package com.gildedrose.items;

import com.gildedrose.Item;

class StaticItem extends AbstractItem implements IItem {

    StaticItem(Item item){
        super(item);
    }

    StaticItem(String name, int sellIn, int quality){
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void updateQuality() {
        // Nothing to do here...
    }



}
