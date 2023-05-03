<?php
if (isset($_POST['submit'])) {
    $to = "comiendaw@gmail.com"; // Destino para recibir los mensajes
    $subject = $_POST['subject'];
    $name = $_POST['name'];
    $email = $_POST['email'];
    $message = $_POST['message'];
    $headers = "From: ".$name." <".$email.">";

    if (mail($to, $subject, $message, $headers)) {
        echo "<p>Tu mensaje ha sido enviado correctamente.</p>";
    } else {
        echo "<p>Ha ocurrido un error al enviar tu mensaje.</p>";
    }
}
?>
