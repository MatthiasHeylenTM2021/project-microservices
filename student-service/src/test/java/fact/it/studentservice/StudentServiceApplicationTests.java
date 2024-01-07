package fact.it.studentservice;

import fact.it.studentservice.dto.StudentRequest;
import fact.it.studentservice.dto.StudentResponse;
import fact.it.studentservice.model.Student;
import fact.it.studentservice.repository.StudentRepository;
import fact.it.studentservice.service.StudentService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class StudentServiceApplicationTests {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository studentRepository;

    @Test
    public void testCreateStudent() {
        // Arrange
        StudentRequest studentRequest = new StudentRequest();
        studentRequest.setFirstName("John");
        studentRequest.setLastName("Doe");
        studentRequest.setEmail("john.doe@example.com");
        studentRequest.setCourseNumber("CS101");

        Student student = new Student();
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setEmail("john.doe@example.com");
        student.setCourseNumber("CS101");

        when(studentRepository.save(any(Student.class))).thenReturn(student);

        // Act
        StudentResponse result = studentService.createStudent(studentRequest);

        // Assert
        verify(studentRepository, times(1)).save(any(Student.class));
        assertEquals("John", result.getFirstName());
        assertEquals("Doe", result.getLastName());
        assertEquals("john.doe@example.com", result.getEmail());
        assertEquals("CS101", result.getCourseNumber());
    }

    @Test
    public void testGetAllStudents() {
        // Arrange
        Student student = new Student();
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setEmail("john.doe@example.com");
        student.setCourseNumber("CS101");

        when(studentRepository.findAll()).thenReturn(Collections.singletonList(student));

        // Act
        List<StudentResponse> result = studentService.getAllStudents();

        // Assert
        verify(studentRepository, times(1)).findAll();
        assertEquals(1, result.size());
        assertEquals("John", result.get(0).getFirstName());
        assertEquals("Doe", result.get(0).getLastName());
        assertEquals("john.doe@example.com", result.get(0).getEmail());
        assertEquals("CS101", result.get(0).getCourseNumber());
    }

    @Test
    public void testGetStudentsByCourseNumber() {
        // Arrange
        Student student = new Student();
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setEmail("john.doe@example.com");
        student.setCourseNumber("CS101");

        when(studentRepository.findByCourseNumber(anyString())).thenReturn(Collections.singletonList(student));

        // Act
        List<StudentResponse> result = studentService.getStudentsByCourseNumber("CS101");

        // Assert
        verify(studentRepository, times(1)).findByCourseNumber(anyString());
        assertEquals(1, result.size());
        assertEquals("John", result.get(0).getFirstName());
        assertEquals("Doe", result.get(0).getLastName());
        assertEquals("john.doe@example.com", result.get(0).getEmail());
        assertEquals("CS101", result.get(0).getCourseNumber());
    }
}
