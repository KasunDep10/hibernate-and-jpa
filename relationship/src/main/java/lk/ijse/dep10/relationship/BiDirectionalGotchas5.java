package lk.ijse.dep10.relationship;

import lk.ijse.dep10.relationship.entity.Customer;
import lk.ijse.dep10.relationship.entity.Employee;
import lk.ijse.dep10.relationship.entity.Order;
import lk.ijse.dep10.relationship.entity.Spouse;
import lk.ijse.dep10.relationship.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class BiDirectionalGotchas5 {
    public static void main(String[] args) {
        try(SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session = sf.openSession()){

            session.beginTransaction();

            Employee muga = session.getReference(Employee.class, 2);
            Spouse sandani = session.get(Spouse.class, 1);
            sandani.setEmployee(muga);

            Employee paniya = session.get(Employee.class, 1);
            paniya.setSpouse(sandani);


            session.getTransaction().commit();
        }
    }

}
