package com.company;

import base.classes.BasicRoom;
import base.classes.Command;
import base.classes.Item;
import commands.*;
import interfaces.IItem;
import items.Crowbar;
import items.KeyCard;
import items.Medkit;
import rooms.Bridge;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

/*
 *  Třída GamePlan - Provadí inicializaci a samotnou hru
 *  Obsahuje metody pro inicializaci a spuštění hry
 *
 *
 *
 *  @author     Dan Šebek
 *  @version    0.01a
 *  @created    květen 2021
 */
public class GamePlan {

    Scanner scanner;

    public static HashMap<String,IItem> generatedItems;
    public static HashMap<String,BasicRoom> generatedRooms;
    public static HashMap<String,Command> commands;
    public static LinkedList<Mimic> mimics;
    public static boolean run;
    public static boolean restart;
    public static boolean testRun;

    static Player player;

    public GamePlan(Scanner scanner){
        this.scanner = scanner;

        generatedItems = new HashMap<String,IItem>();
        generatedRooms = new HashMap<String,BasicRoom>();
        commands = new HashMap<String, Command>();
        mimics = new LinkedList<Mimic>();

    }

    public GamePlan(){
        this.scanner = new Scanner(System.in);

        generatedItems = new HashMap<String,IItem>();
        generatedRooms = new HashMap<String,BasicRoom>();
        commands = new HashMap<String, Command>();
        mimics = new LinkedList<Mimic>();

    }
    /**
     * Metoda zajišťuje inicializaci pro NUnit testy
     *
     */
    public void NUnitINIT(){

        Item cup = new Item("Hrnek","Obyčejný hrníček, asi z keramiky.","cup",true);

        generatedItems.put(cup.GetItemName(),cup);

        BasicRoom entry = new BasicRoom("Vstup", "Nic moc tu není...","entry");
        BasicRoom medical = new BasicRoom("Ošetřovna","Vypadá to tak, že tady asi někoho ošetřovali...","medical");

        entry.AddConnectedRoom(medical);

        medical.AddConnectedRoom(entry);

        generatedRooms.put(entry.GetRoomEngineName(),entry);
        generatedRooms.put(medical.GetRoomEngineName(),medical);

        InitCommands();

        player = new Player(entry);

    }

    /**
     * Metoda zajišťuje inicializaci při normálním spuštění
     *
     */
    public void Init(){
        Item cup = new Item("Hrnek","Obyčejný hrníček, asi z keramiky.","cup",true);
        Item picture = new Item("Obrázek", "Vypadá to jako fotka rodiny.", "picture",true);
        Item box = new Item("Krabička","To vypadá, že kdysi v tom měl někdo svačinu.", "box",true);
        Item record = new Item("Záznam","Něco se tu píše: \"Všechny nás to dostalo, nikdy nevíme co je to za předmět, \nale jakmile s tím začneme něco dělat tak se to hned změní a zabijeto někoho znás.\nKód je jako rok na Zemi...","record",true);
        Item glass = new Item("Sklenice","Obyčejná sklenička, asi ze skla","glass",true);
        Item pistol = new Item("Pistole", "Tu musel mít člen ochranky, bohužel je rozbitá","pistol",true);
        Item coin = new Item("Mince","Kéž by tu byl automat, koupil bych si limonádu","coin",true);

        Crowbar crowbar = new Crowbar("Páčidlo", "Tohle by mohlo něco rozbít.");
        Medkit medkit = new Medkit("Medkit","Věřím, že tohle mi zachrání život.");
        KeyCard keyCard = new KeyCard("Karta","Kdybych ji někde mohl použít, určitě to něco udělá.");

        generatedItems.put(cup.GetItemName(),cup);
        generatedItems.put(box.GetItemName(),box);
        generatedItems.put(picture.GetItemName(),picture);
        generatedItems.put(record.GetItemName(),record);
        generatedItems.put(pistol.GetItemName(),pistol);
        generatedItems.put(coin.GetItemName(),coin);
        generatedItems.put(crowbar.GetItemName(),crowbar);
        generatedItems.put(medkit.GetItemName(),medkit);
        generatedItems.put(keyCard.GetItemName(),keyCard);


        BasicRoom entry = new BasicRoom("Vstup", "Nic moc tu není...","entry");
        BasicRoom medical = new BasicRoom("Ošetřovna","Vypadá to tak, že tady asi někoho ošetřovali...","medical");
        BasicRoom lobby = new BasicRoom("Lobby","Kdysi tudy musela procházet kvanta lidí.","lobby");
        BasicRoom generator = new BasicRoom("Generátor","Tady to muselo pohánět celou loď, chudák ten v rohu...\nJen se snažil přežít...","generator");

        Bridge bridge = new Bridge("Můstek","Tady to vypadá jako by odtud veleli celý lodi.\nTřeba, když najdu kartu tak tu s ní budu moc něco otevřít.","lobby");

        entry.AddItemInRoom(cup);
        entry.AddItemInRoom(picture);
        entry.AddItemInRoom(glass);

        entry.AddConnectedRoom(medical);

        medical.AddItemInRoom(record);
        medical.AddItemInRoom(cup);
        medical.AddItemInRoom(cup);
        medical.AddItemInRoom(glass);
        medical.AddItemInRoom(picture);
        medical.AddItemInRoom(box);

        medical.AddConnectedRoom(entry);
        medical.AddConnectedRoom(lobby);

        lobby.AddItemInRoom(box);
        lobby.AddItemInRoom(glass);
        lobby.AddItemInRoom(coin);
        lobby.AddItemInRoom(cup);
        lobby.AddItemInRoom(picture);
        lobby.AddItemInRoom(coin);


        lobby.AddConnectedRoom(medical);
        lobby.AddConnectedRoom(bridge);
        lobby.AddConnectedRoom(generator);

        generator.AddItemInRoom(keyCard);
        generator.AddItemInRoom(pistol);
        generator.AddItemInRoom(cup);
        generator.AddItemInRoom(box);

        generator.AddConnectedRoom(lobby);

        bridge.AddItemInRoom(crowbar);
        bridge.AddItemInRoom(medkit);
        bridge.AddItemInRoom(box);
        bridge.AddItemInRoom(cup);
        bridge.AddItemInRoom(cup);
        bridge.AddItemInRoom(glass);
        bridge.AddItemInRoom(picture);

        bridge.AddConnectedRoom(lobby);

        generatedRooms.put(entry.GetRoomEngineName(),entry);
        generatedRooms.put(medical.GetRoomEngineName(),medical);
        generatedRooms.put(lobby.GetRoomEngineName(),lobby);
        generatedRooms.put(generator.GetRoomEngineName(),generator);
        generatedRooms.put(bridge.GetRoomEngineName(),bridge);

        Mimic mimic1 = new Mimic("MIMIC","MIMIC",bridge);
        Mimic mimic2 = new Mimic("MIMIC","MIMIC",lobby);
        Mimic mimic3 = new Mimic("MIMIC","MIMIC",generator);
        mimic1.OnMove();
        mimic2.OnMove();
        mimic3.OnMove();

        mimics.add(mimic1);
        mimics.add(mimic2);
        mimics.add(mimic3);

        InitCommands();

        player = new Player(entry);

        run = true;
        restart = false;
        testRun = false;

        Play();

    }
    /**
     * Metoda zajišťuje inicializaci při testovací hře
     *
     */
    public void TestInit(){
        Item cup = new Item("Hrnek","Obyčejný hrníček, asi z keramiky.","cup",true);
        Item picture = new Item("Obrázek", "Vypadá to jako fotka rodiny.", "picture",true);
        Item box = new Item("Krabička","To vypadá, že kdysi v tom měl někdo svačinu.", "box",true);

        Crowbar crowbar = new Crowbar("Páčidlo", "Tohle by mohlo něco rozbít.");
        Medkit medkit = new Medkit("Medkit","Věřím, že tohle mi zachrání život.");
        KeyCard keyCard = new KeyCard("Karta","Kdybych ji někde mohl použít, určitě to něco udělá.");

        generatedItems.put(cup.GetItemName(),cup);
        generatedItems.put(box.GetItemName(),box);
        generatedItems.put(picture.GetItemName(),picture);
        generatedItems.put(crowbar.GetItemName(),crowbar);
        generatedItems.put(medkit.GetItemName(),medkit);
        generatedItems.put(keyCard.GetItemName(),keyCard);

        BasicRoom entry = new BasicRoom("Vstup", "Nic moc tu není...","entry");
        BasicRoom medical = new BasicRoom("Ošetřovna","Vypadá to tak, že tady asi někoho ošetřovali...","medical");

        Bridge bridge = new Bridge("Můstek","Tady to vypadá jako by odtud veleli celý lodi.\nTřeba, když najdu kartu tak tu s ní budu moc něco otevřít.","bridge");

        entry.AddItemInRoom(cup);
        entry.AddItemInRoom(box);
        entry.AddItemInRoom(cup);
        entry.AddItemInRoom(crowbar);

        entry.AddConnectedRoom(medical);


        medical.AddItemInRoom(cup);
        medical.AddItemInRoom(keyCard);

        medical.AddConnectedRoom(entry);
        medical.AddConnectedRoom(bridge);

        bridge.AddItemInRoom(cup);
        bridge.AddItemInRoom(medkit);

        bridge.AddConnectedRoom(medical);

        generatedRooms.put(entry.GetRoomEngineName(),entry);
        generatedRooms.put(medical.GetRoomEngineName(),medical);
        generatedRooms.put(bridge.GetRoomEngineName(),bridge);

        Mimic mimic1 = new Mimic("MIMIC","MIMIC",bridge);
        Mimic mimic2 = new Mimic("MIMIC","MIMIC",medical);
        mimic1.OnMove();
        mimic2.OnMove();

        mimics.add(mimic1);
        mimics.add(mimic2);


        InitCommands();

        player = new Player(entry);

        run = true;
        restart = false;
        testRun = true;

        Play();
    }


    /**
     * Metoda zajišťuje čtení a zpracování příkazů od uživatele
     *
     */
    private void Play(){

        System.out.print(GetUserHelp());
        System.out.print(GetPlayer().currentRoom.OnPlayerEntry());
        while(run){
            System.out.print("\nZadej příkaz: ");
            String txtCommand = UserInput.ReadUserInput();

            txtCommand = txtCommand.toUpperCase(Locale.ROOT);

            //commands.get(command).Execute();
            Command command = commands.get(txtCommand);
            if(command != null){
                command.Execute();
            }else{
                System.out.print("Takový příkaz tu není, promiň...");
            }
        }
        if(restart && testRun){
            System.out.print("\nRestartuji..." + "\n");
            commands.clear();
            TestInit();
        }else if(restart){
            System.out.print("\nRestartuji..." + "\n");
            commands.clear();
            Init();
        }
    }

    /**
     * Metoda zajišťuje inicializaci základních příkazů
     *
     */
    private void InitCommands(){
        CommandHelp commandHelp = new CommandHelp("POMOC","Vypíše všechny dostupné příkazy.");
        CommandMove commandMove = new CommandMove("JÍT","Přesuň se do další místnosti.");
        CommandTerminateGame commandTerminateGame = new CommandTerminateGame("UKONČIT","Vypne hru.");
        CommandPutInBackpack commandPutInBackpack = new CommandPutInBackpack("ZVEDNOUT","Zvdeni předmět a vlož si jej do batohu.");
        CommandTakeOutBackpack commandTakeOutBackpack = new CommandTakeOutBackpack("VYNDAT","Vyndej předmět z batohu a vlož jej do místnosti.");
        CommandLookAround commandLookAround = new CommandLookAround("ROZHLÉDNOUT SE","Zjisti informace o místnosti v které jsi.");
        CommandInspect commandInspect = new CommandInspect("PROHLÉDNOUT SI","Prohlédni si předmět v místnosti nebo v batohu.");
        CommandUse commandUse = new CommandUse("POUŽÍT","Použí předmět v místnosti.");
        CommandInventory commandInventory = new CommandInventory("BATOH","Prohlédni si co máš v batohu.");
        CommandRestart commandRestart = new CommandRestart("RESTART","Restartuj hru.");
        CommandInteract commandInteract = new CommandInteract("INTERAKCE","Interaguj s předmět v místnosi.");

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
        commands.put(commandInteract.GetCommandName(),commandInteract);
    }

    /**
     * Metoda připravý text pro výpis příkazů
     *
     * @return Vrací připravený text
     */
    public static String GetUserHelp(){
        String temp = "";
        temp += "=====================================\n";
        for(String key: commands.keySet()){
            Command command = commands.get(key);
            temp +=command.GetCommandDescription() + " - " + command.GetCommandName() + "\n";
        }
        //remove last "\n"
        temp = temp.substring(0,temp.length()-1);
        temp += "\n=====================================";
        return temp;
    }

    /**
     * Metoda vrátí hráče
     *
     * @return Vrací hráče
     */
    public static Player GetPlayer(){
        return player;
    }

    /**
     * Metoda pohne se všemi MIMIC v herním světě
     */
    public static void MoveMimics(){
        for(Mimic mimic:mimics){
            mimic.OnMove();
        }
    }
}
