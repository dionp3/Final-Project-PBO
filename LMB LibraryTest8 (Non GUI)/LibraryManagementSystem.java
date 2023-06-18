  import java.util.Scanner;

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
