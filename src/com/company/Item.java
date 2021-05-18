package com.company;

import interfaces.IItem;

public class Item implements IItem {

    private String itemName;
    private String itemDescription;



    @Override
    public String OnInspect() {
        return itemDescription;
    }

    @Override
    public String OnUse() {
       String x=itemName+"není nijak pooužitelná nebo cená.";
       return x;
    }
}
