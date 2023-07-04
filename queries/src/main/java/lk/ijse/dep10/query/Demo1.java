package lk.ijse.dep10.query;

import lk.ijse.dep10.query.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            session.beginTransaction();

            /* If you haven't specified the result class, you will get an object array*/
            NativeQuery nativeQuery = session.createNativeQuery("SELECT * FROM employee");
            List<Object[]> list = nativeQuery.list();

            System.out.println(list.get(0)[0]); //id
            System.out.println(list.get(0)[1]); //name


//            list.forEach(System.out::println);

            session.getTransaction().commit();
        }
    }
}
