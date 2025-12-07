package notes;

import java.util.HashSet;
import java.util.Set;

public class Category {

    private String name;
    private Set<Book> books;

    public Category(String name) {
        this.name = name;
        this.books = new HashSet<>(); // aynı kitap tekrar eklenemez
    }

    // Kitap ekle (composition)
    public void addBook(Book book) {
        if (book != null) {
            books.add(book);
            System.out.println("Kitap eklendi: " + book.getTitle() + " -> Kategori: " + name);
        }
    }

    // Kitap çıkar
    public void removeBook(Book book) {
        if (book != null && books.remove(book)) {
            System.out.println("Kitap silindi: " + book.getTitle() + " -> Kategori: " + name);
        } else {
            System.out.println("Kitap kategoride bulunamadı: " + (book != null ? book.getTitle() : "null"));
        }
    }

    // Kategorideki kitapları listele
    public void listBooks() {
        System.out.println("Kategori: " + name + " kitap listesi:");
        if (books.isEmpty()) {
            System.out.println("  (Hiç kitap yok)");
            return;
        }
        for (Book b : books) {
            System.out.println("  - " + b.getTitle() + " (Yazar: " + b.getAuthor().getName() + ")");
        }
    }

    // Getter
    public String getName() {
        return name;
    }

    // Encapsulation: dışarıya setin kopyasını veriyoruz
    public Set<Book> getBooks() {
        return new HashSet<>(books);
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", books=" + books.size() +
                " kitap}" ;
    }
}
