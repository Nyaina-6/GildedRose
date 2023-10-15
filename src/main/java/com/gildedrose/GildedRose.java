
package com.gildedrose;

/* Aina Lariol */

class GildedRose {
  
  private int quality = 0 ;
  Item[] items;

  public GildedRose(Item[] items) {
    
    this.items = items;
  }

  public int qualiteAugmentantDe1(int i){
      return items[i].quality += 1;
    
  }
  public int qualiteDiminuantDe1(int i){
      return items[i].quality -= 1;
    
  }

  public void updateQuality(){
    for (int i = 0; i < items.length; i++) {

        items[i].sellIn -= 1;
      
        //Switch permettant d'effectuer un premier tri en fonction du nom de l'objet -> Simplifie le code en cadrant les résultats
        switch (items[i].name) {
            case "Aged Brie":
                items[i].quality = Math.min(qualiteAugmentantDe1(i),50);
                break;

            case "Sulfuras, Hand of Ragnaros":
                items[i].quality = (items[i].quality == 0)? 0 : 80;
                break;

            case "Backstage passes to a TAFKAL80ETC concert":
                if (items[i].quality <50){
                    quality  = (items[i].sellIn <=0) ? 0 : (items[i].sellIn <5)? (items[i].quality+3) :(items[i].sellIn <10)?
                      (items[i].quality+2):(qualiteAugmentantDe1(i));
                    items[i].quality = Math.min(quality,50);
                }
                break;

            case "Conjured Mana Cake" :
              quality = (items[i].sellIn > 0)? items[i].quality-2 : items[i].quality-4;
              items[i].quality = Math.max(quality , 0);
              break;
            
            default :
              quality = (items[i].sellIn > 0)? qualiteDiminuantDe1(i) : items[i].quality-2;
              items[i].quality = Math.max(quality , 0);
        }
    }
  }
}
