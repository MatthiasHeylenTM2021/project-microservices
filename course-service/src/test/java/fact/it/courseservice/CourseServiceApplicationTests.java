package fact.it.courseservice;

import fact.it.courseservice.dto.CourseRequest;
import fact.it.courseservice.dto.CourseResponse;
import fact.it.courseservice.model.Course;
import fact.it.courseservice.repository.CourseRepository;
import fact.it.courseservice.service.CourseService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class CourseServiceApplicationTests {

    @InjectMocks
    private CourseService courseService;

    @Mock
    private CourseRepository courseRepository;

    @Mock
    private WebClient webClient;

    @Test
    public void testCreateCourse() {
        // Arrange
        CourseRequest courseRequest = new CourseRequest();
        courseRequest.setCourseNumber("001");
        courseRequest.setTitle("course 1");
        courseRequest.setDescription("this is course one");
        courseRequest.setInstructor("instructor 1");

        Course course = new Course();
        course.setCourseNumber("001");
        course.setTitle("course 1");
        course.setDescription("this is course one");
        course.setInstructor("instructor 1");

        when(courseRepository.save(any(Course.class))).thenReturn(course);

        // Act
        CourseResponse result = courseService.createCourse(courseRequest);

        // Assert
        verify(courseRepository, times(1)).save(any(Course.class));
        assertEquals("001", result.getCourseNumber());
        assertEquals("course 1", result.getTitle());
        assertEquals("this is course one", result.getDescription());
        assertEquals("instructor 1", result.getInstructor());
    }

    @Test
    public void testGetAllCourses() {
        // Arrange
        Course course = new Course();
        course.setCourseNumber("001");
        course.setTitle("course 1");
        course.setDescription("this is course one");
        course.setInstructor("instructor 1");

        when(courseRepository.findAll()).thenReturn(Collections.singletonList(course));

        // Act
        List<CourseResponse> result = courseService.getAllCourses();

        // Assert
        verify(courseRepository, times(1)).findAll();
        assertEquals(1, result.size());
        assertEquals("001", result.get(0).getCourseNumber());
        assertEquals("course 1", result.get(0).getTitle());
        assertEquals("this is course one", result.get(0).getDescription());
        assertEquals("instructor 1", result.get(0).getInstructor());
    }

    @Test
    public void testGetCourseByCourseNumber() {
        // Arrange
        Course course = new Course();
        course.setCourseNumber("001");
        course.setTitle("course 1");
        course.setDescription("this is course one");
        course.setInstructor("instructor 1");

        when(courseRepository.findByCourseNumber(anyString())).thenReturn(course);

        // Act
        CourseResponse result = courseService.getCourseByCourseNumber("001");

        // Assert
        verify(courseRepository, times(1)).findByCourseNumber(anyString());
        assertEquals("001", result.getCourseNumber());
        assertEquals("course 1", result.getTitle());
        assertEquals("this is course one", result.getDescription());
        assertEquals("instructor 1", result.getInstructor());
    }
}