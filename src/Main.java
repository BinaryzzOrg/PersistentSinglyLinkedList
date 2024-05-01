import java.util.Scanner;

public class Main {
	// === FIELD VARIABLES === //
	private static PersistentList pList = new PersistentList();

	// === MAIN METHOD === //
	public static void main(String[] args) {
		Menu();
	}// end class

	/*
	 * The PrintMenuChoices method returns a formatted string for MainMenu. This
	 * formatted string is displayed to the user when they run the code for the
	 * first time. The method is also passed as a parameter to other methods that
	 * use the 'prompt' String.
	 */
	public static String printMenuChoices() {
		//@formatter:off
		String MenuChoicesAsString = "\n" 
				+ "{Persistent LinkedList MainMenu}\n" 
				+ "-=======================-\n"
				+ "| (1) : Append \n" 
				+ "| (2) : Delete \n" 
				+ "| (3) : Change Value \n" 
				+ "| (4) : Display \n" 
				+ "| (5) : Node History \n" 
				+ "| (6) : List History \n" 
				+ "| (7) : Exit \n" 
				+ "-=======================-\n"
				+ "Select an operation> ";
		//@formatter:on
		return MenuChoicesAsString;
	}// end method

	/*
	 * The MenuChoices method contains the following operations: Append, Delete,
	 * Change Value, Display, Node History, List History,and Exit. This method calls
	 * the PrintMenuChoices that prints out the choices for modifying the Persistent
	 * Singly LinkedList that is chosen by the user. MenuChoices method also handles
	 * miss inputs of the user and loops if it detects one.
	 */

	static Scanner sc;

	public static void Menu() {
		int pLenght = pList.length - 1;

		System.out.print(printMenuChoices());

		switch (checkUserInput(printMenuChoices())) {
		case 1: {// Append
			String promptAppend = "Enter a number to append: ";
			System.out.print(promptAppend);
			pList.append(checkUserInput(promptAppend));
			break;
		}
		case 2: {// Delete
			String promptPosition = "Enter the position of a node to be deleted ((0 - " + pLenght + "): ";
			System.out.print(promptPosition);
			pList.delete(checkUserInput(promptPosition));
			break;
		}
		case 3: {// Change Value
			// @formatter:off
			String promptPosition = "Enter the position of the node you want to modify (0 - " + pLenght + "): ";
			System.out.print(promptPosition);
			int nodePosition = checkUserInput(promptPosition);

			String promptError = "Entered position is out of bounds, the range of position/s available are (0 - " + pLenght + ")";
			if (nodePosition > pLenght) {
				System.out.println(promptError);
				break;
			}
			// @formatter:on

			String promptValue = "Enter a new value: ";
			System.out.print(promptValue);
			int replacementValue = checkUserInput(promptValue);

			pList.changeValue(nodePosition, replacementValue);
			break;
		}
		case 4: {// Display
			pList.display(1);
			// code
			break;
		}
		case 5: {// Node History
			String promptPosition = "Enter a position of the node you want to see the history (0 - " + pLenght + "): ";
			System.out.print(promptPosition);
			int nodePosition = checkUserInput(promptPosition);
			pList.nodeHistory(nodePosition);
			// code
			break;
		}
		case 6: {// List History
			pList.listHistory();
			// code
			break;
		}
		case 7: {// Delete
			System.out.println(":: Exiting now...");
			System.exit(0);
			break;
		}
		default:
			// @formatter:off
			System.out.println("\n" 
					+ "⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" 
					+ "┇ Error: \n"
					+ "┇ Input is not a valid Menu choice. \n"
					+ "⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" 
					+ "┇ Msg: \n"
					+ "┇ Please enter only 1 to 7 as input \n"
					+ "⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃");
			// @formatter:on
			break;
		}// end method
		Menu();
	}// end method

	/*
	 * The CheckUserInputMenu method scans the user's input and checks if it is an
	 * integer. If the input is an integer, it is stored in the 'value' variable and
	 * returns it. If the input is not an integer, an error message is displayed,
	 * and the user is prompted to enter an integer value. The 'prompt' parameter is
	 * used for different scenarios of printing.
	 */
	// TLDR - METHOD FOR DEALING WITH INTEGER INPUT
	public static int checkUserInput(String prompt) {
		sc = new Scanner(System.in);
		if (sc.hasNextInt()) {
			int value = sc.nextInt();
			return value;
		} // end if
		System.out.println(printCustomError("integer"));
		System.out.print(prompt);
		return checkUserInput(prompt);
	}// end if

	/*
	 * The printCustomError is exclusively used by checkUserInput, and
	 * checkUserInputMenu for printing their errors, but this method can by used by
	 * other methods if needed. This method has a parameter called 'type' for
	 * specify what data is needed be inputed on a method that calls this.
	 */
	public static String printCustomError(String type) {
		// @formatter:off
			return "\n" +
						"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
						"┇ Warning: Input is not a "+ type +" value. \n" +
						"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
						"┇ Notice: Please only enter a "+ type +" value.\n" +
						"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n";
		// @formatter:on
	}// end method

}// end class
