package lk.ijse.deo10.nh;

import lk.ijse.deo10.nh.entity.Customer;
import lk.ijse.deo10.nh.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SaveDemo {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {
            System.out.println(session);

            session.beginTransaction();
            Customer customer = new Customer("Ruwan", "Galle", "071-8796021");
//            session.save(customer);  // 5.x
            session.persist(customer);  // 6.x

            session.getTransaction().commit();
        }
    }
}
