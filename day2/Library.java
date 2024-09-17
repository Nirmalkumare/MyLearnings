package week1.day2;

public class Library {

	public String addBook(String bookTitle) {
		System.out.println("Book added successfully ");
		return bookTitle;
	}

	public void issueBook() {
		System.out.println("Book issued successfully");
	}

	public static void main(String[] args) {
		Library book1 = new Library();
		System.out.println(book1.addBook("Science"));
		book1.issueBook();
	}
}