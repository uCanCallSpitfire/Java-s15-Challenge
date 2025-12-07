package notes;

import java.util.*;

public class Library {

    private Map<Integer, Book> books = new HashMap<>();
    private Map<String, Author> authors = new HashMap<>();
    private Map<Integer, User> users = new HashMap<>();
    private Map<String, Category> categories = new HashMap<>();

    // --- BOOK ---
    public void addBook(Book book) {
        if (book == null) return;

        books.put(book.getId(), book);

        // Author ekleme
        Author a = book.getAuthor();
        authors.putIfAbsent(a.getName(), a);

        // Category ekleme
        Category cat = book.getCategory();
        if (cat != null) {
            categories.putIfAbsent(cat.getName(), cat);
            cat.addBook(book);
        }

        System.out.println("Kitap eklendi: " + book.getTitle());
    }

    public void removeBook(int id) {
        Book book = books.remove(id);
        if (book == null) {
            System.out.println("Böyle bir kitap yok.");
            return;
        }

        // Kitabı kategorilerden de çıkar
        if (book.getCategory() != null) {
            book.getCategory().removeBook(book);
        }

        System.out.println("Kitap silindi -> id: " + id);
    }

    // Güncelleme artık Category ile birlikte
    public void updateBook(int id, String title, Author author, int price, Category category) {
        Book b = books.get(id);
        if (b == null) {
            System.out.println("Güncellenecek kitap bulunamadı.");
            return;
        }
        b.updateBookInfo(title, author, price, category);

        // Yeni kategori varsa Library kategorisine ekle
        if (category != null) {
            categories.putIfAbsent(category.getName(), category);
        }
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

    // --- CATEGORY ---
    public void addCategory(Category category) {
        if (category != null) {
            categories.putIfAbsent(category.getName(), category);
        }
    }

    public Category findCategory(String name) {
        return categories.get(name);
    }

    public void listBooksByCategory(String categoryName) {
        Category cat = categories.get(categoryName);
        if (cat != null) {
            cat.listBooks();
        } else {
            System.out.println("Kategori bulunamadı: " + categoryName);
        }
    }

    // --- USERS ---
    public void addUser(User user) {
        if (user != null) users.put(user.getId(), user);
    }

    public User findUser(int id) {
        return users.get(id);
    }

    // --- GETTERS ---
    public Map<Integer, Book> getBooks() {
        return books;
    }

    public Map<String, Author> getAuthors() {
        return authors;
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    public Map<String, Category> getCategories() {
        return categories;
    }
}
