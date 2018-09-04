import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;

/**
 * Represent an order
 * 
 * @author Inon Cohen
 */
public class Order {
	private String clientName;
	private String clientID;

	private ArrayList<OrderItem> orderItems; // all items & amounts of the order

	public Order() {
		orderItems = new ArrayList<OrderItem>();
	}

	public ArrayList<OrderItem> getOrderItems() {
		return orderItems;
	}

	/**
	 * Add items to the order
	 * 
	 * @param item item to add
	 * @param amount item amount
	 */
	public void addItem(Item item, int amount) {
		orderItems.add(new OrderItem(item, amount));
	}

	/**
	 * Save an order details on file named by the client
	 * 
	 * @param clientName client name to be set
	 * @param clientID client ID to be set
	 */
	public void saveOrder(String clientName, String clientID) {
		this.clientName = clientName;
		this.clientID = clientID;

		try {
			Formatter output = new Formatter(clientName + ".txt");
			output.format(toString());
			output.close();
		} catch (FileNotFoundException exception) {
			System.err.println("ERROR: Could'nt save your order.");
		}
	}

	/**
	 * Return string representation of the order
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (clientName != null) {
			s.append("Client Name: " + clientName + "\r\n");
			s.append("Client ID: " + clientID + "\r\n");
			s.append("\r\n");
		}

		for (OrderItem item : orderItems) {
			s.append(item.getAmount() + "  " + item.getItem().getName() + "  "
					+ item.getItem().getPrice() * item.getAmount() + "¤\r\n");
		}
		return s.toString();
	}

}
