package commands;

import base.classes.Command;
import com.company.GamePlan;
import interfaces.ICommand;

public class CommandLookAround extends Command implements ICommand {
    public CommandLookAround(String commandName, String commandDescription){
        super(commandName,commandDescription);
    }

    @Override
    public void Execute(){
        System.out.print(GamePlan.GetPlayer().GetCurrentRoom().ShowRoomInfo());
    }


}
