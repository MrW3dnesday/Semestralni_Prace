package interfaces;

import data.structures.OnInteractionReturn;

/*
 *  Interface IItem - TODO
 *
 *
 *
 *  @author     Dan Šebek
 *  @version    0.01a
 *  @created    květen 2021
 */
public interface IItem {
    public String OnInspect();

    public OnInteractionReturn OnUse();

    public OnInteractionReturn OnInteract();

    public String GetItemName();

    public String GetItemEngineName();

    public String GetItemDescription();

    public String OnItemPutInBackpack();

    public String OnItemTakeOutBackpack();

    public String OnAttack();

    public boolean CanBeInBackpack();
}
