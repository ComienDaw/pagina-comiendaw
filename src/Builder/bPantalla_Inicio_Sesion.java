package Builder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class bPantalla_Inicio_Sesion extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JPasswordField passwordField;

	JLabel lblTitulo;
	JLabel lblUsuario;
	JButton btnEntrar;
	JLabel lblContraseña;
	
	aPantalla_Inicio pi;
	private JLabel lblNewLabel;
	private JLabel lblAtras;
	
	public void mostrar () {
		setVisible(true);
	}

	public void inicialice (){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 503);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 222, 179));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//BOTON CONFIRMAR QUE EXISTE USUARIO
		btnEntrar = new JButton("ENTRAR");
		btnEntrar.setBackground(new Color(0, 128, 128));
		btnEntrar.setForeground(new Color(245, 255, 250));
		btnEntrar.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnEntrar.setBounds(264, 350, 113, 40);
		contentPane.add(btnEntrar);
		
		lblTitulo = new JLabel("INICIO DE SESIÓN");
		lblTitulo.setForeground(new Color(0, 128, 128));
		lblTitulo.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblTitulo.setBounds(188, 103, 271, 48);
		contentPane.add(lblTitulo);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(227, 193, 191, 40);
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(227, 261, 191, 40);
		contentPane.add(passwordField);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(new Color(0, 128, 128));
		lblUsuario.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblUsuario.setBounds(114, 197, 69, 29);
		contentPane.add(lblUsuario);
		
		lblContraseña = new JLabel("Contraseña");
		lblContraseña.setForeground(new Color(233, 150, 122));
		lblContraseña.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblContraseña.setBounds(104, 266, 99, 27);
		contentPane.add(lblContraseña);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\migue\\OneDrive\\Documentos\\FP\\PROYECTO FINAL PROGRA-ENTORNOS-BASES\\IMAGENES\\logo_comiendawsintexto80x76.png"));
		lblNewLabel.setBounds(289, 24, 88, 76);
		contentPane.add(lblNewLabel);
		
		lblAtras = new JLabel("New label");
		lblAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pi.mostrar();
				setVisible(false);
			}
		});
		lblAtras.setIcon(new ImageIcon("C:\\Users\\migue\\OneDrive\\Documentos\\FP\\PROYECTO FINAL PROGRA-ENTORNOS-BASES\\IMAGENES\\atras.png"));
		lblAtras.setBounds(557, 24, 37, 40);
		contentPane.add(lblAtras);
	}
		
		public bPantalla_Inicio_Sesion(aPantalla_Inicio pi) throws SQLException {
			
			this.pi = pi;
			inicialice();
			
			btnEntrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					String usuario = textFieldUsuario.getText();
					String contraseña = passwordField.getText();
					boolean resultado = false;
					try {	
						resultado=zConexion.inicioSesion(usuario, contraseña);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if(resultado == true) {
					pi.pp.mostrar();
					setVisible(false);
					}
				}
			});
			
			
		}
	
		
		
	}

