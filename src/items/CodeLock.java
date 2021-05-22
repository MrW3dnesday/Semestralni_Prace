package items;

import base.classes.Item;
import data.structures.OnInteractionReturn;
import interfaces.IItem;

/*
 *  Třída CodeLock - Odděděná od třídy Item, implementuje IItem. Slouží k vytvoření zámku s kódem.
 *  Obsahuje @Override OnInteract,@OnItemPutInBackpack
 *
 *
 *
 *  @author     Dan Šebek
 *  @version    0.01a
 *  @created    květen 2021
 */
public class CodeLock extends Item implements IItem {
    public CodeLock(String itemName,String itemDescription){
        super(itemName,itemDescription,"codelock",false);
    }

    /**
     * Metoda vrátí text při interakci s předmětem @Override
     *
     *@return Vrací text při interakci s předmětem
     */
    @Override
    public OnInteractionReturn OnInteract(){
        OnInteractionReturn temp = new OnInteractionReturn(true,"Asi to po mě bude chtít kód." + "\n");
        return temp;
    }

    /**
     * Metoda vrátí text při pokus o vložení předmětu do batohu @Override
     *
     *@return Vrací text při pokus o vložení předmětu do batohu
     */
    @Override
    public String OnItemPutInBackpack() {
        return itemName + " to z té stěny nesundám.";
    }
}
