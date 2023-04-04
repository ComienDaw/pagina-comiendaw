package Builder;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.SwingConstants;

public class cPantalla_Principal extends JFrame {

	private JPanel contentPane;

	JPanel panel, panel_1;	
	JMenuBar menuBar;	
	JMenu MenuPlatos, MenuSeguimiento;	
	JMenuItem mnAlimentos, mnPlatosFav, mnPlatosPrede, mnPesarse;
	JLabel lblFotoUser, lblUsuario, lblComentarios, lblCerrar, lblXSalir, lblResumenDiario, lblObjetivo, lblComentario, lblProteina, lblCarbohidratos, lblGrasas, lblKcalTotales;	
	JProgressBar progressBarKcal, progressBarProteina, progressBarCarbohidrato, progressBarGrasas;
	
	aPantalla_Inicio pi;

	public void mostrar () {
		setVisible(true);
	}
		
	public void inicialice () {
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 503);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 222, 179));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		menuBar = new JMenuBar();
		menuBar.setForeground(new Color(245, 255, 250));
		menuBar.setBackground(new Color(0, 128, 128));
		menuBar.setBounds(0, 0, 282, 36);
		contentPane.add(menuBar);

		MenuPlatos = new JMenu("Platos  y alimentos");
		MenuPlatos.setForeground(new Color(245, 255, 250));
		MenuPlatos.setFont(new Font("Arial Black", Font.ITALIC, 15));
		MenuPlatos.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(MenuPlatos);
		
		MenuSeguimiento = new JMenu("Seguimiento");
		MenuSeguimiento.setForeground(new Color(245, 255, 250));
		MenuSeguimiento.setFont(new Font("Arial Black", Font.ITALIC, 15));
		MenuSeguimiento.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(MenuSeguimiento);
		
		panel.setVisible(false);
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		panel.setBounds(33, 346, 133, 95);
		contentPane.add(panel);
		panel.setLayout(null);

		lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(new Color(245, 255, 250));
		lblUsuario.setFont(new Font("Arial Black", Font.ITALIC, 17));
		lblUsuario.setBounds(10, 11, 81, 18);
		panel.add(lblUsuario);

		lblComentarios = new JLabel("Mensajes");
		lblComentarios.setForeground(new Color(245, 255, 250));
		lblComentarios.setFont(new Font("Arial Black", Font.ITALIC, 17));
		lblComentarios.setBounds(10, 40, 123, 18);
		panel.add(lblComentarios);

		lblCerrar = new JLabel("Salir");
		lblCerrar.setForeground(new Color(245, 255, 250));
		lblCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pi.mostrar();
				setVisible(false);
			}
		});
		lblCerrar.setFont(new Font("Arial Black", Font.ITALIC, 17));
		lblCerrar.setBounds(10, 69, 81, 18);
		panel.add(lblCerrar);
		
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(250, 250, 210));
		panel_1.setBounds(10, 47, 607, 372);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		progressBarKcal = new JProgressBar();
		progressBarKcal.setValue(73);
		progressBarKcal.setOrientation(SwingConstants.VERTICAL);
		progressBarKcal.setBounds(464, 46, 133, 318);
		panel_1.add(progressBarKcal);

		lblResumenDiario = new JLabel("Resumen diario");
		lblResumenDiario.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 20));
		lblResumenDiario.setBounds(10, 11, 205, 24);
		panel_1.add(lblResumenDiario);

		lblObjetivo = new JLabel("Tu objetivo de hoy:");
		lblObjetivo.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblObjetivo.setBounds(161, 53, 146, 24);
		panel_1.add(lblObjetivo);

		progressBarProteina = new JProgressBar();
		progressBarProteina.setMaximum(60);
		progressBarProteina.setValue(45);
		progressBarProteina.setBounds(181, 219, 161, 30);
		panel_1.add(progressBarProteina);

		progressBarCarbohidrato = new JProgressBar();
		progressBarCarbohidrato.setMaximum(30);
		progressBarCarbohidrato.setValue(25);
		progressBarCarbohidrato.setBounds(181, 260, 161, 30);
		panel_1.add(progressBarCarbohidrato);

		progressBarGrasas = new JProgressBar();
		progressBarGrasas.setMaximum(10);
		progressBarGrasas.setValue(3);
		progressBarGrasas.setBounds(181, 301, 161, 30);
		panel_1.add(progressBarGrasas);

		lblComentario = new JLabel("\"PONER EL OBJETIVO QUE SE PONIENDO KCAL A COMER, AGUA... \"");
		lblComentario.setForeground(new Color(128, 0, 128));
		lblComentario.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblComentario.setBounds(10, 88, 431, 76);
		panel_1.add(lblComentario);

		lblProteina = new JLabel("Proteinas");
		lblProteina.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblProteina.setBounds(38, 219, 133, 30);
		panel_1.add(lblProteina);

		lblCarbohidratos = new JLabel("Carbohidratos");
		lblCarbohidratos.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblCarbohidratos.setBounds(38, 260, 133, 30);
		panel_1.add(lblCarbohidratos);

		lblGrasas = new JLabel("Grasas");
		lblGrasas.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblGrasas.setBounds(38, 301, 133, 30);
		panel_1.add(lblGrasas);

		lblKcalTotales = new JLabel("KCal. totales");
		lblKcalTotales.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblKcalTotales.setBounds(485, 15, 112, 22);
		panel_1.add(lblKcalTotales);
		
	}
	
	public cPantalla_Principal(aPantalla_Inicio pi) {

		this.pi = pi;
		inicialice();

		//IMAGEN 'ALIMENTOS' PARA ACCEDER A DPRUEBAINGREDIENTES
		mnAlimentos = new JMenuItem("Alimentos");
		mnAlimentos.setForeground(new Color(245, 255, 250));
		mnAlimentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pi.pin.mostrar();
				setVisible(false);
			}
		});
		mnAlimentos.setIcon(new ImageIcon("C:\\Users\\migue\\OneDrive\\Documentos\\FP\\PROYECTO FINAL PROGRA-ENTORNOS-BASES\\IMAGENES\\alimentos1.png"));
		mnAlimentos.setFont(new Font("Arial Black", Font.ITALIC, 15));
		mnAlimentos.setBackground(new Color(0, 128, 128));
		MenuPlatos.add(mnAlimentos);

		//IMAGEN 'PLATOS GUARDADOS' PARA ACCEDER A EPLATOS_GUARDADOS
		mnPlatosFav = new JMenuItem("Platos favoritos");
		mnPlatosFav.setForeground(new Color(245, 255, 250));
		mnPlatosFav.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pi.pg.mostrar();
				setVisible(false);
			}
		});
		mnPlatosFav.setIcon(new ImageIcon("C:\\Users\\migue\\OneDrive\\Documentos\\FP\\PROYECTO FINAL PROGRA-ENTORNOS-BASES\\IMAGENES\\plato_guardado1.png"));
		mnPlatosFav.setFont(new Font("Arial Black", Font.ITALIC, 15));
		mnPlatosFav.setBackground(new Color(0, 128, 128));
		MenuPlatos.add(mnPlatosFav);
		
		//IMAGEN 'PLATOS PREDETERMINADOS' PARA ACCEDER A EPLATOS_PREDETERMINADOS
		mnPlatosPrede = new JMenuItem("Platos predeterminados");
		mnPlatosPrede.setForeground(new Color(245, 255, 250));
		mnPlatosPrede.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pi.pp2.mostrar();
				setVisible(false);
			}
		});
		mnPlatosPrede.setIcon(new ImageIcon("C:\\Users\\migue\\OneDrive\\Documentos\\FP\\PROYECTO FINAL PROGRA-ENTORNOS-BASES\\IMAGENES\\platos_exportar1.png"));
		mnPlatosPrede.setFont(new Font("Arial Black", Font.ITALIC, 15));
		mnPlatosPrede.setBackground(new Color(0, 128, 128));
		MenuPlatos.add(mnPlatosPrede);

		//IMAGEN '¡DIA DE PESARSE!' PARA ACCEDER A EDIAPESO
		mnPesarse = new JMenuItem("¡Dia de pesarse!");
		mnPesarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pi.dp2.mostrar();
				setVisible(false);
			}
		});
		mnPesarse.setForeground(new Color(245, 255, 250));
		mnPesarse.setIcon(new ImageIcon("C:\\Users\\migue\\OneDrive\\Documentos\\FP\\PROYECTO FINAL PROGRA-ENTORNOS-BASES\\IMAGENES\\Seg_diario1.png"));
		mnPesarse.setFont(new Font("Arial Black", Font.ITALIC, 15));
		mnPesarse.setBackground(new Color(0, 128, 128));
		MenuSeguimiento.add(mnPesarse);

		//IMAGEN DEL EMOTICONO DE USUARIO QUE TE ABRE UN SUBMENU
		lblFotoUser = new JLabel("New label");
		lblFotoUser.setIcon(new ImageIcon("C:\\Users\\migue\\OneDrive\\Documentos\\FP\\PROYECTO FINAL PROGRA-ENTORNOS-BASES\\IMAGENES\\Imagen usuario.png"));
		lblFotoUser.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {				
				panel.setVisible(true);	
			}
		});
		lblFotoUser.setBounds(0, 423, 46, 36);
		contentPane.add(lblFotoUser);

		//EN LE MENU DEL USUARIO, X SUPERIOR QUE HAY PARA CERRAR EL MENU
		lblXSalir = new JLabel("New label");
		lblXSalir.setIcon(new ImageIcon("C:\\Users\\migue\\OneDrive\\Documentos\\FP\\PROYECTO FINAL PROGRA-ENTORNOS-BASES\\IMAGENES\\salir1.png"));
		lblXSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {				
				panel.setVisible(false);				
			}
		});
		lblXSalir.setBounds(101, 11, 25, 25);
		panel.add(lblXSalir);
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}

