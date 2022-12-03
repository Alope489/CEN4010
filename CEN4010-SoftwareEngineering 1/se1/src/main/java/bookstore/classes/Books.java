package bookstore.classes;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "books")
@NoArgsConstructor
public class Books {
    @Id
    @Column
    private String isbn;
    @Column(name = "authorfn")
    private String authorFirstName;
    @Column(name = "authorln")
    private String authorLastName;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "bookname")
    private String bookName;
    @Column(name = "book_description")
    private String bookDescription;
    @Column
    private String genre;
    @Column
    private double price;
    @Column(name = "year_published")
    private Date yearPublished;
    @Column(name = "copies_sold")
    private int copiesSold;

    public Books(String isbn, String authorFirstName, String authorLastName, String publisher, String bookName, String bookDescription, String genre, double price, Date yearPublished, int copiesSold) {
        this.isbn = isbn;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.publisher = publisher;
        this.bookName = bookName;
        this.bookDescription = bookDescription;
        this.genre = genre;
        this.price = price;
        this.yearPublished = yearPublished;
        this.copiesSold = copiesSold;
    }

    public String getIsbn() {
        return isbn;
    }
    public String getAuthorFirstName() {
        return authorFirstName;
    }
    public String getAuthorLastName() {
        return authorLastName;
    }
    public String getPublisher() {
        return publisher;
    }
    public String getBookName() {
        return bookName;
    }
    public String getBookDescription() {
        return bookDescription;
    }
    public String getGenre() {
        return genre;
    }
    public double getPrice() {
        return price;
    }
    public Date getYearPublished() {
        return yearPublished;
    }
    public int getCopiesSold() {
        return copiesSold;
    }

}
