<%-- 
    Document   : modalCliente
    Created on : 24/02/2016, 09:46:53
    Author     : Dijalma Silva <dijalmacz@gmail.com>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Modal -->
<div id="modal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h2 class="modal-title">Notificação</h2>
            </div>
            <div class="modal-body">
                <h4>${result}</h4>
                <c:if test="${multa != null}">
                    <h4>Porém uma multa de ${multa} R$ foi acrescentada devido ao atraso na devolução!</h4>
                </c:if>
            </div>
        </div>
    </div>
</div>