package bookstore.components.controllers;

import bookstore.classes.User_Rating;
import bookstore.components.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/ratings")
public class RatingsController {

    private final RatingService ratingService;
    @Autowired
      public RatingsController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping
    public List<User_Rating> getRating(){ // the List type is used
          return ratingService.getRating();
    }
    @PostMapping
    public void registerNewUser_Rating(@RequestBody User_Rating user_rating){
        ratingService.addUser_Rating(user_rating);
}
  /*  @DeleteMapping(path = "{user_RatingByUemail}")                                        //Deleting is not necessary
    public void deleteUser_Rating(@PathVariable("user_RatingByUemail")String uemail){
    ratingService.deleteUser_Rating(uemail);
    }
*/
    @PutMapping (path={"{rating}"})
    public void updateUser_Rating(
            @PathVariable("rating") byte rating,
            @RequestParam(required = false) String date_posted,
            @RequestParam(required = true) String uemail,
            @RequestParam(required = false) String udname,
            @RequestParam(required = false) long isbn){
        ratingService.updateUser_Rating(rating, date_posted, uemail, udname, isbn);
    }




}

