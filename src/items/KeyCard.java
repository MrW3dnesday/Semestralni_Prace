package items;

import base.classes.Item;
import data.structures.OnInteractionReturn;
import interfaces.IItem;


/*
 *  Třída Keycard - Odděděná od třídy Item, implementuje IItem. Slouží k vytvoření karty
 *  Obsahuje @Override OnUse
 *
 *
 *
 *  @author     Dan Šebek
 *  @version    0.01a
 *  @created    květen 2021
 */
public class KeyCard extends Item implements IItem {
    public KeyCard(String itemName,String itemDescription){
       super(itemName,itemDescription,"keycard",true);
    }

    /**
     * Metoda vrátí text při použítí předmětu a zda interaguje s místností @Override
     *
     *@return Vrací text při použití předmětu a zda interaguje s místností batohu
     */
    @Override
    public OnInteractionReturn OnUse(){
        OnInteractionReturn temp = new OnInteractionReturn(true,"Tohle asi něco otevře.");
        return temp;
    }
}


