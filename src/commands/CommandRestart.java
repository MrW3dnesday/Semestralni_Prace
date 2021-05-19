package commands;

import base.classes.Command;
import com.company.GamePlan;

public class CommandRestart extends Command{
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
