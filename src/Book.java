import javafx.scene.image.Image;

public class Book {
    private String title, author;
    private int bookID, edition;
    double price;
    Image image;

    public Book(String title, String author, int bookID, int edition, double price, Image image) {
        setBookID(bookID);
        setTitle(title);
        setAuthor(author);
        setEdition(edition);
        setPrice(price);
        setImage(image);
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        if (bookID > 0)
            this.bookID = bookID;
        else
            throw new IllegalArgumentException("BookID must be greater than 0");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.isEmpty())
            throw new IllegalArgumentException("Title cannot be empty");
        else
            this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author.isEmpty())
            throw new IllegalArgumentException("Author cannot be empty");
        else
            this.author = author;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        if (edition > 0)
            this.edition = edition;
        else
            throw new IllegalArgumentException("edition must be greater than 0");
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0)
            this.price = price;
        else
            throw new IllegalArgumentException("price must be greater than 0");
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
