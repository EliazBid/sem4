package processSale.model;

public class Amount {

    private double amount;

    /**
     * Creates an instance of an amount.
     * @param amount The amount.
     */
    public Amount(double amount) {
        this.amount = amount;
    }

    /**
     * Adds an amount to the current amount.
     * @param amount The amount to add.
     */
    public void add(Amount amount) {
        this.amount += amount.amount;
    }

    /**
     * Subtracts an amount from the current amount.
     * @param amount The amount to subtract.
     */
    public void subtract(Amount amount) {
        this.amount -= amount.amount;
    }

    /**
     * Multiplies the current amount with another amount.
     * @param amount The amount to multiply with.
     */
    public void multiply(Amount amount) {
        this.amount *= amount.amount;
    }

    /**
     * Returns the current amount.
     * @return The current amount.
     */
    public double getAmount() {
        return this.amount;
    }

    /**
     * Returns the current amount as a string.
     * @return The current amount as a string.
     */
    public String toString() {
        return Double.toString(amount);
    }

    /**
     * Checks if the current amount is equal to another amount.
     * @param amount The amount to check against.
     * @return True if the amounts are equal, false if not.
     */
    public boolean equals(Amount amount) {
        return this.amount == amount.amount;
    }

}
