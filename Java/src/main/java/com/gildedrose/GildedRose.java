package com.gildedrose;

class GildedRose {


    public static final int PASS_SELL_IN_FIRST_LIMIT = 10;
    public static final int PASS_SELL_IN_SECOND_LIMIT = 5;
    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateQualityForOneItem(items[i]);
        }
    }

    private void updateQualityForOneItem(Item item) {
        updateQualityOfItem(item);
        updateSellInOfItem(item);
        if(item.sellIn < 0) {
            updateQualityOfExpiredItem(item);
        }
    }

    private void updateQualityOfItem(Item item) {
        if (item.name.equals("Aged Brie")
                || item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            increaseQuality(item);

            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.sellIn <= PASS_SELL_IN_FIRST_LIMIT) {
                    increaseQuality(item);
                }

                if (item.sellIn <= PASS_SELL_IN_SECOND_LIMIT) {
                    increaseQuality(item);
                }
            }
        } else {
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                decreaseQuality(item);
            }
        }
    }

    private void updateQualityOfExpiredItem(Item expiredItem) {
        if (expiredItem.name.equals("Aged Brie")) {
            increaseQuality(expiredItem);
        } else if (expiredItem.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            expiredItem.quality = 0;
        } else if (!expiredItem.name.equals("Sulfuras, Hand of Ragnaros")) {
            decreaseQuality(expiredItem);
        }
    }

    private void updateSellInOfItem(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    @Override
    public String toString() {
        String str = "";
        for (Item i : this.items) {
            str += i.toString();
            str += "\n";
        }
        return str;
    }
}