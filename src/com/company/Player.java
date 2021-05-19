package com.company;

import base.classes.BasicRoom;
import interfaces.IMovement;

public class Player implements IMovement {
    BasicRoom currentRoom;

    Backpack backpack;

    public Player(BasicRoom startRoom){
        this.currentRoom = startRoom;
        this.backpack = new Backpack(5);
    }

    public void OnMove(BasicRoom nextRoom){
        this.currentRoom = nextRoom;
    }

    public BasicRoom GetCurrentRoom(){
        return  currentRoom;
    }

    public Backpack GetPlayerBackpack(){
        return backpack;
    }

    private String GetRoomInfo(){
        return "Items in room: " + currentRoom.ShowItemsInRoom() + "\n" + "Connected rooms: " + currentRoom.ShowConnectedRooms();
    }


}
