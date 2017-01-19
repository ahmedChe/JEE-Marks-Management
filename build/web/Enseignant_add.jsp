<%-- 
    Document   : Enseignant_add
    Created on : 14 mai 2016, 01:22:27
    Author     : !l-PazZ0
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="EnteteAdmin.html"%>
    <script language="JavaScript">
		/***********************************************
		 * Verification du contenu des zones des saisies
		 ***********************************************/

		function formCheck(formobj)
                {
			// On met ici les noms des champs à contrôler
			var fieldRequired = Array("cin", "mf","nom","prenom","adr","tel","login","pass");
			// Description des zones de texte
			var fieldDescription = Array("CIN", "Matricule Fiscale","Nom","Prenom","L'adresse","Telephone","Login","Le mot de passe");
			// Message de boite de dialogue
			var alertMsg = "Veuillez completer ces zones:\n";

			var l_Msg = alertMsg.length;

			for (var i = 0; i < fieldRequired.length; i++){
				var obj = formobj.elements[fieldRequired[i]];
				if (obj)
                                {
                                        if (obj.value == "" || obj.value == null)
                                        {
                                            alertMsg += " - " + fieldDescription[i] + "\n";
					}
					if (obj.type == undefined)
                                        {
						var blnchecked = false;
						for (var j = 0; j < obj.length; j++){
							if (obj[j].checked){
								blnchecked = true;
							}
						}
						if (!blnchecked){
							alertMsg += " - " + fieldDescription[i] + "\n";
						}
					}
				}
			}

			if (alertMsg.length == l_Msg){
				return true;
			}else{
				alert(alertMsg);
				return false;
			}
		}
	</script>
    <div class="right_col" role="main">
        
        <div class="row" style="margin-top: 50px;">
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <c:set var="code" value="${sessionScope['code']}"/>
            <div class="col-md-12">
                <a href="EnseignantController?doing=display"><input type="button" value="<< Retour a la liste des enseignants" class="btn btn-primary" style="height:40px;margin-top: 30px;"></a>
            <div class="panel panel-default" style="font-weight: bold;background-color: #b5c7da">
                    <div class="panel-heading" style="background-color: #2A3F54;color:white">Ajout d'un enseignant</div>
                    <div class="panel-body">
           <form style="margin-left: 360px;" role="form" autocomplete="false" method="POST" action="EnseignantController?doing=add" onsubmit="return formCheck(this);">
           <div class="form-group" style="margin-top:25px;">
               <label for="cin">CIN</label> <input type="text" name="cin" id="cin" required pattern="[0-9]{8}">
               </div>
           <div class="form-group">
               <label for="matricule">Matricule Fiscale</label><input type="text" required pattern="[0-9]{8}" name="mf" id="mf" style="margin-left:5px;">
           </div>
           <div class="form-group">
               <label for="nom">Nom</label> <input type="text" name="nom" id="nom" required pattern="[a-zA-Z ]+" >
           </div>
           <div class="form-group">
               <label for="prenom">Prenom</label><input type="text" required pattern="[a-zA-Z ]+" name="prenom" id="prenom" style="margin-left:5px;">
           </div>
           <div class="form-group">
               <label for="adresse">Adresse</label> <input type="text" required pattern="[a-zA-Z 0-9]+[,\d{1}]*"  name="adr" id="adr">
           </div>
           <div class="form-group">
               <label for="tel">Tel</label> <input type="text" name="tel" required pattern="[0-9]{8}" id="tel">
           </div>
           <div class="form-group">
               <label for="login">Login</label> <input readonly value="${code+1}" type="text" name="login" id="login" >
           </div>
           <div class="form-group">
               <label for="password">Password</label> <input type="password" required pattern=".{8,}" required title="8 characters minimum" name="pass" id="pass" >
           </div>
           <div class="form-group" style="margin-top:20px;">
           <input type="submit" value="Add" class="btn btn-primary" style="height:40px;"> <input class="btn btn-primary" style="height:40px;" type="reset" value="Annuler">
           </div>
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
            width: 230px;
            height: 30px;
        }

    </style>

    <%@include file="Footer.html"%>