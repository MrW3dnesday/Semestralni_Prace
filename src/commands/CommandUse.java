package commands;

import data.structures.OnInteractionReturn;
import base.classes.Command;
import com.company.GamePlan;
import com.company.UserInput;
import interfaces.IItem;

/*
 *  Třída CommandUse - Umožňuje hráči používat předměty které má v batohu.
 *  Podřazená třídě Command.
 *
 *
 *  @author     Dan Šebek
 *  @version    0.01a
 *  @created    květen 2021
 */




public class CommandUse extends Command{
    public CommandUse(String commandName, String commandDescription){
        super(commandName,commandDescription);
    }

    /**
     * Metoda volá metodu OnUse třídy Item.
     * Počítá jak s možností špatného inputu od hráče  nebo  batohu  bez  předmětů.
     */
    @Override
    public void Execute(){
        if(GamePlan.GetPlayer().GetPlayerBackpack().HaveInteractableItem() == 'Y'){
            System.out.print("Jaký předmět chceš použít?" + "\n" + GamePlan.GetPlayer().GetPlayerBackpack().ShowItemsInBackpack() + "\n" + "Předmět: ");
            String itemName = UserInput.ReadUserInput();
            IItem itemFromBackpack = GamePlan.GetPlayer().GetPlayerBackpack().GetItemInBackpack(itemName);
            if(itemFromBackpack != null){
                OnInteractionReturn temp = itemFromBackpack.OnUse();
                System.out.print(temp.GetInteractText());
                if(temp.GetInteractWithRoom()){
                    System.out.print("\n" + GamePlan.GetPlayer().GetCurrentRoom().OnItemUse(itemFromBackpack));
                }
            }else{
                System.out.print("Takový předmět v batohu nemáš, promiň...");
            }
        }else{
            System.out.print("Bohužel máš prázdný batoh...");
        }

    }
}
