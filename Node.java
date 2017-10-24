public class Node
{
	<T> data;
	Node next;
	
	public Node() {
		data = null;
		next = null;
	}

	public Node(<T> newItem, Node nextN)
	{
		this.data = newItem;
		this.next = nextN;
	}

}