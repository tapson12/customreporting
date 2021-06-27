$(document).ready(function () {



});

function sendMessageByProduit() {


    var codeClient=$("#clientid").val();


    $.get("send-sms",{typeproduit:codeClient,datedebut:datedebut,datefin:datefin},function(data){



    });
}
