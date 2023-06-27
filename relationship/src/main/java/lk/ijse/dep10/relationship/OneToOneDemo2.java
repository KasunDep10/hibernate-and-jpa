package lk.ijse.dep10.relationship;

import lk.ijse.dep10.relationship.entity.Employee;
import lk.ijse.dep10.relationship.entity.Spouse;
import lk.ijse.dep10.relationship.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToOneDemo2 {
    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {

            session.beginTransaction();


//            Employee paniya = session.get(Employee.class, 1);
//            System.out.println(paniya);

            Spouse sandani = session.get(Spouse.class, 1);
            System.out.println(sandani);

            session.getTransaction().commit();
        }
    }
}
