package interfaces;

import jdk.jshell.spi.ExecutionControl;

import java.util.HashMap;
import java.util.LinkedList;

public interface IRoom {
    public String ShowItemsInRoom();
    public String ShowConnectedRooms();
    public HashMap<String,IRoom> GetConnectedRooms();
    public HashMap<String,IItem> GetItemsInRoom();
    public void AddConnectedRoom(IRoom newRoom);
    public void AddItemInRoom(IItem newItem);
    public String GetRoomName();
}
