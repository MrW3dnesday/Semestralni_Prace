package commands;

import base.classes.Command;
import com.company.GamePlan;
import interfaces.ICommand;

public class CommandTerminateGame extends Command implements ICommand {
    public CommandTerminateGame(String commandName, String commandDescription){
        super(commandName,commandDescription);
    }

    @Override
    public void Execute(){
        GamePlan.run = false;
        System.out.println("Hra se vypíná... Díky že jsi mě vyzkoušel!");
        System.exit(0);
    }

}
