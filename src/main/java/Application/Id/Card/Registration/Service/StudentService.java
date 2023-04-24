package Application.Id.Card.Registration.Service;

import Application.Id.Card.Registration.Student.Student;
import Application.Id.Card.Registration.StudentDTO.StudentDTO;

import java.util.List;

public interface StudentService {

    StudentDTO getStudentById(int studentId);

    void registerUser(Student student);

    void registerStudent(Student student);
    Student getStudent(int studentId);


    void updateStudent(int id, StudentDTO studentDTO);

    List<StudentDTO> searchStudents(String searchTerm);
}
