package commands;

import base.classes.Command;
import com.company.GamePlan;

/*
 *  Třída CommandInventory  - Umožňuje hráči rozhlédnout se po místnosti během hry.
 *  Podřazená třídě Command.
 *
 *
 *  @author     Dan Šebek
 *  @version    0.01a
 *  @created    květen 2021
 */

public class CommandLookAround extends Command{
    public CommandLookAround(String commandName, String commandDescription){
        super(commandName,commandDescription);
    }

    /**
     * Metoda volá metodu ShowRoomInfo ze třídy Room.
     *
     */
    @Override
    public void Execute(){
        System.out.print(GamePlan.GetPlayer().GetCurrentRoom().ShowRoomInfo());
    }


}
