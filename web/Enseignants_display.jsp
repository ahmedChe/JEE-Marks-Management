<%-- 
    Document   : Enseignants_display
    Created on : 14 mai 2016, 01:07:43
    Author     : !l-PazZ0
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="EnteteAdmin.html"%>
     <div class="right_col" role="main">

         <div class="row" style="margin-top: 50px;">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <c:set var="ens" value="${sessionScope['enseignants']}"/>
        <div class="panel panel-default" style="margin-top: 50px;font-weight: bold;background-color: #b5c7da">
            <div class="panel-heading" style="background-color: #2A3F54;color:white">Enseignants</div>
            <div class="panel-body">
         <table class="table">
             <thead>
            <tr style="color: white"><td>CIN</td><td>Nom Prenom</td><td>Matricule_fiscale</td><td>Adresse</td><td>Tel</td><td>Login</td></tr>
        </thead>
            <tbody>
            <c:forEach var="e" items="${ens}">
        <tr><td style="line-height:40px;">${e.getCin()}</td>
            <td style="line-height:40px;">${e.getNom()} ${e.getPrenom()}</td>
            <td style="line-height:40px;padding-left: 35px;">${e.getMatriculeFiscale()}</td>
            <td style="line-height:40px;">${e.getAdresse()}</td>
            <td style="line-height:40px;">${e.getTel()}</td>
            <td style="line-height:40px;padding-left: 15px;">${e.getCodeUser()}</td>
            <td><a href="EnseignantController?doing=delete&id=${e.getCin()}" onclick="return confirm('Are you sure ?!')"><button type="button" class="btn btn-danger">Delete</button></a></td>
            <td><a href="EnseignantController?doing=edit&id=${e.getCin()}"><button type="button" class="btn btn-warning">Edit</button></a></td></tr>
        </c:forEach>
         </tbody>
        </table>
                </div>
</div>
        <a href="EnseignantController?doing=load"><button type="button" class="btn btn-primary">Ajouter Nouveau Enseignant</button></a>
    </div>
        </div>
        <%@include file="Footer.html"%>
