package Application.Id.Card.Registration.Service;

import Application.Id.Card.Registration.Repo.StudentRepository;
import Application.Id.Card.Registration.Student.Student;
import Application.Id.Card.Registration.Student.Students;
import Application.Id.Card.Registration.StudentDTO.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentsServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentDTO getStudentById(int id) {
        Optional<Students> students = studentRepository.findById(id);
        if (students == null) {
            throw new StudentNotFoundException("Student not found with id " + id);
        }
        StudentDTO student;
        student = new StudentDTO();
        return new StudentDTO(student.getStudentId(), student.getStudentName(), student.getCourse(), student.getGender().toString());
    }

    @Override
    public void registerUser(Student student) {

    }

    @Override
    public void registerStudent(Student student) {

    }

    @Override
    public Student getStudent(int studentId) {
        return null;
    }

    @Override
    public void updateStudent(int id, StudentDTO studentDTO) {
        Optional<Students> students = studentRepository.findById(id);
        if (students == null) {
            throw new StudentNotFoundException("Student not found with id " + id);
        }
        Students student = null;
        student.StudentName(studentDTO.getStudentName());
        student = new Students();
        student.setCourse(studentDTO.getCourse());
        student.setGender(Students.gender.valueOf(studentDTO.getGender()));
        studentRepository.save(student);
    }

    @Override
    public List<StudentDTO> searchStudents(String searchTerm) {
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
