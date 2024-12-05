package practice_myListImplementation;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Doubly-linked list implementation of the MyList interface.  
 *
 * All of the operations perform as could be expected for a doubly-linked
 * list.  Operations that index into the list will traverse the list from
 * the beginning or the end, whichever is closer to the specified index.
 * 
 * @author Andrii Piatakha
 *
 */

public class DefaultMyListParameterized<T> implements MyListParameterized<T>, ListIterableParameterized<T> {
	
	private Node<T> first;
	private Node<T> last;
	private int size;

	private static class Node<T> {
		private T data;
		private Node<T> next;
		private Node<T> prev;
		
		public Node(Node<T> prev, T data, Node<T> next) {
			this.next = next;
			this.prev = prev;
			this.data = data;
		}
			
		@Override
		public String toString() {
			return data.toString();
		}
	}
	
	@Override
	public void add(T e) {
		final Node<T> lastNode = last;
	    final Node<T> newNode = new Node<>(lastNode, e, null);
	    last = newNode;
	    if (lastNode == null) {
	        first = newNode;
	    } else {
	        lastNode.next = newNode;
	    }
	    
	    size++;
	}

	@Override
	public void clear() {
		for( Node<T> x = first ; x != null ; ) {
			Node<T> nextNode = x.next;
			x.data = null;
			x.prev = null;
			x.next = null;
			x = nextNode;
		}
		this.first = null;
		this.last = null;
		this.size = 0;
	}

	@Override
	public boolean remove(Object o) {
	    Node<T> targetNode = first;
	    if(targetNode == null) {
            return false;
    }
	    while(targetNode.data != o) {
	        targetNode = targetNode.next;
	    }
	    if(targetNode.prev != null)
	        targetNode.prev.next = targetNode.next;
        if(targetNode.next != null)
	        targetNode.next.prev = targetNode.prev;
        targetNode.next = null;
	    targetNode.prev = null;
	    targetNode.data = null;
	    size--;
	    return true;
	}

	@Override
	public Object[] toArray() {
	    if(size == 0)
	        return null;
	    Object[] arrayOfAllObjects = new Object[size];
	    Node<T> targetNode = first;
	    for(int i = 0 ; i < size ; i++) {
	        arrayOfAllObjects[i] = targetNode.data;
	        targetNode = targetNode.next;
	    }
	    return arrayOfAllObjects;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean contains(Object o) {
	    Node<T> targetNode = first;
	    if(targetNode == null) {
            return false;
    }
	    while(targetNode != null) {
        	if (targetNode.data == o ) {
        		return true;
        	} else {
        		targetNode = targetNode.next;
        	}
        }
	    return false;
	}

	@Override
	public boolean containsAll(MyListParameterized<?> c) {
	    Object[] targetArray = c.toArray();
	    Object[] localArray = this.toArray();
	    if(localArray.length == 0) {
            return false;
        }
	    
	    int localArrayTargetNumber = 0;
	    for(int i = 0 ; i < targetArray.length ; i++)
	    	while (true) {
		    	if (targetArray[i] == localArray[localArrayTargetNumber]) {
		    		localArrayTargetNumber = 0;
		    		break;
		    	} else {
		    		localArrayTargetNumber++;
		    		if (localArrayTargetNumber == targetArray.length) {
		    			return false;
		    		}
		    	}
		    }
	    return true;
	}
	
	public T removeNodeByIndex(int index) {
		return unlink(getNodeByIndex(index));
	}
	
	T unlink(Node<T> element) {
		T obj = element.data;
		Node<T> next = element.next;
		Node<T> previous = element.prev;
			
		if (previous == null) {
			first = next;
		} else {
			previous.next = next;
			element.prev = null;
		}
		if (next == null) {
			last = previous;
		} else {
			next.prev = previous;
			element.next = null;
		}
			
		element.data = null;
		size--;
		return obj;	
	}
	
	public Node<T> getNodeByIndex(int index) {
		if (index > (size -1)) {
			return null;
		}
		
		if (index < (size >> 1)) {
            Node<T> x = first;
            for (int i = 0; i < index; i++) {
				x = x.next;
			}
            return x;
        } else {
            Node<T> x = last;
            for (int i = size - 1; i > index; i--) {
				x = x.prev;
			}
            return x;
        }
	}
	
	private class ListIteratorImplParameterized<T> extends IteratorImpl<T> implements ListIteratorParameterized<T> {

		@Override
		public boolean hasPrevious() {
			return cursor != 0;
		}

		@Override
		public T previous() {
		    cursor -= 1;
		    Node<T> prev = (Node<T>)getNodeByIndex(cursor);
		    if (prev == null) {
		        throw new NoSuchElementException();
		    }
		    lastRet = cursor;
		    return prev.data;
		}

		@Override
		public void set(T e) {
			if (lastRet == -1) {
		        throw new IllegalStateException();
		    }
		    
		    Node<T> targetNode = (Node<T>)DefaultMyListParameterized.this.getNodeByIndex(lastRet);
		    targetNode.data = e;
		    
		    lastRet = -1;
		}
	}
	
	private class IteratorImpl<T> implements Iterator<T> {
		
		int cursor = 0;
		int lastRet = -1;

		@Override
		public boolean hasNext() {
			return cursor != size;
		}

		@Override
		public T next() {
		    Node<T> next = (Node<T>)getNodeByIndex(cursor);
		    if (next == null) {
		        throw new NoSuchElementException();
		    }
		    lastRet = cursor;
		    cursor += 1;
		    return next.data;
		}
		
		@Override
		public void remove() {
			if (lastRet == -1) {
		        throw new IllegalStateException();
		    }
		    
		    DefaultMyListParameterized.this.removeNodeByIndex(lastRet);
		    if (lastRet < cursor) {
		        cursor--;
		    }
		    
		    lastRet = -1;
		}
	}
	
	@Override
	public Iterator<T> iterator() {
		return new ListIteratorImplParameterized<>();
	}
	
	@Override
	public ListIteratorParameterized<T> listIterator() {
		return new ListIteratorImplParameterized<>();
	}
}
