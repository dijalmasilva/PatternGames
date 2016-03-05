<%-- 
    Document   : index
    Created on : 23/02/2016, 19:47:54
    Author     : Dijalma Silva <dijalmacz@gmail.com>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="head.jsp" %>
    <body>
        <%@include file="header.jsp" %>
        <div class="dj-modal__section">

            <div class="dj-titulo__left">
                <h2>Funcionalidades do sistema</h2>
            </div>
            <div>
                <div class="modal-header">
                    <h3>Jogos</h3>
                </div>
                <br>
                <ul>
                    <li>
                        <img src="/assets/icons/rent.png" class="dj-image__funcionalidade">
                        <a href="/home/alugar">Alugar</a>
                    </li>
                    <li>
                        <img src="/assets/icons/return.png" class="dj-image__funcionalidade">
                        <a href="/home/devolver">Devolver</a>
                    </li>
                    <li>
                        <img src="/assets/icons/observer.png" class="dj-image__funcionalidade">
                        <a href="/home/observar">Observar</a>
                    </li>
                    <li>
                        <img src="/assets/icons/newGame.png" class="dj-image__funcionalidade">
                        <a href="/home/novoJogo">Novo jogo</a>
                    </li>
                </ul>
            </div>
            <br><br>
            <div>
                <h3>Clientes</h3>
                <br>
                <ul>
                    <li>
                        <img src="/assets/icons/new-user.png" class="dj-image__funcionalidade">
                        <a href="/home/novoCliente">Novo Cliente</a>
                    </li>
                </ul>
            </div>
        </div>
    </body>
</html>
