package lk.jise.dep10.rel;

import lk.jise.dep10.rel.entity.*;
import lk.jise.dep10.rel.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class ManyToManyDemo2 {
    public static void main(String[] args) {
        try(SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession()) {
            session.beginTransaction();

            Student s001 = new Student("S001", "Kasun", "071-1108473");
            Student s002 = new Student("S002", "Nimal", "077-7458412");
            Student s003 = new Student("S003", "Kamal", "076-5108491");

            Course c001 = new Course("C001", "DEP", "6 Months");
            Course c002 = new Course("C002", "CMJD", "6 Months");
            Course c003 = new Course("C003", "GDSE", "24 Months");

            StudentCourse sc1 = new StudentCourse(s001.getId(), c001.getId(), Date.valueOf(LocalDate.now()), "To learn SE");
            StudentCourse sc2 = new StudentCourse(s001.getId(), c003.getId(), Date.valueOf(LocalDate.now()), "To learn SE");
            StudentCourse sc3 = new StudentCourse(s002.getId(), c002.getId(), Date.valueOf(LocalDate.now()), "To learn SE");
            StudentCourse sc4 = new StudentCourse(s003.getId(), c002.getId(), Date.valueOf(LocalDate.now()), "To learn SE");
            StudentCourse sc5 = new StudentCourse(s003.getId(), c003.getId(), Date.valueOf(LocalDate.now()), "To learn SE");
            StudentCourse sc6 = new StudentCourse(s002.getId(), c001.getId(), Date.valueOf(LocalDate.now()), "To learn SE");


            List.of(s001, s002, s003, c001, c002, c003, sc1, sc2, sc3, sc4, sc5, sc6)
                    .forEach(session::persist);

            session.getTransaction().commit();
        }
    }
}
