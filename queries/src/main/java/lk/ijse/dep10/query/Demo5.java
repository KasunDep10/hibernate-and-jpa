package lk.ijse.dep10.query;

import lk.ijse.dep10.query.entity.Car;
import lk.ijse.dep10.query.entity.Employee;
import lk.ijse.dep10.query.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class Demo5 {
    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            session.beginTransaction();

            Query<Car> query1 = session.createNamedQuery("query1", Car.class)
                    .setParameter("model", "Bugati");
            Car car = query1.uniqueResult();

            System.out.println(car);


            session.getTransaction().commit();
        }
    }
}
