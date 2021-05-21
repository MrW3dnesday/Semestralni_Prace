package commands;

import base.classes.Command;
import com.company.GamePlan;
import com.company.UserInput;
import interfaces.IItem;
/*
 *  Třída CommandAttack - Umožňuje hráči zaůtočit na předmět.
 *  Podřazená třídě Command.
 *
 *
 *  @author     Dan Šebek
 *  @version    0.01a
 *  @created    květen 2021
 */
public class CommandAttack extends Command{
    public CommandAttack(String commandName,String commandDescription){
        super(commandName,commandDescription);
    }

    /**
     * Metoda umožnuje hráči vybrat předmět na který bude útočit.
     * Počítá jak s možností špatného inputu od hráče tak místnosti bez předmětu.
     *
     */
    @Override
    public void Execute(){
        if(GamePlan.GetPlayer().GetCurrentRoom().HaveInteractableItem() == 'Y'){
            System.out.print("Na co chceš zaútočit?" + "\n" + GamePlan.GetPlayer().GetCurrentRoom().ShowItemsInRoom() + "\nCíl: ");
            String itemName = UserInput.ReadUserInput();
            IItem itemFromRoom = GamePlan.GetPlayer().GetCurrentRoom().GetItemFromRoom(itemName);
            if(itemFromRoom != null){
                GamePlan.GetPlayer().GetCurrentRoom().OnItemRemove(itemName);
                System.out.print(itemFromRoom.OnAttack());
            }else{
                System.out.print("Takový předmět v místnosti není, promiň...");
            }
        }else{
            System.out.print("Bohužel v místnosti není nic na co by jsi mohl zaútočit, promiň...");
        }
    }
}
