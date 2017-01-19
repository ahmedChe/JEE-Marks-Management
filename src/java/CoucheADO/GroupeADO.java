/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CoucheADO;

import Entities.Groupe;
import Entities.Matiere;
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
public class GroupeADO {
    	public static void addGroupe(Groupe grp) {
        Session session=HibernateUtil.getSession();    
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.save(grp);
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

    public static void deleteGroupe(int id) {
        Transaction trns = null;
        Session session=HibernateUtil.getSession();
        try {
            trns = session.beginTransaction();
            Groupe grp = (Groupe) session.load(Groupe.class,id);
            session.delete(grp);
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

    public static void updateGroupe(Groupe grp) {
        Session session=HibernateUtil.getSession();
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.update(grp);
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

    public static List<Groupe> getAllGroupes() {
        Session session=HibernateUtil.getSession();
        List<Groupe> groupes = new ArrayList<>();
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            groupes = session.createQuery("from Groupe").list();
        } catch (RuntimeException e) {
        } finally {
            session.flush();
            session.close();
        }
        return groupes;
    }
    
    public static Groupe getGroupeById(int id) {
        Groupe grp = null;
        Transaction trns = null;
        Session session=HibernateUtil.getSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Groupe where codeGrp = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            grp = (Groupe) query.uniqueResult();
        } catch (RuntimeException e) {
        } finally {
            session.flush();
            session.close();
        }
        return grp;
    }
    public static List<Groupe> getGroupeByEnseignant(int id) {
        List<Groupe> groupes = new ArrayList<>();
        Transaction trns = null;
        Session session=HibernateUtil.getSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Groupe as g where g.codeGrp in (select distinct mat.groupe from Matiere as mat where mat.enseignant = :id)";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            groupes=query.list();
        } catch (RuntimeException e) {
        } finally {
            session.flush();
            session.close();
        }
        return groupes;
    }
    public static List<Groupe> getGroupesByNiveau(int niveau) {
        Session session=HibernateUtil.getSession();
        List<Groupe> groupes = new ArrayList<>();
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            Query query = session.createQuery("from Groupe where niveau = :id");
            query.setInteger("id", niveau);
            groupes=query.list();
        } catch (RuntimeException e) {
        } finally {
            session.flush();
            session.close();
        }
        return groupes;
    }
}
