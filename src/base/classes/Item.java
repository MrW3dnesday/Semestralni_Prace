package base.classes;

import data.structures.OnUseReturn;
import interfaces.IItem;

public class Item implements IItem {

    protected String itemName;
    protected String itemDescription;
    protected boolean canBeInBackpack;

    public Item(String itemName, String itemDescription, boolean canBeInBackpack){
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.canBeInBackpack = canBeInBackpack;
    }

    protected Item(){

    }

    @Override
    public String OnInspect() {
        String temp = itemDescription;
        return itemDescription;
    }

    @Override
    public OnUseReturn OnUse() {
        OnUseReturn temp = new OnUseReturn(true,itemName + ". Tohle asi nemá žádné využití.");
        return temp;
    }

    @Override
    public String GetItemName(){
        return  itemName;
    }

    @Override
    public String GetItemDescription(){
        return itemDescription;
    }
    @Override
    public String OnItemPutInBackpack() {
        return itemName + " jsi vložil do batohu.";
    }

    @Override
    public String OnItemTakeOutBackpack(){
        return itemName +  " jsi vyndal z batohu";
    }

    @Override
    public String OnAttack(){
        return  itemName + " jsi rozmlátil na prach";
    }

    @Override
    public boolean CanBeInBackpack(){
        return canBeInBackpack;
    }

}
