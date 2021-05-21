package commands;

import base.classes.Command;
import com.company.GamePlan;
import com.company.UserInput;
import data.structures.OnInteractionReturn;
import interfaces.IItem;

/*
 *  Třída CommandInteract -  Umožňuje hráči interaktovat s předměty během hry.
 *  Podřazená třídě Command.
 *
 *
 *  @author     Dan Šebek
 *  @version    0.01a
 *  @created    květen 2021
 */

public class CommandInteract extends Command{
    public CommandInteract(String commandName,String commandDescription){
        super(commandName,commandDescription);
    }

    /**
     * Metoda volá metodu OnIteract ze třídy Item.
     * Počítá jak s možností špatného inputu od hráče tak místnosti bez použitelných předmětů.
     *
     */
    @Override
    public void Execute(){
        if(GamePlan.GetPlayer().GetCurrentRoom().HaveInteractableItem() == 'Y'){
            System.out.print("S jakým předmětěm chceš interagovat?" + "\n" + GamePlan.GetPlayer().GetCurrentRoom().ShowItemsInRoom() + "\n" + "Předmět: ");
            String itemName = UserInput.ReadUserInput();
            IItem itemFromRoom = GamePlan.GetPlayer().GetCurrentRoom().GetItemFromRoom(itemName);
            if(itemFromRoom != null){
                OnInteractionReturn temp = itemFromRoom.OnInteract();
                System.out.print(temp.GetInteractText());
                if(temp.GetInteractWithRoom()){
                    System.out.print(GamePlan.GetPlayer().GetCurrentRoom().OnItemInteract(itemFromRoom));
                }
            }else{
                System.out.print("Takový předmět tu není, promiň...");
            }
        }else{
            System.out.print("Není tu nic s čím by jsi mohl interagovat, promiň...");
        }
    }

}
