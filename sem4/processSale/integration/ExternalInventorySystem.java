package processSale.integration;

import processSale.model.Amount;
import java.util.ArrayList;

public class ExternalInventorySystem {

	private ArrayList<ItemDTO> inventory;

	/**
	 * Creates an instance of an external inventory system.
	 */
	public ExternalInventorySystem() {
		this.inventory = createInventory();
	}

	/**
	 * Finds an item in the inventory.
	 * @param itemIdentifier The identifier of the item.
	 * @return The item.
	 * @throws ItemNotFoundException If the item is not found in the inventory.
	 * @throws DatabaseFailureException If the database is not reachable.
	 */
	public ItemDTO findItem(int itemIdentifier) throws ItemNotFoundException, DatabaseFailureException{
		if (itemIdentifier == 666) {
			throw new DatabaseFailureException("Database failure, please try again.\n");
		}
		for (ItemDTO item : inventory) {
			if (item.getIdentifier() == itemIdentifier) {
				return item;
			}
		}
		throw new ItemNotFoundException("Item with identifier " + itemIdentifier + " not found.\n");
	}

	/**
	 * Updates the inventory.
	 * Unknown how the inventory updates, thus empty.
	 */
	public void updateInventory() {

	}

	/**
	 * Creates a list of items to be used as inventory.
	 */
	private ArrayList<ItemDTO> createInventory() {
		ArrayList<ItemDTO> inventory = new ArrayList<ItemDTO>();
		inventory.add(new ItemDTO(1, 1, new Amount(10), "Milk", "A carton of milk", 1.12));
		inventory.add(new ItemDTO(2, 1, new Amount(20), "Bread", "A loaf of bread", 1.06));
		inventory.add(new ItemDTO(3, 1, new Amount(30), "Butter", "A pack of butter", 1.06));
		inventory.add(new ItemDTO(4, 1, new Amount(40), "Cheese", "A block of cheese", 1.12));
		inventory.add(new ItemDTO(5, 1, new Amount(50), "Ham", "A pack of ham", 1.25));
		inventory.add(new ItemDTO(6, 1, new Amount(60), "Eggs", "A dozen eggs", 1.12));
		inventory.add(new ItemDTO(7, 1, new Amount(70), "Flour", "A bag of flour", 1.25));
		inventory.add(new ItemDTO(8, 1, new Amount(80), "Sugar", "A bag of sugar", 1.12));
		inventory.add(new ItemDTO(9, 1, new Amount(90), "Salt", "A bag of salt", 1.06));
		inventory.add(new ItemDTO(10, 1, new Amount(100), "Pepper", "A bag of pepper", 1.25));
		return inventory;
	}
}