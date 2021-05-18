package commands;

import base.classes.BasicCommand;
import com.company.GamePlan;
import com.company.UserInput;
import interfaces.ICommand;
import interfaces.IItem;

import java.util.Locale;

public class CommandInspect extends BasicCommand implements ICommand {
    public CommandInspect(String commandName, String commandDescription){
        super(commandName,commandDescription);
    }

    @Override
    public void Execute(){
        System.out.print("Jaké předměty si chceš prohlédnout?(BATOH,MÍSTNOST): ");
        String res = UserInput.ReadUserInput();
        res = res.toUpperCase(Locale.ROOT);
        IItem itemFromStorage;
        switch(res){
            case "BATOH":
                System.out.print(GamePlan.GetPlayer().GetPlayerBackpack().ShowItemsInBackpack() + "\n" + "Předmět: ");
                String itemNameInBackpack = UserInput.ReadUserInput();
                itemFromStorage = GamePlan.GetPlayer().GetPlayerBackpack().GetItemInBackpack(itemNameInBackpack);
                if( itemFromStorage!= null){
                    itemFromStorage.OnInspect();
                }else{
                    System.out.print("Takový předmět v batohu nemáš, promiň...");
                }
                break;
            case "MÍSTNOST":
                System.out.print(GamePlan.GetPlayer().GetCurrentRoom().ShowItemsInRoom() + "\n" + "Předmět: ");
                String itemNameInRoom = UserInput.ReadUserInput();
                itemFromStorage = GamePlan.GetPlayer().GetCurrentRoom().GetItemFromRoom(itemNameInRoom);
                if(itemFromStorage != null){
                    itemFromStorage.OnInspect();
                }else{
                    System.out.print("Takový předmět v místnosti není, promiň...");
                }
                break;
            default:
                System.out.print("Bohužel v " + res + " žadné předměty k prohlédnutí nejsou, promiň...");
                break;
        }



    }
}
