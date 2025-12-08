package notes;

import java.util.ArrayList;
import java.util.List;

public class User extends Person {

    private List<Book> borrowedBooks;
    private int maxBooks = 5;

    public User(int id, String name) {
        super(id, name);
        borrowedBooks = new ArrayList<>();
    }


    public int borrowed() {
        return borrowedBooks.size();
    }


    public boolean canBorrow() {
        return borrowed() < maxBooks;
    }

    @Override
    public String getRole() {
        return "User";
    }

    // Kitap ödünç alma
    public boolean borrowBook(Book book) {
        if (!canBorrow()) {
            System.out.println("Limit dolu, kitap alamıyorsun.");
            return false;
        }

        if (book.isBorrowed()) {
            System.out.println("Bu kitap zaten başka birinin elinde.");
            return false;
        }

        borrowedBooks.add(book);
        book.setBorrowedBy(this);

        System.out.println(getName() + " kitabı ödünç aldı: " + book.getTitle());
        return true;
    }


    public boolean returnBook(Book book) {
        if (!borrowedBooks.contains(book)) {
            System.out.println("Bu kitap sende yok, iade edemezsin.");
            return false;
        }

        borrowedBooks.remove(book);
        book.setBorrowedBy(null);

        System.out.println(getName() + " kitabı iade etti: " + book.getTitle());
        return true;
    }


    public List<Book> getBorrowedBooks() {
        return new ArrayList<>(borrowedBooks);
    }


    public int getMaxBooks() {
        return maxBooks;
    }

    public void setMaxBooks(int maxBooks) {
        this.maxBooks = maxBooks;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", borrowedBooks=" + borrowedBooks.size() +
                ", maxBooks=" + maxBooks +
                '}';
    }
}
