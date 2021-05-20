package base.classes;

import data.structures.OnInteractionReturn;
import interfaces.IItem;

public class Item implements IItem {

    protected String itemEngineName;
    protected String itemName;
    protected String itemDescription;
    protected boolean canBeInBackpack;

    public Item(String itemName, String itemDescription,String itemEngineName, boolean canBeInBackpack){
        this.itemName = itemName;
        this.itemEngineName = itemEngineName;
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
    public OnInteractionReturn OnUse() {
        OnInteractionReturn temp = new OnInteractionReturn(false,itemName + ". Tohle asi nemá žádné využití.");
        return temp;
    }

    @Override
    public OnInteractionReturn OnInteract(){
        OnInteractionReturn temp = new OnInteractionReturn(false, this.itemName + " s tím toho moc neudělám.");
        return temp;
    }

    @Override
    public String GetItemName(){
        return  itemName;
    }

    @Override
    public String GetItemEngineName(){
        return itemEngineName;
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
