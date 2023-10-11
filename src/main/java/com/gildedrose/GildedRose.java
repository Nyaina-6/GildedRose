
package com.gildedrose;

class GildedRose {
  static final String AGED_BRIE = "Aged Brie";
  static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
  static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";

  static final int QUALITY_MAX = 50;
  static final int BACKSTAGE_SELLIN_LIMIT2 = 11;
  static final int BACKSTAGE_SELLIN_LIMIT3 = 6;
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
  public void sulfurasQuality(int i){
		  items[i].quality = (items[i].quality == 0)? 0 : items[i].quality;
	}
  public void backstageQuality(int i){
    if (items[i].quality <50){
        quality  = (items[i].sellIn <=0) ? 0 : (items[i].sellIn <6)? items[i].quality+3 :(items[i].sellIn <11)? items[i].quality+2:
        items[i].quality+1 ;
        //items[i].quality = (items[i].quality ==6)? items[i].quality+2 : items[i].quality+1;
        

        items[i].quality = Math.min(quality,50);
  }
}
  public void defaultObjectQuality(int i){
		
    if (items[i].sellIn >0){
      items[i].quality = Math.max(items[i].quality-1 , 0);
    }
    
    if(items[i].sellIn<=0) 
        {
            items[i].quality = (items[i].quality >0)? items[i].quality-2 : 0;
        }
    
	}
  public void ConjuredQuality(int i){
    if (items[i].sellIn >0){
      items[i].quality = Math.max(items[i].quality-2 , 0);
    }
    
    if(items[i].sellIn<=0) 
        {
            items[i].quality = (items[i].quality >0)? items[i].quality-4 : 0;
        }
    
	}
  }
  public void updateQuality(){
    for (int i = 0; i < items.length; i++) {
      if (!items[i].name.equals(SULFURAS)){
        items[i].sellIn -= 1;
      }
        //Switch permettant d'effectuer un premier tri en fonction du nom de l'objet -> Simplifie le code en cadrant les résultats
        switch (items[i].name) {
            case "Aged Brie":
                agedBrieQuality(i);
                break;

            //On note ce cas même si on effectue aucunes actions pour éviter le case default
            case "Sulfuras, Hand of Ragnaros":
              sulfurasQuality(i);
                break;

            case "Backstage passes to a TAFKAL80ETC concert":
              backstageQuality(i);
                break;

            //Ce cas permettra de gérer tous les objets 'classiques' qui ne sont pas pris en compte dans les cas précédents
            default :
                defaultObjectQuality(i);
        }
    }
  }
}
