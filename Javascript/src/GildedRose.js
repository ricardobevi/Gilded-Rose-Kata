class GildedRose {
  constructor(items) {
    this.PASS_SELL_IN_FIRST_LIMIT = 10;
    this.PASS_SELL_IN_SECOND_LIMIT = 5;
    this.items = items;
  }

  updateQuality() {
    this.items.forEach(item => this.updateQualityForOneItem(item));
  }

  updateQualityForOneItem(item) {
    this.updateQualityOfItem(item);
    this.updateSellInOfItem(item);

    if (this.hasExpired(item)) {
      this.updateQualityOfExpiredItem(item);
    }
  }

  updateQualityOfItem(item) {
    switch (item.name) {
      case 'Sulfuras, Hand of Ragnaros':
        break;

      case 'Aged Brie':
        this.increaseQuality(item);
        break;

      case 'Backstage passes to a TAFKAL80ETC concert':
        this.increaseQuality(item);

        if (item.sellIn <= this.PASS_SELL_IN_FIRST_LIMIT) {
          this.increaseQuality(item);
        }

        if (item.sellIn <= this.PASS_SELL_IN_SECOND_LIMIT) {
          this.increaseQuality(item);
        }
        break;

      default:
        this.decreaseQuality(item);
        break;
      }
  }

  updateQualityOfExpiredItem(expiredItem) {
    switch (expiredItem.name) {
      case 'Sulfuras, Hand of Ragnaros':
        break;

      case 'Aged Brie':
        this.increaseQuality(expiredItem);
        break;

      case 'Backstage passes to a TAFKAL80ETC concert':
        expiredItem.quality = 0;
        break;

      default:
        this.decreaseQuality(expiredItem);
        break;
    }
  }

  updateSellInOfItem(item) {
    switch (item.name) {
      case 'Sulfuras, Hand of Ragnaros':
        break;

      case 'Aged Brie':
      case 'Backstage passes to a TAFKAL80ETC concert':
      default:
        item.sellIn = item.sellIn - 1;
        break;
    }
  }

  increaseQuality(item) {
    if (item.quality < 50) {
      item.quality = item.quality + 1;
    }
  }

  decreaseQuality(item) {
    if (item.quality > 0) {
      item.quality = item.quality - 1;
    }
  }

  hasExpired(item) {
    return item.sellIn < 0;
  }

  toString() {
    let string = '';

    this.items.forEach((item) => {
      string += item.toString();
      string += '/n';
    });

    return string;
  }
}

export default GildedRose
