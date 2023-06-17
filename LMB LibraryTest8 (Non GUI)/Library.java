import java.util.ArrayList;
import java.util.List;

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