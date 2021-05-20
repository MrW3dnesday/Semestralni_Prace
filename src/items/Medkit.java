package items;

import base.classes.Item;
import com.company.GamePlan;
import data.structures.OnInteractionReturn;
import interfaces.IItem;

public class Medkit extends Item implements IItem {
    public Medkit(String itemName, String itemDescription){
        super(itemName,itemDescription,"medkit",true);
    }

    @Override
    public OnInteractionReturn OnUse() {
        OnInteractionReturn temp = new OnInteractionReturn(false,"Hned se cítím líp!");
        GamePlan.GetPlayer().Heal();
        return  temp;
    }
}
