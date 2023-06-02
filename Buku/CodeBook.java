import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CodeBook {
    private Map<String, String> snippets;

    public CodeBook() {
        snippets = new HashMap<>();
    }

    public void addSnippet(String code, String description) {
        snippets.put(code, description);
    }

    public void searchSnippet(String code) {
        if (snippets.containsKey(code)) {
            System.out.println("Description: " + snippets.get(code));
        } else {
            System.out.println("Code snippet not found.");
        }
    }

    public void displayAllSnippets() {
        for (Map.Entry<String, String> entry : snippets.entrySet()) {
            System.out.println("Code: " + entry.getKey());
            System.out.println("Description: " + entry.getValue());
            System.out.println("------------------------");
        }
    }

    public static void main(String[] args) {
        CodeBook codeBook = new CodeBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add code snippet");
            System.out.println("2. Search code snippet");
            System.out.println("3. Display all snippets");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter code snippet: ");
                    String code = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    codeBook.addSnippet(code, description);
                    System.out.println("Code snippet added successfully.");
                    break;
                case 2:
                    System.out.print("Enter code to search: ");
                    code = scanner.nextLine();
                    codeBook.searchSnippet(code);
                    break;
                case 3:
                    codeBook.displayAllSnippets();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
    }
}
