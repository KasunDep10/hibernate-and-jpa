package lk.ijse.deo10.nh;

import lk.ijse.deo10.nh.entity.Customer;
import lk.ijse.deo10.nh.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class LoadDemo {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {
            Customer c1 = session.load(Customer.class, 1);
            System.out.println(c1);
            Customer c2 = session.getReference(Customer.class, 1);
            System.out.println(c2);
        }

    }
}
