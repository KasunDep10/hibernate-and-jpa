package lk.ijse.dep10.relationship;

import lk.ijse.dep10.relationship.entity.Course;
import lk.ijse.dep10.relationship.entity.Student;
import lk.ijse.dep10.relationship.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ManyToManyDemo3 {
    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {

            session.beginTransaction();

            Student nimal = session.get(Student.class, "S003");
            System.out.println(nimal.getCourseList().get(0));


            session.getTransaction().commit();
        }
    }
}
