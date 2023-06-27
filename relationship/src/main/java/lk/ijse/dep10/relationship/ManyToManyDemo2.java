package lk.ijse.dep10.relationship;

import lk.ijse.dep10.relationship.entity.Course;
import lk.ijse.dep10.relationship.entity.Student;
import lk.ijse.dep10.relationship.entity.util.Gender;
import lk.ijse.dep10.relationship.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ManyToManyDemo2 {
    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {

            session.beginTransaction();

            Course dep = session.get(Course.class, "DEP");
            Course cmjd = session.get(Course.class, "CMJD");
            Student john = session.get(Student.class, "S002");

            dep.getStudentSet().remove(john);
            cmjd.getStudentSet().add(john);

            session.getTransaction().commit();
        }
    }
}
