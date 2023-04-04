package Builder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class ePlatos_predeterminados extends JFrame {

	private JPanel contentPane;

	JLabel lblNewLabel, lblNewLabel_1;
	JPanel panel_plato3, panel_plato2, panel_plato1;
	
	aPantalla_Inicio pi;
	private JLabel lblArrozConPollo;
	private JLabel lblSesitosDeMono;
	private JLabel lblHigaditosDeBuey;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblAtras;
	
	public void mostrar () {
		setVisible(true);
	}
	
	public void inicialice() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 503);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 222, 179));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Platos predeterminados");
		lblNewLabel.setForeground(new Color(205, 133, 63));
		lblNewLabel.setBackground(new Color(205, 133, 63));
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblNewLabel.setBounds(133, 21, 379, 41);
		contentPane.add(lblNewLabel);
		
		panel_plato3 = new JPanel();
		panel_plato3.setBackground(new Color(238, 232, 170));
		panel_plato3.setBounds(420, 87, 197, 325);
		contentPane.add(panel_plato3);
		panel_plato3.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("USAR");
		btnNewButton_2.setForeground(new Color(0, 128, 128));
		btnNewButton_2.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnNewButton_2.setBackground(new Color(245, 245, 245));
		btnNewButton_2.setBounds(57, 281, 89, 25);
		panel_plato3.add(btnNewButton_2);
		
		lblHigaditosDeBuey = new JLabel("HIGADITOS DE BUEY");
		lblHigaditosDeBuey.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblHigaditosDeBuey.setBounds(20, 11, 177, 25);
		panel_plato3.add(lblHigaditosDeBuey);
		
		panel_plato2 = new JPanel();
		panel_plato2.setBackground(new Color(60, 179, 113));
		panel_plato2.setBounds(213, 87, 197, 325);
		contentPane.add(panel_plato2);
		panel_plato2.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("USAR");
		btnNewButton_1.setForeground(new Color(0, 128, 128));
		btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnNewButton_1.setBackground(new Color(245, 245, 245));
		btnNewButton_1.setBounds(50, 280, 89, 25);
		panel_plato2.add(btnNewButton_1);
		
		lblSesitosDeMono = new JLabel("SESITOS DE MONO");
		lblSesitosDeMono.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblSesitosDeMono.setBounds(26, 11, 161, 25);
		panel_plato2.add(lblSesitosDeMono);
		
		panel_plato1 = new JPanel();
		panel_plato1.setBackground(new Color(0, 128, 128));
		panel_plato1.setBounds(6, 87, 197, 325);
		contentPane.add(panel_plato1);
		panel_plato1.setLayout(null);
		
		JButton btnNewButton = new JButton("USAR");
		btnNewButton.setForeground(new Color(0, 128, 128));
		btnNewButton.setBackground(new Color(245, 245, 245));
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnNewButton.setBounds(53, 277, 89, 25);
		panel_plato1.add(btnNewButton);
		
		lblArrozConPollo = new JLabel("ARROZ CON POLLO");
		lblArrozConPollo.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblArrozConPollo.setBounds(26, 11, 161, 25);
		panel_plato1.add(lblArrozConPollo);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pi.pp.mostrar();
				setVisible(false);
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\diurno\\Desktop\\JMA\\ZZZZPROYECTO\\Imagenes proyecto\\atras.png"));
		lblNewLabel_1.setBounds(592, 11, 25, 25);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("1 / 4");
		lblNewLabel_2.setForeground(new Color(0, 128, 128));
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblNewLabel_2.setBounds(284, 423, 49, 32);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\migue\\OneDrive\\Documentos\\FP\\PROYECTO FINAL PROGRA-ENTORNOS-BASES\\IMAGENES\\PATRAS.png"));
		lblNewLabel_3.setBounds(184, 424, 72, 33);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\migue\\OneDrive\\Documentos\\FP\\PROYECTO FINAL PROGRA-ENTORNOS-BASES\\IMAGENES\\ALANTE.png"));
		lblNewLabel_4.setBounds(343, 425, 84, 32);
		contentPane.add(lblNewLabel_4);
		
		lblAtras = new JLabel("New label");
		lblAtras.setIcon(new ImageIcon("C:\\Users\\migue\\OneDrive\\Documentos\\FP\\PROYECTO FINAL PROGRA-ENTORNOS-BASES\\IMAGENES\\atras.png"));
		lblAtras.setBounds(560, 27, 33, 41);
		contentPane.add(lblAtras);
		
	}

	public ePlatos_predeterminados(aPantalla_Inicio pi) {
		
		this.pi = pi;
		inicialice();
		
		lblAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			   setVisible(false);
			   pi.pp.setVisible(true);
			}
		});
	}
}

