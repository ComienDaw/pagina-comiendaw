
<?php
if($_SERVER['REQUEST_METHOD'] == 'POST') {
    $to = 'comiendaw@gmail.com'; // Nuestra dirección de correo electrónico
    $subject = 'Mensaje enviado desde formulario de contacto'; // Asunto del correo

    // Datos del usuario
    $names = $_POST['nombre'];
    $phone = $_POST['telefono'];
    $email = $_POST['correo'];
    $mensaje = $_POST['mensaje'];

    // El cuerpo del mensaje
    $body = "Nombre: $nombre\nTeléfono: $phone\nCorreo electrónico: $email\nMensaje:\n$mensaje";

    // Condiciones para enviar o no el correo
    if(mail($to, $subject, $body)) {
        header("mensaje-de-envio.html"); // Si se envía el correo electrónico correctamente, redirige al usuario a una página de agradecimiento
        exit;
    } else {
        echo 'Error al enviar el mensaje.'; // Si hay un error al enviar el correo electrónico, se muestra este mensaje en la pantalla
    }
}
?>
