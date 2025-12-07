package notes;

import java.util.ArrayList;
import java.util.List;

public class Author {

    private String name;
    private List<Book> booksWritten;

    public Author(String name) {
        this.name = name;
        this.booksWritten = new ArrayList<>();
    }

    // Kitap ekleme (Composition)
    public void addBook(Book book) {
        if (book != null && !booksWritten.contains(book)) {
            booksWritten.add(book);
        }
    }

    // Yazara ait kitapları listeler
    public List<Book> getBooksWritten() {
        return new ArrayList<>(booksWritten); // encapsulation: dışarıya kopya veriyoruz
    }

    public String getName() {
        return this.name;
    }

    // toString() ile kolay yazdırma
    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", booksWritten=" + booksWritten.size() +
                " kitap}" ;
    }
}
