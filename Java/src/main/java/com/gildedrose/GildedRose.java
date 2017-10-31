package com.gildedrose;

class GildedRose {


    private static final int PASS_SELL_IN_FIRST_LIMIT = 10;
    private static final int PASS_SELL_IN_SECOND_LIMIT = 5;
    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items)
            updateQualityForOneItem(item);
    }

    private void updateQualityForOneItem(Item item) {
        updateQualityOfItem(item);
        updateSellInOfItem(item);

        if(this.hasExpired(item))
            updateQualityOfExpiredItem(item);
    }

    private void updateQualityOfItem(Item item) {
        switch (item.name) {
            case "Sulfuras, Hand of Ragnaros":
                break;
            case "Aged Brie":
                increaseQuality(item);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                increaseQuality(item);

                if (item.sellIn <= PASS_SELL_IN_FIRST_LIMIT)
                    increaseQuality(item);

                if (item.sellIn <= PASS_SELL_IN_SECOND_LIMIT)
                    increaseQuality(item);

                break;
            default:
                decreaseQuality(item);
                break;
        }
    }

    private void updateQualityOfExpiredItem(Item expiredItem) {
        switch (expiredItem.name) {
            case "Sulfuras, Hand of Ragnaros":
                break;
            case "Aged Brie":
                increaseQuality(expiredItem);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                expiredItem.quality = 0;
                break;
            default:
                decreaseQuality(expiredItem);
                break;
        }
    }

    private void updateSellInOfItem(Item item) {
        switch (item.name) {
            case "Sulfuras, Hand of Ragnaros":
                break;
            case "Aged Brie":
            case "Backstage passes to a TAFKAL80ETC concert":
            default:
                item.sellIn = item.sellIn - 1;
                break;
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

    private boolean hasExpired(Item item) {
        return item.sellIn < 0;
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