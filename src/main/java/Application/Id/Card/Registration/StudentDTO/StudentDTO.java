package Application.Id.Card.Registration.StudentDTO;

import Application.Id.Card.Registration.Student.Students;

public class StudentDTO {
    private int studentId;
    private static String studentName;
    private static String course;
    private String gender;

    public StudentDTO() {}

    public StudentDTO(int studentId, String studentName, String course, String gender) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.course = course;
        this.gender = gender;
    }

    public StudentDTO(Students students, String toString) {

    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public static String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public static String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
