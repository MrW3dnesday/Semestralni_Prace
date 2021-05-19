package commands;

import base.classes.BasicCommand;
import com.company.GamePlan;
import com.company.Player;
import interfaces.ICommand;

import java.util.Scanner;

public class CommandLookAround extends BasicCommand implements ICommand {
    public CommandLookAround(String commandName, String commandDescription){
        super(commandName,commandDescription);
    }

    @Override
    public void Execute(){
        System.out.print(GamePlan.GetPlayer().GetCurrentRoom().ShowRoomInfo());
    }


}
