/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import CoucheADO.AdministrationADO;
import CoucheADO.EnseignantADO;
import CoucheADO.EtudiantADO;
import CoucheADO.MatiereADO;
import Entities.Etudiant;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "AuthentificationController", urlPatterns = {"/AuthentificationController"})
public class AuthentificationController extends HttpServlet {
    private EnseignantADO ea=new EnseignantADO();
    private EtudiantADO eta=new EtudiantADO();
    private AdministrationADO aa=new AdministrationADO();
    private int nbracces=0;
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
            out.println("<title>Servlet AuthentificationController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AuthentificationController at " + request.getContextPath() + "</h1>");
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
        String action =request.getParameter("doing"); 
        if (action.equals("deconnexion"))
        {
            session.invalidate();
            response.sendRedirect("Authentification.jsp");
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
        String msg="Erreur de saisie...Verifier vos Cordoneés";
        String action =request.getParameter("doing"); 
        if (action.equals("connexion"))
        {
            int login=Integer.parseInt(request.getParameter("login"));
            String password=request.getParameter("password");
            if (EnseignantADO.VerifierCompte(login, password)==1)
            {              
                session.setAttribute("id", EnseignantADO.getEnseignantByLogin(login).getCin());
                session.setAttribute("nomPrenom",EnseignantADO.getEnseignantByLogin(login).getNom()+" "+EnseignantADO.getEnseignantByLogin(login).getPrenom());
                session.setAttribute("doing","EnsDisplay");                
                request.getRequestDispatcher("/GroupeController").forward(request, response);
                
            }
            else if (EtudiantADO.VerifierCompte(login, password)==1)
            {
                    int cin=EtudiantADO.getStudentByLogin(login).getCin();
                    int nombreMatiere=(int)EtudiantADO.NombreMatiere(cin);
                    int MatierePoste=(int)EtudiantADO.MatierePoste(cin);
                    session.setAttribute("CIN",cin);
                    Etudiant etd=EtudiantADO.getStudentByLogin(login);
                    session.setAttribute("nomPrenom",etd.getNom()+" "+etd.getPrenom());
                    session.setAttribute("Matieres",MatiereADO.getMatieresByStudent(cin));
                    session.setAttribute("nbrMatieres",nombreMatiere);
                    session.setAttribute("MatieresP",MatierePoste);
                    response.sendRedirect("Etudiant.jsp"); 
            }
            else
                if (AdministrationADO.VerifierCompte(login, password)==1)
                    response.sendRedirect("Administration.jsp"); 
            else
                {
                    session.setAttribute("message", msg); 
                    session.setAttribute("nombre", nbracces);
                    response.sendRedirect("Authentification.jsp");
                }
        }
         
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
