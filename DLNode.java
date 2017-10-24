public class DLNode
{
	<T> data;
	DLNode next;
	DLNode prev;
	
	public DLNode() {
		data = null;
		next = null;
		prev = null;
	}

	public DLNode(<T> newItem, DLNode nextN, DLNode prevN)
	{
		this.data = newItem;
		this.next = nextN;
		this.prev = prevN;
	
	}

}