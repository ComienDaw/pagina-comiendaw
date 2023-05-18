package Builder;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import Clases.Personas;

/**
 *
 * @author Javier Martínez,Miguel Ángel de la Calle,Álvaro Martín
 * Pantalla que verán las personas que se registren por primera vez en la aplicación, donde rellenarán sus datos personales para que la aplicación les asigne un plan nutricional
 * @param contentPane panel que contiene toda la información
 * @param textFieldAltura cuadro de texto que permite al usuario introducir su altura
 * @param textFieldPeso cuadro de texto que permite al usuario introducir su peso
 * @param textFieldEdad cuadro de texto que permite al usuario introducir su edad
 * @param lblTitulo label que contiene el título de la pestaña
 * @param lblTituloDatos label que contiene
 * @param lblGenero label que contiene el título "género"
 * @param lblAltura label que contiene el título "altura"
 * @param lblPeso label que contiene el título "peso"
 * @param lblEdad label que contiene el título "edad"
 * @param lblCm label que contiene el título "cm"
 * @param lblKG label que contiene el título "kg"
 * @param lblObjetivo label que contiene el título "objetivo"
 * @param lblAños label que contiene el título "años"
 * @param lblActividadFsica label que contiene el título "actividad física"
 * @param chckHombre checkbox que permite marcar género masculino
 * @param chckMujer checkbox que permite marcar género femenino
 * @param chck1kg checkbox que permite marcar que quieres perder 1 kg a la semana
 * @param chck05kg checkbox que permite marcar que quieres perder 0.5 kg a la semana
 * @param chckMin05kg checkbox que permite marcar que quieres perder menos de 0.5 a la semana
 * @param chckMax1kg checkbox que permite marcar que quieres perder más de 1 kg a la semana
 * @param btnCalcularKcal botón que, al ser pulsado, hace que la aplicación calcule las kcal diarias que tiene que consumir el usuario en función de los datos introducidos
 * @param btnConfirmar botón que confirma los datos que personales que el usuario ha introducido y da paso a rellenar el resto de datos
 * @param panelDatos panel que contiene los chceckbox que el usuario rellenará con sus datos
 * @param panelObjetivos panel que contiene los checkbox del peso que el usuario semanal que el usuario pretende perder y la actividad física que realiza
 * @param comboBoxActividad comboBox que permite al usuario seleccionar la cantidad de actividad física que realiza semanalmente
 * @param nombre variable para guardar el nombre del usuario
 * @param usuario variable para guardar el nombre del usuario
 * @param apellido variable para guardar el nombre del usuario
 * @param correo variable para guardar el nombre del usuario
 * @param contraseña variable para guardar el nombre del usuario
 * @param genero variable para guardar el nombre del usuario
 * @param altura variable para guardar el nombre del usuario
 * @param edad variable para guardar el nombre del usuario
 * @param peso variable para guardar el nombre del usuario
 * @param imc variable para guardar el nombre del usuario
 * @param alturaIMC variable para guardar el nombre del usuario
 * @param KcalDiarias variable para guardar el nombre del usuario
 * @param checkGeneroMarcado boolean que comprueba si se seleccionó género o no
 * @param checkObjetivoMarcado boolean que comprueba si se seleccionó objetivo o no
 */

public class bDatos_Personales extends JFrame {

	JPanel contentPane;
	JTextField textFieldAltura, textFieldPeso, textFieldEdad;

	JLabel lblTitulo, lblTituloDatos, lblGenero, lblAltura, lblPeso, lblEdad,  lblCm, lblKG, lblObjetivo, lblAños, lblActividadFsica;
	JCheckBox chckHombre, chckMujer, chck1kg, chck05kg, chckMin05kg, chckMax1kg;
	JButton btnCalcularKcal, btnConfirmar;
	JPanel panelDatos, panelObjetivos;

	JComboBox<String> comboBoxActividad;

	String nombre, usuario, apellido, correo, contraseña, genero;
	int altura, edad;
	double peso, imc, alturaIMC, KcalDiarias = 0;
	boolean checkGeneroMarcado=false, checkObjetivoMarcado=false;

	/**
	 * Método main que lanza esta pestaña
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bDatos_Personales frame = new bDatos_Personales();
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
	 * Método que inserta los datos en las tablas "Personas" y "Usuarios" de la base de datos si los datos de registro son correctos
	 */
	public void almacenarDatos() throws SQLException{

		//PRIMERO ALMACENAMOS EN LA BASE DE DATOS A LA PERSONA
		nombre = Personas.px_actual.getNombre();									//ESTOS DATOS LOS HEMOS RELLENADO DEL FRAME ANTERIOR DONDE INICIALIZAMOS LA CLASE PERSONA CON LOS VALORES DEL USUARIO
		usuario = Personas.px_actual.getUsuario();
		apellido = Personas.px_actual.getApellido();
		correo = Personas.px_actual.getCorreo();
		contraseña = Personas.px_actual.getContraseña();
		zConexion.insertPersonas(usuario, nombre, apellido, correo, contraseña);	// INSERT

		//DESPUES ALMACENAMOS LOS DATOS DEL USUARIO
//		altura = Integer.parseInt(textFieldAltura.getText());	LOS PONEMOS ABAJO EN EL INICIALICE PORQUE LOS NECESITAMOS PARA VERIFICAR SI LOS DATOS ESETAN INTRODUCIDOS
//		peso = Double.parseDouble(textFieldPeso.getText());
//		edad = Integer.parseInt(textFieldEdad.getText());
		genero = "";
		alturaIMC = Math.pow((altura/100.0), 2.0);
		imc = peso/alturaIMC;

			//1. TASA METABÓLICA BASAL: (TMB)
			//2. TMB * ACTIVIDAD FISICA DEL USUARIO
			//3. RESTAR LAS CALORIAS DEPENDIENTO LA PERDIDA SEMANAL REQUERIDA
				//4. OBTENEMOS LA KCAL DE MANTENIMIENTO DEL USUARIO

		// 1. CON EL CHECK DE GENERO, OBTENEMOS EL GENERO Y LA OPERACION DE TASA METABOLICA BASAL (PARA CALCULAR LAS KCAL DIARIAS)
			double TMB = 0;

			//MARCAR EN EL CHECKBOX EL GENERO PARA HACER EL CALCULO
			if(chckHombre.isSelected()) {
				TMB = 66 + (13.7 * peso) + (5 * altura) - (6.8 * edad);
				genero = "H";
			}else if(chckMujer.isSelected()) {
				TMB =  655 + (9.6 * peso) + (1.8 * altura) - (4.7 * edad);
				genero = "M";
			}else {
			}
		// 2. CON LA TMB CALCULAMOS SEGUN ACTIVIDAD FISICA DEL USUARIO
			String actividad_fisica = (String) comboBoxActividad.getSelectedItem();
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

		// 3. CALCULO KCAL DIARIAS CON EL OBJETIVO SEMANAL DEL USUARIO
			if(chckMax1kg.isSelected()) {
				KcalDiarias = TMB - ((1.2*7700)/7);
			}else if(chck1kg.isSelected()) {
				KcalDiarias = TMB - ((1*7700)/7);
			}else if(chck05kg.isSelected()) {
				KcalDiarias = TMB - ((0.5*7700)/7);
			}else if(chckMin05kg.isSelected()) {
				KcalDiarias = TMB - ((0.4*7700)/7);
			}else {

			}

		zConexion.insertUsuarios(usuario,genero,altura,peso,edad,imc,KcalDiarias);		//INSERT

	}

	/**
	 * Método que carga la interfaz gráfica de la ventana
	 */
 	public void inicialice() {

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 503);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		//TITULO DE LA PAGINA
		lblTitulo = new JLabel("Rellena los siguientes datos:");
		lblTitulo.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblTitulo.setBounds(10, 11, 405, 34);
		contentPane.add(lblTitulo);

		//PRIMER PANEL (IZQUIERDA) CON DATOS DEL USUARIO
		panelDatos = new JPanel();
		panelDatos.setBackground(new Color(238, 232, 170));
		panelDatos.setBounds(24, 80, 279, 373);
		contentPane.add(panelDatos);
		panelDatos.setLayout(null);

		//TITULO DE ESTE PRIMER PANEL
		lblTituloDatos = new JLabel("Datos personales:");
		lblTituloDatos.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 16));
		lblTituloDatos.setBounds(10, 11, 259, 33);
		panelDatos.add(lblTituloDatos);

		//LABEL GENERO
		lblGenero = new JLabel("Genero:");
		lblGenero.setFont(new Font("Arial Black", Font.ITALIC, 15));
		lblGenero.setBounds(10, 115, 113, 33);
		panelDatos.add(lblGenero);

		//LABEL ALTURA
		lblAltura = new JLabel("Altura");
		lblAltura.setFont(new Font("Arial Black", Font.ITALIC, 15));
		lblAltura.setBounds(10, 202, 56, 33);
		panelDatos.add(lblAltura);

		//LABEL PESO
		lblPeso = new JLabel("Peso");
		lblPeso.setFont(new Font("Arial Black", Font.ITALIC, 15));
		lblPeso.setBounds(10, 246, 56, 33);
		panelDatos.add(lblPeso);

		//LABEL EDAD
		lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Arial Black", Font.ITALIC, 15));
		lblEdad.setBounds(10, 290, 56, 33);
		panelDatos.add(lblEdad);

		//OPCION DE GENERO (HOMBRE)
		chckHombre = new JCheckBox("Hombre");
		chckHombre.setFont(new Font("Arial Black", Font.PLAIN, 11));
		chckHombre.setBackground(new Color(238, 232, 170));
		chckHombre.setBounds(20, 155, 120, 23);
		panelDatos.add(chckHombre);

		//OPCION DE GENERO (MUJER)
		chckMujer = new JCheckBox("Mujer");
		chckMujer.setFont(new Font("Arial Black", Font.PLAIN, 11));
		chckMujer.setBackground(new Color(238, 232, 170));
		chckMujer.setBounds(142, 155, 97, 23);
		panelDatos.add(chckMujer);

		//PARAR INGRESAR LA ALTURA DEL USUARIO
		textFieldAltura = new JTextField();
		textFieldAltura.setBounds(68, 208, 102, 25);
		panelDatos.add(textFieldAltura);
		textFieldAltura.setColumns(10);

		//PARA INGRESAR EL PESO DEL USUARIO
		textFieldPeso = new JTextField();
		textFieldPeso.setColumns(10);
		textFieldPeso.setBounds(68, 252, 102, 25);
		panelDatos.add(textFieldPeso);

		//PARA INGRESAR LA EDAD DEL USUARIO
		textFieldEdad = new JTextField();
		textFieldEdad.setColumns(10);
		textFieldEdad.setBounds(68, 296, 102, 25);
		panelDatos.add(textFieldEdad);

		//LABEL CM
		lblCm = new JLabel("cm.");
		lblCm.setFont(new Font("Arial Black", Font.ITALIC, 15));
		lblCm.setBounds(193, 207, 46, 22);
		panelDatos.add(lblCm);

		//LABEL KG
		lblKG = new JLabel("kg.");
		lblKG.setFont(new Font("Arial Black", Font.ITALIC, 15));
		lblKG.setBounds(193, 251, 46, 22);
		panelDatos.add(lblKG);

		//SEGUNDO PANEL (DERECHA) DE OBJETIVOS DEL USUARIO
		panelObjetivos = new JPanel();
		panelObjetivos.setVisible(false);
		panelObjetivos.setBackground(new Color(238, 232, 170));
		panelObjetivos.setBounds(338, 80, 279, 373);
		contentPane.add(panelObjetivos);
		panelObjetivos.setLayout(null);

		//TITULO DEL PANEL
		lblObjetivo = new JLabel("Objetivo semanal:");
		lblObjetivo.setFont(new Font("Arial Black", Font.ITALIC, 15));
		lblObjetivo.setBounds(10, 122, 259, 33);
		panelObjetivos.add(lblObjetivo);

		//LABEL KG
		chck1kg = new JCheckBox("1 kg. ");
		chck1kg.setBackground(new Color(204, 153, 102));
		chck1kg.setBounds(77, 205, 153, 23);
		panelObjetivos.add(chck1kg);

		//LABEL KG
		chck05kg = new JCheckBox("0.5 kg (RECOMENDADO)");
		chck05kg.setBackground(new Color(153, 255, 102));
		chck05kg.setBounds(77, 231, 153, 23);
		panelObjetivos.add(chck05kg);

		//LABEL KG
		chckMin05kg = new JCheckBox("< 0.5 kg");
		chckMin05kg.setBackground(new Color(204, 153, 102));
		chckMin05kg.setBounds(77, 257, 153, 23);
		panelObjetivos.add(chckMin05kg);

		//LABEL KG
		chckMax1kg = new JCheckBox("> 1kg.");
		chckMax1kg.setBackground(new Color(204, 51, 51));
		chckMax1kg.setBounds(77, 179, 153, 23);
		panelObjetivos.add(chckMax1kg);

		//LABEL AÑOS
		lblAños = new JLabel("años.");
		lblAños.setFont(new Font("Arial Black", Font.ITALIC, 15));
		lblAños.setBounds(193, 295, 46, 22);
		panelDatos.add(lblAños);

		//DESPLEGABLE PARA MARCAR LA ACTIVIDAD DEL USUARIO
		comboBoxActividad = new JComboBox<>();
		comboBoxActividad.setBounds(77, 66, 153, 23);
		panelObjetivos.add(comboBoxActividad);

		//TITULO DEL DESPLEGABLE
		lblActividadFsica = new JLabel("Actividad física:");
		lblActividadFsica.setFont(new Font("Arial Black", Font.ITALIC, 15));
		lblActividadFsica.setBounds(10, 22, 259, 33);
		panelObjetivos.add(lblActividadFsica);

		comboBoxActividad.addItem("Sedentario");				//AÑADIMOS LAS OPCIONES QUE QUEREMOS
		comboBoxActividad.addItem("Ligeramente activo");
		comboBoxActividad.addItem("Moderadamente activo");
		comboBoxActividad.addItem("Muy activo");
		comboBoxActividad.addItem("Extremadamente activo");

		//BOTON PARA CONFIRMAR LOS DATOS DEL PRIMER PANEL
		btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.setBackground(new Color(0, 128, 128));
		btnConfirmar.setForeground(new Color(248, 248, 255));
		btnConfirmar.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnConfirmar.setBounds(142, 339, 127, 23);
		panelDatos.add(btnConfirmar);

		//BOTON PARA CALCULAR LOS OBJETIVOS DEL SEGUNDO PANEL
		btnCalcularKcal = new JButton("CALCULAR");
		btnCalcularKcal.setBackground(new Color(0, 128, 128));
		btnCalcularKcal.setForeground(new Color(248, 248, 255));
		btnCalcularKcal.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnCalcularKcal.setBounds(135, 339, 134, 23);
		panelObjetivos.add(btnCalcularKcal);
	}

 	/**
	 * Método que incluye la funcionalidad de todos los botones de la pantalla
	 */

	public bDatos_Personales() {

		inicialice();

		//******************************************************************************************************************	CHECKBOX PARA MARCAR EL GENERO

		chckHombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckHombre.isSelected()) {
					chckMujer.setSelected(false);
					checkGeneroMarcado = true;
				}
			}
		});

		chckMujer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckMujer.isSelected()) {
					chckHombre.setSelected(false);
					checkGeneroMarcado = true;
				}
			}
		});

		//******************************************************************************************************************	FIN CHECKBOX

		//******************************************************************************************************************	CHECKBOX OBJETIVO SEMANAL

		chckMax1kg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckMax1kg.isSelected()) {
					chck1kg.setSelected(false);
					chck05kg.setSelected(false);
					chckMin05kg.setSelected(false);
					checkObjetivoMarcado=true;
				}
			}
		});

		chck1kg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chck1kg.isSelected()) {
					chckMax1kg.setSelected(false);
					chck05kg.setSelected(false);
					chckMin05kg.setSelected(false);
					checkObjetivoMarcado=true;
				}
			}
		});

		chck05kg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chck05kg.isSelected()) {
					chckMax1kg.setSelected(false);
					chck1kg.setSelected(false);
					chckMin05kg.setSelected(false);
					checkObjetivoMarcado=true;
				}
			}
		});

		chckMin05kg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckMin05kg.isSelected()) {
					chckMax1kg.setSelected(false);
					chck1kg.setSelected(false);
					chck05kg.setSelected(false);
					checkObjetivoMarcado=true;
				}
			}
		});

		//******************************************************************************************************************	FIN CHECKBOX

		//BOTON PARA CONFIRMAR LOS DATOS PERSONALES
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelObjetivos.setVisible(true);
				panelDatos.setVisible(false);
			}
		});

		//BOTON PARA CALCULAR LAS KCAL.
		btnCalcularKcal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altura = textFieldAltura.getText().equals("")?0:Integer.parseInt(textFieldAltura.getText());
				peso = textFieldPeso.getText().equals("")?0:Double.parseDouble(textFieldPeso.getText());
				edad = textFieldEdad.getText().equals("")?0:Integer.parseInt(textFieldEdad.getText());

				try {
					if (altura != 0 && peso != 0 && edad != 0 && checkObjetivoMarcado && checkGeneroMarcado){
					almacenarDatos();
					cambioFrame1();
					}else {
						mensajeError a = new mensajeError(contentPane, "No están introducidos todos los datos");
						panelDatos.setVisible(true);
						panelObjetivos.setVisible(false);
					}
				} catch (SQLException e1) {

				}

			}
		});
	}
}
