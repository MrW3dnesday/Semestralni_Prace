package commands;

import com.company.Player;
import interfaces.ICommand;
import interfaces.IRoom;
import base.classes.BasicCommand;

import java.util.Scanner;

public class CommandMove extends BasicCommand implements ICommand  {

    public CommandMove(String commandName,String commandDescription){
        super(commandName,commandDescription);
    }
    @Override
    public void Execute(Player player, Scanner scanner) {
        System.out.print(player.GetCurrentRoom().ShowConnectedRooms() + "\nMístnost:");
        String roomName = scanner.nextLine();
        IRoom room = player.GetCurrentRoom().GetConnectedRooms().get(roomName);
        System.out.println(player.OnMove(room));
    }
}
