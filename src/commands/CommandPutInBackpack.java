package commands;

import base.classes.BasicCommand;
import base.classes.BasicRoom;
import com.company.GamePlan;
import com.company.Player;
import com.company.UserInput;
import interfaces.ICommand;
import interfaces.IItem;

import java.util.Scanner;

public class CommandPutInBackpack extends BasicCommand implements ICommand {
    public CommandPutInBackpack(String commandName, String commandDescription){
        super(commandName,commandDescription);
    }

    @Override
    public void Execute(){
        System.out.print("Jaký předmět chcete sebrat?" +"\n" + GamePlan.GetPlayer().GetCurrentRoom().ShowItemsInRoom() + "\n" + "Předmět: ");
        String itemName = UserInput.ReadUserInput();
        IItem itemFromRoom = GamePlan.GetPlayer().GetCurrentRoom().OnItemRemove(itemName);
        if(itemFromRoom != null){
            char res = GamePlan.GetPlayer().GetPlayerBackpack().OnPutIn(itemFromRoom);
            switch (res){
                case 'S':
                    System.out.print("Předmět jsi uložil do batohu.");
                    break;
                case 'C':
                    System.out.print("Takový předmět už máš v batohu, promiň...");
                    GamePlan.GetPlayer().GetCurrentRoom().OnItemAdd(itemFromRoom);
                    break;
                case 'F':
                    System.out.print("Batoh už máš plný, promiň...");
                    GamePlan.GetPlayer().GetCurrentRoom().OnItemAdd(itemFromRoom);
                    break;
            }
        }else{
            System.out.print("Takový předmět tu není,promiň...");
        }

    }
}
