<%-- 
    Document   : Groupes_display
    Created on : 12 mai 2016, 20:03:02
    Author     : !l-PazZ0
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="EnteteAdmin.html"%>
     <div class="right_col" role="main">

         <div class="row" style="margin-top: 50px;">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@page import="CoucheADO.NiveauADO"%>
        <c:set var="grp" value="${sessionScope['groupes']}"/>
        <div class="panel panel-default" style="margin-top: 50px;font-weight: bold;background-color: #b5c7da">
          <div class="panel-heading" style="background-color: #2A3F54;color:white">Groupes</div>
            <div class="panel-body">
         <table class="table">
             <thead>
                 <tr style="color: white"><td>Nom du groupe</td><td>Abreviation</td><td>Niveau</td></tr>
             </thead>
            <tbody>
        <c:forEach var="g" items="${grp}">
        <tr><td style="line-height:40px;">${g.getNomGrp()}</td>
            <td style="padding-left: 25px;line-height:40px;">${g.getAbreviation()}</td>
            <td style="line-height:40px;">${g.getNiveauName()}</td>
            <td><a href="GroupeController?doing=delete&id=${g.getCodeGrp()}" onclick="return confirm('Are you sure ?!')"><button type="button" class="btn btn-danger">Delete</button></a></td>
            <td><a href="GroupeController?doing=edit&id=${g.getCodeGrp()}"><button type="button" class="btn btn-warning">Edit</button></a></td>
            <td><a href="MatiereController?doing=display&id=${g.getCodeGrp()}"><button type="button" class="btn btn-info">Liste des Matieres</button></a></td>
            <td><a href="EtudiantController?doing=display&id=${g.getCodeGrp()}"><button type="button" class="btn btn-info">Liste des Etudiants</button></a></td>
        </tr>
        </c:forEach>
         </tbody>
        </table>
                </div>
</div>
        <a href="GroupeController?doing=chargerCombo"><button type="button" class="btn btn-primary">Ajouter Nouveau Groupe</button></a>
        
    </div>
        </div>
        <%@include file="Footer.html"%>
