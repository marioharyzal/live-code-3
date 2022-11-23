package com.pintarngoding.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaConfig {
    private static final String PERSISTENCE_UNIT_NAME = "default";

    private static EntityManagerFactory factory;

    public static void getEntityManagerFactory() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public static EntityManager getEntityManager() {
        if (factory == null){
            getEntityManagerFactory();
        }
        return factory.createEntityManager();
    }

    public static void shutDown() {
        if (factory != null){
            factory.close();
        }
    }
}
