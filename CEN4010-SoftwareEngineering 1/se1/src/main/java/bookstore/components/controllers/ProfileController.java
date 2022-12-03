package bookstore.components.controllers;

import bookstore.classes.UserProfile;
import bookstore.components.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/userProfile")
public class ProfileController
{
    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService)
    {
        this.profileService = profileService;
    }

    //Get
    @GetMapping
    public List<UserProfile> getProfile()
    {
        return profileService.getProfile();
    }

    @GetMapping("/{userEmail}")
    public List<UserProfile> getEmail(@PathVariable String userEmail)
    {
        return profileService.getEmail(userEmail);
    }

    //Post
    @PostMapping
    public void newProfileRegistration(@RequestBody UserProfile user_profile)
    {
        profileService.createProfile(user_profile);
    }

    //Put
    @PutMapping(path = "/{userEmail}")
    public void profileUpdate(
            @PathVariable String email,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String userName,
            @RequestParam(required = false) String address)
    {
        profileService.updateInfo(userName, password, address, name, email);
    }
}
