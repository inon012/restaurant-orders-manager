/**
 * Represent an exception that occurs when an item is about to get an invalid
 * type
 * 
 * @author Inon Cohen
 */
public class ItemTypeException extends Exception {
	public ItemTypeException() {
		super();
	}

	public ItemTypeException(String s) {
		super(s);
	}
}
