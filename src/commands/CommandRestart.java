package commands;

import base.classes.Command;
import com.company.GamePlan;
import interfaces.ICommand;

public class CommandRestart extends Command implements ICommand {
    public CommandRestart(String commandName, String commandDescription){
        super(commandName,commandDescription);
    }

    public CommandRestart(){

    }

    @Override
    public void Execute(){
        GamePlan.run = false;
        GamePlan.restart = true;
    }
}
