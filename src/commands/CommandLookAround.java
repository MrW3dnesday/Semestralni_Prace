package commands;

import base.classes.Command;
import com.company.GamePlan;

/*
 *  Třída CommandAttack -
 *
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

    @Override
    public void Execute(){
        System.out.print(GamePlan.GetPlayer().GetCurrentRoom().ShowRoomInfo());
    }


}
