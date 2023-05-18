package Builder;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Javier Martínez,Miguel Ángel de la Calle,Álvaro Martín
 * Primera pantalla que ven los usuarios, donde pueden iniciar sesión o registrarse como nuevo usuario
 * @param contentPane panel que contiene toda la información
 * @param btnInicioSesion botón para iniciar sesión en la aplicación
 * @param btnRegistro botón para efectuar un nuevo registro en la aplicación
 * @param lblFoto label con el background
 * @param lblLogo label con el logo de la aplicación
 */
public class aPantalla_Inicio extends JFrame {

	JPanel contentPane;
	JButton btnInicioSesion, btnRegistro;
	JLabel lblFoto;
	JLabel lblLogo;

	/**
	 * Método main que lanza esta pestaña
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					aPantalla_Inicio frame = new aPantalla_Inicio();
					frame.setResizable(false);
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Método que permite acceder a la pantalla de registro de usuario nuevo
	 */

	public void cambiarFrame1() {
		final bPantalla_Registro bPantalla_Registro = new bPantalla_Registro ();
		bPantalla_Registro.setVisible(true);
		dispose();
	}

	/**
	 * Método que permite acceder a la pantalla de inicio de sesión
	 */
	public void cambiarFrame2() {
		final bPantalla_Inicio_Sesion bPantalla_Inicio_Sesion = new bPantalla_Inicio_Sesion ();
		bPantalla_Inicio_Sesion.setVisible(true);
		dispose();
	}

	/**
	 * Método que carga la interfaz gráfica de la ventana
	 */
	public void inicialice () {

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 503);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		lblLogo = new JLabel("New label");
		lblLogo.setIcon(new ImageIcon("./src/Imagenes_Proyecto/logo_comiendawsintexto80x76.png"));
		lblLogo.setBounds(286, 87, 81, 76);
		contentPane.add(lblLogo);

		//BOTON INICIO SESION
		btnInicioSesion = new JButton("INICIO SESIÓN");
		btnInicioSesion.setBackground(new Color(0, 128, 128));
		btnInicioSesion.setForeground(new Color(248, 248, 255));
		btnInicioSesion.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnInicioSesion.setBounds(168, 273, 141, 35);
		contentPane.add(btnInicioSesion);

		//BOTON REGISTRARSE
		btnRegistro = new JButton("SOY NUEVO");
		btnRegistro.setBackground(new Color(244, 164, 96));
		btnRegistro.setForeground(new Color(248, 248, 255));
		btnRegistro.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnRegistro.setBounds(340, 273, 141, 35);
		contentPane.add(btnRegistro);

		//FONDO DE PANTALLA (IMAGEN LOGO)
		lblFoto = new JLabel("");
		lblFoto.setVerticalAlignment(SwingConstants.BOTTOM);
		lblFoto.setIcon(new ImageIcon("src/Imagenes_Proyecto/Foto_Inicio.png"));
		lblFoto.setBounds(0, 0, 627, 464);
		contentPane.add(lblFoto);
		contentPane.setLayout(null);
	}

	/**
	 * Método que incluye la funcionalidad de todos los botones de la pantalla
	 */

	public aPantalla_Inicio() {
		inicialice();
		zConexion.conectar();

		btnInicioSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					cambiarFrame2();
			}
		});

		//CAMBIO DE FRAME 2
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarFrame1();
			}
		});



	}
}
