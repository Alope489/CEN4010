package bookstore.components.services;

import bookstore.classes.UserProfile;
import bookstore.components.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProfileService {
    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository)
    {
        this.profileRepository = profileRepository;
    }

    //Returns a list of all profiles
    public List<UserProfile> getProfile()
    {
        return profileRepository.findAll();
    }

    //Returns all emails with matching email address
    public List<UserProfile> getEmail(String email)
    {
        return profileRepository.findByUserEmail(email);
    }

    //Creates a new User Profile
    public void createProfile(UserProfile user_profile)
    {

        Optional<UserProfile> profileByEmail = profileRepository
                .findByEmail(user_profile.getEmail());

        //Checks to see if email exists
        if (profileByEmail.isPresent())
        {
            throw new IllegalStateException("Error: Email is already in use.");
        }

        profileRepository.save(user_profile);

        System.out.println(user_profile);
    }

    //Updates User Profile information
    @Transactional
    public void updateInfo(String userName, String password, String address, String name, String email)
    {
        UserProfile user_profile = profileRepository.findUserByEmail(email);

        //Password
        if (password != null && password.length() > 0 && !Objects.equals(user_profile.getPassword(), password))
        {
            user_profile.setPassword(password);
        }

        //Name
        if (name != null && name.length() > 0 && !Objects.equals(user_profile.getName(), name))
        {
            user_profile.setName(name);
        }

        //Address
        if (address != null && address.length() > 0 && !Objects.equals(user_profile.getAddress(), address)) {
            user_profile.setAddress(address);
        }

        //User Name
        if (userName != null && userName.length() > 0 && !Objects.equals(user_profile.getUserName(), userName)) {
            user_profile.setUserName(userName);
        }
    }

}