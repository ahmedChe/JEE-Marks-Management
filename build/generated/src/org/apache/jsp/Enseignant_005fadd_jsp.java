package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Enseignant_005fadd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/Includes/Entete.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>AJOUTER UN NOVEAU ENSEIGNANT</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("        <a href=\"NiveauxController?doing=display\">Niveaux</a>\n");
      out.write("        <a href=\"GroupeController?doing=display\">Groupes</a>\n");
      out.write("        <a href=\"EnseignantController?doing=display\">Enseignants</a>\n");
      out.write("        <a href=\"EtudiantController?doing=inscription\">Inscription</a>\n");
      out.write("        <a href=\"AuthentificationController?doing=deconnexion\">Deconnexion</a>\n");
      out.write("\n");
      out.write("           <form method=\"POST\" action=\"EnseignantController?doing=add\">\n");
      out.write("           CIN :<input type=\"text\" name=\"cin\"><br>\n");
      out.write("           Matricule Fiscale :<input type=\"text\" name=\"mf\"><br>\n");
      out.write("           Nom :<input type=\"text\" name=\"nom\"><br>\n");
      out.write("           Prenom :<input type=\"text\" name=\"prenom\"><br>\n");
      out.write("           Adresse :<input type=\"text\" name=\"adr\"><br>\n");
      out.write("           Tel :<input type=\"text\" name=\"tel\"><br>\n");
      out.write("           Login :<input type=\"text\" name=\"login\"><br>\n");
      out.write("           Password :<input type=\"password\" name=\"pass\"><br>\n");
      out.write("           <input type=\"submit\" value=\"Add\"> <input type=\"reset\" value=\"Annuler\"><br>\n");
      out.write("           <input type=\"button\" value=\"Retour\" onclick=\"history.go(-1)\">\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
