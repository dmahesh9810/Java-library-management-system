import java.util.Scanner;

public class Book {
    private static String[] titles = new String[100];
    private static String[] authors = new String[100];
    private static String[] ISBNs = new String[100];
    private static int[] years = new int[100];
    private static int bookCount = 0;

    public boolean CheckLength() {
        if (bookCount >= titles.length) {
            return true;
        }
        return false;
    }

    public boolean checkAlreadyExists(String ISBN) {
        for (int i = 0; i < bookCount; i++) {
            if (ISBNs[i].equals(ISBN)) {
                System.out.println("Book with this ISBN already exists.");
                return true;
            }
        }
        return false;
    }

    public boolean setBook(String title, String author, String ISBN, int year) {
        try {
            titles[bookCount] = title;
            authors[bookCount] = author;
            ISBNs[bookCount] = ISBN;
            years[bookCount] = year;
            bookCount++;
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public String getBook(String data) {
        for (int i = 0; i < bookCount; i++) {
            if (titles[i].equalsIgnoreCase(data) || ISBNs[i].equals(data)) {
                return ("Book found: Title: " + titles[i] + ", Author: " + authors[i] +
                        ", ISBN: " + ISBNs[i] + ", Year: " + years[i]);
            }
        }
        return "Book not found.";
    }

    public String getAllBook() {
        if (bookCount == 0) {
            return "No books available in the library.";
        }

        StringBuilder allBooks = new StringBuilder();
        for (int i = 0; i < bookCount; i++) {
            allBooks.append("Title: ").append(titles[i])
                    .append(", Author: ").append(authors[i])
                    .append(", ISBN: ").append(ISBNs[i])
                    .append(", Year: ").append(years[i])
                    .append("\n");
        }
        return allBooks.toString();
    }

    public String deleteBook(String ISBN, Scanner scanner) {
        for (int i = 0; i < bookCount; i++) {
            if (ISBNs[i].equals(ISBN)) {
                System.out.print("Are you sure you want to delete this book? (yes/no): ");
                String confirmation = scanner.nextLine();
                if (confirmation.equalsIgnoreCase("yes")) {
                    for (int j = i; j < bookCount - 1; j++) {
                        titles[j] = titles[j + 1];
                        authors[j] = authors[j + 1];
                        ISBNs[j] = ISBNs[j + 1];
                        years[j] = years[j + 1];
                    }
                    titles[bookCount - 1] = null;
                    authors[bookCount - 1] = null;
                    ISBNs[bookCount - 1] = null;
                    years[bookCount - 1] = 0;
                    bookCount--;
                    return ("Book deleted successfully.");
                } else {
                    return ("Deletion cancelled.");
                }
            }
        }
        return "Book not found.";
    }
}
