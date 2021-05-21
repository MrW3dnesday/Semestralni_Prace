package commands;

import base.classes.Command;
import com.company.GamePlan;
/*
 *  Třída CommandTerminateGame - Umožňuje hráči vypsat list příkazů během hry.
 *  Podřazená třídě Command.
 *
 *
 *  @author     Dan Šebek
 *  @version    0.01a
 *  @created    květen 2021
 */



public class CommandTerminateGame extends Command{
    public CommandTerminateGame(String commandName, String commandDescription){
        super(commandName,commandDescription);
    }

    /**
     * Metoda umožnuje hráči vypsat list příkazů.
     *
     */
    @Override
    public void Execute(){
        GamePlan.run = false;
        System.out.println("Hra se vypíná... \nDíky že jsi mě vyzkoušel!");
        System.exit(0);
    }

}
