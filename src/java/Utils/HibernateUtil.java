/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author !l-PazZ0
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private static Session session;

    public static Session getSession() {
        if (session==null)
            session=sessionFactory.openSession();
        else
        {
            if(session.isOpen())
                session.clear();
            else
            {
                session=sessionFactory.openSession();
            }
           
                
        }
        return session;
    }

    public static void setSession(Session session) {
        HibernateUtil.session = session;
    }
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
