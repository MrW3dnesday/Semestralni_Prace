package commands;

import base.classes.Command;
import com.company.GamePlan;
/*
 *  Třída CommandTerminateGame - Umožňuje hráči vypnout  hru.
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
     * Metoda  nastaví hodnotu run na false čímž zastavím algoritmus Play ve třídě GamePlan.
     *
     */
    @Override
    public void Execute(){
        GamePlan.run = false;
        System.out.println("Hra se vypíná... \nDíky že jsi mě vyzkoušel!");
        System.exit(0);
    }

}
