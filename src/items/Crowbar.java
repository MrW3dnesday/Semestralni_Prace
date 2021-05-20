package items;

import base.classes.Command;
import base.classes.Item;
import com.company.GamePlan;
import commands.CommandAttack;
import data.structures.OnUseReturn;
import interfaces.IItem;

public class Crowbar extends Item implements IItem {
    public Crowbar(String itemName, String itemDescription){
        super(itemName,itemDescription,"crowbar",true);
    }

    @Override
    public String OnItemPutInBackpack(){
        CommandAttack commandAttack = new CommandAttack("ATTACK","Smash item to dust.");
        GamePlan.commands.put(commandAttack.GetCommandName(),commandAttack);
        return "NEW COMMAND: " + commandAttack.GetCommandName() + " - " + commandAttack.GetCommandDescription() + "\n" + super.OnItemPutInBackpack();
    }

    @Override
    public String OnItemTakeOutBackpack(){
        Command command = GamePlan.commands.remove("ATTACK");
        return  "COMMAND REMOVED: " + command.GetCommandName() + "\n" + super.OnItemTakeOutBackpack();
    }

    @Override
    public OnUseReturn OnUse(){
        OnUseReturn temp = new OnUseReturn(true,"Možná s tím pujde něco vypáčit.");
        return temp;
    }
}
