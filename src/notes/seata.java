package notes;

public class seata {

    public static void loadSampleBooks(Library lib) {

        // --- Yazarlar ---
        Author chuck = new Author("Chuck Palahniuk");
        Author king = new Author("Stephen King");
        Author gaiman = new Author("Neil Gaiman");
        Author murakami = new Author("Haruki Murakami");

        // --- Kategoriler ---
        Category fiction = new Category("Fiction");
        Category horror = new Category("Horror");
        Category drama = new Category("Drama");
        Category fantasy = new Category("Fantasy");

        lib.addCategory(fiction);
        lib.addCategory(horror);
        lib.addCategory(drama);
        lib.addCategory(fantasy);

        // --- Kitaplar ---
        lib.addBook(new Book(1, "Fight Club", chuck, 120, fiction));
        lib.addBook(new Book(2, "Choke", chuck, 110, fiction));
        lib.addBook(new Book(3, "Invisible Monsters", chuck, 130, drama));
        lib.addBook(new Book(4, "Haunted", chuck, 125, horror));

        lib.addBook(new Book(5, "IT", king, 150, horror));
        lib.addBook(new Book(6, "The Shining", king, 140, horror));
        lib.addBook(new Book(7, "Misery", king, 135, drama));
        lib.addBook(new Book(8, "Carrie", king, 120, horror));

        lib.addBook(new Book(9, "American Gods", gaiman, 160, fantasy));
        lib.addBook(new Book(10, "Coraline", gaiman, 100, fantasy));
        lib.addBook(new Book(11, "Good Omens", gaiman, 170, fantasy));
        lib.addBook(new Book(12, "Neverwhere", gaiman, 155, fantasy));

        lib.addBook(new Book(13, "Norwegian Wood", murakami, 140, drama));
        lib.addBook(new Book(14, "Kafka on the Shore", murakami, 150, fiction));
        lib.addBook(new Book(15, "1Q84", murakami, 180, fiction));
        lib.addBook(new Book(16, "The Wind-Up Bird Chronicle", murakami, 175, fiction));

        lib.addBook(new Book(17, "Fight Club 2 (Comic)", chuck, 95, fiction));
        lib.addBook(new Book(18, "Lullaby", chuck, 115, drama));
        lib.addBook(new Book(19, "Survivor", chuck, 130, fiction));
        lib.addBook(new Book(20, "Rant", chuck, 140, fiction));

        System.out.println(">>> 20 kitap başarıyla yüklendi!");
    }
}
