package data.structures;

public class OnUseReturn {
    private boolean interactWithRoom;
    private String interactText;

    public OnUseReturn(boolean interactWithRoom,String interactText){
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
