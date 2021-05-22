package base.classes;

import data.structures.OnInteractionReturn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    Item cup = new Item("Hrnek","Obyčejný hrníček, asi z keramiky.","cup",true);
    @Test
    void onInspect() {
        assertEquals("Obyčejný hrníček, asi z keramiky.",cup.OnInspect());
    }

    @Test
    void onUse() {

        OnInteractionReturn temp = new OnInteractionReturn(false,cup.GetItemName() + ". Tohle asi nemá žádné využití.");
        assertEquals(temp,cup.OnUse());
    }

    @Test
    void onInteract() {
        OnInteractionReturn temp = new OnInteractionReturn(false, this.cup.GetItemName() + " s tím toho moc neudělám.");
        assertEquals(temp,cup.OnInteract());


    }

    @Test
    void getItemName() {
        assertEquals("Hrnek",cup.GetItemName());
    }

    @Test
    void getItemEngineName() {
        assertEquals("cup",cup.GetItemEngineName());
    }

    @Test
    void getItemDescription() {
        assertEquals("Obyčejný hrníček, asi z keramiky.",cup.GetItemDescription());
    }

    @Test
    void onItemPutInBackpack() {
        assertEquals("Hrnek jsi vložil do batohu.",cup.OnItemPutInBackpack());
    }

    @Test
    void onItemTakeOutBackpack() {
        assertEquals("Hrnek jsi vyndal z batohu.",cup.OnItemTakeOutBackpack());
    }

    @Test
    void onAttack() {
        assertEquals("Hrnek jsi rozmlátil na prach.",cup.OnAttack());
    }

    @Test
    void canBeInBackpack() {
        assertEquals(true,cup.CanBeInBackpack());
    }
}