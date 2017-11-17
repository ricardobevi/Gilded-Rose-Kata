package com.gildedrose.items;

import com.gildedrose.Item;

abstract class AbstractItem {

    public String name;

    public int sellIn;

    public int quality;

    public AbstractItem(){}

    public AbstractItem(Item item){
        this.name = item.name;
        this.sellIn = item.sellIn;
        this.quality = item.quality;
    }

    protected void increaseQuality() {
        if (this.quality < 50) {
            this.quality = this.quality + 1;
        }
    }

    protected void decreaseQuality() {
        if (this.quality > 0) {
            this.quality = this.quality - 1;
        }
    }

    protected void decreaseSellIn() {
        this.sellIn = this.sellIn - 1;
    }

    protected boolean hasExpired() {
        return this.sellIn < 0;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

}
