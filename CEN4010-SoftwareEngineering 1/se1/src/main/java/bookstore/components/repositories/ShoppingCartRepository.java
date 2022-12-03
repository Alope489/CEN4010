package bookstore.components.repositories;


import bookstore.classes.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, String> {


     @Query("SELECT u FROM ShoppingCart u WHERE u.uemail = ?1")
     List<ShoppingCart> findByuemail(String uemail);
     @Query("SELECT u FROM ShoppingCart u WHERE u.uemail = ?1 AND u.isbn = ?2")
     List<ShoppingCart> findByuemailisbn(String uemail, Long isbn);


}
