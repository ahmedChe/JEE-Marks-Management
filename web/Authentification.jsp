<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Authentification</title>
        <link href="gentelella/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="gentelella/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="Signin/form-elements.css" rel="stylesheet">
    <link href="Signin/style.css" rel="stylesheet">
        <link rel="shortcut icon" href="favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="Signin/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="Signin/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="Signin/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="Signin/apple-touch-icon-57-precomposed.png">

    </head>
    <body>


        <div class="container-fluid">
            <div class="row">
                <div class="col-md-3">
                </div>
                <div class="col-md-6" >
                    <div class="container">

                        <div class="top-content">
                            <div class="inner-bg" >
                                <div class="container">
                                    <div class="row" style=" ">
                                        <div class="col-sm-7" style="">
                                            <div class="form-top">
                                                <div class="form-top-left">
                                                    <h3>Connecter à notre site</h3>
                                                    <p>Entrer le numéro de votre compte et votre mot de passe</p>
                                                </div>
                                                <div class="form-top-right">
                                                </div>
                                            </div>
                                            <div class="form-bottom">


                                                <form role="form" method="POST" action="AuthentificationController?doing=connexion" class="login-form">
                                                   
                                                     <%
                                                    if (session.getAttribute("message") != null) {
                                                        Integer cpt = (Integer) session.getAttribute("nombre");
                                                        if (cpt == 3) {
                                                            response.sendRedirect("Alert.jsp");
                                                        } else {
                                                %>
                                                <div class="alert alert-danger" role="alert">
                                                    <span  aria-hidden="true"></span>
                                                    <span class="sr-only">Error:</span>
                                                    <b><% out.println(session.getAttribute("message").toString());%>..</b>
                                                </div>
                                                <%
                                                        }
                                                    }
                                                %>
                                                    
                                                    <div class="form-group">
                                                        <label for="form-username">Numero de compte</label>
                                                        <input type="text" name="login" required="required"  pattern="[0-9]+" required="required" placeholder="Username..."  required title="Le nom d'utilisateur ne contient que des chiffres" class="form-username form-control" id="form-username">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="form-password">Mot de passe </label>
                                                        <input type="password" name="password" required="required"  placeholder="Password..." class="form-password form-control" id="form-password">
                                                    </div>
                                                    <button type="submit" class="btn" style="margin-top: 10px;font-weight:bold;">Connexion</button>
                                                </form>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>

                        </div>

                    </div>
                </div>
                <div class="col-md-3">
                </div>
            </div>
        </div>
    </body>
</html>