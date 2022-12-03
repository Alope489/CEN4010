package bookstore.components.repositories;


import bookstore.classes.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist,String> {

    List<Wishlist> getAllByListnameAndUemailAndIsbnIsNotNull(String uemail, String listname);
    Optional<Wishlist> findByUemailAndListnameAndIsbn(String uemail, String listname, String isbn);
    Integer countWishlistsByUemailAndIsbn(String uemail, String isbn);
    Optional<Wishlist> deleteWishlistByUemailAndIsbn(String listname, String uemail);

}