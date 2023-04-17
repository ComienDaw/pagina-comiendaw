<?php  

// Llamando a los campos
$nombre = $_GET['nombre'];
$correo = $_GET['correo'];
$telefono = $_GET['telefono'];
$mensaje = $_GET['mensaje'];

// Datos para el correo
$destinatario = "comiendaw@gmail.com";
$asunto = "Contacto desde nuestra web";

$carta = "De: $nombre \n";
$carta .= "Correo: $correo \n";
$carta .= "Telefono: $telefono \n";
$carta .= "Mensaje: $mensaje";

// Enviando Mensaje
mail($destinatario, $asunto, $carta);
header('Location:mensaje-de-envio.html');

?>
