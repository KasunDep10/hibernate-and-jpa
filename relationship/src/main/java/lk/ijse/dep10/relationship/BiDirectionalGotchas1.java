package lk.ijse.dep10.relationship;

import lk.ijse.dep10.relationship.entity.Customer;
import lk.ijse.dep10.relationship.entity.Order;
import lk.ijse.dep10.relationship.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class BiDirectionalGotchas1 {
    public static void main(String[] args) {
        try(SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session = sf.openSession()){

            session.beginTransaction();

            Order order2 = session.get(Order.class, 2);
            Customer nuwan = session.getReference(Customer.class, 2);

            System.out.println(order2.getCustomer().getName());
            order2.setCustomer(nuwan);


            /* This doesn't work*/
//            Customer kasun = session.get(Customer.class, 1);
//            Order order = session.get(Order.class, 2);
//            kasun.getOrderList().add(order);

            /* Now  it is normally okay*/
            Customer kasun = session.get(Customer.class, 1);
            Order order = session.get(Order.class, 2);
            kasun.addOrder(order);


            session.getTransaction().commit();
        }
    }

}
