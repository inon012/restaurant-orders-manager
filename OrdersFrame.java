import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Represent a menu frame where you can take an order
 * 
 * @author Inon Cohen
 */
public class OrdersFrame extends JFrame {

	private MenuPanel menuPanel;

	private JButton orderButton;
	private JButton exitButton;

	private OrdersFrameHandler handler; 

	/**
	 * Construct a menu frame where you can take an order
	 * @param menu the menu to present
	 */
	public OrdersFrame(Menu menu) {
		super("OrdersManager");

		handler = new OrdersFrameHandler(this);
		menuPanel = new MenuPanel(menu, handler);

		// top area
		JPanel topPanel = new JPanel();
		JLabel menuLabel = new JLabel("Menu");
		topPanel.add(menuLabel);

		// bottom area
		JPanel bottomPanel = new JPanel();
		orderButton = new JButton("Order");
		exitButton = new JButton("Exit");
		orderButton.addActionListener(handler);
		exitButton.addActionListener(handler);
		bottomPanel.add(orderButton);
		bottomPanel.add(exitButton);

		add(menuPanel, BorderLayout.CENTER);
		add(topPanel, BorderLayout.NORTH);
		add(bottomPanel, BorderLayout.SOUTH);

		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Initialize and start new order
	 */
	public void startNewOrder() {
		setVisible(false);

		if (JOptionPane.showConfirmDialog(null, "Do you want to take an order?", null, JOptionPane.YES_NO_OPTION) != 0)
			System.exit(0);

		menuPanel.initialState();

		setVisible(true);
	}

	public MenuPanel getMenuPanel() {
		return menuPanel;
	}

	public JButton getOrderButton() {
		return orderButton;
	}

	public JButton getExitButton() {
		return exitButton;
	}
}
