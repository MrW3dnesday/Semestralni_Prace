package com.company;

import base.classes.BasicRoom;
import base.classes.Item;
import data.structures.OnInteractionReturn;
import interfaces.IItem;

import java.util.Random;

/*
 *  Třída Mimic - Slouží k vytvoření mimic které se samovolně pohybuji po mapě a berou na sebe podobu předmětů. Odděděná od Item. Implementuje IItem.
 *  Obsahuje metody pro pohyb a změnu formy a @Override pro některé metody od třídy Item.
 *
 *
 *
 *  @author     Dan Šebek
 *  @version    0.01a
 *  @created    květen 2021
 */
public class Mimic extends Item implements IItem {

    public BasicRoom currentRoom;

    public Mimic(String mimicName, String mimicDescription, BasicRoom currentRoom){
        super(mimicName,mimicDescription,"mimic",false);
        this.currentRoom = currentRoom;
    }

    /**
     * Metoda zajišťuje změnu formu mimic
     */
    private void ChangeForm(){
        //Possible problem
        //If there is only one room left without mimic and it has all item types inside this will end into never ending loop
        //Possible solution
        //Change form to standard mimic form
        IItem[] possibleItems = GamePlan.generatedItems.values().toArray(new IItem[GamePlan.generatedItems.size()]);
        Random random = new Random();
        boolean validForm = false;
        IItem temp;

        for(int i = 0;i<possibleItems.length;i++){
            //Get random item from array
            temp = possibleItems[random.nextInt(possibleItems.length)];
            //check if the item is in room
            if(!currentRoom.GetItemsInRoom().containsKey(temp.GetItemName())){
                //set mimic form
                this.itemName = temp.GetItemName();
                this.itemDescription = temp.GetItemDescription();
                validForm = true;
                break;
            }
        }
        //if there is not possible form form mimic, move to next room
        if(!validForm){
            OnMove();
        }
        //Obsolete Solution
        /*while(!validForm){
            temp = possibleItems[random.nextInt(possibleItems.length)];
            if(!currentRoom.GetItemsInRoom().containsKey(temp.GetItemName())){
                this.itemName = temp.GetItemName();
                this.itemDescription = temp.GetItemDescription();
                validForm = true;
                break;
            }
        }*/
    }

    /**
     * Metoda zajišťuje přesun Mimic do další místnosti a změnu jeji formy na předmět který v místnosti jěště není
     */
    public void OnMove(){
        //Possible problem
        //If there is none room left without mimic this will end in never ending loop
        //Possible Solution
        //Let there me more mimics in one room. Possibly less more interaction with mimics.

        //get array of rooms that mimic can move too
        BasicRoom[] connectedRooms = currentRoom.GetConnectedRooms().values().toArray(new BasicRoom[currentRoom.GetConnectedRooms().size()]);
        Random random = new Random();
        //get random room from array
        BasicRoom newRoom = connectedRooms[random.nextInt(connectedRooms.length)];


        boolean hasMimic = false;

        IItem temp;

        //check if mimic current room has connected rooms
        if(newRoom.GetConnectedRooms().size() > 0) {
            //check if connected room has mimic inside
            for (String key : newRoom.GetItemsInRoom().keySet()) {
                temp = newRoom.GetItemsInRoom().get(key).get(0);
                if (temp.GetItemEngineName().equals("mimic")) {
                    hasMimic = true;
                }
            }

            //move mimic to next room
            currentRoom.OnItemRemove(this.itemName);
            currentRoom = newRoom;
            ChangeForm();
            currentRoom.AddItemInRoom(this);

            //if the room has mimic inside, move mimic to next room
            if(hasMimic){
                OnMove();
            }
        }
    }

    /**
     * Metoda vrátí popis předmětu a zaútočí na hráče@Override
     *
     *@return Vrací popis předmětu
     */
    @Override
    public String OnInspect(){

        return "Je to mimic. To bude bolet!" + GamePlan.GetPlayer().OnPlayerAttacked();
    }

    /**
     * Metoda vrátí text při vložení do batohu, a zaútočí na hráče @Override
     *
     *@return Vrací popis předmětu
     */
    @Override
    public String OnItemPutInBackpack(){

        return "Je to mimic. Moc se jí tam nechce. To bude bolet!" +  GamePlan.GetPlayer().OnPlayerAttacked();
    }

    /**
     * Metoda vrátí text při interakci, a zaútočí na hráče @Override
     *
     *@return Vratí text při interakci
     */
    @Override
    public OnInteractionReturn OnInteract(){
        OnInteractionReturn temp = new OnInteractionReturn(false,"Je to mimic. To bude bolet!" + GamePlan.GetPlayer().OnPlayerAttacked());
        return temp;
    }

    /**
     * Metoda vrátí text při útoku @Override
     *
     *@return Vratí text při útoku
     */
    @Override
    public String OnAttack(){
        GamePlan.mimics.remove(this);
        return "Tohle si zasloužila, teď už mě nebude otravovat...";
    }

}
