package lk.ijse.dep10.relationship;

import lk.ijse.dep10.relationship.entity.Course;
import lk.ijse.dep10.relationship.entity.Employee;
import lk.ijse.dep10.relationship.entity.Spouse;
import lk.ijse.dep10.relationship.entity.Student;
import lk.ijse.dep10.relationship.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BiDirectionalGotchas6 {
    public static void main(String[] args) {
        try(SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session = sf.openSession()){

            session.beginTransaction();

            Student nimal = session.get(Student.class, "S003");
            Course dep = session.get(Course.class, "DEP");

            /* Inverse End */
//            nimal.getCourseList().remove(dep);

            /* Owner End */
            dep.getStudentSet().remove(nimal);


            session.getTransaction().commit();
        }
    }

}
