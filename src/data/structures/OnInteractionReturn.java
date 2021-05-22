package data.structures;

/*
 *  Třída OnInteractionReturn - Slouží jako datová struktura pro návrat z metod které interagují s předmět
 *
 *
 *
 *  @author     Dan Šebek
 *  @version    0.01a
 *  @created    květen 2021
 */
public class OnInteractionReturn {
    private boolean interactWithRoom;
    private String interactText;

    public OnInteractionReturn(boolean interactWithRoom, String interactText){
        this.interactWithRoom = interactWithRoom;
        this.interactText = interactText;

    }
    /**
     * Metoda vrátí příznak interactWithRoom
     *
     * @return Vrací příznak interactWithRoom
     */
    public boolean GetInteractWithRoom(){
        return interactWithRoom;
    }

    /**
     * Metoda vrátí text interactText
     *
     * @return Vrací text interactText
     */
    public String GetInteractText(){
        return interactText;
    }
}
