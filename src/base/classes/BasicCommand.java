package base.classes;

import com.company.Player;
import interfaces.ICommand;

import java.util.Scanner;

public class BasicCommand implements ICommand {

    String commandName;
    String commandDescription;

    protected BasicCommand(){

    }

    protected BasicCommand(String commandName,String commandDescription){
        this.commandName = commandName;
        this.commandDescription = commandDescription;
    }
    @Override
    public void Execute(){
        System.out.println("BASE CLASS");
    }

    @Override
    public String GetCommandName(){
        return  commandName;
    }

    @Override
    public String GetCommandDescription(){return commandDescription;}
}
