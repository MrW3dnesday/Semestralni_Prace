package com.company;

import base.classes.BasicRoom;
import base.classes.Item;
import data.structures.OnInteractionReturn;
import interfaces.IItem;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class Mimic extends Item implements IItem {

    public BasicRoom currentRoom;

    public Mimic(String mimicName, String mimicDescription, BasicRoom currentRoom){
        super(mimicName,mimicDescription,"mimic",false);
        this.currentRoom = currentRoom;
    }

    public void ChangeForm(){
        IItem[] possibleItems = GamePlan.generatedItems.values().toArray(new IItem[GamePlan.generatedItems.size()]);
        Random random = new Random();
        boolean validForm = false;
        IItem temp;
        while(!validForm){
            temp = possibleItems[random.nextInt(possibleItems.length)];
            if(!currentRoom.GetItemsInRoom().containsKey(temp.GetItemName())){
                this.itemName = temp.GetItemName();
                this.itemDescription = temp.GetItemDescription();
                validForm = true;
                break;
            }
        }
    }

    public void OnMove(){
        BasicRoom[] connectedRooms = currentRoom.GetConnectedRooms().values().toArray(new BasicRoom[currentRoom.GetConnectedRooms().size()]);
        Random random = new Random();
        BasicRoom newRoom = connectedRooms[random.nextInt(connectedRooms.length)];
        boolean hasMimic = false;
        IItem temp;
        if(newRoom.GetConnectedRooms().size() > 0) {
            for (String key : newRoom.GetItemsInRoom().keySet()) {
                temp = newRoom.GetItemsInRoom().get(key).get(0);
                if (temp.GetItemEngineName().equals("mimic")) {
                    hasMimic = true;
                }
            }
            currentRoom.OnItemRemove(this.itemName);
            currentRoom = newRoom;

            if(hasMimic){
                OnMove();
            }else{
                ChangeForm();
                currentRoom.AddItemInRoom(this);
            }
        }
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
    public OnInteractionReturn OnInteract(){
        OnInteractionReturn temp = new OnInteractionReturn(false,"Je to mimic. To bude bolet!");
        return temp;
    }

    @Override
    public String OnAttack(){
        GamePlan.mimics.remove(this);
        return "Tohle si zasloužila, teď už mě nebude otravovat...";
    }

}
