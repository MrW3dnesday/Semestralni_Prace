package com.company;

import base.classes.BasicRoom;
import base.classes.Item;
import commands.CommandMove;
import interfaces.ICommand;
import interfaces.IRoom;
import interfaces.IItem;

import java.util.HashMap;
import java.util.Scanner;

public class GamePlan {

    Scanner scanner;

    HashMap<String,IItem> generatedItems;
    HashMap<String,IRoom> generatedRooms;
    HashMap<String,ICommand> commands;

    Player player;

    public GamePlan(Scanner scanner){
        this.scanner = scanner;

        generatedItems = new HashMap<String,IItem>();
        generatedRooms = new HashMap<String,IRoom>();
        commands = new HashMap<String,ICommand>();
    }

    public void Init(){

    }
    public void TestInit(){
        Item item1 = new Item("item1","item1 dsc");
        Item item2 = new Item("item2", "item2 dsc");

        BasicRoom room1 = new BasicRoom("room1");
        BasicRoom room2 = new BasicRoom("room2");

        room1.AddItemInRoom(item1);
        room1.AddConnectedRoom(room2);

        room2.AddItemInRoom(item2);
        room2.AddConnectedRoom(room1);

        InitCommands();

        player = new Player(room1);

        Play();
    }



    private void Play(){
        boolean run = true;
        while(run){
            System.out.print("Zadej příkaz: ");
            String command = scanner.nextLine();


            if(command.equals("TERMINATE")){
                run = false;
            }
            commands.get(command).Execute(player,scanner);
        }
    }

    private void InitCommands(){
        CommandMove commandMove = new CommandMove("MOVE","Use this to move between rooms.");

        commands.put(commandMove.GetCommandName(),commandMove);
    }

}
