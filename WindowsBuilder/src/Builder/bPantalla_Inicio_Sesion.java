package Builder;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import Clases.Usuario;

/**
 *
 * @author Javier Martínez,Miguel Ángel de la Calle,Álvaro Martín
 * Pantalla que permite a los usuarios que ya tengan cuenta en la aplicación iniciar sesión con su usuario y contraseña
 * @param contentPane panel que contiene toda la información
 * @param textFieldUuario cuadro de texto que permite al usuario introducir su nombre de usuario
 * @param passwordField cuadro de texto que permite al usuario introducir su contraseña
 * @param lblTitulo label que contiene el título de la pestaña
 * @param lblUsuario label que contiene el texto "usuario"
 * @param lblContraseña label que contiene el título "contraseña"
 * @param lblLogo label que contiene el logo de la aplicación
 * @param btnEntrar botón que permite entrar al menú principal de la aplicación
 * @param btnVolver botón que permite volver a la pantalla de inicio de la aplicación
 * @param mostrar objeto de la clase mensajeError que se mostrará con distintos textos según el error que se haya producido en la aplicación
 */
public class bPantalla_Inicio_Sesion extends JFrame {

	JPanel contentPane;
	JTextField textFieldUsuario;
	JPasswordField passwordField;
	JLabel lblTitulo, lblUsuario, lblContraseña,lblLogo;
	JButton btnEntrar,btnVolver;

	mensajeError mostrar;

	/**
	 * Método main que lanza esta pestaña
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bPantalla_Inicio_Sesion frame = new bPantalla_Inicio_Sesion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Método que permite acceder a la pantalla principal de la aplicación
	 */
	public void cambioFrame1 () {
		final cPantalla_Principal cPantalla_Principal = new cPantalla_Principal ();
		cPantalla_Principal.setVisible(true);
		dispose();
	}

	/**
	 * Método que permite acceder a la pantalla de inicio de la aplicación
	 */
	public void cambioFrame2 () {
		final aPantalla_Inicio aPantalla_Inicio = new aPantalla_Inicio ();
		aPantalla_Inicio.setVisible(true);
		dispose();
	}

	/**
	 * Método que carga la interfaz gráfica de la ventana
	 */
	public void inicialice (){

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 503);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		//BOTON CONFIRMAR QUE EXISTE USUARIO AL INTRODUCIR LOS DATOS Y COMPARARLOS CON LA BBDD
		btnEntrar = new JButton("ENTRAR");
		btnEntrar.setBackground(new Color(0, 128, 128));
		btnEntrar.setForeground(new Color(248, 248, 255));
		btnEntrar.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnEntrar.setBounds(167, 383, 113, 40);
		contentPane.add(btnEntrar);

		//TITULO DE LA PAGINA
		lblTitulo = new JLabel("INICIO DE SESIÓN");
		lblTitulo.setForeground(new Color(0, 128, 128));
		lblTitulo.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblTitulo.setBounds(200, 102, 271, 48);
		contentPane.add(lblTitulo);

		//PARA INGRESAR EL USUARIO QUE QUIERO HACER LOGIN
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(249, 192, 191, 40);
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);

		//PARA INGRESAR LA CONTRASEÑA
		passwordField = new JPasswordField();
		passwordField.setBounds(249, 264, 191, 40);
		contentPane.add(passwordField);

		//LABEL USUARIO
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(new Color(0, 128, 128));
		lblUsuario.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblUsuario.setBounds(142, 196, 69, 29);
		contentPane.add(lblUsuario);

		//LABEL CONTRASEÑA
		lblContraseña = new JLabel("Contraseña");
		lblContraseña.setForeground(new Color(244, 164, 96));
		lblContraseña.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblContraseña.setBounds(112, 269, 99, 27);
		contentPane.add(lblContraseña);

		//LABEL LOGO SUPERIOR
		lblLogo = new JLabel("New label");
		lblLogo.setIcon(new ImageIcon("./src/Imagenes_Proyecto/logo_comiendawsintexto80x76.png"));
		lblLogo.setBounds(290, 21, 76, 70);
		contentPane.add(lblLogo);

		//BOTÓN VOLVER A LA PANTALLA DE INICIO
		btnVolver = new JButton("VOLVER");
		btnVolver.setBackground(new Color(244, 164, 96));
		btnVolver.setForeground(new Color(248, 248, 255));
		btnVolver.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnVolver.setBounds(358, 383, 113, 40);
		contentPane.add(btnVolver);
	}

	/**
	 * Método que incluye la funcionalidad de todos los botones de la pantalla
	 */

	public bPantalla_Inicio_Sesion(){

		inicialice();
		zConexion.conectar();

		//VERIFICACION EN LA BBDD DE LA EXISTENCIA DEL USUARIO Y CONTRASEÑA PARA HACER EL LOGIN
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String usuario = textFieldUsuario.getText();
				String contraseña = passwordField.getText();
				boolean resultado = false;
				if (!usuario.isEmpty() || !contraseña.isEmpty()) {			//COMPARAMOS TANTO QUE EXISTA EL USUARIO Y LA CONTRASEÑA Y QUE NO ESTE VACIO
				try {
					resultado=zConexion.inicioSesion(usuario, contraseña);	//COMPROBACIONES CON LA BBDD PARA VERIFICAR EL ACCESO
					Usuario.user_actual = new Usuario(usuario, contraseña);
					zConexion.datosPersona(usuario);
					if(resultado) {
						cambioFrame1 ();
					} else {
						mostrar = new mensajeError(contentPane, "Los datos introducidos son incorrectos");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				}else {
				}
			}
		});

		//VOLVER A LA PANTALLA DE INICIO SI NO SE QUIERE INCIAR SESIÓN
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambioFrame2();
	}
});
	}

}

