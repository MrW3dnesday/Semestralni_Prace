package com.company;

import base.classes.BasicRoom;
import base.classes.Item;
import interfaces.IItem;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class Mimic extends Item implements IItem {

    public BasicRoom currentRoom;

    public Mimic(String mimicName, String mimicDescription, BasicRoom currentRoom){
        super(mimicName,mimicDescription,false);
        this.currentRoom = currentRoom;
    }

    public void ChangeForm(){
        HashMap<String, LinkedList<IItem>> itemsInRoom = currentRoom.GetItemsInRoom();
        for(String key:GamePlan.generatedItems.keySet()){
            if(!currentRoom.GetItemsInRoom().containsKey(key)){
                IItem temp = GamePlan.generatedItems.get(key);
                this.itemName = temp.GetItemName();
                this.itemDescription = temp.GetItemDescription();
                break;
            }
        }
    }

    public void OnMove(){
        BasicRoom[] connectedRooms = currentRoom.GetConnectedRooms().values().toArray(new BasicRoom[currentRoom.GetConnectedRooms().size()]);
        Random random = new Random();
        BasicRoom newRoom = connectedRooms[random.nextInt(connectedRooms.length)];
        currentRoom.OnItemRemove(this.itemName);
        currentRoom = newRoom;
        ChangeForm();
        currentRoom.AddItemInRoom(this);
    }
    @Override
    public String OnInspect(){

        return "Je to mimic. To bude bolet!" + GamePlan.GetPlayer().OnPlayerAttacked();
    }

    @Override
    public String OnItemPutInBackpack(){

        return "Je to mimic. Moc se jí tam nechce. To bude bolet!" +  GamePlan.GetPlayer().OnPlayerAttacked();
    }

    @Override
    public String OnAttack(){
        GamePlan.mimics.remove(this);
        return "Tohle si zasloužila, teď už mě nebude otravovat...";
    }

}
