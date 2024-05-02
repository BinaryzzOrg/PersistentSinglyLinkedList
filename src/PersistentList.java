public class PersistentList {

	// === FIELD VARIABLES === //
	private Node root;
	private Node tail;
	public static int length = 0;

	// === CONSTRUCTOR === //
	public PersistentList() {
		this.root = null;
		this.tail = null;
	}// end constructor

	// === LINKED LIST OPERATIONS === //
	public void append(int data) {
		Node node = new Node(data);
		if (root != null) {
			tail.setNext(node);
			tail = node;
		} else {
			root = node;
			tail = root;
		}
		length++;
	}// end method

	public void delete(int position) {
		if (length < 0) {
			System.out.println("Please append a value first.");
			return;
		}

		if (outOfBounds(position)) {
			System.out.println("Entered position is out of bounds, the range of position/s available are (0 to "
					+ (length - 1) + ").");
			return;
		}

		Node toDelete = search(position);

		if (toDelete != null) {
			toDelete.delete(); // sets deleted to true
			System.out.println(toDelete.getData() + " deleted.");
		}
		return;
	}// end method

	public void changeValue(int position, int value) {

		if (length < 0) {
			System.out.println("Please append a value first.");
			return;
		}

		if (outOfBounds(position)) {
			System.out.println("Entered position is out of bounds, the range of position/s available are (0 - "
					+ (length - 1) + ").");
			return;
		}

		Node toChange = search(position);
		if (toChange != null) {
			toChange.prependFatNodes(new Node(toChange.getData()));
			toChange.setData(value);
		}
		return;
	}// end method

	private Node search(int position) {

		if (length < 0) {
			System.out.println("Please append a value first.");
			return null;
		}

		if (outOfBounds(position)) {
			System.out.println("Entered position is out of bounds, the range of position/s available are (0 - "
					+ (length - 1) + ").");
			return null;
		}

		int counter = 0;
		Node currentNode = root;
		while (counter < length) {

			if (counter == position) {
				return (currentNode.isDeleted()) ? null : currentNode;
			}
			currentNode = currentNode.getNext();
			counter++;
		}

		System.out.println("The node does not exist.");
		return null;
	}// end method

	private boolean outOfBounds(int position) {
		return (position < 0 || position > length);
	}// end method

	public void display(int parameter) {
		Node currentNode = root;

		System.out.print("\nList: ");
		while (currentNode != null) {

			if (!currentNode.isDeleted() && parameter == 1)
				System.out.print(currentNode.getData() + " ");

			if (parameter == 2)
				System.out.print(currentNode.getData() + " ");

			currentNode = currentNode.getNext();
		} // end while
		System.out.println();
	}// end method

	public void nodeHistory(int position) {

		Node foundNode = search(position);

		if (foundNode != null) {
			System.out.print("\n[" + foundNode.getData() + "] - Modification History: ");

			if (foundNode.getFatNodes() != null) {

				Node fatNodeRoot = foundNode.getFatNodes();
				while (fatNodeRoot != null) {

					System.out.print(fatNodeRoot.getData() + " ");
					fatNodeRoot = fatNodeRoot.getNext();
				}
				System.out.println("\n");
			} else {
				System.out.print("[No History Record]\n");
			}

		} // end if
	}// end method

	public void listHistory() {
		display(2);
	}// end method

}// end class