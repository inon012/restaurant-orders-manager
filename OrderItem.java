/**
 * Represent order item (item + amount)
 * 
 * @author Inon Cohen
 */
public class OrderItem {
	private Item item;
	private int amount;

	/**
	 * Construct order item according to the given parameters
	 * 
	 * @param item the chosen item
	 * @param amount the chosen amount
	 */
	public OrderItem(Item item, int amount) {
		this.item = item;
		this.amount = amount;
	}

	public Item getItem() {
		return item;
	}

	public int getAmount() {
		return amount;
	}
}
