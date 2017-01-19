<%-- 
    Document   : NiveauGroupes
    Created on : 13 mai 2016, 03:08:42
    Author     : !l-PazZ0
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="EnteteAdmin.html"%>
    <div class="right_col" role="main">

        <div class="row" style="margin-top: 50px;">
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <c:set var="grp" value="${sessionScope['selectionGroupes']}"/>
        <c:set var="niveauGroupe" scope="session" value="${grp[0].getNiveau()}"/>
        <div class="panel panel-default" style="margin-top: 50px;font-weight: bold;background-color: #b5c7da">
            <div class="panel-heading" style="background-color: #2A3F54;color:white">Liste des groupes du niveau ${grp[0].getNiveau()}</div>
            <div class="panel-body">
         <table class="table">
             <tr style="color: white"><td>Nom du groupe</td><td>Abreviation</td><td style="padding-left: 25px;">Niveau</td></tr>
        </thead>
            <tbody>
        <c:forEach var="g" items="${grp}">
        <tr><td style="line-height:40px;padding-left: 35px;">${g.getNomGrp()}</td>
            <td style="line-height:40px;padding-left: 35px;">${g.getAbreviation()}</td>
            <td style="line-height:40px;">${g.getNiveauName()}</td>
            <td><a href="GroupeController?doing=delete&id=${g.getCodeGrp()}" onclick="return confirm('Are you sure ?!')"><button type="button" class="btn btn-danger">Delete</button></a></td>
            <td><a href="GroupeController?doing=edit&niv=1&id=${g.getCodeGrp()}"><button type="button" class="btn btn-warning">Edit</button></a></td>
            <td><a href="MatiereController?doing=display&id=${g.getCodeGrp()}"><button type="button" class="btn btn-info">Liste des Matieres</button></a></td>
            <td><a href="EtudiantController?doing=display&id=${g.getCodeGrp()}"><button type="button" class="btn btn-info">Liste des Etudiants</button></a></td>

        </tr>
        </c:forEach>      
        </tbody>
        </table>
                </div>
        </div>
        <a href="GroupeController?doing=chargerCombo&niveau=${niveauGroupe}"><button type="button" class="btn btn-primary">Ajouter Nouveau Groupe</button></a>
        <a href="NiveauxController?doing=display"><button type="button" class="btn btn-primary">Retour au Niveaux</button></a>
     </div>
        </div>
        <%@include file="Footer.html"%>
