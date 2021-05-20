package base.classes;

import interfaces.IItem;

import java.util.*;

public class BasicRoom{

    //declare
    protected String roomName;
    protected String roomDescription;
    protected HashMap<String,LinkedList<IItem>>itemsInRoom;
    protected HashMap<String,BasicRoom> connectedRooms;

    //default constructor
    public BasicRoom(){
        this.itemsInRoom = new HashMap<String, LinkedList<IItem>>();
        this.connectedRooms = new HashMap<String,BasicRoom>();
    }

    //constructor for testing
    public BasicRoom(String roomName, String roomDescription){
        this.itemsInRoom = new HashMap<String, LinkedList<IItem>>();
        this.connectedRooms = new HashMap<String,BasicRoom>();
        this.roomName = roomName;
        this.roomDescription = roomDescription;
    }
    //constructor for game plan
    public BasicRoom(HashMap<String,IItem> generatedListOfItems,HashMap<String,BasicRoom> connectedRooms, String roomName,String roomDescription){
        this.itemsInRoom = new HashMap<String, LinkedList<IItem>>();
        this.connectedRooms = new HashMap<String,BasicRoom>();
        this.roomName = roomName;
        this.roomDescription = roomDescription;
    }

    //Return in one string all of the items in the room
    public String ShowItemsInRoom() {
        String temp = "";
        if (this.itemsInRoom.size() == 0) {
            temp = "!NONE!";
            return temp;
        } else {
            for (String key : this.itemsInRoom.keySet()) {
                temp += "|" + key + " " + itemsInRoom.get(key).size() +"x| ";
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

    //return itemsInRoom
    public  HashMap<String,LinkedList<IItem>> GetItemsInRoom(){
        return  itemsInRoom;
    }

    //add room to connected rooms
    public void AddConnectedRoom(BasicRoom room){
        connectedRooms.put(room.GetRoomName(),room);
    }

    //add item to items in Room
    public void AddItemInRoom(IItem item) {
        if(itemsInRoom.containsKey(item.GetItemName())){
            itemsInRoom.get(item.GetItemName()).add(item);
        }else{
            LinkedList<IItem> temp = new LinkedList<IItem>();
            temp.add(item);
            itemsInRoom.put(item.GetItemName(),temp);
        }
    }

    public String GetRoomName(){
        return  roomName;
    }

    public IItem OnItemRemove(String itemName){
        IItem removedItem;
        if(itemsInRoom.containsKey(itemName)){
            if(itemsInRoom.get(itemName).size() == 1){
                removedItem = itemsInRoom.get(itemName).get(itemsInRoom.get(itemName).size()-1);
                itemsInRoom.remove(itemName);
            }else{
                removedItem = itemsInRoom.get(itemName).get(itemsInRoom.get(itemName).size() - 1);
                itemsInRoom.remove(itemName);
            }
            return removedItem;
        }
        return null;
    }

    public char HaveInteractableItem(){
        if(itemsInRoom.size() == 0){
            return 'E';
        }
        return 'Y';
    }

    public String OnPlayerEntry(){
        return "\n" + ShowRoomInfo();
    }

    public IItem GetItemFromRoom(String itemName){
        if(itemsInRoom.containsKey(itemName)){
            return itemsInRoom.get(itemName).get(itemsInRoom.get(itemName).size()-1);
        }else{
            return null;
        }
    }

    public String OnItemUse(IItem item){
        String temp = item.GetItemName() + " se tu nedá použít, promiň...";
        return temp;
    }

    public String OnItemInteract(IItem item){
        String temp = item.GetItemName() + " s tím toho moc neudělám.";
        return temp;
    }


    public BasicRoom GetConnectedRoom(String roomName){
        return connectedRooms.get(roomName);
    }

    public HashMap<String,BasicRoom> GetConnectedRooms(){
        return connectedRooms;
    }

    public String ShowRoomInfo(){
        return roomDescription + "\n" + "Věci v místnosti: " + ShowItemsInRoom() + "\n" + "Propojené místnosti: " + ShowConnectedRooms();
    }
}
