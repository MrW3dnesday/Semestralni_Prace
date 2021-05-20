package items;

import base.classes.Item;
import data.structures.OnInteractionReturn;
import interfaces.IItem;

public class KeyCard extends Item implements IItem {
    public KeyCard(String itemName,String itemDescription){
       super(itemName,itemDescription,"keycard",true);
    }

    @Override
    public OnInteractionReturn OnUse(){
        OnInteractionReturn temp = new OnInteractionReturn(true,"Tohle asi něco otevře.");
        return temp;
    }
}


