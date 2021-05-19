package items;

import base.classes.Item;
import com.company.GamePlan;
import data.structures.OnUseReturn;
import interfaces.IItem;

public class Medkit extends Item implements IItem {
    public Medkit(String itemName, String itemDescription){
        super(itemName,itemDescription,true);
    }

    @Override
    public OnUseReturn OnUse() {
        OnUseReturn temp = new OnUseReturn(false,"Hned se cítím líp!");
        GamePlan.GetPlayer().Heal();
        return  temp;
    }
}
