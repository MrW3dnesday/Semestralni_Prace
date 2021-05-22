package base.classes;

import data.structures.OnInteractionReturn;
import interfaces.IItem;

/*
 *  Třída Item - Nadřazená třída všem předmětům. Implementuje rozhraní IItem. Slouží pro vytvoření předmětů bez rozšířené funkcionality.
 *  Obsahuje metody pro interakci s předmety.
 *
 *
 *
 *  @author     Dan Šebek
 *  @version    0.01a
 *  @created    květen 2021
 */
public class Item implements IItem {

    protected String itemEngineName;
    protected String itemName;
    protected String itemDescription;
    protected boolean canBeInBackpack;

    public Item(String itemName, String itemDescription,String itemEngineName, boolean canBeInBackpack){
        this.itemName = itemName;
        this.itemEngineName = itemEngineName;
        this.itemDescription = itemDescription;
        this.canBeInBackpack = canBeInBackpack;
    }


    /**
     * Metoda vrátí popis předmětu
     *
     *@return Vrací popis předmětu
     */
    @Override
    public String OnInspect() {
        return itemDescription;
    }

    /**
     * Metoda vrátí zda se předmět dá použít v místnosti a text při použití
     *
     *@return Vrací OnInteractionReturn
     */
    @Override
    public OnInteractionReturn OnUse() {
        OnInteractionReturn temp = new OnInteractionReturn(false,itemName + ". Tohle asi nemá žádné využití.");
        return temp;
    }

    /**
     * Metoda vrátí zda se předmět má interakci v místnosti a text při interakci
     *
     *@return Vrací OnInteractionReturn
     */
    @Override
    public OnInteractionReturn OnInteract(){
        OnInteractionReturn temp = new OnInteractionReturn(false, this.itemName + " s tím toho moc neudělám.");
        return temp;
    }

    /**
     * Metoda vrátí název předmětu
     *
     *@return Vrací název předmětu
     */
    @Override
    public String GetItemName(){
        return  itemName;
    }

    /**
     * Metoda vrátí název předmětu pro herní engine
     *
     *@return Vrací název předmětu pro herní engine
     */
    @Override
    public String GetItemEngineName(){
        return itemEngineName;
    }

    /**
     * Metoda vrátí popis předmětu
     *
     *@return Vrací popis předmětu
     */
    @Override
    public String GetItemDescription(){
        return itemDescription;
    }

    /**
     * Metoda vrátí připravený text při vložení do batohu
     *
     *@return Vrací připravený text při vložení do batohu
     */
    @Override
    public String OnItemPutInBackpack() {
        return itemName + " jsi vložil do batohu.";
    }

    /**
     * Metoda vrátí připravený text při vyjmutí z batohu
     *
     *@return Vrací připravený text při vyjmutí z batohu
     */
    @Override
    public String OnItemTakeOutBackpack(){
        return itemName +  " jsi vyndal z batohu.";
    }

    /**
     * Metoda vrátí připravený text při zaútočení na předmět
     *
     *@return Vrací připravený text při zaútočení na předmět
     */
    @Override
    public String OnAttack(){
        return  itemName + " jsi rozmlátil na prach.";
    }

    /**
     * Metoda vrátí zda předmět může být uložen do batohu
     *
     *@return Vrací zda předmět může být v batohu
     */
    @Override
    public boolean CanBeInBackpack(){
        return canBeInBackpack;
    }

}
