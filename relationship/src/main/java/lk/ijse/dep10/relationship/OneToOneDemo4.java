package lk.ijse.dep10.relationship;

import lk.ijse.dep10.relationship.entity.Car;
import lk.ijse.dep10.relationship.entity.Employee;
import lk.ijse.dep10.relationship.entity.Manager;
import lk.ijse.dep10.relationship.util.HibernateUtil;
import org.hibernate.Cache;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToOneDemo4 {
    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {

            session.beginTransaction();


            Manager lokka = new Manager(1, "Lokka");
            Manager meema = new Manager(2, "Meema");
            Manager martin = new Manager(3, "Martin");

            Car bugati = new Car("ASD-1234", "Bugati", lokka);
            Car ferari = new Car("ASD-1235", "Ferari", meema);
            Car mclaren = new Car("ASD-1236", "Mclaren");

            session.persist(bugati);
            session.persist(ferari);

            session.persist(martin);
            session.persist(mclaren);


            session.getTransaction().commit();
        }
    }
}
