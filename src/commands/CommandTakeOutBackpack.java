package commands;

import base.classes.Command;
import com.company.GamePlan;
import com.company.UserInput;
import interfaces.IItem;

/*
 *  Třída CommandTakeOutBackpack - Umožňuje hráči vypsat list příkazů během hry.
 *  Podřazená třídě Command.
 *
 *
 *  @author     Dan Šebek
 *  @version    0.01a
 *  @created    květen 2021
 */


public class CommandTakeOutBackpack extends Command{
    public CommandTakeOutBackpack(String commandName,String commandDescription){
        super(commandName,commandDescription);
    }

    /**
     * Metoda umožnuje hráči vypsat list příkazů.
     *
     */
    @Override
    public void Execute(){
        if(GamePlan.GetPlayer().GetPlayerBackpack().HaveInteractableItem() == 'Y'){
            System.out.print("Jaký předmět chceš vyndat z batohu?" + "\n" + GamePlan.GetPlayer().GetPlayerBackpack().ShowItemsInBackpack() + "\n" + "Předmět: ");
            String itemName = UserInput.ReadUserInput();
            IItem itemFromBackpack = GamePlan.GetPlayer().GetPlayerBackpack().OnTakeOut(itemName);
            if(itemFromBackpack != null){
                System.out.print(itemFromBackpack.OnItemTakeOutBackpack());
                GamePlan.GetPlayer().GetCurrentRoom().AddItemInRoom(itemFromBackpack);
            }else{
                System.out.print("Takový předmět v batohu nenáš, promiň...");
            }
        }else{
            System.out.print("Bohužel v batohu nic nemáš, promiň...");
        }

    }
}
