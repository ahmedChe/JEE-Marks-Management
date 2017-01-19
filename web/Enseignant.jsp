<%-- 
    Document   : Enseignant
    Created on : 19 mai 2016, 00:23:48
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
        <c:set var="ens" value="${sessionScope['enseignant']}"/>
        <c:set var="nomP" value="${sessionScope['nomPrenom']}"/>
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
    <div class="row">
 
        <title>Enseignant Tableau de bord</title>
        
        <a href="GroupeController?doing=EnsDisplay&id=${ens}">Groupes</a>
          <a href="AuthentificationController?doing=deconnexion">Deconnexion</a>
   </div>
    </div>
        <%@include file="FooterEnseignant.html"%>