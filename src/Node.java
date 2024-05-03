public class Node {

	// === FIELD VARIABLES === //
	private Node next;
	private Node fatNodes;
	private int data;
	private boolean isDeleted;

	// === CONSTRUCTOR === //
	public Node(int data) {
		this.next = null;
		this.fatNodes = null;
		this.data = data;
		this.isDeleted = false;
	}// end constructor

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getFatNodes() {
		return fatNodes;
	}

	public void setFatNodes(Node fatNodes) {
		this.fatNodes = fatNodes;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void delete() {
		this.isDeleted = true;
	}

	public void prependFatNodes(Node node) {
		node.setNext(fatNodes);
		fatNodes = node;
	}// end method

}// end class
