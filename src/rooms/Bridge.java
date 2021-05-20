package rooms;

import base.classes.BasicRoom;
import interfaces.IItem;
import items.CodeLock;

public class Bridge extends BasicRoom {
    public Bridge(String roomName,String roomDescription){
        super(roomName,roomDescription);
    }

    @Override
    public String OnItemUse(IItem item){
        if(item.GetItemEngineName().equals("keycard")){
            EscapeModul escapeModul = new EscapeModul("Modul","Vypadá to, že tohle bude moje cesta domů.","2021");
            CodeLock codeLock = new CodeLock("Zámek","Vypadáto na to, že sem můžu zadat nějaký kód.");
            escapeModul.AddItemInRoom(codeLock);
            escapeModul.AddConnectedRoom(this);
            this.AddConnectedRoom(escapeModul);
            return "Otevřeli se dveře do únikového modulu.";
        }else{
            return super.OnItemUse(item);
        }
    }

}
