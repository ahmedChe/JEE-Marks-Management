/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CoucheADO;

import Entities.Niveau;
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
public class NiveauADO { 
    	public static void addNiveau(Niveau niv) {
        Transaction trns = null;
        Session session=HibernateUtil.getSession();
        try {
            trns = session.beginTransaction();
            session.save(niv);
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

    public static void deleteNiveau(int id) {
        Transaction trns = null;
        Session session=HibernateUtil.getSession();
        try {
            trns = session.beginTransaction();
            Niveau niv = (Niveau) session.load(Niveau.class,id);
            session.delete(niv);
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

    public static void updateNiveau(Niveau niv) {
        Transaction trns = null;
        Session session=HibernateUtil.getSession();
        try {
            trns = session.beginTransaction();
            session.update(niv);
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

    public static List<Niveau> getAllNiveaux() {
        List<Niveau> groupes = new ArrayList<>();
        Session session=HibernateUtil.getSession();
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            groupes = session.createQuery("from Niveau").list();
        } catch (RuntimeException e) {
        } finally {
            session.flush();
            session.close();
        }
        return groupes;
    }

    public static Niveau getNiveauById(int id) {
        Niveau niv = null;
        Transaction trns = null;
        Session session=HibernateUtil.getSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Niveau where codeNiv = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            niv = (Niveau) query.uniqueResult();
        } catch (RuntimeException e) {
        } finally {
            session.flush();
            session.close();
        }
        return niv;
    }
}
