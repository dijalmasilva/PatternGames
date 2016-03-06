/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {

});

function cadastrarCliente() {
    var formulario = document.getElementById('formCliente');
    formulario.onsubmit = function (event) {
        event.preventDefault();
        var formData = new FormData(document.getElementById('formCliente'));
        
//        $.ajax({
//            processData: false,
//            cache: false,
//            contentType: false,
//            data: formData,
//            type: 'post',
//            url: '/addCliente',
//            sucess: function (result) {
//                console.log(result);
//                $('#result').text(result);
//            },
//            done: function (result) {
//                console.log('2:' + result);
//                $('#result').text(result);
//            }
//        });
        var req = new XMLHttpRequest();
        req.open("POST", "/addCliente", false);
        req.send(formData);
        console.log(req.responseText);
    };
}
//    var nome = $("#nome").val();
//    var cpf = $("#cpf").val();
//    var email = $('#email').val();
//    formData.append("nome", nome);
//    formData.append("cpf", cpf);
//    formData.append("email", email);

function setarCliente(cpf){
    $('#cpf_cliente').val(cpf+"");
    console.log("Cpf setado: " + cpf);
}

function setarGame(id){
    $('#id_jogo').val(id);
    console.log("Id_game setado: " + id);
}

function submeterAluguel(){
    $('#submeterAluguel').trigger("click");
}