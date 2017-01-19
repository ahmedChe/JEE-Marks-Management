/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CoucheADO;


import Utils.HibernateUtil;
import java.util.Calendar;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author !l-PazZ0
 */
public class SessionADO {
    


    public static void add(Entities.Session s)
    {
        Session session=HibernateUtil.getSession();
        session.beginTransaction();
        session.save(s);
        session.getTransaction().commit();
    }


    public static void delete(Entities.Session s) {
        Session session=HibernateUtil.getSession();
        session.beginTransaction();
        session.update(s);
        session.getTransaction().commit();
    }


    public static void update(Entities.Session s)
    {
        Session session=HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(s);
        session.getTransaction().commit();
    }


    public static List<Entities.Session> display() 
    {
        Session session=HibernateUtil.getSession();
        List<Entities.Session> retour;
        Query req=session.createQuery("from Session");
        retour=(List<Entities.Session>)req.list();
           /* for (Entities.Session se : retour)
            {
                System.out.println("Session"+se.getLibelle());        
            }*/
        return retour;
    }
    public static Entities.Session GetCurrentYear() 
    {
        Entities.Session current=null;
        Session session=HibernateUtil.getSession();
        int year = Calendar.getInstance().get(Calendar.YEAR);
            String queryString = "from Session where anneeUniversitaire = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", year);
            current = (Entities.Session) query.uniqueResult();
           /* for (Entities.Session se : retour)
            {
                System.out.println("Session"+se.getLibelle());        
            }*/
        return current;
    }
    public static Entities.Session getSessionByCode(int id) {
        Entities.Session se = null;
        Transaction trns = null;
        Session session=HibernateUtil.getSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Session where idSession = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            se = (Entities.Session) query.uniqueResult();
        } catch (RuntimeException e) {
        } finally {
            session.flush();
            session.close();
        }
        return se;
    }
}
