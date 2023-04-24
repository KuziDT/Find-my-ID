package Application.Id.Card.Registration.StudentController;

import Application.Id.Card.Registration.Service.StudentService;
import Application.Id.Card.Registration.Student.Student;
import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Objects;

@Controller
public class LoginController {

    @Autowired
    private StudentService studentService;


    @GetMapping("/login")
    public String showLoginForm(Model model) throws InterruptedException {
        model.wait();
        return "login";
    }

    @PostMapping("/login")
    public String validateLogin(@ModelAttribute("user") Student student, Model model) throws InterruptedException {
        Student savedStudent = studentService.getStudent(student.getStudentId());
        if (savedStudent != null && Objects.equals(savedStudent.getPassword(), student.getPassword())) {
            return "success";
        } else {
            model.wait();
            return "login";
        }
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) throws InterruptedException {
        model.wait();
        return "register";
    }

    @PostMapping("/register")
    public String validateRegistration(@ModelAttribute("student") Student student, Model model) throws InterruptedException {
        if (null != studentService.getStudent(student.getStudentId())) {
            model.wait();
            return "register";
        } else {
            studentService.registerUser(null);
            return "success";
        }
    }
}
