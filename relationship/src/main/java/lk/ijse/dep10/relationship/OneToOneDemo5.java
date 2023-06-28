package lk.ijse.dep10.relationship;

import lk.ijse.dep10.relationship.entity.Car;
import lk.ijse.dep10.relationship.entity.Manager;
import lk.ijse.dep10.relationship.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToOneDemo5 {
    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {

            session.beginTransaction();


            Manager martin = session.get(Manager.class, 3);
            Car mclaren = session.get(Car.class, "ASD-1236");

            mclaren.setManager(martin);


            session.getTransaction().commit();
        }
    }
}
