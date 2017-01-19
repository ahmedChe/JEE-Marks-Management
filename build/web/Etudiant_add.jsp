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
                <c:set var="grp" value="${sessionScope['groupes']}"/>
                <c:set var="inscr" value="${sessionScope['numinscri']}"/>
                <c:set var="login" value="${sessionScope['login']}"/>
                <div class="panel panel-default" style="margin-top: 30px;font-weight: bold;background-color: #b5c7da">
                    <div class="panel-heading" style="background-color: #2A3F54;color:white">Inscription</div>
                    <div class="panel-body">
                        <form style="margin-left: 360px;" role="form" method="POST" action="EtudiantController?doing=add">
                            <div class="form-group" style="margin-top:25px;">
                                <label for="cin">CIN </label><input required pattern="[0-9]{8}" type="text" name="cin">
                            </div>
                            <div class="form-group">
                                <label for="numinscrip">Numero Inscription</label><input type="text" name="ni" readonly value="${inscr+1}">
                            </div>
                            <div class="form-group">
                                <label for="nom">Nom</label><input required pattern="[a-zA-Z ]+" type="text" name="nom">
                            </div>
                            <div class="form-group">
                                <label for="prenom">Prenom</label><input required pattern="[a-zA-Z ]+" type="text" name="prenom">
                            </div>
                            <div class="form-group">
                                <label for="groupe">Groupe</label><select name='grp'>             
                                    <option selected value="aucun">Select Group</option>
                                    <c:forEach var="g" items="${grp}">
                                        <option value="${g.getCodeGrp()}">${g.getNiveau()} Année : ${g.getNomGrp()}</option>     
                                    </c:forEach>
                                </select></div>
                            <div class="form-group">
                                <label for="adresse">Adresse</label><input required pattern="[a-zA-Z 0-9]+[,\d{1}]*" type="text" name="adr">
                            </div>
                            <div class="form-group">
                                <label for="tel">Tel</label><input required pattern="[0-9]{8}" type="text" name="tel">
                            </div>
                            <div class="form-group">
                                <label for="login">Login</label><input readonly value="${login+1}" type="text" name="login">
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label><input required pattern=".{8,}" type="password" name="pass">
                            </div>
                            <div class="form-group" style="margin-top:20px;" >
                                <input type="submit" value="Ajouter" class="btn btn-primary" style="height:40px;"><input class="btn btn-primary" type="reset" value="Annuler" style="height:40px;">
                            
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
