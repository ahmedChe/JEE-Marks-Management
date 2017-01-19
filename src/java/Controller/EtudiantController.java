/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import CoucheADO.EnseignantADO;
import CoucheADO.EtudiantADO;
import CoucheADO.GroupeADO;
import CoucheADO.MatiereADO;
import CoucheADO.NoteADO;
import CoucheADO.SessionADO;
import Entities.Enseignant;
import Entities.Etudiant;
import Entities.Groupe;
import Entities.Matiere;
import Entities.Note;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author !l-PazZ0
 */
@WebServlet(name = "EtudiantController", urlPatterns = {"/EtudiantController"})
public class EtudiantController extends HttpServlet {
    private boolean retour=false;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EtudiantController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EtudiantController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       HttpSession session=request.getSession();
        String action=request.getParameter("doing");       
            List<Groupe>groupes;
            switch (action)
            {
                case "display":
                    displayGroupe(request, response,Integer.parseInt(request.getParameter("id")));
                    break;
                case "inscription":
                {
                    groupes=GroupeADO.getAllGroupes();
                    session.setAttribute("groupes", groupes);
                    List<Etudiant> etudiants=EtudiantADO.getAllEtudiants();
                    int numinscrip=0;
                    if (!etudiants.isEmpty())
                    {
                        for (Etudiant etd:etudiants)
                        {
                            if (etd.getNumInscription()>numinscrip)
                                numinscrip=etd.getNumInscription();
                        }   
                       
                    }
                    session.setAttribute("login", getLogin());
                    session.setAttribute("numinscri", numinscrip);
                    request.getRequestDispatcher("Etudiant_add.jsp").forward(request, response);
                    break;
                }
                case "delete":
                {
                    int id=Integer.parseInt(request.getParameter("id"));                                        
                    int grp=Integer.parseInt(request.getParameter("group")); 
                    EtudiantADO.deleteEtudiant(id);
                    NoteADO.deleteNoteEtudiant(id);
                    displayGroupe(request, response,grp);
                     break;
                }
                case "loadData":
                {
                    int id=Integer.parseInt(request.getParameter("id"));                                        
                    Etudiant etd=EtudiantADO.getEtudiantByCode(id);
                    session.setAttribute("etudiant", etd);
                    groupes=GroupeADO.getAllGroupes();
                    List<Etudiant> etudiants=EtudiantADO.getAllEtudiants();
                    int numinscrip=0;
                    if (!etudiants.isEmpty())
                    {
                        for (Etudiant etud:etudiants)
                        {
                            if (etud.getNumInscription()>numinscrip)
                                numinscrip=etud.getNumInscription();
                        }                         
                    }
                    session.setAttribute("login", getLogin());
                    session.setAttribute("numinscri", numinscrip);
                    session.setAttribute("groupes", groupes);
                    request.getRequestDispatcher("Etudiant_edit.jsp").forward(request, response);
                }
                case "addPersonalise":
                {
                    session.setAttribute("login", getLogin());
                    int groupe=Integer.parseInt(request.getParameter("id"));
                    session.setAttribute("groupe", groupe);
                    request.getRequestDispatcher("Etudiant_addPersonalise.jsp").forward(request, response);
                }
            }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session=request.getSession();
        String action=request.getParameter("doing");
        if (action.equals("add"))
        {
            int groupe=Integer.parseInt(request.getParameter("grp"));
            add(groupe, request, response);
            List<Matiere> matieres=MatiereADO.getAllMatieresByGroup(groupe);
            int cin=Integer.parseInt(request.getParameter("cin"));
            matieres.stream().map((mat) -> new Note (0,0,0,0,mat.getCodeMat(),cin,SessionADO.GetCurrentYear().getIdSession())).forEach((note) -> {
                NoteADO.addNote(note);
            });
            String redirect=request.getParameter("redirect");
            if (redirect==null)
                request.getRequestDispatcher("Administration.jsp").forward(request, response);
            else 
                displayGroupe(request, response, groupe);
        }
        else
        {
            if (action.equals("Edit"))
            {
                Etudiant etd=EtudiantADO.getEtudiantByCode(Integer.parseInt(request.getParameter("cin")));
                String adresse=request.getParameter("adr");
                int tel=Integer.parseInt(request.getParameter("tel"));
                int code=Integer.parseInt(request.getParameter("login"));
                String password=request.getParameter("pass");       
                int group=Integer.parseInt(request.getParameter("grp"));               
                etd.setAdresse(adresse);
                etd.setTel(tel);
                etd.setCodeUser(code);
                etd.setPassword(password);
                etd.setGroupe(group);
                EtudiantADO.updateEtudiant(etd);
                displayGroupe(request, response,group);   
            }
        }
    }
    protected void displayGroupe(HttpServletRequest request, HttpServletResponse response,int code) throws IOException, ServletException
    {
        HttpSession session=request.getSession();
        List<Etudiant> etudiants;
        etudiants=EtudiantADO.getGroupEtudiants(code);
        session.setAttribute("etudiants", etudiants);
        session.setAttribute("id", code);
        request.getRequestDispatcher("Etudiants_display.jsp").forward(request, response);
        
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    public void add (int groupe,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int cin=Integer.parseInt(request.getParameter("cin"));
            int numInscrip=Integer.parseInt(request.getParameter("ni"));
            String nom=request.getParameter("nom");
            String prenom=request.getParameter("prenom");  
            String adresse=request.getParameter("adr");
            int tel=Integer.parseInt(request.getParameter("tel"));
            int code=Integer.parseInt(request.getParameter("login"));
            
            String password=request.getParameter("pass");
            Etudiant etd=new Etudiant(cin, numInscrip, nom, prenom, adresse, tel, code, password, groupe);
            EtudiantADO.addEtudiant(etd);

    }
    public int getLogin()
    {
                    int login=0;
                    List<Enseignant> enseignants=EnseignantADO.getAllEnseignants();
                    if (!enseignants.isEmpty())
                    {
                        login=enseignants.get(0).getCodeUser();
                        for (Enseignant ens:enseignants)
                        {
                            if (ens.getCodeUser()>login)
                                login=ens.getCodeUser();
                        }
                    }
                    List<Etudiant> etudiants=EtudiantADO.getAllEtudiants();
                    if (!etudiants.isEmpty())
                    {
                        for (Etudiant etd:etudiants)
                        {
                            if (etd.getCodeUser()>login)
                                login=etd.getCodeUser();
                        }   
                       
                    }
          return login;
    }
}
