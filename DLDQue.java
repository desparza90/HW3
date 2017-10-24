/** 
	A class implementing an ADT QUEUE using a doubly linked node
	@authoer Daniel Esparza
	@version 1.0
*/

public class DLDQue<T> implements DequeInterface<T>
{
	private DLNode head;	//pointer to beginning of line
	private DLNode tail;	//pointer to end of line
	
	
	public DLDQue()
	{
		head = null;
		tail = null;
	}
	/** Adds a new entry to the front of this dequeue. The new node is node(item, next, prev)
    @param item  An object to be added. */
	public DLDQue(T item)
	{
		head = new DLNode(item, null, null);
		tail = head;	
	}
	
	/** Adds a new entry to the front of this dequeue.
    @param newEntry  An object to be added. */
	public void addToFront(T newEntry)
	{
		if (head == null)
		{
			head = new DLNode(newEntry, null, null);
			tail = head;
		}
		else 
		{
			DLNode node = new DLNode(newEntry, head, null);
			head.prev = node;
			head = node;
		}
	}
	
	/** Adds a new entry to the back of this dequeue.
    @param newEntry  An object to be added. */
    public void addToBack(T newEntry)
	{
		if (head == null)
		{
			head = new DLNode(newEntry, null, null);
			tail = head;
		}
		else 
		{
			DLNode node = new DLNode(newEntry, null, tail);
			tail.next = node;
			tail = node;
		}
	}
	
	/** Removes and returns the front entry of this dequeue.
    @return  The object at the front of the dequeue.
    @throws  EmptyQueueException if the dequeue is empty before the operation. */
    public T removeFront()
	{
		//Check if data is there if NOT throw exception
		//Hold data in temp variable
		//Delete data in DLNODE (for security)
		//Move tail to previous
		//ONLY IF there is a DLNode that Head is pointing to then move its next to null
		
		if(head != null)
		{
			T temp = head.data;
			head.data = null;
			if(head.next != null)
			{
				head.next.prev = null;
				head = head.next;
			}
			return temp;
		}
		else
			throw new EmptyQueueException();
	}
	
	/** Removes and returns the back entry of this dequeue.
    @return  The object at the back of the dequeue.
    @throws  EmptyQueueException if the dequeue is empty before the operation. */
    public T removeBack()
	{
		//Check if data is there if NOT throw exception
		//Hold data in temp variable
		//Delete data in DLNODE (for security)
		//Move tail to previous
		//ONLY IF there is a DLNode that tail is pointing to then move its next to null
		
		if(tail != null)
		{
			T temp = tail.data;
			tail.data = null;
			if(tail.prev != null)
			{
				tail.prev.next = null;
				tail = tail.prev;
			}
			return temp;
		}
		else
			throw new EmptyQueueException("Queue is empty, nothing to remove");
	}
	
	/** Retrieves the back entry of this dequeue.
    @return  The object at the back of the dequeue.
    @throws  EmptyQueueException if the dequeue is empty before the operation. */
    public T getFront()
	{
		return head.data;
	}
	
	/** Retrieves the back entry of this dequeue.
    @return  The object at the back of the dequeue.
    @throws  EmptyQueueException if the dequeue is empty before the operation. */
    public T getBack()
	{
		return tail.data;
	}
	
	/*  Detects whether this dequeue is empty.
    @return  True if the queue is empty, or false otherwise. */
	public boolean isEmpty()
	{
		if (head == null && tail == null)
			return true;
		else 
			return false;
	}
   
	/*  Removes all entries from this dequeue. */
	public void clear()
	{
		while(head.next != null){
			head.data = null;
			head.next.prev = null;
			head = head.next;
		}
                head = null;
                tail = null;
		
	}
	
}