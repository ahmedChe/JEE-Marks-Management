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
                  <c:set var="grp" value="${sessionScope['groupes']}"/>
            <c:set var="etd" value="${sessionScope['etudiant']}"/>
                <a href="EtudiantController?doing=display&id=${etd.getGroupe()}"><input type="button" value="<< Retour a la liste des etudiants du groupe ${etd.getGroupe()}" class="btn btn-primary" style="height:40px;margin-top: 30px;"></a>
            <div class="panel panel-default" style="font-weight: bold;background-color: #b5c7da">
                    <div class="panel-heading" style="background-color: #2A3F54;color:white">Modifier d'un etudiant</div>
                    <div class="panel-body">
          
           <form style="margin-left: 360px;" role="form" method="POST" action="EtudiantController?doing=Edit">
               <div class="form-group" style="margin-top:25px;">
                   <label for="cin">CIN</label><input type="text" name="cin" value="${etd.getCin()}" readonly></div>
                     <div class="form-group">

                         <label for="numinscri">Numero Inscription</label><input type="text" name="ni" value="${etd.getNumInscription()}" readonly></div>
                         <div class="form-group">
                             <label for="nom">Nom</label><input type="text" name="nom" value="${etd.getNom()}" readonly ></div>
                      <div class="form-group">

                          <label for="prenom">Prenom</label><input type="text" name="prenom" value="${etd.getPrenom()}" readonly ></div>
                      <div class="form-group">

                          <label for="grp">Groupe</label><select name='grp'>
           <option selected value="aucun">Select Group</option>
           <c:forEach var="g" items="${grp}">
               <option value="${g.getCodeGrp()}"<c:if test="${g.getCodeGrp() == etd.getGroupe()}">selected="selected"</c:if>>${g.getNomGrp()}</option>    
           </c:forEach>
            </select></div>         
           <div class="form-group">

               <label for="adresse">Adresse</label><input type="text" name="adr" required pattern="[a-zA-Z 0-9]+[,\d{1}]*" value="${etd.getAdresse()}"></div>
                     <div class="form-group">

                         <label for="tel">Tel</label><input type="text" name="tel" required pattern="[0-9]{8}" value="${etd.getTel()}"></div>
                      <div class="form-group">

                          <label for="login">Login</label><input type="text" name="login" value="${etd.getCodeUser()}"></div>
                      <div class="form-group">

                          <label for="password">Password</label><input type="password" name="pass" required pattern=".{8,}" value="${etd.getPassword()}"></div>
           <div class="form-group" style="margin-top:20px;">
           <input type="submit" value="Sauvgarder" class="btn btn-primary" style="height:40px;"> <input type="reset" value="Annuler" class="btn btn-primary" style="height:40px;"><br>
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