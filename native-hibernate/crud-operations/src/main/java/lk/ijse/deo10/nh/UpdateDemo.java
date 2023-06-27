package lk.ijse.deo10.nh;

import lk.ijse.deo10.nh.entity.Customer;
import lk.ijse.deo10.nh.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UpdateDemo {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Customer c1 = session.get(Customer.class, 1);
            c1.setAddress("Horana");

            session.getTransaction().commit();
        }
    }
}
