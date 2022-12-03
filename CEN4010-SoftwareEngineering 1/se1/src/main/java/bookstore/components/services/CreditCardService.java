package bookstore.components.services;

import bookstore.classes.CreditCards;
import bookstore.classes.UserProfile;
import bookstore.components.repositories.CreditCardRepository;
import bookstore.components.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardService {
    private final ProfileRepository profileRepository;
    private final CreditCardRepository creditCardRepository;

    @Autowired
    public CreditCardService(ProfileRepository profileRepository, CreditCardRepository creditCardRepository)
    {
        this.profileRepository = profileRepository;
        this.creditCardRepository = creditCardRepository;
    }

    //Retrieves Card
    public List<CreditCards> retrieveCard()
    {
        return creditCardRepository.findAll();
    }

    public void addNewCreditCard(CreditCards creditCards)
    {
        creditCardRepository.save(creditCards);
        System.out.println(creditCards);
    }

    public CreditCards assignCreditCardToUserProfile(String cardNum, String userID)
    {
        CreditCards creditCards = creditCardRepository.findById(cardNum).get();
        UserProfile userProfile = profileRepository.findByEmail(userID).get();

        creditCards.assignUserProfile(userProfile);

        return creditCardRepository.save(creditCards);
    }

}
