package lk.ijse.deo10.nh;

import lk.ijse.deo10.nh.entity.Customer;
import lk.ijse.deo10.nh.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeleteDemo {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

//            Customer c3 = session.getReference(Customer.class, 3);
//            session.delete(c3);

            Customer c4 = session.getReference(Customer.class, 4);
            session.remove(c4);


            session.getTransaction().commit();
        }

    }
}
