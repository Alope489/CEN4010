package bookstore.components.repositories;

import bookstore.classes.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Books, String> {
    @Query("SELECT b FROM Books b WHERE b.genre = ?1")
    List<Books> findBooksByGenre(String genre);

    @Query(nativeQuery = true, value = "SELECT * FROM books b ORDER BY b.copies_sold DESC LIMIT 10")
    List<Books> findTop10ByOrderByCopies_sold();

    @Query(nativeQuery = true, value = "SELECT b.* FROM books b INNER JOIN user_ratings ur ON (b.isbn = ur.isbn) " +
            "GROUP BY b.isbn, b.authorfn, b.authorln, b.publisher, b.bookname " +
            "HAVING AVG(ur.rating) >= ?1")
    List<Books> findBooksWithRatingHigherThan(int ratingBound);

    @Query(nativeQuery = true, value = "SELECT * FROM (" +
            "   SELECT" +
            "      Row_Number() Over (Order By b.isbn) as Index " +
            "    , * " +
            "    FROM books b" +
            ") t2 " +
            "WHERE Index >= ?1 AND Index < ?2")
    List<Books> findBooksByIndexRange(int index1, int index2);
}
