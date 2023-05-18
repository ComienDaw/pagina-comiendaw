package Builder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import Clases.Personas;
import Clases.Usuario;

/**
 *
 * @author Javier Martínez,Miguel Ángel de la Calle,Álvaro Martín
 * Pantalla que permite a los clientes iniciar el proceso para crearse un nuevo usuario en la aplicación
 * @param panel panel que contiene toda la información
 * @param textUsuario cuadro de texto que permite al usuario introducir su nombre de usuario
 * @param textCorreo cuadro de texto que permite al usuario introducir su correo electrónico
 * @param textFieldNombre cuadro de texto que permite al usuario introducir su nombre
 * @param textFieldApellido cuadro de texto que permite al usuario introducir sus apellidos
 * @param textPassword cuadro de texto que permite al usuario introducir su contraseña
 * @param textPasswordOK cuadro de texto que permite al usuario confirmar su contraseña
 * @param scrollPane scrollpane que permite desplazarse por la ventana
 * @param lblCampoVacio label que aparece si no se ha introducido nombre de usuario
 * @param lblTitulo label que continene el título de la pestaña
 * @param logoCD label que contiene el logo de la aplicación
 * @param lblContraseña label que contiene el texto "contraseña"
 * @param lblConfirma_Contraseña label que contiene el texto " Confirma contraseña"
 * @param lblErrorPassword label que aparece si no se ha confirmado correctamente la contraseña
 * @param lblErrorCorreo label que aparece si el correo introducido no es válido
 * @param lblNombre label que contiene el texto "Nombre"
 * @param lblApellido label que contiene el texto "Apellidos"
 * @param Boton_Registrarme botón para confirmar el registro y acceder a la pestaña para rellenar los datos personales
 * @param Boton_Volver botón para volver a la pantalla inicial de la aplicación
 */
public class bPantalla_Registro extends JFrame {

	JTextField textUsuario, textCorreo, textFieldNombre, textFieldApellido;
	JPasswordField textPassword, textPasswordOK;

	JPanel panel;
	JScrollPane scrollPane;
	JLabel lblCampoVacio, lblTitulo, logoCD, lblUsuario, lblCorreo, lblContraseña, lblConfirma_Contraseña, lblErrorPassword, lblErrorCorreo, lblNombre, lblApellido;
	JButton Boton_Registrarme,Boton_Volver ;


	/**
	 * Método main que lanza esta pestaña
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bPantalla_Registro frame = new bPantalla_Registro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Método que permite acceder a la pantalla del segundo cuestionario
	 */

	public void cambioFrame1 () {
		final bDatos_Personales bDatos_Personales = new bDatos_Personales ();
		bDatos_Personales.setVisible(true);
		dispose();
	}

	/**
	 * Método que permite acceder a la pantalla de inicio si no quiere continuar con el registro
	 */
		public void cambioFrame2 () {
			final aPantalla_Inicio aPantalla_Inicio = new aPantalla_Inicio ();
			aPantalla_Inicio.setVisible(true);
			dispose();
		}


		/**
		 * Método que carga la interfaz gráfica de la ventana.
		 */
	public void inicialice () {

		setTitle("JScrollPane Example");
		setSize(786, 550);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());

		panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));

		scrollPane = new JScrollPane(panel);
		panel.setLayout(null);

		//LABEL ERROR
		lblCampoVacio = new JLabel("Campo vacio");
		lblCampoVacio.setVisible(false);

		//LABEL NOMBRE
		lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(new Color(255, 140, 0));
		lblNombre.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblNombre.setBounds(106, 166, 111, 18);
		panel.add(lblNombre);

		//LABEL APELLIDO
		lblApellido = new JLabel("Apellidos:");
		lblApellido.setForeground(new Color(0, 128, 128));
		lblApellido.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblApellido.setBounds(415, 166, 111, 18);
		panel.add(lblApellido);

		//PARA INTRODUCIR EL APELLIDO
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(561, 167, 176, 20);
		panel.add(textFieldApellido);

		//PARA INTRODUCIR EL NOMBRE
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(187, 167, 176, 20);
		panel.add(textFieldNombre);
		lblCampoVacio.setForeground(new Color(255, 0, 0));
		lblCampoVacio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCampoVacio.setBounds(198, 282, 100, 14);
		panel.add(lblCampoVacio);

		//LABEL REGISTRO
		lblTitulo = new JLabel("USUARIO NUEVO");
		lblTitulo.setForeground(new Color(0, 128, 128));
		lblTitulo.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblTitulo.setBounds(127, 44, 278, 40);
		panel.add(lblTitulo);

		//IMAGEN FONDO PANTALLA (IMAGEN LOGO)
		logoCD = new JLabel("");
		logoCD.setIcon(new ImageIcon("./src/Imagenes_Proyecto/logo_comiendawsintexto80x76.png"));
		logoCD.setBounds(29, 5, 128, 97);
		panel.add(logoCD);

		//LABEL USUARIO
		lblUsuario = new JLabel("Nombre de usuario:");
		lblUsuario.setForeground(new Color(255, 140, 0));
		lblUsuario.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblUsuario.setBounds(26, 250, 151, 18);
		panel.add(lblUsuario);

		//PARA INGRESAR EL USUARIO
		textUsuario = new JTextField();
		textUsuario.setColumns(10);
		textUsuario.setBounds(187, 251, 176, 20);
		panel.add(textUsuario);

		//LABEL CORREO
		lblCorreo = new JLabel("Correo electrónico:");
		lblCorreo.setForeground(new Color(0, 128, 128));
		lblCorreo.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblCorreo.setBounds(394, 252, 150, 14);
		panel.add(lblCorreo);

		//PARA INGRESAR EL CORREO
		textCorreo = new JTextField();
		textCorreo.setColumns(10);
		textCorreo.setBounds(561, 251, 176, 20);
		panel.add(textCorreo);

		//LABEL CONTRASEÑA
		lblContraseña = new JLabel("Contraseña:");
		lblContraseña.setForeground(new Color(255, 140, 0));
		lblContraseña.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblContraseña.setBounds(69, 353, 100, 14);
		panel.add(lblContraseña);

		//LABEL CONFIRMAR CONTRASEÑA
		lblConfirma_Contraseña = new JLabel("Confirma contraseña:");
		lblConfirma_Contraseña.setForeground(new Color(0, 128, 128));
		lblConfirma_Contraseña.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblConfirma_Contraseña.setBounds(379, 353, 165, 14);
		panel.add(lblConfirma_Contraseña);

		//PARA AÑADIR LA CONTRASEÑA
		textPassword = new JPasswordField();
		textPassword.setBounds(187, 352, 176, 20);
		panel.add(textPassword);

		//PARA AÑADIR LA CONFIRMACION DE LA CONTRASEÑA
		textPasswordOK = new JPasswordField();
		textPasswordOK.setBounds(561, 352, 176, 20);
		panel.add(textPasswordOK);

		//LABEL ERROR
		lblErrorPassword = new JLabel("Contraseña incorrecta");
		lblErrorPassword.setVisible(false);
		lblErrorPassword.setForeground(new Color(255, 0, 0));
		lblErrorPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblErrorPassword.setBounds(571, 384, 236, 14);
		panel.add(lblErrorPassword);

		//LABEL ERROR
		lblErrorCorreo = new JLabel("Correo no válido");
		lblErrorCorreo.setVisible(false);
		lblErrorCorreo.setForeground(new Color(255, 0, 0));
		lblErrorCorreo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblErrorCorreo.setBounds(572, 282, 165, 14);
		panel.add(lblErrorCorreo);
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		//BOTON PARA QUE EL USUARIO HAGA EL REGISTRO SI LOS DATOS SON VALIDOS
		Boton_Registrarme = new JButton("REGISTRARME");
		Boton_Registrarme.setBackground(new Color(0, 128, 128));
		Boton_Registrarme.setForeground(new Color(248, 248, 255));
		Boton_Registrarme.setFont(new Font("Arial Black", Font.BOLD, 12));
		Boton_Registrarme.setBounds(198, 444, 165, 39);
		panel.add(Boton_Registrarme);

		//BOTON PARA VOLVER A LA PANTALLA PRINCIPAL SI NO QUIERES COMPLETAR REGISTRO
		Boton_Volver = new JButton("VOLVER");
		Boton_Volver.setBackground(new Color(244, 164, 96));
		Boton_Volver.setForeground(new Color(248, 248, 255));
		Boton_Volver.setFont(new Font("Arial Black", Font.BOLD, 12));
		Boton_Volver.setBounds(426, 444, 165, 39);
		panel.add(Boton_Volver);
	}

	/**
	 * Método que incluye la funcionalidad de todos los botones de la pantalla
	 */

	public bPantalla_Registro() {

		inicialice();

		//COMPROBACION SIMPLES DE QUE EL CORREO ESTE BIEN ESCRITO Y LA CONFIRMACION DE CONTRASEÑA
		Boton_Registrarme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String contraseña = textPassword.getText();
				String contraseñaOK = textPasswordOK.getText();
				String correo = textCorreo.getText();
				String com = correo.substring(correo.length()-4, correo.length());
				String es = correo.substring(correo.length()-3, correo.length());
				String usuario = textUsuario.getText();
				String nombre = textFieldNombre.getText();
				String apellido = textFieldApellido.getText();

				if (!usuario.equals("") && correo.contains("@") && (com.equals(".com") || es.equals(".es"))) {
					//CORREO BIEN
					if (contraseña.equals(contraseñaOK) && !contraseña.equals("")) {						//TODOS LOS DATOS SON CORRECTOS
						lblErrorPassword.setVisible(false);
						lblErrorCorreo.setVisible(false);
						cambioFrame1 ();
						Personas.px_actual = new Personas(usuario,nombre,apellido,correo,contraseña);
						Usuario.user_actual = new Usuario(usuario, contraseña);
					}else {																					//LA CONTRASEÑA ESTA MAL
						lblErrorPassword.setVisible(true);
						lblErrorCorreo.setVisible(false);
						textPassword.setText("");
						textPasswordOK.setText("");
					}}else if (contraseña.equals(contraseñaOK) && !contraseña.equals("")){					//EL CORREO ESTA MAL
						lblErrorCorreo.setVisible(true);
						lblErrorPassword.setVisible(false);
					}else {																					//TODOS LOS DATOS SON INCORRECTOS
						lblErrorCorreo.setVisible(true);
						lblErrorPassword.setVisible(true);
						textPassword.setText("");
						textPasswordOK.setText("");
					}}
		});

		Boton_Volver.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cambioFrame2();
			}
		});
	}
}