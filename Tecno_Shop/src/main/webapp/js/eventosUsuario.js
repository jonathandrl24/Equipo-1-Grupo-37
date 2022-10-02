$(document).ready(function () {
    var url = '/Tecno_Shop/CrearUsuarioServlet';
    $("#numeroId").change(function () {
        $.ajax({
            contentType: 'application/json',
            type: 'GET',
            url: '/Tecno_Shop/ConsultarUsuarioServlet?numeroIdentificacion=' + $("#numeroId").val(),
            success: function (data) {
                $("#numeroId").val(data.numeroIdentificacion);
                $("#nombre").val(data.nombre);
                $("#apellido").val(data.apellido);
                $("#email").val(data.email);
                $("#telefono").val(data.telefono);
                $("#direccion").val(data.direccion);
                $("#frmUsuario :input").prop("disabled", true);
                $("#id").val(data.id);
                $("#btnEditar").prop("disabled", false);
            },
            error: function (jqXHR, textStatus, errorThrown) {

            }
        });
    });

    $("#btnGuardar").click(function () {
        //$(".invalid-feedback").show();
        $.ajax({
            contentType: 'application/json',
            type: 'POST',
            url: url,
            data: JSON.stringify({
                'id': $("#id").val(),
                'numeroIdentificacion': $("#numeroId").val(),
                'nombre': $("#nombre").val(),
                'apellido': $("#apellido").val(),
                'email': $("#email").val(),
                'telefono': $("#telefono").val(),
                'direccion': $("#direccion").val()
            }),
            success: function (data) {
            },
            error: function (jqXHR, textStatus, errorThrown) {

            }
        });

    });
    
    $("#btnEditar").click(function () {
        $("#frmUsuario :input").prop("disabled", false);
        $("#btnEditar").prop("disabled", true);
        url = '/Tecno_Shop/ModificarUsuarioServlet';
    });


});




