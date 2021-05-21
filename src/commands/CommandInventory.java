package commands;

import base.classes.Command;
import com.company.GamePlan;

/*
 *  Třída CommandInventory  - Umožňuje hráči zobrazit si inventář během hry.
 *  Podřazená třídě Command.
 *
 *
 *  @author     Dan Šebek
 *  @version    0.01a
 *  @created    květen 2021
 */

public class CommandInventory extends Command{
    public CommandInventory (String commandName,String commandDescription){
        super(commandName,commandDescription);
    }

    /**
     * Metoda volá metodu ShowItemsInBackpack ze třídy Backpack.
     * Počítá s možností batohu bez předmětů.
     */
    @Override
    public void Execute(){
        if(GamePlan.GetPlayer().GetPlayerBackpack().HaveInteractableItem() == 'Y') {
            System.out.print(GamePlan.GetPlayer().GetPlayerBackpack().ShowItemsInBackpack());
        }else{
            System.out.print("Bohužel v batohu nic nemáš, promiň...");
        }
    }

}
