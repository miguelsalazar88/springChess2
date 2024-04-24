document.addEventListener('DOMContentLoaded', function() {
    // Capturar el nombre de usuario de la URL
    function getParameterByName(name) {
        const urlParams = new URLSearchParams(window.location.search);
        return urlParams.get(name);
    }

    // Obtener el nombre de usuario de la URL
    const username = getParameterByName('username');

    // Verificar si se capturó el nombre de usuario correctamente
    if (username) {
        // Obtener el elemento h1 para mostrar el saludo
        const greetingElement = document.getElementById('greeting');

        // Mostrar el saludo con el nombre de usuario
        greetingElement.textContent = "¡Hello, " + username + "!";
    } else {
        console.log("No se encontró el nombre de usuario en la URL");
        // Manejar el caso en el que no se encuentre el nombre de usuario en la URL
    }
});

$(document).ready(function() {
    // Cuando el documento esté listo, hacemos la petición AJAX
    $.ajax({
        url: "/board/all",
        type: "GET",
        success: function(data) {
            // La función que se ejecutará cuando la petición sea exitosa
            console.log("Petición exitosa");
            console.log("Datos recibidos:", data);

            // Construimos la tabla dinámicamente
            const table = $("<table>").appendTo("body"); // Creamos la tabla y la agregamos al body

            // Añadimos la fila de encabezado
            const headerRow = $("<tr>").appendTo(table);
            $("<th>").text("Saved Games").appendTo(headerRow); // Creamos la celda del encabezado

            // Iteramos sobre los datos y agregamos las celdas de los juegos
            data.forEach(function(item) {
                const row = $("<tr>").appendTo(table); // Creamos una nueva fila
                const link = $("<a>").attr("href", "chess_board.html?id=" + item.id).text("Game " + item.id); // Creamos el enlace con el texto del juego
                $("<td>").append(link).appendTo(row); // Agregamos el enlace a la celda y luego la celda a la fila
            });
        },
        error: function(xhr, status, error) {
            // La función que se ejecutará si hay un error en la petición
            console.error("Error en la petición:", status, error);
            // Aquí puedes manejar el error de alguna manera
        }
    });
});


