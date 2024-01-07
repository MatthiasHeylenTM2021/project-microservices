package fact.it.feedbackservice.controller;

import fact.it.feedbackservice.dto.FeedbackRequest;
import fact.it.feedbackservice.dto.FeedbackResponse;
import fact.it.feedbackservice.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
@RequiredArgsConstructor
public class FeedbackController {

    private final FeedbackService feedbackService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<FeedbackResponse> getAllFeedback() {
        return feedbackService.getAllFeedback();
    }

    @GetMapping("/byCourse")
    @ResponseStatus(HttpStatus.OK)
    public List<FeedbackResponse> getFeedbackByCourseNumber(@RequestParam String courseNumber) {
        return feedbackService.getFeedbackByCourseNumber(courseNumber);
    }
}

