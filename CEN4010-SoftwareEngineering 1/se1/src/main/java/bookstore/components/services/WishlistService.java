package bookstore.components.services;

import bookstore.classes.ShoppingCart;
import bookstore.classes.Wishlist;
import bookstore.components.controllers.ShoppingCartController;
import bookstore.components.repositories.ShoppingCartRepository;
import bookstore.components.repositories.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WishlistService {

    private final WishlistRepository wishlistRepository;
    private final ShoppingCartService shoppingCartService;
    private static Integer numLists;
    @Autowired
    public WishlistService(WishlistRepository wishlistRepository, ShoppingCartRepository shoppingCartRepository, ShoppingCartService shoppingCartService) {
        this.wishlistRepository = wishlistRepository;
        this.shoppingCartService = shoppingCartService;
    }

    public void addNewWishlist(Wishlist wishlist) {
        numLists = wishlistRepository.countWishlistsByUemailAndIsbn(wishlist.getUemail(), null);
        if (numLists < 3) {
            Optional<Wishlist> userOptional1 = wishlistRepository.findByUemailAndListnameAndIsbn(wishlist.getUemail(), wishlist.getListname(), null);
            System.out.println(numLists);
            if (wishlist.getIsbn() == null) {
                if (userOptional1.isPresent()) {
                    throw new IllegalStateException("list already exists");
                }
                wishlistRepository.save(wishlist);
            } else {
                throw new IllegalStateException("You cannot add a book here");
            }
        }else {
            throw new IllegalStateException("Can't add more than 3 lists");
        }
    }

    public void addBookToWishlist(Wishlist wishlist) {
        Optional<Wishlist> userOptional1 = wishlistRepository.findByUemailAndListnameAndIsbn(wishlist.getUemail(), wishlist.getListname(), null);
        if (wishlist.getIsbn() != null){
            if (!userOptional1.isPresent()){
                throw new IllegalStateException("No list to add book to");
            }
            userOptional1 = wishlistRepository.findByUemailAndListnameAndIsbn(wishlist.getUemail(), wishlist.getListname(), wishlist.getIsbn());
            if (userOptional1.isPresent()){
                throw new IllegalStateException("The book is already in that list");
            }
        }
        wishlistRepository.save(wishlist);
    }


    public List<Wishlist> getWishlists(){
        return wishlistRepository.findAll();
    }


    public List<Wishlist> getWishlists(String uemail, String listname) {
        return wishlistRepository.getAllByListnameAndUemailAndIsbnIsNotNull( listname, uemail);
    }

    public void addToCart(String uemail, String isbn) {
        ShoppingCart cart = new ShoppingCart(uemail, Long.parseLong(isbn));
        shoppingCartService.addNewShoppingCart(cart);
    }

    public void addToCart(Wishlist wishlist){
        wishlistRepository.deleteWishlistByUemailAndIsbn(wishlist.getUemail(), wishlist.getIsbn());
    }
}
