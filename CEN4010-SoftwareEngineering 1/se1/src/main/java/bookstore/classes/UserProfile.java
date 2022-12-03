package bookstore.classes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "userprofile")
public class UserProfile {
    @Id
    @Column(name = "uemail", unique = true)
    private String email;

    @Column(name = "upassword")
    private String password;

    @Column(name = "udname")
    private String userName;

    @Column(name = "uaddress")
    private String address;

    @Column(name = "uname")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "userProfile")

    //Credit Card
    private Set<CreditCards> userCard = new HashSet<>();

    //Constructor
    public UserProfile()
    {

    }

    public UserProfile(String email, String userName, String password)
    {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public UserProfile(String email, String userName, String password, String name, String address)
    {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.name = name;
        this.address = address;
    }

    //Getters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    //Setters
    public void setAddress(String address) {
        this.address = address;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    //User Credit Card
    public Set<CreditCards> retrieveCard()
    {
        return userCard;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}
