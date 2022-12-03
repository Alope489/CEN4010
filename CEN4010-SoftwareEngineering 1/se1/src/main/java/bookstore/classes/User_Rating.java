package bookstore.classes;

import lombok.NoArgsConstructor;
import javax.persistence.*;  //recommended
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_ratings")
@NoArgsConstructor

public class User_Rating{
@Id
@SequenceGenerator(name="rating", sequenceName = "rating", allocationSize = 1)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rating")
    private String uemail;
    private String udname;
    private byte rating;
    private String date_posted;
    private long isbn;

    public User_Rating(String uemail, String udname, byte rating, String date_posted, long isbn) {
        this.uemail = uemail;
        this.udname = udname;
        this.rating = rating;
        this.date_posted = date_posted;
        this.isbn = isbn;
    }

    public void setUdname(String udname) {
        this.udname = udname;
    }

    public void setRating(byte rating) {
        this.rating = rating;
    }

    public String getUemail() {
        return uemail;
    }

    public String getUdname() {
        return udname;
    }

    public byte getRating() {
        return rating;
    }

    public String getDate_posted() {
        return date_posted;
    }

    public long getIsbn() {
        return isbn;
    }
}
