package Application.Id.Card.Registration.Repo;

import Application.Id.Card.Registration.Student.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Students, Integer> {

    // Query to retrieve students with missing id cards
    @Query("SELECT s FROM Students s WHERE s.id NOT IN (SELECT c.student.id FROM IdCards c)")
    List<Students> findStudentsWithMissingIdCards();

    // Query to retrieve a student by id
    Students findStudentById(int id);

    // Method to create a new student
    Students save(Students student);

    // Query to search for students by name or course
    @Query("SELECT s FROM Students s WHERE s.studentName LIKE %:searchTerm% OR s.course LIKE %:searchTerm%")
    List<Students> searchStudents(@Param("searchTerm") String searchTerm);

    void save(Optional<Students> student);

    List<Students> searchMissingIdCards();
}
