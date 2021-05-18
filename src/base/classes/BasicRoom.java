package base.classes;

import interfaces.IItem;

import java.util.*;

public class BasicRoom{

    //declare
    protected String roomName;
    protected HashMap<String,IItem> itemsInRoom;
    protected HashMap<String,BasicRoom> connectedRooms;

    //default constructor
    public BasicRoom(){
        this.itemsInRoom = new HashMap<String, IItem>();
        this.connectedRooms = new HashMap<String,BasicRoom>();
    }

    //constructor for testing
    public BasicRoom(String roomName){
        this.itemsInRoom = new HashMap<String, IItem>();
        this.connectedRooms = new HashMap<String,BasicRoom>();
        this.roomName = roomName;
    }
    //constructor for game plan
    public BasicRoom(HashMap<String,IItem> generatedListOfItems,HashMap<String,BasicRoom> connectedRooms, String roomName){
        this.itemsInRoom = generatedListOfItems;
        this.connectedRooms = new HashMap<String,BasicRoom>();
        this.roomName = roomName;
    }

    //Return in one string all of the items in the room
    public String ShowItemsInRoom() {
        String temp = "";
        if (this.itemsInRoom.size() == 0) {
            temp = "|NONE|";
            return temp;
        } else {
            for (String key : this.itemsInRoom.keySet()) {
                temp += key + " ";
            }
            return temp;
        }
    }

    //Return in one string all of the connected rooms
    public String ShowConnectedRooms(){
        String temp = "";
        for(String key: this.connectedRooms.keySet()){
            temp += key + " ";
        }
        return temp;
    }

    //return connectedRooms
    /*public HashMap<String,BasicRoom> GetConnectedRooms(){
        return connectedRooms;
    }*/

    //return itemsInRoom
    public  HashMap<String,IItem> GetItemsInRoom(){
        return  itemsInRoom;
    }

    //add room to connected rooms
    public void AddConnectedRoom(BasicRoom room){
        connectedRooms.put(room.GetRoomName(),room);
    }

    //add item to items in Room
    public void AddItemInRoom(IItem item) {
        itemsInRoom.put(item.GetItemName(),item);
    }

    public String GetRoomName(){
        return  roomName;
    }

    public IItem OnItemRemove(String itemName){
        IItem removedItem = itemsInRoom.remove(itemName);
        return removedItem;
    }

    public void OnItemAdd(IItem item){
        itemsInRoom.put(item.GetItemName(),item);
    }

    public IItem GetItemFromRoom(String itemName){
        return itemsInRoom.get(itemName);
    }

    public BasicRoom GetConnectedRoom(String roomName){
        return connectedRooms.get(roomName);
    }

    public String ShowRoomInfo(){
        return "Items in room: " + ShowItemsInRoom() + "\n" + "Connected rooms: " + ShowConnectedRooms() + "\n";
    }
}
