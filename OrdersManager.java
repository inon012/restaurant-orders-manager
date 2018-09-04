/**
 * Run Order Manager app
 * 
 * @author Inon Cohen
 */
public class OrdersManager {

	public static void main(String[] args) {

		String menuFile = "menu.txt";

		OrdersFrame frame = new OrdersFrame(new Menu(menuFile));

		frame.startNewOrder();

	}
}
