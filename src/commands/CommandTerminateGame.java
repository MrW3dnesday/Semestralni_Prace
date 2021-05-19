package commands;

import base.classes.BasicCommand;
import com.company.Player;
import interfaces.ICommand;

import java.util.Scanner;

public class CommandTerminateGame extends BasicCommand implements ICommand {
    public CommandTerminateGame(String commandName, String commandDescription){
        super(commandName,commandDescription);
    }

    @Override
    public void Execute(){
        System.out.println("Hra se vypíná... Díky že jsi mě vyzkoušel!");
        System.exit(0);
    }

}
