package com.company;

import interfaces.IItem;
import interfaces.IRoom;

import java.util.*;

public class BasicRoom implements IRoom {
    protected LinkedList<IItem> itemsInRoom;
    protected boolean playerInside;


    protected BasicRoom(){
        this.itemsInRoom = new LinkedList<IItem>();
    }

    public BasicRoom(LinkedList<IItem> generatedListOfItems){
        this.itemsInRoom = generatedListOfItems;
    }

    public String ShowItemsInRoom(){
        return "NOT IMPLEMENTED";
    }

    public String ShowConnectedRooms(){
        return "NOT IMPLEMENTED";
    }
}
