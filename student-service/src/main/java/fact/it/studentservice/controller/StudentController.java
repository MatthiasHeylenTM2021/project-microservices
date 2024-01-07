package fact.it.studentservice.controller;

import fact.it.studentservice.dto.StudentRequest;
import fact.it.studentservice.dto.StudentResponse;
import fact.it.studentservice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public StudentResponse createStudent(@RequestBody StudentRequest studentRequest) {
        return studentService.createStudent(studentRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StudentResponse> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{studentNumber}")
    @ResponseStatus(HttpStatus.OK)
    public StudentResponse getStudentByStudentNumber(@PathVariable String studentNumber) {
        return studentService.getStudentByStudentNumber(studentNumber);
    }
}
