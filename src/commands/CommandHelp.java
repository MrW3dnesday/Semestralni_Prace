package commands;

import base.classes.Command;
import com.company.GamePlan;

public class CommandHelp extends Command{
    public CommandHelp(String commandName,String commandDescription){
        super(commandName,commandDescription);
    }

    @Override
    public void Execute(){
        System.out.print(GamePlan.GetUserHelp());
    }

}
