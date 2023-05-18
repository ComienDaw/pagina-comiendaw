package Builder;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.net.URI;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Clases.Personas;
import Clases.Platos;
import Clases.Usuario;

/**
 *
 * @author Javier Martínez,Miguel Ángel de la Calle,Álvaro Martín
 * Menú principal de la aplicación, al que se accede una vez se inicia sesión o se completa el registro en la aplicación y a través de la cual se puede acceder a todas las demás pantallas disponibles
 * @param contentPane panel que contiene toda la información
 * @param panel panel que contiene los accesos a las opciones de usuario, mensajes y cerrar sesión
 * @param panel_1 panel que contiene el resumen diario
 * @param menuBar menú a través del cual podemos acceder a las distintas pantallas de la aplicación
 * @param MenuPlatos acceso al menú "platos"
 * @param MenuSeguimiento acceso al menú "seguimiento"
 * @param MenuWEB acceso al menú "página web"
 * @param mnCrear_Plato acceso a la pestaña que nos permité crear un plato con distintos alimentos
 * @param mnPlatosFav acceso a la pestaña de platos guardados por el usuario
 * @param mnPesarse acceso a la pantalla para modificar el peso y el plan del usuario
 * @param mnAcceder acceso a la página web de Nutripal
 * @param lblLogoUser label que contiene el logo del usuario
 * @param lblUsuario label que contiene el texto "usuario"
 * @param lblMensajes label que contiene el texto "mensajes"
 * @param lblCerrarSesion label que contiene el texto "cerrar sesión"
 * @param lblXSalir label que contiene la X para cerrar el menú de usuario
 * @param lblResumenDiario label que contiene el texto "resumen diario"
 * @param lblObjetivo label que contiene el texto "objetivo"
 * @param lblComentario label que contiene el texto de bienvenida del menú principal
 * @param lblProteina label que contiene el texto "proteínas"
 * @param lblCarbohidratos label que contiene el texto "carbohidratos"
 * @param lblGrasas label que contiene el texto "grasas"
 * @param lblKcalTotales label que contiene el texto "kcal totales"
 * @param progressBarKcal progressbar de las kcal totales consumidas en el día
 * @param progressBarProteina progressbar de las proteínas totales consumidas en el día
 * @param progressBarCarbohidrato progressbar de los carbohidratos totales consumidas en el día
 * @param progressBarGrasas progressbar de las grasas totales consumidas en el día
 * @param proteinas variable para almacenar el valor de las proteínas consumidas
 * @param carbohidratos variable para almacenar el valor de los carbohidratos consumidos
 * @param grasas variable para almacenar el valor de las grasas consumidas
 * @param kcal variable para almacenar el valor de las kcal consumidas
 * @param kcal_diarias variable para almacenar el valor de las kcal diarias permitidas
 * @param proteinas_diarias variable para almacenar el valor de las proteínas diarias permitidas
 * @param carbo_diarios variable para almacenar el valor de los carbohidratos diarios permitidos
 * @param grasas_diarias variable para almacenar el valor de las grasas diarias permitidas
 * @param TotalProteinas cuadro de texto donde se refleja el contador de proteínas consumidas en el día en comparación con las permitidas
 * @param TotalCarbo cuadro de texto donde se refleja el contador de carbohidratos consumidos en el día en comparación con los permitidos
 * @param TotalGrasas cuadro de texto se refleja el contador de grasas consumidas en el día en comparación con las permitidas
 * @param TotalKcal cuadro de texto donde se refleja el contador de kcal consumidas en el día en comparación con las permitidas
 */

public class cPantalla_Principal extends JFrame {

	JPanel contentPane;
	JPanel panel, panel_1;
	JMenuBar menuBar;
	JMenu MenuPlatos, MenuSeguimiento,MenuWEB;
	JMenuItem mnCrear_Plato, mnPlatosFav, mnPesarse,mnAcceder;
	JLabel lblLogoUser, lblUsuario, lblMensajes, lblCerrarSesion, lblXSalir, lblResumenDiario, lblObjetivo, lblComentario, lblProteina, lblCarbohidratos, lblGrasas, lblKcalTotales;
	JProgressBar progressBarKcal, progressBarProteina, progressBarCarbohidrato, progressBarGrasas;

	static double proteinas, carbohidratos, grasas, kcal;

	int kcal_diarias, proteinas_diarias, carbo_diarios, grasas_diarias;
	JTextField TotalProteinas;
	JTextField TotalCarbo;
	JTextField TotalGrasas;
	JTextField TotalKcal;

	/**
	 * Método main que lanza esta pestaña
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cPantalla_Principal frame = new cPantalla_Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//******************************************************************************************	CAMBIO FRAME

	/**
	 * Método que permite acceder a la pantalla de creación de platos
	 */
	public void cambioFrame1 () {
		final dPruebaingredientes dPruebaingredientes = new dPruebaingredientes ();
		dPruebaingredientes.setVisible(true);
		dispose();
	}

	/**
	 * Método que permite acceder a la pantalla de platos guardados por el usuario
	 */
	public void cambioFrame2 () {
		final ePlatos_guardados ePlatos_guardados = new ePlatos_guardados ();
		ePlatos_guardados.setVisible(true);
		dispose();
	}

	/**
	 * Método que permite acceder a la pantalla de control de peso y plan
	 */
	public void cambioFrame4 () {
		final eDiaPeso eDiaPeso = new eDiaPeso ();
		eDiaPeso.setVisible(true);
		dispose();
	}

	/**
	 * Método que permite acceder a la pantalla de datos del usuario
	 */
	public void cambioFrame5 () {
		final fUsuario fUsuario = new fUsuario ();
		fUsuario.setVisible(true);
		dispose();
	}

	/**
	 * Método que permite acceder a la pantalla de mensajes
	 */
	public void cambioFrame6 () {
		final fMensajes fMensajes = new fMensajes ();
		fMensajes.setVisible(true);
		dispose();
	}


	/**
	 * Método que permite cerrar sesión y volver a la pantalla de inicio de la aplicación
	 */
	public void cambioFrame7 () {
		final aPantalla_Inicio aPantalla_Inicio = new aPantalla_Inicio ();
		aPantalla_Inicio.setVisible(true);
		dispose();
		}

//******************************************************************************************	CAMBIO FRAME

	/**
	 * Método que permite realizar una consulta a la base de datos para recoger los platos usados en el día y mostrar la información por pantalla
	 */
	public void valoresProgressBar() {

		String nombre_user= Usuario.user_actual.getNombre_usuario();
		try {
			zConexion.recuperaTablaComen(nombre_user);

			proteinas = Platos.plato_actual.getProteina_total();
			carbohidratos = Platos.plato_actual.getCarbohidrato_total();
			grasas = Platos.plato_actual.getGrasas_total();
			kcal = Platos.plato_actual.getKcal_total();

			proteinas = proteinas *4;						//CAMBIOS RELATIVOS A EL APORTE CALORICO POR GRAMO DE CADA NUTRIENTE	[ 1GR PROTEINA = 4KCAL, 1GR CARBO = 4KCAL Y 1GR GRASAS = 9KCAL ]
			carbohidratos = carbohidratos *4;
			grasas = grasas *9;

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método que permite que el color del progressbar vaya variando en función de las cantidades que el usuario vaya consumiendo a lo largo del día
	 * @param diario parámetro 1, variable que contiene el valor de la cantidad consumida hoy
	 * @param total parámetro 2, variable que contiene el valor de la cantidad total permitida
	 */
	public Color coloresProgresBar (double diario, double total) {

		if(diario == total || (diario < (1*total) && diario > (0.9*total))) {
			return Color.GREEN;
		}else if ((diario <= 0.9*total && diario > 0.8*total) || (diario >= 1*total && diario < 1.1*total)) {
			return Color.ORANGE;
		}else if(diario>0.5*total && diario<=0.8*total || diario>=1.1*total){
			return Color.RED;
		}		else {
			return Color.white;
		}
	}

	/**
	 * Método que carga la interfaz gráfica de la ventana
	 */
	public void inicialice () {

		panel = new JPanel();
		panel.setForeground(new Color(248, 248, 255));
		panel.setBackground(new Color(0, 128, 128));

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 503);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(245, 222, 179));
		contentPane.setBackground(new Color(245, 222, 179));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		//BARRA DE HERRAMIENTAS
		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(244, 164, 96));
		menuBar.setBounds(0, 0, 372, 36);
		contentPane.add(menuBar);



		//OPCION "PLATOS" BARRA DE HERRAMIENTAS
		MenuPlatos = new JMenu("Platos y alimentos");
		MenuPlatos.setForeground(new Color(248, 248, 255));
		MenuPlatos.setBackground(new Color(0, 128, 128));
		MenuPlatos.setFont(new Font("Arial Black", Font.BOLD, 14));
		MenuPlatos.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(MenuPlatos);

		//OPCION "SEGUIMIENTO" BARRA DE HERRAMIENTAS
		MenuSeguimiento = new JMenu("Seguimiento");
		MenuSeguimiento.setForeground(new Color(248, 248, 255));
		MenuSeguimiento.setBackground(new Color(0, 128, 128));
		MenuSeguimiento.setFont(new Font("Arial Black", Font.ITALIC, 13));
		MenuSeguimiento.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(MenuSeguimiento);

		//OPCION "PÁGINA WEB" BARRA DE HERRAMIENTAS
		MenuWEB = new JMenu("Página Web");
		MenuWEB.setForeground(new Color(248, 248, 255));
		MenuWEB.setBackground(new Color(0, 128, 128));
		MenuWEB.setFont(new Font("Arial Black", Font.ITALIC, 13));
		MenuWEB.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(MenuWEB);

		panel.setVisible(false);
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		panel.setBounds(33, 346, 175, 95);
		contentPane.add(panel);
		panel.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(250, 250, 210));
		panel_1.setBounds(10, 47, 607, 372);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		//**************************************************************************************************	VALORES DE LAS BARRAS DE PROGRESO
		progressBarKcal = new JProgressBar();
		try {
			zConexion.recuperarDatosPersonales(Usuario.user_actual.getNombre_usuario());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		kcal_diarias = Usuario.user_completo.getKcal();		// KCAL DIARIAS
		progressBarKcal.setMaximum(kcal_diarias);

		progressBarKcal.setOrientation(SwingConstants.VERTICAL);
		progressBarKcal.setBounds(464, 46, 133, 285);
		panel_1.add(progressBarKcal);

		progressBarProteina = new JProgressBar();

		proteinas_diarias = (int)(kcal_diarias * 0.20);		// PROTEINAS DIARIAS
		progressBarProteina.setMaximum(proteinas_diarias);

		progressBarProteina.setBounds(181, 219, 161, 30);
		panel_1.add(progressBarProteina);

		progressBarCarbohidrato = new JProgressBar();

		carbo_diarios = (int)(kcal_diarias * 0.55);			// CARBOHIDRATOS DIARIOS
		progressBarCarbohidrato.setMaximum(carbo_diarios);

		progressBarCarbohidrato.setBounds(181, 260, 161, 30);
		panel_1.add(progressBarCarbohidrato);

		progressBarGrasas = new JProgressBar();

		grasas_diarias = (int)(kcal_diarias * 0.25);			// GRASAS DIARIAS
		progressBarGrasas.setMaximum(grasas_diarias);

		progressBarGrasas.setBounds(181, 301, 161, 30);
		panel_1.add(progressBarGrasas);
		//**************************************************************************************************

		//LABEL TITULO
		lblResumenDiario = new JLabel("Resumen diario");
		lblResumenDiario.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 20));
		lblResumenDiario.setBounds(10, 11, 205, 24);
		panel_1.add(lblResumenDiario);

		//LABEL OBJETIVO
		lblObjetivo = new JLabel("Tu objetivo de hoy:");
		lblObjetivo.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblObjetivo.setBounds(136, 53, 146, 24);
		panel_1.add(lblObjetivo);

		//LABEL COMENTARIO
		lblComentario = new JLabel("");
		lblComentario.setForeground(Color.BLACK);
		lblComentario.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblComentario.setBounds(56, 88, 398, 98);
		panel_1.add(lblComentario);

		//LABEL PROTEINA
		lblProteina = new JLabel("Proteinas");
		lblProteina.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblProteina.setBounds(38, 219, 133, 30);
		panel_1.add(lblProteina);

		//LABEL CARBOHIDRATO
		lblCarbohidratos = new JLabel("Carbohidratos");
		lblCarbohidratos.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblCarbohidratos.setBounds(38, 260, 133, 30);
		panel_1.add(lblCarbohidratos);

		//LABEL GRASAS
		lblGrasas = new JLabel("Grasas");
		lblGrasas.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblGrasas.setBounds(38, 301, 133, 30);
		panel_1.add(lblGrasas);

		//LABEL KCAL
		lblKcalTotales = new JLabel("KCal. totales");
		lblKcalTotales.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblKcalTotales.setBounds(485, 15, 112, 22);
		panel_1.add(lblKcalTotales);

		//OPCION BARRA DE HERRAMIENTAS
		mnCrear_Plato = new JMenuItem("Crear plato");
		mnCrear_Plato.setForeground(new Color(0, 128, 128));
		mnCrear_Plato.setIcon(new ImageIcon("./src/Imagenes_Proyecto/alimentos1.png"));
		mnCrear_Plato.setFont(new Font("Arial Black", Font.ITALIC, 15));
		mnCrear_Plato.setBackground(new Color(230, 230, 250));
		MenuPlatos.add(mnCrear_Plato);

		//OPCION BARRA DE HERRAMIENTAS
		mnPlatosFav = new JMenuItem("Platos guardados");
		mnPlatosFav.setForeground(new Color(0, 128, 128));
		mnPlatosFav.setIcon(new ImageIcon("./src/Imagenes_Proyecto/platos_guardados.png"));
		mnPlatosFav.setFont(new Font("Arial Black", Font.ITALIC, 15));
		mnPlatosFav.setBackground(new Color(230, 230, 250));
		MenuPlatos.add(mnPlatosFav);

		//OPCION BARRA DE HERRAMIENTAS
		mnPesarse = new JMenuItem("¡Dia de pesarse!");
		mnPesarse.setForeground(new Color(0, 128, 128));
		mnPesarse.setIcon(new ImageIcon("./src/Imagenes_Proyecto/Seg_diario1.png"));
		mnPesarse.setFont(new Font("Arial Black", Font.ITALIC, 15));
		mnPesarse.setBackground(new Color(230, 230, 250));
		MenuSeguimiento.add(mnPesarse);

		//OPCION BARRA DE HERRAMIENTAS
		mnAcceder = new JMenuItem("Acceder");
		mnAcceder.setForeground(new Color(0, 128, 128));
		mnAcceder.setIcon(new ImageIcon("./src/Imagenes_Proyecto/internet.png"));
		mnAcceder.setFont(new Font("Arial Black", Font.ITALIC, 15));
		mnAcceder.setBackground(new Color(230, 230, 250));
		MenuWEB.add(mnAcceder);

		//LABEL USUARIO
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(new Color(248, 248, 255));
		lblUsuario.setFont(new Font("Arial Black", Font.ITALIC, 17));
		lblUsuario.setBounds(10, 11, 82, 18);
		panel.add(lblUsuario);

		//LABEL COMENTARIOS
		lblMensajes = new JLabel("Mensajes");
		lblMensajes.setForeground(new Color(248, 248, 255));
		lblMensajes.setFont(new Font("Arial Black", Font.ITALIC, 17));
		lblMensajes.setBounds(10, 40, 123, 18);
		panel.add(lblMensajes);

		// 'X' PARA CERRAR (ICONO)
		lblCerrarSesion = new JLabel("Cerrar sesión");
		lblCerrarSesion.setForeground(new Color(248, 248, 255));
		lblCerrarSesion.setFont(new Font("Arial Black", Font.ITALIC, 17));
		lblCerrarSesion.setBounds(10, 69, 137, 18);
		panel.add(lblCerrarSesion);

		//FOTO DE USUARIO (ICONO)
		lblLogoUser = new JLabel("New label");
		lblLogoUser.setIcon(new ImageIcon("./src/Imagenes_Proyecto/Imagen usuario.png"));
		lblLogoUser.setBounds(0, 423, 46, 36);
		contentPane.add(lblLogoUser);

		//LABEL SALIR DEL SUBMENÚ DE USUARIO
		lblXSalir = new JLabel("New label");
		lblXSalir.setIcon(new ImageIcon("./src/Imagenes_Proyecto/salir1.png"));
		lblXSalir.setBounds(140, 11, 25, 25);
		panel.add(lblXSalir);

		//PARA VER  EL TOTAL QUE LLEVAS EN EL DIA DE PROTEINAS
		TotalProteinas = new JTextField();
		TotalProteinas.setHorizontalAlignment(SwingConstants.CENTER);
		TotalProteinas.setFont(new Font("Arial Black", Font.PLAIN, 9));
		TotalProteinas.setEditable(false);
		TotalProteinas.setBounds(376, 219, 66, 30);
		panel_1.add(TotalProteinas);
		TotalProteinas.setColumns(10);

		//PARA VER  EL TOTAL QUE LLEVAS EN EL DIA DE CARBOHIDRATOS
		TotalCarbo = new JTextField();
		TotalCarbo.setHorizontalAlignment(SwingConstants.CENTER);
		TotalCarbo.setFont(new Font("Arial Black", Font.PLAIN, 9));
		TotalCarbo.setEditable(false);
		TotalCarbo.setColumns(10);
		TotalCarbo.setBounds(376, 260, 66, 30);
		panel_1.add(TotalCarbo);

		//PARA VER  EL TOTAL QUE LLEVAS EN EL DIA DE GRASAS
		TotalGrasas = new JTextField();
		TotalGrasas.setHorizontalAlignment(SwingConstants.CENTER);
		TotalGrasas.setFont(new Font("Arial Black", Font.PLAIN, 9));
		TotalGrasas.setEditable(false);
		TotalGrasas.setColumns(10);
		TotalGrasas.setBounds(376, 301, 66, 30);
		panel_1.add(TotalGrasas);

		//PARA VER  EL TOTAL QUE LLEVAS EN EL DIA DE KCAL
		TotalKcal = new JTextField();
		TotalKcal.setHorizontalAlignment(SwingConstants.CENTER);
		TotalKcal.setFont(new Font("Arial Black", Font.PLAIN, 12));
		TotalKcal.setBounds(464, 332, 133, 30);
		panel_1.add(TotalKcal);
		TotalKcal.setColumns(10);



	}

	/**
	 * Método que incluye la funcionalidad de todos los botones de la pantalla
	 */
	public cPantalla_Principal() {

		inicialice();

		valoresProgressBar();

		progressBarKcal.setValue((int)kcal);
		progressBarProteina.setValue((int)proteinas);
		progressBarCarbohidrato.setValue((int)carbohidratos);
		progressBarGrasas.setValue((int)grasas);
		repaint();


		//MOSTRAR MENSAJE BIENVENIDA
		String nombreUser = Personas.px_actual.getNombre();

		lblComentario.setText("<html><center>¡Hola <font color='green' size='+1'>" + nombreUser + "</font>! <br> Recuerda que el total de Kilocalorias <br>que puedes consumir hoy no puede pasar de <font color='green' size='+1'>" + kcal_diarias + "</font>.<br> "
				+ "<font color='purple' size='+1'>¡¡Ánimo y a por todas!!</font></center></html>");

		//FORMATO PARA DARLE DECIMALES NECESARIOS A LOS NUMEROS (MOSTRAR EL INCICADOR DE LOS VALORES NUTRICIONALES DIARIOS)
		DecimalFormat df = new DecimalFormat("#");
		df.setMaximumFractionDigits(0);

		TotalKcal.setText(df.format(proteinas + carbohidratos + grasas) + " / " + df.format(kcal_diarias));
		TotalProteinas.setText(df.format(proteinas) + " / " + df.format((kcal_diarias * 0.20)));
		TotalCarbo.setText(df.format(carbohidratos) + " / " + df.format((kcal_diarias * 0.55)));
		TotalGrasas.setText(df.format(grasas) + " / " + df.format((kcal_diarias * 0.25)));

		//CAMBIO DE COLORES DEL TEXTFIELD
		TotalProteinas.setBackground(coloresProgresBar(proteinas, (kcal_diarias * 0.20)));
		TotalCarbo.setBackground(coloresProgresBar(carbohidratos, (kcal_diarias * 0.55)));
		TotalGrasas.setBackground(coloresProgresBar(grasas, (kcal_diarias * 0.25)));
		TotalKcal.setBackground(coloresProgresBar((proteinas + carbohidratos + grasas), kcal_diarias));

//********************************************************************************************************************************************************	CAMBIO DE FRAME
		//CAMBIO DE FRAME 1
		mnCrear_Plato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambioFrame1 ();
			}
		});

		//CAMBIO DE FRAME 2
		mnPlatosFav.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambioFrame2();
			}
		});

		//CAMBIO DE FRAME 4
		mnPesarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambioFrame4 ();
			}
		});

		//ACCESO A LA PÁGINA WEB DE NUTRIPAL
		mnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				 try {
			            Desktop.getDesktop().browse(new URI("https://comiendaw.github.io/pagina-nutripal/"));
			        } catch (Exception ex) {
			            ex.printStackTrace();
			        }

			}
		});

		//CAMBIO DE FRAME 5
		lblUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cambioFrame5 ();
			}
		});

		//CAMBIO DE FRAME 6
		lblMensajes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cambioFrame6 ();
			}
		});

		//CAMBIO DE FRAME 7
		lblCerrarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cambioFrame7 ();
			}
		});

//********************************************************************************************************************************************************	CAMBIO DE FRAME

		//IMAGEN DEL EMOTICONO DE USUARIO QUE TE ABRE UN SUBMENU
		lblLogoUser.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				panel.setVisible(true);
			}
		});

		//EN LE MENU DEL USUARIO, X SUPERIOR QUE HAY PARA CERRAR EL MENU
		lblXSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				panel.setVisible(false);
			}
		});

//******************************************************************************************************************************************************** VALORES DEL PROGRESSBAR


	}
}
