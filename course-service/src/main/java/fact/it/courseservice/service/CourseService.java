package fact.it.courseservice.service;

import fact.it.courseservice.dto.CourseRequest;
import fact.it.courseservice.dto.CourseResponse;
import fact.it.courseservice.dto.FeedbackResponse;
import fact.it.courseservice.dto.StudentResponse;
import fact.it.courseservice.model.Course;
import fact.it.courseservice.repository.CourseRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final WebClient webClient;

    @PostConstruct
    public void loadData() {
        if(courseRepository.count() == 0){
            Course course = new Course();
            course.setCourseNumber("001");
            course.setTitle("course 1");
            course.setDescription("this is course one");
            course.setInstructor("instructor 1");

            Course course2 = new Course();
            course2.setCourseNumber("002");
            course2.setTitle("course 2");
            course2.setDescription("this is course two");
            course2.setInstructor("instructor 2");

            Course course3 = new Course();
            course3.setCourseNumber("003");
            course3.setTitle("course 3");
            course3.setDescription("this is course three");
            course3.setInstructor("instructor 3");

            Course course4 = new Course();
            course4.setCourseNumber("004");
            course4.setTitle("course 4");
            course4.setDescription("this is course four");
            course4.setInstructor("instructor 4");

            Course course5 = new Course();
            course5.setCourseNumber("005");
            course5.setTitle("course 5");
            course5.setDescription("this is course five");
            course5.setInstructor("instructor 5");

            courseRepository.save(course);
            courseRepository.save(course2);
            courseRepository.save(course3);
            courseRepository.save(course4);
            courseRepository.save(course5);
        }
    }

    public CourseResponse createCourse(CourseRequest courseRequest) {
        Course course = Course.builder()
                .courseNumber(courseRequest.getCourseNumber())
                .title(courseRequest.getTitle())
                .description(courseRequest.getDescription())
                .instructor(courseRequest.getInstructor())
                .build();
        return mapToCourseResponse(course);
    }

    public List<CourseResponse> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream().map(this::mapToCourseResponse).toList();
    }

    public CourseResponse getCourseByCourseNumber(String courseNumber) {
        Course course = courseRepository.findByCourseNumber(courseNumber);
        return mapToCourseResponse(course);
    }

    public List<FeedbackResponse> getFeedbackForCourse(String courseNumber) {
        return webClient
                .get()
                .uri("http://localhost:8080/api/feedback/byCourse?courseNumber=" + courseNumber)
                .retrieve()
                .bodyToFlux(FeedbackResponse.class)
                .collectList()
                .block();
    }

    public List<StudentResponse> getStudentsForCourse(String courseNumber) {
        return webClient
                .get()
                .uri("http://localhost:8081/api/students/byCourse?courseNumber=" + courseNumber)
                .retrieve()
                .bodyToFlux(StudentResponse.class)
                .collectList()
                .block();
    }

    private CourseResponse mapToCourseResponse(Course course) {
        return CourseResponse.builder()
                .id(course.getId())
                .courseNumber(course.getCourseNumber())
                .title(course.getTitle())
                .description(course.getDescription())
                .instructor(course.getInstructor())
                .build();
    }
}
