package commands;

import base.classes.BasicCommand;
import com.company.GamePlan;
import interfaces.ICommand;

public class CommandHelp extends BasicCommand implements ICommand {
    public CommandHelp(String commandName,String commandDescription){
        super(commandName,commandDescription);
    }

    @Override
    public void Execute(){
        System.out.print(GamePlan.GetUserHelp());
    }

}
