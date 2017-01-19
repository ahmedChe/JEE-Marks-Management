/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import CoucheADO.NoteADO;
import Entities.Note;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "NoteController", urlPatterns = {"/NoteController"})
public class NoteController extends HttpServlet {

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
            out.println("<title>Servlet NoteController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NoteController at " + request.getContextPath() + "</h1>");
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
        String action=request.getParameter("doing");
        switch (action)
        {
            case "Display":
            {
                HttpSession session=request.getSession();
                int id=Integer.parseInt(request.getParameter("id"));
                ArrayList<Note>liste=NoteADO.getAllNotesByMatiere(id);    
                session.setAttribute("notes", liste);
                int ens=Integer.parseInt(request.getParameter("ens"));
                String nomP=request.getParameter("nomPrenom");
                session.setAttribute("enseignant", ens);
                session.setAttribute("nomPrenom",nomP);
                request.getRequestDispatcher("Notes_Enseignant.jsp").forward(request, response);
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
        String action=request.getParameter("doing");
        if (action.equals("update"))
        {
            Note note=null;
            String [] notestp=request.getParameterValues("notetp");
            String [] notesds=request.getParameterValues("noteds");           
            String [] notespres=request.getParameterValues("notepres");          
            List<Note>notes=(List<Note>)session.getAttribute("notes");
            for (int x=0;x<notes.size();x++)
            {
                note=notes.get(x);
                note.setValidite(1);
                note.setNoteTp(Float.parseFloat(notestp[x]));
                note.setNoteDs(Float.parseFloat(notesds[x]));
                note.setNotePresentielle(Float.parseFloat(notespres[x]));
                NoteADO.updateNote(note);
            }
            session.setAttribute("notes", notes);
            request.getRequestDispatcher("Notes_Enseignant.jsp").forward(request, response);
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
