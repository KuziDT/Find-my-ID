package Application.Id.Card.Registration.StudentController;

import Application.Id.Card.Registration.Repo.StudentRepository;
import Application.Id.Card.Registration.Student.Students;
import Application.Id.Card.Registration.StudentDTO.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/{id}")
    public StudentDTO getStudentById(@PathVariable int id) {
        Optional<Students> student = studentRepository.findById(id);
        StudentDTO studentDTO = new StudentDTO(student.get(), toString());
        return studentDTO;
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable int id, @RequestBody StudentDTO studentDTO) {
        Optional<Students> student = studentRepository.findById(id);
        if (student == null) {
            throw new StudentNotFoundException("Student not found with id " + id);
        }
        student.get();
        student.get();
        student.get();
        Object StudentDTO = null;
        student.getClass();
        studentRepository.save(student);
    }

    @GetMapping("/search")
    public List<StudentDTO> searchStudents(@RequestParam("q") String searchTerm) {
        List<Students> students = studentRepository.searchStudents(searchTerm);
        return students.stream().map(student ->
                new StudentDTO(Math.toIntExact(student.getStudentId()), student.getStudentName(), student.getCourse(), student.getGender().toString())
        ).collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public class StudentNotFoundException extends RuntimeException {
        public StudentNotFoundException(String message) {
            super(message);
        }
    }
}
