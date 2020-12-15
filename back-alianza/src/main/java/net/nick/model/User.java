package net.nick.model;

/**
 *
 * @author Nick
 */
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private final String sharedKey;
    private final String name;
    private final String email;
    private final Date dateAdded;
    
    public User() {
        this.sharedKey = "";
        this.name = "";
        this.email = "";
        this.dateAdded = new Date();
    }
    
    public User(String sharedKey, String name, String email, Date dateAdded) {
        this.sharedKey = sharedKey;
        this.name = name;
        this.email = email;
        this.dateAdded = dateAdded;
    }

    public long getId() {
        return id;
    }

    public String getSharedKey() {
        return sharedKey;
    }   
        
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    
    public Date getDateAdded() {
        return dateAdded;
    }
    
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", sharedKey=" + sharedKey + ", name=" + name + ", email=" + email + '}';
    }
}

