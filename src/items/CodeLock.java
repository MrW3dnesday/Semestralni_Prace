package items;

import base.classes.Item;
import data.structures.OnInteractionReturn;
import interfaces.IItem;

public class CodeLock extends Item implements IItem {
    public CodeLock(String itemName,String itemDescription){
        super(itemName,itemDescription,"codelock",false);
    }

    @Override
    public OnInteractionReturn OnInteract(){
        OnInteractionReturn temp = new OnInteractionReturn(true,"Asi to po mě bude chtít kód." + "\n");
        return temp;
    }

    @Override
    public String OnItemPutInBackpack() {
        return itemName + " to z té stěny nesundám.";
    }
}
