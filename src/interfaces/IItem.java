package interfaces;

import data.structures.OnInteractionReturn;

/*
 *  Rozhraní IItem - Rozhraní pro interakci s předměty
 *
 *
 *
 *  @author     Dan Šebek
 *  @version    0.01a
 *  @created    květen 2021
 */
public interface IItem {

    /**
     * Metoda pro provedení akce při prohlížení předmětu
     *
     * @return Vrací předpřipravený text při prohlédnutí předmětu
     */
    public String OnInspect();


    /**
     * Metoda pro provedení akce při použití předmětu
     *
     * @return Vrací předpřipravený text při použití předmětu
     */
    public OnInteractionReturn OnUse();

    /**
     * Metoda pro provedení akce při interakci s předmětem
     *
     * @return Vrací předpřipravený text při použití předmětu
     */
    public OnInteractionReturn OnInteract();

    /**
     * Metoda vrátí název předmětu
     *
     * @return Vrací název předmetu
     */
    public String GetItemName();

    /**
     * Metoda vrátí název předmětu pro herní engine
     *
     * @return Vrací název předmetu pro herní engine
     */
    public String GetItemEngineName();

    /**
     * Metoda vrátí popis předmětu
     *
     * @return Vrací popis předmetu
     */
    public String GetItemDescription();

    /**
     * Metoda pro provedení akce při vložení předmětu do batohu
     *
     * @return Vrací předpřipravený text při vložení předmětu do batohu
     */
    public String OnItemPutInBackpack();

    /**
     * Metoda pro provedení akce při vyndání předmětu z batohu
     *
     * @return Vrací předpřipravený text při vyndání předmětu z batohu
     */
    public String OnItemTakeOutBackpack();

    /**
     * Metoda pro provedení akce při útoku na předmět
     *
     * @return Vrací předpřipravený text při útoku na předmět
     */
    public String OnAttack();

    /**
     * Metoda vrátí příznak zda předmět může být v batohu
     *
     * @return Vrací příznak zda může být předmět v batohu
     */
    public boolean CanBeInBackpack();
}
