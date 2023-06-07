import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
                    borrowBook();
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
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAvailableBooks();
                    break;
                case 2:
                    borrowBook();
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
                    borrowBook();
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
        System.out.print("Enter the book author: ");
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
        String memberId = scanner.nextLine();

        Member member = new Member(name, memberId);
        members.add(member);

        System.out.println("Member added successfully!");
    }

    private static void borrowBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the member ID: ");
        String memberId = scanner.nextLine();
        System.out.print("Enter the book title: ");
        String bookTitle = scanner.nextLine();
    
        Member member = findMemberById(memberId);
        if (member == null) {
            System.out.println("Member not found!");
            return;
        }
    
        Book book = findBookByTitle(bookTitle);
        if (book == null) {
            System.out.println("Book not found!");
            return;
        }
    
        if (book.isBorrowed()) {
            System.out.println("The book is already borrowed!");
            return;
        }
    
        Borrow borrow = new Borrow(member, book);
        borrows.add(borrow);
        book.setBorrowed(true);
        System.out.println("Book borrowed successfully!");
    }
    

    private static void returnBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the member ID: ");
        String memberId = scanner.nextLine();
        System.out.print("Enter the book title: ");
        String bookTitle = scanner.nextLine();

        Member member = findMemberById(memberId);
        if (member == null) {
            System.out.println("Member not found!");
            return;
        }

        Book book = findBookByTitle(bookTitle);
        if (book == null) {
            System.out.println("Book not found!");
            return;
        }

        Borrow borrow = findBorrowByMemberAndBook(member, book);
        if (borrow == null) {
            System.out.println("The book was not borrowed by this member!");
            return;
        }

        Return returnObj = new Return(member, book);
        returns.add(returnObj);
        borrows.remove(borrow);
        book.setBorrowed(false);
        System.out.println("Book returned successfully!");
    }

    private static void viewAvailableBooks() {
        System.out.println("--- Available Books ---");
        for (Book book : books) {
            if (!book.isBorrowed()) {
                System.out.println(book.getTitle() + " by " + book.getAuthor());
            }
        }
    }

    private static Member findMemberById(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }

    private static Book findBookByTitle(String bookTitle) {
        for (Book book : books) {
            if (book.getTitle().equals(bookTitle)) {
                return book;
            }
        }
        return null;
    }

    private static Borrow findBorrowByMemberAndBook(Member member, Book book) {
        for (Borrow borrow : borrows) {
            if (borrow.getMember().equals(member) && borrow.getBook().equals(book)) {
                return borrow;
            }
        }
        return null;
    }
}

class Book {
    private String title;
    private String author;
    private boolean borrowed;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.borrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }
}

class Member {
    private String name;
    private String memberId;

    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public String getMemberId() {
        return memberId;
    }
}

class Borrow {
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
}

class Return {
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
}

abstract class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

class Librarian extends User {
    public Librarian(String username) {
        super(username);
    }
}

class Student extends User {
    public Student(String username) {
        super(username);
    }
}

class Teacher extends User {
    public Teacher(String username) {
        super(username);
    }
}
