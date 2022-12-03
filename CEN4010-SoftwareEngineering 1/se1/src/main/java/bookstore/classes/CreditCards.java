package bookstore.classes;

import javax.persistence.*;

@Entity
@Table(name = "creditcards")
public class CreditCards {
    @Id
    @Column(name = "card_number", unique = true)
    private String cardNum;

    @Column(name = "useremail")
    private String userID;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "useremail", referencedColumnName = "uemail", insertable = false, updatable = false)
    private UserProfile userProfile;

    //Constructor
    public CreditCards()
    {

    }

    public CreditCards(String userID, String cardNum)
    {
        this.userID = userID;
        this.cardNum = cardNum;
    }

    public CreditCards(String userID, String cardNum, UserProfile userProfile)
    {
        this.userID = userID;
        this.cardNum = cardNum;
        this.userProfile = userProfile;
    }

    //Getter
    public String getUserID()
    {
        return userID;
    }

    public String getCardNum()
    {
        return cardNum;
    }

    public UserProfile getUserProfile()
    {
        return userProfile;
    }

    //Setter
    public void setUserID(String userID)
    {
        this.userID = userID;
    }

    public void setCardNum(String cardNum)
    {
        this.cardNum = cardNum;
    }
    public void assignUserProfile(UserProfile userProfile)
    {
        this.userProfile = userProfile;
    }

    @Override
    public String toString()
    {
        return "CreditCard{" +
                "CardNumber = " + cardNum +
                "User ID = " + userID +
                "}";
    }
}
