/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import CoucheADO.EnseignantADO;
import CoucheADO.EtudiantADO;
import Entities.Enseignant;
import Entities.Etudiant;
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
@WebServlet(name = "EnseignantController", urlPatterns = {"/EnseignantController"})
public class EnseignantController extends HttpServlet {
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
            out.println("<title>Servlet EnseignantController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EnseignantController at " + request.getContextPath() + "</h1>");
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
        if (retour)
        {
            retour=false;
            displayGroupe(request, response);
        }
        else
        {
            switch (action)
            {
                case "display":
                    displayGroupe(request, response);
                    break;
                case "delete":
                {
                    int id=Integer.parseInt(request.getParameter("id"));                                        
                    EnseignantADO.deleteEnseignant(id);
                    retour=true;
                    doGet(request, response);
                }
                case "edit":
                {
                    Enseignant enseignant=EnseignantADO.getEnseignantByCode(Integer.parseInt(request.getParameter("id")));                  
                    session.setAttribute("enseignant", enseignant);                                     
                    request.getRequestDispatcher("Enseignant_Edit.jsp").forward(request, response);                     
                    break;
                }
                case "load":
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
                    session.setAttribute("code", login); 
                    request.getRequestDispatcher("Enseignant_add.jsp").forward(request, response);                     

                }
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
            int cin=Integer.parseInt(request.getParameter("cin"));
            int matricule=Integer.parseInt(request.getParameter("mf"));
            String nom=request.getParameter("nom");
            String prenom=request.getParameter("prenom");  
            String adresse=request.getParameter("adr");
            int tel=Integer.parseInt(request.getParameter("tel"));
            int code=Integer.parseInt(request.getParameter("login"));
            String password=request.getParameter("pass");
            Enseignant e=new Enseignant(cin, matricule, nom, prenom, adresse, tel, code, password);
            EnseignantADO.addEnseignant(e);
            retour=true;
            doGet(request, response);
        }
        else
            if (action.equals("validEdit"))
            {
                Enseignant ens=EnseignantADO.getEnseignantByCode(Integer.parseInt(request.getParameter("cin")));
                String adresse=request.getParameter("adr");
                int tel=Integer.parseInt(request.getParameter("tel"));
                int code=Integer.parseInt(request.getParameter("login"));
                String password=request.getParameter("pass");              
                ens.setAdresse(adresse);
                ens.setTel(tel);
                ens.setCodeUser(code);
                ens.setPassword(password);
                EnseignantADO.updateEnseignant(ens);
                retour=true;
                doGet(request, response);
            }
    }
    protected void displayGroupe(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        HttpSession session=request.getSession();
        List<Enseignant> enseignants;
        enseignants=EnseignantADO.getAllEnseignants();
        session.setAttribute("enseignants", enseignants);
        request.getRequestDispatcher("Enseignants_display.jsp").forward(request, response);
        
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

}
