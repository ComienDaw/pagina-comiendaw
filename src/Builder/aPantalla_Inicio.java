package Builder;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class aPantalla_Inicio extends JFrame {
	
	private JPanel contentPane;
	
	bPantalla_Inicio_Sesion pis;
	bPantalla_Registro pr;	
	bDatos_Personales dp;
	cPantalla_Principal pp;
	dPruebaingredientes pin;
	ePlatos_guardados pg;
	ePlatos_predeterminados pp2;
	eDiaPeso dp2;

	JButton btnInicioSesion;
	JButton btnRegistro;
	JLabel lblTitulo;
	JLabel lblFoto;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					aPantalla_Inicio frame = new aPantalla_Inicio();
					frame.setResizable(false);
					frame.setVisible(true);


				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void mostrar() {
		setVisible(true);
	}
	
	public void inicioFrame() throws SQLException {
		pis = new bPantalla_Inicio_Sesion(this);
			pis.setVisible(false);
		pr = new bPantalla_Registro(this);
			pr.setVisible(false);
		dp = new bDatos_Personales(this);
			dp.setVisible(false);
		pp = new cPantalla_Principal(this);
			pp.setVisible(false);
		pin = new dPruebaingredientes(this);
			pin.setVisible(false);
		pg = new ePlatos_guardados(this);
			pg.setVisible(false);
		pp2 = new ePlatos_predeterminados(this);
			pp2.setVisible(false);
		dp2 = new eDiaPeso(this);
			dp2.setVisible(false);
	}
	
	public void inicialice () {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 503);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnInicioSesion = new JButton("INICIO SESIÓN");
		btnInicioSesion.setBackground(new Color(245, 255, 250));
		btnInicioSesion.setForeground(new Color(0, 128, 128));
		btnInicioSesion.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnInicioSesion.setBounds(46, 88, 141, 35);
		contentPane.add(btnInicioSesion);
		
		btnRegistro = new JButton("REGISTRO");
		btnRegistro.setBackground(new Color(245, 255, 250));
		btnRegistro.setForeground(new Color(0, 128, 128));
		btnRegistro.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnRegistro.setBounds(46, 134, 141, 35);
		contentPane.add(btnRegistro);
		
		
		lblTitulo = new JLabel("BIENVENID@");
		lblTitulo.setBounds(10, 11, 253, 54);
		lblTitulo.setForeground(new Color(245, 255, 250));
		lblTitulo.setFont(new Font("Arial Black", Font.PLAIN, 35));
		contentPane.add(lblTitulo);
		
		lblFoto = new JLabel("");
		lblFoto.setBackground(new Color(245, 222, 179));
		lblFoto.setVerticalAlignment(SwingConstants.BOTTOM);
		lblFoto.setIcon(new ImageIcon("C:\\Users\\migue\\OneDrive\\Documentos\\FP\\PROYECTO FINAL PROGRA-ENTORNOS-BASES\\IMAGENES\\fotoInicioSesion.png\\"));
		lblFoto.setBounds(0, -21, 643, 503);
		contentPane.add(lblFoto);
		contentPane.setLayout(null);
	}

	public aPantalla_Inicio() {

		inicialice();
		zConexion.conectar();
		try {
			inicioFrame();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
		//BOTON DE INICIO SESION (CON USUARIO YA CREADO)
		btnInicioSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pis.mostrar();
				setVisible(false);
			}
		});
	
		//BOTON PARA HACER NUEVO REGISTRO
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pr.mostrar();
				setVisible(false);
			}
		});



	}
}
