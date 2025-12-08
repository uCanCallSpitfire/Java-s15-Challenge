package notes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        seata.loadSampleBooks(library);

        Author defaultAuthor = new Author("Default Author");
        Category defaultCategory = new Category("Genel");

        while (true) {
            System.out.println("\n=== Kütüphane Yönetim Menüsü ===");
            System.out.println("1. Kitap Ekle");
            System.out.println("2. Kitap Güncelle");
            System.out.println("3. Kitap Sil");
            System.out.println("4. Kitapları Listele");
            System.out.println("5. Kategori Ekle");
            System.out.println("6. Kitapları Kategoriye Göre Listele");
            System.out.println("7. Kullanıcı Ekle");
            System.out.println("8. Kitap Ödünç Al");
            System.out.println("9. Kitap İade Et");
            System.out.println("0. Çıkış");
            System.out.print("Seçiminiz: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.print("Kitap ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Kitap Başlığı: ");
                    String title = sc.nextLine();
                    System.out.print("Yazar Adı: ");
                    String authorName = sc.nextLine();
                    Author author = library.getAuthors().getOrDefault(authorName, new Author(authorName));
                    System.out.print("Fiyat: ");
                    int price = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Kategori Adı: ");
                    String catName = sc.nextLine();
                    Category category = library.getCategories().getOrDefault(catName, new Category(catName));

                    Book book = new Book(id, title, author, price, category);
                    library.addBook(book);
                }
                case 2 -> {
                    System.out.print("Güncellenecek Kitap ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Yeni Başlık: ");
                    String title = sc.nextLine();
                    System.out.print("Yeni Yazar: ");
                    String authorName = sc.nextLine();
                    Author author = library.getAuthors().getOrDefault(authorName, new Author(authorName));
                    System.out.print("Yeni Fiyat: ");
                    int price = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Yeni Kategori: ");
                    String catName = sc.nextLine();
                    Category category = library.getCategories().getOrDefault(catName, new Category(catName));

                    library.updateBook(id, title, author, price, category);
                }
                case 3 -> { // Kitap sil
                    System.out.print("Silinecek Kitap ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    library.removeBook(id);
                }
                case 4 -> { // Tüm kitapları listele
                    System.out.println("=== Tüm Kitaplar ===");
                    library.getBooks().values().forEach(System.out::println);
                }
                case 5 -> { // Kategori ekle
                    System.out.print("Kategori Adı: ");
                    String catName = sc.nextLine();
                    library.addCategory(new Category(catName));
                }
                case 6 -> { // Kitapları kategoriye göre listele
                    System.out.print("Kategori Adı: ");
                    String catName = sc.nextLine();
                    library.listBooksByCategory(catName);
                }
                case 7 -> { // Kullanıcı ekle
                    System.out.print("Kullanıcı ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Kullanıcı Adı: ");
                    String name = sc.nextLine();
                    library.addUser(new User(id, name));
                }
                case 8 -> { // Kitap ödünç al
                    System.out.print("Kullanıcı ID: ");
                    int userId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Kitap ID: ");
                    int bookId = sc.nextInt();
                    sc.nextLine();

                    User user = library.findUser(userId);
                    Book book = library.findBookById(bookId);

                    if (user != null && book != null) {
                        user.borrowBook(book);
                    } else {
                        System.out.println("Kullanıcı veya kitap bulunamadı.");
                    }
                }
                case 9 -> { // Kitap iade
                    System.out.print("Kullanıcı ID: ");
                    int userId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Kitap ID: ");
                    int bookId = sc.nextInt();
                    sc.nextLine();

                    User user = library.findUser(userId);
                    Book book = library.findBookById(bookId);

                    if (user != null && book != null) {
                        user.returnBook(book);
                    } else {
                        System.out.println("Kullanıcı veya kitap bulunamadı.");
                    }
                }
                case 0 -> {
                    System.out.println("Çıkış yapılıyor...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Geçersiz seçim, tekrar deneyin!");
            }
        }
    }
}
