package data.structures;

public class OnInteractionReturn {
    private boolean interactWithRoom;
    private String interactText;

    public OnInteractionReturn(boolean interactWithRoom, String interactText){
        this.interactWithRoom = interactWithRoom;
        this.interactText = interactText;

    }



    public boolean GetInteractWithRoom(){
        return interactWithRoom;
    }
    public String GetInteractText(){
        return interactText;
    }
}
