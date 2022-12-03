package bookstore.components.controllers;

import bookstore.classes.CreditCards;
import bookstore.components.repositories.CreditCardRepository;
import bookstore.components.repositories.ProfileRepository;
import bookstore.components.services.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/creditcards")
public class CreditCardController {

    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    CreditCardRepository creditCardRepository;

    private final CreditCardService creditCardService;

    @Autowired
    public CreditCardController (CreditCardService creditCardService)
    {
        this.creditCardService = creditCardService;
    }

    //Get
    @GetMapping
    public List<CreditCards> retrieveCard()
    {
        return creditCardService.retrieveCard();
    }

    //Post
    @PostMapping("/cardRegistration")
    public void createCreditCard(@RequestBody CreditCards creditCards)
    {
        creditCardService.addNewCreditCard(creditCards);
    }

    //Put
    @PutMapping("/{cardNum}/{userID}")
    public CreditCards cardAndProfile(@PathVariable String cardNum, @PathVariable String userID)
    {
        return creditCardService.assignCreditCardToUserProfile(cardNum, userID);
    }
}
