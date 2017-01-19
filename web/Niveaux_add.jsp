<%-- 
    Document   : Niveaux_add
    Created on : 12 mai 2016, 17:41:05
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
                <div class="panel panel-default" style="margin-top: 30px;font-weight: bold;background-color: #b5c7da">
                    <div class="panel-heading" style="background-color: #2A3F54;color:white">Ajout d'un niveau</div>
                    <div class="panel-body">
        <form style="margin-left: 360px;" role="form" method="post" action="NiveauxController?doing=add">
           <div class="form-group" style="margin-top:25px;">
               <label for="niveau">Nom de Niveau</label><input type="text" required pattern="[a-zA-Z ]+" name="niv">
               </div>
           <div class="form-group" style="margin-top:20px;">
            <input class="btn btn-primary" style="height:40px;" type="submit" value="Ajouter"><input class="btn btn-primary" style="height:40px;" type="reset" value="Annuler"> <br>      
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
