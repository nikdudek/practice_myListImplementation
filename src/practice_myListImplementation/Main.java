package practice_myListImplementation;

public class Main {

	public static void main(String[] args) {
		MyList myList = new DefaultMyList();
		myList.add("object_1");
		myList.add("object_2");
		myList.add("object_3");
		
		System.out.println(myList.toString());
	}

}
