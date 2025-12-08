package notes;

public class Book {

    private int id;
    private String title;
    private Author author;
    private int price;
    private User borrowedBy;
    private Category category;

    public Book(int id, String title, Author author, int price, Category category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.borrowedBy = null;
        this.category = category;

        author.addBook(this);
        if (category != null) {
            category.addBook(this);
        }
    }

    public void updateBookInfo(String title, Author author, int price, Category category) {
        this.title = title;
        this.author = author;
        this.price = price;
        setCategory(category);
        System.out.println("Kitap bilgileri güncellendi: " + title);
    }


    public boolean borrowBook(User user) {
        if (borrowedBy != null) {
            System.out.println("Kitap zaten ödünçte: " + title);
            return false;
        }
        borrowedBy = user;
        System.out.println(user.getName() + " kitabı aldı: " + title);
        return true;
    }

    public void returnBook() {
        if (borrowedBy != null) {
            System.out.println(borrowedBy.getName() + " kitabı iade etti: " + title);
            borrowedBy = null;
        } else {
            System.out.println("Kitap rafta: " + title);
        }
    }


    public int getId() { return id; }
    public String getTitle() { return title; }
    public Author getAuthor() { return author; }
    public int getPrice() { return price; }
    public User getBorrowedBy() { return borrowedBy; }
    public Category getCategory() { return category; }

    public void setCategory(Category category) {
        if (this.category != null) {
            this.category.removeBook(this); // eski kategoriden çıkar
        }
        this.category = category;
        if (category != null) {
            category.addBook(this);         // yeni kategoriye ekle
        }
    }

    public void setBorrowedBy(User borrowedBy) {
        this.borrowedBy = borrowedBy;
    }

    public boolean isBorrowed() { return borrowedBy != null; }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author.getName() +
                ", category=" + (category != null ? category.getName() : "Yok") +
                ", borrowedBy=" + (borrowedBy != null ? borrowedBy.getName() : "Rafta") +
                '}';
    }
}
