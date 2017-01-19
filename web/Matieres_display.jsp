<%-- 
    Document   : Matieres
    Created on : 12 mai 2016, 10:44:40
    Author     : !l-PazZ0
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="EnteteAdmin.html"%>
     <div class="right_col" role="main">

         <div class="row" style="margin-top: 50px;">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@page import="javax.swing.JOptionPane"%>
        <%@page import="javax.swing.JFrame"%>
        <c:set var="mat" value="${sessionScope['matieres']}"/>
         <c:set var="groupe" scope="session" value="${param['groupe']}"/>
         <c:set var="niveau" scope="session" value="${mat[0].CodeNiveau()}"/>
         <c:set var="comp" scope="session" value="${sessionScope['compostage']}"/>
        <div class="panel panel-default" style="margin-top: 50px;font-weight: bold;background-color: #b5c7da">
            <div class="panel-heading" style="background-color: #2A3F54;color:white">Liste des matieres</div>
            <div class="panel-body">
         <table class="table">
        <tr style="color: white"><td>Libelle</td><td>VolumeC</td><td>VolumeTD</td><td>VolumeTP</td><td>Coeffecient</td><td>Credit</td><td>Enseignant</td><td>Groupe</td></tr>
         </thead>
            <tbody>
        <c:forEach var="m" items="${mat}">
        <tr><td style="line-height:40px;">${m.getLibelle()}</td>
            <td style="line-height:40px;padding-left: 25px;">${m.getVolumeC()}</td>
            <td style="line-height:40px;padding-left: 25px;">${m.getVolumeTd()}</td>
            <td style="line-height:40px;padding-left: 25px;">${m.getVolumeTp()}</td>
            <td style="line-height:40px;padding-left: 25px;">${m.getCoeffecient()}</td>
            <td style="line-height:40px;padding-left: 15px;">${m.getCredit()}</td>
            <td style="line-height:40px;">${m.getEnseignantName()}</td>
            <td style="line-height:40px;">${m.getGroupeName()}</td>
            <td><a href="MatiereController?doing=delete&id=${m.getCodeMat()}&groupe=${m.getGroupe()}" onclick="return confirm('Are you sure ?!')"><button type="button" class="btn btn-danger">Delete</button></a></td>
            <td><a href="MatiereController?doing=loadMatiere&id=${m.getCodeMat()}"><button type="button" class="btn btn-warning">Edit</button></a></td>
            <c:if test="${m.verifierCompostage()==0}"><td><a href="CompostageController?doing=generer&id=${m.getCodeMat()}"><button type="button" class="btn btn-info">Compostage</button></a></td>
            </c:if>
            <c:if test="${m.verifierCompostage()!=0}"><td style="font-weight: bold;color: red;line-height: 40px;">Compostage Prêt</td></c:if>
        </tr>
        </c:forEach>
        </tbody>
        </table>
                </div>
</div>
        <c:if test="${empty groupe}">
            <c:set var="groupe" scope="session" value="${param['id']}"/>
            </c:if>
         <a href="MatiereController?doing=loadAdd&id=${groupe}"><button type="button" class="btn btn-primary">Ajouter Nouvelle Matiere</button></a>
         <a href="GroupeController?doing=selection&id=${niveau}"><button type="button" class="btn btn-primary">Retour aux groupes de ce niveau</button></a>
           </div>
        </div>
        <%@include file="Footer.html"%>
