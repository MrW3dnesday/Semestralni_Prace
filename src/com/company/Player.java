package com.company;

import interfaces.IMovement;
import interfaces.IRoom;

public class Player implements IMovement {
    IRoom currentRoom;

    Backpack backpack;

    public Player(IRoom startRoom){
        this.currentRoom = startRoom;
    }

    @Override
    public String OnMove(IRoom nextRoom){
        if(nextRoom != null){
            this.currentRoom = nextRoom;
            return "Moved to next room" + "\n" + GetRoomInfo();
        }else {
            return "There is not room like that, choose some else room please, sorry...";
        }
    }
    @Override
    public IRoom GetCurrentRoom(){
        return  currentRoom;
    }

    private String GetRoomInfo(){
        return "Items in room: " + currentRoom.ShowItemsInRoom() + "\n" + "Connected rooms: " + currentRoom.ShowConnectedRooms();
    }


}
