package com.company;

import base.classes.BasicRoom;
import commands.CommandRestart;

/*
 *  Třída Player - Slouží k vytvoření hráče.
 *  Obsahuje metody pro pohyb a ošetření hráče.
 *
 *
 *
 *  @author     Dan Šebek
 *  @version    0.01a
 *  @created    květen 2021
 */
public class Player {

    BasicRoom currentRoom;

    Backpack backpack;

    private boolean wasAttacked;

    public Player(BasicRoom startRoom){
        this.currentRoom = startRoom;
        this.backpack = new Backpack(5);
        wasAttacked = false;
    }

    /**
     * Metoda zajišťuje přechod hráče do další místnosti
     *
     * @return Připravený text při vstupu do místnosti
     */
    public String OnMove(BasicRoom nextRoom){
        this.currentRoom = nextRoom;
        return currentRoom.OnPlayerEntry();
    }

    /**
     * Metoda vrátí místnost ve které se hráč nachází
     *
     * @return Vrací Místnost ve které se náchází hráč
     */
    public BasicRoom GetCurrentRoom(){
        return  currentRoom;
    }

    /**
     * Metoda vrátí batoh hráče
     *
     * @return Vrací batoh hráče
     */
    public Backpack GetPlayerBackpack(){
        return backpack;
    }

    public String OnPlayerAttacked(){
        if(wasAttacked){
            CommandRestart restart = new CommandRestart();
            restart.Execute();
            return "\nTak to je můj konec...\n";
        }else{
            wasAttacked=true;
            return "\nTak tohle sakra bolí, měl bych najít lékárnu!";
        }
    }

    /**
     * Metoda nastaví příznak zda bylo na hráče zaútočeno na false
     */
    public void Heal(){
        wasAttacked = false;
    }

    /**
     * Metoda vrátí příznak zda bylo na hráče zaútočeno
     * Pouze pro NUnit testy
     *
     * @return Vrací příznak zda bylo zaútočeno na hráče
     */
    public boolean GetWasAttacked(){
        return wasAttacked;
    }
}
