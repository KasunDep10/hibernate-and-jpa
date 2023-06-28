package lk.ijse.dep10.relationship;

import lk.ijse.dep10.relationship.entity.Module;
import lk.ijse.dep10.relationship.entity.Teacher;
import lk.ijse.dep10.relationship.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToManyDemo6 {
    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {

            session.beginTransaction();

            Teacher pingala = session.get(Teacher.class, "T003");
            Module angularModule = session.get(Module.class, "SE002");

            angularModule.setTeacher(pingala);

            session.getTransaction().commit();
        }
    }

}
