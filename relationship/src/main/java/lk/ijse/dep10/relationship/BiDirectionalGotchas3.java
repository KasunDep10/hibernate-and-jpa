package lk.ijse.dep10.relationship;

import lk.ijse.dep10.relationship.entity.Customer;
import lk.ijse.dep10.relationship.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BiDirectionalGotchas3 {
    public static void main(String[] args) {
        try(SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session = sf.openSession()){

            session.beginTransaction();

            Customer ruwan = session.get(Customer.class, 3);
            session.remove(ruwan);



            session.getTransaction().commit();
        }
    }

}
