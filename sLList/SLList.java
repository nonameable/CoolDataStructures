package sLList;
/*
 * Class that defines the structure of a Single Linked List
 */

public class SLList {
	
	//instance variables.
	NodeSLL head;
	NodeSLL tail;
	int size;
	
	// methods
	
	public NodeSLL push ( int pValue)
	{
		NodeSLL newNode  = new NodeSLL(pValue);
		newNode.next = head;
		head = newNode;
		if (size == 0)
			tail  = newNode;
		size = size +1;
		return newNode; // should it return something?
	}
	
	public NodeSLL pop ()
	{
		
		if (size == 0) // checks if the list is empty
			return null; 
		else
		{
			NodeSLL toReturn = head;
			head  = head.next;
			size = size - 1;
			if (size == 0) // of there was only one element, the size must be now zero and the tail obviously has to be null
				tail  = null; 
			return toReturn;
		}
		
	}
	
	public boolean add (int pValue)
	{
		NodeSLL newNode = new NodeSLL(pValue);
		tail.next = newNode;
		if (size == 0) // if the list is empty, then the one we want to add has to be the head too.
			head = newNode;
		else			// if the list is not empty, that means me can say that the next element of the current tail is goign tobe the newNode
			tail.next = newNode;
		tail = newNode; // 
		size = size + 1;
		return true;
	}
	
	/*
	 *  you have to be careful, because if the element you want to eliminate is the tail, you cannot simply
	 *  eliminate it, you only have to change the next variable of the previous one. 
	 */

	public boolean remove (int position) 
	{
		boolean isGone = false;
		int index  = 0;
		NodeSLL current  = head;
		while(index < position && !isGone)
		{
			if (index == position - 1)
			{
				NodeSLL toEliminate = current.next;
				if (toEliminate == tail) // it may be equals, I don't know now
				{
					current.next = null;
					tail = current;
				}
				else
				{
					current.next = toEliminate.next;
				}
				isGone = true;

				
			}else
			{
				current  = current.next;
			}
			index = index + 1;
		}
		size = size -1;
		return isGone;
		
	}
	/*
	 * This method works everywhere except the head and the tail; in order to insert values there you must use add or push 
	 */
	public boolean insert (int position, int pValue)
	{
		boolean inserted  = false;
		NodeSLL newNode =  new NodeSLL (pValue);
		int index  = 0;
		NodeSLL current  = head;
		while (index < position && !inserted)
		{
			if (index  == position -1 )
			{
				NodeSLL nodeFollowing = current.next;
				current.next = newNode;
				newNode.next = nodeFollowing;
				size = size + 1;
				inserted = true;
			}
			else
			{
				current  = current.next;
			}
			index  = index + 1;
		}
		
		
		return inserted;
	}
	// comment 3
}
