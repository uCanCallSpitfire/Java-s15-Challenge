package notes;

public class Librarian extends Person {

    public Librarian(int id, String name) {
        super(id, name);
    }

    @Override
    public String getRole() {
        return "Librarian";
    }

    public void addBookToLibrary(Library library, Book book) {
        library.addBook(book);
    }

    public void removeBookFromLibrary(Library library, int bookId) {
        library.removeBook(bookId);
    }

    public void updateBookInfo(Library library, int bookId, String title, Author author, int price) {
        library.updateBook(bookId, title, author, price);
    }
}
