/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {

    //filtro na tabela de clientes cadastrados
    $("#searchClient").keyup(function () {
        //split the current value of searchInput
        var data = this.value.split(" ");
        //create a jquery object of the rows
        var jo = $("#cbody").find("tr");
        if (this.value == "") {
            jo.show();
            return;
        }
        //hide all the rows
        jo.hide();

        //Recusively filter the jquery object to get results.
        jo.filter(function (i, v) {
            var $t = $(this);
            for (var d = 0; d < data.length; ++d) {
                if ($t.is(":contains('" + data[d] + "')")) {
                    return true;
                }
            }
            return false;
        })
                //show the rows that match.
                .show();
    }).focus(function () {
        this.value = "";
        $(this).css({
            "color": "black"
        });
        $(this).unbind('focus');
    }).css({
        "color": "#C0C0C0"
    });
    
    //Filtro na tabela de jogos disponíveis
    $("#searchGame").keyup(function () {
        //split the current value of searchInput
        var data = this.value.split(" ");
        //create a jquery object of the rows
        var jo = $("#gbody").find("tr");
        if (this.value == "") {
            jo.show();
            return;
        }
        //hide all the rows
        jo.hide();

        //Recusively filter the jquery object to get results.
        jo.filter(function (i, v) {
            var $t = $(this);
            for (var d = 0; d < data.length; ++d) {
                if ($t.is(":contains('" + data[d] + "')")) {
                    return true;
                }
            }
            return false;
        })
                //show the rows that match.
                .show();
    }).focus(function () {
        this.value = "";
        $(this).css({
            "color": "black"
        });
        $(this).unbind('focus');
    }).css({
        "color": "#C0C0C0"
    });
    
    $('tr').css({
        cursor: 'pointer'
    });
    
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

function setarCliente(cpf, tr) {
    clearSelectedRowClient();
    $('#cpf_cliente').val(cpf + "");
    $(tr).css({
        background: '#E5E5E5',
        cursor: 'default'
    });
}

function setarGame(id, tr) {
    clearSelectedRowGame();
    $('#id_jogo').val(id);
    $(tr).css({
        background: '#E5E5E5',
        cursor: 'default'
    });
}

function submeterAluguel() {
    $('#submeterAluguel').trigger("click");
}

function clearSelectedRowClient(){
    var j = $('#cbody').find('tr');
    j.css({
       background: 'white',
       cursor: 'pointer'
    });
}

function clearSelectedRowGame(){
    var j = $('#gbody').find('tr');
    j.css({
       background: 'white',
       cursor: 'pointer'
    });
}