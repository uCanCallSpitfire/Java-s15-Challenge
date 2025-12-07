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


    public boolean borrowBook(Book book) {
        if (!canBorrow()) {
            System.out.println("Lan limit dolu, kitap alamıyorsun.");
            return false;
        }

        if (book.isBorrowed()) {
            System.out.println("Bu kitap zaten başka birinin elinde.");
            return false;
        }

        borrowedBooks.add(book);
        book.setBorrowedBy(this);
        book.setBorrowed(true);

        return true;
    }

    public boolean returnBook(Book book) {
        if (!borrowedBooks.contains(book)) {
            System.out.println("Bu kitap sende bile değil, nasıl iade ediyon sen?");
            return false;
        }

        borrowedBooks.remove(book);
        book.setBorrowedBy(null);
        book.setBorrowed(false);

        return true;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public int getMaxBooks() {
        return maxBooks;
    }

    public void setMaxBooks(int maxBooks) {
        this.maxBooks = maxBooks;
    }
}
