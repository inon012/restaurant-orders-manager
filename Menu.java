import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Represent a menu
 * 
 * @author Inon Cohen
 */
public class Menu {
	private ArrayList<Item>[] items; // items of the menu by categories

	/**
	 * Construct a menu from a formatted menu file
	 * 
	 * @param fileName
	 *            name of the formatted menu file
	 */
	public Menu(String fileName) {

		// initial item list by category
		items = new ArrayList[Constants.TYPES.length];

		for (int i = 0; i < Constants.TYPES.length; i++)
			items[i] = new ArrayList<Item>();

		Scanner input;

		// reading the file
		try {
			input = new Scanner(new File(fileName));
			while (input.hasNext()) {
				addItem(input);
			}
			input.close();
		} catch (FileNotFoundException exception) {
			System.err.println("ERROR: 'menu.txt' No such file");
			System.exit(1);
		}catch (Exception exception) {
			System.err.println("ERROR: 'menu.txt' No such file");
			System.exit(1);
		}
	}

	/**
	 * Add item to menu with parameters from the input file
	 * 
	 * @param input the input where we take the item parameters from
	 */
	private void addItem(Scanner input) {
		String name;
		int typeNum;
		float price;

		try {
			do {
				name = input.nextLine();
			} while (name.isEmpty()); // skipping empty lines in the input
			typeNum = typeNum(input.nextLine());
			price = Float.parseFloat(input.nextLine());

			items[typeNum].add(new Item(name, typeNum, price));

		} catch (NoSuchElementException exception) {
			System.err.println("ERROR: 'menu.txt' Does not follow the input format");
			System.exit(1);
		} catch (ItemTypeException exception) {
			System.err.println("ERROR: Couldn't figure out item's type ");
			System.exit(1);
		} catch (NumberFormatException exception) {
			System.err.println("ERROR: Couldn't figure out item's price");
			System.exit(1);
		}
	}

	/**
	 * Figure out the type number according to the type name
	 * 
	 * @param type the type name
	 * @return the type number
	 * @throws ItemTypeException when the type name is invalid
	 */
	private int typeNum(String type) throws ItemTypeException {
		for (int i = 0; i < Constants.TYPES.length; i++)
			if (Constants.TYPES[i].equalsIgnoreCase(type))
				return i;
		throw new ItemTypeException();
	}

	/**
	 * Return menu item by index
	 * 
	 * @param index index of the item
	 * @return menu item according to the given index
	 */
	public Item getItem(int index) {
		int i = 0;
		while (index >= items[i].size()) {
			index -= items[i].size();
			i++;
		}
		return items[i].get(index);
	}

	/**
	 * Return menu size (how much items in the menu)
	 * 
	 * @return menu size
	 */
	public int size() {
		int size = 0;
		for (int i = 0; i < Constants.TYPES.length; i++)
			size += items[i].size();
		return size;
	}

	public ArrayList<Item>[] getItems() {
		return items;
	}

}
