package lk.jise.dep10.rel;

import lk.jise.dep10.rel.entity.Actor;
import lk.jise.dep10.rel.entity.ActorMovie;
import lk.jise.dep10.rel.entity.Movie;
import lk.jise.dep10.rel.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class ManyToManyDemo {
    public static void main(String[] args) {
        try(SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession()) {
            session.beginTransaction();

            Actor a001 = new Actor("A001", "Kasun");
            Actor a002 = new Actor("A002", "Nimal");
            Actor a003 = new Actor("A003", "Kamal");

            Movie m001 = new Movie("M001", "Ice age");
            Movie m002 = new Movie("M002", "Harry Potter");
            Movie m003 = new Movie("M003", "Rio");

            ActorMovie am1 = new ActorMovie(a001.getId(), m001.getId(), Date.valueOf(LocalDate.now()));
            ActorMovie am2 = new ActorMovie(a001.getId(), m002.getId(), Date.valueOf(LocalDate.now()));
            ActorMovie am3 = new ActorMovie(a002.getId(), m002.getId(), Date.valueOf(LocalDate.now()));
            ActorMovie am4 = new ActorMovie(a002.getId(), m003.getId(), Date.valueOf(LocalDate.now()));
            ActorMovie am5 = new ActorMovie(a003.getId(), m001.getId(), Date.valueOf(LocalDate.now()));
            ActorMovie am6 = new ActorMovie(a003.getId(), m002.getId(), Date.valueOf(LocalDate.now()));

            List.of(a001, a002, a003, m001, m002, m003, am1, am2, am3, am4, am5, am6)
                    .forEach(session::persist);

            session.getTransaction().commit();
        }
    }
}
