package cl.obeay.angelica.util;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hibernate Utility class with a convenient method to get Session Factory object.
 * @author dyevenes
 */
public class HibernateUtil{
    private static final SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    static{
    	Logger flog = Logger.getLogger(HibernateUtil.class);
        try{
        	flog.info("Cargando configuraci�n hibernate.cfg.xml en SessionFactory");

            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            serviceRegistry = new ServiceRegistryBuilder().applySettings(
                    configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//			sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
            
            flog.info("Configuraci�n hibernate.cfg.xml cargada");
        }catch (Throwable ex){
        	flog.fatal("Error al cargar configuracion Hibernate", ex);
            throw new RuntimeException("Error al cargar configuracion Hibernate",ex);
        }
    }

    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}