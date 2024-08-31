import java.util.Scanner;

public class Library {

    public void addBook(Scanner scanner, Book book) {

        if (book.CheckLength()) {
            System.out.println("Library is full. Cannot add more books.");
            return;
        }
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String ISBN = scanner.nextLine();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        if (book.checkAlreadyExists(ISBN)) {
            System.out.println("Book with this ISBN already exists.");
        }

        if (book.setBook(title, author, ISBN, year)) {
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Book add not successfull.");

        }
    }

    public void searchBook(Scanner scanner, Book book) {
        System.out.print("Enter title or ISBN: ");
        String data = scanner.nextLine();

        System.out.println(book.getBook(data));
    }

    public void displayAllBook(Scanner scanner, Book book) {
        System.out.println(book.getAllBook());

    }

    public void deleteBook(Scanner scanner) {
        System.out.print("Enter ISBN of the book to delete: ");
        String ISBN = scanner.nextLine();

        Book book = new Book();
        System.out.println(book.deleteBook(ISBN, scanner));
    }
}
