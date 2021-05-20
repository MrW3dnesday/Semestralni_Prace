package items;

import base.classes.Item;
import interfaces.IItem;

public class KeyCard extends Item implements IItem {
    public KeyCard(String itemName,String itemDescription){
       super(itemName,itemDescription,"keycard",true);
    }
}
