package processSale.tests;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import processSale.model.Amount;
import processSale.integration.ItemDTO;


import static org.junit.Assert.*;

public class ItemDTOTest {




    @Test
    public void increaseQuantityTest() {
        ItemDTO reference = new ItemDTO(1, 1, new Amount(10), "Milk", "A carton of milk", 1.12);
        ItemDTO testItem = new ItemDTO(1, 1, new Amount(10), "Milk", "A carton of milk", 1.12);
        testItem.increaseQuantity();
        assertTrue("Increased inaccurately", testItem.getQuantity() == reference.getQuantity()+1);

    }

    @Test
    public void getFinalPriceTest() {
        ItemDTO testItem = new ItemDTO(1, 3, new Amount(10), "Milk", "A carton of milk", 1.12);
        Amount quantity = new Amount(3);
        Amount cost = new Amount(10);
        cost.multiply(quantity);
        assertEquals("price is correct", cost.getAmount(),testItem.getFinalPrice().getAmount(),0);

    }

}