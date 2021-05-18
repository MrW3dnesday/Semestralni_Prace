package base.classes;

import interfaces.IItem;

public class Item implements IItem {

    private String itemName;
    private String itemDescription;

    public Item(String itemName, String itemDescription){
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }

    protected Item(){

    }

    @Override
    public String OnInspect() {
        return itemDescription;
    }

    @Override
    public String OnUse() {
       String x=itemName+" není nijak pooužitelná nebo cená.";
       return x;
    }

    @Override
    public String GetItemName(){
        return  itemName;
    }


}
