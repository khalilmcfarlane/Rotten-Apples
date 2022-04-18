package CS1530.RottenApples.sequenceGenerator;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customSequences")
public class CustomSequences {
    @Id
    private String id;
    private Long seq;

    public Long getSeq() {
        return seq;
    }
    public void setSeq(long seq) {
        this.seq = seq;
    }

}
