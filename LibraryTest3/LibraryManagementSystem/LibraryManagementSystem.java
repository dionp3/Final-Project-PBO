import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Main class representing the Library Management System
public class LibraryManagementSystem {
    private static List<Book> books = new ArrayList<>();
    private static List<Member> members = new ArrayList<>();
    private static List<Borrow> borrows = new ArrayList<>();
    private static List<Return> returns = new ArrayList<>();
    private static User currentUser;

    public static void main(String[] args) {
        // Add some initial books and members to the library
        books.add(new Book("Book1", "Author1"));
        books.add(new Book("Book2", "Author2"));
        members.add(new Member("John Doe", "1234567890"));
        members.add(new Member("Jane Smith", "0987654321"));

        // Start the login system
        login();
    }

    private static void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        User user = authenticateUser(username, password);
        if (user != null) {
            currentUser = user;
            System.out.println("Login successful!");
            showMenu();
        } else {
            System.out.println("Invalid username or password. Please try again.");
            login();
        }
    }

    private static User authenticateUser(String username, String password) {
        // Implement your own authentication logic here
        // For simplicity, we're using a hard-coded username and password
        if (username.equals("admin") && password.equals("password")) {
            return new Librarian("Admin");
        } else if (username.equals("student") && password.equals("password")) {
            return new Student("Student");
        } else if (username.equals("teacher") && password.equals("password")) {
            return new Teacher("Teacher");
        }
        return null;
    }

    private static void showMenu() {
        if (currentUser instanceof Librarian) {
            showLibrarianMenu();
        } else if (currentUser instanceof Student) {
            showStudentMenu();
        } else if (currentUser instanceof Teacher) {
            showTeacherMenu();
        }
    }

    private static void showLibrarianMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Librarian Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    addMember();
                    break;
                case 3:
                    issueBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        currentUser = null;
        login();
    }

    private static void showStudentMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Menu ---");
            System.out.println("1. View Available Books");
            System.out.println("2. View Borrowed Books");
            System.out.println("3. Return Book");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAvailableBooks();
                    break;
                case 2:
                    viewBorrowedBooks();
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        currentUser = null;
        login();
    }

    private static void showTeacherMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Teacher Menu ---");
            System.out.println("1. View Available Books");
            System.out.println("2. View Borrowed Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAvailableBooks();
                    break;
                case 2:
                    viewBorrowedBooks();
                    break;
                case 3:
                    issueBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        currentUser = null;
        login();
    }

    private static void addBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter the author name: ");
        String author = scanner.nextLine();

        Book book = new Book(title, author);
        books.add(book);
        System.out.println("Book added successfully!");
    }

    private static void addMember() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the member name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the member ID: ");
        String id = scanner.nextLine();

        Member member = new Member(name, id);
        members.add(member);
        System.out.println("Member added successfully!");
    }

    private static void issueBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the member ID: ");
        String memberId = scanner.nextLine();
        System.out.print("Enter the book title: ");
        String bookTitle = scanner.nextLine();

        Member member = findMemberById(memberId);
        Book book = findBookByTitle(bookTitle);

        if (member != null && book != null) {
            if (isBookAvailable(book)) {
                // Create a new borrow record
                Borrow borrow = new Borrow(member, book);
                borrows.add(borrow);
                System.out.println("Book issued successfully!");
            } else {
                System.out.println("Book is already borrowed by someone else.");
            }
        } else {
            System.out.println("Invalid member ID or book title. Please try again.");
        }
    }

    private static void returnBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the member ID: ");
        String memberId = scanner.nextLine();
        System.out.print("Enter the book title: ");
        String bookTitle = scanner.nextLine();

        Member member = findMemberById(memberId);
        Book book = findBookByTitle(bookTitle);

        if (member != null && book != null) {
            if (isBookBorrowed(member, book)) {
                // Create a new return record
                Return returnRecord = new Return(member, book);
                returns.add(returnRecord);
                System.out.println("Book returned successfully!");
            } else {
                System.out.println("Book is not currently borrowed by the member.");
            }
        } else {
            System.out.println("Invalid member ID or book title. Please try again.");
        }
    }

    private static void viewAvailableBooks() {
        System.out.println("\n--- Available Books ---");
        for (Book book : books) {
            if (isBookAvailable(book)) {
                System.out.println(book);
            }
        }
    }

    private static void viewBorrowedBooks() {
        System.out.println("\n--- Borrowed Books ---");
        for (Borrow borrow : borrows) {
            System.out.println(borrow);
        }
    }

    private static Member findMemberById(String memberId) {
        for (Member member : members) {
            if (member.getId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }

    private static Book findBookByTitle(String bookTitle) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                return book;
            }
        }
        return null;
    }

    private static boolean isBookAvailable(Book book) {
        for (Borrow borrow : borrows) {
            if (borrow.getBook().equals(book)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isBookBorrowed(Member member, Book book) {
        for (Borrow borrow : borrows) {
            if (borrow.getMember().equals(member) && borrow.getBook().equals(book)) {
                return true;
            }
        }
        return false;
    }

    // Book class representing a book
    static class Book {
        private String title;
        private String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        @Override
        public String toString() {
            return "Title: " + title + ", Author: " + author;
        }
    }

    // Member class representing a library member
    static class Member {
        private String name;
        private String id;

        public Member(String name, String id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }
    }

    // Borrow class representing a book borrowing record
    static class Borrow {
        private Member member;
        private Book book;

        public Borrow(Member member, Book book) {
            this.member = member;
            this.book = book;
        }

        public Member getMember() {
            return member;
        }

        public Book getBook() {
            return book;
        }

        @Override
        public String toString() {
            return "Borrowed by: " + member.getName() + ", Book: " + book.getTitle();
        }
    }

    // Return class representing a book return record
    static class Return {
        private Member member;
        private Book book;

        public Return(Member member, Book book) {
            this.member = member;
            this.book = book;
        }

        public Member getMember() {
            return member;
        }

        public Book getBook() {
            return book;
        }

        @Override
        public String toString() {
            return "Returned by: " + member.getName() + ", Book: " + book.getTitle();
        }
    }

    // User class representing a library user
    static class User {
        private String username;

        public User(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }
    }

    // Librarian class representing a librarian user
    static class Librarian extends User {
        public Librarian(String username) {
            super(username);
        }
    }

    // Student class representing a student user
    static class Student extends User {
        public Student(String username) {
            super(username);
        }
    }

    // Teacher class representing a teacher user
    static class Teacher extends User {
        public Teacher(String username) {
            super(username);
        }
    }
}
