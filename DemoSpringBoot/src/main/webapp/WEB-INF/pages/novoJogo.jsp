<%-- 
    Document   : novoJogo
    Created on : 24/02/2016, 11:10:52
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
            <h2 class="dj-titulo__left">Novo jogo</h2>
            <br>
            <div>
                <c:if test="${result != null}">
                            <%@include file="modalResposta.jsp" %>
                            <button data-toggle="modal" data-target="#modal" class="invisible" id="showModal"></button>
                </c:if>
            </div>
            <form action="/novo/Jogo" method="post" class="form-group">
                <div class="dj-form__input">
                    <label for="nome">Nome:</label>
                    <input class="form-control" name="nome" id="nome" autofocus="" required="">
                </div><br>
                <div class="dj-form__input">
                    <label for="genero">Gênero:</label>
                    <input class="form-control" name="genero" id="genero" required="">
                </div>
                <div class="text-right dj-button__submit">
                    <input type="submit" class="btn btn-primary btn-lg" value="Cadastrar">
                </div>
            </form>
            <br>
            <h4><a href="/home">Voltar ao início</a></h4>
        </div>
    </body>
</html>
