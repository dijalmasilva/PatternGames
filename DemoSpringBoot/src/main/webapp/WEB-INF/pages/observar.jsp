<%-- 
    Document   : observar
    Created on : 24/02/2016, 10:50:45
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
                <c:when test="${Games == null}">
                    <div class="dj-titulo__left">
                        <h2>Atenção!</h2>
                    </div>
                    <br>
                    <h4>Ainda não há jogos cadastrados. Clique <a href="/novoJogo">aqui</a> para
                        cadastrar!</h4>
                    </c:when>
                    <c:otherwise>
                    <h2 class="dj-titulo__left">Observar jogo</h2>
                    <br>
                    <div>
                        <c:if test="${result != null}">
                            <%@include file="modalResposta.jsp" %>
                            <button data-toggle="modal" data-target="#modal" class="invisible" id="showModal"></button>
                        </c:if>
                    </div>
                    <c:choose>
                        <c:when test="${Clientes == null}">
                            <h4>Ainda não há clientes cadastrados. Clique <a href="/novoCliente">aqui</a> para
                                cadastrar!</h4>
                            <br>
                        </c:when>
                        <c:otherwise>
                            <div class="form-group dj-form__input">
                                <label for="buscar">Buscar clinte:</label>
                                <input class="form-control" id="searchClient" name="buscar" autofocus="">
                                <div class="text-right">
                                    <button data-toggle="modal" data-target="#modalCliente" class="btn btn-default btn-sm">Novo Cliente</button>
                                </div>
                                <%@include file="modalCliente.jsp" %>
                            </div>
                            <div class="text-left dj-table">
                                <h3>Clientes</h3>
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>Nome</th>
                                            <th>Email</th>
                                            <th>CPF</th>
                                        </tr>
                                    </thead>
                                    <tbody id="cbody">
                                        <c:forEach items="${Clientes}" var="cliente">
                                            <tr onclick="setarCliente('${cliente.cpf}', this)">
                                                <td>${cliente.nome}</td>
                                                <td>${cliente.email}</td>
                                                <td>${cliente.cpf}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <br><br>
                        </c:otherwise>
                    </c:choose>
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
                                <c:forEach items="${Games}" var="game">
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
                    <form action="/novo/Observardor" method="post" class="invisible">
                        <input type="text" name="cpf_cliente" id="cpf_cliente" value="" required="">
                        <input type="number" name="id_jogo" id="id_jogo" value="" required="">
                        <input type="submit" id="observar">
                    </form>
                    <div class="text-right dj-button__submit">
                        <button class="btn btn-primary btn-lg" onclick="observar()" <c:if test="${Clientes == null}">disabled=""</c:if>>Observar</button><br><br>
                        </div>
                </c:otherwise>
            </c:choose>
            <br>
            <h4><a href="/home">Voltar ao início</a></h4>
        </div>
    </body>
</html>
