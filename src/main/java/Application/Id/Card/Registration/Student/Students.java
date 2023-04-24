package Application.Id.Card.Registration.Student;


import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Students {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public static String gender;
    @Id
    @Column(name="student_id", length = 8)
    private Long studentId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "course")
    private String course;


    public Students( String studentName, String course, String gender){
        this.studentName = studentName;
        this.course = course;
        this.gender = gender;
    }

    public Students() {

    }

    public Long getStudentId(){
        return studentId;
    }

    public void setStudentId(Long studentId){
        this.studentId = studentId;
    }


    public String getStudentName(){
        return studentName;
    }

    public void setStudentName(String studentName){
        this.studentName = this.studentName;
    }

    public String getCourse(){
        return course;
    }

    public void setCourse(String course){
        this.course = course;
    }

    public String getGender(){
        return gender;
    }

    public void setGender(String s) {
        this.gender = gender;
    }

    public String toString(){
        return "Students{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", course='" + course + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public void StudentName(String studentName) {
    }
}
