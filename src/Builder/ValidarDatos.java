package Builder;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidarDatos {

    public static void validar() {

       String nombreUsuario = "MiNombre123";
       String contrasena = "MiContrasena123";
        String correoElectronico = "micorreo@gmail.com";

     
        // Expresión regular para validar el nombre de usuario

        String regexNombreUsuario = "^[a-zA-Z0-9]{4,8}$";
        Pattern patternNombreUsuario = Pattern.compile(regexNombreUsuario);
        Matcher matcherNombreUsuario = patternNombreUsuario.matcher(nombreUsuario);

      
        if (matcherNombreUsuario.matches()) {
            System.out.println("El nombre de usuario es válido");
        } else {
            System.out.println("El nombre de usuario no es válido");
        }


        // Expresión regular para validar la contraseña

        String regexContrasena = "^[a-zA-Z0-9]{4,8}$";
        Pattern patternContrasena = Pattern.compile(regexContrasena);
        Matcher matcherContrasena = patternContrasena.matcher(contrasena);


        if (matcherContrasena.matches()) {
            System.out.println("La contraseña es válida");
        } else {
            System.out.println("La contraseña no es válida");
        }

       

        // Expresión regular para validar el correo electrónico
        
        String regexCorreoElectronico = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.(com|es)$";
        Pattern patternCorreoElectronico = Pattern.compile(regexCorreoElectronico);
        Matcher matcherCorreoElectronico = patternCorreoElectronico.matcher(correoElectronico);

    
        if (matcherCorreoElectronico.matches()) {
            System.out.println("El correo electrónico es válido");
        } else {
            System.out.println("El correo electrónico no es válido");
        }
    }
}
