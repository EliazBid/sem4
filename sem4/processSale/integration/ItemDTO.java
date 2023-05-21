package processSale.integration;

import processSale.model.Amount;

public class ItemDTO {

	private int itemIdentifier;

	private int quantity;

	private Amount price;

	private String name;

	private double vatRate;

	/**
	 * Creates an instance of an item.
	 * @param itemIdentifier The identifier of the item.
	 * @param quantity The quantity of the item.
	 * @param price The price of the item.
	 * @param name The name of the item.
	 * @param description The description of the item.
	 * @param vatRate The vat rate of the item.
	 */
	public ItemDTO(int itemIdentifier, int quantity, Amount price, String name, String description, double vatRate) {
		this.itemIdentifier = itemIdentifier;
		this.quantity = quantity;
		this.price = price;
		this.name = name;
		this.vatRate = vatRate;
	}

	/**
	 * Increases the quantity of the item.
	 */
	public void increaseQuantity() {
		quantity++;
	}

	/**
	 * Checks if the item is valid.
	 */
	public int getIdentifier() {
		return this.itemIdentifier;
	}

	/**
	 * Returns the quantity of the item.
	 */
	public int getQuantity() {
		return this.quantity;
	}

	/**
	 * Returns the price of the item.
	 */
	public Amount getPrice() {
		return this.price;
	}

	/**
	 * Returns the name of the item.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Returns the vat rate of the item.
	 */
	public double getVAT() {
		return this.vatRate;
	}

	/**
	 * Returns the price for the item multiplied with its quantity.
	 */
	public Amount getFinalPrice() {
		Amount quan = new Amount(quantity);
		Amount priceOfItems = new Amount(price.getAmount());
		priceOfItems.multiply(quan);
		return priceOfItems;
	}

}
