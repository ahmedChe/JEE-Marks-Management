/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import CoucheADO.GroupeADO;
import CoucheADO.NiveauADO;
import Entities.Groupe;
import Entities.Niveau;
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
@WebServlet(name = "GroupeController", urlPatterns = {"/GroupeController"})
public class GroupeController extends HttpServlet {
    boolean retour=false;
    private int niveauChosi=0;
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
            out.println("<title>Servlet GroupeController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GroupeController at " + request.getContextPath() + "</h1>");
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
        System.out.println("ok");
        if (session.getAttribute("doing")!=null)
        {
            System.out.println("ok");
            if (session.getAttribute("doing").toString().equals("EnsDisplay"))
                    {
                        int id=(int)session.getAttribute("id");
                        String nomP=(String)session.getAttribute("nomPrenom");
                        List<Groupe> groupes=GroupeADO.getGroupeByEnseignant(id);
                        session.setAttribute("selectionGroupes", groupes);
                        session.setAttribute("enseignant", id);
                        session.setAttribute("nomPrenom", nomP);
                        response.sendRedirect("GroupesEnseignant.jsp");                 
                    } 
        }
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
                case "EnsDisplay":
                {
                    int id=Integer.parseInt(request.getParameter("id"));
                    String nomP=request.getParameter("nomPrenom");
                    List<Groupe> groupes=GroupeADO.getGroupeByEnseignant(id);
                    /*session.removeAttribute("selectionGroupes");
                    session.removeAttribute("enseignant");
                    session.removeAttribute("nomPrenom");*/
                    session.setAttribute("selectionGroupes", groupes);
                    session.setAttribute("enseignant", id);
                    session.setAttribute("nomPrenom",nomP);
                    //response.sendRedirect("GroupesEnseignant.jsp"); 
                    System.out.println("oki");
                    break;
                }   
                case "display":
                    displayGroupe(request, response);
                    break;
                case "chargerCombo":
                {
                    String redirect=request.getParameter("niveau");
                    if (redirect==null)
                    {
                         session.setAttribute("niveaux", NiveauADO.getAllNiveaux());
                         request.getRequestDispatcher("Groupes_add.jsp").forward(request, response);                        
                    }
                    else
                    {
                        session.setAttribute("niveau",Integer.parseInt(redirect));
                        request.getRequestDispatcher("NiveauGroupes_add.jsp").forward(request, response);
                    }
                    break;
                }
                case "delete":
                {
                    int id=Integer.parseInt(request.getParameter("id"));  
                    int niv=GroupeADO.getGroupeById(id).getNiveau();
                    Niveau n=NiveauADO.getNiveauById(niv);                    
                    n.setNombreGrp(n.getNombreGrp()-1);
                    NiveauADO.updateNiveau(n);
                    GroupeADO.deleteGroupe(id);
                    retour=true;
                    doGet(request, response);
                }
                case "edit":
                {
                    Groupe groupe=GroupeADO.getGroupeById(Integer.parseInt(request.getParameter("id")));                  
                    session.setAttribute("groupe", groupe);
                    String redirect=request.getParameter("niv");
                    if (redirect==null)
                    {
                        session.setAttribute("niveaux", NiveauADO.getAllNiveaux());
                        request.getRequestDispatcher("Groupes_edit.jsp").forward(request, response);                     
                    }
                    else
                    {
                       request.getRequestDispatcher("NiveauGroupes_edit.jsp").forward(request, response);
                    }

                    break;
                }
                case "selection":
                {
                    String redirect=request.getParameter("retour");
                    int id=Integer.parseInt(request.getParameter("id")); 
                    if (redirect!=null)
                    {
                        id=GroupeADO.getGroupeById(id).getNiveau();
                    }
                    List<Groupe> groupes=GroupeADO.getGroupesByNiveau(id);
                    session.setAttribute("selectionGroupes", groupes);
                    request.getRequestDispatcher("NiveauGroupes.jsp").forward(request, response);
                    break;
                }
                
                default:
                    break;
            }
        }
        
    }
    protected void displayGroupe(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        HttpSession session=request.getSession();
        List<Groupe> groupes;
        
        /*if (niveauChosi!=0)
        {
            groupes=GroupeADO.getGroupesByNiveau(niveauChosi);
            session.setAttribute("selectionGroupes", groupes);
            request.getRequestDispatcher("NiveauGroupes.jsp").forward(request, response);
        }
        else
        {*/
            groupes=GroupeADO.getAllGroupes();
            session.setAttribute("groupes", groupes);
            System.out.println("ok");
            request.getRequestDispatcher("Groupes_display.jsp").forward(request, response);
       // }
        
        
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
        String doing=(String)session.getAttribute("doing");
        if (doing.equals("EnsDisplay"))
                {
                    int id=(int)session.getAttribute("id");
                    String nomP=(String)session.getAttribute("nomPrenom");
                    List<Groupe> groupes=GroupeADO.getGroupeByEnseignant(id);
                    session.setAttribute("selectionGroupes", groupes);
                    session.setAttribute("enseignant", id);
                    session.setAttribute("nomPrenom", nomP);
                    response.sendRedirect("GroupesEnseignant.jsp");                 
                }   
        String action=request.getParameter("doing");
        if (action.equals("add"))
        {
            int niv=Integer.parseInt(request.getParameter("Niveau"));
            String nom=request.getParameter("nom");
            String abrev=request.getParameter("ab");
            Groupe g=new Groupe(nom,abrev,niv);
            GroupeADO.addGroupe(g);
            Niveau n=NiveauADO.getNiveauById(niv);
            n.setNombreGrp(n.getNombreGrp()+1);
            NiveauADO.updateNiveau(n);
            if (request.getParameter("niv")!=null)
            {
                niveauChosi=Integer.parseInt(request.getParameter("niv"));
            }
            retour=true;
            doGet(request, response);
        }
        else
            if (action.equals("validEdit"))
            {
                int niv=Integer.parseInt(request.getParameter("Niveau"));
                String libelle=request.getParameter("nom");
                String abrev=request.getParameter("ab");
                Groupe groupe=(Groupe)session.getAttribute("groupe");
                groupe.setNomGrp(libelle);
                groupe.setAbreviation(abrev);
                groupe.setNiveau(niv);
                GroupeADO.updateGroupe(groupe);
                if (request.getParameter("niv")!=null)
                    niveauChosi=Integer.parseInt(request.getParameter("niv"));
                retour=true;
                doGet(request, response);
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
