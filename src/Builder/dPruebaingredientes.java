package Builder;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class dPruebaingredientes extends JFrame {

	JPanel contentPane,panelValoresNut, panelPlato, PanelTextoCambiaNombre_Plato;
	JButton btnBuscarAlimentos,btnQuitar,btnAñadir,btnBuscarTipo,btnGuardarFav,btnUsoPlato;
	JLabel lblAtras, lblKCal,lblProteina,lblCarbohidrato,lblGrasas,lblVirtaminas,lblTitulo,lblMostrarKcal,lblMostrarProt,lblMostrarCarbo,lblMostrarGras,lblMostrarVit,lblkcalU,lblProteinasU,lblCarbohidratosU,lblGrasasU,lblPorcionGr,lblPanelValores, lblAñadeIngredientes, lblTituloPlato;
	JSpinner spinner;
	JTextField textFieldAlimentos;
	JComboBox comboBoxAlimentos;

	private static int moverlbl = 0;			//VARIABLE STATIC PARA MOVER LOS JLABEL DEL BOTON CREAR PLATO
	public static int indice = 0;

	public  ePlatos_guardados pg;					//INSTANCIA DE LA CLASE 'PLATOS_GUARDADOS' EN OTRO FRAME
	aPantalla_Inicio pi;
	
	ArrayList <JPanel> Alimentosplatos = new ArrayList <JPanel>();
	private JLabel lblNewLabel;
	private JLabel lblCambioNombre_Plato;
	private JLabel lblNewLabel_1;


	public void mostrar () {
		setVisible(true);
	}

	public void inicialice(){
		
		//VENTANA INICIAL		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 610);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 222, 179));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		//PANEL INICIAL
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//PARA ELEGIR OPCIONES PINCHANDO ENCIMA (JCOMBOBOX)
		comboBoxAlimentos = new JComboBox();
		comboBoxAlimentos.setFont(new Font("Arial Black", Font.PLAIN, 11));
		comboBoxAlimentos.setVisible(false);
		
		PanelTextoCambiaNombre_Plato = new JPanel();
		PanelTextoCambiaNombre_Plato.setBounds(304, 126, 169, 26);
		contentPane.add(PanelTextoCambiaNombre_Plato);
		PanelTextoCambiaNombre_Plato.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Cambia el nombre del plato");
		lblNewLabel_1.setForeground(new Color(0, 128, 128));
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 9));
		lblNewLabel_1.setBounds(10, 0, 160, 31);
		PanelTextoCambiaNombre_Plato.add(lblNewLabel_1);
		PanelTextoCambiaNombre_Plato.setVisible(false);
		comboBoxAlimentos.setBounds(26, 106, 181, 22);
		contentPane.add(comboBoxAlimentos);
		
		//AÑADIR LAS OPCIONES AL COMBOBOX
		comboBoxAlimentos.addItem("Patata");
		comboBoxAlimentos.addItem("Cebolla");
		comboBoxAlimentos.addItem("Pimiento rojo");
		comboBoxAlimentos.addItem("Pimiento verde");
		comboBoxAlimentos.addItem("Esparrago");
		comboBoxAlimentos.addItem("Ajo");
		comboBoxAlimentos.addItem("Judia");
		comboBoxAlimentos.addItem("Lenteja");
		
		//LABEL TITULO
		lblTitulo = new JLabel("Añade tus ingredientes favoritos y crea tu plato");
		lblTitulo.setForeground(new Color(0, 128, 128));
		lblTitulo.setBounds(26, 11, 447, 26);
		lblTitulo.setFont(new Font("Arial Black", Font.BOLD, 16));
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
		btnGuardarFav.setBackground(new Color(0, 128, 128));
		btnGuardarFav.setForeground(new Color(245, 245, 245));
		btnGuardarFav.setFont(new Font("Arial Black", Font.BOLD, 11));
//		btnGuardarFav.addActionListener( e -> activaFrame());
		btnGuardarFav.setBounds(178, 537, 128, 23);
		contentPane.add(btnGuardarFav);
		
		//PANEL DONDE VAN LOS VALORES NUTRICIONALES
		panelValoresNut = new JPanel();
		panelValoresNut.setForeground(new Color(0, 128, 128));
		panelValoresNut.setBounds(338, 139, 273, 387);
		panelValoresNut.setBackground(new Color(250, 250, 210));
		contentPane.add(panelValoresNut);
		panelValoresNut.setLayout(null);
		
		//LABEL kCAL
		lblKCal = new JLabel("Valor energético");
		lblKCal.setForeground(new Color(0, 128, 128));
		lblKCal.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblKCal.setBounds(10, 214, 116, 14);
		panelValoresNut.add(lblKCal);
		
		//LABEL PROTEINAS
		lblProteina = new JLabel("Proteinas");
		lblProteina.setForeground(new Color(0, 128, 128));
		lblProteina.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblProteina.setBounds(10, 250, 116, 14);
		panelValoresNut.add(lblProteina);
		
		//LABEL CARBOHIDRATOS
		lblCarbohidrato = new JLabel("Carbohidratos");
		lblCarbohidrato.setForeground(new Color(0, 128, 128));
		lblCarbohidrato.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblCarbohidrato.setBounds(10, 289, 111, 14);
		panelValoresNut.add(lblCarbohidrato);
		
		//LABEL GRASAS
		lblGrasas = new JLabel("Grasas");
		lblGrasas.setForeground(new Color(0, 128, 128));
		lblGrasas.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblGrasas.setBounds(10, 322, 111, 14);
		panelValoresNut.add(lblGrasas);
		
		//LABEL VITAMINAS
		lblVirtaminas = new JLabel("Vitaminas");
		lblVirtaminas.setForeground(new Color(0, 128, 128));
		lblVirtaminas.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblVirtaminas.setBounds(10, 362, 116, 14);
		panelValoresNut.add(lblVirtaminas);
		
		//LABEL DE LOS VALORES NUTRICIONALES
		lblPanelValores = new JLabel("Valores nutrionales:");
		lblPanelValores.setForeground(new Color(0, 128, 128));
		lblPanelValores.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblPanelValores.setBounds(49, 151, 187, 14);
		
		//SEGUNDO PANEL DONDE APARECEN INGREDIENTES Y VALORES
		panelValoresNut.add(lblPanelValores);
		panelValoresNut.setVisible(false);
		
		//PARA PONER LA CANTIDAD DE ALIMENTOS QUE DESEAS MARCAR
		spinner = new JSpinner();
		spinner.setBounds(190, 40, 36, 34);
		panelValoresNut.add(spinner);
		spinner.setVisible(false);
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinner.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		
		//LABEL DE AÑADE INGREDIENTES
		lblAñadeIngredientes = new JLabel("Añade la cantidad:");
		lblAñadeIngredientes.setForeground(new Color(205, 133, 63));
		lblAñadeIngredientes.setBounds(10, 11, 303, 14);
		panelValoresNut.add(lblAñadeIngredientes);
		lblAñadeIngredientes.setFont(new Font("Arial Black", Font.BOLD, 15));
		
		//VISUAL DEL INGREDIENTE SELECCIONADO EN EL JCOMBOBOX
		textFieldAlimentos = new JTextField();
		textFieldAlimentos.setBounds(10, 40, 167, 34);
		panelValoresNut.add(textFieldAlimentos);
		textFieldAlimentos.setFont(new Font("Arial Black", Font.PLAIN, 15));
		textFieldAlimentos.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldAlimentos.setVisible(false);
		textFieldAlimentos.setColumns(10);
		
		//BOTON PARA QUITAR ALIMENTO SELECCIONADO
		btnQuitar = new JButton("QUITAR");
		btnQuitar.setBackground(new Color(0, 128, 128));
		btnQuitar.setForeground(new Color(245, 245, 245));
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
		lblkcalU.setForeground(new Color(205, 133, 63));
		lblkcalU.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblkcalU.setBounds(190, 212, 46, 14);
		panelValoresNut.add(lblkcalU);
		
		//LABEL PROTEINAU
		lblProteinasU = new JLabel("gr.");
		lblProteinasU.setForeground(new Color(205, 133, 63));
		lblProteinasU.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblProteinasU.setBounds(190, 248, 46, 14);
		panelValoresNut.add(lblProteinasU);
		
		//LABEL CARBOHIDRATOSU
		lblCarbohidratosU = new JLabel("gr.");
		lblCarbohidratosU.setForeground(new Color(205, 133, 63));
		lblCarbohidratosU.setBackground(new Color(205, 133, 63));
		lblCarbohidratosU.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblCarbohidratosU.setBounds(190, 287, 46, 14);
		panelValoresNut.add(lblCarbohidratosU);
		
		//LABEL GRASASU
		lblGrasasU = new JLabel("gr.");
		lblGrasasU.setForeground(new Color(205, 133, 63));
		lblGrasasU.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblGrasasU.setBounds(190, 320, 46, 14);
		panelValoresNut.add(lblGrasasU);
		
		//LABEL TAMAÑO DE LA PORCION
		lblPorcionGr = new JLabel("Tamaño de la porción 100gr.");
		lblPorcionGr.setForeground(new Color(205, 133, 63));
		lblPorcionGr.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblPorcionGr.setBounds(49, 176, 199, 14);
		panelValoresNut.add(lblPorcionGr);	
		
		//BOTON PARA VER LOS INGREDIENTES QUE LLEVA EL PLATO
		btnUsoPlato = new JButton("USAR");
		btnUsoPlato.setBackground(new Color(0, 128, 128));
		btnUsoPlato.setForeground(new Color(245, 255, 250));
		btnUsoPlato.setFont(new Font("Arial Black", Font.BOLD, 11));
		
		//LABEL PARA ALMACENAR EL NOMBRE DEL PLATO
		lblTituloPlato = new JLabel("       \"NOMBRE PLATO\"");
		lblTituloPlato.setForeground(new Color(205, 133, 63));
		lblTituloPlato.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblTituloPlato.setBounds(0, 8, 253, 25);
		panelPlato.add(lblTituloPlato);
		
		lblCambioNombre_Plato = new JLabel("New label");
		lblCambioNombre_Plato.setIcon(new ImageIcon("C:\\Users\\migue\\OneDrive\\Documentos\\FP\\PROYECTO FINAL PROGRA-ENTORNOS-BASES\\IMAGENES\\cambio_nombre_plato.png"));
		lblCambioNombre_Plato.setBounds(238, 8, 25, 25);
		panelPlato.add(lblCambioNombre_Plato);

//		btnUsoPlato.addActionListener(e -> Cambio());			
		btnUsoPlato.setBounds(46, 537, 123, 22);
		contentPane.add(btnUsoPlato);
		
		
	}
 
	public dPruebaingredientes(aPantalla_Inicio pi) {			
		
		this.pi = pi;
		inicialice();
		
		//CREA EL FRAME DE PLATOS FAVORITOS
//		pg = new ePlatos_guardados();

		//CLASE PARA METER TODOS LOS ALIMENTOS CON SUS PARAMETROS
		class Alimentos {


			private String nombre, tipo, proteina, carbohidrato, grasas, kcal, vitamina;

			public Alimentos (String nombre, String tipo, String proteina, String carbohidrato, String grasas, String kcal, String vitamina) {

				this.nombre = nombre;
				this.tipo = tipo;
				this.proteina = proteina;
				this.carbohidrato = carbohidrato;
				this.grasas = grasas;
				this.kcal = kcal;
				this.vitamina = vitamina;
			}
			public String getNombre () {
				return this.nombre;
			}
			public String gettipo() {
				return this.tipo;
			}
		}

		//ARRAYLIST CON TODOS LOS ALIMENTOS --------------------------------------------------------------------------------------------------------
		List<Alimentos> listaAlimentos = new ArrayList<Alimentos>();
		
		//ELEMENTOS DEL ARRAYLIST CON LOS PARAMETROS
		Alimentos al1 		= 	new Alimentos ("Patata", "Vegetales","20","30","2","100","A");
		Alimentos al2		= 	new Alimentos ("Cebolla", "Carne","10","20","0.5","80","A");
		Alimentos al3		=	new Alimentos ("Pimiento rojo", "Pasta","11","34","1","87","A");
		Alimentos al4 		= 	new Alimentos ("Pimiento verde","Vegetales","17","70","3.2","16","A");
		Alimentos al5 		= 	new Alimentos ("Esparrago","Carne","23","31","2.1","78","A");
		Alimentos al6		= 	new Alimentos ("Ajo", "Pasta","34","12","2.5","34","A");
		Alimentos al7 		= 	new Alimentos ("Judia", "Vegetales","28","10","2","56","A");
		Alimentos al8 		= 	new Alimentos ("Lenteja", "Pasta","21","32","1","108","A");
		
		//AÑADIR LOS ALIMENTOS AL ARRAYLIST
		listaAlimentos.add(al1);listaAlimentos.add(al2);listaAlimentos.add(al3);listaAlimentos.add(al4);
		listaAlimentos.add(al5);listaAlimentos.add(al6);listaAlimentos.add(al7);listaAlimentos.add(al8);

		//BOTON PARA ACCIONAR EL JCOMBOBOX Y QUE APAREZCAN LOS VALORES NUTRICIONALES EN LOS TEXTFIELD ---------------------------------------------
		btnBuscarAlimentos = new JButton("BUSCAR");
		btnBuscarAlimentos.setBackground(new Color(0, 128, 128));
		btnBuscarAlimentos.setForeground(new Color(245, 245, 245));
		btnBuscarAlimentos.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnBuscarAlimentos.setVisible(false);
		btnBuscarAlimentos.setBounds(217, 106, 89, 23);
		btnBuscarAlimentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String objeto = (String) comboBoxAlimentos.getSelectedItem();

				for (Alimentos comida : listaAlimentos) {
					if (objeto.equals(comida.getNombre())) {
						panelValoresNut.setVisible(true);
						lblMostrarKcal.setText(comida.kcal);
						lblMostrarProt.setText(comida.proteina);
						lblMostrarCarbo.setText(comida.carbohidrato);
						lblMostrarGras.setText(comida.grasas);
						lblMostrarProt.setText(comida.proteina);
						lblMostrarVit.setText(comida.vitamina);
						spinner.setVisible(true);
						textFieldAlimentos.setVisible(true);
						textFieldAlimentos.setText(objeto);
					}
				}
			}
		});
		contentPane.add(btnBuscarAlimentos);

		//LABEL AÑADIR ALIMENTO ----------------------------------------------------------------------------------------------------------
		btnAñadir = new JButton("AÑADIR");
		btnAñadir.setBackground(new Color(0, 128, 128));
		btnAñadir.setForeground(new Color(245, 245, 245));
		btnAñadir.setFont(new Font("Arial Black", Font.PLAIN, 11));

		ArrayList <JLabel> Alimentosañadidos = new ArrayList <JLabel>();				//DECLARAR ARRAYLIST DE OBJETOS JLABEL (NOMBRES ALIMENTOS)
		ArrayList <JLabel> Numerosañadidos = new ArrayList <JLabel>();					//DECLARAR ARRAYLIST DE OBJETOS JLABEL (NUMEROS)

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
				
				//ALMACENAR LA CANTIDAD QUE QUIERE USAR EN UN PLATO DE UN MISMO INGREDIENTE
				int cantidad = (int)spinner.getValue();
			}
		});

		btnAñadir.setBounds(10, 85, 103, 23);
		panelValoresNut.add(btnAñadir);

		//OPCION PARA PODER ESCOGER ENTRE LOS TIPOS DE ALIMENTOS
		JComboBox comboBoxTipo = new JComboBox();
		comboBoxTipo.setFont(new Font("Arial Black", Font.PLAIN, 11));
		comboBoxTipo.setBounds(26, 73, 181, 22);			
		comboBoxTipo.addItem("Pasta");
		comboBoxTipo.addItem("Vegetales");
		comboBoxTipo.addItem("Carne");
		contentPane.add(comboBoxTipo);
		
		//OPCION PARA PODER ESCOGER INGREDIENTES DE LOS TIPOS DE ALIMENTOS QUE HEMOS ESCOGIDO ANTERIORMENTE
		btnBuscarTipo = new JButton("BUSCAR");
		btnBuscarTipo.setBackground(new Color(0, 128, 128));
		btnBuscarTipo.setForeground(new Color(245, 245, 245));
		btnBuscarTipo.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnBuscarTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				comboBoxAlimentos.setVisible(true);	
				btnBuscarAlimentos.setVisible(true);

				comboBoxAlimentos.removeAllItems();
				String tipo = (String) comboBoxTipo.getSelectedItem();

				for (Alimentos X : listaAlimentos) {
					if (tipo.equals(X.gettipo())) {
						comboBoxAlimentos.addItem(X.getNombre());
					}
				}
			}
		});
		btnBuscarTipo.setBounds(217, 72, 89, 23);
		contentPane.add(btnBuscarTipo);		
		
		//BOTON QUITAR ALIMENTO -----------------------------------------------------------------------------------
		btnQuitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Alimentosañadidos.get(Alimentosañadidos.size()-1).setVisible(false);
				Numerosañadidos.get(Numerosañadidos.size()-1).setVisible(false);
				Alimentosañadidos.remove(Alimentosañadidos.size()-1);
				Numerosañadidos.remove(Numerosañadidos.size()-1);

				moverlbl = moverlbl - 15;

			}
		});

		//IMAGEN PARA VOLVER ATRAS A CPANTALLA_PRINCIPAL
		lblAtras = new JLabel("");
		lblAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pi.pp.mostrar();
				setVisible(false);
			}
		});
		lblAtras.setIcon(new ImageIcon("C:\\Users\\migue\\OneDrive\\Documentos\\FP\\PROYECTO FINAL PROGRA-ENTORNOS-BASES\\IMAGENES\\atras.png"));
		lblAtras.setBounds(579, 11, 48, 38);
		contentPane.add(lblAtras);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\migue\\OneDrive\\Documentos\\FP\\PROYECTO FINAL PROGRA-ENTORNOS-BASES\\IMAGENES\\logo_comiendawsintexto80x76.png"));
		lblNewLabel.setBounds(504, 44, 76, 82);
		contentPane.add(lblNewLabel);

		//CARTEL QUE APARECE O DESAPARECE CUANDO PASAS POR ENCIMA DEL BOTON DE CAMBIAR PLATO O NO 
		panelPlato.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
			
				PanelTextoCambiaNombre_Plato.setVisible(false);
			}
		});
		lblCambioNombre_Plato.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				PanelTextoCambiaNombre_Plato.setVisible(true);
					
			}
		});
		
		btnGuardarFav.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pi.pg.mostrarCambio();
			}
		});
		
		lblCambioNombre_Plato.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String nombre_plato = JOptionPane.showInputDialog(panelPlato,"Introduce nuevo nombre para el plato:","CAMBIAR NOMBRE", JOptionPane.INFORMATION_MESSAGE);
			
				lblTituloPlato.setText(nombre_plato);
				
			}
		});
		

	}
}
