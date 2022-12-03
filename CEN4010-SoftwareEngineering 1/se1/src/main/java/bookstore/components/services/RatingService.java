package bookstore.components.services;

import bookstore.classes.User_Rating;
import bookstore.components.repositories.RatingRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service //can be @Component
public class RatingService {

    private final RatingRepository ratingRepository;
    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }
        public List<User_Rating> getRating() {
        return ratingRepository.findAll();
    }

    public void addUser_Rating(User_Rating user_rating) {
        Optional<User_Rating> user_ratingOptional = ratingRepository
                .findUser_RatingByUemail(user_rating.getUemail());
        if(user_ratingOptional.isPresent()){                                    // Q: Is this exception an allowed constraint for the user?
            throw new IllegalStateException("rating already registered");
        }
        ratingRepository.save(user_rating);
        }

    @Transactional
    public void updateUser_Rating(byte rating, String date_posted, String uemail, String udname, long isbn){
        User_Rating user_rating = ratingRepository.findUser_RatingByUemail(uemail)
                .orElseThrow(() -> new IllegalStateException("rating by this user email " + uemail + " does not exist"));
     if(uemail!=null &&
             uemail.length()>0 &&
             !Objects.equals(user_rating.getUemail(),uemail)){
         Optional<User_Rating> user_ratingOptional = ratingRepository
                 .findUser_RatingByUemail(uemail);
         if(user_ratingOptional.isPresent()){
             throw new IllegalStateException("email is taken");
         }
         user_rating.setRating(rating);
     }
    }


}
