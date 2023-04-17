<?php
if(isset($_POST['submit'])) {
    $to = "comiendaw@gmail.com"; // La dirección de correo electrónico del destinatario
    $subject = $_POST['subject']; // El asunto del correo electrónico
    $message = $_POST['message']; // El mensaje del correo electrónico
    $headers = "From: ".$_POST['name']." <".$_POST['email'].">\r\n"; // El remitente del correo electrónico
    mail($to, $subject, $message, $headers); // Función para enviar el correo electrónico
    echo "Correo enviado."; // Mensaje de confirmación para el usuario
}
?>
