package rooms;

import base.classes.BasicRoom;
import com.company.UserInput;
import interfaces.IItem;

public class EscapeModul extends BasicRoom {

    String code;

    public EscapeModul(String roomName,String roomDescription,String code){
        super(roomName,roomDescription);
        this.code = code;
    }

    @Override
    public String OnItemInteract(IItem item){
        if(item.GetItemEngineName().equals("codelock")){
            System.out.print("Zadejte startovací kód: " );
            String enteredCode = UserInput.ReadUserInput();
            if(enteredCode.equals(code)){
                return "Připravte se ke startu. Prosím připoutejte se.";
            }else{
                return "Byl zadán špatný kód. Prosím akci opakujte.";
            }
        }else {
            return super.OnItemInteract(item);
        }
    }
}
