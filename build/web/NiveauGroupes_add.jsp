<%-- 
    Document   : NiveauGroupes_add
    Created on : 14 mai 2016, 00:22:57
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
        <c:set var="niv" value="${sessionScope['niveau']}"/>
                                <input type="button" class="btn btn-primary" style="height:40px;margin-top: 30px;" value="<< Retour aux groupes" onclick="history.go(-1)">
                        <div class="panel panel-default" style="font-weight: bold;background-color: #b5c7da">
                    <div class="panel-heading" style="background-color: #2A3F54;color:white">Inscription</div>
                    <div class="panel-body">
        <form style="margin-left: 360px;" role="form" method="POST" action="GroupeController?doing=add&niv=${niv}">
            <div class="form-group" style="margin-top:25px;">
                
                <label for="nomgrp">Nom de Groupe</label><input type="text" name="nom" required pattern="[a-zA-Z ]+">
            </div>
            <div class="form-group">
                <label for="abreviation">Abreviation</label> <input type="text" name="ab" required pattern="[a-zA-Z 0-9]+">
            </div>
            <div class="form-group">
                <label for="niveau">Niveau</label> <input style="font-weight:bold" type="text" name="Niveau" value="${niv}" readonly>  
            </div>
            <div class="form-group" style="margin-top:20px;" >
                <input type="submit" class="btn btn-primary" style="height:40px;" value="Add"><input type="reset" class="btn btn-primary" style="height:40px;"value="Annuler"> <br>
           
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
