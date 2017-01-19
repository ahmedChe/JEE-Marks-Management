<%-- 
    Document   : GroupesEnseignant
    Created on : 19 mai 2016, 00:54:47
    Author     : !l-PazZ0
--%>

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
    <div class="row"style="margin-top: 50px;">
        <c:set var="selg" value="${sessionScope['selectionGroupes']}"/>
        <c:set var="ens" value="${sessionScope['enseignant']}"/>      
         <div class="panel panel-default" style="margin-top: 50px;font-weight: bold;background-color: #b5c7da">
          <div class="panel-heading" style="background-color: #2A3F54;color:white">Groupes</div>
            <div class="panel-body">
         <table class="table">
             <thead>
        <tr><td colspan="3"style="font-weight: bolder;text-align: center;color: #2A3F54">Nom du groupe</td><td colspan="3"style="font-weight: bolder;color: #2A3F54;padding-left: 130px;">Abreviation</td><td colspan="3"style="font-weight: bolder;padding-left: 280px;color: #2A3F54">Niveau</td></tr>
        </thead>
            <tbody>
        <c:forEach var="g" items="${selg}">
        <thead ><tr style="border: 0px;color: white;">
                <td colspan="3" style="border: 0px;font-weight: bold;padding-left: 185px;">${g.getNomGrp()}</td>
                <td colspan="3"style="border: 0px;font-weight: bold;padding-left: 20px;text-align: center">${g.getAbreviation()}</td>
            <td colspan="3" style="border: 0px;font-weight: bold;padding-left: 250px;">${g.getNiveauName()}</td>
        </tr></thead>
        <tr style="color:#2A3F54 "><td>Libelle</td><td>VolumeC</td><td>VolumeTD</td><td>VolumeTP</td><td>Coeffecient</td><td>Credit</td><td style="padding-left: 35px;">Notes</td><td style="padding-left: 80px;">Compostage</td></tr>
            <c:forEach var="m" items="${g.getAllStudents(ens,g.getCodeGrp())}">
                <tr><td style="line-height: 35px;">${m.getLibelle()}</td>
            <td style="line-height: 35px;padding-left: 25px;">${m.getVolumeC()}</td>
            <td style="line-height: 35px;padding-left: 25px;">${m.getVolumeTd()}</td>
            <td style="line-height: 35px;padding-left: 25px;">${m.getVolumeTp()}</td>
            <td style="line-height: 35px;padding-left: 25px;">${m.getCoeffecient()}</td>
            <td style="line-height: 35px;padding-left: 25px;">${m.getCredit()}</td>
            <td style="line-height: 35px;padding-left: 25px;"><a href="NoteController?doing=Display&id=${m.getCodeMat()}&ens=${ens}&nomPrenom=${nomP}"><button type="button" class="btn btn-warning">Cliquez Ici</button></a></td>
            <c:if test="${m.validite (m.getCodeMat())==0}">
                <td style="color: red;font-weight: bold;line-height: 35px;">Vous devez validez les notes d'abord</td>
            </c:if>
           <c:if test="${m.validite (m.getCodeMat())==1}">     
           <c:if test="${m.verifierCompostage()==0}">
            <td></td>
             </c:if>
            <c:if test="${m.verifierCompostage()!=0}">
                <td><a href="CompostageController?doing=compostage&id=${m.getCodeMat()}"><button type="button"  style="margin-left: 35px;width: 200px;"class="btn btn-danger">Cliquez-ici</button></a></td>
             </c:if>
              </c:if>  
             <c:if test="${m.validite (m.getCodeMat())==2}">
                 <td style="font-weight: bold;color: red;line-height: 35px;padding-left: 70px;">Notes déja postés</td>
             </c:if>
        </tr>
            </c:forEach>
        </c:forEach>
        </tbody>
        </table>
 </div>
    </div>
          </div>
    </div>
        <%@include file="FooterEnseignant.html"%>
