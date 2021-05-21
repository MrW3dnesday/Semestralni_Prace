package base.classes;

import interfaces.IItem;

import java.util.*;

/*
 *  Třída BasicRoom - Nadřazená třída všem místnostem. Slouží k vytvoření místostní bez rozšírené funkcionality.
 *  Obsahuje metody pro práci s předměty v místnosti, připojenými místnostmi a interakci s předměty.
 *
 *
 *
 *  @author     Dan Šebek
 *  @version    0.01a
 *  @created    květen 2021
 */
public class BasicRoom{

    //declare
    protected String roomName;
    protected String roomDescription;
    protected String roomEngineName;
    protected HashMap<String,LinkedList<IItem>>itemsInRoom;
    protected HashMap<String,BasicRoom> connectedRooms;

    //constructor
    public BasicRoom(String roomName, String roomDescription,String roomEngineName){
        this.itemsInRoom = new HashMap<>();
        this.connectedRooms = new HashMap<>();
        this.roomName = roomName;
        this.roomDescription = roomDescription;
        this.roomEngineName = roomEngineName;
    }

    /**
     * Metoda připraví text pro výpis předmětů v místnosti
     *
     *@return Vrací připravený text předmetů v místnosti
     */
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

    /**
     * Metoda připraví text pro výpis připojených místností
     *
     *@return Vrací připravený text připojených místností
     */
    public String ShowConnectedRooms(){
        String temp = "";
        for(String key: this.connectedRooms.keySet()){
            temp += "|" + key + "| ";
        }
        return temp;
    }

    /**
     * Metoda vrátí HashMap předmětů v místnosti
     *
     *@return Vrací HashMap předmětů v místnosti
     */
    public  HashMap<String,LinkedList<IItem>> GetItemsInRoom(){
        return  itemsInRoom;
    }

    /**
     * Metoda přidá připojenou místnost
     */
    public void AddConnectedRoom(BasicRoom room){
        connectedRooms.put(room.GetRoomName(),room);
    }

    /**
     * Metoda přidá předmět do místnosti
     */
    public void AddItemInRoom(IItem item) {
        //check if item type is already in room
        if(itemsInRoom.containsKey(item.GetItemName())){
            //add item
            itemsInRoom.get(item.GetItemName()).add(item);
        }else{
            //create item in room
            LinkedList<IItem> temp = new LinkedList<>();
            temp.add(item);
            itemsInRoom.put(item.GetItemName(),temp);
        }
    }

    /**
     * Metoda vrátí název místnoti
     *
     *@return Vrací název místnosti
     */
    public String GetRoomName(){
        return  roomName;
    }

    /**
     * Metoda vrátí název místnoti pro herní engine
     *
     *@return Vrací název místnosti pro herní engine
     */
    public String GetRoomEngineName(){
        return roomEngineName;
    }

    /**
     * Metoda odebere předmět z místnosti
     *
     *@return Odebraný předmět
     */
    public IItem OnItemRemove(String itemName){
        IItem removedItem;
        //check if items name is in room
        if(itemsInRoom.containsKey(itemName)){
            //there is only one instance of item
            if(itemsInRoom.get(itemName).size() == 1){
                //remove one item from list
                removedItem = itemsInRoom.get(itemName).get(itemsInRoom.get(itemName).size()-1);
                //remove item from room
                itemsInRoom.remove(itemName);
            //there are multiple instances of item
            }else{
                //remove one item from list
                removedItem = itemsInRoom.get(itemName).get(itemsInRoom.get(itemName).size() - 1);
                itemsInRoom.get(itemName).remove(removedItem);
            }
            return removedItem;
        }
        return null;
    }

    /**
     * Metoda zjistí zda jsou v místnoti předměty s který jde nějak interagovat
     *
     *@return Příznak zda v místnoti jsou předemty s který jde nějak interagovat
     */
    public char HaveInteractableItem(){
        if(itemsInRoom.size() == 0){
            return 'E';
        }
        return 'Y';
    }

    /**
     * Metoda připraví text informací o místnosti pro výpis
     *
     *@return Vrací připravený text
     */
    public String OnPlayerEntry(){
        return "\n" + ShowRoomInfo();
    }

    /**
     * Metoda vrátí předmět z místnosti
     *
     *@return Vrací předmět z místnosti pokud v ní je, jinak null
     */
    public IItem GetItemFromRoom(String itemName){
        if(itemsInRoom.containsKey(itemName)){
            return itemsInRoom.get(itemName).get(itemsInRoom.get(itemName).size()-1);
        }else{
            return null;
        }
    }

    /**
     * Metoda připraví text pro výpís při použití předmětu v místnosti
     *
     *@return Vrací připravený text
     */
    public String OnItemUse(IItem item){
        String temp = item.GetItemName() + " se tu nedá použít, promiň...";
        return temp;
    }

    /**
     * Metoda připraví text pro výpís při interakci s předmět v místnosti
     *
     *@return Vrací připravený text
     */
    public String OnItemInteract(IItem item){
        String temp = item.GetItemName() + " s tím toho moc neudělám.";
        return temp;
    }

    /**
     * Metoda vrací připojenou místnost
     *
     *@return Vratí připojenou místnost, nebo null
     */
    public BasicRoom GetConnectedRoom(String roomName){
        return connectedRooms.get(roomName);
    }

    /**
     * Metoda vrací HashMap připojených místnost
     *
     *@return Vratí HashMap připojených místností
     */
    public HashMap<String,BasicRoom> GetConnectedRooms(){
        return connectedRooms;
    }

    /**
     * Metoda připravý text informací o místnosti pro výpis
     *
     *@return Vrací připravený text
     */
    public String ShowRoomInfo(){
        return roomDescription + "\n" + "Věci v místnosti: " + ShowItemsInRoom() + "\n" + "Propojené místnosti: " + ShowConnectedRooms();
    }
}
