package notes;

import java.util.*;

public class Library {

    private Map<Integer, Book> books = new HashMap<>();
    private Map<String, Author> authors = new HashMap<>();
    private Map<Integer, User> users = new HashMap<>();
    private List<Invoice> invoices = new ArrayList<>();

    // --- BOOK ---
    public void addBook(Book book) {
        books.put(book.getId(), book);

        Author a = book.getAuthor();
        authors.put(a.getName(), a);

        System.out.println("Kitap eklendi: " + book.getTitle());
    }

    public void removeBook(int id) {
        if (!books.containsKey(id)) {
            System.out.println("Böyle bir kitap yok.");
            return;
        }
        books.remove(id);
        System.out.println("Kitap silindi -> id: " + id);
    }

    public void updateBook(int id, String title, Author author, int price) {
        Book b = books.get(id);
        if (b == null) {
            System.out.println("Güncellenecek kitap bulunamadı.");
            return;
        }
        b.updateBookInfo(title, author, price);
    }

    public Book findBookById(int id) {
        return books.get(id);
    }

    public Book findBookByName(String name) {
        for (Book b : books.values()) {
            if (b.getTitle().equalsIgnoreCase(name)) {
                return b;
            }
        }
        return null;
    }

    public List<Book> findBookByAuthor(String authorName) {
        List<Book> result = new ArrayList<>();
        for (Book b : books.values()) {
            if (b.getAuthor().getName().equalsIgnoreCase(authorName)) {
                result.add(b);
            }
        }
        return result;
    }

    // --- USERS ---
    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public User findUser(int id) {
        return users.get(id);
    }

    // Getters (isteğe göre)
    public Map<Integer, Book> getBooks() {
        return books;
    }

    public Map<String, Author> getAuthors() {
        return authors;
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }
}
