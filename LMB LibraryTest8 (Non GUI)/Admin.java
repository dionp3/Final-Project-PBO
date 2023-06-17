import java.util.List;
import java.util.Scanner;

// Admin class (inherits from User)
class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }

    // Admin menu methods
    public void displayMenu() {
        System.out.println("Admin Menu:");
        System.out.println("1. View available books");
        System.out.println("2. View borrowed books");
        System.out.println("3. Add a book");
        System.out.println("4. Add a member");
        System.out.println("5. Delete a book");
        System.out.println("6. Delete a member");
        System.out.println("0. Exit");
    }

    public void performAction(int choice, Library library) {
        switch (choice) {
            case 1:
                viewAvailableBooks(library);
                break;
            case 2:
                viewBorrowedBooks(library);
                break;
            case 3:
                addBook(library);
                break;
            case 4:
                addMember(library);
                break;
            case 5:
                deleteBook(library);
                break;
            case 6:
                deleteMember(library);
                break;
            case 0:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public void viewAvailableBooks(Library library) {
        List<Book> availableBooks = library.getAvailableBooks();
        if (availableBooks.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("Available Books:");
            for (Book book : availableBooks) {
                System.out.println(book.getTitle() + " by " + book.getAuthor());
            }
        }
    }

    public void viewBorrowedBooks(Library library) {
        List<Borrow> borrowRecords = library.getBorrowRecords();
        if (borrowRecords.isEmpty()) {
            System.out.println("No books are currently borrowed from the library.");
        } else {
            System.out.println("Borrowed Books:");
            for (Borrow borrow : borrowRecords) {
            Book book = borrow.getBook();
            Member member = borrow.getMember();
                System.out.println(book.getTitle() + " by " + book.getAuthor() + " (Borrowed by: " + member.getUsername() + ")");
            }
        }
    }

    public void addBook(Library library) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter the book author: ");
        String author = scanner.nextLine();

        library.addBook(new Book(title, author));
        System.out.println("Book added successfully.");
    }

    public void addMember(Library library) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the member username: ");
        String username = scanner.nextLine();
        System.out.print("Enter the member password: ");
        String password = scanner.nextLine();

        library.addMember(new Student(username, password));
        System.out.println("Member added successfully.");
    }

    public void deleteBook(Library library) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title of the book to delete: ");
        String title = scanner.nextLine();

        if (library.deleteBook(title)) {
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book not found in the library.");
        }
    }

    public void deleteMember(Library library) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the username of the member to delete: ");
        String username = scanner.nextLine();

        if (library.deleteMember(username)) {
            System.out.println("Member deleted successfully.");
        } else {
            System.out.println("Member not found in the library.");
        }
    }
}