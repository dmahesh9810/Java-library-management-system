import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Library library = new Library();
        Book book = new Book();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book");
            System.out.println("3. List All Books");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    library.addBook(scanner, book);
                    break;
                case 2:
                    library.searchBook(scanner, book);
                    break;
                case 3:
                    library.displayAllBook(scanner, book);
                    break;
                case 4:
                    library.deleteBook(scanner);
                    break;
                default:
                    break;
            }

        } while (choice != 5);
    }

}