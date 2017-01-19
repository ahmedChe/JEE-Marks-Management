<%-- 
    Document   : Niveaux_display
    Created on : 12 mai 2016, 17:31:58
    Author     : !l-PazZ0
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="EnteteAdmin.html"%>
     <div class="right_col" role="main">

         <div class="row" style="margin-top: 50px;">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        
         <c:set var="niv" value="${sessionScope['niveaux']}"/>
         <div class="panel panel-default" style="margin-top: 50px;font-weight: bold;background-color: #b5c7da">
          <div class="panel-heading" style="background-color: #2A3F54;color:white">Niveaux</div>
            <div class="panel-body">
         <table class="table">
            <thead>
                <tr style="color: white">
                    <th>Nom Du Niveau</th>
                    <th>Nombre de groupes</th>
                    <th></th>
		</tr>
            </thead>
            <tbody>
        <c:forEach var="n" items="${niv}">
            <tr>
                <td style="line-height:40px;">${n.getNomNiv()}</td>
                <td style="padding-left: 75px;line-height:40px;">${n.getNombreGrp()}</td>
                <td><a href="NiveauxController?doing=delete&id=${n.getCodeNiv()}" onclick="return confirm('Are you sure ?!')"><button type="button" class="btn btn-danger">Delete</button></a></td>
                <td><a href="NiveauxController?doing=edit&id=${n.getCodeNiv()}"><button type="button" class="btn btn-warning">Edit</button></a></td>
                <td><a href="GroupeController?doing=selection&id=${n.getCodeNiv()}"><button type="button" class="btn btn-info">Display Groups</button></a></td>
            </tr>
        </c:forEach>
            </tbody>
        </table>
                </div>
</div>

         <a href="Niveaux_add.jsp"><button type="button" class="btn btn-primary">Ajouter Nouveau Niveau</button></a>
       </div>
        </div>
        <%@include file="Footer.html"%>
