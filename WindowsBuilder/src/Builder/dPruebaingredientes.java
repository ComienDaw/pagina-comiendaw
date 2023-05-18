package Builder;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Clases.Alimentos;
import Clases.Platos;
import Clases.Usuario;

/**
 *
 * @author Javier Martínez,Miguel Ángel de la Calle,Álvaro Martín
 * Esta pestaña se utiliza para la creacion de un nuevo plato por parte del usuario. Consta de dos JComboBox para la eleccion del tipo y nombre del ingrediente que se quiere seleccionar de la BBDD
 * Se generan dos JPanel nuevos, uno para la informacion correspondiente del alimento seleccionado y otro para ver la creacion del plato.
 * El usuario podrá guardar el plato en la BBDD para su posterior uso en la pestaña de "Platos favoritos" o pulsar el botón "usar" para utilizarlo ese mismo dia para su dieta
 * @param contentPane panel que contiene toda la información de la ventana
 * @param panelValoresNut panel que muestra los valores nutricionales de los alimentos que vas seleccionando para añadir al plato
 * @param panelPlato panel que muestra el nombre del plato con los ingredientes que lo conforman
 * @param panelMensaje panel que aparece cuando pasas el ratón por en encima del icono para cambiar el plato, para que el usuario sepa para qué sirve ese icono
 * @param btnBuscarAlimentos botón para que la aplicación muestre el alimento que estás buscando y poder añadirlo posteriormente al plato
 * @param btnQuitar botón para quitar el último elemento de la lista de ingredientes del plato que estás creando
 * @param btnAñadir botón para añadir el alimento seleccionado a la lista de ingredientes del plato que estás creando
 * @param btnBuscarTipo botón para que aparezcan los alimentos del tipo que has seleccionado
 * @param btnGuardarFav botón para guardar el plato en la pestaña de platos favoritos del usuario
 * @param btnUsoPlato botón para usar el plato creado y añadir que se sumen sus valores nutricionales a los consumidos durante el día actual
 * @param lblAtras label para volver atrás, al menú principal
 * @param lblKCal label que contiene el texto "valor energético"
 * @param lblProteina label que contiene el texto "proteínas"
 * @param lblCarbohidrato label que contiene el texto "carbohidratos"
 * @param lblGrasas label que contiene el texto "grasas"
 * @param lblVirtaminas label que contiene el texto "vitaminas"
 * @param lblTitulo label que contiene el título de la pestaña
 * @param lblMostrarKcal label que muestra las kcal que tiene el alimento
 * @param lblMostrarProt label que muestra las proteínas que tiene el alimento
 * @param lblMostrarCarbo label que muestra los carbohidratos que tiene el alimento
 * @param lblMostrarGras label que muestra las grasas que tiene el alimento
 * @param lblMostrarVit label que muestra las vitaminas que tiene el alimento
 * @param lblkcalU label con texto que acompaña a la cantidad de kcal
 * @param lblProteinasU con texto que acompaña a la cantidad de proteínas
 * @param lblCarbohidratosU con texto que acompaña a la cantidad de carbohidratos
 * @param lblGrasasU con texto que acompaña a la cantidad de grasas
 * @param lblPanelValores label que contiene el texto "valores nutricionales"
 * @param lblAñadeIngredientes label que contiene el texto "añade la cantidad"
 * @param lblTituloPlato label que contiene el título del plato
 * @param lblFotoCambio_plato label que contiene el logo del botón de cambiar de plato
 * @param lblModificar_plato label que contiene el texto "modificar el nombre del plato"
 * @param spinner spinner para seleccionar la cantidad de unidades que quieres agregar de un alimento al plato
 * @param textFieldAlimentos textfield donde se muestra el alimento seleccionado para añadir al plato
 * @param comboBoxAlimentos combobox para elegir el alimento a añadir
 * @param comboBoxTipo combobox para elegir el tipo de alimento a añadir
 * @param totalProteina variable que guardará el total de proteínas que tendrá el plato creado
 * @param totalCarbhidratos variable que guardará el total de carbohidratos que tendrá el plato creado
 * @param totalGrasas variable que guardará el total de grasas que tendrá el plato creado
 * @param totalKcal variable que guardará el total de kcal que tendrá el plato creado
 * @param vitamina variable que guardará las vitaminas que tendrá el plato creado
 * @param numPlato variable que guarda el número de plato favorito del usuario conectado
 * @param moverlbl variable para crear los alimentos en el panel del plato nuevo
 * @param ponerNombre variable que almacena un nombre por defecto para el plato creado si no se añade uno manualmente
 * @param Alimentosañadidos arraylist de alimentos añadidos para formar el plato
 * @param Numerosañadidos arraylist de numeros que refleja el número de unidades de cada alimento que contiene el plato
 * @param mostrar objeto de la clase mensajeError que sirve para mostrar errores personalizados según se requiera
 * @param lblInfoCantidad label que informa de la unidad estándar con la que se mide el alimento que has seleccionado para añadir al plato
 */

public class dPruebaingredientes extends JFrame {

	JPanel contentPane,panelValoresNut, panelPlato, panelMensaje;
	JButton btnBuscarAlimentos,btnQuitar,btnAñadir,btnBuscarTipo,btnGuardarFav,btnUsoPlato;
	JLabel lblAtras, lblKCal,lblProteina,lblCarbohidrato,lblGrasas,lblVirtaminas,lblTitulo,lblMostrarKcal,lblMostrarProt,lblMostrarCarbo,lblMostrarGras,lblMostrarVit,lblkcalU,lblProteinasU,lblCarbohidratosU,lblGrasasU,lblPanelValores, lblAñadeIngredientes, lblTituloPlato, lblFotoCambio_plato, lblModificar_plato;
	JSpinner spinner;
	JTextField textFieldAlimentos;
	JComboBox comboBoxAlimentos, comboBoxTipo;

	static float totalProteina, totalCarbhidratos, totalGrasas, totalKcal;	//CONTADORES DE LOS VALORES NUTRICIONALES
	static String vitamina = "";

	static int numPlato = 1;						//VARIABLE PARA INSERTAR EN LA BBDD COLUMNA PLATOS

	private static int moverlbl = 0;				//VARIABLE PARA CREAR LOS ALIMENTOS EN EL PANEL DEL PLATO NUEVO

	static boolean ponerNombre = true;							//VARIABLE PARA RELLENAR NOMBRE POR DEFECTO DEL PLATO SI NO SE AÑADIO UN NOMBRE MANUAL

	ArrayList <JLabel> Alimentosañadidos = new ArrayList <>();				//DECLARAR ARRAYLIST DE OBJETOS JLABEL (NOMBRES ALIMENTOS)
	ArrayList <JLabel> Numerosañadidos = new ArrayList <>();					//DECLARAR ARRAYLIST DE OBJETOS JLABEL (NUMEROS)

	mensajeError mostrar;
	private JLabel lblInfoCantidad;


	/**
	 * Método main que lanza esta pestaña
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dPruebaingredientes frame = new dPruebaingredientes();
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
		try {
			zConexion.cerrar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dispose();
	}

	/**
	 * Método que muestra los valores nutricionales de cada alimento
	 */
	public void valoresAlimentos() {

		String nombre = (String) comboBoxAlimentos.getSelectedItem();
		int cantidad = (int)spinner.getValue();		//ALMACENAR LA CANTIDAD QUE QUIERE USAR EN UN PLATO DE UN MISMO INGREDIENTE

		try {

			zConexion.nutrientesAlimentos(nombre);	//LLAMADA A LA BBDD PARA RELLENAR OBJETO ALIMENTO.AL_ACTUAL

			//FORMATO PARA DARLE DECIMALES NECESARIOS A LOS NUMEROS
			DecimalFormat df = new DecimalFormat("#.00");

			lblMostrarProt.setText(df.format(Alimentos.al_actual.getProteina()*cantidad));
			lblMostrarCarbo.setText(df.format(Alimentos.al_actual.getCarbohidrato()*cantidad));
			lblMostrarGras.setText(df.format(Alimentos.al_actual.getGrasas()*cantidad));
			lblMostrarKcal.setText(df.format(Alimentos.al_actual.getKcal()*cantidad));
			lblMostrarVit.setText(Alimentos.al_actual.getVitaminas());


		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Método con el que se obtienen todos los tipos de alimentos existentes
	 */
	public void tipoAlimentos() {

	ArrayList<Object> tipo;

		try {
			tipo = zConexion.sacarTipo();					//LLAMADA A LA BBDD PARA RELLENAR LA LISTA DE TIPOS DE LOS ALIMENTOS
			for (Object mostrarTipo : tipo) {
				comboBoxTipo.addItem(mostrarTipo);			//COMBOBOX AÑADE LA LISTA
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método con el que se obtienen todos los alimentos de un tipo guardados en la BBDD
	 */
	public void tipoNombre() {

	String tipo = (String) comboBoxTipo.getSelectedItem();
	ArrayList<Object> nombre;
	comboBoxAlimentos.removeAllItems();

		try {
			nombre = zConexion.nombreAlimentos(tipo);		//LLAMADA A LA BBDD PARA RELLENAR LA LISTA DE NOMBRES DE LOS ALIMENTOS (POR TIPOS)
			for (Object mostrarNombre : nombre) {
				comboBoxAlimentos.addItem(mostrarNombre);	//COMBOBOX AÑADE LOS NOMBRES
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Método para guardar un plato en favoritos, almacenando el total de los valores nutricionales que contiene
	 */
	public void totalNutrientes() {

		String nombre = (String) comboBoxAlimentos.getSelectedItem();

		try {
			zConexion.nutrientesAlimentos(nombre);			//LLAMADA A LA BBDD CON EL NOMBRE DEL ALIMENTO PARA DEVOLVER VALORES NUTRICIONALES

			//SE USA REPLACE POR FALLO A LA HORA DE COGER LOS DATOS
			totalProteina += Float.parseFloat(lblMostrarProt.getText().replace(",", "."));
			totalCarbhidratos += Float.parseFloat(lblMostrarCarbo.getText().replace(",", "."));
			totalGrasas += Float.parseFloat(lblMostrarGras.getText().replace(",", "."));
			totalKcal += Float.parseFloat(lblMostrarKcal.getText().replace(",", "."));

			//PARA NO DUPLICAR VITAMINAS EN LA BBDD
			if(!vitamina.equals("")) {
				for(int i=0; i<lblMostrarVit.getText().length(); i++) {
					if (vitamina.charAt(i) != lblMostrarVit.getText().charAt(0) ) {
						vitamina += lblMostrarVit.getText();
					}else {
						break;
					}
				}
			}else {
				vitamina += lblMostrarVit.getText();
			}

		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Método para insertar los datos necesarios en las tablas "Platos" y "Comen" (que actúa como relación entre usuarios y platos) de la BBDD
	 */
	public void insert_Comen_Platos(int esFavorito , int numPlato) throws SQLException{

		String nombre_plato= "";

		if (!ponerNombre) {
			nombre_plato = lblTituloPlato.getText();
		}else {
			nombre_plato = "Plato_nuevo_" + numPlato;
			lblTituloPlato.setText(nombre_plato);

		}

				String nombre_user= Usuario.user_actual.getNombre_usuario();

					zConexion.insertPlatos(nombre_plato, totalProteina, totalCarbhidratos, totalGrasas, totalKcal, vitamina, numPlato);
					zConexion.insertComen(nombre_plato, nombre_user, esFavorito);
					totalProteina=0;
					totalCarbhidratos=0;
					totalGrasas=0;
					totalKcal=0;
					vitamina="";
					numPlato=0;
					ponerNombre = true;

					Platos.plato_actual.setNombre_plato(nombre_plato);					//INSERTA EL PLATO COMO FAVORITO O NO DEPENDIENDO SI SOLO SE USA O SE GUARDA
			}

	/**
	 * Método para insertar los datos necesarios en la tabla "Forman" (tabla que pone en relación las tablas "Platos" y "Alimentos"
	 */
	public void insert_Forman() throws SQLException{
	    String nombre_plato = lblTituloPlato.getText();
	    String nombre_alimento;
	    int cantidad;

	    for (int i = 0; i < Alimentosañadidos.size(); i++) {
	        cantidad = Integer.parseInt(Numerosañadidos.get(i).getText());
	        nombre_alimento = Alimentosañadidos.get(i).getText();

	        zConexion.insertForman(nombre_plato, nombre_alimento,  cantidad);
	    }
	}

	/**
	 * Método da funcionalidad al label "lblInfoCantidad", para que refleje un texto u otro según el tipo de alimento que el usuario seleccione
	 */
	//METODO PARA LABEL INFORMACION CANTIDAD/ VALORES NUTRICIONALES
	public void lblCantidad() {

		if (comboBoxTipo.getSelectedItem().equals("LIPIDO")) {
			lblInfoCantidad.setText("por cada cucharada (15ml).");

		} else if (comboBoxTipo.getSelectedItem().equals("VEGETALES") || comboBoxTipo.getSelectedItem().equals("REFRESCO") || comboBoxTipo.getSelectedItem().equals("FRUTA")) {
			lblInfoCantidad.setText("por cada unidad.");

		} else if (comboBoxTipo.getSelectedItem().equals("PASTA") || comboBoxTipo.getSelectedItem().equals("CEREALES")){
			lblInfoCantidad.setText("por cada 80 gramos.");

		} else {
			lblInfoCantidad.setText("por cada 120 gramos.");

		}
	}


	/**
	 * Método que carga la interfaz gráfica de la ventana
	 */
	public void inicialice(){

		//VENTANA INICIAL
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 610);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		//PANEL INICIAL
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//PARA ELEGIR OPCIONES PINCHANDO ENCIMA (JCOMBOBOX)
		comboBoxAlimentos = new JComboBox();
		comboBoxAlimentos.setFont(new Font("Arial Black", Font.PLAIN, 11));
		comboBoxAlimentos.setVisible(false);

		panelMensaje = new JPanel();
		panelMensaje.setVisible(false);
		panelMensaje.setBackground(new Color(240, 248, 255));
		panelMensaje.setBounds(300, 126, 181, 20);
		contentPane.add(panelMensaje);
		panelMensaje.setLayout(null);

		//LABEL MODIFICAR
		lblModificar_plato = new JLabel("Modificar nombre del plato");
		lblModificar_plato.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblModificar_plato.setBounds(0, 0, 180, 25);
		panelMensaje.add(lblModificar_plato);
		comboBoxAlimentos.setBounds(26, 106, 181, 22);
		contentPane.add(comboBoxAlimentos);

		//LABEL TITULO
		lblTitulo = new JLabel("Añade tus ingredientes favoritos y crea tu plato");
		lblTitulo.setForeground(new Color(0, 128, 128));
		lblTitulo.setBackground(new Color(248, 248, 255));
		lblTitulo.setBounds(26, 11, 432, 26);
		lblTitulo.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		contentPane.add(lblTitulo);

		//JPANEL PARA CREAR UN NUEVO PLATO
		panelPlato = new JPanel();
		panelPlato.setVisible(false);
		panelPlato.setBackground(new Color(250, 250, 210));
		panelPlato.setBounds(36, 139, 273, 387);
		contentPane.add(panelPlato);
		panelPlato.setLayout(null);

		//BOTON PARA AÑADIR EL PLATO
		btnGuardarFav = new JButton("GUARDAR");
		btnGuardarFav.setForeground(new Color(205, 133, 63));
		btnGuardarFav.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnGuardarFav.setBounds(178, 537, 128, 23);
		contentPane.add(btnGuardarFav);

		//PANEL DONDE VAN LOS VALORES NUTRICIONALES
		panelValoresNut = new JPanel();
		panelValoresNut.setBounds(338, 139, 273, 387);
		panelValoresNut.setBackground(new Color(250, 250, 210));
		contentPane.add(panelValoresNut);
		panelValoresNut.setLayout(null);

		//LABEL kCAL
		lblKCal = new JLabel("Valor energético");
		lblKCal.setFont(new Font("Sitka Text", Font.BOLD, 12));
		lblKCal.setBounds(10, 214, 103, 14);
		panelValoresNut.add(lblKCal);

		//LABEL PROTEINAS
		lblProteina = new JLabel("Proteinas");
		lblProteina.setFont(new Font("Sitka Text", Font.BOLD, 12));
		lblProteina.setBounds(10, 250, 116, 14);
		panelValoresNut.add(lblProteina);

		//LABEL CARBOHIDRATOS
		lblCarbohidrato = new JLabel("Carbohidratos");
		lblCarbohidrato.setFont(new Font("Sitka Text", Font.BOLD, 12));
		lblCarbohidrato.setBounds(10, 289, 111, 14);
		panelValoresNut.add(lblCarbohidrato);

		//LABEL GRASAS
		lblGrasas = new JLabel("Grasas");
		lblGrasas.setFont(new Font("Sitka Text", Font.BOLD, 12));
		lblGrasas.setBounds(10, 322, 111, 14);
		panelValoresNut.add(lblGrasas);

		//LABEL VITAMINAS
		lblVirtaminas = new JLabel("Vitaminas");
		lblVirtaminas.setFont(new Font("Sitka Text", Font.BOLD, 12));
		lblVirtaminas.setBounds(10, 362, 116, 14);
		panelValoresNut.add(lblVirtaminas);

		//LABEL DE LOS VALORES NUTRICIONALES
		lblPanelValores = new JLabel("Valores nutricionales:");
		lblPanelValores.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		lblPanelValores.setBounds(10, 151, 226, 14);

		//SEGUNDO PANEL DONDE APARECEN INGREDIENTES Y VALORES
		panelValoresNut.add(lblPanelValores);
		panelValoresNut.setVisible(false);

		//PARA PONER LA CANTIDAD DE ALIMENTOS QUE DESEAS MARCAR
		spinner = new JSpinner();
		spinner.setBounds(190, 40, 36, 34);
		panelValoresNut.add(spinner);
		spinner.setVisible(true);
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinner.setModel(new SpinnerNumberModel(1, 1, 5, 1));

		//LABEL DE AÑADE INGREDIENTES
		lblAñadeIngredientes = new JLabel("Añade la cantidad:");
		lblAñadeIngredientes.setBounds(10, 11, 303, 14);
		panelValoresNut.add(lblAñadeIngredientes);
		lblAñadeIngredientes.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));

		//VISUAL DEL INGREDIENTE SELECCIONADO EN EL JCOMBOBOX
		textFieldAlimentos = new JTextField();
		textFieldAlimentos.setEditable(false);
		textFieldAlimentos.setBounds(10, 40, 167, 34);
		panelValoresNut.add(textFieldAlimentos);
		textFieldAlimentos.setFont(new Font("Arial Black", Font.PLAIN, 15));
		textFieldAlimentos.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldAlimentos.setVisible(true);
		textFieldAlimentos.setColumns(10);

		//BOTON PARA QUITAR ALIMENTO SELECCIONADO
		btnQuitar = new JButton("QUITAR");
		btnQuitar.setBackground(new Color(244, 164, 96));
		btnQuitar.setForeground(new Color(248, 248, 255));
		btnQuitar.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnQuitar.setBounds(123, 85, 103, 23);
		panelValoresNut.add(btnQuitar);

		//LABEL KCAL
		lblMostrarKcal = new JLabel("..");
		lblMostrarKcal.setBounds(131, 212, 46, 14);
		panelValoresNut.add(lblMostrarKcal);

		//LABEL PROTEINA
		lblMostrarProt = new JLabel("..");
		lblMostrarProt.setBounds(132, 248, 46, 14);
		panelValoresNut.add(lblMostrarProt);

		//LABEL CARBOHIDRATO
		lblMostrarCarbo = new JLabel("..");
		lblMostrarCarbo.setBounds(131, 287, 46, 14);
		panelValoresNut.add(lblMostrarCarbo);

		//LABEL GRASAS
		lblMostrarGras = new JLabel("..");
		lblMostrarGras.setBounds(131, 320, 46, 14);
		panelValoresNut.add(lblMostrarGras);

		//LABEL VITAMINAS
		lblMostrarVit = new JLabel("..");
		lblMostrarVit.setBounds(131, 360, 46, 14);
		panelValoresNut.add(lblMostrarVit);

		//LABEL KCALU
		lblkcalU = new JLabel("Kcal.");
		lblkcalU.setBounds(190, 212, 46, 14);
		panelValoresNut.add(lblkcalU);

		//LABEL PROTEINAU
		lblProteinasU = new JLabel("gr.");
		lblProteinasU.setBounds(190, 248, 46, 14);
		panelValoresNut.add(lblProteinasU);

		//LABEL CARBOHIDRATOSU
		lblCarbohidratosU = new JLabel("gr.");
		lblCarbohidratosU.setBounds(190, 287, 46, 14);
		panelValoresNut.add(lblCarbohidratosU);

		//LABEL GRASASU
		lblGrasasU = new JLabel("gr.");
		lblGrasasU.setBounds(190, 320, 46, 14);
		panelValoresNut.add(lblGrasasU);

		//BOTON PARA VER LOS INGREDIENTES QUE LLEVA EL PLATO
		btnUsoPlato = new JButton("USAR");
		btnUsoPlato.setForeground(new Color(205, 133, 63));
		btnUsoPlato.setFont(new Font("Arial Black", Font.PLAIN, 11));

		//LABEL PARA ALMACENAR EL NOMBRE DEL PLATO
		lblTituloPlato = new JLabel("       \"NOMBRE PLATO\"", SwingConstants.CENTER);
		lblTituloPlato.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTituloPlato.setBounds(10, 7, 221, 25);
		panelPlato.add(lblTituloPlato);
		btnUsoPlato.setBounds(46, 537, 123, 22);
		contentPane.add(btnUsoPlato);

		//OPCION PARA PODER ESCOGER ENTRE LOS TIPOS DE ALIMENTOS
		comboBoxTipo = new JComboBox();
		comboBoxTipo.setToolTipText("");
		comboBoxTipo.setFont(new Font("Arial Black", Font.PLAIN, 11));
		comboBoxTipo.setBounds(26, 73, 181, 22);
		contentPane.add(comboBoxTipo);

		//BOTON PARA BUSCAR ALIMENTO
		btnBuscarAlimentos = new JButton("BUSCAR");
		btnBuscarAlimentos.setBackground(new Color(244, 164, 96));
		btnBuscarAlimentos.setForeground(new Color(248, 248, 255));
		btnBuscarAlimentos.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnBuscarAlimentos.setVisible(false);
		btnBuscarAlimentos.setBounds(217, 106, 89, 23);
		contentPane.add(btnBuscarAlimentos);

		//BOTON PARA BUSCAR TIPO
		btnBuscarTipo = new JButton("BUSCAR");
		btnBuscarTipo.setBackground(new Color(0, 128, 128));
		btnBuscarTipo.setForeground(new Color(248, 248, 255));
		btnBuscarTipo.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnBuscarTipo.setBounds(217, 72, 89, 23);
		contentPane.add(btnBuscarTipo);

		//ICONO PARA VOLVER ATRAS
		lblAtras = new JLabel("");
		lblAtras.setIcon(new ImageIcon("./src/Imagenes_Proyecto/atras.png"));
		lblAtras.setBounds(595, 11, 32, 26);
		contentPane.add(lblAtras);

		//ICONO PARA CAMBIAR DE NOMBRE AL PLATO
		lblFotoCambio_plato = new JLabel("");
		lblFotoCambio_plato.setIcon(new ImageIcon("./src/Imagenes_Proyecto/cambio_nombre_plato.png"));
		lblFotoCambio_plato.setBounds(238, 7, 25, 25);
		panelPlato.add(lblFotoCambio_plato);

		//BOTON PARA AÑADIR INGREDIENTE AL PLATO
		btnAñadir = new JButton("AÑADIR");
		btnAñadir.setBackground(new Color(0, 128, 128));
		btnAñadir.setForeground(new Color(248, 248, 255));
		btnAñadir.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnAñadir.setBounds(10, 85, 103, 23);
		panelValoresNut.add(btnAñadir);

		//LABEL INFORMACION SOBRE CANTIDAD ESTANDAR INGREDIENTE
		lblInfoCantidad = new JLabel("");
		lblInfoCantidad.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblInfoCantidad.setBounds(76, 119, 150, 14);
		panelValoresNut.add(lblInfoCantidad);
	}

	/**
	 * Método que incluye la funcionalidad de todos los botones de la pantalla
	 */

	public dPruebaingredientes() {

		inicialice();
		zConexion.conectar();

		tipoAlimentos();		//LLAMADA A LOS METODOS
		tipoNombre();

		//REINICIAMOS TODOS LOS VALORES
		Alimentosañadidos.clear();			//PONEMOS A 0 LOS DOS ARRAYS
		Numerosañadidos.clear();
		moverlbl = 0;


		//BOTON PARA ACCIONAR EL JCOMBOBOX Y QUE APAREZCAN LOS VALORES NUTRICIONALES EN LOS TEXTFIELD ---------------------------------------------
		btnBuscarAlimentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelValoresNut.setVisible(true);
				String alimento = (String)comboBoxAlimentos.getSelectedItem();
				textFieldAlimentos.setText(alimento);
				lblCantidad();
				valoresAlimentos();
			}
		});

		//INSERTAR UNA LEYENDA DEL NOMBRE Y CANTIDAD DEL PLATO EN EL PANEL AL PULSAR EL BOTON 'GUARDAR'
		btnAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panelPlato.setVisible(true);
				String elegido = textFieldAlimentos.getText();							//GUARDAMOS EL NOMBRE DEL ALIMENTO EN UNA VARIABLE EXTERNA
				JLabel lblNuevo = new JLabel();											//CREAMOS UN JLABEL NUEVO CADA VEZ QUE DEMOS AL BOTON
				lblNuevo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
				Alimentosañadidos.add(lblNuevo);										//AÑADIR OBJETO AL ARRAYLIST
				lblNuevo.setBounds(10, (67 + moverlbl), 150, 30);						//LE DAMOS LA UBICACION DONDE DEBE IR COLOCADO (AÑADIENDO VARIABLE STATIC 'MOVERLBL'
				lblNuevo.setText(elegido);												//INTRODUCIMOS EL TEXTO DE LA VARIABLE EXTERNA EN EL JLABEL
				panelPlato.add(lblNuevo);												//AÑADIMOS EL JLABEL AL PANEL DE CREAR PLATO CORRESPONDIENTE
				panelPlato.repaint();													//REFRESCAMOS EL JPANEL PARA QUE NOS MUESTRE AL INSTANTE LOS CAMBIOS

				String numeroelegido =  "" + spinner.getValue();
				JLabel lblNuevo1 = new JLabel();
				lblNuevo1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
				Numerosañadidos.add(lblNuevo1);
				lblNuevo1.setBounds(150, (67 + moverlbl), 90, 30);
				moverlbl = moverlbl +15;												//MODIFICAMOS LA VARIABLE STATIC PARA NUEVOS LABEL QUE SE VAYAN PRODUCIENDO
				lblNuevo1.setText(numeroelegido);
				panelPlato.add(lblNuevo1);
				panelPlato.repaint();

				totalNutrientes();														//ALMACENAMOS LOS VALORES PARA DESPUES
			}
		});

		//OPCION PARA PODER ESCOGER INGREDIENTES DE LOS TIPOS DE ALIMENTOS QUE HEMOS ESCOGIDO ANTERIORMENTE
		btnBuscarTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBuscarAlimentos.setVisible(true);
				comboBoxAlimentos.setVisible(true);
				tipoNombre();
			}
		});

		//BOTON QUITAR ALIMENTO DEL PANEL
		btnQuitar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                       Alimentosañadidos.get(Alimentosañadidos.size()-1).setVisible(false);	//PRIMERO LO HACE INVISIBLE
                       Numerosañadidos.get(Numerosañadidos.size()-1).setVisible(false);
                       Alimentosañadidos.remove(Alimentosañadidos.size()-1);				//SEGUNDO LO BORRA DEL ARRAY
                       Numerosañadidos.remove(Numerosañadidos.size()-1);

                       moverlbl = moverlbl - 15;											//RESETEAMOS EL LABEL PARA MOSTRAR SIGUIENTE ELEMENTO
            }
		});

		//CAMBIO DE FRAME 1
		lblAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cambioFrame1 ();
			}
		});

		//JOPTION PANE PARA CAMBIO DE NOMBRE DEL PLATO
		lblFotoCambio_plato.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ponerNombre = false;
				String nuevoCodigo = JOptionPane.showInputDialog(panelPlato, "Introduce el nuevo nombre:", "El nombre utilizado es solo si vas a guardarlo",JOptionPane.INFORMATION_MESSAGE);
				lblTituloPlato.setText(nuevoCodigo);
			}
		});

		// 1. OCULTAR MENSAJE DE CAMBIO DE NOMBRE DE PLATO
		lblFotoCambio_plato.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				panelMensaje.setVisible(true);
			}
		});

		// 2. DESOCULTAR MENSAJE DE CAMBIO DE NOMBRE DE PLATO
		panelPlato.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				panelMensaje.setVisible(false);
			}
		});

		//BOTON PARA GUARDAR EL PLATO EN FAVORITOS
		btnGuardarFav.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nombre_user= Usuario.user_actual.getNombre_usuario();
				try {
					numPlato = zConexion.numPlato(nombre_user);
					numPlato++;
					insert_Comen_Platos(1, numPlato);	// PARAMETRO 1 ( ES FAVORITO )
					insert_Forman();

					cambioFrame1 ();

				} catch (SQLException e1) {
					mostrar = new mensajeError(contentPane, "Este plato ya existe");
				}

			}
		});

		//BOTON PARA USAR EL PLATO SIN GUARDARLO EN FAVORITOS
		btnUsoPlato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					insert_Comen_Platos(0, 0);	// PARAMETRO 0 ( NO ES FAVORITO) Y PARAMETRO 0 ( VALOR DE NUMPLATO QUE ES SOLO PARA CUENTA DE PLATOS FAVORITOS )
				} catch (SQLException e1) {
					mostrar = new mensajeError(contentPane, "Error. No pulses el mismo botón repetidamente.");
				}
			}
		});

		//ACCION CADA VEZ QUE INSERTAS UNA CANTIDAD EN EL 'SPINNER' PARA MODIFICAR LOS VALORES
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				valoresAlimentos();
			}
		});
	}
}