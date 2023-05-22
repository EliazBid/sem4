package processSale.tests;

import processSale.view.*;
import processSale.model.*;
import processSale.controller.*;
import processSale.integration.*;
import processSale.integration.ItemNotFoundException;
import processSale.integration.DatabaseFailureException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;




/**
 * tests both the ItemNotFoundException and the DatabaseFailureException using the findItem function in ExternalInventorySystem as both exceptions are thrown there.
 * The ItemNotFoundException should be thrown when the itemIdentifier is not between 1-10.
 * The DatabaseFailureException should be thrown when the itemIdentifier is 666.
 */

public class ExceptionTests {
    
    @BeforeEach
    public void setUp() {
        ExternalInventorySystem inventory = new ExternalInventorySystem();
    }

    @AfterEach
    public void tearDown() {
        ExternalInventorySystem inventory = null;
    }


    @Test
    public void testItemNotFoundException() {
        int validItemIdentifier;
        for (validItemIdentifier = 1; validItemIdentifier <= 10; validItemIdentifier++)
        try{
            ExternalInventorySystem inventory = new ExternalInventorySystem();
            inventory.findItem(validItemIdentifier);
        } 
        catch(ItemNotFoundException e){
            fail("Test should have passed.");
        }
        catch(DatabaseFailureException e){
            fail("Test should have passed.");
        }
    }

    @Test
    public void testItemNotFoundExceptionIDZero() {
        int invalidItemIdentifier = 0;
        try{
            ExternalInventorySystem inventory = new ExternalInventorySystem();
            inventory.findItem(invalidItemIdentifier);
            fail("ItemNotFoundException should have been thrown.");
        } 
        catch(ItemNotFoundException e){
            assertEquals(e.getMessage(),"Item with identifier " + invalidItemIdentifier + " not found.");
        }
        catch(DatabaseFailureException e){
            fail("ItemNotFoundException should have been thrown.");
        }
    }

    @Test
    public void testItemNotFoundExceptionIDNegative() {
        int invalidItemIdentifier = -10;
        try{
            ExternalInventorySystem inventory = new ExternalInventorySystem();
            inventory.findItem(invalidItemIdentifier);
            fail("ItemNotFoundException should have been thrown.");
        } 
        catch(ItemNotFoundException e){
            assertEquals(e.getMessage(),"Item with identifier " + invalidItemIdentifier + " not found.");
        }
        catch(DatabaseFailureException e){
            fail("ItemNotFoundException should have been thrown.");
        }
    }

    @Test
    public void testItemNotFoundExceptionIDHigher() {
        int invalidItemIdentifier = 11;
        try{
            ExternalInventorySystem inventory = new ExternalInventorySystem();
            inventory.findItem(invalidItemIdentifier);
            fail("ItemNotFoundException should have been thrown.");
        } 
        catch(ItemNotFoundException e){
            assertEquals(e.getMessage(),"Item with identifier " + invalidItemIdentifier + " not found.");
        }
        catch(DatabaseFailureException e){
            fail("ItemNotFoundException should have been thrown.");
        }
    }

    @Test
    public void testDatabaseFailureException() {
        int invalidItemIdentifier = 666;
        try{
            ExternalInventorySystem inventory = new ExternalInventorySystem();
            inventory.findItem(invalidItemIdentifier);
            fail("DatabaseFailureException should have been thrown.");
        } 
        catch(ItemNotFoundException e){
            fail("DatabaseFailureException should have been thrown.");
        }
        catch(DatabaseFailureException e){
            assertEquals(e.getMessage(),"Database not reached, check database status.");
        }
    }
}
