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
           <input type="button" value="<< Retour aux Niveaux" onclick="history.go(-1)" class="btn btn-primary" style="height:40px;margin-top: 30px;" >   
        <c:set var="niv" value="${sessionScope['niveau']}"/>
        <div class="panel panel-default" style="font-weight: bold;background-color: #b5c7da">
                    <div class="panel-heading" style="background-color: #2A3F54;color:white">Modifier un Niveau</div>
                    <div class="panel-body">
        <form style="margin-left: 360px;" role="form" method="post" action="NiveauxController?doing=validEdit">
            <input type="hidden" name="code" value="${niv.getCodeNiv()}"><br>
            <div class="form-group" style="margin-top:25px;">
                <label for="nomniveau">Nom de Niveau</label> <input type="text" name="niv" value="${niv.getNomNiv()}" required pattern="[a-zA-Z ]+">
            </div> 
                <div class="form-group">
                    <label for="nombreniveau">Nombre de groupe</label> <input type="text" name="grp" value="${niv.getNombreGrp()}" readonly>
           </div> 
                <div class="form-group" style="margin-top:20px;" >
                <input type="submit" value="Modify" class="btn btn-primary" style="height:40px;"><input type="reset" value="Annuler" class="btn btn-primary" style="height:40px;">
           
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
