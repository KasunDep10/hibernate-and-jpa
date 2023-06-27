package lk.ijse.deo10.nh;

import lk.ijse.deo10.nh.entity.Customer;
import lk.ijse.deo10.nh.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GetDemo {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {
            Customer customer = session.get(Customer.class, 1);
//            Customer customer = session.find(Customer.class, 1);
            System.out.println(customer);

        }

    }
}
