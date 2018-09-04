import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Represent a window that take the client details for saving client order
 * 
 * @author Inon Cohen
 */
public class ClientDetailsWindow extends JFrame {

	private JTextField clientName; // field to write in client name
	private JTextField clientID; // field to write in client ID

	/**
	 * Construct a window that take the client details for saving client order
	 * 
	 * @param frame
	 *            previous order frame to call after saving the order
	 * @param order
	 *            the order to save
	 */
	public ClientDetailsWindow(OrdersFrame frame, Order order) {
		clientName = new JTextField(15);
		clientID = new JTextField(15);

		JButton ok = new JButton("OK");
		// anonymous action listener for the ok button
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				order.saveOrder(clientName.getText(), clientID.getText());
				JOptionPane.showMessageDialog(null, "We received your order.\nThanks!");
				setVisible(false);
				frame.startNewOrder();
			}
		});

		// ordering text fields on panel
		JPanel panel = new JPanel();

		GridLayout layout = new GridLayout(0, 2);
		panel.setLayout(layout);

		panel.add(new JLabel("Enter Name:"));
		panel.add(clientName);
		panel.add(new JLabel("Enter ID:"));
		panel.add(clientID);
		// end of ordering text fields

		add(panel, BorderLayout.CENTER);
		add(ok, BorderLayout.SOUTH);

		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
