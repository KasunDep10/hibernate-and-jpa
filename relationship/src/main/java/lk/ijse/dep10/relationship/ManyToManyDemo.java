package lk.ijse.dep10.relationship;

import lk.ijse.dep10.relationship.entity.Course;
import lk.ijse.dep10.relationship.entity.Student;
import lk.ijse.dep10.relationship.entity.util.Gender;
import lk.ijse.dep10.relationship.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ManyToManyDemo {
    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {

            session.beginTransaction();

            Student kasun = new Student("S001", "Kasun", "Panadura", Gender.MALE);
            Student john = new Student("S002", "John", "Galle", Gender.MALE);
            Student nimal = new Student("S003", "Nimal", "Matara", Gender.MALE);

            Course dep = new Course("DEP", "Direct Entry Programme", 4);
            Course cmjd = new Course("CMJD", "Comprehensive Master Java Developer", 6);

            session.persist(kasun);
            session.persist(john);
            session.persist(nimal);
            session.persist(dep);
            session.persist(cmjd);

            dep.getStudentSet().add(kasun);
            dep.getStudentSet().add(john);
            dep.getStudentSet().add(nimal);

            cmjd.getStudentSet().add(kasun);
            cmjd.getStudentSet().add(nimal);

            session.getTransaction().commit();
        }
    }
}
