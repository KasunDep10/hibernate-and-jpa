package lk.ijse.dep10.relationship;

import lk.ijse.dep10.relationship.entity.Customer;
import lk.ijse.dep10.relationship.entity.Order;
import lk.ijse.dep10.relationship.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class OneToManyDemo3 {
    public static void main(String[] args) {
        try(SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session = sf.openSession()){

            session.beginTransaction();

            Customer kasun = session.get(Customer.class, 1);
            List<Order> orderList = kasun.getOrderList();
            System.out.println(orderList.get(0));


            session.getTransaction().commit();
        }
    }

}
