package bookstore.classes;



import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;


@Data
@EqualsAndHashCode
@Entity
@Table(name = "shoppingcart")
public class ShoppingCart  {

    @Id
    @SequenceGenerator(
            name="cart_sequence",
            sequenceName = "cart_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cart_sequence"
    )
    private Long cartnumber;
    @Column
    private String uemail;
   // @Id
    @Column
    private Long isbn;
    public ShoppingCart() {
    }
    public ShoppingCart(String uemail, Long isbn) {
        this.uemail = uemail;
        this.isbn = isbn;
    }

    public String getuemail() {
        return uemail;
    }

    public void setUserID(String uemail) {
        this.uemail = uemail;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    // each shopping cart item is actually the isbn of a book and a user email


    @Override
    public String toString() {
        return "ShoppingCart{" +
                "uemail='" + uemail + '\'' +
                ", isbn=" + isbn +
                '}';
    }
}
