package Builder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class ePlatos_guardados extends JFrame {

	public JPanel contentPane_PlatosGuardados;
	private static int moverpanel = 0;
	private static int moverpanel2 = 0;
	public static int indice = 0;
	public static JPanel panel = new JPanel();
	public JPanel panel1;

	JLabel lblTituloPlato, lblTitulo, lblAtras;
	
	aPantalla_Inicio pi;

	//ÀRRAYLIST' QUE ALMACENA LOS 'JPANEL' CREADO CON CADA PLATO AÑADIDO A FAVORITO
	ArrayList <JPanel> Alimentosplatos = new ArrayList <JPanel>();

	//METODO UTILIZADO EN 'PRUEBAINGREDIENTES' EL CUAL CREA UN 'JPANEL' NUEVO EN EL CUAL ALMACENAREMOS LOS PLATOS CREADO
	//PARA USAR EL METODO EN OTRO 'JFRAME' DEBO INSTANCIAR ESTA CLASE A LA OTRA CLASE PARA USAR EL METODO
	public void mostrarCambio () {

		panel1 = new JPanel();
		panel1.setBounds((10 + moverpanel), (49 + moverpanel2), 197, 184);
		moverpanel = moverpanel + 207;
		contentPane_PlatosGuardados.add(panel1);
		Alimentosplatos.add(panel1);
		panel1.setBackground(new Color(250, 250, 210));
		contentPane_PlatosGuardados.repaint();	

		lblTituloPlato = new JLabel("TITULO");
		lblTituloPlato.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		lblTituloPlato.setBounds(21, 163, 100, 38);
		panel1.add(lblTituloPlato);
		lblTituloPlato.setVisible(true);

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

	}

	public void mostrar () {
		setVisible(true);
	}
		
	public void inicialice() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 503);
		contentPane_PlatosGuardados = new JPanel();
		contentPane_PlatosGuardados.setBackground(new Color(245, 222, 179));
		contentPane_PlatosGuardados.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane_PlatosGuardados);
		contentPane_PlatosGuardados.setLayout(null);
//		contentPane_PlatosGuardados.setLayout(null);

		lblTitulo = new JLabel("Platos favoritos");
		lblTitulo.setForeground(new Color(0, 128, 128));
		lblTitulo.setBounds(189, 11, 237, 36);
		lblTitulo.setFont(new Font("Arial Black", Font.PLAIN, 25));
		contentPane_PlatosGuardados.add(lblTitulo);
		
	}


	public ePlatos_guardados(aPantalla_Inicio pi) {

		this.pi = pi;
		inicialice();

		//ICONO PARA VOLVER ATRAS A CPANTALLA_PRINCIPAL
		lblAtras = new JLabel("");
		lblAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pi.pp.mostrar();
				setVisible(false);
			}
		});
		lblAtras.setIcon(new ImageIcon("C:\\Users\\migue\\OneDrive\\Documentos\\FP\\PROYECTO FINAL PROGRA-ENTORNOS-BASES\\IMAGENES\\atras.png"));
		lblAtras.setBounds(579, 11, 40, 36);
		contentPane_PlatosGuardados.add(lblAtras);

	}
}

