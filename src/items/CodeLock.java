package items;

import base.classes.Item;
import interfaces.IItem;

public class CodeLock extends Item implements IItem {
    public CodeLock(String itemName,String itemDescription){
        super(itemName,itemDescription,"codelock",false);
    }
}
