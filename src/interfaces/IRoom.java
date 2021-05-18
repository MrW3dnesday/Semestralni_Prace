package interfaces;

import jdk.jshell.spi.ExecutionControl;

public interface IRoom {
    public String ShowItemsInRoom() throws ExecutionControl.NotImplementedException;
    public String ShowConnectedRooms();
}
