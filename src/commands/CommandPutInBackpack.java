package commands;

import base.classes.Command;
import com.company.GamePlan;
import com.company.UserInput;
import interfaces.IItem;

/*
 *  Třída CommandPutInBackpack - Umožňuje hráči vkládat předměty do batohu během hry.
 *  Podřazená třídě Command.
 *
 *
 *  @author     Dan Šebek
 *  @version    0.01a
 *  @created    květen 2021
 */



public class CommandPutInBackpack extends Command{
    public CommandPutInBackpack(String commandName, String commandDescription){
        super(commandName,commandDescription);
    }

    /**
     * Metoda volá metodu OnPutIn třídy Backpack.
     * Počítá jak s možností špatného inputu od hráče dublictního předmětu nebo  místnosti bez sebratelných předmětů.
     *
     */
    @Override
    public void Execute(){
        if(GamePlan.GetPlayer().GetCurrentRoom().HaveInteractableItem() == 'Y'){
            System.out.print("Jaký předmět chcete sebrat?" +"\n" + GamePlan.GetPlayer().GetCurrentRoom().ShowItemsInRoom() + "\n" + "Předmět: ");
            String itemName = UserInput.ReadUserInput();
            IItem itemFromRoom = GamePlan.GetPlayer().GetCurrentRoom().OnItemRemove(itemName);
            if(itemFromRoom != null){
                char res = GamePlan.GetPlayer().GetPlayerBackpack().OnPutIn(itemFromRoom);
                switch (res){
                    //success or mimic
                    case 'S':
                        System.out.print(itemFromRoom.OnItemPutInBackpack());
                        break;
                    //already in backpack
                    case 'C':
                        System.out.print("Takový předmět už máš v batohu, promiň...");
                        GamePlan.GetPlayer().GetCurrentRoom().AddItemInRoom(itemFromRoom);
                        break;
                    //backpack is full
                    case 'F':
                        System.out.print("Batoh už máš plný, promiň...");
                        GamePlan.GetPlayer().GetCurrentRoom().AddItemInRoom(itemFromRoom);
                        break;
                }
            }else{
                System.out.print("Takový předmět tu není,promiň...");
            }
        }else{
            System.out.print("Bohužel tu není žádný předmět co by jsi mohl sebrat, promiň...");
        }

    }
}
