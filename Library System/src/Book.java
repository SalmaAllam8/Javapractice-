import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Book {

    Long id;
    String title;

    Author author;

    double price;

    String category ;

    Boolean available;

    String borrowingstart;
    String borrowingend;
    Long userId;


    ArrayList<Author> muliauthors = new ArrayList<Author>();

    public Book(Long id, String title, Author author, double price, String category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;

        this.category = category;
        muliauthors.add(author);
    }



    public void addAuthor(Author author){
        muliauthors.add(author);

    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Author> getAuthor() {
        return muliauthors.stream().toList();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAuthor(Author author) {
        this.author = author;
        muliauthors.add(author);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public <T> Object getBorrowingstart() {
        return borrowingstart;
    }

    public void setBorrowingstart(String borrowingstart) {


        this.borrowingstart = borrowingstart;
        LocalDateTime start = LocalDateTime.parse(borrowingstart, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public <T>Object getBorrowingend() {
        return borrowingend;
    }

    public void setBorrowingend(String borrowingend) {
        this.borrowingend = borrowingend;
        LocalDateTime end = LocalDateTime.parse(borrowingend, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", available=" + available +
                ", Authors=" + muliauthors.stream().toList() +
                '}';
    }


}
