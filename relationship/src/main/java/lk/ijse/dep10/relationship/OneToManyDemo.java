package lk.ijse.dep10.relationship;

import lk.ijse.dep10.relationship.entity.Customer;
import lk.ijse.dep10.relationship.entity.Order;
import lk.ijse.dep10.relationship.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.time.LocalDate;

public class OneToManyDemo {
    public static void main(String[] args) {
        try(SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session = sf.openSession()){

            session.beginTransaction();

            Customer kasun = new Customer(1, "Kasun", "071-3976824");
            Order order1 = new Order(1, Date.valueOf(LocalDate.now()), kasun);
            Order order2 = new Order(2, Date.valueOf(LocalDate.now()), kasun);

            Customer nuwan = new Customer(2, "Nuwan", "071-3876234");
            Order order3 = new Order(3, Date.valueOf(LocalDate.now()), nuwan);

            session.persist(kasun);
            session.persist(order1);
            session.persist(order2);
            session.persist(nuwan);
            session.persist(order3);


            session.getTransaction().commit();
        }
    }

}
