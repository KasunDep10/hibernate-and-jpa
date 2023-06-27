package lk.ijse.dep10.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep10.jpa.entity.Customer;
import lk.ijse.dep10.jpa.util.JpaUtil;

public class FindDemo {

    public static void main(String[] args) {
        try(EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
            EntityManager entityManager = emf.createEntityManager()) {

            Customer customer = entityManager.find(Customer.class, 2);
            System.out.println(customer);
        }

    }
}
