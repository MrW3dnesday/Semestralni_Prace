package commands;

import base.classes.Command;
import com.company.GamePlan;
import com.company.UserInput;
import interfaces.IItem;

public class CommandInteract extends Command{
    public CommandInteract(String commandName,String commandDescription){
        super(commandName,commandDescription);
    }

    @Override
    public void Execute(){
        if(GamePlan.GetPlayer().GetCurrentRoom().HaveInteractableItem() == 'Y'){
            System.out.print("S jakým předmětěm chceš interagovat?" + "\n" + GamePlan.GetPlayer().GetCurrentRoom().ShowItemsInRoom() + "\n" + "Předmět: ");
            String itemName = UserInput.ReadUserInput();
            IItem itemFromRoom = GamePlan.GetPlayer().GetCurrentRoom().GetItemFromRoom(itemName);
            if(itemFromRoom != null){
                System.out.print(GamePlan.GetPlayer().GetCurrentRoom().OnItemInteract(itemFromRoom));
            }else{
                System.out.print("Takový předmět tu není, promiň...");
            }
        }else{
            System.out.print("Není tu nic s čím by jsi mohl interagovat, promiň...");
        }
    }

}
