package lk.ijse.dep10.relationship;

import lk.ijse.dep10.relationship.entity.Customer;
import lk.ijse.dep10.relationship.entity.Order;
import lk.ijse.dep10.relationship.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class OneToManyDemo4 {
    public static void main(String[] args) {
        try(SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session = sf.openSession()){

            session.beginTransaction();

            Customer ruwan = new Customer(3, "Ruwan", "071-3989236");
            List<Order> ruwanOrderList = List.of(
                    new Order(4, Date.valueOf(LocalDate.now()), ruwan),
                    new Order(5, Date.valueOf(LocalDate.now()), ruwan));
            ruwan.setOrderList(ruwanOrderList);

            Customer nimal = new Customer(4, "Nimal", "071-3164234");
            List<Order> nimalOrderList = List.of(
            new Order(6, Date.valueOf(LocalDate.now()), nimal));
            nimal.setOrderList(nimalOrderList);

            session.persist(ruwan);
            session.persist(nimal);


            session.getTransaction().commit();
        }
    }

}
