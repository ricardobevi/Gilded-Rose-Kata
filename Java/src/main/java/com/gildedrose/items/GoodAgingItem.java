package com.gildedrose.items;

import com.gildedrose.Item;

class GoodAgingItem extends AbstractItem implements IItem {

    GoodAgingItem(Item item){
        super(item);
    }

    GoodAgingItem(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void updateQuality() {
        increaseQuality();
        decreaseSellIn();

        if (this.hasExpired())
            increaseQuality();
    }


}
