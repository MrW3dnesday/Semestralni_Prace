package commands;

import base.classes.Command;
import com.company.GamePlan;

public class CommandTerminateGame extends Command{
    public CommandTerminateGame(String commandName, String commandDescription){
        super(commandName,commandDescription);
    }

    @Override
    public void Execute(){
        GamePlan.run = false;
        System.out.println("Hra se vypíná... \nDíky že jsi mě vyzkoušel!");
        System.exit(0);
    }

}
