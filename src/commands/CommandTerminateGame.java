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
    public void Execute(Player player, Scanner scanner){
        System.out.println("Terminating game, thank you for playing");
        System.exit(0);
    }

}
