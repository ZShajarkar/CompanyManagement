package ir.shajarkar.common;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAProvider {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("J2OS");
    public static EntityManager getEntityManager()
    {
        return entityManagerFactory.createEntityManager();
    }
    private JPAProvider(){

    }
}
