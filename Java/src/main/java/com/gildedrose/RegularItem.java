package com.gildedrose;

public class RegularItem extends AbstractItem implements IItem {

    RegularItem(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void updateQuality() {
        decreaseQuality();
        decreaseSellIn();

        if (this.hasExpired())
            decreaseQuality();
    }

}
