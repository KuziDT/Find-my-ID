package Application.Id.Card.Registration.Service;

import Application.Id.Card.Registration.Repo.StudentRepository;
import Application.Id.Card.Registration.Student.Students;
import Application.Id.Card.Registration.StudentDTO.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class StudentsService {

    @Autowired
    private StudentRepository studentRepository;

    public Optional<Students> getStudentById(int studentId) {
        Optional<Students> student = studentRepository.findById(studentId);
        if (student == null) {
            throw new StudentNotFoundException("Student not found with id " + studentId);
        }
        return student;
    }

    public void updateStudent(int id, Students updatedStudent) {
        Optional<Students> student = studentRepository.findById(id);
        if (student == null) {
            throw new StudentNotFoundException("Student not found with id " + id);
        }
        student.get();
        student.get();
        student.get();
        studentRepository.save(student);
    }

    public abstract void updateStudent(int id, StudentDTO studentDTO);

    public List<Students> searchStudents(String searchTerm) {
        return studentRepository.searchStudents(searchTerm);
    }

    public Students createStudent(Students newStudent) {
        return studentRepository.save(newStudent);
    }

    public List<Students> searchMissingIdCards() {
        return studentRepository.searchMissingIdCards();
    }

    public class StudentNotFoundException extends RuntimeException {
        public StudentNotFoundException(String message) {
            super(message);
        }
    }

}
