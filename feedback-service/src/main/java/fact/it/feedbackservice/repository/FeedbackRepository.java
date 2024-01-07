package fact.it.feedbackservice.repository;

import fact.it.feedbackservice.model.Feedback;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FeedbackRepository extends MongoRepository<Feedback, String> {
    List<Feedback> findByCourseNumber(String courseNumber);
}
