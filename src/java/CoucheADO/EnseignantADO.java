/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CoucheADO;

import Entities.Enseignant;
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
public class EnseignantADO {
    
    

    public static long VerifierCompte(int user,String password) 
    {
        Session session=HibernateUtil.getSession();
        long count;
        Query query = session.createQuery("select count (e) from Enseignant as e where e.codeUser= :user and e.password= :pass");
        query.setInteger("user", user);
        query.setString("pass", password);
        query.setCacheable(true);

        final Object obj = query.uniqueResult();
        if (obj==null)
        {
            count=0;
        }
        else
        {
            count = ((Long)query.uniqueResult());
        }
        System.out.println(count);
        return count;
    }
    public static void addEnseignant(Enseignant e) {
        Session session=HibernateUtil.getSession();    
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.save(e);
            session.getTransaction().commit();
        } catch (RuntimeException x) {
            if (trns != null) {
                trns.rollback();
            }
        } finally {
            session.flush();
            session.close();
        }
    }

    public static void deleteEnseignant(int id) {
        Transaction trns = null;
        Session session=HibernateUtil.getSession();
        try {
            trns = session.beginTransaction();
            Enseignant e = (Enseignant) session.load(Enseignant.class,id);
            session.delete(e);
            session.getTransaction().commit();
        } catch (RuntimeException x) {
            if (trns != null) {
                trns.rollback();
            }
        } finally {
            session.flush();
            session.close();
        }
    }

    public static void updateEnseignant(Enseignant ens) {
        Session session=HibernateUtil.getSession();
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.update(ens);
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

    public static List<Enseignant> getAllEnseignants() {
        Session session=HibernateUtil.getSession();
        List<Enseignant> groupes = new ArrayList<>();
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            groupes = session.createQuery("from Enseignant").list();
        } catch (RuntimeException e) {
        } finally {
            session.flush();
            session.close();
        }
        return groupes;
    }
    
    public static Enseignant getEnseignantByCode(int id) {
        Enseignant ens = null;
        Transaction trns = null;
        Session session=HibernateUtil.getSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Enseignant where cin = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            ens = (Enseignant) query.uniqueResult();
        } catch (RuntimeException e) {
        } finally {
            session.flush();
            session.close();
        }
        return ens;
    }
    public static Enseignant getEnseignantByLogin(int id) {
        Enseignant ens = null;
        Transaction trns = null;
        Session session=HibernateUtil.getSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Enseignant where codeUser = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            ens = (Enseignant) query.uniqueResult();
        } catch (RuntimeException e) {
        } finally {
            session.flush();
            session.close();
        }
        return ens;
    }
 
 
}
