package lk.ijse.dep10.query;

import lk.ijse.dep10.query.entity.Employee;
import lk.ijse.dep10.query.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class Demo6 {
    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            session.beginTransaction();

            List<Employee> list = session.createNamedQuery("searchEmployees", Employee.class)
                    .setParameter("q", "%u%").list();
            list.forEach(System.out::println);


            session.getTransaction().commit();
        }
    }
}
