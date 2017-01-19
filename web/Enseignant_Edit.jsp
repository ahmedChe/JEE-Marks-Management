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
            <div class="col-md-12">
                                <input type="button" value="<< Retour a la liste des enseignants" onclick="history.go(-1)" class="btn btn-primary" style="height:40px;margin-top: 30px;">
            <div class="panel panel-default" style="font-weight: bold;background-color: #b5c7da">
                    <div class="panel-heading" style="background-color: #2A3F54;color:white">Modifier d'un enseignant</div>
                    <div class="panel-body">
            <c:set var="ens" value="${sessionScope['enseignant']}"/>
           <form style="margin-left: 360px;" role="form" method="POST" action="EnseignantController?doing=validEdit" onsubmit="return formCheck(this);">
               <div class="form-group" style="margin-top:25px;">
                   <label for="cin">CIN</label><input type="text" name="cin" id="cin" value="${ens.getCin()}" readonly>
           </div>
           <div class="form-group">
               <label for="matricule">Matricule Fiscale</label><input type="text" id="mf" name="mf" value="${ens.getMatriculeFiscale()}" readonly>
           </div>
           <div class="form-group">
               <label for="nom">Nom</label><input type="text" id="nom" name="nom" value="${ens.getNom()}" readonly>
           </div>
           <div class="form-group">
               <label for="prenom">Prenom</label><input type="text" id="prenom" name="prenom" value="${ens.getPrenom()}" readonly>
           </div>
           <div class="form-group">
               <label for="adresse">Adresse</label><input type="text" id="adr" required pattern="[a-zA-Z 0-9]+[,\d{1}]*" name="adr" value="${ens.getAdresse()}" >
           </div>
           <div class="form-group">
               <label for="tel">Tel</label><input type="text" id="tel" name="tel" required pattern="[0-9]{8}" value="${ens.getTel()}" >
           </div>
           <div class="form-group">
               <label for="login">Login</label><input type="text" id="login" name="login" readonly value="${ens.getCodeUser()}" >
           </div>
           <div class="form-group">
               <label for="password">Password</label><input type="password" id="pass" required pattern=".{8,}" title="8 characters minimum" name="pass" value="${ens.getPassword()}">
           </div>
           <div class="form-group" style="margin-top:20px;">
                   <input type="submit" value="Sauvgarder" class="btn btn-primary" style="height:40px;"><input type="reset" value="Annuler" class="btn btn-primary" style="height:40px;">   
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