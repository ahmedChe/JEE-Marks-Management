<%-- 
    Document   : Etudiants_display
    Created on : 14 mai 2016, 02:24:55
    Author     : !l-PazZ0
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="EnteteAdmin.html"%>
     <div class="right_col" role="main">

         <div class="row" style="margin-top: 50px;">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <c:set var="etd" value="${sessionScope['etudiants']}"/>
        <c:set var="groupe" scope="session" value="${param['id']}"/>
        <c:if test="${empty groupe}">
            <c:set var="groupe" scope="session" value="${sessionScope['id']}"/>
            </c:if>
        <div class="panel panel-default" style="margin-top: 50px;font-weight: bold;background-color: #b5c7da">
            <div class="panel-heading" style="background-color: #2A3F54;color:white">Liste des etudiants</div>
            <div class="panel-body">
         <table class="table">
            <tr style="color: white"><td>CIN</td><td>Nom Prenom</td><td>Numero Inscription</td><td>Adresse</td><td>Tel</td><td>Login</td></tr>
         </thead>
            <tbody>
            <c:forEach var="e" items="${etd}">
        <tr><td style="line-height:40px;">${e.getCin()}</td>
            <td style="line-height:40px;">${e.getNom()} ${e.getPrenom()}</td>
            <td style="line-height:40px;padding-left: 35px;">${e.getNumInscription()}</td>
            <td style="line-height:40px;">${e.getAdresse()}</td>
            <td style="line-height:40px;">${e.getTel()}</td>
            <td style="line-height:40px;padding-left: 15px;">${e.getCodeUser()}</td>
            <td><a href="EtudiantController?doing=delete&id=${e.getCin()}&group=${groupe}" onclick="return confirm('Are you sure ?!')"><button type="button" class="btn btn-danger">Delete</button></a></td>
            <td><a href="EtudiantController?doing=loadData&id=${e.getCin()}"><button type="button" class="btn btn-warning">Edit</button></a></td></tr>
        </c:forEach>
       </tbody>
        </table>
                </div>
</div>
        <a href="EtudiantController?doing=addPersonalise&id=${groupe}"><button type="button" class="btn btn-primary">Ajouter Un Etudiant</button></a>
        <a href="GroupeController?doing=display"><button type="button" class="btn btn-primary">Retour aux groupes</button></a>
       
     </div>
        </div>
        <%@include file="Footer.html"%>
