package com.company;

import interfaces.IItem;

public class Item implements IItem {

    private String itemName;
    private String itemDescription;


    @Override
    public String OnInspect() {
        return null;
    }

    @Override
    public String OnUse() {
        return null;
    }
}
