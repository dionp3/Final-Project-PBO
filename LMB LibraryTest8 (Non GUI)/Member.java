import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Member class (inherits from User)
class Member extends User {
    public Member(String username, String password) {
        super(username, password);
    }

    // Member menu methods
    public void displayMenu() {
        System.out.println("Member Menu:");
        System.out.println("1. View available books");
        System.out.println("2. View borrowed books");
        System.out.println("3. Borrow a book");
        System.out.println("4. Return a book");
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
                borrowBook(library);
                break;
            case 4:
                returnBook(library);
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

    private void viewBorrowedBooks(Library library) {
        List<Borrow> borrowRecords = library.getBorrowRecords();
        List<Book> borrowedBooks = new ArrayList<>();

        for (Borrow borrow : borrowRecords) {
            if (borrow.getMember().getUsername().equals(getUsername())) {
                borrowedBooks.add(borrow.getBook());
            }
        }

        if (borrowedBooks.isEmpty()) {
            System.out.println("You have not borrowed any books.");
        } else {
            System.out.println("Borrowed Books:");
            for (Book book : borrowedBooks) {
                System.out.println(book.getTitle() + " by " + book.getAuthor());
            }
        }
    }

    public void borrowBook(Library library) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title of the book to borrow: ");
        String title = scanner.nextLine();

        List<Book> availableBooks = library.getAvailableBooks();
        for (Book book : availableBooks) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                boolean success = library.borrowBook(this, book);
                if (success) {
                    System.out.println("Book borrowed successfully.");
                } else {
                    System.out.println("Failed to borrow the book. Please try again.");
                }
                return;
            }
        }

        System.out.println("Book not found in the library.");
    }

    public void returnBook(Library library) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title of the book to return: ");
        String title = scanner.nextLine();

        List<Book> borrowedBooks = library.getBorrowedBooks();
        for (Book book : borrowedBooks) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                boolean success = library.returnBook(this, book);
                if (success) {
                    System.out.println("Book returned successfully.");
                } else {
                    System.out.println("Failed to return the book. Please try again.");
                }
                return;
            }
        }

        System.out.println("You have not borrowed the book.");
    }
}
