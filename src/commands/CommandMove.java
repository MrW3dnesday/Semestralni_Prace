package commands;

import base.classes.BasicRoom;
import com.company.GamePlan;
import com.company.UserInput;
import base.classes.Command;

public class CommandMove extends Command{

    public CommandMove(String commandName,String commandDescription){
        super(commandName,commandDescription);
    }
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
