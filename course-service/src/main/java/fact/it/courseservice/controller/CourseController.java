package fact.it.courseservice.controller;

import fact.it.courseservice.dto.CourseRequest;
import fact.it.courseservice.dto.CourseResponse;
import fact.it.courseservice.dto.FeedbackResponse;
import fact.it.courseservice.dto.StudentResponse;
import fact.it.courseservice.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CourseResponse createCourse(@RequestBody CourseRequest courseRequest) {
        return courseService.createCourse(courseRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CourseResponse> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{courseNumber}")
    @ResponseStatus(HttpStatus.OK)
    public CourseResponse getCourseByCourseNumber(@PathVariable String courseNumber) {
        return courseService.getCourseByCourseNumber(courseNumber);
    }

    @GetMapping("/{courseNumber}/feedback")
    @ResponseStatus(HttpStatus.OK)
    public List<FeedbackResponse> getFeedbackForCourse(@PathVariable String courseNumber) {
        return courseService.getFeedbackForCourse(courseNumber);
    }

    @GetMapping("/{courseNumber}/students")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentResponse> getStudentsForCourse(@PathVariable String courseNumber) {
        return courseService.getStudentsForCourse(courseNumber);
    }
}
