package com.company;

import base.classes.BasicRoom;
import commands.CommandRestart;
import interfaces.IMovement;

public class Player implements IMovement {

    BasicRoom currentRoom;

    Backpack backpack;

    private boolean wasAttacked;

    public Player(BasicRoom startRoom){
        this.currentRoom = startRoom;
        this.backpack = new Backpack(5);
        wasAttacked = false;
    }

    public String OnMove(BasicRoom nextRoom){
        this.currentRoom = nextRoom;
        return currentRoom.OnPlayerEntry();
    }

    public BasicRoom GetCurrentRoom(){
        return  currentRoom;
    }

    public Backpack GetPlayerBackpack(){
        return backpack;
    }

    public String OnPlayerAttacked(){
        if(wasAttacked){
            CommandRestart restart = new CommandRestart();
            restart.Execute();
            return "Tak to je můj konec...";
        }else{
            wasAttacked=true;
            return "Tak tohle sakra bolí, měl bych najít lékárnu!";
        }
    }

    public void Heal(){
        wasAttacked = false;
    }
}
