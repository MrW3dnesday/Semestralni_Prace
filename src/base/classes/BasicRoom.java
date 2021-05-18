package base.classes;

import interfaces.IItem;
import interfaces.IRoom;

import java.util.*;

public class BasicRoom implements IRoom {

    //declare
    protected String roomName;
    protected HashMap<String,IItem> itemsInRoom;
    protected HashMap<String,IRoom> connectedRooms;

    //default constructor
    public BasicRoom(){
        this.itemsInRoom = new HashMap<String, IItem>();
        this.connectedRooms = new HashMap<String, IRoom>();
    }

    public BasicRoom(String roomName){
        this.itemsInRoom = new HashMap<String, IItem>();
        this.connectedRooms = new HashMap<String, IRoom>();
        this.roomName = roomName;
    }
    //constructor for gameplan
    public BasicRoom(HashMap<String,IItem> generatedListOfItems,HashMap<String,IRoom> connectedRooms, String roomName){
        this.itemsInRoom = generatedListOfItems;
        this.connectedRooms = connectedRooms;
        this.roomName = roomName;
    }

    //Return in one string all of the items in the room
    @Override
    public String ShowItemsInRoom(){
        String temp = "";
        for(String key: this.itemsInRoom.keySet()){
            temp += key + " ";
        }
        return temp;
    }

    //Return in one string all of the connected rooms
    @Override
    public String ShowConnectedRooms(){
        String temp = "";
        for(String key: this.connectedRooms.keySet()){
            temp += key + " ";
        }
        return temp;
    }

    //return connectedRooms
    @Override
    public HashMap<String,IRoom> GetConnectedRooms(){
        return connectedRooms;
    }

    //return itemsInRoom
    @Override
    public  HashMap<String,IItem> GetItemsInRoom(){
        return  itemsInRoom;
    }

    //add room to connected rooms
    @Override
    public void AddConnectedRoom(IRoom room){
        connectedRooms.put(room.GetRoomName(),room);
    }

    //add item to items in Room
    @Override
    public void AddItemInRoom(IItem item) {
        itemsInRoom.put(item.GetItemName(),item);
    }
    public String GetRoomName(){
        return  roomName;
    }

}
