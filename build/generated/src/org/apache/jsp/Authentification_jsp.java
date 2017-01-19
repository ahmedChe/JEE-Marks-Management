package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Authentification_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("        <title>Authentification</title>\r\n");
      out.write("        <link href=\"gentelella/vendors/bootstrap/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!-- Font Awesome -->\r\n");
      out.write("    <link href=\"gentelella/vendors/font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"Signin/form-elements.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"Signin/style.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link rel=\"shortcut icon\" href=\"favicon.png\">\r\n");
      out.write("        <link rel=\"apple-touch-icon-precomposed\" sizes=\"144x144\" href=\"Signin/apple-touch-icon-144-precomposed.png\">\r\n");
      out.write("        <link rel=\"apple-touch-icon-precomposed\" sizes=\"114x114\" href=\"Signin/apple-touch-icon-114-precomposed.png\">\r\n");
      out.write("        <link rel=\"apple-touch-icon-precomposed\" sizes=\"72x72\" href=\"Signin/apple-touch-icon-72-precomposed.png\">\r\n");
      out.write("        <link rel=\"apple-touch-icon-precomposed\" href=\"Signin/apple-touch-icon-57-precomposed.png\">\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-md-3\">\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-6\" >\r\n");
      out.write("                    <div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"top-content\">\r\n");
      out.write("                            <div class=\"inner-bg\" >\r\n");
      out.write("                                <div class=\"container\">\r\n");
      out.write("                                    <div class=\"row\" style=\" \">\r\n");
      out.write("                                        <div class=\"col-sm-7\" style=\"\">\r\n");
      out.write("                                            <div class=\"form-top\">\r\n");
      out.write("                                                <div class=\"form-top-left\">\r\n");
      out.write("                                                    <h3>Connecter à notre site</h3>\r\n");
      out.write("                                                    <p>Entrer le numéro de votre compte et votre mot de passe</p>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                                <div class=\"form-top-right\">\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"form-bottom\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                                <form role=\"form\" method=\"POST\" action=\"AuthentificationController?doing=connexion\" class=\"login-form\">\r\n");
      out.write("                                                   \r\n");
      out.write("                                                     ");

                                                    if (session.getAttribute("message") != null) {
                                                        Integer cpt = (Integer) session.getAttribute("nombre");
                                                        if (cpt == 3) {
                                                            response.sendRedirect("Alert.jsp");
                                                        } else {
                                                
      out.write("\r\n");
      out.write("                                                <div class=\"alert alert-danger\" role=\"alert\">\r\n");
      out.write("                                                    <span  aria-hidden=\"true\"></span>\r\n");
      out.write("                                                    <span class=\"sr-only\">Error:</span>\r\n");
      out.write("                                                    <b>");
 out.println(session.getAttribute("message").toString());
      out.write("..</b>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                                ");

                                                        }
                                                    }
                                                
      out.write("\r\n");
      out.write("                                                    \r\n");
      out.write("                                                    <div class=\"form-group\">\r\n");
      out.write("                                                        <label for=\"form-username\">Numero de compte</label>\r\n");
      out.write("                                                        <input type=\"text\" name=\"login\" required=\"required\"  pattern=\"[0-9]+\" required=\"required\" placeholder=\"Username...\"  required title=\"Le nom d'utilisateur ne contient que des chiffres\" class=\"form-username form-control\" id=\"form-username\">\r\n");
      out.write("                                                    </div>\r\n");
      out.write("                                                    <div class=\"form-group\">\r\n");
      out.write("                                                        <label for=\"form-password\">Mot de passe </label>\r\n");
      out.write("                                                        <input type=\"password\" name=\"password\" required=\"required\"  placeholder=\"Password...\" class=\"form-password form-control\" id=\"form-password\">\r\n");
      out.write("                                                    </div>\r\n");
      out.write("                                                    <button type=\"submit\" class=\"btn\" style=\"margin-top: 10px;font-weight:bold;\">Connexion</button>\r\n");
      out.write("                                                </form>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-3\">\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
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
