package base.classes;

import com.company.GamePlan;
import com.company.Mimic;
import com.company.Player;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class MimicTest {

    GamePlan gamePlan = new GamePlan();


    @org.junit.jupiter.api.Test
    void OnMoveAndChangeFormTest(){
        gamePlan.NUnitINIT();

        Mimic mimic = new Mimic("MIMIC","MIMIC",GamePlan.generatedRooms.get("entry"));
        GamePlan.mimics.add(mimic);

        mimic.OnMove();

        if(!mimic.currentRoom.roomEngineName.equals("entry") && !mimic.itemName.equals("MIMIC")){
            return;
        }else{
            Assertions.fail();
        }
    }
    @org.junit.jupiter.api.Test
    void OnInspectAndPutInTest(){
        gamePlan.NUnitINIT();

        Mimic mimic = new Mimic("MIMIC","MIMIC",GamePlan.generatedRooms.get("entry"));

        mimic.OnInspect();

        if(GamePlan.GetPlayer().GetWasAttacked()) {
            GamePlan.GetPlayer().Heal();
            mimic.OnInteract();
            if (GamePlan.GetPlayer().GetWasAttacked()) {
                GamePlan.GetPlayer().Heal();
                mimic.OnItemPutInBackpack();
                if (GamePlan.GetPlayer().GetWasAttacked()) {
                    return;
                }
            }
        }
        Assertions.fail();
    }
}
