package persistent.structures;

public class PersistentList {
	
	private Node root;
	private Node tail;
	private static int length = 0;
	
	public PersistentList() {
		this.root = null;
		this.tail = null;
	}

	public void append(int data) {
		Node node = new Node(data);
		if(root != null) {
			tail.setNext(node);
			tail = node;
		} else {
			root = node;
			tail = root;
		}
		length++;
	}
	
	public void delete(int position) {
		
		Node toDelete = search(position);
		
		if(toDelete != null) {
			toDelete.delete(); //sets deleted to true
			System.out.println(toDelete.getData() + " deleted.");
		} 
		return;
	}
	
	public void changeValue(int position, int value) {
		Node toChange = search(position);
		
		if(toChange != null) {
			toChange.prependFatNodes(new Node(toChange.getData()));	
			toChange.setData(value);
		} else {
			System.out.println("Message");
		}
		return;
	}
	
	private Node search(int position) {
		
		if(outOfBounds(position)) {
			System.out.println("\nPosition out of Bounds.");
			return null;
		}
		
		int counter = 0;
		int countDeleted = 0;
		Node currentNode = root;
		while(counter < length) {
			
			if(currentNode.isDeleted()) 
				countDeleted++;
			
			if(counter == (position + countDeleted)) {
				return (currentNode.isDeleted()) ? null : currentNode;
			}
			
			currentNode = currentNode.getNext();
			counter++;
		}
		
		System.out.println("\n\nThe node does not exist.");
		return null;
	}
	
	private boolean outOfBounds(int position) {
		return (position < 0 || position > length);
	}
	
	
	public void display(int parameter) {
		Node currentNode = root;
		
		System.out.println((parameter == 1) ? "\nList: " : "List History: ");
		while(currentNode != null) {
			
			if(!currentNode.isDeleted() && parameter == 1)
				System.out.print(currentNode.getData() + " ");
			
			if(parameter == 2)
				System.out.print(currentNode.getData() + " ");
			
			currentNode = currentNode.getNext();
		}
	}
	
	public void nodeHistory(int position) {
		System.out.println("Node History");
		Node foundNode = search(position);
		
		if(foundNode != null) {
			System.out.println("\n\n[" + foundNode.getData() + "] - Modification History: ");
			
			if(foundNode.getFatNodes() != null) {	
				
				Node fatNodeRoot = foundNode.getFatNodes();
				while(fatNodeRoot != null) {
					
					System.out.print(fatNodeRoot.getData() + " ");
					fatNodeRoot = fatNodeRoot.getNext();
				}
				System.out.println("\n");
			} else {
				System.out.println("[No History Record]\n");
			
			}
		}
	}
	
	public void listHistory() {
		display(2);
	}
}
