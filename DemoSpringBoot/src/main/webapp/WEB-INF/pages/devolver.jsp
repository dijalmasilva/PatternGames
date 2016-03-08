<%-- 
    Document   : devolver
    Created on : 23/02/2016, 23:26:47
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
            <c:choose>
                <c:when test="${games == null}">
                    <div class="dj-titulo__left">
                        <h2>Atenção!</h2>
                    </div>
                    <br>
                    <h4>Não há jogos para serem desenvolvidos!</h4>
                    </c:when>
                    <c:otherwise>
                    <h2 class="dj-titulo__left">Devolução</h2>
                    <br>
                    <div>
                        <c:if test="${result != null}">
                            <%@include file="modalDevolucao.jsp" %>
                            <button data-toggle="modal" data-target="#modal" class="invisible" id="showModal"></button>
                        </c:if>
                    </div>
                    <div class="form-group dj-form__input">
                        <label for="buscar">Buscar jogo:</label>
                        <input class="form-control" id="searchGame" name="buscar" autofocus="">
                    </div>
                    <div class="text-left dj-table">
                        <h3>Jogos</h3>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nome</th>
                                    <th>Gênero</th>
                                </tr>
                            </thead>
                            <tbody id="gbody">
                                <c:forEach items="${games}" var="game">
                                    <tr onclick="setarGame(${game.id}, this)">
                                        <td>${game.id}</td>
                                        <td>${game.nome}</td>
                                        <td>${game.genero}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <br>
                    <form action="/home/devolvido" method="post" class="invisible">
                        <input type="number" name="id_jogo" id="id_jogo" value="" required="">
                        <input type="submit" id="devolver">
                    </form>
                    <div class="text-right dj-button__submit">
                        <button class="btn btn-primary btn-lg" onclick="devolver()">Devolver</button><br><br>
                        </div>
                </c:otherwise>
            </c:choose>
            <br>
            <h4><a href="/home">Voltar ao início</a></h4>
        </div>
    </body>
</html>
