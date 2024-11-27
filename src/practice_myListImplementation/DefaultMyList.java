package practice_myListImplementation;

public class DefaultMyList implements MyList {

	private Node first;
	private Node last;
	private int size;
	
	private static class Node {
		private Object data;
		private Node next;
		private Node prev;
		
		public Node(Node prev, Object data, Node next) {
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
	public void add(Object e) {
	    final Node lastNode = last;
	    final Node newNode = new Node(lastNode, e, null);
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
	    Node targetNode = last;
	    while (targetNode != null) {
	        last = targetNode.prev;
	        targetNode.next = null;
	        targetNode.data = null;
	        targetNode.prev = null;
	        targetNode = last;
	    }
	    
	    size = 0;
	}
	
	@Override
	public boolean remove(Object o) {
	    Node targetNode = first;
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
	    Node targetNode = first;
	    for(int i = 0 ; i < size ; i++) {
	        arrayOfAllObjects[i] = targetNode.data;
	        targetNode = targetNode.next;
	    }
	    return arrayOfAllObjects;
	}
	
	@Override
	public int size() {
	    return size;
	}
	
	@Override
	public boolean contains(Object o) {
	    Node targetNode = first;
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
	public boolean containsAll(MyList c) {
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
}
