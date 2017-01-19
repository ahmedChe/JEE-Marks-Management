/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import CoucheADO.NiveauADO;
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
@WebServlet(name = "NiveauxController", urlPatterns = {"/NiveauxController"})
public class NiveauxController extends HttpServlet {
    boolean retour=false;
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
            out.println("<title>Servlet NiveauxController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NiveauxController at " + request.getContextPath() + "</h1>");
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
        if (retour|| action.equals("display"))
        {
            retour=false;
            List<Niveau> niveaux;
            niveaux=NiveauADO.getAllNiveaux();     
            session.setAttribute("niveaux", niveaux);
            request.getRequestDispatcher("Niveaux_display.jsp").forward(request, response);
        }
        else
        if (action.equals("delete"))
        {
            int id=Integer.parseInt(request.getParameter("id"));
            NiveauADO.deleteNiveau(id);
            retour=true;
            doGet(request, response);
        }
        else if (action.equals("edit"))
        {
            Niveau niveaux=NiveauADO.getNiveauById(Integer.parseInt(request.getParameter("id")));
            session.setAttribute("niveau", niveaux);
            request.getRequestDispatcher("Niveaux_edit.jsp").forward(request, response);
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
            String niv=request.getParameter("niv");
            Niveau n=new Niveau(niv);
            NiveauADO.addNiveau(n);
            retour=true;
            doGet(request, response);
        }
        else
            if(action.equals("validEdit"))
            {
                String niv=request.getParameter("niv");
                Niveau niveau=(Niveau)session.getAttribute("niveau");
                niveau.setNomNiv(niv);
                NiveauADO.updateNiveau(niveau);
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
