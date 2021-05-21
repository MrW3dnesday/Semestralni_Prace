package rooms;

import base.classes.BasicRoom;
import com.company.GamePlan;
import com.company.UserInput;
import interfaces.IItem;

public class EscapeModul extends BasicRoom {

    String code;

    public EscapeModul(String roomName,String roomDescription,String code){
        super(roomName,roomDescription,"modul");
        this.code = code;
    }

    @Override
    public String OnItemInteract(IItem item){
        if(item.GetItemEngineName().equals("codelock")){
            System.out.print("Zadejte startovací kód: " );
            String enteredCode = UserInput.ReadUserInput();
            if(enteredCode.equals(code)){
                GamePlan.run = false;
                return "Připravte se ke startu. Prosím připoutejte se." + "\n" + "Úspěšně se ti povedlo z lodi útéct.\nV jediné co doufáš, že na tu loď už nikdo nikdy nevstoupí.\nA že její tajemství v ní budou zapomenuta.";
            }else{
                return "Byl zadán špatný kód. Prosím akci opakujte.";
            }
        }else {
            return super.OnItemInteract(item);
        }
    }
}
