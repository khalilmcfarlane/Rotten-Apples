package CS1530.RottenApples.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "friendRequest")
public class friendRequest {
    @Id
    private long id;
    private User sender;
    private User recipient;
    private boolean accepted;

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
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public boolean isAccepted() {
        return accepted;
    }
    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
   
}
