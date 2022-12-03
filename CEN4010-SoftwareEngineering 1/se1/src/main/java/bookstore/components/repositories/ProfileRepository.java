package bookstore.components.repositories;

import bookstore.classes.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<UserProfile, Long> {

    @Query("SELECT s FROM UserProfile s WHERE s.email = ?1")
    List<UserProfile> findByUserEmail(String email);

    Optional<UserProfile> findByEmail(String email);

    UserProfile findUserByEmail(String email);
}
