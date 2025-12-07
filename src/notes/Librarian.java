package notes;

public class Librarian extends Person {

    public Librarian(int id, String name) {
        super(id, name);
    }

    @Override
    public String getRole() {
        return "Librarian";
    }

    // Kitap ekleme
    public void addBookToLibrary(Library library, Book book) {
        if (library != null && book != null) {
            library.addBook(book);
            System.out.println("Librarian " + getName() + " kitap ekledi: " + book.getTitle());
        }
    }

    // Kitap silme
    public void removeBookFromLibrary(Library library, int bookId) {
        if (library != null) {
            library.removeBook(bookId);
            System.out.println("Librarian " + getName() + " kitap sildi: ID " + bookId);
        }
    }

    // Kitap güncelleme
    public void updateBookInfo(Library library, int bookId, String title, Author author, int price, Category category) {
        library.updateBook(bookId, title, author, price, category);
    }


}
