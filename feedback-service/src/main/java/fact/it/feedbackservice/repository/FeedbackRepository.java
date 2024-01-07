package fact.it.feedbackservice.repository;

import fact.it.feedbackservice.model.Feedback;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FeedbackRepository extends MongoRepository<Feedback, String> {
}
