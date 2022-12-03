package bookstore.components.controllers;

import bookstore.classes.ShoppingCart;
import bookstore.classes.Wishlist;
import bookstore.components.services.ShoppingCartService;
import bookstore.components.services.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "api-wishlist")
public class WishlistController {


    private final WishlistService wishlistService;

    @Autowired
    public WishlistController(WishlistService wishlistService, ShoppingCartService shoppingCartService){
        this.wishlistService = wishlistService;
    }

    @GetMapping(path = "/get")
    //gets all lists and books
    public List<Wishlist> getAllWishlists(){
        return wishlistService.getWishlists();
    }

    @GetMapping(path = "/get/user-list")
    //gets a specific users list
    public List<Wishlist> getWishlists(@RequestBody Wishlist wishlist){
        return wishlistService.getWishlists(wishlist.getUemail(), wishlist.getListname());
    }

    @PostMapping(path = "/post/wishlist")
    // creates a list
    public void createNewWishlist(@RequestBody Wishlist wishlist){
        wishlistService.addNewWishlist(wishlist);
    }

    @PostMapping(path = "post/book")
    // adds a book to the list
    public void addBookToWishlist (@RequestBody Wishlist wishlist){
        wishlistService.addBookToWishlist(wishlist);
    }

    @DeleteMapping(path = "post/add-to-cart")
    @Transactional
    public void addBookToShoppingCart(@RequestBody Wishlist wishlist){
        wishlistService.addToCart(wishlist.getUemail(), wishlist.getIsbn());
        wishlistService.addToCart(wishlist);

    }

}