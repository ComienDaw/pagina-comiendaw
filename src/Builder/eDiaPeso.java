package Builder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class eDiaPeso extends JFrame {

	private JPanel contentPane;
	private JTextField textfieldPesoPerdido;
	private JTextField textFieldPeso;

	aPantalla_Inicio pi;
	
	public void mostrar () {
		setVisible(true);
	}
	
	public eDiaPeso(aPantalla_Inicio pi) {
		
			this.pi = pi;
		
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 643, 503);
				contentPane = new JPanel();
				contentPane.setBackground(new Color(245, 222, 179));
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

				setContentPane(contentPane);
				contentPane.setLayout(null);
//				contentPane.setLayout(null);
		
				JLabel lblHola = new JLabel("Hola,");
				lblHola.setFont(new Font("Arial Black", Font.BOLD, 20));
				lblHola.setBounds(45, 17, 60, 29);
				contentPane.add(lblHola);
		
				JLabel lbNombreUser = new JLabel("......\"USUARIO\"...........");
				lbNombreUser.setVerticalAlignment(SwingConstants.TOP);
				lbNombreUser.setFont(new Font("Tahoma", Font.ITALIC, 20));
				lbNombreUser.setBounds(110, 19, 200, 25);
				contentPane.add(lbNombreUser);
		
				JLabel lblPesoIni = new JLabel("Peso inicial:");
				lblPesoIni.setForeground(new Color(205, 133, 63));
				lblPesoIni.setFont(new Font("Arial Black", Font.PLAIN, 30));
				lblPesoIni.setBounds(248, 55, 200, 43);
				contentPane.add(lblPesoIni);
		
				JLabel lblKG1 = new JLabel("Kg.");
				lblKG1.setFont(new Font("Arial Black", Font.PLAIN, 15));
				lblKG1.setBounds(420, 109, 28, 22);
				contentPane.add(lblKG1);
		
				JLabel lblPesoPerdido = new JLabel("Peso perdido:");
				lblPesoPerdido.setForeground(new Color(0, 128, 128));
				lblPesoPerdido.setVisible(false);
				lblPesoPerdido.setFont(new Font("Arial Black", Font.PLAIN, 15));
				lblPesoPerdido.setBounds(248, 382, 112, 22);
				contentPane.add(lblPesoPerdido);
		
				textfieldPesoPerdido = new JTextField();
				textfieldPesoPerdido.setVisible(false);
				textfieldPesoPerdido.setColumns(10);
				textfieldPesoPerdido.setBounds(248, 415, 151, 20);
				contentPane.add(textfieldPesoPerdido);
		
				JLabel lblMostrarPeso = new JLabel("\"peso actual\"");
				lblMostrarPeso.setFont(new Font("Segoe Print", Font.PLAIN, 13));
				lblMostrarPeso.setBounds(276, 109, 84, 24);
				contentPane.add(lblMostrarPeso);
		
				JLabel lblPeso = new JLabel("Tu peso actual:");
				lblPeso.setForeground(new Color(0, 128, 128));
				lblPeso.setFont(new Font("Arial Black", Font.PLAIN, 15));
				lblPeso.setBounds(248, 310, 151, 22);
				contentPane.add(lblPeso);
		
				textFieldPeso = new JTextField();
				textFieldPeso.setBounds(248, 345, 151, 20);
				contentPane.add(textFieldPeso);
				textFieldPeso.setColumns(10);
		
				JLabel lblKG4 = new JLabel("Kg.");
				lblKG4.setForeground(new Color(205, 133, 63));
				lblKG4.setFont(new Font("Arial Black", Font.PLAIN, 15));
				lblKG4.setBounds(420, 412, 28, 22);
				contentPane.add(lblKG4);
		
				JLabel lblObjetivo = new JLabel("Objetivo:");
				lblObjetivo.setForeground(new Color(0, 128, 128));
				lblObjetivo.setFont(new Font("Arial Black", Font.PLAIN, 25));
				lblObjetivo.setBounds(45, 128, 159, 36);
				contentPane.add(lblObjetivo);
		
				JLabel KcalMostrarKcal = new JLabel("\"peso actual\"");
				KcalMostrarKcal.setFont(new Font("Segoe Print", Font.PLAIN, 13));
				KcalMostrarKcal.setBounds(276, 229, 84, 24);
				contentPane.add(KcalMostrarKcal);
		
				JLabel lblKG2 = new JLabel("Kg.");
				lblKG2.setFont(new Font("Arial Black", Font.PLAIN, 15));
				lblKG2.setBounds(420, 229, 28, 22);
				contentPane.add(lblKG2);
		
				JLabel lblKcalMant = new JLabel("KCal mantenimiento:");
				lblKcalMant.setForeground(new Color(205, 133, 63));
				lblKcalMant.setFont(new Font("Arial Black", Font.PLAIN, 25));
				lblKcalMant.setBounds(248, 182, 304, 36);
				contentPane.add(lblKcalMant);
		
				JLabel lblMostrarPesoObj = new JLabel("\"peso actual\"");
				lblMostrarPesoObj.setFont(new Font("Segoe Print", Font.PLAIN, 13));
				lblMostrarPesoObj.setBounds(92, 175, 84, 24);
				contentPane.add(lblMostrarPesoObj);
		
				JLabel lblKG3 = new JLabel("Kg.");
				lblKG3.setForeground(new Color(205, 133, 63));
				lblKG3.setFont(new Font("Arial Black", Font.PLAIN, 15));
				lblKG3.setBounds(420, 342, 28, 22);
				contentPane.add(lblKG3);
		
				JLabel lblMostrarPorcentaje = new JLabel("\"%\"");
				lblMostrarPorcentaje.setFont(new Font("Tahoma", Font.PLAIN, 40));
				lblMostrarPorcentaje.setBounds(82, 359, 71, 49);
				contentPane.add(lblMostrarPorcentaje);
		
				JButton btnConfirmar = new JButton("CONFIRMAR");
				btnConfirmar.setBackground(new Color(0, 128, 128));
				btnConfirmar.setFont(new Font("Arial Black", Font.BOLD, 11));
				btnConfirmar.setForeground(new Color(245, 255, 250));
				btnConfirmar.setBounds(499, 428, 118, 25);
				contentPane.add(btnConfirmar);
			
				JLabel lblCorchete = new JLabel("");
				lblCorchete.setIcon(new ImageIcon("C:\\Users\\migue\\OneDrive\\Documentos\\FP\\PROYECTO FINAL PROGRA-ENTORNOS-BASES\\IMAGENES\\corchete.png"));
				lblCorchete.setBounds(205, 76, 46, 143);
				contentPane.add(lblCorchete);
		
				JLabel lblAtras = new JLabel("");
				lblAtras.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						pi.pp.mostrar();
						setVisible(false);
					}
				});
				lblAtras.setIcon(new ImageIcon("C:\\Users\\migue\\OneDrive\\Documentos\\FP\\PROYECTO FINAL PROGRA-ENTORNOS-BASES\\IMAGENES\\atras.png"));
				lblAtras.setBounds(588, 17, 29, 32);
				contentPane.add(lblAtras);
		
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

