package commands;

import base.classes.BasicRoom;
import com.company.GamePlan;
import com.company.UserInput;
import base.classes.Command;

public class CommandMove extends Command{

    /*
     *  Třída CommandMove - Umožňuje hráči pohyb po mapě.
     *  Podřazená třídě Command.
     *
     *
     *  @author     Dan Šebek
     *  @version    0.01a
     *  @created    květen 2021
     */


    public CommandMove(String commandName,String commandDescription){
        super(commandName,commandDescription);
    }

    /**
     * Metoda umožnuje hráči přesun do přidělených místností.
     * Počítá se špatným inputem hráče.
     *
     */
    @Override
    public void Execute() {
        System.out.print(GamePlan.GetPlayer().GetCurrentRoom().ShowConnectedRooms() + "\n" + "Místnost :");
        String roomName = UserInput.ReadUserInput();
        //IRoom room = player.GetCurrentRoom().GetConnectedRooms().get(roomName);
        BasicRoom room = GamePlan.GetPlayer().GetCurrentRoom().GetConnectedRoom(roomName);
        if(room != null){
            GamePlan.MoveMimics();
            System.out.print("Přecházíš do " + room.GetRoomName() + "...");
            System.out.print(GamePlan.GetPlayer().OnMove(room));

        }else{
            System.out.print("Do takové místnosti odsud nemůžeš přejít, promiň...");
        }
    }
}
