<%-- 
    Document   : Etudiant
    Created on : 20 mai 2016, 21:08:53
    Author     : !l-PazZ0
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Gestion de notes </title>

    <!-- Bootstrap -->
    <link href="gentelella/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="gentelella/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="gentelella/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- bootstrap-progressbar -->
    <link href="gentelella/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <!-- jVectorMap -->
    <link href="gentelella/production/css/maps/jquery-jvectormap-2.0.3.css" rel="stylesheet"/>

    <!-- Custom Theme Style -->
    <link href="gentelella/build/css/custom.min.css" rel="stylesheet">
  </head>

  <body class="nav-md">
             <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <body>
        <c:set var="nomP" value="${sessionScope['nomPrenom']}"/>
        <c:set var="nbr" value="${sessionScope['nbrMatieres']}"/>   
        <c:set var="poste" value="${sessionScope['MatieresP']}"/>  
        <c:set var="mat" value="${sessionScope['Matieres']}"/>   
        <c:set var="cin" value="${sessionScope['CIN']}"/> 
        <c:set var="session" value="${mat[0].note(cin).getSessionName ()}"/> 
        <div class="container body">
      <div class="main_container">
        

        <!-- top navigation -->
        
          <div class="nav_menu">
            <nav>
            

              <ul class="nav navbar-nav navbar-right">
                <li class="">
                  <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    <img src="images/inconnu.png" alt="">${nomP}
                    <span class=" fa fa-angle-down"></span>
                  </a>
                  <ul class="dropdown-menu dropdown-usermenu pull-right">
                    
                    <li><a href="AuthentificationController?doing=deconnexion"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                  </ul>
                </li>

                <li role="presentation" class="dropdown">
                  <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
                    <i class="fa fa-envelope-o"></i>
                    <span class="badge bg-green"></span>
                  </a>
                  
                </li>
              </ul>
            </nav>
          </div>


    <div class="right_col" style="margin-left: 0px;" role="main">
    <div class="row"style="margin-top: 50px;">
         <div class="panel panel-default" style="margin-top: 50px;font-weight: bold;background-color: #b5c7da">
          <div class="panel-heading" style="background-color: #2A3F54;color:white">Liste des notes</div>
            <div class="panel-body">

        <c:if test="${nbr>poste}">
            
            <div class="alert alert-danger" style="margin-top: 20px;"role="alert">
            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
            
            <h3 style="color: #2A3F54;font-weight: bolder;text-align: center;">Les Notes ne sont pas encore publiés par l'administration</h1>
          </div>
           
         
        </c:if>
        <c:if test="${nbr==poste}">
        <table class="table">
             <thead>
            <th colspan="5" style="color:#2A3F54;font-size: xx-large;font-weight: bold;text-align: center;line-height: 50px;">Session ${session}</th>
            
            <tr><td colspan="3" style="font-weight: bold;color: black;font-size: 1.3em;">Matiere</td><td style="font-weight: bold;font-size: 1.3em;color: black;padding-left: 150px;">Coeffecient</td></tr>
            <hr>
        </thead>
            <tbody>
            <c:forEach var="m" items="${mat}">
            <tr><td colspan="3" style="border: none;font-size: 1.2em;font-weight: bold;color: gray">${m.getLibelle()}</td><td style="border: none;font-weight: bold;padding-left: 185px;font-size: 1.2em;color: gray">${m.getCoeffecient()}</td></tr>
             <tr><td style='font-size: 1.1em;font-weight: bold;padding-left: 70px;width:300px;'>Note TP</td><td style='font-size: 1.1em;font-weight: bold;padding-left: 35px;width:400px;'>Note Presentielle</td><td style='font-size: 1.1em;font-weight: bold;padding-left: 0px;'>Note DS</td><td style='font-size: 1.1em;font-weight: bold;padding-left: 30px;width:300px;'>Note Examen</td></tr>
              <tr><td style='font-weight: bold;padding-left: 85px;'>${m.note(cin).getNoteTp()}</td><td style='font-weight: bold;padding-left: 85px;'>${m.note(cin).getNotePresentielle()}</td><td style='font-weight: bold;padding-left: 20px;'>${m.note(cin).getNoteDs()}</td><td style='font-weight: bold;padding-left: 60px;'>${m.note(cin).getNoteExamen()}</td></tr>
        </c:forEach>
            </tbody>
        </table>
        </c:if>
   </div>
    </div>
          </div>
    </div>
        <%@include file="FooterEnseignant.html"%>
