package fact.it.courseservice.controller;

import fact.it.courseservice.dto.CourseRequest;
import fact.it.courseservice.dto.CourseResponse;
import fact.it.courseservice.dto.FeedbackResponse;
import fact.it.courseservice.dto.StudentResponse;
import fact.it.courseservice.model.Course;
import fact.it.courseservice.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> updateCourse(@RequestBody Course updateCourse, @PathVariable("id") Long courseId) {
        Course updatedCourse = courseService.updateCourse(updateCourse, courseId);

        if (updatedCourse != null) {
            return ResponseEntity.ok("Course updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found");
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteCourse(@PathVariable("id") Long courseId) {
        boolean deleted = courseService.deleteCourse(courseId);

        if (deleted) {
            return ResponseEntity.ok("Course deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found");
        }
    }
}
