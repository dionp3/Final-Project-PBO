private static class peminjaman {
    private Member member;
    private Book book;

    public peminjaman(Member member, Book book) {
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
        return "Member: " + member.getName() + ", Book: " + book.getTitle();
    }
}
