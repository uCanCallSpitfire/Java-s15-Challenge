package notes;

public class Book {

    private int id;
    private String title;
    private Author author;
    private int price;
    private User borrowedBy;

    public Book(int id, String title, Author author, int price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;

        this.borrowedBy = null; // kitap başlangıçta rafta

        author.addBook(this);   // Composition: yazarın listesine kitap ekle
    }

    public void updateBookInfo(String title, Author author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
        System.out.println("Bilgiler güncellendi.");
    }


    public boolean borrowBook(User user) {
        if (borrowedBy != null) {
            System.out.println("Kitap zaten ödünçte.");
            return false;
        }

        borrowedBy = user;
        System.out.println(user.getName() + " kitabı aldı: " + title);
        return true;
    }

    // --- İade ---
    public void returnBook() {
        if (borrowedBy != null) {
            System.out.println(borrowedBy.getName() + " kitabı iade etti: " + title);
            borrowedBy = null;
        }
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public int getPrice() {
        return price;
    }

    public User getBorrowedBy() {
        return borrowedBy;
    }

    // Kitap ödünçte mi?
    public boolean isBorrowed() {
        return borrowedBy != null;
    }

    // Kitabı kimin aldığını set et
    public void setBorrowedBy(User user) {
        this.borrowedBy = user;
    }

    // User sınıfı book.setBorrowed(true/false) çağırdığı için:
    public void setBorrowed(boolean state) {
        if (state) {
            // birisi ödünç alıyor ama kimin aldığını User sınıfı zaten setBorrowedBy ile belirliyor
            // burada ekstra bir şey yapmana gerek yok
        } else {
            // kitap rafta
            this.borrowedBy = null;
        }
    }

}
