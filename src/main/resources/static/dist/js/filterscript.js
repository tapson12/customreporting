$(document).ready(function () {


    $("#regions").change(function () {
        var region=$("#regions").val();

        $.ajax({
            url:"filter-province",
            type:"POST",
            headers:{
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'region':region,
            },
            success:function(reponse)
            {
                console.log(reponse);
                $("#provinces").empty();
                $("#communes").empty();
               
                reponse.forEach(element =>
                $("#provinces").append("<option value='"+element+"'>"+element+"</option>")
            );

                $("#provinces").append(" <option value='BAM' id='commune'>BAM</option>");


            },
            error:function(e)
            {


            }

        });
    })


    $("#provinces").change(function () {

        var province=$("#provinces").val();
        $.ajax({
            url:"filter-communes",
            type:"POST",
            headers:{
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'province':province,
            },
            success:function(reponse)
            {
                $("#communes").empty();

                reponse.forEach(element =>
                $("#communes").append("<option value='"+element[1]+"'>"+element[0]+"</option>")
            );


            },
            error:function(e)
            {


            }

        });
    })


    $("#produits").change(function () {

        var produits=$("#produits").val();

        $.ajax({
            url:"filter-quantite",
            type:"POST",
            headers:{
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'produits':produits,
            },
            success:function(reponse)
            {
                $("#quantite").empty();
                $("#prix").empty();
                reponse.forEach(element =>
                $("#quantite").append("<option value='"+element.quantite+"'>"+element.quantite+"</option>")



            );


            },
            error:function(e)
            {


            }

        });
    })


    $("#quantite").change(function () {

        var quantite=$("#quantite").val();
        var produits=$("#produits").val();
        $.ajax({
            url:"filter-prix",
            type:"POST",
            headers:{
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'produits':produits,
                'quantite':quantite,
            },
            success:function(reponse)
            {
               $("#prix").empty();




                reponse.forEach(element=>{
                   $("#prix").append("<div><span style='color: red'>Prix "+element.cout+"</span> <span style='color: red'>sexe "+element.sexe+"</span></div>");
                });



            },
            error:function(e)
            {


            }

        });
    })


    $("#sexe").change(function () {

        var quantite=$("#quantite").val();
        var produits=$("#produits").val();
        var sexe=$("#sexe").val();
        $.ajax({
            url:"filter-sexe",
            type:"POST",
            headers:{
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'produits':produits,
                'quantite':quantite,
                'sexe':sexe,
            },
            success:function(reponse)
            {
                $("#prix").empty();




                reponse.forEach(element=>{
                    $("#prix").append("<div><span style='color: red'>Prix "+element.cout+"</span> <span style='color: red'>sexe "+element.sexe+"</span></div>");
            });



            },
            error:function(e)
            {


            }

        });
    })


});




function genererBon() {


    var regions = $("#regions").val();
    var provinces = $("#provinces").val();
    var communes = $("#communes").val();
    var codeproducteur = $("#codeproducteur").val();
    var codeproduits = $("#produits").val();
    var quantite = $("#quantite").val();
    var sexe = $("#sexe").val();
    var nbbon = $("#nombrebon").val();
    var campagne = $("#annnees").val();


    if ($("#nombrebon").val()=="")
    {
        alert("saisiez le nombre de bon");
    }else
    {
        $.ajax({
            url: "genere-bon-aleatoire",
            type: "POST",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'province': provinces,
                'regions': regions,
                'commune': communes,
                'producteur': codeproducteur,
                'produit': codeproduits,
                'quantite': quantite,
                'sexe': sexe,
                'nbbon': nbbon,
                'campagne': campagne,
            },
            success: function (reponse) {
                console.log(reponse);
            },
            error: function (e) {


            }

        });

    }

}

function exportData() {

    var communes = $("#communes").val();

    var provinces = $("#provinces option:selected").text();
    var campagne = $("#annnees").val();

    alert(provinces);
    alert(communes);
    alert(campagne);

    if ( $("#communes").val()=="" ||  $("#provinces").val()=="")
    {
        alert("exportation echouer");
    }else
    {
        $.ajax({
            url: "export-bon-aleatoire",
            type: "POST",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'province': provinces,
                'commune': communes,
                'campagne': campagne,

            },
            success: function (reponse) {
                    console.log(reponse[0])
                var csv = JSON2CSV(reponse);
                var currentdate=new Date();
                var downloadLink = document.createElement("a");
                var blob = new Blob(["\ufeff", csv]);
                var url = URL.createObjectURL(blob);
                downloadLink.href = url;
                downloadLink.download = "bon_aleatoire_"+campagne+"_"+reponse[0].communes+"_"+currentdate.getUTCDay()+currentdate.getMonth()+currentdate.getFullYear()+currentdate.getHours()+currentdate.getMinutes()+currentdate.getSeconds()+".csv";

                document.body.appendChild(downloadLink);
                downloadLink.click();
                document.body.removeChild(downloadLink);

            },
            error: function (e) {


            }

        });
    }

}

function JSON2CSV(objArray) {
    var array = typeof objArray != 'object' ? JSON.parse(objArray) : objArray;
    var str = '';
    var line = '';

    if ($("#labels").is(':checked')) {
        var head = array[0];
        if ($("#quote").is(':checked')) {
            for (var index in array[0]) {
                var value = index + "";
                line += '"' + value.replace(/"/g, '""') + '",';
            }
        } else {
            for (var index in array[0]) {
                line += index + ',';
            }
        }

        line = line.slice(0, -1);
        str += line + '\r\n';
    }

    for (var i = 0; i < array.length; i++) {
        var line = '';

        if ($("#quote").is(':checked')) {
            for (var index in array[i]) {
                var value = array[i][index] + "";
                line += '"' + value.replace(/"/g, '""') + '",';
            }
        } else {
            for (var index in array[i]) {
                line += array[i][index] + ',';
            }
        }

        line = line.slice(0, -1);
        str += line + '\r\n';
    }
    return str;
}


