package lk.ijse.dep10.relationship.util;

import lk.ijse.dep10.relationship.entity.*;
import lk.ijse.dep10.relationship.entity.Module;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory(){
        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .loadProperties("/application.properties")
                .build();

        Metadata metadata = new MetadataSources(standardRegistry)
                .addAnnotatedClasses(Customer.class, Order.class)
                .addAnnotatedClasses(Employee.class, Spouse.class)
                .addAnnotatedClasses(Student.class, Course.class)
                .addAnnotatedClasses(Teacher.class, Module.class)
                .addAnnotatedClasses(Manager.class, Car.class)
                .getMetadataBuilder()
                .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
                .build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder()
                .build();

        return sessionFactory;

    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

}
