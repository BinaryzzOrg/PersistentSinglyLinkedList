
public class Node {

	// === FIELD VARIABLES === //
	private int data;
	private Node next;

	// === CONSTRUCTOR === //
	public Node(int data) {
		setData(data);
		setNext(null);
	}// end constructor

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}// end class
