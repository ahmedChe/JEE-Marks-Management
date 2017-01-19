<%-- 
    Document   : Matieres_add
    Created on : 12 mai 2016, 11:11:00
    Author     : !l-PazZ0
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="EnteteAdmin.html"%>
    <div class="right_col" role="main">

        <div class="row" style="margin-top: 50px;">
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <div class="col-md-12">
                <input type="button" value="<< Retour aux matieres" onclick="history.go(-1)" class="btn btn-primary" style="height:40px;margin-top: 30px;">
        <c:set var="grp" value="${sessionScope['groupe']}"/>
        <c:set var="ens" value="${sessionScope['enseignants']}"/>
        <div class="panel panel-default" style="font-weight: bold;background-color: #b5c7da">
                    <div class="panel-heading" style="background-color: #2A3F54;color:white">Ajouter un etudiant au groupe</div>
                    <div class="panel-body">
        <form style="margin-left: 360px;" role="form" method="POST" action="MatiereController?doing=add&id=${grp.getCodeGrp()}">
            <div class="form-group" style="margin-top:25px;">
                <label for="nomMat">Nom de Matiere</label><input type="text" required pattern="[a-zA-Z ]+" name="lib">
            </div>
            <div class="form-group">
                <label for="volumeC">Volume Controle</label><input type="text" name="vc" required pattern="[0-9]+">
            </div>
            <div class="form-group">
                <label for="volumeTD">Volume TD</label><input type="text" name="vtd" required pattern="[0-9]+">
            </div>
            <div class="form-group">
                <label for="volumeTP">Volume TP</label><input type="text" name="vtp" required pattern="[0-9]+">
            </div>
            <div class="form-group">
                <label for="coefficient">Coeffecient</label><input type="text" name="coef" required pattern="[0-9]+[,\d{1}]*">
            </div>
            <div class="form-group">
                <label for="credit">Credit</label><input type="text" name="crd" required pattern="[0-9]+">
            </div>
            <div class="form-group">
                <label for="groupe">Groupe</label><input type="text" name="grp" value="${grp.getNomGrp()}" readonly>
            </div>
           <div class="form-group">
               <label for="enseignant">Enseignant</label><select name='ens'>
               </div><option selected value="aucun" required >Select Enseignant</option>
           <c:forEach var="e" items="${ens}">
               <option value="${e.getCin()}">${e.getNom()} ${e.getPrenom()}</option>     
           </c:forEach></select>
           </div>
           <div class="form-group" style="margin-top:20px;" >
               <input type="submit" class="btn btn-primary" style="height:40px;" value="Ajouter"><input type="reset" value="Annuler" class="btn btn-primary" style="height:40px;">
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
            width: 225px;
            height: 30px;
        }

    </style>

    <%@include file="Footer.html"%>
