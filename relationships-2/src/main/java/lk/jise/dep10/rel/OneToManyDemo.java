package lk.jise.dep10.rel;

import lk.jise.dep10.rel.entity.Customer;
import lk.jise.dep10.rel.entity.CustomerOrder;
import lk.jise.dep10.rel.entity.Order;
import lk.jise.dep10.rel.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class OneToManyDemo {
    public static void main(String[] args) {
        try(SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession()) {
            session.beginTransaction();

            Customer c001 = new Customer("C001", "Kasun");
            Customer c002 = new Customer("C002", "Nimal");
            Customer c003 = new Customer("C003", "Kamal");

            Order od001 = new Order("OD001", Date.valueOf(LocalDate.now()), new BigDecimal("170.00"));
            Order od002 = new Order("OD002", Date.valueOf(LocalDate.now()), new BigDecimal("480.00"));
            Order od003 = new Order("OD003", Date.valueOf(LocalDate.now()), new BigDecimal("7926.00"));
            Order od004 = new Order("OD004", Date.valueOf(LocalDate.now()), new BigDecimal("272.00"));
            Order od005 = new Order("OD005", Date.valueOf(LocalDate.now()), new BigDecimal("531.00"));

            CustomerOrder c01 = new CustomerOrder(od001, c001, od001.getTotal().multiply(new BigDecimal("0.03")));
            CustomerOrder c02 = new CustomerOrder(od004, c001, od004.getTotal().multiply(new BigDecimal("0.03")));
            CustomerOrder c03 = new CustomerOrder(od002, c002, od002.getTotal().multiply(new BigDecimal("0.03")));
            CustomerOrder c04 = new CustomerOrder(od003, c002, od003.getTotal().multiply(new BigDecimal("0.03")));
            CustomerOrder c05 = new CustomerOrder(od005, c003, od005.getTotal().multiply(new BigDecimal("0.03")));

            List.of(c001, c002, c003, od001, od002, od003, od004, od005, c01, c02, c03, c04, c05)
                    .forEach(session::persist);

            session.getTransaction().commit();
        }
    }
}
