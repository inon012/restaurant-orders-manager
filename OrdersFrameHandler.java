import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JOptionPane;

/**
 * Represent handler for handling OrdersFrame actions/item state changes
 * 
 * @author Inon Cohen
 */
public class OrdersFrameHandler implements ActionListener, ItemListener {

	private OrdersFrame frame;

	public OrdersFrameHandler(OrdersFrame frame) {
		this.frame = frame;
	}

	public void itemStateChanged(ItemEvent e) {
		for (int i = 0; i < frame.getMenuPanel().getCheckBoxes().length; i++)
			if (e.getSource() == frame.getMenuPanel().getCheckBoxes()[i]) {
				frame.getMenuPanel().getAmountBoxes()[i]
						.setEnabled(!frame.getMenuPanel().getAmountBoxes()[i].isEnabled());
			}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == frame.getExitButton())
			System.exit(0);
		if (e.getSource() == frame.getOrderButton())
			confirmOrder();
	}

	/**
	 * ask for order confirmation and take action according to the answer
	 */
	private void confirmOrder() {
		Order order = new Order();

		// fill order with the chosen items
		for (int i = 0; i < frame.getMenuPanel().getCheckBoxes().length; i++)
			if (frame.getMenuPanel().getCheckBoxes()[i].isSelected()) {
				order.addItem(frame.getMenuPanel().getMenu().getItem(i),
						frame.getMenuPanel().getAmountBoxes()[i].getSelectedIndex() + 1);
			}

		if (order.getOrderItems().size() == 0) {
			JOptionPane.showMessageDialog(null, "You didn't pick any item!");
			return;
		}

		int ans = JOptionPane.showOptionDialog(null, order, null, 0, JOptionPane.INFORMATION_MESSAGE, null,
				Constants.TAKE_ORDER_BUTTONS, null);

		// take order
		if (ans == 0) {
			frame.setVisible(false);
			new ClientDetailsWindow(frame, order);
		}
		// cancel Order
		if (ans == 2)
			frame.startNewOrder();
	}

}
