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
        greetingElement.textContent = "¡Hola, " + username + "!";
    } else {
        console.log("No se encontró el nombre de usuario en la URL");
        // Manejar el caso en el que no se encuentre el nombre de usuario en la URL
    }
});