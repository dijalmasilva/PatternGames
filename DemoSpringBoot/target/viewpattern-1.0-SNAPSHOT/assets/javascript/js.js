/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {

});

function cadastrarCliente() {
    var form = new FormData();
    form.append("nome", $("#nome").val());
    form.append("cpf", $("#cpf").val());
    form.append("email", $('#email').val());

    $.ajax({
        url: '/novo/aluguel/Cliente',
        data: form,
        success: function (data) {
            $('result').text(data);
        },
        beforeSend: function () {
            //
        },
        complete: function () {
            console.log("Função terminada!");
        }
    });
}