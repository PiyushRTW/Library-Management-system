import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String isbn;
    private String title;
    private String author;
    private int publicationYear;
    private boolean isAvailable;

    // Getters and setters

    public String toString() {
        return "ISBN: " + isbn + "\nTitle: " + title + "\nAuthor: " + author +
               "\nPublication Year: " + publicationYear + "\nAvailability: " + (isAvailable ? "Available" : "Not Available");
    }
}

class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String isbn) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equals(isbn)) {
                books.remove(i);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public Book searchBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book);
            }
        }
    }

    public void borrowBook(String isbn) {
        Book book = searchBook(isbn);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book not available for borrowing.");
        }
    }

    public void returnBook(String isbn) {
        Book book = searchBook(isbn);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book not found or already available.");
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        // Sample books
        library.addBook(new Book("12345", "Book 1", "Author 1", 2023, true));
        library.addBook(new Book("67890", "Book 2", "Author 2", 2022, true));

        while (true) {
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. View Available Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Code to add a book
                    break;
                case 2:
                    // Code to borrow a book
                    break;
                case 3:
                    // Code to return a book
                    break;
                case 4:
                    // Code to view available books
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
            }
        }
    }
}