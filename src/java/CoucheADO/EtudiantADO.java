/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CoucheADO;

import Entities.Etudiant;
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
public class EtudiantADO {
    

    public static long VerifierCompte(int user,String password) 
    {
        Session session=HibernateUtil.getSession();
        long count;
        Query query = session.createQuery("select count (e) from Etudiant as e where e.codeUser= :user and e.password= :pass");
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
    public static void addEtudiant(Etudiant etd) {
        Session session=HibernateUtil.getSession();    
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.save(etd);
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

    public static void deleteEtudiant(int id) {
        Transaction trns = null;
        Session session=HibernateUtil.getSession();
        try {
            trns = session.beginTransaction();
            Etudiant etd = (Etudiant) session.load(Etudiant.class,id);
            session.delete(etd);
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

    public static void updateEtudiant(Etudiant etd) {
        Session session=HibernateUtil.getSession();
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.update(etd);
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

    public static List<Etudiant> getGroupEtudiants(int groupe) {
        Session session=HibernateUtil.getSession();
        List<Etudiant> etudiants = new ArrayList<>();
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            String queryString = "from Etudiant where groupe = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", groupe);
            etudiants =query.list();
        } catch (RuntimeException e) {
        } finally {
            session.flush();
            session.close();
        }
        return etudiants;
    }
    
    public static Etudiant getEtudiantByCode(int id) {
        Etudiant ens = null;
        Transaction trns = null;
        Session session=HibernateUtil.getSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Etudiant where cin = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            ens = (Etudiant) query.uniqueResult();
        } catch (RuntimeException e) {
        } finally {
            session.flush();
            session.close();
        }
        return ens;
    }
     public static long NombreMatiere(int cin) 
    {
        Session session=HibernateUtil.getSession();
        long count;
        String queryString = "select count (m) from Matiere as m where m.groupe=(select e.groupe from Etudiant as e where e.cin = :cin)";
        Query query = session.createQuery(queryString);
        query.setInteger("cin", cin);        
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
     public static List<Etudiant> getAllEtudiants() {
        Session session=HibernateUtil.getSession();
        List<Etudiant> etudiants = new ArrayList<>();
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            etudiants = session.createQuery("from Etudiant").list();
        } catch (RuntimeException e) {
        } finally {
            session.flush();
            session.close();
        }
        return etudiants;
    }
     public static long MatierePoste(int cin) 
    {
        Session session=HibernateUtil.getSession();
        long count;
        String queryString = "select count (n) from Note as n where n.etudiant= :cin and n.validite = :value";
        Query query = session.createQuery(queryString);
        query.setInteger("cin", cin);
        query.setInteger("value",2); 
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
     public static Etudiant getStudentByLogin(int id) {
        Etudiant etd = null;
        Transaction trns = null;
        Session session=HibernateUtil.getSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Etudiant where codeUser = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            etd = (Etudiant) query.uniqueResult();
        } catch (RuntimeException e) {
        } finally {
            session.flush();
            session.close();
        }
        return etd;
    }
}
