package base.classes;

import com.company.GamePlan;
import interfaces.IItem;

import java.util.HashMap;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class BasicRoomTest {

    GamePlan gamePlan = new GamePlan();
    @org.junit.jupiter.api.Test
    void showItemsInRoom() {
        gamePlan.NUnitINIT();

        assertEquals("|Hrnek 1x| ",gamePlan.generatedRooms.get("entry").ShowItemsInRoom());

    }

    @org.junit.jupiter.api.Test
    void showConnectedRooms() {
        gamePlan.NUnitINIT();
        assertEquals("|Ošetřovna| ",gamePlan.generatedRooms.get("entry").ShowConnectedRooms());

    }

    @org.junit.jupiter.api.Test
    void getItemsInRoom() {

        LinkedList<IItem> list = new LinkedList<>();
        BasicRoom entry = new BasicRoom("Vstup", "Nic moc tu není...","entry");
        Item cup = new Item("Hrnek","Obyčejný hrníček, asi z keramiky.","cup",true);
        entry.AddItemInRoom(cup);
        list.add(cup);
        HashMap<String,LinkedList<IItem>> hah = new HashMap<>();


        hah.put(cup.GetItemName(), list);




        assertEquals(hah,entry.GetItemsInRoom());
    }

    @org.junit.jupiter.api.Test
    void addConnectedRoom() {
        gamePlan.NUnitINIT();
        assertEquals(2,gamePlan.generatedRooms.size());
    }

    @org.junit.jupiter.api.Test
    void addItemInRoom() {
        gamePlan.NUnitINIT();
        assertEquals(1,gamePlan.generatedRooms.get("entry").GetItemsInRoom().size());
    }

    @org.junit.jupiter.api.Test
    void getRoomName() {
        gamePlan.NUnitINIT();
        assertEquals("Vstup",gamePlan.generatedRooms.get("entry").GetRoomName());
    }

    @org.junit.jupiter.api.Test
    void onItemRemove() {
        gamePlan.NUnitINIT();
        gamePlan.generatedRooms.get("entry").OnItemRemove("Hrnek");
        assertEquals(0,gamePlan.generatedRooms.get("entry").GetItemsInRoom().size());
    }

    @org.junit.jupiter.api.Test
    void haveInteractableItem() {
        gamePlan.NUnitINIT();

        assertEquals('Y',gamePlan.generatedRooms.get("entry").HaveInteractableItem());
    }

    @org.junit.jupiter.api.Test
    void onPlayerEntry() {
        gamePlan.NUnitINIT();
        assertEquals("\n" + "Nic moc tu není...\n" + "Věci v místnosti: |Hrnek 1x| \n" + "Propojené místnosti: |Ošetřovna| ",gamePlan.generatedRooms.get("entry").OnPlayerEntry());
    }

    @org.junit.jupiter.api.Test
    void getItemFromRoom() {
        BasicRoom entry = new BasicRoom("Vstup", "Nic moc tu není...","entry");
        Item cup = new Item("Hrnek","Obyčejný hrníček, asi z keramiky.","cup",true);
        entry.AddItemInRoom(cup);
        assertEquals(cup,entry.GetItemFromRoom("Hrnek"));
    }

    @org.junit.jupiter.api.Test
    void onItemUse() {
        gamePlan.NUnitINIT();
        Item cup = new Item("Hrnek","Obyčejný hrníček, asi z keramiky.","cup",true);
        assertEquals("Hrnek se tu nedá použít, promiň...",gamePlan.generatedRooms.get("entry").OnItemUse(cup));
    }

    @org.junit.jupiter.api.Test
    void onItemInteract() {
        gamePlan.NUnitINIT();
        Item cup = new Item("Hrnek","Obyčejný hrníček, asi z keramiky.","cup",true);
        assertEquals("Hrnek s tím toho moc neudělám.",gamePlan.generatedRooms.get("entry").OnItemUse(cup));
    }

    @org.junit.jupiter.api.Test
    void getConnectedRoom() {
        gamePlan.NUnitINIT();
        assertEquals(gamePlan.generatedRooms.get("medical"),gamePlan.generatedRooms.get("entry").GetConnectedRoom("Ošetřovna"));
    }

    @org.junit.jupiter.api.Test
    void getConnectedRooms() {
        BasicRoom entry = new BasicRoom("Vstup", "Nic moc tu není...","entry");
        BasicRoom medical = new BasicRoom("Ošetřovna","Vypadá to tak, že tady asi někoho ošetřovali...","medical");

        entry.AddConnectedRoom(medical);
        HashMap<String,BasicRoom> testhash= new HashMap<>();
        testhash.put(medical.GetRoomName(),medical);
        assertEquals(testhash,entry.GetConnectedRooms());
    }

    @org.junit.jupiter.api.Test
    void showRoomInfo() {
        gamePlan.NUnitINIT();
        assertEquals("Nic moc tu není...\n" + "Věci v místnosti: |Hrnek 1x| \n" + "Propojené místnosti: |Ošetřovna| ",gamePlan.generatedRooms.get("entry").ShowRoomInfo());
    }
}