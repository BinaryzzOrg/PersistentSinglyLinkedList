
public class PersistentList {

	// === FIELD VARIABLES === //
	private Node root;
	private Node tail;
	private int length = 0;
	private int pLength = -1;

	public int getLength() {
		return this.length;
	}

	public int getPlength() {
		return this.pLength;
	}

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
		pLength++;
	}// end method

	public void delete(int position) {

		Node toDelete = search(position);

		if (toDelete != null) {
			toDelete.delete(); // sets deleted to true
			System.out.println(toDelete.getData() + " deleted.");
			--pLength;
		}
		return;
	}// end method

	public void changeValue(int position, int value) {
		Node toChange = search(position);
		if (toChange != null) {
			toChange.prependFatNodes(new Node(toChange.getData()));
			toChange.setData(value);
		} else {
			System.out.println("Message");
		}

		return;
	}// end method

	private Node search(int position) {

		if (outOfBounds(position)) {
			System.out.println("\nPosition out of Bounds.");
			return null;
		}

		int counter = 0;
		int countDeleted = 0;
		Node currentNode = root;
		while (counter < length) {

			if (currentNode.isDeleted())
				countDeleted++;

			if (counter == (position + countDeleted)) {
				return (currentNode.isDeleted()) ? null : currentNode;
			}

			currentNode = currentNode.getNext();
			counter++;
		}

		System.out.println("The node does not exist.");
		return null;
	}// end method

	public boolean outOfBounds(int position) {
		return (position < 0 || position > getLength());
	}// end method

	public void display(int parameter) {
		Node currentNode = root;

		System.out.println((parameter == 1) ? "\nList: " : "\nList History: ");
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
		System.out.println("\nNode History");
		Node foundNode = search(position);

		if (foundNode != null) {
			System.out.println("\n\n[" + foundNode.getData() + "] - Modification History: ");

			if (foundNode.getFatNodes() != null) {

				Node fatNodeRoot = foundNode.getFatNodes();
				while (fatNodeRoot != null) {

					System.out.print(fatNodeRoot.getData() + " ");
					fatNodeRoot = fatNodeRoot.getNext();
				}
				System.out.println();
			} else {
				System.out.print("[No History Record]\n");
			}

		} // end if
	}// end method

	public void listHistory() {
		display(2);
	}// end method

}// end class