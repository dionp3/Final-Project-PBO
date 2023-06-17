import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// User class (base class for Admin, Member, Student, and Teacher)
class User {
  private String username;
  private String password;

  // Constructor
  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  // Getters and setters
  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  // Login method
  public boolean login(String username, String password) {
    return this.username.equals(username) && this.password.equals(password);
  }
}

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

// Student class (inherits from Member)
class Student extends Member {
  public Student(String username, String password) {
    super(username, password);
  }
}

// Teacher class (inherits from Member)
class Teacher extends Member {
  public Teacher(String username, String password) {
    super(username, password);
  }
}

// Book class
class Book {
  private String title;
  private String author;

  public Book(String title, String author) {
    this.title = title;
    this.author = author;
  }

  // Getters
  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }
}

// Borrow class
class Borrow {
  private Member member;
  private Book book;

  public Borrow(Member member, Book book) {
    this.member = member;
    this.book = book;
  }

  // Getters
  public Member getMember() {
    return member;
  }

  public Book getBook() {
    return book;
  }
}

// Library class
class Library {
  private List<Book> books;
  private List<Member> members;
  private List<Borrow> borrowRecords;

  public Library() {
    books = new ArrayList<>();
    members = new ArrayList<>();
    borrowRecords = new ArrayList<>();
  }

  // Library methods
  public void addBook(Book book) {
    books.add(book);
  }

  public boolean deleteBook(String title) {
    for (Book book : books) {
        if (book.getTitle().equalsIgnoreCase(title)) {
            books.remove(book);
            return true;
        }
    }
    return false;
  }

  public void addMember(Member member) {
    members.add(member);
  }

  public boolean deleteMember(String username) {
    for (Member member : members) {
        if (member.getUsername().equalsIgnoreCase(username)) {
            members.remove(member);
            return true;
        }
    }
    return false;
  }

  public List<Book> getAvailableBooks() {
    List<Book> availableBooks = new ArrayList<>();
    for (Book book : books) {
      if (!isBookBorrowed(book)) {
        availableBooks.add(book);
      }
    }
    return availableBooks;
  }

  public List<Book> getBorrowedBooks() {
    List<Book> borrowedBooks = new ArrayList<>();
    for (Borrow borrow : borrowRecords) {
      borrowedBooks.add(borrow.getBook());
    }
    return borrowedBooks;
  }

  public List<Borrow> getBorrowRecords() {
    return borrowRecords;
  }

  public boolean borrowBook(Member member, Book book) {
    if (!isBookBorrowed(book)) {
      borrowRecords.add(new Borrow(member, book));
      return true;
    }
    return false;
  }

  public boolean returnBook(Member member, Book book) {
    for (Borrow borrow : borrowRecords) {
      if (borrow.getMember().equals(member) && borrow.getBook().equals(book)) {
        borrowRecords.remove(borrow);
        return true;
      }
    }
    return false;
  }

  private boolean isBookBorrowed(Book book) {
    for (Borrow borrow : borrowRecords) {
      if (borrow.getBook().equals(book)) {
        return true;
      }
    }
    return false;
  }

  public List<Member> getMembers() {
    return members;
  }
}

public class LibraryManagementSystem {
  public static void main(String[] args) {
    Library library = new Library();

    // Adding initial books to the library
    library.addBook(new Book("Book 1", "Author 1"));
    library.addBook(new Book("Book 2", "Author 2"));
    library.addBook(new Book("Book 3", "Author 3"));

    // Adding initial members to the library
    library.addMember(new Student("student", "password"));
    library.addMember(new Teacher("teacher", "password"));

    // Login menu
    Scanner scanner = new Scanner(System.in);
    String username;
    String password;
    int choice;

    do {
      System.out.print("Enter username: ");
      username = scanner.nextLine();
      System.out.print("Enter password: ");
      password = scanner.nextLine();

      if (username.equalsIgnoreCase("admin") && password.equals("admin123")) {
        // Admin menu
        Admin admin = new Admin(username, password);

        do {
          admin.displayMenu();
          System.out.print("Enter your choice: ");
          choice = scanner.nextInt();
          scanner.nextLine(); // Consume newline character

          admin.performAction(choice, library);
        } while (choice != 0);

      } else {
        // Check if it's a member login
        Member member = null;
        for (Member m : library.getMembers()) {
          if (m.login(username, password)) {
            member = m;
            break;
          }
        }

        if (member != null) {
          // Member menu
          do {
            member.displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            member.performAction(choice, library);
          } while (choice != 0);

        } else {
          System.out.println("Invalid login credentials.");
        }
      }
    } while (true);
  }
}
