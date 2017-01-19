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
@WebServlet(name = "MatiereController", urlPatterns = {"/MatiereController"})
public class MatiereController extends HttpServlet {
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
            out.println("<title>Servlet MatiereController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MatiereController at " + request.getContextPath() + "</h1>");
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
         HttpSession session=request.getSession();
        switch (action)
            {
                case "display":
                {
                 int groupe=Integer.parseInt(request.getParameter("id"));
                 display(groupe,request,response);
                 break;
                }
                case "delete":
                {
                    int id=Integer.parseInt(request.getParameter("id"));  
                    MatiereADO.deleteMatiere(id);
                    NoteADO.deleteNote(id);
                    int groupe=Integer.parseInt(request.getParameter("groupe"));
                    display(groupe, request, response);
                }
                case "loadAdd":
                {
                    int groupe=Integer.parseInt(request.getParameter("id"));                                        
                    ArrayList<Enseignant>enseignants=(ArrayList<Enseignant>) EnseignantADO.getAllEnseignants();
                    session.setAttribute("enseignants", enseignants);
                    Groupe grp=GroupeADO.getGroupeById(groupe);
                    session.setAttribute("groupe", grp);
                    request.getRequestDispatcher("Matieres_add.jsp").forward(request, response);
                }
                case "loadMatiere":
                {
                    int id=Integer.parseInt(request.getParameter("id")); 
                    Matiere m =MatiereADO.getMatiereById(id);
                    session.setAttribute("matiere", m);
                    ArrayList<Enseignant>enseignants=(ArrayList<Enseignant>) EnseignantADO.getAllEnseignants();
                    session.setAttribute("enseignants", enseignants);
                    request.getRequestDispatcher("Matieres_edit.jsp").forward(request, response);
                }
               
            }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param groupe
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    public void display (int groupe,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
            List<Matiere> matieres;
            HttpSession session=request.getSession();
            
            matieres=MatiereADO.getMatieresByGRP(groupe);         
            session.setAttribute("matieres", matieres);
            request.getRequestDispatcher("Matieres_display.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        String action=request.getParameter("doing");
        if (action.equals("add"))
        {
            String lib=request.getParameter("lib");
            float vc=Float.parseFloat(request.getParameter("vc"));
            float vtd=Float.parseFloat(request.getParameter("vtd"));
            float vtp=Float.parseFloat(request.getParameter("vtp"));
            float coef=Float.parseFloat(request.getParameter("coef"));
            float credit=Float.parseFloat(request.getParameter("crd"));
            int ens=Integer.parseInt(request.getParameter("ens"));
            int grp=Integer.parseInt(request.getParameter("id"));
            Matiere m=new Matiere(lib,vc,vtd,vtp,coef,credit,ens,grp);
            MatiereADO.addMatiere(m);
            List<Etudiant> etudiants=EtudiantADO.getGroupEtudiants(grp);
            int code=MatiereADO.getLastMatiere(grp).getCodeMat();
                        etudiants.stream().map((e) -> new Note (0,0,0,0,code,e.getCin(),SessionADO.GetCurrentYear().getIdSession())).forEach((note) -> {
                NoteADO.addNote(note);
            });
            display(grp, request, response);
            

        }
        else
        {
            if (action.equals("edit"))
            {
                Matiere matiere=(Matiere)session.getAttribute("matiere");
                
                float vc=Float.parseFloat(request.getParameter("vc"));
                float vtd=Float.parseFloat(request.getParameter("vtd"));
                float vtp=Float.parseFloat(request.getParameter("vtp"));
                float coef=Float.parseFloat(request.getParameter("coef"));
                float credit=Float.parseFloat(request.getParameter("crd"));
                int ens=Integer.parseInt(request.getParameter("ens"));
                matiere.setVolumeC(vc);
                matiere.setVolumeTd(vtd);
                matiere.setVolumeTp(vtp);
                matiere.setCoeffecient(coef);
                matiere.setCredit(credit);
                matiere.setEnseignant(ens);
                MatiereADO.updateMatiere(matiere);
                display(matiere.getGroupe(), request, response);
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
