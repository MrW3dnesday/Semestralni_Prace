package interfaces;

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

    public String OnUse();

    public String OnPutInBackpack();

    public String OnTakeOutBackpack();

    public String GetItemName();
}
