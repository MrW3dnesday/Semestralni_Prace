package commands;

import base.classes.Command;
import com.company.GamePlan;
/*
 *  Třída CommandHelp - Umožňuje hráči vypsat list příkazů během hry.
 *  Podřazená třídě Command.
 *
 *
 *
 *  @author     Dan Šebek
 *  @version    0.01a
 *  @created    květen 2021
 */
public class CommandHelp extends Command{
    public CommandHelp(String commandName,String commandDescription){
        super(commandName,commandDescription);
    }

    @Override
    public void Execute(){
        System.out.print(GamePlan.GetUserHelp());
    }

}
