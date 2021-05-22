package rooms;

import base.classes.BasicRoom;
import com.company.GamePlan;
import interfaces.IItem;
import items.CodeLock;

/*
 *  Třída Bridge - Odděděná od třídy BasicRoom. Slouží k vytvoření můstku.
 *  Obsahuje @Override OnItemUse
 *
 *
 *
 *  @author     Dan Šebek
 *  @version    0.01a
 *  @created    květen 2021
 */
public class Bridge extends BasicRoom {

    String modulConnectsTo;

    public Bridge(String roomName,String roomDescription,String modulConnectTo){
        super(roomName,roomDescription,"bridge");
        this.modulConnectsTo = modulConnectTo;
    }

    /**
     * Metoda vrátí text při použítí předmetu v místnosti, při použití karty přidá další místnost do herního plánu @Override
     *
     *@return Vrací text při použití předmětu v místnosti
     */
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
