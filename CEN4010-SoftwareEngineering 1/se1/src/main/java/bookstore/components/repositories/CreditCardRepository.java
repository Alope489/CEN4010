package bookstore.components.repositories;

import bookstore.classes.CreditCards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCards, String> {

}
