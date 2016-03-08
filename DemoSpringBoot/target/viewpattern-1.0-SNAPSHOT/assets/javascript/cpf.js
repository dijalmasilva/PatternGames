/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {

    $("#cpf").keypress(function (){
       var cpf = $(this).val();
       
       if(cpf.length === 3 || cpf.length === 7)
           cpf += '.';
       else if (cpf.length === 11)
           cpf += '-';
       
       $(this).val(cpf);
    });
});