<%-- 
    Document   : Groupes_add
    Created on : 12 mai 2016, 23:12:12
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
        <c:set var="grp" value="${sessionScope['groupe']}"/>
                              <input type="button" class="btn btn-primary" style="height:40px;margin-top: 30px;" value="<< Retour aux groupes" onclick="history.go(-1)">
                        <div class="panel panel-default" style="font-weight: bold;background-color: #b5c7da">
                    <div class="panel-heading" style="background-color: #2A3F54;color:white">Inscription</div>
                    <div class="panel-body">
        <form style="margin-left: 360px;" method="POST" action="GroupeController?doing=validEdit&niv=${grp.getNiveau()}">
            <div class="form-group" style="margin-top:25px;">
                <label for="nomgrp">Nom de Groupe </label><input type="text" name="nom" value="${grp.getNomGrp()}" required pattern="[a-zA-Z ]+">
            </div>
            <div class="form-group">
                <label for="abreviation">Abreviation</label><input type="text" name="ab" value="${grp.getAbreviation()}" required pattern="[a-zA-Z 0-9]+">
            </div>
            <div class="form-group">
                <label for="niveau">Niveau</label><input type="text" name="Niveau" value="${grp.getNiveau()}" readonly>
            </div>
            <div class="form-group" style="margin-top:20px;" >
                <input type="submit" class="btn btn-primary" style="height:40px;" value="Modifier"> <input type="reset" class="btn btn-primary" style="height:40px;" value="Annuler">
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
