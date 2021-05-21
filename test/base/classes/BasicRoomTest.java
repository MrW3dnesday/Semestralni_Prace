package base.classes;

import static org.junit.jupiter.api.Assertions.*;

class BasicRoomTest {

    @org.junit.jupiter.api.Test
    void showItemsInRoom() {
        Item cup = new Item("Hrnek","Obyčejný hrníček, asi z keramiky.","cup",true);
        BasicRoom entry = new BasicRoom("Vstup", "Nic moc tu není...");
        entry.AddItemInRoom(cup);

        assertEquals("|Hrnek 1x| ",entry.ShowItemsInRoom());


    }

    @org.junit.jupiter.api.Test
    void showConnectedRooms() {
    }

    @org.junit.jupiter.api.Test
    void getItemsInRoom() {
    }

    @org.junit.jupiter.api.Test
    void addConnectedRoom() {
    }

    @org.junit.jupiter.api.Test
    void addItemInRoom() {
    }

    @org.junit.jupiter.api.Test
    void getRoomName() {
    }

    @org.junit.jupiter.api.Test
    void onItemRemove() {
    }

    @org.junit.jupiter.api.Test
    void haveInteractableItem() {
    }

    @org.junit.jupiter.api.Test
    void onPlayerEntry() {
    }

    @org.junit.jupiter.api.Test
    void getItemFromRoom() {
    }

    @org.junit.jupiter.api.Test
    void onItemUse() {
    }

    @org.junit.jupiter.api.Test
    void onItemInteract() {
    }

    @org.junit.jupiter.api.Test
    void getConnectedRoom() {
    }

    @org.junit.jupiter.api.Test
    void getConnectedRooms() {
    }

    @org.junit.jupiter.api.Test
    void showRoomInfo() {
    }
}