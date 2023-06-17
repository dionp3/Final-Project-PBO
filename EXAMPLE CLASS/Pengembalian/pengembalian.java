private static class pengembalian {
    private Member member;
    private Book book;

    public pengembalian(Member member, Book book) {
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