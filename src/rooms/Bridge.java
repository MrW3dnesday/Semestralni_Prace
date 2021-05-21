package rooms;

import base.classes.BasicRoom;
import com.company.GamePlan;
import interfaces.IItem;
import items.CodeLock;

public class Bridge extends BasicRoom {

    String modulConnectsTo;

    public Bridge(String roomName,String roomDescription,String modulConnectTo){
        super(roomName,roomDescription,"bridge");
        this.modulConnectsTo = modulConnectTo;
    }

    @Override
    public String OnItemUse(IItem item){
        if(item.GetItemEngineName().equals("keycard")){
            EscapeModul escapeModul = new EscapeModul("Modul","Vypadá to, že tohle bude moje cesta domů.","2021");
            CodeLock codeLock = new CodeLock("Zámek","Vypadáto na to, že sem můžu zadat nějaký kód.");
            BasicRoom connects = GamePlan.generatedRooms.get(modulConnectsTo);
            escapeModul.AddItemInRoom(codeLock);
            escapeModul.AddConnectedRoom(connects);
            connects.AddConnectedRoom(escapeModul);
            return "Otevřeli se dveře do únikového modulu.";
        }else{
            return super.OnItemUse(item);
        }
    }

}
