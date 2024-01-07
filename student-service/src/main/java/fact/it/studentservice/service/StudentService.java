package fact.it.studentservice.service;

import fact.it.studentservice.dto.StudentRequest;
import fact.it.studentservice.dto.StudentResponse;
import fact.it.studentservice.model.Student;
import fact.it.studentservice.repository.StudentRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    @PostConstruct
    public void loadData() {
        if(studentRepository.count() == 0){
            Student student = new Student();
            student.setStudentNumber("001");
            student.setFirstName("Jan");
            student.setLastName("Versmissen");
            student.setEmail("jan.versmissen@webmail.de");

            Student student2 = new Student();
            student2.setStudentNumber("002");
            student2.setFirstName("Dirk");
            student2.setLastName("Tegels");
            student2.setEmail("dirk.tegels@yahoo.be");

            Student student3 = new Student();
            student3.setStudentNumber("003");
            student3.setFirstName("Johan");
            student3.setLastName("Deswaef");
            student3.setEmail("johan.deswaef@mail.com");

            Student student4 = new Student();
            student4.setStudentNumber("004");
            student4.setFirstName("John");
            student4.setLastName("Peeters");
            student4.setEmail("john.peeters@gmail.nl");

            Student student5 = new Student();
            student5.setStudentNumber("005");
            student5.setFirstName("Marc");
            student5.setLastName("Janssens");
            student5.setEmail("marc.janssens@msn.be");

            studentRepository.save(student);
            studentRepository.save(student2);
            studentRepository.save(student3);
            studentRepository.save(student4);
            studentRepository.save(student5);
        }
    }

    public StudentResponse createStudent(StudentRequest studentRequest) {
        Student student = Student.builder()
                .studentNumber(studentRequest.getStudentNumber())
                .firstName(studentRequest.getFirstName())
                .lastName(studentRequest.getLastName())
                .email(studentRequest.getEmail())
                .build();
        return mapTostudentResponse(student);
    }

    public List<StudentResponse> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(this::mapTostudentResponse).toList();
    }

    public StudentResponse getStudentByStudentNumber(String studentNumber) {
        Student student = studentRepository.findByStudentNumber(studentNumber);
        return mapTostudentResponse(student);
    }

    private StudentResponse mapTostudentResponse(Student student) {
        return StudentResponse.builder()
                .id(student.getId())
                .studentNumber(student.getStudentNumber())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .build();
    }
}
