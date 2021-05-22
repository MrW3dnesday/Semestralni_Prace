package items;

import base.classes.Command;
import base.classes.Item;
import com.company.GamePlan;
import commands.CommandAttack;
import data.structures.OnInteractionReturn;
import interfaces.IItem;

/*
 *  Třída Crowbar - Odděděná od třídy Item, implementuje IItem. Slouží k vytvoření páčidla
 *  Obsahuje @Override OnUse,OnItemPutInBackpack,OnItemTakeOutBackpack
 *
 *
 *
 *  @author     Dan Šebek
 *  @version    0.01a
 *  @created    květen 2021
 */
public class Crowbar extends Item implements IItem {
    public Crowbar(String itemName, String itemDescription){
        super(itemName,itemDescription,"crowbar",true);
    }

    /**
     * Metoda vrátí text při vložení předmětu do batohu a přidá hráči nový příkaz @Override
     *
     *@return Vrací text při vložení předmětu do batohu
     */
    @Override
    public String OnItemPutInBackpack(){
        CommandAttack commandAttack = new CommandAttack("ZAÚTOČIT","Rozmlať předmět na prach");
        GamePlan.commands.put(commandAttack.GetCommandName(),commandAttack);
        return "Nový příkaz: " + commandAttack.GetCommandName() + " - " + commandAttack.GetCommandDescription() + "\n" + super.OnItemPutInBackpack();
    }

    /**
     * Metoda vrátí text při vyndání předmětu z batohu a odebere hráči příkaz @Override
     *
     *@return Vrací text při vyndání předmětu z batohu
     */
    @Override
    public String OnItemTakeOutBackpack(){
        Command command = GamePlan.commands.remove("ZAÚTOČIT");
        return  "Příkaz odebrán: " + command.GetCommandName() + "\n" + super.OnItemTakeOutBackpack();
    }

    /**
     * Metoda vrátí text při použítí předmětu a zda interaguje s místností @Override
     *
     *@return Vrací text při použití předmětu a zda interaguje s místností batohu
     */
    @Override
    public OnInteractionReturn OnUse(){
        OnInteractionReturn temp = new OnInteractionReturn(true,"Možná s tím pujde něco vypáčit.");
        return temp;
    }
}
