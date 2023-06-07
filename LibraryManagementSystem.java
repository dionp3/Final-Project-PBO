import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private boolean available;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Books in the library:");
            for (Book book : books) {
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Availability: " + (book.isAvailable() ? "Available" : "Not Available"));
                System.out.println("------------------------");
            }
        }
    }

    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add book");
            System.out.println("2. Borrow book");
            System.out.println("3. Return book");
            System.out.println("4. Display books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    Book newBook = new Book(title, author);
                    library.addBook(newBook);
                    System.out.println("Book added successfully.");
                    break;
                case 2:
                    System.out.print("Enter book title to borrow: ");
                    title = scanner.nextLine();
                    Book borrowBook = library.findBook(title);
                    if (borrowBook != null && borrowBook.isAvailable()) {
                        borrowBook.setAvailable(false);
                        System.out.println("Book borrowed successfully.");
                    } else {
                        System.out.println("Book not found or not available.");
                    }
                    break;
                case 3:
                    System.out.print("Enter book title to return: ");
                    title = scanner.nextLine();
                    Book returnBook = library.findBook(title);
                    if (returnBook != null && !returnBook.isAvailable()) {
                        returnBook.setAvailable(true);
                        System.out.println("Book returned successfully.");
                    } else {
                        System.out.println("Book not found or already returned.");
                    }
                    break;
                case 4:
                    library.displayBooks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
    }
}
