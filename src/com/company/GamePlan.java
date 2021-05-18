package com.company;

import base.classes.BasicRoom;
import base.classes.Item;
import commands.*;
import interfaces.ICommand;
import interfaces.IItem;

import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class GamePlan {

    Scanner scanner;

    HashMap<String,IItem> generatedItems;
    HashMap<String,BasicRoom> generatedRooms;
    static HashMap<String,ICommand> commands;

    static Player player;

    public GamePlan(Scanner scanner){
        this.scanner = scanner;

        generatedItems = new HashMap<String,IItem>();
        generatedRooms = new HashMap<String,BasicRoom>();
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
        System.out.print(GetUserHelp());
        while(run){
            System.out.print("Zadej příkaz: ");
            String txtCommand = UserInput.ReadUserInput();

            txtCommand = txtCommand.toUpperCase(Locale.ROOT);

            if(txtCommand.equals("TERMINATE")){
                run = false;
            }
            //commands.get(command).Execute();
            ICommand command = commands.get(txtCommand);
            if(command != null){
                command.Execute();
            }else{
                System.out.print("Takový příkaz tu není, promiň..." + "\n");
            }
        }
    }

    private void InitCommands(){
        CommandHelp commandHelp = new CommandHelp("HELP","Show all commands");
        CommandMove commandMove = new CommandMove("MOVE","Move to other room.");
        CommandTerminateGame commandTerminateGame = new CommandTerminateGame("TERMINATE","Terminates the game.");
        CommandPutInBackpack commandPutInBackpack = new CommandPutInBackpack("PUT IN","Put item from room to backpack.");
        CommandTakeOutBackpack commandTakeOutBackpack = new CommandTakeOutBackpack("TAKE OUT","Take out item from backpack");
        CommandLookAround commandLookAround = new CommandLookAround("LOOK AROUND","Get info about room you are inside.");
        CommandInspect commandInspect = new CommandInspect("INSPECT","Inspect item in room or backpack");

        commands.put(commandHelp.GetCommandName(),commandHelp);
        commands.put(commandLookAround.GetCommandName(),commandLookAround);
        commands.put(commandMove.GetCommandName(),commandMove);
        commands.put(commandTerminateGame.GetCommandName(),commandTerminateGame);
        commands.put(commandPutInBackpack.GetCommandName(),commandPutInBackpack);
        commands.put(commandTakeOutBackpack.GetCommandName(),commandTakeOutBackpack);
        commands.put(commandInspect.GetCommandName(),commandInspect);
    }

    public static String GetUserHelp(){
        String temp = "";
        for(String key: commands.keySet()){
            ICommand command = commands.get(key);
            temp += command.GetCommandName() + " - " + command.GetCommandDescription() + "\n";
        }
        return temp;
    }

    public static Player GetPlayer(){
        return player;
    }

}
