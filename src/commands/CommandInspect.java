package commands;

import base.classes.Command;
import com.company.GamePlan;
import com.company.UserInput;
import interfaces.IItem;

import java.util.Locale;

/*
 *  Třída CommandInspect - Umožňuje hráči prohlédnout  si předmět během hry.
 *  Podřazená třídě Command.
 *
 *
 *  @author     Dan Šebek
 *  @version    0.01a
 *  @created    květen 2021
 */


public class CommandInspect extends Command{
    public CommandInspect(String commandName, String commandDescription){
        super(commandName,commandDescription);
    }

    /**
     * Metoda umožnuje hřáči aby si prohlédl předmět buďto v místnsoti nebo v batohu.
     * Počítá jak s možností špatného inputu od hráče tak místnosti nebo batohu bez předmětů.
     */
    @Override
    public void Execute(){
        if(GamePlan.GetPlayer().GetCurrentRoom().HaveInteractableItem() == 'Y' && GamePlan.GetPlayer().GetCurrentRoom().HaveInteractableItem() == 'Y') {
            System.out.print("Jaké předměty si chceš prohlédnout?(BATOH,MÍSTNOST): ");
            String res = UserInput.ReadUserInput();
            res = res.toUpperCase(Locale.ROOT);
            IItem itemFromStorage;
            switch (res) {
                case "BATOH":
                    if(GamePlan.GetPlayer().GetPlayerBackpack().HaveInteractableItem() == 'Y'){
                        System.out.print(GamePlan.GetPlayer().GetPlayerBackpack().ShowItemsInBackpack() + "\n" + "Předmět: ");
                        String itemNameInBackpack = UserInput.ReadUserInput();
                        itemFromStorage = GamePlan.GetPlayer().GetPlayerBackpack().GetItemInBackpack(itemNameInBackpack);
                        if (itemFromStorage != null) {
                            System.out.print(itemFromStorage.OnInspect());
                        } else {
                            System.out.print("Takový předmět v batohu nemáš, promiň...");
                        }
                    }else{
                        System.out.print("Bohužel v batohu není nic co by jsi si mohl prohlédnout, promiň...");
                    }
                    break;
                case "MÍSTNOST":
                case "MISTNOST":
                    if(GamePlan.GetPlayer().GetCurrentRoom().HaveInteractableItem() == 'Y'){
                        System.out.print(GamePlan.GetPlayer().GetCurrentRoom().ShowItemsInRoom() + "\n" + "Předmět: ");
                        String itemNameInRoom = UserInput.ReadUserInput();
                        itemFromStorage = GamePlan.GetPlayer().GetCurrentRoom().GetItemFromRoom(itemNameInRoom);
                        if (itemFromStorage != null) {
                            System.out.print(itemFromStorage.OnInspect());
                        } else {
                            System.out.print("Takový předmět v místnosti není, promiň...");
                        }
                    }else{
                        System.out.print("Bohužel v místnosti nejsou žádné předměty k prohlédnutí, promiň...");
                    }
                    break;
                default:
                    System.out.print("Bohužel v " + res + " žadné předměty k prohlédnutí nejsou, promiň...");
                    break;
            }
        }else{
            System.out.print("Bohužel nemáš žádné předměty k prohlédnutí ani u sebe ani v místnosit...");
        }

    }
}
