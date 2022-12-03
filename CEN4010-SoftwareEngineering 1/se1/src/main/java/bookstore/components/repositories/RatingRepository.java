// data access layer
package bookstore.components.repositories;
import bookstore.classes.User_Rating;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RatingRepository extends JpaRepository<User_Rating,String> {

@Query("SELECT ue FROM User_Rating ue WHERE ue.uemail =?1") //THIS IS JDQL NOT SQL
Optional<User_Rating> findUser_RatingByUemail(String uemail); //SINCE WE CANNOT HAVE DUPLICATE EMAILS RATINGS

}


