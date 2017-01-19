<%-- 
    Document   : Compostages_Enseignant
    Created on : 20 mai 2016, 17:59:05
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
<script language="JavaScript">
		/***********************************************
		 * Verification du contenu des zones des saisies
		 ***********************************************/

		function formCheck()
                {
			var alertMsg = "Ces valeurs doivent être de type reél:\n";

			var l_Msg = alertMsg.length;	
                        
                                var fields = document.getElementsByName("note");
                                for(var j = 0; j < fields.length; j++) 
                                {  
                                    if (j==0)
                                    {
                                        var msg=" - Note d'examen du 1 ére etudiant \n"
                                    }
                                    else
                                    {
                                       var msg=" - Note d'examen du " +(j+1)+" éme etudiant \n" 
                                    }
                                    
                                    if (fields[j].value == "" || fields[j].value == null)
                                        {
                                            alertMsg += msg;
					}
                                        if (isNaN(fields[j].value))
                                        {
                                            alertMsg += msg;
                                        }
                                        
                                }
				

			if (alertMsg.length == l_Msg){
				return confirm('Vous êtes sûre..ces notes seront finale?!');
			}else{
				alert(alertMsg);
				return false;
			}
		}
	</script>
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
             <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
             <c:set var="ens" value="${sessionScope['enseignant']}"/>
        <c:set var="nomP" value="${sessionScope['nomPrenom']}"/>
    <div class="container body">
      <div class="main_container">
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
                                        <input type="button" value="<< Retour a la liste des etudiants" onclick="history.go(-1)" class="btn btn-primary" style="height:40px;margin-top: 30px;">
       <c:set var="comp" value="${sessionScope['compostages']}"/>   
       <div class="panel panel-default" style="font-weight: bold;background-color: #b5c7da">
            <div class="panel-heading" style="background-color: #2A3F54;color:white">Affectation de note avec compostage</div>
            <div class="panel-body">
       <form method="POST" action="CompostageController?doing=postuler" onsubmit="return formCheck();">
           <table class="table" style="margin-left: 400px;width:500px;">
             <thead>
                 <tr><td style="padding-left:40px;">ID</td><td style="padding-left:220px;">Note</td></tr>
                </thead>
            <tbody>
                <c:forEach var="c" items="${comp}">
                    <tr ><td style="color: black;padding-left:30px;">${c.getNumeroCompostage()}</td><td><input type="text" name="note" value="${c.getNote()}" style="margin-left: 180px;padding-left:15px;width:100px;"></td></tr>
                </c:forEach>
            </tbody>
        </table>
           <input class="btn btn-info" type="submit" value="Postuler" style="height:40px;margin-left: 540px;width: 100px;">
       </form>
            </div>
       </div>
    </div>
                </div>


            </div></div>
    </div>
    <style>
        .form-group label
        {
            width:140px; 
        }
        .form-group input,select
        {
            width: 225px;
            height: 30px;
        }

    </style>

    <%@include file="FooterEnseignant.html"%>