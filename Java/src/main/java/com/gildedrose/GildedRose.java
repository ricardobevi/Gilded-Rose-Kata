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
        updateQualityOfExpiredItem(item);
    }

    private void updateQualityOfItem(Item item) {
        if (!item.name.equals("Aged Brie")
                && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.quality > 0) {
                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    item.quality = item.quality - 1;
                }
            }
        } else {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.sellIn <= PASS_SELL_IN_FIRST_LIMIT) {
                        increaseQuality(item);
                    }

                    if (item.sellIn <= PASS_SELL_IN_SECOND_LIMIT) {
                        increaseQuality(item);
                    }
                }
            }
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void updateQualityOfExpiredItem(Item item) {
        if (item.sellIn < 0) {
            if (!item.name.equals("Aged Brie")) {
                if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.quality > 0) {
                        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                            item.quality = item.quality - 1;
                        }
                    }
                } else {
                    item.quality = item.quality - item.quality;
                }
            } else {
                increaseQuality(item);
            }
        }
    }

    private void updateSellInOfItem(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
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