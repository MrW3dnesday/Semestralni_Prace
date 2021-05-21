package commands;

import base.classes.Command;
import com.company.GamePlan;
/*
 *  Třída CommandRestart - Umožňuje hráči vypsat list příkazů během hry.
 *  Podřazená třídě Command.
 *
 *
 *  @author     Dan Šebek
 *  @version    0.01a
 *  @created    květen 2021
 */




public class CommandRestart extends Command{
    public CommandRestart(String commandName, String commandDescription){
        super(commandName,commandDescription);
    }

    public CommandRestart(){

    }

    /**
     * Metoda umožnuje hráči vypsat list příkazů.
     *
     */
    @Override
    public void Execute(){
        GamePlan.run = false;
        GamePlan.restart = true;
    }
}
