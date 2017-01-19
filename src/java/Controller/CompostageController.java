/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import CoucheADO.CompostageADO;
import CoucheADO.MatiereADO;
import CoucheADO.NoteADO;
import Entities.Compostage;
import Entities.Matiere;
import Entities.Note;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
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
@WebServlet(name = "CompostageController", urlPatterns = {"/CompostageController"})
public class CompostageController extends HttpServlet {

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
            out.println("<title>Servlet CompostageController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CompostageController at " + request.getContextPath() + "</h1>");
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
        int compostage[];
        List<Matiere> matieres;
        HttpSession session=request.getSession();
        String action =request.getParameter("doing");
        switch (action)
        {
            case "generer":
            {
                int matiere=Integer.parseInt(request.getParameter("id"));
                int CodeGrp=MatiereADO.getMatiereById(matiere).getGroupe();
                ArrayList<Note> notes=NoteADO.getAllNotesByMatiere(matiere);     
                compostage = ThreadLocalRandom.current().ints(100000,999999).distinct().limit(notes.size()).toArray();
                for (int i=0;i<notes.size();i++)
                {
                    Compostage c=new Compostage(compostage[i], notes.get(i).getCode());
                    CompostageADO.addCompostage(c);            
                }
                matieres=MatiereADO.getMatieresByGRP(CodeGrp);         
                session.setAttribute("matieres", matieres);
                request.getRequestDispatcher("Matieres_display.jsp").forward(request, response);
                break;
            }
            case "compostage":
             {
                 List<Compostage> comps;
                 int matiere=Integer.parseInt(request.getParameter("id"));
                 comps=CompostageADO.Compostages(matiere);
                 session.setAttribute("compostages", comps);
                 request.getRequestDispatcher("Compostages_Enseignant.jsp").forward(request, response);
                 break;
             }
            default:
                break;
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
        String action =request.getParameter("doing");
    
        if (action.equals("postuler"))
            {
                String[] note=request.getParameterValues("note");
                List<Compostage> comps=(List<Compostage>)session.getAttribute("compostages");
                for (int x=0;x<comps.size();x++)
                {
                    comps.get(x).setNote(Float.parseFloat(note[x]));
                    CompostageADO.updateCompostage(comps.get(x));
                    NoteADO.updateNoteEtudiant(comps.get(x).getCodeNote(),comps.get(x).getNote());
                }
                response.sendRedirect("GroupesEnseignant.jsp");
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
