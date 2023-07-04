package lk.jise.dep10.rel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student_course")
public class StudentCourse {
    @EmbeddedId
    private StudentCoursePK studentCoursePK;
    @Column(name = "reg_date", nullable = false)
    private Date regDate;
    @Column(nullable = false)
    private String reason;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Course course;


    public StudentCourse(StudentCoursePK studentCoursePK, Date regDate, String reason) {
        this.studentCoursePK = studentCoursePK;
        this.regDate = regDate;
        this.reason = reason;
    }

    public StudentCourse(String studentId, String courseId, Date regDate, String reason) {
        this.studentCoursePK = new StudentCoursePK(studentId, courseId);
        this.regDate = regDate;
        this.reason = reason;
    }

}
