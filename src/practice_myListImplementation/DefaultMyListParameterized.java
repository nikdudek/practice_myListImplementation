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
		private Object data;
		private Node<T> next;
		private Node<T> prev;
		
		public Node(Node<T> prev, Object data, Node<T> next) {
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
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIteratorParameterized<T> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(T e) {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(MyListParameterized<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

}
