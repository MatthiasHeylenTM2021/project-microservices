package fact.it.feedbackservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "feedback")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Feedback {
    @Id
    private String id;
    private String courseNumber;
    private String comment;
    private int rating;
}
