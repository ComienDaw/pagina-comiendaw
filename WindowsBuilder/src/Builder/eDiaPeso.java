package Builder;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import Clases.Usuario;

/**
 * @author Javier Martínez,Miguel Ángel de la Calle,Álvaro Martín
 * Esta pestaña esta destinada al seguimiento del usuario con el control de su peso, haciendo posible modificar su peso guardado al inicio por el peso actual. Además, el usuario dispone de 2 opciones adicionales:
 * modificar solo su peso y continuar con su misma rutina alimentaria, o modificar tanto su peso como los demás datos respectivos de su rutina alimentaria, con lo que cambiaría totalmente su plan de consumo diario.
 * @param contentPane panel que contiene toda la información de la ventana
 * @param panelModificar panel que aparecerá cuando el usuario pulse al botón "cambiar peso"
 * @param lblTitulo label que contiene el título de la ventana
 * @param lblpeso label para introducir el nuevo peso
 * @param lblopcion label label que contiene las opciones
 * @param lblCambioActividad label que contiene la opción de cambiar de nivel de ejercicio físico semanal
 * @param lblCambioObjetivo label que contiene la opción de cambiar de objetivo de pérdida de peso
 * @param lblAtras botón para cerrar la ventana actual y volver al menú principal
 * @param btnMejorOtroDia botón para que cierra la ventana actual y volver al menú principal
 * @param cambiaPeso textField que contiene el texto de "cambiar de peso"
 * @param panelCambioPeso label que muestra el panel en que el usuario puede introducir su nuevo peso
 * @param accion variable de tipo boolean que nos indica si el usuario
 * @param nombreUser variable en la que se guarda el nombre del usuario
 * @param genero variable en la que se guarda el género del usuario
 * @param chckContinuar checkbox que permite marcar la opción de continuar con el plan actual
 * @param chckModificar checkbox que permite marcar la opción de cambiar el plan actual
 * @param comboBox1 comboBox que nos permite desplegar las opciones para el nuevo nivel de ejercicio físico semanal que va a realizar el usuario
 * @param comboBox2 comboBox que nos permite desplegar las opciones para la nueva cantidad de peso que el usuario quiere perder semanalmente
 * @param altura variable que guarda la altura del usuario
 * @param edad variable que guarda la edad del usuario
 * @param peso variable que guarda el peso del usuario
 * @param calcularIMC que guarda el valor del nuevo IMC del usuario
 * @param KcalDiarias que guarda el valor de las kcal diarias que tiene que consumir el usuario
 * @param TMB variable que guarda la tasa de metabolismo basal del usuario
 * @param cambio variable de tipo boolean que se muestra a verdadero o falso según el usuario haya decidido cambiar o no de peso
 * @param btnCambiarPeso botón que sirve para introducir un nuevo peso en la aplicación
 * @param lblTexto_Explicativo label que guarda el texto que informa al usuario de cómo pesarse correctamente
 * @param lbl_logo label que contiene el logo de la aplicación
 *
 */
public class eDiaPeso extends JFrame {

	JPanel contentPane, panelModificar;
	JLabel lblTitulo, lblpeso, lblopcion, lblCambioActividad, lblCambioObjetivo, lblAtras,lblTexto_Explicativo, lbl_logo;
	JButton btnMejorOtroDia,btnCambiarPeso;
	JTextField cambiaPeso;
	JOptionPane panelCambioPeso;
	String accion, nombreUser, genero;
	JCheckBox chckContinuar, chckModificar;
	JComboBox<String> comboBox1,  comboBox2;

	int botonesJOption, botonesJOption2, altura, edad;
	double peso, calcularIMC, KcalDiarias, TMB;
	static boolean cambio;

	/**
	 * Método main que lanza esta pestaña
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					eDiaPeso frame = new eDiaPeso();
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
	 * Método que genera el primer JOptionPane para introducir el peso
	 */

	public void JOptionPanel() {

		//INGRESAR NUEVO PESO
		cambiaPeso = new JTextField();

		//TODOS LOS COMPONENTES DE NUESTRO JOPTIONPANEL
		Object[] JOptionPanel = {
				lblpeso = new JLabel("Ingrese su peso:"),cambiaPeso,
				lblopcion = new JLabel("¿Qué desea hacer?"),
				chckContinuar = new JCheckBox("Continuar con mi plan"),
				chckModificar = new JCheckBox("Modificar mi plan")
		};

		//AÑADIMOS LOS COMPONENTES A EL JOPTIONPANEL
		panelCambioPeso = new JOptionPane(JOptionPanel);

		peso = 0;
		accion = null;
		chckContinuar = (JCheckBox) JOptionPanel[3];		//ESTABLECEMOS LA POSICION DE CONTINUAR
		chckModificar = (JCheckBox) JOptionPanel[4];		//ESTABLECEMOS LA POSICION DE MODIFICAR

		chckContinuar.addActionListener(new ActionListener() {		//SELECCIONAR CONTINUAR
			public void actionPerformed(ActionEvent e) {
				if (chckContinuar.isSelected()) {
					chckModificar.setSelected(false);
				}
			}
		});

		chckModificar.addActionListener(new ActionListener() {		//SELECCIONAR MODIFICAR
			public void actionPerformed(ActionEvent e) {
				if (chckModificar.isSelected()) {
					chckContinuar.setSelected(false);
				}
			}
		});


		//VARIABLE PARA ALMACENAR LO SELECCIONADO
			//EL JOPTION PANEL DEVUELVE UN ENTERO POR ESO ESTA VARIABLE
		botonesJOption = JOptionPane.showConfirmDialog(contentPane, JOptionPanel, "Modificar peso", JOptionPane.OK_CANCEL_OPTION);	//(ULTIMO PARAMETRO) BOTON DE ACEPTAR Y CANCELAR

		int pesoNuevo = cambiaPeso.getText().equals("")?0:Integer.parseInt(cambiaPeso.getText());

		//ACCION DEL BOTON ACEPTAR
		if (botonesJOption == JOptionPane.OK_OPTION) {
			if (chckContinuar.isSelected() && pesoNuevo!= 0) {
				try {
					nombreUser = Usuario.user_actual.getNombre_usuario();
					zConexion.recuperarDatosPersonales(nombreUser);

					peso = Double.parseDouble(cambiaPeso.getText());
					altura = Usuario.user_completo.getAltura();
					calcularIMC = (peso/(Math.pow((altura/100.0), 2.0)));
					zConexion.updatePeso(peso, nombreUser, calcularIMC);

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} else if (chckModificar.isSelected() && pesoNuevo!= 0) {
					peso = Double.parseDouble(cambiaPeso.getText());
					cambio = true;
			} else {
				mensajeError a = new mensajeError(contentPane, "No están introducidos todos los datos");
			}
		}
	}

	/**
	 * Método que genera un JOptionPane si el usuario, además de cambiar su peso, decide cambiar su plan
	 */

	public void JOptionPanel2() {

		Object[] JOptionPanel2 = {
				comboBox1 = new JComboBox<>(),
				comboBox2 = new JComboBox<>()
		};
	      		comboBox1.addItem("Sedentario");
	      		comboBox1.addItem("Ligeramente activo");
	      		comboBox1.addItem("Moderadamente activo");
	      		comboBox1.addItem("Muy activo");
	      		comboBox1.addItem("Extremadamente activo");


	      		comboBox2.addItem(">1KG");
	      		comboBox2.addItem("1KG");
	      		comboBox2.addItem("0.5KG");
	      		comboBox2.addItem("<0.5KG");

	      lblCambioActividad = new JLabel("Actividad física: ");

	      lblCambioObjetivo = new JLabel("Objetivo semanal: ");

	      panelModificar = new JPanel();
	      panelModificar.setLayout(new BoxLayout(panelModificar, BoxLayout.PAGE_AXIS));
	      panelModificar.add(lblCambioActividad);
	      panelModificar.add(comboBox1);
	      panelModificar.add(lblCambioObjetivo);
	      panelModificar.add(comboBox2);

	      botonesJOption2 = JOptionPane.showConfirmDialog(contentPane, panelModificar, "Cambiar Datos", JOptionPane.DEFAULT_OPTION);


	      //ACCION DEL BOTON ACEPTAR
	      if (botonesJOption2 == JOptionPane.OK_OPTION) {
				try {
					nombreUser = Usuario.user_actual.getNombre_usuario();
					zConexion.recuperarDatosPersonales(nombreUser);

					genero = Usuario.user_completo.getGenero();
					edad = Usuario.user_completo.getEdad();
					altura = Usuario.user_completo.getAltura();

					System.out.println(nombreUser + " " + genero + " " + edad + " " + altura); //++++++

//**************************************************************************************************** CALCULAR KCAL MANTENIMIENTO
					if(genero.equals("H")) {
						TMB = 66 + (13.7 * peso) + (5 * altura) - (6.8 * edad);
					}else if(genero.equals("M")) {
						TMB =  655 + (9.6 * peso) + (1.8 * altura) - (4.7 * edad);
					}


				// ACTIVIDAD FISICA DEL USUARIO
					String actividad_fisica = (String) comboBox1.getSelectedItem();
					switch (actividad_fisica) {
					case "Sedentario" :
						TMB = TMB*1.2;
						break;
					case "Ligeramente activo" :
						TMB=TMB*1.375;
						break;
					case "Moderadamente activo" :
						TMB = TMB*1.55;
						break;
					case "Muy activo" :
						TMB=TMB*1.725;
						break;
					case "Extremadamente activo" :
						TMB=TMB*1.9;
						break;
					}

				// OBJETIVO SEMANAL DEL USUARIO
					String objetivo = (String) comboBox2.getSelectedItem();
					switch (objetivo) {
					case ">1KG" :
						KcalDiarias = TMB - ((1.2*7700)/7);
						System.out.println("aqui estamos 2");
						break;
					case "1KG" :
						KcalDiarias = TMB - ((1*7700)/7);
						break;
					case "0.5KG" :
						KcalDiarias = TMB - ((0.5*7700)/7);
						break;
					case "<0.5KG" :
						KcalDiarias = TMB - ((0.4*7700)/7);
						break;
					}

					calcularIMC =  peso/(Math.pow((altura/100.0), 2.0));


					zConexion.updatePesoIMC(peso, nombreUser,calcularIMC, (int)KcalDiarias);

				} catch (SQLException e1) {
					mensajeError a = new mensajeError(contentPane, "No se ha podido actualizar el peso.");
				}
				}

	      }

	//****************************************************************************************************


	/**
	 * Método que carga la interfaz gráfica de la ventana
	 */
	public void inicialice() {

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 503);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		lblAtras = new JLabel("");
		lblAtras.setIcon(new ImageIcon("./src/Imagenes_Proyecto/atras.png"));
		lblAtras.setBounds(579, 11, 25, 25);
		contentPane.add(lblAtras);

		btnCambiarPeso = new JButton("CAMBIAR PESO");
		btnCambiarPeso.setBackground(new Color(0, 128, 128));
		btnCambiarPeso.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnCambiarPeso.setBounds(232, 312, 173, 41);
		btnCambiarPeso.setForeground(new Color(248, 248, 255));
		contentPane.add(btnCambiarPeso);

		lblTitulo = new JLabel("¿Cómo pesarse correctamente?");
		lblTitulo.setForeground(new Color(0, 128, 128));
		lblTitulo.setBackground(new Color(0, 128, 128));
		lblTitulo.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblTitulo.setBounds(138, 31, 392, 63);
		contentPane.add(lblTitulo);

		//TEXTO PRINCIPAL DEL FRAME
		lblTexto_Explicativo = new JLabel("<html><pre>  -Pésate solo con una báscula.\n\n  "
				+ "- Estado antes de pesarse:\n     "
				+ "• En ropa interior o desnudo.\n     "
				+ "• En ayunas o habiendo bebido uno o dos vasos de agua.\n     "
				+ "• Después de haber ido al servicio.\n\n  "
				+ "- Fija un día y una hora para pesarte.</pre></html>");
		lblTexto_Explicativo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblTexto_Explicativo.setBounds(69, 46, 519, 278);
		contentPane.add(lblTexto_Explicativo);

		btnMejorOtroDia = new JButton("MEJOR OTRO DÍA");
		btnMejorOtroDia.setBackground(new Color(244, 164, 96));
		btnMejorOtroDia.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnMejorOtroDia.setForeground(new Color(248, 248, 255));
		btnMejorOtroDia.setBounds(232, 378, 173, 41);
		contentPane.add(btnMejorOtroDia);

		lbl_logo = new JLabel("New label");
		lbl_logo.setIcon(new ImageIcon("./src/Imagenes_Proyecto/logo_comiendawsintexto80x76.png"));
		lbl_logo.setBounds(10, 11, 76, 74);
		contentPane.add(lbl_logo);
	}

	/**
	 * Método que incluye la funcionalidad de todos los botones de la pantalla
	 */

	public eDiaPeso() {

		inicialice();
		zConexion.conectar();

		btnCambiarPeso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPanel();

				if (cambio) {
					JOptionPanel2();
					cambio = false;
				}
			}
		});



		//CAMBIO DE FRAME 1 (BOTON MEJOR OTRO DIA)
		btnMejorOtroDia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambioFrame1 ();
			}
		});

		lblAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cambioFrame1 ();
			}
		});
	}
}

