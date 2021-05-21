package base.classes;

import com.company.GamePlan;
import com.company.Mimic;
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
}
