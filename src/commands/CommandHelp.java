package commands;

import base.classes.Command;
import com.company.GamePlan;
import interfaces.ICommand;

public class CommandHelp extends Command implements ICommand {
    public CommandHelp(String commandName,String commandDescription){
        super(commandName,commandDescription);
    }

    @Override
    public void Execute(){
        System.out.print(GamePlan.GetUserHelp());
    }

}
