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
            <c:choose>
                <c:when test="${clientes != null}">
                    <div class="dj-titulo__left">
                        <h2>Atenção!</h2>
                    </div>
                    <br>
                    <h4>Nenhum cliente ainda cadastrado. Por favor clique <a href="cadastrarCliente">aqui</a> para
                        cadastrar.</h4>
                </c:when>
                <c:otherwise>
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
                                <img src="../icons/rent.png" class="dj-image__funcionalidade">
                                <a href="alugar.jsp">Alugar</a>
                            </li>
                            <li>
                                <img src="../icons/return.png" class="dj-image__funcionalidade">
                                <a href="devolver.jsp">Devolver</a>
                            </li>
                            <li>
                                <img src="../icons/observer.png" class="dj-image__funcionalidade">
                                <a href="observar.jsp">Observar</a>
                            </li>
                            <li>
                                <img src="../icons/newGame.png" class="dj-image__funcionalidade">
                                <a href="novoJogo.jsp">Novo jogo</a>
                            </li>
                        </ul>
                    </div>
                    <br><br>
                    <div>
                        <h3>Clientes</h3>
                        <br>
                        <ul>
                            <li>
                                <img src="../icons/rent.png" class="dj-image__funcionalidade">
                                <a href="novoCliente.jsp">Novo Cliente</a>
                            </li>
                        </ul>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </body>
</html>
