package lk.ijse.dep10.query;

import lk.ijse.dep10.query.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class Demo3 {
    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            session.beginTransaction();

            Query emplyees = session.createQuery("FROM Employee e");            // HQL
//            Query emplyees = session.createQuery("SELECT e FROM Employee e");   //JPQL

            List list = emplyees.list();
            list.forEach(System.out::println);


            session.getTransaction().commit();
        }
    }
}
