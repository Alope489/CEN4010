package bookstore.components.controllers;

import bookstore.classes.ShoppingCart;
import bookstore.components.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(path = "/shoppingcart-api")
public class ShoppingCartController {
    private final ShoppingCartService cartServ;

    @Autowired
    public ShoppingCartController(ShoppingCartService cartServ) {
        this.cartServ = cartServ;
    }

    @GetMapping
    public ResponseEntity<List<ShoppingCart>> getShoppingCart(@RequestParam String uemail) {
        try {
            List<ShoppingCart> shoppingCart = new ArrayList<>();
            shoppingCart.addAll(cartServ.findByuemail(uemail));
            if (shoppingCart.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(shoppingCart, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
     @DeleteMapping(path = "/shoppingcart-delete")
     public void deleteStuff (@RequestBody ShoppingCart shoppingCart){
        cartServ.delete(shoppingCart);
     }

    @PostMapping(value = "/add")
    public void createShoppingCart(@RequestBody ShoppingCart shoppingCart){

        cartServ.addNewShoppingCart(shoppingCart);
    }

}