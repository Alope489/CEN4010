package bookstore.classes;

import java.util.Date;

public class Comments {
    private String userID;
    private String userDisplayName;
    private String userComment;
    private Date datePosted;
    private long isbn;

    public String getUserID() {
        return userID;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public long getIsbn() {
        return isbn;
    }

    public String getUserDisplayName() {
        return userDisplayName;
    }

    public void setUserDisplayName(String userDisplayName) {
        this.userDisplayName = userDisplayName;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }
}
