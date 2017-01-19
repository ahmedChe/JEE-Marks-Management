/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CoucheADO;

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
public class MatiereADO {
    
    	public static void addMatiere(Matiere matiere) {
        Transaction trns = null;
        Session session=HibernateUtil.getSession();
        
        try {
            trns = session.beginTransaction();
            session.save(matiere);
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

    public static void deleteMatiere(int id) {
        Transaction trns = null;
        Session session=HibernateUtil.getSession();
        try {
            trns = session.beginTransaction();
            Matiere matiere = (Matiere) session.load(Matiere.class,id);
            session.delete(matiere);
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

    public static void updateMatiere(Matiere matiere) {
        Transaction trns = null;
        Session session=HibernateUtil.getSession();
        try {
            trns = session.beginTransaction();
            session.update(matiere);
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

    public static List<Matiere> getAllMatieres() {
        List<Matiere> notes = new ArrayList<>();
        Transaction trns = null;
        Session session=HibernateUtil.getSession();
        try {
            trns = session.beginTransaction();
            notes = session.createQuery("from Matiere").list();
        } catch (RuntimeException e) {
        } finally {
            session.flush();
            session.close();
        }
        return notes;
    }
    
    public static List<Matiere> getMatieresByGRP(int codeGRP) {
        List<Matiere> matieres = new ArrayList<>();
        Transaction trns = null;
        Session session=HibernateUtil.getSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Matiere where groupe = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", codeGRP);
            matieres =query.list();
        } catch (RuntimeException e) {
        } finally {
            session.flush();
            session.close();
        }
        return matieres;
    }
    public static List<Matiere> getMatieresByENSEIGNANT(int enseignant,int groupe) {
        List<Matiere> matieres = new ArrayList<>();
        Transaction trns = null;
        Session session=HibernateUtil.getSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Matiere where enseignant = :id and groupe = :grp";
            Query query = session.createQuery(queryString);
            query.setInteger("id", enseignant);
            query.setInteger("grp",groupe);
            matieres =query.list();
        } catch (RuntimeException e) {
        } finally {
            session.flush();
            session.close();
        }
        return matieres;
    }
    public static Matiere getMatiereById(int id) {
        Matiere matiere = null;
        Transaction trns = null;
        Session session=HibernateUtil.getSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Matiere where codeMat = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            matiere = (Matiere) query.uniqueResult();
        } catch (RuntimeException e) {
        } finally {
            session.flush();
            session.close();
        }
        return matiere;
    }
     public static List<Matiere> getMatieresByStudent(int cin) {
        List<Matiere> matieres = new ArrayList<>();
        Transaction trns = null;
        Session session=HibernateUtil.getSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Matiere as m where m.groupe=(select e.groupe from Etudiant as e where e.cin = :id)";
            Query query = session.createQuery(queryString);
            query.setInteger("id", cin);
            matieres =query.list();
        } catch (RuntimeException e) {
        } finally {
            session.flush();
            session.close();
        }
        return matieres;
    }
        public static Matiere getLastMatiere(int id) {
        Matiere matiere = null;
        Transaction trns = null;
        Session session=HibernateUtil.getSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Matiere as m where m.groupe = :id order by m.codeMat desc";
            Query query = session.createQuery(queryString);
            query.setMaxResults(1);
            query.setInteger("id", id);
            matiere = (Matiere) query.uniqueResult();
        } catch (RuntimeException e) {
        } finally {
            session.flush();
            session.close();
        }
        return matiere;
    }
    public static List<Matiere> getAllMatieresByGroup(int groupe) {
        List<Matiere> notes = new ArrayList<>();
        Transaction trns = null;
        Session session=HibernateUtil.getSession();
        try {
            trns = session.beginTransaction();
            String queryString ="from Matiere where groupe = :grp";
            Query query = session.createQuery(queryString);
            query.setInteger("grp",groupe);
            notes =query.list();
        } catch (RuntimeException e) {
        } finally {
            session.flush();
            session.close();
        }
        return notes;
    }
    public static long VerifierCompostage(int id) 
    {
        long count;
        Session session=HibernateUtil.getSession();
        Query query = session.createQuery("select count (c) from Compostage as c where c.codeNote in (select n.code from Note as n where n.matiere = :id)");
        query.setInteger("id", id);
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
}
