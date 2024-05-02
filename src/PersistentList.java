
public class PersistentList {

	// === FIELD VARIABLES === //
	private Node root;
	private Node tail;
	private int length = 0;
	private int pLength = -1;

	// === GETTER SETTER === //
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
	/*
	 * append uses a tail to append nodes in O(1) time complexity, the if condition
	 * checks if the root is not equal to null if the root has nodes, append the new
	 * node to the tail of the list and adjust the tail variable to the newly
	 * appended node. Else set the new node as the root and also tail as the root
	 * since it is just the first node in the list.
	 */
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

	/*
	 * delete has a position parameter to indicate the position of the node in the
	 * list. Using the search method, if it finds a node on the specified position
	 * store it in the toDelete node. If the toDelete node is not equal to null set
	 * the stored node to deleted using the delete method in the node class then
	 * decrease the length.
	 */
	public void delete(int position) {
		Node toDelete = search(position);
		if (toDelete != null) {
			toDelete.delete(); // sets deleted to true
			System.out.println("\nNode [" + toDelete.getData() + "] was deleted.");
			--pLength;
		}
		return;
	}// end method

	/*
	 * ChangeValue method accepts to parameters, the node position to change and the
	 * value for replacement. It first identifies if the given position is a valid
	 * position within the list using the search method to find the node within that
	 * position if it finds nothing it stores null else it stores the node found.
	 * then the if condition if the toChange node is not null to avoid null
	 * exceptions. If it is not null prepend in the fat nodes of the node to be
	 * change the current value of the node then change its data to the new given
	 * value to record the changes.
	 */
	public void changeValue(int position, int value) {
		Node toChange = search(position);
		if (toChange != null) {
			toChange.prependFatNodes(new Node(toChange.getData()));
			toChange.setData(value);
		}
		System.out.println("\nChanged the Value of node[" + toChange.getFatNodes().getData() + "] to [" + toChange.getData() + "].");
		return;
	}// end method

	/*
	 * display method has a parameter to avoid the repetition of while printing of
	 * display and list history since there are only conditions that they differ in.
	 * If the given parameter is 1, it performs the normal display function where
	 * the deleted node is not included in the display of the list. If the parameter
	 * is 2 it performs the function of list history where it includes the deleted
	 * nodes of the list to be displayed in the console.
	 */
	public void display(int parameter) {
		Node currentNode = root;

		System.out.print((parameter == 1) ? "\nList: " : "\nList History: ");
		while (currentNode != null) {

			if (!currentNode.isDeleted() && parameter == 1)
				System.out.print(currentNode.getData() + " ");

			if (parameter == 2)
				System.out.print(currentNode.getData() + " ");

			currentNode = currentNode.getNext();
		} // end while
		System.out.println();
	}// end method

	/*
	 * nodeHistory first search for the node in the given position using the search
	 * method and stores it in the foundNode node. if the search method returns a
	 * node check its fat nodes if there are nodes stored in it. If there are, get
	 * its fat nodes and store it in the fatNodeRoot variable then traverse all of
	 * it until it reaches null to display all of the fat nodes of the node in the
	 * given specified position. Else just print that there is no history record of
	 * the given node position since there are no changes in that node/ no history.
	 */
	public void nodeHistory(int position) {
		Node foundNode = search(position);

		if (foundNode != null) {
			System.out.print("\nModification History of node[" + foundNode.getData() + "]: ");

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

	/*
	 * displays the listHistory by including the deleted nodes it uses the display
	 * function and parameter 2 to specify the list history condition for printing
	 * inside the while loop of the display method.
	 */
	public void listHistory() {
		display(2);
	}// end method

	/*
	 * The search method is used in various methods in this class as a helper of
	 * those methods. It first checks if the given position is out of bounds If true
	 * return null since there is node in the given position. Then in order to find
	 * the node in a given position it uses a counter to keep track of the current
	 * node position that traverses through the whole list to find the node. The
	 * while loop is not possible to get a null error because the given position is
	 * surely to be in the boundaries of the list because of the first if condition.
	 * The while loop has two if condition, the first one is for counting the number
	 * of deleted nodes in the list before the given position. The countDeleted is
	 * for avoiding deleted nodes and adjusting the given position for the counter
	 * to find the correct node since deleted nodes are just marked as tombstoned in
	 * the list. Furthermore, the second if condition checks if the counter reached
	 * the next not deleted node then returns the value if true. If the while loop
	 * finishes and no if condition is satisfied inside just return null and specify
	 * that the node does not exist in the list.
	 */
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

			if (counter == (position + countDeleted))
				return currentNode;

			currentNode = currentNode.getNext();
			counter++;
		}

		System.out.println("The node does not exist.");
		return null;
	}// end method

	// out of Bounds method returns true if the given position is within the list
	// length else return false
	public boolean outOfBounds(int position) {
		return (position < 0 || position > getLength());
	}// end method

}// end class
