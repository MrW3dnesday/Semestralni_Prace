package commands;

import base.classes.BasicCommand;
import com.company.GamePlan;
import com.company.UserInput;
import interfaces.ICommand;
import interfaces.IItem;

public class CommandAttack extends BasicCommand implements ICommand {
    public CommandAttack(String commandName,String commandDescription){
        super(commandName,commandDescription);
    }

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
