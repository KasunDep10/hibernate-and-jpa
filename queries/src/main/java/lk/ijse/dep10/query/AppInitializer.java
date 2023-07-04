package lk.ijse.dep10.query;

import lk.jise.dep10.rel.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AppInitializer {
    public static void main(String[] args) {
        try(SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession()) {
            session.beginTransaction();
            System.out.println(session);
            session.getTransaction().commit();
        }
    }
}
