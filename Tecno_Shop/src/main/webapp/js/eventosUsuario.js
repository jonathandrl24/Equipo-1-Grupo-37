$(document).ready(function () {
    $("#btnSave").click(function () {
        //$(".invalid-feedback").show();
        $.ajax({
            contentType: 'application/json',
            type: 'POST',
            url: '/Tecno_Shop/CrearUsuarioServlet',
            data: JSON.stringify({
                'numeroIdentificacion': $("#numeroId").val()
            }),
            success: function (data) {
                alert(data);
            },
            error: function (jqXHR, textStatus, errorThrown ) {
                
            }
        });

    });


});




