package commands;

import base.classes.Command;
import com.company.GamePlan;
/*
 *  Třída CommandRestart - Umožňuje hráči restartovat hru.
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
    //netusim co sem
    public CommandRestart(){

    }

    /**
     * Metoda  nastaví hodnotu run na false čímž zastavím algoritmus Play ve třídě GamePlan a pomocí hodnoty restart spustí metodu Init znovu.
     *
     */
    @Override
    public void Execute(){
        GamePlan.run = false;
        GamePlan.restart = true;
    }
}
