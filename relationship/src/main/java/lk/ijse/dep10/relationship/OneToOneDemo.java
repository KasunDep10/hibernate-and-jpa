package lk.ijse.dep10.relationship;

import lk.ijse.dep10.relationship.entity.Employee;
import lk.ijse.dep10.relationship.entity.Spouse;
import lk.ijse.dep10.relationship.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToOneDemo {
    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {

            session.beginTransaction();

            Employee paniya = new Employee(1, "Paniya", "Galle");
            Employee muga = new Employee(2, "Muga", "Matara");

            Spouse sandani = new Spouse(1, "Sandani", paniya);

            session.persist(paniya);
            session.persist(muga);
            session.persist(sandani);

            session.getTransaction().commit();
        }
    }
}
