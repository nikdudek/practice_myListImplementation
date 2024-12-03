package practice_myListImplementation;

import java.util.Iterator;

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

	public DefaultMyListParameterized() {
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub

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
