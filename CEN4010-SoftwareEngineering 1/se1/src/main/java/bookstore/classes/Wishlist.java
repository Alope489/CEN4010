package bookstore.classes;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class Wishlist {
    @Id
    @SequenceGenerator(
            name = "wishlist_sequence",
            sequenceName = "wishlist_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "wishlist_sequence"
    )
    private long id;
    @Column(name = "listname", columnDefinition = "varchar(20) NOT NULL")
    String listname;
    @Column(name = "uemail", columnDefinition = "varchar(30) NOT NULL")
    String uemail;
    @Column(name = "isbn", columnDefinition = "varchar(13)")
    String isbn;

    public Wishlist() {
    }

    public Wishlist(String listname, String uemail, String isbn) {
        this.listname = listname;
        this.uemail = uemail;
        this.isbn = isbn;
    }

    public String getListname() {
        return listname;
    }

    public void setListname(String listname) {
        this.listname = listname;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Wishlist{" +
                "listname='" + listname + '\'' +
                ", uemail='" + uemail + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wishlist)) return false;
        Wishlist wishlist = (Wishlist) o;
        return Objects.equals(listname, wishlist.listname) && Objects.equals(uemail, wishlist.uemail) && Objects.equals(isbn, wishlist.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listname, uemail, isbn);
    }
}
