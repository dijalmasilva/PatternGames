<%-- 
    Document   : alugar
    Created on : 23/02/2016, 22:13:37
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
                    <h4>Ainda não há jogos disponíveis para locação. Clique <a href="/home/novoJogo">aqui</a> para
                        cadastrar!</h4>
                    </c:when>
                    <c:otherwise>
                    <h2 class="dj-titulo__left">Alugar jogo</h2>
                    <br>
                    <c:choose>

                        <c:when test="${clientes == null}">

                            <h4>Ainda não há clientes cadastrados. Clique <a href="/home/novoCliente">aqui</a> para
                                cadastrar!</h4>
                            <br>
                        </c:when>
                        <c:otherwise>
                            <c:if test="${result != null}">
                                <%@include file="modalResposta.jsp" %>
                                <button data-toggle="modal" data-target="#modal" class="invisible" id="showModal"></button>
                            </c:if>
                            <div class="form-group dj-form__input">
                                <label for="buscar">Buscar cliente:</label>
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
                                        <c:forEach items="${clientes}" var="cliente">
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
                    <form action="/novo/Aluguel" method="post" class="invisible">
                        <input type="text" name="cpf_cliente" id="cpf_cliente" value="" required="">
                        <input type="number" name="id_jogo" id="id_jogo" value="" required="">
                        <input type="submit" id="submeterAluguel">
                    </form>
                    <h3>Informações complementares</h4>
                        <c:choose>
                            <c:when test="${dia == 'ESPECIAL'}">
                                <h4>Valor a ser pago: 5 R$ </h4>
                                <h4>Duração de aluguel: 2 dias </h4>
                            </c:when>
                            <c:otherwise>
                                <h4>Valor a ser pago: 3 R$ </h4>
                                <h4>Duração de aluguel: 1 dia </h4>
                            </c:otherwise>

                        </c:choose>
                        <h4>Data de devolução: ${dataDevolucaoFormatada}</h4>
                        <br>
                        <div class="text-right dj-button__submit">
                            <button class="btn btn-primary btn-lg" onclick="submeterAluguel()" <c:if test="${clientes == null}">disabled=""</c:if>>Alugar</button><br><br>
                            </div>
                    </c:otherwise>
                </c:choose>
                <br>
                <h4><a href="/home">Voltar ao início</a></h4>
        </div>
    </body>

</html>
