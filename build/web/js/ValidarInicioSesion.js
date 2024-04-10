function Ingresar() {
    let ruta = "http://localhost:8080/GetAllaProyecto/api/admin/generarToken";
    let v_user = document.getElementById("txtUsuario").value;
    let v_password = document.getElementById("txtContrasena").value;
    let _datos = {
        usuario: v_user,
        contrasenia: v_password
    };
 
    const queryString = new URLSearchParams(_datos).toString();
    const requestOptions = {
        method: 'GET',
        headers: {'Content-Type': 'application/x-www-form-urlencoded'}
    };
 
    fetch(`${ruta}?${queryString}`, requestOptions)
        .then(function (response) {
            if (!response.ok) {
                throw new Error('Error en la solicitud');
            }
            return response.json();
        })
        .then(function (data) {
            console.log(data);
            // Guardar el token en localStorage
        sessionStorage.setItem("token", data.token);
            window.location.href="../Html/control.html"; 
        })
        .catch(function (error) {
            console.error('Error en la solicitud:', error);
        });
}