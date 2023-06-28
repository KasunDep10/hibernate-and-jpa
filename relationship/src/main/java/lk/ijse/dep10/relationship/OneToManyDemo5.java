package lk.ijse.dep10.relationship;

import lk.ijse.dep10.relationship.entity.Module;
import lk.ijse.dep10.relationship.entity.Teacher;
import lk.ijse.dep10.relationship.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.lang.reflect.Modifier;

public class OneToManyDemo5 {
    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {

            session.beginTransaction();

            Teacher pt = new Teacher("T001", "PT");
            Teacher sameera = new Teacher("T002", "Sameera");
            Teacher pingala = new Teacher("T003", "Pingala");

            Module springModule = new Module("SE001", "Spring Boot", 1, pt);
            Module pfModule = new Module("CS001", "Programming Fundamentals", 5, sameera);
            Module angularModule = new Module("SE002", "Angular Platform", 3);
            Module dsModule = new Module("CS002", "Data Structures", 5);

            session.persist(springModule);
            session.persist(pfModule);

            session.persist(pingala);
            session.persist(angularModule);
            session.persist(dsModule);

            session.getTransaction().commit();
        }
    }

}
