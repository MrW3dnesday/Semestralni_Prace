package commands;

import base.classes.Command;
import com.company.GamePlan;

public class CommandInventory extends Command{
    public CommandInventory (String commandName,String commandDescription){
        super(commandName,commandDescription);
    }

    @Override
    public void Execute(){
        if(GamePlan.GetPlayer().GetPlayerBackpack().HaveInteractableItem() == 'Y') {
            System.out.print(GamePlan.GetPlayer().GetPlayerBackpack().ShowItemsInBackpack());
        }else{
            System.out.print("Bohužel v batohu nic nemáš, promiň...");
        }
    }

}
