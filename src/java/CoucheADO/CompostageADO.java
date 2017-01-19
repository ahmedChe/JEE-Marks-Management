/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CoucheADO;

import Entities.Compostage;
import Utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author !l-PazZ0
 */
public class CompostageADO {
    
    	public static void addCompostage(Compostage comp) {
        Session session=HibernateUtil.getSession();
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.save(comp);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
        } finally {
            session.flush();
            session.close();
        }
    }

    public static void deleteCompostage(int id) {
        Transaction trns = null;
        Session session=HibernateUtil.getSession();
        try {
            trns = session.beginTransaction();
            Compostage comp = (Compostage) session.load(Compostage.class,id);
            session.delete(comp);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
        } finally {
            session.flush();
            session.close();
        }
    }

    public static void updateCompostage(Compostage comp) {
        Transaction trns = null;
        Session session=HibernateUtil.getSession();
        try {
            trns = session.beginTransaction();
            session.update(comp);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
        } finally {
            session.flush();
            session.close();
        }
    }

    public static List<Compostage> getAllCompostages() {
        List<Compostage> comps = new ArrayList<>();
        Session session=HibernateUtil.getSession();
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            comps = session.createQuery("from Compostage").list();
        } catch (RuntimeException e) {
        } finally {
            session.flush();
            session.close();
        }
        return comps;
    }

    public Compostage getCompostageById(int id) {
        Compostage comp = null;
        Transaction trns = null;
        Session session=HibernateUtil.getSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Compostage where codeCompostage = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            comp = (Compostage) query.uniqueResult();
        } catch (RuntimeException e) {
        } finally {
            session.flush();
            session.close();
        }
        return comp;
    }
    public static List<Compostage> Compostages(int id) 
    {
        List<Compostage> comps=new ArrayList<>();
        Transaction trns = null;
        Session session=HibernateUtil.getSession();
        try 
        {
                trns = session.beginTransaction();
                Query query = session.createQuery("select c from Compostage as c where c.codeNote in (select n.code from Note as n where n.matiere = :id)");
                query.setInteger("id", id);
                comps=query.list();
        }
         catch (RuntimeException e)
         {
         }
        finally 
        {
            session.flush();
            session.close();
        }
        return comps;
    }
}
