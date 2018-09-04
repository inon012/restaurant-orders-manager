/**
 * Represent a menu item
 * 
 * @author Inon Cohen
 */
public class Item {
	private String name;
	private int typeNum; // save type of the item
	private float price;

	/**
	 * Construct an item
	 * 
	 * @param name
	 *            name of the item
	 * @param typeNum
	 *            number type of the item
	 * @param price
	 *            price of the item
	 */
	public Item(String name, int typeNum, float price) {
		this.name = name;
		this.typeNum = typeNum;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getTypeNum() {
		return typeNum;
	}

	public float getPrice() {
		return price;
	}

}
