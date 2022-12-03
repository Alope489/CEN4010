package bookstore.classes;

public class Authors {
    String fName;
    String lName;
    String publisher;
    String biography;

    public Authors(String fName, String lName, String publisher, String biography) {
        this.fName = fName;
        this.lName = lName;
        this.publisher = publisher;
        this.biography = biography;
    }

    public Authors(String fName, String lName, String publisher) {
        this.fName = fName;
        this.lName = lName;
        this.publisher = publisher;
    }

    public Authors() {
    }

    public String getfName() {
        return fName;
    }

    public void setName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
    
}
