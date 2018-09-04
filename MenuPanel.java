import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Represent Menu Panel for ordering
 * 
 * @author Inon Cohen
 */
public class MenuPanel extends JPanel {

	private Menu menu;

	private JComboBox amountBoxes[]; // combo box for each menu item
	private JCheckBox checkBoxes[]; // check box for each menu item

	public MenuPanel(Menu newMenu, OrdersFrameHandler handler) {
		menu = newMenu;

		setLayout(new GridBagLayout());
		GridBagConstraints gridBagCons = new GridBagConstraints();

		int menuSize = menu.size();
		int currentType = 0;
		JLabel typeLabel;

		// initialize the amounts of combo and check boxes
		amountBoxes = new JComboBox[menuSize];
		checkBoxes = new JCheckBox[menuSize];

		int i = 0;

		// fill menu items on the panel. (for each item - name, price, check box, combo
		// box)
		while (i < menuSize) {
			// adding category headers
			typeLabel = new JLabel(Constants.TYPES[currentType]);
			typeLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
			gridBagCons.gridy = i + currentType;
			gridBagCons.gridx = 0;
			add(typeLabel, gridBagCons);// end of adding category headers

			for (int j = 0; j < menu.getItems()[currentType].size(); j++, i++) {
				amountBoxes[i] = new JComboBox(Constants.AMOUNTS);
				amountBoxes[i].setEnabled(false);
				checkBoxes[i] = new JCheckBox();
				checkBoxes[i].addItemListener(handler);

				gridBagCons.gridy = i + currentType + 1;

				gridBagCons.gridx = 1;
				add(new JLabel(String.format("    %-30s", menu.getItem(i).getName())), gridBagCons);
				gridBagCons.gridx++;
				add(new JLabel(String.format("%.1f¤", menu.getItem(i).getPrice())), gridBagCons);
				gridBagCons.gridx++;
				add(checkBoxes[i], gridBagCons);
				gridBagCons.gridx++;
				add(amountBoxes[i], gridBagCons);
			}
			currentType++;
		}

	}

	/**
	 * return all the check and combo boxes to their initial state
	 */
	public void initialState() {
		for (int i = 0; i < checkBoxes.length; i++) {
			amountBoxes[i].setSelectedIndex(0);
			checkBoxes[i].setSelected(false);
		}
	}

	public Menu getMenu() {
		return menu;
	}

	public JComboBox[] getAmountBoxes() {
		return amountBoxes;
	}

	public JCheckBox[] getCheckBoxes() {
		return checkBoxes;
	}
}
