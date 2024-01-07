package fact.it.feedbackservice;

import fact.it.feedbackservice.dto.FeedbackResponse;
import fact.it.feedbackservice.model.Feedback;
import fact.it.feedbackservice.repository.FeedbackRepository;
import fact.it.feedbackservice.service.FeedbackService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class FeedbackServiceApplicationTests {

    @InjectMocks
    private FeedbackService feedbackService;

    @Mock
    private FeedbackRepository feedbackRepository;

    @Test
    public void testGetAllFeedback() {
        // Arrange
        Feedback feedback = new Feedback();
        feedback.setCourseNumber("001");
        feedback.setComment("Goed");
        feedback.setRating(10);

        when(feedbackRepository.findAll()).thenReturn(Collections.singletonList(feedback));

        // Act
        List<FeedbackResponse> result = feedbackService.getAllFeedback();

        // Assert
        verify(feedbackRepository, times(1)).findAll();
        assertEquals(1, result.size());
        assertEquals("001", result.get(0).getCourseNumber());
        assertEquals("Goed", result.get(0).getComment());
        assertEquals(10, result.get(0).getRating());
    }

    @Test
    public void testGetFeedbackByCourseNumber() {
        // Arrange
        Feedback feedback = new Feedback();
        feedback.setCourseNumber("001");
        feedback.setComment("Goed");
        feedback.setRating(10);

        when(feedbackRepository.findByCourseNumber(anyString())).thenReturn(Collections.singletonList(feedback));

        // Act
        List<FeedbackResponse> result = feedbackService.getFeedbackByCourseNumber("001");

        // Assert
        verify(feedbackRepository, times(1)).findByCourseNumber(anyString());
        assertEquals(1, result.size());
        assertEquals("001", result.get(0).getCourseNumber());
        assertEquals("Goed", result.get(0).getComment());
        assertEquals(10, result.get(0).getRating());
    }
}