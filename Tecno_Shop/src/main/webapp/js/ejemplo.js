$(document).ready(function () {

    alert("Llego");
    $.ajax({
        contentType: 'application/json',
        type: 'GET',
        url: '/Tecno_Shop/ConsultarProductoServlet',
        data: null,
        success: function (data) {
            
            for(var i = 0; i < data.length; i++) {
                html = '<div class="card" style="width: 18rem;">' +
                        '<img src="..." class="card-img-top" alt="...">' +
                        '<div class="card-body">' +
                        '<h5 class="card-title">' + data[i].marca + ' ' + data[i].modelo + ' ' + data[i].nombre + '</h5>' +
                        '<p class="card-text">Vale: $' + data[i].precio + ' </p>' +
                        '<a href="#" class="btn btn-primary">Go somewhere</a>' +
                        '</div>' +
                        '</div>';
                $("#contenido").append(html);
            }

        },
        error: function (jqXHR, textStatus, errorThrown) {

        }
    });
});

//$(window).on("load", readyFn);








