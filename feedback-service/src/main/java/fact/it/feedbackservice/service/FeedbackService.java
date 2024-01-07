package fact.it.feedbackservice.service;

import fact.it.feedbackservice.dto.FeedbackRequest;
import fact.it.feedbackservice.dto.FeedbackResponse;
import fact.it.feedbackservice.model.Feedback;
import fact.it.feedbackservice.repository.FeedbackRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    @PostConstruct
    public void loadData() {
        if (feedbackRepository.count() == 0) {
            Feedback feedback = new Feedback();
            feedback.setCourseNumber("001");
            feedback.setComment("Goed");
            feedback.setRating(10);

            Feedback feedback2 = new Feedback();
            feedback2.setCourseNumber("001");
            feedback2.setComment("Slecht");
            feedback2.setRating(1);

            feedbackRepository.save(feedback);
            feedbackRepository.save(feedback2);
        }
    }
    public void createFeedback(FeedbackRequest feedbackRequest){
        Feedback feedback = Feedback.builder()
                .comment(feedbackRequest.getComment())
                .rating(feedbackRequest.getRating())
                .build();

        feedbackRepository.save(feedback);
    }

    public List<FeedbackResponse> getAllFeedback() {
        List<Feedback> feedbacks = feedbackRepository.findAll();

        return feedbacks.stream().map(this::mapToFeedbackResponse).toList();
    }

    public List<FeedbackResponse> getFeedbackByCourseNumber(String courseNumber) {
        List<Feedback> students = feedbackRepository.findByCourseNumber(courseNumber);
        return students.stream().map(this::mapToFeedbackResponse).toList();
    }

    private FeedbackResponse mapToFeedbackResponse(Feedback feedback) {
        return FeedbackResponse.builder()
                .id(feedback.getId())
                .courseNumber(feedback.getCourseNumber())
                .comment(feedback.getComment())
                .rating(feedback.getRating())
                .build();
    }

}
