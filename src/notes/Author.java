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

    public void addBook(Book book) {
        if (book != null && !booksWritten.contains(book)) {
            booksWritten.add(book);
        }
    }


    public List<Book> getBooksWritten() {
        return new ArrayList<>(booksWritten);
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", booksWritten=" + booksWritten.size() +
                " kitap}" ;
    }
}
