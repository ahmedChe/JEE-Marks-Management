/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CoucheADO;

import Entities.Matiere;
import Entities.Note;
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
public class NoteADO {
    
    
    
    	public static void addNote(Note note) {
        Transaction trns = null;
        Session session=HibernateUtil.getSession();
        try {
            trns = session.beginTransaction();
            session.save(note);
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

    public static void deleteNote(int id) {
        Transaction trns = null;
        Session session=HibernateUtil.getSession();
        try {
             trns = session.beginTransaction();
            String queryString = "delete Note n where n.matiere = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            query.executeUpdate();
            trns.commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
        } finally {
            session.flush();
            session.close();
        }
    }
    public static void deleteNoteEtudiant(int id) {
        Transaction trns = null;
        Session session=HibernateUtil.getSession();
        try {
             trns = session.beginTransaction();
            String queryString = "delete Note n where n.etudiant = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            query.executeUpdate();
            trns.commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
        } finally {
            session.flush();
            session.close();
        }
    }
    public static void updateNoteEtudiant (int id,float note)
    {
         Transaction trns = null;
        Session session=HibernateUtil.getSession();
        try 
        {
            trns = session.beginTransaction();
            String queryString = "update Note n set n.noteExamen = :note, n.validite = :valeur where n.code = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            query.setInteger("valeur", 2);
            query.setFloat("note", note);
            query.executeUpdate();
            trns.commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
        } finally {
            session.flush();
            session.close();
        }
    }
    public static void updateNote(Note note) {
        Transaction trns = null;
        Session session=HibernateUtil.getSession();
        try {
            trns = session.beginTransaction();
            session.update(note);
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

    public static List<Note> getAllNotes() {
        List<Note> notes = new ArrayList<>();
        Transaction trns = null;
        Session session=HibernateUtil.getSession();
        try {
            trns = session.beginTransaction();
            notes = session.createQuery("from Note").list();
        } catch (RuntimeException e) {
        } finally {
            session.flush();
            session.close();
        }
        return notes;
    }
    public static ArrayList<Note> getAllNotesByMatiere(int id) {
        ArrayList<Note> notes = new ArrayList<>();
        Transaction trns = null;
        Session session=HibernateUtil.getSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Note where matiere = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            notes =(ArrayList<Note>)query.list();
        } catch (RuntimeException e) {
        } finally {
            session.flush();
            session.close();
        }
        return notes;
    }
    public static ArrayList<Note> getAllNotesByStudent(int id) {
        ArrayList<Note> notes = new ArrayList<>();
        Transaction trns = null;
        Session session=HibernateUtil.getSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Note where etudiant = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            notes =(ArrayList<Note>)query.list();
        } catch (RuntimeException e) {
        } finally {
            session.flush();
            session.close();
        }
        return notes;
    }
    public static Note getNoteById(int id) {
        Note note = null;
        Transaction trns = null;
        Session session=HibernateUtil.getSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Note where code = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            note = (Note) query.uniqueResult();
        } catch (RuntimeException e) {
        } finally {
            session.flush();
            session.close();
        }
        return note;
    }
    public static Note getNoteByMatiere(int cin,int matiere) {
        Note note = null;
        Transaction trns = null;
        Session session=HibernateUtil.getSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Note as n where n.matiere = :mat and n.etudiant = :cin";
            Query query = session.createQuery(queryString);
            query.setInteger("mat", matiere);
            query.setInteger("cin", cin);          
            note =(Note) query.uniqueResult();
        } catch (RuntimeException e) {
        } finally {
            session.flush();
            session.close();
        }
        return note;
    }
}
