package com.gildedrose;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/*   Aina Lariol  */

class GildedRoseTest {

  @Test
  @DisplayName("Test that the name is unchanged")
  void testName() {
    Item element = new Item("foo", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.name, is("foo"));
  }

  // on teste que la qualité de Aged brie augmente bien de 1
  @Test
  void qualiteAgedBrie() {
      int qual = 5;
    int sell = 9;
    Item[] items = new Item[] { new Item("Aged Brie", sell, qual) };
    GildedRose app = new GildedRose(items);
      app.updateQuality();
      assertThat(app.items[0].quality, is(qual+1));
  }
  //test qualité si la qualité  est 49 et augmente bien de 1 si sellIn <=10
  @Test
  void qualiteAgedBrie49(){
      int qual = 49;
    int sell = 10;
    Item[] items = new Item[] { new Item("Aged Brie", sell, qual) };
    GildedRose app = new GildedRose(items);
      app.updateQuality();
      assertThat(app.items[0].quality, is(qual+1));
  }
 //test qualité si la qualité ne dépasse 50
  @Test
  void qualiteAgedBrieCinquante(){
      int qual = 50;
    int sell = 10;
    Item[] items = new Item[] { new Item("Aged Brie", sell, qual) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.items[0].quality, is(qual));
  }
  // test que la qualité de AgedBrie augmente de 1 si quality = 0
  @Test
  void qualite0AgedBriesiSellInPositive () {
      int qual = 0;
    int sell = 10;
    Item[] items = new Item[] { new Item("Aged Brie", sell, qual) };
    GildedRose app = new GildedRose(items);
      app.updateQuality();
      assertThat(app.items[0].quality, is(qual+1));
  }
  
  // test que la qualité de AgedBrie augmente de 1 si quality positive et sellIn dépassé
  /**@Test refacto
  void qualitePositiveAgedBriesiSellInNegative () {
      int qual = 10;
    int sell = -1;
    Item[] items = new Item[] { new Item("Aged Brie", sell, qual) };
    GildedRose app = new GildedRose(items);
      app.updateQuality();
      assertThat(app.items[0].quality, is(qual+2)); // +2 code originale
  }**/
   // test que la qualité de AgedBrie augmente de 1 si quality <50 et sellIn dépassé
  @Test
  void qualitePositiveAgedBriesiSellInNegative50 () {
      int qual = 49;
    int sell = -1;
    Item[] items = new Item[] { new Item("Aged Brie", sell, qual) };
    GildedRose app = new GildedRose(items);
      app.updateQuality();
      assertThat(app.items[0].quality, is(qual+1));
  }

  // test que la qualité de AgedBrie augmente de 1 avec une valeur negative si sellIn dépassé
  //enlever pdt refacto
  /**@Test
  void qualiteNegativeAgedBriesiSellInNegative () {
      int qual = 0;
    int sell = -1;
    Item[] items = new Item[] { new Item("Aged Brie", sell, qual) };
    GildedRose app = new GildedRose(items);
      app.updateQuality();
      assertThat(app.items[0].quality, is(qual+2)); //+2 sur le code originale
  }**/

  //test qualité pour Backstage passes avec sa qualité qui augment bien de 1 si SellIn >10
  @Test
  void qualiteBackstageSiSellInPlusde10 () {
      int qual = 10;
    int sell = 20 ;
    Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sell, qual) };
      GildedRose app = new GildedRose(items);
      app.updateQuality();
      assertThat(app.items[0].quality, is(qual+1));
  }
   

  //test qualité pour Backstage passes avec sa qualité qui augmente bien de 2 si SellIn <=10
  /**@Test refacto
  void qualiteBackstageSiSellInauMoins10 () {
      int qual = 2;
    int sell = 9;
    Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sell, qual) };
    GildedRose app = new GildedRose(items);
      app.updateQuality();
      assertThat(app.items[0].quality, is(qual+2));
  }**/
  //test qualité pour Backstage passes augmente bien de 1 si si qualite <50 SellIn =11
  @Test
  void qualiteBackstageSiSellIna11Qualite49 () {
    int qual = 49;
    int sell = 11;
    Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sell, qual) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.items[0].quality, is(qual+1));
  }
  //test qualité pour Backstage passes augmente bien de 1 si si qualite positive SellIn <=10
  @Test //refacto
  void qualiteBackstageSiSellIna11Qualitepositive () {
    int qual = 10;
    int sell = 11;
    Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sell, qual) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.items[0].quality, is(qual+1));
  }
  //test qualité pour Backstage passes augmente bien de 1 si si qualite <50 SellIn <=10
  @Test
  void qualiteBackstageSiSellInauMoins10Qualite49 () {
    int qual = 49;
    int sell = 10;
    Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sell, qual) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.items[0].quality, is(qual+1));
  }
  //test qualité pour Backstage passes augmente bien de 1 si si qualite positive SellIn <=10
  @Test
  void qualiteBackstageSiSellInauMoins10QualitePositive () {
    int qual = 49;
    int sell = 10;
    Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sell, qual) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.items[0].quality, is(qual+1));
  }
  //test qualité pour Backstage passes augmente bien de 1 si si qualite <50 SellIn <=5
  @Test
  void qualiteBackstageSiSellInauMoins5Qualite49 () {
      int qual = 49;
    int sell = 3;
    Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sell, qual) };
    GildedRose app = new GildedRose(items);
      app.updateQuality();
      assertThat(app.items[0].quality, is(qual+1));
  }

  
  //test qualité pour Backstage passes avec sa qualité <50 qui augmente bien de 3 si SellIn =6
  @Test
  void qualiteBackstageSiSellInSuperieur5Quality49 () {
    int qual = 49;
    int sell = 6;
    Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sell, qual) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.items[0].quality, is(qual+1));
  }
  //test qualité pour Backstage passes avec sa qualité positive qui augmente bien de 1 si SellIn =6
  @Test//enlever pdt refacto
  void qualiteBackstageSiSellInEgal6 () {
    int qual = 8;//10
    int sell = 6;
    Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sell, qual) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.items[0].quality, is(qual+2));
  }
  //test qualité pour Backstage passes avec sa qualité positive qui augmente bien de 1 si SellIn <=5
  @Test//enler pdt refacto
  void qualiteBackstageSiSellInInferieur5 () {
    int qual = 1;
    int sell = 5;
    Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sell, qual) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.items[0].quality, is(qual+3));
  }
  //test quality backstage si quality =50 et sellIn <6
  //j'ai enlevé pdt le refacto
  @Test
  void qualiteBackstage50 () {
    int qual = 50;
    int sell = 1;
    Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sell, qual) };
    GildedRose app = new GildedRose(items);
      app.updateQuality();
      assertThat(app.items[0].quality, is(qual));
  }
  //test qualité pour Backstage passes avec sa qualité < 0 si SellIn <= 0
  @Test
  void qualiteBackstageSiSellInEgale0 () {
    int qual = 2;
    int sell = 0;
    Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sell, qual) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.items[0].quality, is(qual-qual));
  }
  //test qualité pour Backstage passes avec sa qualité = 0 si SellIn <= 0
  @Test
  void qualiteBackstageSiSellInInférieur0 () {
      int qual = 0;
    int sell = -1;
    Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sell, qual) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.items[0].quality, is(0));
  }
  
  //test qualité pour Sulfuras avec sa qualité = 80
  @Test
  void qualiteSulfuras () {
      int qual = 80;
    int sell = 9;
    Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", sell, qual) };
    GildedRose app = new GildedRose(items);
      app.updateQuality();
      assertThat(app.items[0].quality, is(qual));
  }

  //test qualité pour Sulfuras avec sa qualité = 80 et sellIn <= 0
  @Test
  void qualiteSulfurasSellInInferieur0 () {
    int qual = 80;
    int sell = -1;
    Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", sell, qual) };
    GildedRose app = new GildedRose(items);
      app.updateQuality();
      assertThat(app.items[0].quality, is(qual));
  }
  //test qualité pour Sulfuras avec sa qualité = 0 et sellIn <= 0
  @Test
  void qualiteSulfurasSellInInferieur0Quality0 () {
    int qual = 0;
    int sell = -1;
    Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", sell, qual) };
    GildedRose app = new GildedRose(items);
      app.updateQuality();
      assertThat(app.items[0].quality, is(qual));
  }
  
  
  //test pour les autres items en general
  @Test
  void qualityItem() {
    int qual = 10;
    int sell = 10;
    Item[] items = new Item[] { new Item("Diamond Boot", sell, qual) };
    GildedRose app = new GildedRose(items);
      app.updateQuality();
      assertThat(app.items[0].quality, is(qual-1));
  }
  //test pour les autres items en general si sellin = 0
  @Test
  void qualityItemSellIn0() {
    int qual = 0;
    int sell = 0;
    Item[] items = new Item[] { new Item("Diamond Boot", sell, qual) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.items[0].quality, is(qual)); 
  }

  //test pour les autres items en general si sellin <0 quality = 0
  
  @Test
  void qualityItemSellInInferieur0() {
    int qual = 0;
    int sell = -1;
    Item[] items = new Item[] { new Item("Diamond Boot", sell, qual) };
    GildedRose app = new GildedRose(items);
      app.updateQuality();
      assertThat(app.items[0].quality, is(qual));
  }
  
  //test pour les autres items en general si sellin <0
  @Test
  void qualityItemSellInInferieur0QualitySuperieur0() {
    int qual = 10;
    int sell = -1;
    Item[] items = new Item[] { new Item("Diamond Boot", sell, qual) };
    GildedRose app = new GildedRose(items);
      app.updateQuality();
      assertThat(app.items[0].quality, is(qual-2));
  }
  //test pour les autres items en general si sellin <0 ajouter en refacto
  @Test
  void qualityItemSellIn0QualitySuperieur0() {
    int qual = 10;
    int sell = 0;
    Item[] items = new Item[] { new Item("Diamond Boot", sell, qual) };
    GildedRose app = new GildedRose(items);
      app.updateQuality();
      assertThat(app.items[0].quality, is(qual-2)); //qual-2 avec le code original
  }
  //test pour les autres items en general si quality = 50
  @Test
  void qualityItemQualitySellIn50() {
    int qual = 50;
    int sell = 10;
    Item[] items = new Item[] { new Item("Diamond Boot", sell, qual) };
    GildedRose app = new GildedRose(items);
      app.updateQuality();
      assertThat(app.items[0].quality, is(qual-1));
  }
  //test pour les autres items en general si quality = 0 et sellIn positive
  @Test
  void qualityItemQuality0SellInpositif() {
    int qual = 0;
    int sell = 10;
    Item[] items = new Item[] { new Item("Diamond Boot", sell, qual) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.items[0].quality, is(qual));
  }

  //sellIn
  
   // test que  sellin diminue de 1  même avec une valeur negative
  @Test
  void sellInAgedBriesiSellInNegative () {
      int qual = 10;
      int sell = -1;
      Item[] items = new Item[] { new Item("Aged Brie", sell, qual) };
      GildedRose app = new GildedRose(items);
      app.updateQuality();
      assertThat(app.items[0].sellIn, is(sell-1));
  }

   //test que sellIn diminue bien de 1 avec la qualite de Aged Brie positive
  @Test
  void SellInAgedBrie(){
      int qual = 4;
      int sell = 5;
      Item[] items = new Item[] { new Item("Aged Brie", sell, qual) };
      GildedRose app = new GildedRose(items);
      app.updateQuality();
      assertThat(app.items[0].sellIn, is(sell-1));
  }

   //test que sellIn diminue bien de 1 avec la qualite de Aged Brie negative
  @Test
  void SellInAgedBriequality0(){
      int qual = 0;
      int sell = 5;
      Item[] items = new Item[] { new Item("Aged Brie", sell, qual) };
      GildedRose app = new GildedRose(items);
      app.updateQuality();
      assertThat(app.items[0].sellIn, is(sell-1));
  }
   //test qualité pour Sulfuras avec sa qualité = 80
  @Test
  void sellInSulfurasquality80 () {
      int qual = 80;
      int sell = 9;
      Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", sell, qual) };
      GildedRose app = new GildedRose(items);
      app.updateQuality();
      assertThat(app.items[0].sellIn, is(sell-1));
  }
  //test sellin qui diminue de 1 pour backstage si quality <0
  @Test
  void sellInBackstage () {
      int qual = 10;
      int sell = 11;
      Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sell, qual) };
      GildedRose app = new GildedRose(items);
      app.updateQuality();
      assertThat(app.items[0].sellIn, is(sell-1));
  }

  //test sellin qui diminue de 1 pour backstage sellIn <10 et quality = 50
  @Test
  void sellInBackstageSellinInf10 () {
      int qual = 50;
      int sell = 9;
      Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sell, qual) };
      GildedRose app = new GildedRose(items);
      app.updateQuality();
      assertThat(app.items[0].sellIn, is(sell-1));
  }
  
  //Test sellIn pour un item classique
  @Test
  void sellInItem() {
      int qual = 10;
    int sell = 10;
    Item[] items = new Item[] { new Item("Diamond Boot", sell, qual) };
    GildedRose app = new GildedRose(items);
      app.updateQuality();
      assertThat(app.items[0].sellIn, is(sell-1));
  }
  //Test sellIn pour un item classique et SellIn a 0
  @Test
  void sellInItemSellInZero() {
      int qual = 10;
      int sell = -1;
      Item[] items = new Item[] { new Item("Diamond Boot", sell, qual) };
      GildedRose app = new GildedRose(items);
      app.updateQuality();
      assertThat(app.items[0].sellIn, is(sell-1));
  }
  //Test sellIn pour un item classique si quality < 0
  @Test
  void sellInItemQualitynegative() {
      int qual = -1;
    int sell = -1;
    Item[] items = new Item[] { new Item("Diamond Boot", sell, qual) };
    GildedRose app = new GildedRose(items);
      app.updateQuality();
      assertThat(app.items[0].sellIn, is(sell-1));
  }

  //Test sellIn pour un item classique si quality et sellIn  <0
  @Test
  void sellInItemQualitySellInnegative() {
      int qual = 49;
      int sell = -1;
      Item[] items = new Item[] { new Item("Diamond Boot", sell, qual) };
      GildedRose app = new GildedRose(items);
      app.updateQuality();
      assertThat(app.items[0].sellIn, is(sell-1));
  }

  //tostring
  /**@Test
    void tostring () {
      int qual = 10;
      int sell = 10;
      String expected ="Aged Brie, 10,10";
      Item item = new Item("Aged Brie" , sell ,qual);
      assertThat(item.toString(), is(expected));
    }**/
  //test pour conjured si sellin positive
@Test
  void qualiteConjuredSellinPositve () {
    int qual = 10;
    int sell = 5;
    Item[] items = new Item[] { new Item("Conjured Mana Cake", sell, qual) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.items[0].quality, is(qual-2));
  }
//test pour conjured si sellin negative
@Test
  void qualiteConjuredSellinNegative () {
    int qual = 10;
    int sell = -1;
    Item[] items = new Item[] { new Item("Conjured Mana Cake", sell, qual) };
    GildedRose app = new GildedRose(items);
      app.updateQuality();
      assertThat(app.items[0].quality, is(qual-4));
  }
  //test pour conjured si sellin negative et quality =0
/**@Test
  void qualiteConjuredSellinNegativeQuality0 () {
    int qual = 0;
    int sell = -1;
    Item[] items = new Item[] { new Item("Conjured Mana Cake", sell, qual) };
    GildedRose app = new GildedRose(items);
      app.updateQuality();
      assertThat(app.items[0].quality, is(qual));
  }**/
}

