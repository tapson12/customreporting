$(document).ready(function() {

});
"C:\Users\TAPSOBA PC\Documents\devmaah\agrivoucher\src\main\resources\static\dist\js\sendmessage.js"

function sendsms() {

    var typeproduit = $("#typeproduitid").val();
    var commune_id = $("#commune_id").val();
    alert(typeproduit);

    $.ajax({
        url: "send-sms",
        type: "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'typeproduit': typeproduit,
            'commune_id': commune_id,
        },
        success: function(reponse) {
            console.log(reponse);

        },
        error: function(e) {

        }

    });

}

function sendsmsProvince() {
    var typeproduit = $("#typeproduitid").val();
    var province_id = $("#province_id").val();
    $.ajax({
        url: "send-sms-province",
        type: "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'typeproduit': typeproduit,
            'province_id': province_id,
        },
        success: function(reponse) {
            alert("Succès");
            console.log(reponse);

        },
        error: function(e) {

        }

    });

}