package bookstore.components.services;


import bookstore.classes.ShoppingCart;
import bookstore.components.repositories.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService {
    private final ShoppingCartRepository cartRepo;

    @Autowired
    public ShoppingCartService(ShoppingCartRepository cartRepo) {
        this.cartRepo = cartRepo;
    }

    public List<ShoppingCart> findByuemail(String uemail) {
        return cartRepo.findByuemail(uemail);
    }

    public List<ShoppingCart> findByuemailisbn(String uemail, Long isbn) {
        return cartRepo.findByuemailisbn(uemail, isbn);
    }

    public void addNewShoppingCart(ShoppingCart shoppingCart) {
        cartRepo.save(shoppingCart);
    }

    public void delete(ShoppingCart shoppingCart) {
        cartRepo.delete(shoppingCart);
        System.out.println("book was removed");
    }

}