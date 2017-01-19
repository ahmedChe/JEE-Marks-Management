<%-- 
    Document   : Enseignants_display
    Created on : 14 mai 2016, 01:07:43
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
			// On met ici les noms des champs à contrôler
			var fieldRequired = Array("notetp", "notepres","noteds");
			// Description des zones de texte
			var fieldDescription = Array("Note de TP", "Note de Présence","Note du DS");
			// Message de boite de dialogue
			var alertMsg = "Ces valeurs doivent être de type reél:\n";

			var l_Msg = alertMsg.length;

			for (var i = 0; i < fieldRequired.length; i++)
                        {				
                                var fields = document.getElementsByName(fieldRequired[i]);
                                for(var j = 0; j < fields.length; j++) 
                                {  
                                    if (j==0)
                                    {
                                        var msg=" - " + fieldDescription[i] +" du " +(j+1)+"ére etudiant \n"
                                    }
                                    else
                                    {
                                       var msg=" - " + fieldDescription[i] +" du " +(j+1)+"éme etudiant \n" 
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
        <c:set var="nt" value="${sessionScope['notes']}"/>
        <c:set var="note" value="${nt[0].getValidite()}"/>
        <div class="panel panel-default" style="font-weight: bold;background-color: #b5c7da">
                    <div class="panel-heading" style="background-color: #2A3F54;color:white">Attribution des notes</div>
                    <div class="panel-body">
        <form method="POST" action="NoteController?doing=update" onsubmit="return formCheck();">            
                <c:if test="${note==0}">
                    <table class="table">
             <thead>
             <th colspan="5" style="color:#2A3F54;font-size: xx-large;font-weight: bold;text-align: center">Session ${nt[0].getSessionName ()}</th>
                    <tr><td>Etudiant</td><td style="padding-left:50px;">Note TP</td><td style="padding-left:20px;">Note Presidentielle</td><td style="padding-left:50px;">Note DS</td></tr>
                   </thead>
                   <tbody>
                    <c:forEach var="n" items="${nt}">
                        <tr><td style="color:black">${n.getEtudiantName ()}</td>                 
                            <td><input id="tp"style="padding-left: 15px;"type="text" value="${n.getNoteTp()}" name="notetp"></td>
                            <td><input id="presence" style="padding-left: 15px;" type="text" value="${n.getNotePresentielle()}" name="notepres"></td>
                            <td><input id="ds" style="padding-left: 15px;" type="text" value="${n.getNoteDs()}" name="noteds"></td>  </tr>                  
                                           
                </c:forEach>
                         </tbody>
        </table>
                <input  type="submit" value="Valider les notes" class="btn btn-primary" style="height:40px;margin-left:500px;">
            </c:if>
            <c:if test="${note==1}">
                <table class="table">
             <thead>
             <th colspan="5" style="color:#2A3F54;font-size: xx-large;font-weight: bold;text-align: center">Session ${nt[0].getSessionName ()}</th>
                 <tr><td>Etudiant</td><td>Note TP</td><td>Note Presidentielle</td><td>Note DS</td></tr>                
               </thead>
                   <tbody>
                 <c:forEach var="n" items="${nt}">  
                     <tr style="color:black"><td>${n.getEtudiantName()}</td> 
                   <td style="padding-left: 15px;">${n.getNoteTp()}</td>
                    <td style="padding-left: 55px;">${n.getNotePresentielle()}</td>
                    <td style="padding-left: 15px;">${n.getNoteDs()}</td>                    
                    </tr>             
            </c:forEach>
                    </tbody>
        </table>
        </c:if>
        <c:if test="${note==2}">
                 <table class="table">
             <thead>
             <th colspan="5" style="color:#2A3F54;font-size: xx-large;font-weight: bold;text-align: center">Session ${nt[0].getSessionName ()}</th>
                 <tr><td>Etudiant</td><td>Note TP</td><td>Note Presidentielle</td><td>Note DS</td><td>Note Examen</td></tr>                
                </thead>
                   <tbody>
                 <c:forEach var="n" items="${nt}">  
                     <tr><td>${n.getEtudiantName()}</td> 
                   <td style="padding-left: 15px;">${n.getNoteTp()}</td>
                    <td style="padding-left: 60px;">${n.getNotePresentielle()}</td>
                    <td style="padding-left: 15px;">${n.getNoteDs()}</td>
                    <td style="padding-left: 35px;">${n.getNoteExamen()}</td> 
                    </tr>             
            </c:forEach>
                     </tbody>
        </table>
        </c:if>     
                <c:set var="string" value="${fn:split(nomP, ' ')}" />
                <c:set var="nom" value="${fn:join(string, '-')}" />  
                <a href="GroupeController?doing=EnsDisplay&id=${ens}&nomPrenom=${nom}"><input type="button" class="btn btn-primary" style="height:40px;" value="Retour aux matieres"></a>  
    </form>
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