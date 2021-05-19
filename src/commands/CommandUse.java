package commands;

import data.structures.OnUseReturn;
import base.classes.Command;
import com.company.GamePlan;
import com.company.UserInput;
import interfaces.ICommand;
import interfaces.IItem;

public class CommandUse extends Command implements ICommand {
    public CommandUse(String commandName, String commandDescription){
        super(commandName,commandDescription);
    }

    @Override
    public void Execute(){
        if(GamePlan.GetPlayer().GetPlayerBackpack().HaveInteractableItem() == 'Y'){
            System.out.print("Jaký předmět chceš použít?" + "\n" + GamePlan.GetPlayer().GetPlayerBackpack().ShowItemsInBackpack() + "\n" + "Předmět: ");
            String itemName = UserInput.ReadUserInput();
            IItem itemFromBackpack = GamePlan.GetPlayer().GetPlayerBackpack().GetItemInBackpack(itemName);
            if(itemFromBackpack != null){
                OnUseReturn temp = itemFromBackpack.OnUse();
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
