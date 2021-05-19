package com.company;

import base.classes.BasicRoom;
import base.classes.Item;
import commands.*;
import interfaces.ICommand;
import interfaces.IItem;
import items.Crowbar;
import items.Medkit;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

public class GamePlan {

    Scanner scanner;

    public static HashMap<String,IItem> generatedItems;
    HashMap<String,BasicRoom> generatedRooms;
    public static HashMap<String,ICommand> commands;
    public static LinkedList<Mimic> mimics;
    public static boolean run;
    public static boolean restart;
    public static boolean testRun;

    static Player player;

    public GamePlan(Scanner scanner){
        this.scanner = scanner;

        generatedItems = new HashMap<String,IItem>();
        generatedRooms = new HashMap<String,BasicRoom>();
        commands = new HashMap<String,ICommand>();
        mimics = new LinkedList<Mimic>();

    }

    public void Init(){

    }
    public void TestInit(){
        Item item1 = new Item("item1","item1 dsc",true);
        Item item2 = new Item("item2", "item2 dsc", true);
        Item item3 = new Item("item3","item3 dsc", true);

        Crowbar crowbar = new Crowbar("Crowbar", "Looks like it can smash a lot things.");

        Medkit medkit = new Medkit("Medkit","I think, this might save my life.");

        BasicRoom room1 = new BasicRoom("room1");
        BasicRoom room2 = new BasicRoom("room2");

        room1.AddItemInRoom(item1);
        room1.AddItemInRoom(item1);
        room1.AddItemInRoom(item2);
        room1.AddConnectedRoom(room2);
        room1.AddItemInRoom(crowbar);

        room2.AddItemInRoom(item2);
        room2.AddConnectedRoom(room1);
        room2.AddItemInRoom(medkit);

        generatedItems.put(item1.GetItemName(),item1);
        generatedItems.put(item2.GetItemName(),item2);
        generatedItems.put(item3.GetItemName(),item3);

        Mimic mimic1 = new Mimic("MIMIC","MIMIC",room2);
        mimic1.OnMove();

        mimics.add(mimic1);


        InitCommands();

        player = new Player(room1);

        run = true;
        restart = false;
        testRun = true;

        Play();
    }



    private void Play(){

        System.out.print(GetUserHelp());
        System.out.print(GetPlayer().currentRoom.OnPlayerEntry());
        while(run){
            System.out.print("\nZadej příkaz: ");
            String txtCommand = UserInput.ReadUserInput();

            txtCommand = txtCommand.toUpperCase(Locale.ROOT);

            //commands.get(command).Execute();
            ICommand command = commands.get(txtCommand);
            if(command != null){
                command.Execute();
            }else{
                System.out.print("Takový příkaz tu není, promiň...");
            }
        }
        if(restart){
            TestInit();
        }
    }

    private void InitCommands(){
        CommandHelp commandHelp = new CommandHelp("HELP","Show all commands");
        CommandMove commandMove = new CommandMove("MOVE","Move to other room.");
        CommandTerminateGame commandTerminateGame = new CommandTerminateGame("TERMINATE","Terminates the game.");
        CommandPutInBackpack commandPutInBackpack = new CommandPutInBackpack("PUT IN","Put item from room to backpack.");
        CommandTakeOutBackpack commandTakeOutBackpack = new CommandTakeOutBackpack("TAKE OUT","Take out item from backpack.");
        CommandLookAround commandLookAround = new CommandLookAround("LOOK AROUND","Get info about room you are inside.");
        CommandInspect commandInspect = new CommandInspect("INSPECT","Inspect item in room or backpack.");
        CommandUse commandUse = new CommandUse("USE","Use item, or use it to interact with with the item in something room.");
        CommandInventory commandInventory = new CommandInventory("INV","Show content of your backpack");
        CommandRestart commandRestart = new CommandRestart("RESTART","Restart game.");

        commands.put(commandHelp.GetCommandName(),commandHelp);
        commands.put(commandLookAround.GetCommandName(),commandLookAround);
        commands.put(commandMove.GetCommandName(),commandMove);
        commands.put(commandTerminateGame.GetCommandName(),commandTerminateGame);
        commands.put(commandPutInBackpack.GetCommandName(),commandPutInBackpack);
        commands.put(commandTakeOutBackpack.GetCommandName(),commandTakeOutBackpack);
        commands.put(commandInspect.GetCommandName(),commandInspect);
        commands.put(commandUse.GetCommandName(),commandUse);
        commands.put(commandInventory.GetCommandName(),commandInventory);
        commands.put(commandRestart.GetCommandName(),commandRestart);
    }

    public static String GetUserHelp(){
        String temp = "";
        temp += "=====================================\n";
        for(String key: commands.keySet()){
            ICommand command = commands.get(key);
            temp += command.GetCommandName() + " - " + command.GetCommandDescription() + "\n";
        }
        temp = temp.substring(0,temp.length()-1);
        temp += "\n=====================================";
        return temp;
    }

    public static Player GetPlayer(){
        return player;
    }

    public static void MoveMimics(){
        for(Mimic mimic:mimics){
            mimic.OnMove();
        }
    }
}
