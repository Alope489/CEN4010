package bookstore.components.services;

import bookstore.classes.Books;
import bookstore.components.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepo;

    @Autowired
    public BookService(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Books> getBooksInGenre(String genre) {
        return bookRepo.findBooksByGenre(genre);
    }

    public List<Books> getTopSelling() {
        return bookRepo.findTop10ByOrderByCopies_sold();
    }

    public List<Books> getBooks() {
        return bookRepo.findAll();
    }

    public List<Books> getBooksWithRatingHigherThan(int num) {
        return bookRepo.findBooksWithRatingHigherThan(num);
    }

    public List<Books> getBooksByIndexRange(int startIndex, int quantity) {
        int endIndex = startIndex + quantity;
        return bookRepo.findBooksByIndexRange(startIndex, endIndex);
    }
}
