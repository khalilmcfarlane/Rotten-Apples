package CS1530.RottenApples.models;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "friendRequest")
public class friendRequest {
    private User sender;
    private User recipient;

    public friendRequest(User sender, User recipient) {
        this.sender = sender;
        this.recipient = recipient;
    }
    public User getSender() {
        return sender;
    }
    public void setSender(User sender) {
        this.sender = sender;
    }
    public User getRecipient() {
        return recipient;
    }
    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }
   
}
