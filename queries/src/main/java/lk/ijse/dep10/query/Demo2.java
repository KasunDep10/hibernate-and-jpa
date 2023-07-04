package lk.ijse.dep10.query;

import lk.ijse.dep10.query.entity.Employee;
import lk.ijse.dep10.query.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class Demo2 {
    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            session.beginTransaction();

            NativeQuery<Employee> nativeQuery = session.createNativeQuery("SELECT * FROM employee", Employee.class);
            List<Employee> list = nativeQuery.list();

            list.forEach(System.out::println);



            session.getTransaction().commit();
        }
    }
}
