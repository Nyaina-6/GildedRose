
package com.gildedrose;

/* Aina Lariol */

class GildedRose {
  static final String AGED_BRIE = "Aged Brie";
  static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
  static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
  static final String CONJURED ="Conjured Mana Cake";

  static final int QUALITY_MAX = 50;
  private int quality = 0 ;
  Item[] items;

  public GildedRose(Item[] items) {
    
    this.items = items;
  }

  public void qualiteAugmentantDe1( int i){
    if (items[i].quality < QUALITY_MAX ) {
        items[i].quality += 1 ;
    }
  }
  public void agedBrieQuality(int i){
    if (items[i].quality == QUALITY_MAX){
        items[i].quality = QUALITY_MAX ;
    }
        qualiteAugmentantDe1(i);
    
    }
  
  public void updateQuality(){
    for (int i = 0; i < items.length; i++) {

        items[i].sellIn -= 1;
      
        //Switch permettant d'effectuer un premier tri en fonction du nom de l'objet -> Simplifie le code en cadrant les résultats
        switch (items[i].name) {
            case "Aged Brie":
                agedBrieQuality(i);
                break;

            case "Sulfuras, Hand of Ragnaros":
                items[i].quality = (items[i].quality == 0)? 0 : items[i].quality;
                break;

            case "Backstage passes to a TAFKAL80ETC concert":
                if (items[i].quality <50){
                    quality  = (items[i].sellIn <=0) ? 0 : (items[i].sellIn <5)? (items[i].quality+3) :(items[i].sellIn <10)?
                      (items[i].quality+2):(items[i].quality+1);
                    items[i].quality = Math.min(quality,50);
    }
                break;

            case "Conjured Mana Cake" :
              quality = (items[i].sellIn > 0)? items[i].quality-2 : items[i].quality-4;
              items[i].quality = Math.max(quality , 0);
              break;
            //Ce cas permettra de gérer tous les objets 'classiques' qui ne sont pas pris en compte dans les cas précédents
            default :
            items[i].quality = Math.max(items[i].quality-1 , 0);
            if(items[i].sellIn<=0)
                {
                    items[i].quality = (items[i].quality >0)? items[i].quality-1 : 0;
                }
        }
    }
  }
}
