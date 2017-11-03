import { expect } from 'chai';

import GildedRose from '../src/GildedRose';
import Item from '../src/Item';

describe('#GildedRose', () => {
  describe('buy item', () => {
      it('should test the store', () => {
        const items = [
          new Item('Sword of Burning Fire', 10, 26),
          new Item('Aged Brie', 10, 0),
          new Item('Vest of Hermes', 5, 7),
          new Item('Backstage passes to a TAFKAL80ETC concert', 10, 24),
          new Item('Sulfuras, Hand of Ragnaros', 0, 80)
        ]

        const shop = new GildedRose(items);

        [1,2,3,4,5,6,7,8,9,10,11].forEach(() => shop.updateQuality());

        expect(shop.toString()).to.be.equal(
          'Sword of Burning Fire -1 14/nAged Brie -1 12/nVest of Hermes -6 0/nBackstage passes to a TAFKAL80ETC concert -1 0/nSulfuras, Hand of Ragnaros 0 80/n'
        );
      });
  });
});
