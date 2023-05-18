package Builder;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import Clases.Personas;
import Clases.Usuario;

/**
 *
 *  @author Javier Martínez,Miguel Ángel de la Calle,Álvaro Martín
 * Pantalla en la que aparecen los datos del usuario, sus platos más consumidos en cada momento del día, y le ofrece la posibilidad de cambiar su contraseña de acceso.
 * @param contentPane label que contiene toda la información.
 * @param lblNombreUsuario label que muestra el nombre de usuario.
 * @param lblIcono_Usuario label que muestra el icono del usuario.
 * @param lblMostrar_nombre label con texto que muestra el nombre del usuario.
 * @param lblNombre label que muestra el nombre del usuario
 * @param lblApellido label que muestra el apellido del usuario.
 * @param lblCorreo label que muestra el correo del usuario.
 * @param lblMostrar_Apellido label texto que muestra el apellido del usuario.
 * @param lblMostrar_correo label texto que muestra el correo del usuario.
 * @param lblPlatos_Consumidos label que muestra los platos favoritos del usuario.
 * @param lblCena label que muestra la cena favorita del el usuario.
 * @param lblComida label que muestra la comida favorita del usuario.
 * @param lblDesayuno label que muestra el desayuno favorito del usuario.
 * @param lblContenido_Desayuno label con texto que muestra el desayuno.
 * @param lblContenido_Comida label con texto que muestra la comida.
 * @param lblContenido_Cena label con texto que muestra la cena.
 * @param lblLogo label que muestra el logo de la aplicación.
 * @param btnVolver_Principal botón para volver a la pantalla principal.
 * @param btnContraseña botón para cambiar la contraseña.
 * @param contraseña campo de texto donde el usuario introduce la contraseña.
 * @param OKcontraseña campo de texto donde el usuario introduce de nuevo la contraseña para confirmar.
 * @param cambiarContraseña ventana donde el usuario modificará la contraseña.
 * @param nuevaContraseña reemplaza la contraseña actual.
 */

public class fUsuario extends JFrame {

	private JPanel contentPane, panelOption;
	JLabel lblNombreUsuario, lblIcono_Usuario, lblMostrar_nombre, lblNombre, lblApellido, lblCorreo, lblMostrar_Apellido, lblMostrar_correo, lblPlatos_Consumidos, lblCena, lblComida, lblDesayuno, lblContenido_Desayuno, lblContenido_Comida, lblContenido_Cena, lblLogo;
	JButton btnVolver_Principal, btnContraseña;
    JPasswordField contraseña, OKcontraseña, espacioBlanco;
    int cambiarContraseña;
    String nuevaContraseña;


    /**
	 * Método main que lanza esta pestaña
	 */

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	fUsuario frame = new fUsuario();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    /**
	 * Método que permite volver al menú principal de la aplicación
	 */

    public void cambioFrame1 () {
		final cPantalla_Principal cPantalla_Principal = new cPantalla_Principal ();
		cPantalla_Principal.setVisible(true);
		dispose();
	}

    /**
	 * Método que lanza el panel desde el cual se permite realizar el cambio de contraseña
	 * @param actual JPanel en el cual se mostrará el diálogo para realizar el cambio de contraseña
	 */

    public void mostrarDialogo(JPanel actual) {

				panelOption = new JPanel();
				panelOption.setLayout(new GridLayout(3, 2));

		        contraseña = new JPasswordField();
		        OKcontraseña = new JPasswordField();
		        espacioBlanco = new JPasswordField();

		        panelOption.add(new JLabel("Contraseña nueva:"));
		        panelOption.add(contraseña);
		        panelOption.add(new JLabel(""));
		        panelOption.add(espacioBlanco);
		        espacioBlanco.setVisible(false);
		        panelOption.add(new JLabel("Confirma contraseña:"));
		        panelOption.add(OKcontraseña);

		        cambiarContraseña = JOptionPane.showConfirmDialog(actual, panelOption, "Modificar contraseña", JOptionPane.DEFAULT_OPTION);
		        if (cambiarContraseña == JOptionPane.OK_OPTION) {
		        	nuevaContraseña = contraseña.getText();
					mostrarDialogo(contentPane);
					String nombreUsuario = Usuario.user_actual.getNombre_usuario();
					try {
						zConexion.updateContraseña(nombreUsuario, nuevaContraseña);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
		        }
		    }


    /**
	 * Método que carga la interfaz gráfica de la ventana
	 */

      public void inicialice () {

	        //CONTENT PANE
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			setBounds(100, 100, 643, 503);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(230, 230, 250));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			//LABEL NOMBRE DE USUARIO ARRIBA
			lblNombreUsuario = new JLabel("(NOMBRE USUARIO)");
			lblNombreUsuario.setForeground(new Color(0, 128, 128));
			lblNombreUsuario.setBackground(new Color(0, 128, 255));
			lblNombreUsuario.setFont(new Font("Arial Black", Font.ITALIC, 14));
			lblNombreUsuario.setBounds(87, 22, 172, 37);
			contentPane.add(lblNombreUsuario);

			//LABEL LOGO
			lblLogo = new JLabel("");
			lblLogo.setIcon(new ImageIcon("./src/Imagenes_Proyecto/logo_comiendawsintexto80x76.png"));
			lblLogo.setBounds(530, 10, 89, 73);
			contentPane.add(lblLogo);

			//ICONO DIBUJO USUARIO
			lblIcono_Usuario = new JLabel("");
			lblIcono_Usuario.setIcon(new ImageIcon("./src/Imagenes_Proyecto/Imagen usuario.png"));
			lblIcono_Usuario.setBounds(28, 0, 82, 83);
			contentPane.add(lblIcono_Usuario);


			//LABEL "NOMBRE"
			lblNombre = new JLabel("Nombre:");
			lblNombre.setForeground(new Color(0, 128, 128));
			lblNombre.setFont(new Font("Arial Black", Font.BOLD, 13));
			lblNombre.setBounds(56, 88, 111, 18);
			contentPane.add(lblNombre);

			//LABEL QUE MUESTRA EL NOMBRE
			lblMostrar_nombre = new JLabel("New label");
			lblMostrar_nombre.setFont(new Font("Arial Black", Font.BOLD, 13));
			lblMostrar_nombre.setBounds(246, 88, 228, 18);
			contentPane.add(lblMostrar_nombre);

			//LABEL "APELLIDO"
			lblApellido = new JLabel("Apellidos:");
			lblApellido.setForeground(new Color(205, 133, 63));
			lblApellido.setFont(new Font("Arial Black", Font.BOLD, 13));
			lblApellido.setBounds(56, 135, 111, 18);
			contentPane.add(lblApellido);

			//LABEL QUE MUESTRA EL APELLIDO
			lblMostrar_Apellido = new JLabel("New label");
			lblMostrar_Apellido.setFont(new Font("Arial Black", Font.BOLD, 13));
			lblMostrar_Apellido.setBounds(246, 135, 328, 18);
			contentPane.add(lblMostrar_Apellido);


			//LABEL "CORREO"
			lblCorreo = new JLabel("Correo electrónico:");
			lblCorreo.setForeground(new Color(0, 128, 128));
			lblCorreo.setFont(new Font("Arial Black", Font.BOLD, 13));
			lblCorreo.setBounds(56, 184, 150, 14);
			contentPane.add(lblCorreo);

			//LABEL QUE MUESTRA EL CORREO
			lblMostrar_correo = new JLabel("New label");
			lblMostrar_correo.setFont(new Font("Arial Black", Font.BOLD, 13));
			lblMostrar_correo.setBounds(246, 180, 328, 18);
			contentPane.add(lblMostrar_correo);

			//BOTON PARA VOLVER A LA PANTALLA PRINCIPAL
			btnVolver_Principal = new JButton("VOLVER A MENÚ PRINCIPAL");
			btnVolver_Principal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				}
			});
			btnVolver_Principal.setForeground(new Color(248, 248, 255));
			btnVolver_Principal.setFont(new Font("Arial Black", Font.PLAIN, 12));
			btnVolver_Principal.setBackground(new Color(244, 164, 96));
			btnVolver_Principal.setBounds(364, 399, 228, 35);
			contentPane.add(btnVolver_Principal);

			btnContraseña = new JButton("CAMBIAR CONTRASEÑA");
			btnContraseña.setForeground(new Color(248, 248, 255));
			btnContraseña.setFont(new Font("Arial Black", Font.PLAIN, 12));
			btnContraseña.setBackground(new Color(0, 128, 128));
			btnContraseña.setBounds(45, 399, 228, 35);
			contentPane.add(btnContraseña);

			lblPlatos_Consumidos = new JLabel("Platos más consumidos:");
			lblPlatos_Consumidos.setForeground(new Color(0, 128, 128));
			lblPlatos_Consumidos.setFont(new Font("Arial Black", Font.BOLD, 13));
			lblPlatos_Consumidos.setBounds(56, 236, 183, 24);
			contentPane.add(lblPlatos_Consumidos);

			lblCena = new JLabel("Cena:");
			lblCena.setForeground(new Color(255, 128, 0));
			lblCena.setFont(new Font("Arial Black", Font.BOLD, 13));
			lblCena.setBounds(109, 353, 150, 14);
			contentPane.add(lblCena);

			lblComida = new JLabel("Comida:");
			lblComida.setForeground(new Color(255, 128, 0));
			lblComida.setFont(new Font("Arial Black", Font.BOLD, 13));
			lblComida.setBounds(109, 316, 150, 14);
			contentPane.add(lblComida);

			lblDesayuno = new JLabel("Desayuno:");
			lblDesayuno.setForeground(new Color(255, 128, 0));
			lblDesayuno.setFont(new Font("Arial Black", Font.BOLD, 13));
			lblDesayuno.setBounds(109, 279, 150, 14);
			contentPane.add(lblDesayuno);

			lblContenido_Desayuno = new JLabel("New label");
			lblContenido_Desayuno.setFont(new Font("Arial Black", Font.BOLD, 13));
			lblContenido_Desayuno.setBounds(246, 277, 328, 18);
			contentPane.add(lblContenido_Desayuno);

			lblContenido_Comida = new JLabel("New label");
			lblContenido_Comida.setFont(new Font("Arial Black", Font.BOLD, 13));
			lblContenido_Comida.setBounds(246, 314, 328, 18);
			contentPane.add(lblContenido_Comida);

			lblContenido_Cena = new JLabel("New label");
			lblContenido_Cena.setFont(new Font("Arial Black", Font.BOLD, 13));
			lblContenido_Cena.setBounds(246, 351, 328, 18);
			contentPane.add(lblContenido_Cena);

	}

     /**
  	 * Método que incluye la funcionalidad de todos los botones de la pantalla
  	 */

	public fUsuario() {

		inicialice();
		zConexion.conectar();

		//MOSTRAR INFORMACION USUARIO
		lblNombreUsuario.setText(Personas.px_actual.getUsuario());
		lblMostrar_nombre.setText(Personas.px_actual.getNombre());
		lblMostrar_Apellido.setText(Personas.px_actual.getApellido());
		lblMostrar_correo.setText(Personas.px_actual.getCorreo());

		//MOSTRAR INFORMACION PLATOS FAVORITOS USUARIO

		String desayuno="", comida="", cena ="";
		try {
			desayuno = zConexion.platos_Mas_Usados(Personas.px_actual.getUsuario(), "DESAYUNO");
			comida = zConexion.platos_Mas_Usados(Personas.px_actual.getUsuario(), "COMIDA");
			cena = zConexion.platos_Mas_Usados(Personas.px_actual.getUsuario(), "CENA");

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		lblContenido_Desayuno.setText(desayuno);
		lblContenido_Comida.setText(comida);
		lblContenido_Cena.setText(cena);

		//CAMBIO DE FRAME 1
		btnVolver_Principal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cambioFrame1 ();
			}
		});

		btnContraseña.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarDialogo(contentPane);
			}
		});

	}
}

