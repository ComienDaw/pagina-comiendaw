
<?php
if($_SERVER['REQUEST_METHOD'] == 'POST') {
    $to = 'comiendaw@gmail.com'; // Reemplaza esto con tu dirección de correo electrónico
    $subject = 'Mensaje enviado desde formulario de contacto'; // Asunto del correo electrónico

    // Recopilación de los datos enviados por el formulario
    $names = $_POST['nombre'];
    $phone = $_POST['telefono'];
    $email = $_POST['correo'];
    $mensaje = $_POST['mensaje'];

    // Construcción del cuerpo del correo electrónico
    $body = "Nombre: $nombre\nTeléfono: $phone\nCorreo electrónico: $email\nMensaje:\n$mensaje";

    // Envío del correo electrónico
    if(mail($to, $subject, $body)) {
        header("mensaje-de-envio.html"); // Si se envía el correo electrónico correctamente, redirige al usuario a una página de agradecimiento
        exit;
    } else {
        echo 'Error al enviar el mensaje.'; // Si hay un error al enviar el correo electrónico, se muestra este mensaje en la pantalla
    }
}
?>
