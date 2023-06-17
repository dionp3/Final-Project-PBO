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