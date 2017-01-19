<%-- 
    Document   : Enseignant_add
    Created on : 14 mai 2016, 01:22:27
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
                <input type="button" value="<< Retour aux groupes" onclick="history.go(-1)" class="btn btn-primary" style="height:40px;margin-top: 30px;">
            <c:set var="grp" value="${sessionScope['groupe']}"/>
            <c:set var="inscr" value="${sessionScope['numinscri']}"/>
                <c:set var="login" value="${sessionScope['login']}"/>

           <div class="panel panel-default" style="font-weight: bold;background-color: #b5c7da">
                    <div class="panel-heading" style="background-color: #2A3F54;color:white">Ajouter un etudiant au groupe</div>
                    <div class="panel-body">
            <form style="margin-left: 360px;" role="form" method="POST" action="EtudiantController?doing=add&redirect=true">
                <div class="form-group" style="margin-top:25px;">
                    <label for="cin">CIN</label> <input type="text" name="cin" required pattern="[0-9]{8}">
                </div>
                <div class="form-group">
                    <label for="numinscri">Numero Inscription</label><input type="text" name="ni" readonly value="${inscr+1}">
                </div>
                <div class="form-group">
                    <label for="nom">Nom</label><input type="text" required pattern="[a-zA-Z ]+" name="nom">
                </div>
                <div class="form-group">
                    <label for="prenom">Prenom</label><input type="text" required pattern="[a-zA-Z ]+" name="prenom">
                </div>
                <div class="form-group">
                    <label for="groupe">Groupe</label><input type="text" name="grp" value="${grp}" readonly>
                </div>
                <div class="form-group">
                    <label for="adresse">Adresse</label><input required pattern="[a-zA-Z 0-9]+[,\d{1}]*" type="text" name="adr">
                </div>
                <div class="form-group">
                    <label for="tel">Tel</label><input type="text" required pattern="[0-9]{8}" name="tel">
                </div>
                <div class="form-group">
                    <label for="login">Login</label><input readonly value="${login+1}" type="text" name="login">
                </div>
                <div class="form-group">
                    <label for="password">Password</label><input type="password" required pattern=".{8,}" name="pass">
                </div>
                <div class="form-group" style="margin-top:20px;" >
                    <input type="submit" class="btn btn-primary" style="height:40px;" value="Ajouter"><input type="reset" class="btn btn-primary" style="height:40px;" value="Annuler"> 
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
