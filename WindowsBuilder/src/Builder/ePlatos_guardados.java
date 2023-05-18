package Builder;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import Clases.Personas;
import Clases.Platos;
import Clases.Usuario;

/**
 * @author Javier Martínez,Miguel Ángel de la Calle,Álvaro Martín
 * Esta pestaña se encarga de mostrar la informacion de los platos guardados del usuario que está conectado en la aplicación
 * Aparte de mostrarte todos los platos que has ido guardando podrás volver a utilizarlos sin la necesidad de volver a crear dicho plato
 * @param contentPane_PlatosGuardados panel que contiene toda la información de la ventana
 * @param panel1 panel que almacena la información del plato favorito
 * @param moverpanel indice que se utiliza para mover las posiciones de los paneles en los que se alojan los platos favoritos a medida que se van insertando nuevos platos
 * @param moverpanel2 indice que se utiliza para mover las posiciones de los paneles en los que se alojan los platos favoritos a medida que se van insertando nuevos platos
 * @param indice indice que se utiliza para mover las posiciones de los paneles en los que se alojan los platos favoritos a medida que se van insertando nuevos platos
 * @param lblTituloPlato label que contiene el título del plato
 * @param lblTitulo label que contiene el título de la pestaña
 * @param lblAtras label con el que volvemos atrás, al menú principal de la aplicación
 * @param lblCarbo label en el que se muestra la cantidad total de carbohidratos que tiene un plato
 * @param lblGrasas label en el que se muestra la cantidad total de carbohidratos que tiene un plato
 * @param lblKcal label en el que se muestra la cantidad total de kcal que tiene un plato
 * @param lblVitaminas label en el que se muestra la cantidad total de vitaminas que tiene un plato
 * @param lblProteinas label en el que se muestra la cantidad total de proteínas que tiene un plato
 * @param btnDrch botón para avanzar a la siguiente página de platos favoritos
 * @param btnIzq botón para retroceder a la página anterior de platos favoritos
 * @param btnUsar botón para usar el plato
 * @param textField texField que contiene el texto con todos los valores del plato
 * @param numIzq variables de los platos que se van a ir mostrando por pantalla (siempre serán seis)
 * @param numDch variables de los platos que se van a ir mostrando por pantalla (siempre serán seis)
 * @param num variable que alamacena el número de platos que hay por página
 * @param contador variable que alamacena el número total de páginas de platos favoritos creadas
 * @param paginaActual variable que alamacena el número de la página actual de platos favoritos en la que se encuentra el usuario
 * @param flechaIzq variable de tipo boolean que se muestra a true o false según haya o no página anterior de platos favoritos
 * @param flechaDch variable de tipo boolean que se muestra a true o false según haya o no página posterior de platos favoritos
 * @param Alimentosplatos arrayList que almacena los contenedores creados con cada plato que se guarda como favorito
 *
 *
 */
public class ePlatos_guardados extends JFrame {

	JPanel contentPane_PlatosGuardados;
	JPanel panel1;

	static int moverpanel = 0;		//MOVER LOS NUEVOS PANELES DE PLATOS FAVORITOS
	static int moverpanel2 = 0;
	static int indice = 0;

	JLabel lblTituloPlato, lblTitulo, lblAtras, lblCarbo, lblGrasas, lblKcal, lblVitaminas, lblProteinas;
	JButton btnDrch, btnIzq, btnUsar;
	JTextField textField;
	mensajeError mostrar;

	//VARIABLES DE LOS PLATOS QUE SE VAN A IR MOSTRANDO POR PANTALLA (SIEMPRE SERÁN 6)
	int numIzq = 1, numDch = 6;

	int num;
	static int contador = 1;

	int paginaActual = 1;
	static boolean flechaIzq = true;	//VISIBLE
	static boolean flechaDch = true;	//VISIBLE

	ArrayList <JPanel> Alimentosplatos = new ArrayList <>();


	/**
	 * Método main que lanza esta pestaña
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ePlatos_guardados frame = new ePlatos_guardados();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Método para hacer visibles o no las flechas para acceder a la siguiente página de platos favoritos, si la hubiese
	 */

	public void mostrarFlecha() {

			if(paginaActual == 1 && contador == 1 ) {	//SI HAY 1 SOLA PAGINA
				flechaIzq = false;
				flechaDch = false;
			}else if (paginaActual == 1) {				//SI TIENE MAS DE UNA PÁGINA PERO ESTA UBICADO EN LA PRIMERA
				flechaIzq = false;
				flechaDch = true;
			}else if (paginaActual == contador) {		//SI ESTA EN LA ULTIMA PÁGINA
				flechaIzq = true;
				flechaDch = false;
			}else {										//SI ESTA EN LAS PAGINAS DE EN MEDIO
				flechaIzq = true;
				flechaDch = true;
			}
	}

	/**
	 * Método para mostrar los platos favoritos que tiene el usuario, con los datos alimenticios totales de dichos platos
	 */

	public void mostrarCambio (String id_plato, double total_prot, double total_carbo, double total_gras, double total_kcal) {

		//****************************************************************************	GENERAR PANEL Y LOS LABEL
		panel1 = new JPanel();
		panel1.setBounds((10 + moverpanel), (49 + moverpanel2), 197, 184);
		moverpanel = moverpanel + 207;
		contentPane_PlatosGuardados.add(panel1);
		Alimentosplatos.add(panel1);
		panel1.setBackground(new Color(250, 250, 210));
		panel1.setLayout(null);
		contentPane_PlatosGuardados.repaint();

		lblTituloPlato = new JLabel(id_plato);
		lblTituloPlato.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		lblTituloPlato.setBounds(10,11,177,32);
		panel1.add(lblTituloPlato);
		lblTituloPlato.setVisible(true);

		btnUsar = new JButton("Usar");						// CADA VEZ QUE USAS UN PLATO

		btnUsar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nombre_user = Usuario.user_actual.getNombre_usuario();
				try {
					zConexion.insertComen(id_plato, nombre_user, 0);
				} catch (SQLException e1) {
					mostrar = new mensajeError(contentPane_PlatosGuardados, "Error. No pulses el mismo botón repetidamente.");
				}
			}
		});

		btnUsar.setBounds(98, 150, 89, 23);
		panel1.add(btnUsar);

		lblCarbo = new JLabel("Carbohidratos: " + total_carbo);
		lblCarbo.setBounds(10, 72, 177, 14);
		lblCarbo.setForeground(Color.BLACK);
		panel1.add(lblCarbo);

		lblGrasas = new JLabel("Grasas: " + total_gras);
		lblGrasas.setBounds(10, 88, 177, 14);
		lblGrasas.setForeground(Color.BLACK);
		panel1.add(lblGrasas);

		lblKcal = new JLabel("Kcal: " + total_kcal);
		lblKcal.setBounds(10, 104, 177, 14);
		lblKcal.setForeground(Color.BLACK);
		panel1.add(lblKcal);

		lblProteinas = new JLabel("Proteinas: " + total_prot);
		lblProteinas.setBounds(10, 120, 177, 14);
		lblProteinas.setForeground(Color.BLACK);
		panel1.add(lblProteinas);
		//****************************************************************************	GENERAR PANEL Y LOS LABEL

		indice++;

		//ESTA PARTE SOLO ES PARA GERERAR LOS PANEL QUE SE IRAN VIENDO Y EL DESPLAZAMIENTO DE LOS 'JPANEL'
		//YA QUE SOLO 8 'JPANEL' A LA VEZ PUEDEN VERSE POR PANTALLA
		if (indice == 3) {
			moverpanel = 0;
			moverpanel2 = moverpanel2 +195;
		}else if (indice == 6) {
			moverpanel = 0;
			moverpanel2 = 0;

			indice = 0;
		}

		//*********************************************************************** COMO HAY UN REMOVEALL PARA VOLVER A GENERAR TITULO, LABEL(ATRAS), BOTONES E INDICADOR DE NUEVO
		//ICONO PARA VOLVER ATRAS A CPANTALLA_PRINCIPAL, EN ESTA PANTALLA TIENE QUE IR AQUÍ Y NO EN EL MÉTODOINICIALICE() PORQUE SI NO NO SALÍA SI EL USUARIO AÚN NO HABÍA GUARDADO PLATOS
		lblAtras = new JLabel("");
		lblAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cambioFrame1 ();
			}
		});
		lblAtras.setIcon(new ImageIcon("./src/Imagenes_Proyecto/atras.png"));
		lblAtras.setBounds(588, 10, 29, 32);
		contentPane_PlatosGuardados.add(lblAtras);
		//METODO PARA ACTUALIZAR VALORES DE LOS SETVISIBLE DE LAS FLECHAS
		mostrarFlecha();

		//ACCION BOTON DERECHA ENTRE LAS PAGINAS DE PLATOS FAVORITOS	*********************************************
		btnDrch = new JButton(">>>>>>");
		btnDrch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				paginaActual++;
				btnDrch.setVisible(flechaDch);
				btnIzq.setVisible(flechaIzq);

				numIzq = numIzq + 6;
				numDch = numDch + 6;
				try {
					contentPane_PlatosGuardados.removeAll();
					indice = 0;
					moverpanel = 0;
					moverpanel2 = 0;
					mostrarPaneles();
					repaint();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				}
		});
		btnDrch.setBounds(338, 430, 89, 23);
		contentPane_PlatosGuardados.add(btnDrch);

		//ACCION BOTON IZQUIERDA ENTRE LAS PAGINAS DE PLATOS FAVORITOS	*************************************
		btnIzq = new JButton("<<<<<<");
		btnIzq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				paginaActual--;
				btnDrch.setVisible(flechaDch);
				btnIzq.setVisible(flechaIzq);



				numIzq = numIzq - 6;
				numDch = numDch - 6;
				try {
					contentPane_PlatosGuardados.removeAll();
					indice = 0;
					moverpanel = 0;
					moverpanel2 = 0;
					mostrarPaneles();
					repaint();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnIzq.setBounds(200, 430, 89, 23);
		contentPane_PlatosGuardados.add(btnIzq);

		//TITULO DEL FRAME
		lblTitulo = new JLabel("PLATOS GUARDADOS");
		lblTitulo.setBounds(189, 10, 250, 36);
		lblTitulo.setFont(new Font("Arial Black", Font.PLAIN, 20));
		contentPane_PlatosGuardados.add(lblTitulo);
		//***********************************************************************

		btnDrch.setVisible(flechaDch);
		btnIzq.setVisible(flechaIzq);
		repaint();
	}
	/**
	 * Método para mostrar paneles con la información de la base de datos
	 */

	public void mostrarPaneles() throws SQLException {
		String nombre_user = Usuario.user_actual.getNombre_usuario();
			zConexion.generarPanelPlatos(nombre_user, numIzq, numDch);

			for (Platos element : Platos.platos_usuario) {

				String nombre = element.getNombre_plato();
				double proteina = element.getProteina_total();
				double carbohidrato = element.getCarbohidrato_total();
				double grasas = element.getGrasas_total();
				double kcal = element.getKcal_total();

			mostrarCambio(nombre, proteina, carbohidrato, grasas, kcal);
			}
	}

	/**
	 * Método que dirige a la pestaña del menú principal de la aplicación
	 */

	public void cambioFrame1 () {
		final cPantalla_Principal cPantalla_Principal = new cPantalla_Principal ();
		cPantalla_Principal.setVisible(true);
		dispose();
	}

	/**
	 * Método que carga la interfaz gráfica de la ventana
	 */

	public void inicialice() {

		moverpanel = 0;
		moverpanel2 = 0;
		indice = 0;

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 503);
		contentPane_PlatosGuardados = new JPanel();
		contentPane_PlatosGuardados.setBackground(new Color(230, 230, 250));
		contentPane_PlatosGuardados.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane_PlatosGuardados);
		contentPane_PlatosGuardados.setLayout(null);

		contador = 1;				//TENEMOS QUE REINICIAR ESTA VARIABLE ESTATICA CADA VEZ QUE SE HABRA ESTE FRAME
		//PRUEBA BOTONES DE FAVORITOS
		try {
			String nombre = Personas.px_actual.getUsuario();
			num = zConexion.numPlato(nombre);

			while (num>6) {
				num = num -6;
				contador ++;		//TOTAL PAGINAS DE FAVORITOS QUE DEBE MOSTRAR
			}
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
	}


	/**
	 * Método que incluye la funcionalidad de todos los botones de la pantalla
	 */
	public ePlatos_guardados() {

		zConexion.conectar();
		inicialice();


		try {
			mostrarFlecha();
			mostrarPaneles();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

}
}