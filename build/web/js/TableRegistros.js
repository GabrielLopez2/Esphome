  document.addEventListener("DOMContentLoaded", function() {
        // CargarTabla(); // Comentado porque llamaremos a esta función después de cargar el módulo de la tabla
    });

    function CargarTabla() {
                let ruta = "http://localhost:8080/GetAllaProyecto/api/registro/getall";
        fetch(ruta)
            .then(function(data) {
                return data.json();
            })
            .then(function(data) {
                // Obtener la tabla y su cuerpo
                const tablaRegistros = document.getElementById("tablaRegistros").getElementsByTagName('tbody')[0];

                // Limpiar la tabla
                tablaRegistros.innerHTML = "";

                // Recorrer los datos y agregar filas a la tabla
                data.forEach(function(fila) {
                    const nuevaFila = tablaRegistros.insertRow(-1);

                    const idCell = nuevaFila.insertCell(0);
                    idCell.innerHTML = fila.idRegistro;

                    const temperatureCell = nuevaFila.insertCell(1);
                    temperatureCell.innerHTML = fila.temperature;

                    const humidityCell = nuevaFila.insertCell(2);
                    humidityCell.innerHTML = fila.humidity;

                    const brightnessCell = nuevaFila.insertCell(3);
                    brightnessCell.innerHTML = fila.brightness;

                    const doorCell = nuevaFila.insertCell(4);
                    doorCell.innerHTML = fila.door;

                    const garageCell = nuevaFila.insertCell(5);
                    garageCell.innerHTML = fila.garage;

                    const led0Cell = nuevaFila.insertCell(6);
                    led0Cell.innerHTML = fila.led0;

                    const led1Cell = nuevaFila.insertCell(7);
                    led1Cell.innerHTML = fila.led1;

                    const led2Cell = nuevaFila.insertCell(8);
                    led2Cell.innerHTML = fila.led2;

                    const timestampCell = nuevaFila.insertCell(9);
                    timestampCell.innerHTML = fila.timestamp;
                });
            })
            .catch(function(error) {
                console.error("Error al cargar la tabla: " + error);
            });
    
    }

    function cargarmodulotabla() {
        fetch("boxgetall.html")
            .then(response => response.text())
            .then(function(html) {
                document.getElementById("contenedortabla").innerHTML = html;
                CargarTabla(); 
            });
    }