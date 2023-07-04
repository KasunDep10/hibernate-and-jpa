package lk.ijse.dep10.relationship;

import lk.ijse.dep10.relationship.entity.Car;
import lk.ijse.dep10.relationship.entity.Manager;
import lk.ijse.dep10.relationship.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToOneDemo6 {
    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {

            session.beginTransaction();


            Manager martin = session.get(Manager.class, 3);
            Car mclaren = session.get(Car.class, "ASD-1236");

            Manager meema = session.get(Manager.class, 2);
            Car ferari = session.get(Car.class, "ASD-1235");

            mclaren.setManager(null);
            ferari.setManager(martin);
            session.flush();
            mclaren.setManager(meema);




            session.getTransaction().commit();
        }
    }
}
