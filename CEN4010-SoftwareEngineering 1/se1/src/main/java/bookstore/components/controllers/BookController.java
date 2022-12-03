package bookstore.components.controllers;

import bookstore.classes.Books;
import bookstore.components.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(path = "/browse-api")
public class BookController {
    private final BookService bookServ;

    @Autowired
    public BookController(BookService bookServ) {
        this.bookServ = bookServ;
    }

    @GetMapping
    public ResponseEntity<List<Books>> getBooks(@RequestParam(required = false) String genre,
                                               @RequestParam(required = false) Integer ratingBound) {
        try {
            List<Books> books = new ArrayList<>();
            if (genre == null && ratingBound == null) {
                books.addAll(bookServ.getBooks());

            } else if (ratingBound == null) {
                books.addAll(bookServ.getBooksInGenre(genre));

            } else {
                books.addAll(bookServ.getBooksWithRatingHigherThan(ratingBound));
            }

            if (books.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/top-sellers")
    public List<Books> getTopSeller() {
        return bookServ.getTopSelling();
    }

    @GetMapping(path = "/range")
    public List<Books> getInRange(@RequestParam int index,
                                 @RequestParam int quantity) {

        return bookServ.getBooksByIndexRange(index, quantity);
    }
}
