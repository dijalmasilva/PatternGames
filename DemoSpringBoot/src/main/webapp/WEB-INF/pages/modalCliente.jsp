<%-- 
    Document   : modalCliente
    Created on : 24/02/2016, 09:46:53
    Author     : Dijalma Silva <dijalmacz@gmail.com>
--%>

<!-- Modal -->
<div id="modalCliente" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h2 class="modal-title">Novo Cliente</h2>
            </div>
            <div class="modal-body">
                <form class="form-group" method="post" action="/novo/ClienteFast" id="formWithCPF">
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
                    <br><br>
                    <div class="text-right dj-button__submit">
                        <input type="submit" class="btn btn-primary btn-lg" value="Cadastrar"/>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>