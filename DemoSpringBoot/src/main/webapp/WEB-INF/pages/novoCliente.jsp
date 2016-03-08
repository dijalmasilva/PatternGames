<%-- 
    Document   : novoCliente
    Created on : 23/02/2016, 21:53:04
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
            <h2 class="dj-titulo__left">Novo cliente</h2>
            <br>
            <div>
                <c:if test="${result != null}">
                            <%@include file="modalResposta.jsp" %>
                            <button data-toggle="modal" data-target="#modal" class="invisible" id="showModal"></button>
                </c:if>
            </div>
            <form action="/novo/Cliente" method="post" class="form-group" id="formWithCPF">

                <div class="form-group dj-form__input">
                    <label for="nome">Nome:</label>
                    <input class="dj-button form-control" id="nome" name="nome" autofocus="" required="">
                </div>
                <br>
                <div class="form-group dj-form__input">
                    <label for="cpf">CPF:</label>
                    <input class="dj-button form-control" id="cpf" name="cpf" required="" maxlength="14"
                               pattern="\d{3}\.\d{3}\.\d{3}-\d{2}" title="Digite o CPF no formato xxx.xxx.xxx-xx">
                </div>
                <br>
                <div class="form-group dj-form__input">
                    <label for="email">Email:</label>
                    <input class="dj-button form-control" id="email" name="email" required="">
                </div>
                <br>
                <div class="text-right dj-button__submit">
                    <input type="submit" class="btn btn-primary btn-lg" value="Cadastrar"><br><br>
                </div>
            </form>
            <br>
            <h4><a href="/home">Voltar ao início</a></h4>
        </div>
    </body>
</html>
