package week1.day2;

public class LibraryManagement {

	public static void main(String[] args) {
		Library book2 = new Library();
		System.out.println(book2.addBook("Science II"));
		book2.issueBook();
	}
}