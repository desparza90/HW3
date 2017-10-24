/** 
	A class implementing an ADT QUEUE using a single linked node
	@authoer Daniel Esparza
	@version 1.0
*/

public class DQue<T> implements DequeInterface<T>
{
	private Node head;	//pointer to beginning of line
	private Node tail;	//pointer to end of line
	
	
	public DQue()
	{
		head = null;
		tail = null;
	}
	/** Adds a new entry to the front of this dequeue. The new node is node(item, next)
    @param item  An object to be added. */
	public DQue(T item)
	{
		head = new Node(item, null);
		tail = head;	
	}
	
	/** Adds a new entry to the front of this dequeue.
    @param newEntry  An object to be added. */
	public void addToFront(T newEntry)
	{
		if (head == null)
		{
			head = new Node(newEntry, null);
			tail = head;
		}
		else 
		{
			Node node = new Node(newEntry, head);
			head = node;
		}
	}
	
	/** Adds a new entry to the back of this dequeue.
    @param newEntry  An object to be added. */
    public void addToBack(T newEntry)
	{
		if (head == null)
		{
			head = new Node(newEntry,null);
			tail = head;
		}
		else 
		{
			Node node = new Node(newEntry, null);
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
		//Delete data in NODE (for security)
		//Move tail to previous
		//ONLY IF there is a Node that Head is pointing to then move its next to null
		
		if(head != null)
		{
			T temp = head.data;
			head.data = null;
			if(head.next != null)
			{
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
		//Delete data in NODE (for security)
		//Move tail to previous by finding the previous node in do while loop
		
		if(tail != null)
		{
			Node TNode = head;
			T temp = tail.data;
			tail.data = null;
                        if (TNode.next != null)
                        {
                            while(TNode.next != tail)
                            {
                                TNode = head.next;
                            } 
                        }
			tail = TNode;
                        tail.next = null;
			return temp;
		}
		else
			throw new EmptyQueueException();
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
            head = head.next;
        }
        head = null;
        tail = null;
		
	}
	
}