package items;

import base.classes.Item;
import com.company.GamePlan;
import data.structures.OnInteractionReturn;
import interfaces.IItem;


/*
 *  Třída Medkit - Odděděná od třídy Item, implementuje IItem. Slouží k vytvoření medkitu
 *  Obsahuje @Override OnUse
 *
 *
 *
 *  @author     Dan Šebek
 *  @version    0.01a
 *  @created    květen 2021
 */
public class Medkit extends Item implements IItem {
    public Medkit(String itemName, String itemDescription){
        super(itemName,itemDescription,"medkit",true);
    }

    /**
     * Metoda vrátí text při použítí předmětu a zda interaguje s místností a ošetří hráče @Override
     *
     *@return Vrací text při použití předmětu a zda interaguje s místností batohu
     */
    @Override
    public OnInteractionReturn OnUse() {
        OnInteractionReturn temp = new OnInteractionReturn(false,"Hned se cítím líp!");
        GamePlan.GetPlayer().Heal();
        GamePlan.GetPlayer().GetPlayerBackpack().OnTakeOut("Medkit");
        return  temp;
    }
}
